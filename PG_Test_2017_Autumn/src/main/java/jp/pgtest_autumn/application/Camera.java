package jp.pgtest_autumn.application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import jp.pgtest_autumn.model.PhotoListManager;
import jp.pgtest_autumn.model.bean.Photo;

/**
 * カメラアプリクラス。
 * <p>
 * カメラアプリ起動時の処理を記述するためのクラス。<br>
 * </p>
 *
 * @author SYS Takahiro Mitsuoka
 */
public class Camera extends ApplicationBase {

	/** 写真リスト */
	private PhotoListManager photoListManager;

	/**
	 * コンストラクタ。
	 * <p>
	 * 引数に渡された写真リストをフィールド変数に格納する。<br>
	 * </p>
	 * @param photoListManager 写真リスト
	 */
	public Camera(PhotoListManager photoListManager) {
		/*===============================================*/
		/*           解答を記述してください。            */
		/*===============================================*/
	}

	/**
	 * カメラアプリ起動時処理。(修正不要)
	 */
	@Override
	public List<String> launch() {
		return new ArrayList<String>(Arrays.asList("カメラアプリを起動しました。"));
	}


	/**
	 * 音量UPボタン押下時処理。
	 * <p>
	 * 以下の処理を行う。<br>
	 *   ・写真を撮影する。<br>
	 *   ・メッセージ"写真を撮りました。"をメッセージリストに追加する。<br>
	 *   ・撮影した写真のファイル名をメッセージリストに追加する。<br>
	 *   ・メッセージリストを返却する。<br>
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	@Override
	public List<String> putVolumeUp() {
		/*===============================================*/
		/*           解答を記述してください。            */
		/*===============================================*/
		return null;/* ←コンパイルエラー回避のため。回答時は削除してください。 */
	}

	/**
	 * 音量DOWNボタン押下時処理。
	 * <p>
	 * 以下の処理を行う。<br>
	 *   ・写真を撮影する。(Cameraクラスのshotメソッドを実行)<br>
	 *   ・メッセージ"写真を撮りました。"をメッセージリストに追加する。<br>
	 *   ・撮影した写真のファイル名をメッセージリストに追加する。<br>
	 *   ・メッセージリストを返却する。<br>
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	@Override
	public List<String> putVolumeDown() {

		/*===============================================*/
		/*           解答を記述してください。            */
		/*===============================================*/
		return null;/* ←コンパイルエラー回避のため。回答時は削除してください。 */
	}

	/**
	 * 起動中アプリ表示メソッド。(修正不要)
	 *
	 * @return メッセージ
	 */
	@Override
	public List<String> display() {
		return new ArrayList<String>(Arrays.asList("カメラアプリが起動中です。",
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
		return "カメラ  ";
	}

	/**
	 * 撮影メソッド。(修正不要)
	 * <p>
	 * 以下の処理を行う。
	 *   ・現時刻を取得する。
	 *   ・現時刻をファイル名とした写真オブジェクトを生成する。
	 *   ・写真リストに追加する。
	 *   ・写真オブジェクトを返却する。
	 * </p>
	 * @return 写真
	 */
	private Photo shot() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

		String fileName = simpleDateFormat.format(calendar.getTime());
		Photo photo = new Photo(fileName);
		photoListManager.add(photo);

		return photo;
	}
}
