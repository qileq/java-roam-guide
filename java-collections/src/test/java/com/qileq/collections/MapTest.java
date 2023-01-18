package com.qileq.collections;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MapTest {

	@Test
	public void testComputeIfAbsent() {
		Map<String, Integer> strLenMap = new HashMap<>();
		strLenMap.put("foo", 3);
		// 1. Key is exist
		assertEquals(strLenMap.computeIfAbsent("foo", String::length), 3);

		// 2. Key is not exist and compute function return non-null
		assertEquals(strLenMap.computeIfAbsent("bar", String::length), 3);
		assertEquals(strLenMap.get("bar"), 3);

		// 3. Key is not exist but compute function return null
		assertNull(strLenMap.computeIfAbsent("qileq", k -> null));
		assertNull(strLenMap.get("qileq"));
	}

	@Test
	public void testPutIfAbsent() {
		Map<String, Integer> strLenMap = new HashMap<>();
		strLenMap.put("foo", 3);
		// 1. Key is exist
		assertEquals(strLenMap.putIfAbsent("foo", 3), 3);

		// 2. Key is not exist and put "bar" -> 3 into map, return null
		assertNull(strLenMap.putIfAbsent("bar", 3));
		assertEquals(strLenMap.get("bar"), 3);

		// 3. Key is not exist and put "bar" -> null into map, return null
		assertNull(strLenMap.putIfAbsent("qileq", null));
		assertNull(strLenMap.get("qileq"));

		Map<String, Boolean> testMap = new HashMap<>();
	}
}
