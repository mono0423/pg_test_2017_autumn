package jp.pgtest_autumn.factory;

import jp.pgtest_autumn.application.Album;
import jp.pgtest_autumn.application.ApplicationBase;
import jp.pgtest_autumn.application.Camera;
import jp.pgtest_autumn.application.Home;
import jp.pgtest_autumn.constant.MessageConstant;
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

		switch (app) {
		case "home":
			home = home == null ? new Home() : home;
			return home;

		case "camera":
			camera = camera == null ? new Camera(photoListManager) : camera;
			return camera;

		case "album":
			album = album == null ? new Album(photoListManager) : album;
			return album;

		/* 不正なアプリ名が渡された場合、例外をスローする */
		default:
			throw new IllegalArgumentException(MessageConstant.ILLAGAL_APP_NAME_MSG);
		}
	}
}
