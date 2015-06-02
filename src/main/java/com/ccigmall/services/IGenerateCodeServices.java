package com.ccigmall.services;

import java.io.File;

public interface IGenerateCodeServices {
	
	public String pro(
			String filePath,
			String packageStr,
			String importStr,
			String className,
			String extendsStr,
			String author,
			String description,
			String[] eName,
			String[] annotation,
			String[] loactor,
			String[] value ,
			String[] actType
			) ;
	public String ZipFiles(
			String zipFile, 
			String srcDir
			);
	void write(File file, String content);
}
