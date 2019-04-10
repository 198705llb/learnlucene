package com.warmme.learnlucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.CollectionUtil;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Indexer {

    private IndexWriter writer;

    public Indexer(String indexDir) throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(indexDir));
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        writer = new IndexWriter(directory,indexWriterConfig);
    }

    public void close() throws IOException {
        if (writer != null){
            writer.close();
        }
    }

    public void index(List<Map<String,String>> filed2valueList) throws IOException {
        if (filed2valueList==null || filed2valueList.size()<=0){
            return;
        }
        filed2valueList.forEach(file2value -> {
            final Document document = new Document();
            file2value.forEach((key,value) -> {
                document.add(new TextField(key,value, Field.Store.YES));
            });
            try {
                writer.addDocument(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        close();

    }
}
