package com.warmme.learnlucene;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class IndexerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void index() throws IOException {
        Indexer indexer = new Indexer("C://develop\\lucene\\testIndex");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name","xiaoxiao");
            map.put("conten","chenggongle");
            map.put("pass","12345");
            indexer.index(Arrays.asList(map));
            if (i%100 == 0){
            System.err.println("i="+i+", time="+(System.currentTimeMillis()-start)/1000);
        }}
        System.err.println("time="+(System.currentTimeMillis()-start)/1000);
        indexer.close();
    }
}