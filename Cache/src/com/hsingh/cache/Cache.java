package com.hsingh.cache;

/**
 * This interface defines common methods for a cache implementation.
 * 
 * @author Himanshu_Singh2
 *
 * @param <K>
 *            Data Type of the key for cache
 * @param <V>
 *            Data Type of the value for cache
 */
public interface Cache<K, V> {
	/**
	 * Gets the key from the cache.
	 * 
	 * @param key
	 *            the key to search in the cache
	 * @return value associated with key
	 */
	V get(K key);

	/**
	 * Puts the key and associated value in the cache
	 * 
	 * @param key
	 * @param value
	 */
	void put(K key, V value);

	/**
	 * Gets the size of the cache.
	 * 
	 * @return the size of the cache.
	 */
	int size();

	/**
	 * Gets the maximum capacity of the cache.
	 * 
	 * @return the maximum capacity of the cache.
	 */
	int capacity();
}
