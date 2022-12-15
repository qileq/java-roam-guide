package com.qileq.io;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourcesUtil {

	public static void main(String[] args) throws Exception {
		final String conf = "db.properties";
		ResourcesUtil resourcesUtil = new ResourcesUtil();
		resourcesUtil.getResourceByClass("/" + conf);
		resourcesUtil.getResourceByClassLoader(conf);
		resourcesUtil.getResourceByClass("/com/qileq/io/ResourcesUtil.class");
		resourcesUtil.getResourceByClassLoader("com/qileq/io/ResourcesUtil.class");
//		IOUtils.printInputStream(resourcesUtil.getResourceFileAsStream(conf));
//		IOUtils.printFile(resourcesUtil.getResourceFile(conf));
	}

	private void getResourceByClass(String name) {
		URL resource1 = getClass().getResource(name);
		URL resource2 = ResourcesUtil.class.getResource(name);
		InputStream inputStream = getClass().getResourceAsStream(name);
		log.info("[getResourceByClass] {}, {}, {}", resource1, resource2, inputStream);
	}

	private void getResourceByClassLoader(String name) {
		URL resource1 = getClass().getClassLoader().getResource(name);
		URL resource2 = ResourcesUtil.class.getClassLoader().getResource(name);
		URL resource3 =  ClassLoader.getSystemResource(name);
		InputStream inputStream = ClassLoader.getSystemResourceAsStream(name);
		log.info("[getResourceByClassLoader] {}, {}, {}, {}", resource1, resource2, resource3, inputStream);
	}

	private InputStream getResourceFileAsStream(String filename) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + filename);
		} else {
			return inputStream;
		}
	}

	private File getResourceFile(String filename) throws URISyntaxException {
		URL resource = getClass().getClassLoader().getResource(filename);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + filename);
		} else {
			return new File(resource.toURI());
		}
	}
}
