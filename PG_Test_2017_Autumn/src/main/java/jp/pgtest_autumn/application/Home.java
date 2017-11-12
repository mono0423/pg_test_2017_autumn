package jp.pgtest_autumn.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.pgtest_autumn.constant.MessageConstant;

/**
 * ホームアプリクラス。(修正不要)
 * <p>
 * ホームアプリ起動時の処理を記述するためのクラス。
 * </p>
 *
 * @author SYS Takahiro Mitsuoka
 */
public class Home extends ApplicationBase {

	/**
	 * アプリ起動時処理。(修正不要)
	 * <p>
	 * 以下の処理を行う。<br>
	 *   ・起動時メッセージをメッセージリストに追加する。<br>
	 *   ・メッセージリストを返却する。<br>
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	@Override
	public List<String> launch() {
		return new ArrayList<String>(Arrays.asList("ホームアプリを起動しました。"));
	}

	/**
	 * 音量UPボタン押下時処理。(修正不要)
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
	 * 音量DOWNボタン押下時処理。(修正不要)
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
	 * 起動中アプリ表示メソッド。(修正不要)
	 *
	 * @return メッセージ
	 */
	@Override
	public List<String> display() {
		return new ArrayList<String>(Arrays.asList("ホームアプリが起動中です。",
											  "以下のボタン名を入力してください。",
											  "    camera : カメラアプリ",
											  "    album  : アルバムアプリ",
											  "    up     : 音量UPボタン",
											  "    down   : 音量DOWNボタン",
											  "    home   : HOMEボタン"));
	}

	/**
	 * アプリ名取得メソッド。(修正不要)
	 *
	 * @return アプリ名
	 */
	@Override
	public String fetchApplicationName() {
		return "ホーム  ";
	}
}
