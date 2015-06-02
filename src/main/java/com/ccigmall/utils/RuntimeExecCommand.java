package com.ccigmall.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 
 * @author treesea888@icloud.com
 * @description exute bat,执行bat
 */
public class RuntimeExecCommand {
	/**
	 * exute bat
	 * @param filepath
	 */
	public void execCommandFile(String filepath) {
		try {
			Runtime.getRuntime().exec("cmd.exe /c start " + filepath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 文件写入
	 * 
	 * @param filePath
	 * @param content
	 */
	public void write(String filePath, String content) {
		try {
			File file = new File(filePath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
				System.out.println(file.getAbsolutePath());
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			OutputStreamWriter write = new OutputStreamWriter(
					new FileOutputStream(file), "GBK");
			BufferedWriter writer = new BufferedWriter(write);
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
