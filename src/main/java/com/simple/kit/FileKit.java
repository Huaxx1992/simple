package com.simple.kit;

import java.io.File;
import java.io.FileFilter;

public class FileKit {

	public static void main(String[] args) {
		File root = new File("E:\\project");
		recursion(root);
	}

	private static void recursion(File target) {
		File[] childrenList = target.listFiles(new FileFilter() {
			public boolean accept(File fi) {
				if (fi.getName().endsWith(".java") || fi.isDirectory()) {
					return true;
				}
				return false;
			}
		});
		for (File childrenFile : childrenList) {
			if (childrenFile.isDirectory()) {
				recursion(childrenFile);
			} else {
				System.out.println(childrenFile);
			}
		}
	}
}
