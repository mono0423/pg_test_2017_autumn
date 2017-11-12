package jp.pgtest_autumn.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jp.pgtest_autumn.constant.MessageConstant;
import jp.pgtest_autumn.model.PhotoListManager;
import jp.pgtest_autumn.model.bean.Photo;

/**
 * アルバムアプリクラス。
 * <p>
 * アルバムアプリ起動時の処理を記述するためのクラス。<br>
 * </p>
 *
 * @author SYS Takahiro Mitsuoka
 */
public class Album extends ApplicationBase {

	/** 写真リスト */
	private PhotoListManager photoListManager;

	/**
	 * コンストラクタ。
	 * <p>
	 * 引数に渡された写真リストをフィールド変数に格納する。<br>
	 * </p>
	 * @param photoListManager 写真リスト
	 */
	public Album(PhotoListManager photoListManager) {
		this.photoListManager = photoListManager;
	}

	/**
	 * アルバムアプリ起動時処理。(修正不要)
	 * <p>
	 * 以下の処理を行う。<br>
	 *   ・起動時メッセージをメッセージリストに追加する。<br>
	 *   ・カメラアプリで撮影した写真のファイル名をメッセージリストに追加する。(最新の10枚、ファイル名降順)<br>
	 *   ・メッセージリストを返却する。<br>
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	@Override
	public List<String> launch() {

		List<String> messageList = new ArrayList<String>(Arrays.asList("アルバムアプリを起動しました。"));


		messageList.add("------------------------------------");
		messageList.add("撮影した写真(最新10枚)");

		if (photoListManager.isEmpty()) {
			messageList.add("写真が撮影されていません。");
			messageList.add("------------------------------------");
			return messageList;
		}

		for (Photo photo : fetchLatest10Photo()) {
			messageList.add(photo.getFileNameWithExtension());
		}
		messageList.add("------------------------------------");

		return messageList;
	}

	/**
	 * 音量UPボタン押下時処理。
	 * <p>
	 * 以下の処理を行う。<br>
	 *   ・メッセージ"音量を上げました。"をメッセージリストに追加し、返却する。<br>
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	@Override
	public List<String> putVolumeUp() {
		return new ArrayList<String>(Arrays.asList(MessageConstant.VOLUME_UP_MSG));
	}

	/**
	 * 音量DOWNボタン押下時処理。
	 * <p>
	 * 以下の処理を行う。<br>
	 *   ・メッセージ"音量を下げました。"をメッセージリストに追加し、返却する。<br>
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	@Override
	public List<String> putVolumeDown() {
		return new ArrayList<String>(Arrays.asList(MessageConstant.VOLUME_DOWN_MSG));
	}

	/**
	 * 写真取得メソッド。
	 * <p>
	 * 写真リストの中で、最新10枚の写真を返却する。<br>
	 * </p>
	 * @return 写真リスト(最新10枚)
	 */
	private List<Photo> fetchLatest10Photo() {

		if (photoListManager.getPhotoList().size() == 0) {
			return photoListManager.getPhotoList();
		}

//		/* Java7 */
//		List<Photo> reverseList = new ArrayList<>(photoListManager.getPhotoList());
//		Collections.reverse(reverseList);
//
//		List<Photo> returnList = new ArrayList<>();
//		for (int i = 0; i < 10 && i < reverseList.size(); i++) {
//			returnList.add(reverseList.get(i));
//		}
//
//		return returnList;

		/* Java8 */
		return photoListManager.getPhotoList()
						 .stream()
						 .limit(10)
						 .sorted((p1, p2) -> p2.getFileName().compareTo(p1.getFileName()))
						 .collect(Collectors.toList());
	}

	/**
	 * 起動中アプリ表示メソッド。(修正不要)
	 *
	 * @return メッセージ
	 */
	@Override
	public List<String> display() {
		return new ArrayList<String>(Arrays.asList("アルバムアプリが起動中です。",
											  "以下のボタン名を入力してください。",
											  "    up   : 音量UPボタン",
											  "    down : 音量DOWNボタン",
											  "    home : HOMEボタン"));
	}

	/**
	 * アプリ名取得メソッド。(修正不要)
	 *
	 * @return アプリ名
	 */
	@Override
	public String fetchApplicationName() {
		return "アルバム";
	}
}
