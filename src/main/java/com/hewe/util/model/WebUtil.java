package com.hewe.util.model;

import java.io.File;
import java.util.UUID;

public class WebUtil {
	public static String makeFileName(String filename) { // 2.jpg
		return UUID.randomUUID().toString() + "_" + filename;
	}
	
	public static String makeId(){
		return UUID.randomUUID().toString();
	}
	
	public static String makePath(String filename, String savePath) {

		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15

		String dir = savePath + "\\" + dir1 + "\\" + dir2; // upload\2\3
															// upload\3\5
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}
}
