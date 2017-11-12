package jp.pgtest_autumn.model;

import java.util.ArrayList;
import java.util.List;

import jp.pgtest_autumn.bean.Photo;

/**
 * 写真リスト管理クラス。(修正不要)
 *
 * @author SYS Takahiro Mitsuoka
 */
public class PhotoListManager {

	/** 写真リスト */
	private List<Photo> photoList;

	/**
	 * コンストラクタ。
	 */
	public PhotoListManager() {
		photoList = new ArrayList<>();
	}

	/**
	 * 写真追加メソッド。
	 * <p>
	 * 写真リストに引数に受け取った写真オブジェクトを追加する。
	 * </p>
	 * @param photo 写真オブジェクト
	 */
	public void add(Photo photo) {
		photoList.add(photo);
	}

	/**
	 * 写真リスト取得メソッド。
	 *
	 * @return 写真リスト
	 */
	public List<Photo> getPhotoList() {
		return photoList;
	}

	/**
	 * 写真0枚判定メソッド。
	 *
	 * @return true(写真リストが空)、false(写真リストのサイズが1以上)
	 */
	public boolean isEmpty() {
		return photoList.isEmpty();
	}
}
