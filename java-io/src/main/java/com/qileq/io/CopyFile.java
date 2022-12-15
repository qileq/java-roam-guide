package com.qileq.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyFile {

	public static void main(String[] args) {
		CopyFile cf = new CopyFile();
		String src = "src.txt";
		String dst = "dst.txt";
		cf.copyByCharactersWrapByte(src, dst);
	}

	public void copyByBytes(String src, String dst) {
		try (
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dst))
		) {
			int b;
			while ((b = bis.read()) != -1) {
				bos.write(b);
				bos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyByCharacters(String src, String dst) {
		try (
				BufferedReader br = new BufferedReader(new FileReader(src));
				BufferedWriter bw = new BufferedWriter(new FileWriter(dst))
		) {
			String l;
			while ((l = br.readLine()) != null) {
				bw.write(l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyByCharactersWrapByte(String src, String dst) {
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dst)));
		) {
			String l;
			while ((l = br.readLine()) != null) {
				bw.write(l);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
