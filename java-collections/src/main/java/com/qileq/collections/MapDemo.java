package com.qileq.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapDemo {

	public void iteratorByEntrySet() {
		Map<String, String> map = new HashMap<>();
		map.put("Java", "https://qileq.com");
		map.put("Guide", "https://qileq.com");

		// 1. iterate over Map.entrySet()
		log.info("== iterate through a Map using the entrySet by for loop ==");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			log.info("key = {}, value = {}", entry.getKey(), entry.getValue());
		}

		log.info("== iterate through a Map using the keySet by for loop ==");
		for (String key : map.keySet()) {
			log.info("key = {}, value = {}", key, map.get(key));
		}

		log.info("== iterate through a Map using the values by for loop ==");
		for (String value : map.values()) {
			log.info("value = {}", value);
		}

		log.info("== iterate through a Map using the entrySet by Iterator ==");
		Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, String> entry = entryIterator.next();
			log.info("key = {}, value = {}", entry.getKey(), entry.getValue());
		}

		log.info("== iterate through a Map using the keySet by Iterator ==");
		Iterator<String> keyIterator = map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			log.info("key = {}, value = {}", key, map.get(key));
		}

		// forEach
		log.info("== iterate through a Map by forEach ==");
		map.forEach((k, v) -> log.info("key = {}, value = {}", k, v));

		// Stream
		log.info("== iterate through a Map by stream ==");
		map.entrySet()
			.stream()
			// some other Stream transform
			.forEach(entry -> log.info("key = {}, value = {}", entry.getKey(), entry.getValue()));

		log.info("== iterate through a Map by stream ==");
		map.keySet()
			.stream()
			// some other Stream transform
			.forEach(key -> log.info("key = {}, value = {}", key, map.get(key)));
	}

	public static void main(String[] args) {
		MapDemo mapDemo = new MapDemo();
		mapDemo.iteratorByEntrySet();
	}
}
