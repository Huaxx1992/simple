package com.simple.kit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WinKit {

	public static void copy(String str) {
		String[] command = { "cmd", "/C", "echo " + str + " | clip" };
		executeCMD(command);
	}

	public static void executeCMD(String[] command) {
		BufferedReader br = null;
		try {
			Runtime run = Runtime.getRuntime();
			Process p = run.exec(command);
			br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (Exception e) {
			closeBufferedReader(br);
		}
	}

	private static void closeBufferedReader(BufferedReader br) {
		if (br == null) {
			return;
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
