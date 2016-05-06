package com.hsingh.cache;

public class TestLRUCache {

	public static void main(String[] args) {
		LRUCache2<Integer, String> lruCache = new LRUCache2<Integer, String>(3);

		lruCache.put(1, "One");
		System.out.println(lruCache);
		lruCache.put(2, "Two");
		System.out.println(lruCache);
		System.out.println(lruCache.get(3));
		System.out.println(lruCache);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache);
		lruCache.put(3, "Three");
		System.out.println(lruCache);

		lruCache.put(4, "Four");
		System.out.println(lruCache);
		lruCache.put(5, "Five");
		System.out.println(lruCache);
		System.out.println(lruCache.get(3));
		System.out.println(lruCache);
		lruCache.put(6, "Six");
		System.out.println(lruCache);
	}
}
