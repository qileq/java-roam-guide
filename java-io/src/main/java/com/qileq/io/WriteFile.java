package com.qileq.io;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	private File filename;

	public void writeByFileOutputStream(String str) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(filename);
		byte[] strToBytes = str.getBytes();
		outputStream.write(strToBytes);
		outputStream.close();
	}

	public void writeByDataOutputStream(String str) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(filename);
		DataOutputStream outStream = new DataOutputStream(outputStream);

		byte[] strToBytes = str.getBytes();
		outputStream.write(strToBytes);
		outputStream.close();
	}

	public void writeByBufferedWriter(String str) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(str);
		writer.close();
	}
}
