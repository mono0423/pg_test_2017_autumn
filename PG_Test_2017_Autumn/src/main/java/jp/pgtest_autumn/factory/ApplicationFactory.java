package jp.pgtest_autumn.factory;

import jp.pgtest_autumn.application.Album;
import jp.pgtest_autumn.application.ApplicationBase;
import jp.pgtest_autumn.application.Camera;
import jp.pgtest_autumn.application.Home;
import jp.pgtest_autumn.model.PhotoList;

public class ApplicationFactory {

	private static PhotoList photoList;

	private static ApplicationBase home;

	private static ApplicationBase album;

	private static ApplicationBase camera;

	static {
		photoList = new PhotoList();
	}

	private ApplicationFactory() { }

	public static ApplicationBase getInstance(String app) {

		switch (app) {
		case "home":
			home = home == null ? new Home() : home;
			return home;

		case "camera":
			camera = camera == null ? new Camera(photoList) : camera;
			return camera;

		case "album":
			album = album == null ? new Album(photoList) : album;
			return album;

		default:
			throw new IllegalArgumentException("引数にホーム・カメラ・アルバム以外のオブジェクトが渡されています。：" + app);
		}
	}
}
