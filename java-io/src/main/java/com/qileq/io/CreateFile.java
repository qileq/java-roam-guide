package com.qileq.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.io.FileUtils;

public class CreateFile {

	private final String filename = "qileq";

	public void createByFile() throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public void createByFileOutputStream() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(filename);
		fileOutputStream.close();
	}

	public void createByFileWriter() throws IOException {
		FileWriter fileWriter = new FileWriter(filename);
		fileWriter.close();
	}

	public void createByFileChannel() throws IOException {
		Path file = Paths.get(filename);
		FileChannel.open(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
	}

	public void createByFilesCreateFile() throws IOException {
		Path file = Paths.get(filename);
		Files.createFile(file);
	}

	public void createByFilesNewOutputStream() throws IOException {
		Path file = Paths.get(filename);
		Files.newOutputStream(file, StandardOpenOption.CREATE);
//		Files.newOutputStream(file, StandardOpenOption.CREATE_NEW);
	}

	public void createByFilesNewBufferedWriter() throws IOException {
		Path file = Paths.get(filename);
		Files.newBufferedWriter(file);
	}

	public void createByFilesNewByteChannel() throws IOException {
		Path file = Paths.get(filename);
		Files.newByteChannel(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
	}

	public void createByGuava() throws IOException {
		com.google.common.io.Files.touch(new File(filename));
	}

	public void createByApacheCommonIO() throws IOException {
		FileUtils.touch(new File(filename));
	}

	public static void main(String[] args) throws IOException {
		CreateFile cf = new CreateFile();
		cf.createByApacheCommonIO();
	}
}
