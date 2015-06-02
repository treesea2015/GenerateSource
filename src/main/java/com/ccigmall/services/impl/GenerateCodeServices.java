package com.ccigmall.services.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Service;

import com.ccigmall.beans.Action;
import com.ccigmall.beans.Page;
import com.ccigmall.beans.Step;
import com.ccigmall.beans.Xml;
import com.ccigmall.services.IGenerateCodeServices;

/**
 * 
 * @author treesea888@icloud.com
 * @description generate services
 */
@Service
public class GenerateCodeServices implements IGenerateCodeServices {

	@Override
	public String pro(String filePath, String packageStr, String importStr,
			String className, String extendsStr, String author,
			String description, String[] eName, String[] annotation,
			String[] loactor, String[] value, String[] actType) {
		// page
		File fPage = new File(filePath + File.separator + className
				+ "Page.java");
		String javaPageContent = new Page(packageStr, className, extendsStr,
				author, description, eName, annotation, loactor, value)
				.toString();
		// Act
		File fAction = new File(filePath + File.separator + className
				+ "Act.java");
		String javaActContent = new Action(packageStr, importStr, className,
				extendsStr, author, description, eName, annotation, actType)
				.toString();
		// Step
		File fStep = new File(filePath + File.separator + className
				+ "Step.java");
		String javaStepContent = new Step(packageStr, importStr, className,
				extendsStr, author, description, eName, annotation, actType)
				.toString();
		// Xml
		File fXml = new File(filePath + File.separator + className
				+ ".xml");
		String XmlContent = new Xml(packageStr, importStr, className)
				.toString();
		// 写入
		write(fPage, javaPageContent);
		write(fAction, javaActContent);
		write(fStep, javaStepContent);
		write(fXml, XmlContent);
		return ZipFiles(filePath + ".zip", filePath);
	}

	/**
	 * 文件写入
	 * 
	 * @param file
	 * @param content
	 */
	@Override
	public void write(File file, String content) {
		try {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
				System.out.println(file.getAbsolutePath());
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			OutputStreamWriter write = new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8");
			BufferedWriter writer = new BufferedWriter(write);
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 将生成的文件所在目录，进行压缩
	 */
	@Override
	public String ZipFiles(String zipFile, String srcDir) {
		try {
			byte[] buffer = new byte[1024];
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			File dir = new File(srcDir);
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				FileInputStream fis = new FileInputStream(files[i]);
				zos.putNextEntry(new ZipEntry(files[i].getName()));
				int length;
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
		} catch (Exception e) {

		}
		return zipFile;

	}
	
	

}
