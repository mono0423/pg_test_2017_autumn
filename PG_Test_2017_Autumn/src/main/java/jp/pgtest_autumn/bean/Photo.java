package jp.pgtest_autumn.bean;

public class Photo {

	private String fileName;

	public Photo(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileNameWithExtension() {
		return fileName + ".png";
	}
}
