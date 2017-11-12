package jp.pgtest_autumn.controller;

import java.util.List;

import jp.pgtest_autumn.application.ApplicationBase;
import jp.pgtest_autumn.constant.ButtonNameConstant;
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
	 * @return メッセージリスト
	 */
	public List<String> exe(String input) {

		List<String> messageList = null;
		/*===========↑は編集しないでください。====================================*/


		/*===============================================*/
		/*           解答を記述してください。            */
		/*===============================================*/


		/*===========↓は編集しないでください。====================================*/
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
	 * @return 起動中アプリ
	 */
	public ApplicationBase getCurrentApp() {
		return currentApp;
	}
}
