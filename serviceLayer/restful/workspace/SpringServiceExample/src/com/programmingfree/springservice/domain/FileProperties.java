package com.programmingfree.springservice.domain;

import java.io.File;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "filePath",
        "file",
        "fileComments"
    })
@XmlRootElement(name="FileProperties")
public class FileProperties {
	@XmlElement(name="filePath")
	private String filePath;
	@XmlElement(name="file")
	private File file;
	@XmlElement(name="fileComments")
	private String fileComments;


	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	public String getFileComments() {
		return fileComments;
	}
	public void setFileComments(String fileComments) {
		this.fileComments = fileComments;
	}

	@Override
	public String toString() {
		return "FileProperties [filePath=" + filePath + ", file exists=" + file.exists()
				+ ", fileComments=" + fileComments + "]";
	}

}