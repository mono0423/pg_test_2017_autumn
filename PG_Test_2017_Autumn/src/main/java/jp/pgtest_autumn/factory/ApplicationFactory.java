package jp.pgtest_autumn.factory;

import jp.pgtest_autumn.application.ApplicationBase;
import jp.pgtest_autumn.model.PhotoListManager;

/**
 * アプリケーションファクトリクラス。
 * <p>
 * アプリ切替時にアプリのオブジェクトを返却するクラス。
 * </p>
 *
 * @author SYS Takahiro Mitsuoka
 */
public class ApplicationFactory {

	/** 写真リストマネージャ */
	private static PhotoListManager photoListManager;

	/** ホームアプリ */
	private static ApplicationBase home;

	/** アルバムアプリ */
	private static ApplicationBase album;

	/** カメラアプリ */
	private static ApplicationBase camera;

	/** スタティックイニシャライザ */
	static {
		photoListManager = new PhotoListManager();
	}

	/**
	 * コンストラクタ。
	 * <p>
	 * staticクラスのため、コンストラクタはprivateで他クラスから不可視にする。
	 * </p>
	 */
	private ApplicationFactory() { }

	/**
	 * アプリオブジェクト取得メソッド。
	 * <p>
	 * 引数に受け取ったアプリ名に対応するアプリオブジェクトを返却する。
	 * </p>
	 *
	 * @param app アプリ名
	 * @return アプリオブジェクト
	 */
	public static ApplicationBase getInstance(String app) {

		/*===============================================*/
		/*           解答を記述してください。            */
		/*===============================================*/
		return null;/* ←コンパイルエラー回避のため。回答時は削除してください。 */
	}
}
