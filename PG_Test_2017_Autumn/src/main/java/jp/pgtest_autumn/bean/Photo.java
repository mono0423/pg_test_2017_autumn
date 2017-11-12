package jp.pgtest_autumn.bean;

/**
 * 写真クラス。(修正不要)
 * <p>
 * 簡単のため、写真の情報はファイル名しか保持しない。<br>
 * ファイル名は"yyyyMMdd_hhmmss.png"とする。(例：20171121_173000.png)
 * </p>
 *
 * @author SYS Takahiro Mitsuoka
 */
public class Photo {

	/** ファイル名 */
	private String fileName;

	/**
	 * コンストラクタ。
	 *
	 * @param fileName ファイル名
	 */
	public Photo(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * ファイル名取得メソッド。
	 *
	 * @return ファイル名
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 拡張子付きファイル名取得メソッド。
	 *
	 * @return ファイル名(拡張子付き)
	 */
	public String getFileNameWithExtension() {
		return fileName + ".png";
	}
}
