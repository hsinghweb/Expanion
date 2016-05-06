package com.hsingh.cache;

public class TestLFUCache {

	public static void main(String[] args) {
		LFUCache2<Integer, String> lfu = new LFUCache2<Integer, String>(4);

		lfu.put(1, "a");
		lfu.put(2, "b");
		lfu.put(3, "c");
		lfu.put(4, "d");

		System.out.println(lfu);

		lfu.get(3);
		lfu.get(4);
		System.out.println(lfu);
		lfu.get(3);

		
		lfu.get(3);
		lfu.get(3);
		lfu.get(4);
		lfu.get(4);
		
		lfu.get(2);
		
		lfu.get(1);
		lfu.get(1);
		lfu.get(2);
		System.out.println(lfu);

		lfu.put(5, "e");
		System.out.println(lfu);

	}
}
