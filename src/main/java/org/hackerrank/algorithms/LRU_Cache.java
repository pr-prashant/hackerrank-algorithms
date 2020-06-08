package org.hackerrank.algorithms;

import java.util.LinkedList;

class LRU_Cache_ENTRY {
    private String key;

    private String value;

    public LRU_Cache_ENTRY(String key, String value) {
        this.key = key;
        this.value = value;
    }


}

public class LRU_Cache {
    private LinkedList<LRU_Cache_ENTRY> cache = new LinkedList<>();

    int capacity=4;
    private void putInCache(String key,String value){
        if(cache.size() == 4){
            cache.removeFirst();
        }
        cache.add(new LRU_Cache_ENTRY(key,value));
    }

    private void getFromCache(String key){
        for (LRU_Cache_ENTRY cache_entry: cache){
//            if(cache_entry.)
        }
    }
}
