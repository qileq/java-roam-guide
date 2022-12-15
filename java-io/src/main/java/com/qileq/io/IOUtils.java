package com.qileq.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOUtils {

	public static void printInputStream(InputStream is) {
		log.info("=== InputStream content ===");
		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			 BufferedReader reader = new BufferedReader(streamReader)) {
			String line;
			while ((line = reader.readLine()) != null) {
				log.info(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printFile(File file) {
		log.info("=== File content === ");
		try {
			List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			lines.forEach(log::info);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public final void logMemory() {
		log.info("Max Memory: {} Mb, Total Memory: {} Mb, Free Memory: {} Mb",
				Runtime.getRuntime().maxMemory() / 1048576,
				Runtime.getRuntime().totalMemory() / 1048576,
				Runtime.getRuntime().freeMemory() / 1048576);
	}
}
