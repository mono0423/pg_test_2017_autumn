package jp.pgtest_autumn.application;

import java.util.List;

public abstract class ApplicationBase {

	/**
	 * アプリ起動時処理。
	 * <p>
	 * 具体的な処理はサブクラスでオーバーライドし定義する。
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	public abstract List<String> launch();

	/**
	 * 音量UPボタン押下時処理。
	 * <p>
	 * 具体的な処理はサブクラスでオーバーライドし定義する。
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	public abstract List<String> putVolumeUp();

	/**
	 * 音量DOWNボタン押下時処理。
	 * <p>
	 * 具体的な処理はサブクラスでオーバーライドし定義する。
	 * </p>
	 *
	 * @return メッセージリスト
	 */
	public abstract List<String> putVolumeDown();

	/**
	 * 起動中アプリ表示メソッド。
	 * <p>
	 * 具体的な処理はサブクラスでオーバーライドし定義する。
	 * </p>
	 *
	 * @return メッセージ
	 */
	public abstract List<String> display();

	/**
	 * アプリ名取得メソッド。
	 * <p>
	 * 具体的な処理はサブクラスでオーバーライドし定義する。
	 * </p>
	 *
	 * @return メッセージ
	 */
	public abstract String fetchApplicationName();
}
