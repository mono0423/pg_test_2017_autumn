package jp.pgtest_autumn.model;

import java.util.ArrayList;
import java.util.List;

import jp.pgtest_autumn.model.bean.Photo;

/**
 * 写真リスト管理クラス。(修正不要)
 *
 * @author SYS Takahiro Mitsuoka
 */
public class PhotoListManager {

	/** 写真リスト */
	private List<Photo> photoList;

	/**
	 * コンストラクタ。(修正不要)
	 */
	public PhotoListManager() {
		photoList = new ArrayList<>();
	}

	/**
	 * 写真追加メソッド。(修正不要)
	 * <p>
	 * 写真リストに引数に受け取った写真オブジェクトを追加する。
	 * </p>
	 * @param photo 写真オブジェクト
	 */
	public void add(Photo photo) {
		photoList.add(photo);
	}

	/**
	 * 写真リスト取得メソッド。(修正不要)
	 *
	 * @return 写真リスト
	 */
	public List<Photo> getPhotoList() {
		return photoList;
	}

	/**
	 * 写真0枚判定メソッド。(修正不要)
	 *
	 * @return true(写真リストが空)、false(写真リストのサイズが1以上)
	 */
	public boolean isEmpty() {
		return photoList.isEmpty();
	}
}
