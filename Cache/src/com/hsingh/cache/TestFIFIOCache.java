package com.hsingh.cache;

public class TestFIFIOCache {

    public static void main(String[] args) {
        FIFOCache2<Integer, String> fifoCache = new FIFOCache2<Integer, String>(3);
        
        fifoCache.put(1, "One");
        fifoCache.put(2, "Two");

        System.out.println(fifoCache);
        System.out.println(fifoCache.get(3));
        System.out.println(fifoCache.get(2));
        
        fifoCache.put(3, "Three");
        System.out.println(fifoCache);
        fifoCache.put(4, "Four");
        fifoCache.put(5, "Five");
        fifoCache.put(6, "Six");
        System.out.println(fifoCache);
    }
}
