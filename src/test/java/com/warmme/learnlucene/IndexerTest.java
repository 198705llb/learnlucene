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
        HashMap<String, String> map = new HashMap<>();
        map.put("name","xiaoxiao");
        map.put("conten","chenggongle");
        map.put("pass","12345");
        indexer.index(Arrays.asList(map));
    }
}