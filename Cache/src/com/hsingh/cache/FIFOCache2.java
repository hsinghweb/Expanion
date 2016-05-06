package com.hsingh.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache2<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = -459802815015950849L;
	private int cacheSize;

	public FIFOCache2(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > cacheSize;
	}
}