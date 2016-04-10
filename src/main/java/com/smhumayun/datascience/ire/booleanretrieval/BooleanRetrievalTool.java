package com.smhumayun.datascience.ire.booleanretrieval;

import com.smhumayun.datascience.ire.booleanretrieval.config.BooleanRetrievalToolConfig;
import com.smhumayun.datascience.ire.booleanretrieval.config.InputDocumentConfig;
import com.smhumayun.datascience.ire.booleanretrieval.query.parser.QueryParser;
import com.smhumayun.datascience.ire.booleanretrieval.model.Document;
import com.smhumayun.datascience.ire.booleanretrieval.model.InvertedIndex;
import com.thoughtworks.xstream.XStream;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by Humayun on 4/3/2016.
 */
public class BooleanRetrievalTool {

    private static File configFile;
    private static XStream xStream = new XStream();

    static {
        try {
            configFile = new File(BooleanRetrievalTool.class.getResource("/BooleanRetrievalToolConfig.xml").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        BooleanRetrievalToolConfig booleanRetrievalToolConfig = (BooleanRetrievalToolConfig) xStream.fromXML(FileUtils.readFileToString(configFile));
        if(booleanRetrievalToolConfig == null) {
            System.out.println("No config found in file " + configFile);
        }
        if(booleanRetrievalToolConfig.getInputDocuments() == null || booleanRetrievalToolConfig.getInputDocuments().size() == 0) {
            System.out.println("Document(s) path missing in file " + configFile);
        }
        File inputFile;
        List<Document> documents = new ArrayList<Document>();
        List<HashSet<String>> dictionaryList = new ArrayList<HashSet<String>>();
        Document document;
        for (InputDocumentConfig inputDocumentConfig : booleanRetrievalToolConfig.getInputDocuments()) {
            inputFile = new File(inputDocumentConfig.getInputDocumentPath());
            if(inputFile == null || !inputFile.exists()) {
                System.out.println("Document does not exists - " + inputDocumentConfig + " : " + inputFile);
            }
            document = new Document();
            document.setName(inputFile.getName());
            document.setIndex(inputDocumentConfig.getInputDocumentIndex());
            document.setUri(inputFile.toURI());
            document.setContent(FileUtils.readFileToString(inputFile));
            preprocess(document);
            documents.add(document);
            dictionaryList.add(createDictionary(document));
        }
        InvertedIndex invertedIndex = new InvertedIndex();
        HashSet<String> dictionary;
        List<Integer> postings;
        for (int i = 0; i < documents.size(); i++) {
            document =  documents.get(i);
            dictionary = dictionaryList.get(i);
            for (String term : dictionary) {
                postings = invertedIndex.get(term);
                if(postings == null) {
                    postings = new ArrayList<Integer>();
                    invertedIndex.put(term, postings);
                }
                postings.add(document.getIndex());
            }
        }
        System.out.println("INVERTED INDEX:\n" + invertedIndex);

        QueryParser queryParser = new QueryParser();
        queryParser.parse(booleanRetrievalToolConfig.getSearchQuery());
        List<Integer> matchedDocumentIndices = new ArrayList<Integer>();
        System.out.println("DOCUMENT POSTINGS:");
        for(int i = 0; i < dictionaryList.size(); i++) {
            System.out.println(String.format("%1$-6d", documents.get(i).getIndex()) + " = " + dictionaryList.get(i));
            if(queryParser.match(dictionaryList.get(i))) {
                matchedDocumentIndices.add(documents.get(i).getIndex());
            }
        }

        System.out.println("\n*******************************************************");
        System.out.println("Search Query: " + booleanRetrievalToolConfig.getSearchQuery());
        System.out.println("Matched Documents: " + matchedDocumentIndices);
    }

    public static void preprocess (Document document) {
        document.setContent(document.getContent()
                //remove all punctuations
                .replaceAll("\\p{P}", "")
                        //lower case all characters
                .toLowerCase());
    }

    public static HashSet<String> createDictionary (Document document) {
        HashSet<String> dictionary = new LinkedHashSet<String>();
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String inputString = document.getContent();
        Span[] spanArray = simpleTokenizer.tokenizePos(inputString);
        String token;
        for (Span span : spanArray) {
            token = inputString.substring(span.getStart(), span.getEnd());
            dictionary.add(token);
        }
        //System.out.println(dictionary);
        return dictionary;
    }

    public static void populateConfig () throws URISyntaxException, IOException {
        BooleanRetrievalToolConfig booleanRetrievalToolConfig = new BooleanRetrievalToolConfig();
        booleanRetrievalToolConfig.setSearchQuery("ENTER YOUR SEARCH QUERY HERE");
        List<InputDocumentConfig> inputDocumentConfigs = new ArrayList<InputDocumentConfig>();
        inputDocumentConfigs.add(new InputDocumentConfig("DOCUMENT 1 PATH", 1));
        inputDocumentConfigs.add(new InputDocumentConfig("DOCUMENT 2 PATH", 2));
        booleanRetrievalToolConfig.setInputDocuments(inputDocumentConfigs);
        String configXml = xStream.toXML(booleanRetrievalToolConfig);
        System.out.println("configXml = " + configXml);
        FileUtils.writeStringToFile(configFile, configXml);
    }

}
