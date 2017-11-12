package jp.pgtest_autumn.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.pgtest_autumn.application.ApplicationBase;
import jp.pgtest_autumn.application.Home;
import jp.pgtest_autumn.constant.ButtonNameConstant;
import jp.pgtest_autumn.constant.MessageConstant;
import jp.pgtest_autumn.factory.ApplicationFactory;

/**
 * スマートフォンコントローラクラス。
 * <p>
 * 押下されたボタンに応じたアプリの処理を実行する。
 * </p>
 *
 * @author SYS Takahiro Mitsuoka
 */
public class PhoneController {

	/** 起動中のアプリ */
	private ApplicationBase currentApp;

	/**
	 * コンストラクタ。(修正不要)
	 * <p>
	 * 初回起動時はホーム画面を表示するため、以下の処理を行う。<br>
	 *   ・ApplicationFactoryからホームアプリのオブジェクトを取得する。<br>
	 *   ・ホームアプリのlaunchメソッドを実行し、返却されたメッセージを表示する。<br>
	 * </p>
	 */
	public PhoneController() {
		currentApp = ApplicationFactory.getInstance(ButtonNameConstant.HOME);

		List<String> messageList = currentApp.launch();
		messageList.addAll(currentApp.display());
		for (String message : messageList) {
			System.out.println("【" + currentApp.fetchApplicationName() + "】" + message);
		}
	}

	/**
	 * 処理実行メソッド。
	 * <p>
	 * 押下されたボタンに応じた処理を行う。<br>
	 * 実行される処理の具体的な中身は、起動中のアプリに依存する。<br>
	 * </p>
	 *
	 * @param input 押下されたボタン名
	 */
	public List<String> exe(String input) {

		List<String> messageList;

		/* ホームアプリ以外からのアプリ切り替え防止 */
		if (!(currentApp instanceof Home)
				&& (ButtonNameConstant.CAMERA.equals(input) || ButtonNameConstant.ALBUM.equals(input))) {
			messageList = new ArrayList<>(Arrays.asList(MessageConstant.ILLAGAL_APP_CHANGE_MSG));

		/* アプリ切り替え時 */
		} else 	if (ButtonNameConstant.HOME.equals(input)
						|| ButtonNameConstant.CAMERA.equals(input)
						|| ButtonNameConstant.ALBUM.equals(input)) {

			/* ボタン時応じたアプリを起動する */
			currentApp = ApplicationFactory.getInstance(input);
			messageList = currentApp.launch();

		/* 音量UPボタン押下時 */
		} else if (ButtonNameConstant.UP.equals(input)) {
			messageList = currentApp.putVolumeUp();

		/* 音量Downボタン押下時 */
		} else if (ButtonNameConstant.DOWN.equals(input)) {
			messageList = currentApp.putVolumeDown();

		/* ボタン名が不正な場合 */
		} else {
			messageList = new ArrayList<>(Arrays.asList(MessageConstant.ILLAGAL_BUTTON_MSG));
			messageList.addAll(currentApp.launch());
		}

		/* メッセージを出力する */
		for (String message : messageList) {
			System.out.println("【" + currentApp.fetchApplicationName() + "】" + message);
		}
		for (String message : currentApp.display()) {
			System.out.println("【" + currentApp.fetchApplicationName() + "】" + message);
		}

		return messageList;
	}

	/**
	 * 起動中アプリ取得メソッド。(修正不要)
	 *
	 * @return 起動中アプリ。
	 */
	public ApplicationBase getCurrentApp() {
		return currentApp;
	}
}
