package jp.pgtest_autumn.factory;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import jp.pgtest_autumn.application.Album;
import jp.pgtest_autumn.application.ApplicationBase;
import jp.pgtest_autumn.application.Camera;
import jp.pgtest_autumn.application.Home;
import jp.pgtest_autumn.constant.MessageConstant;
import jp.pgtest_autumn.model.PhotoListManager;

public class ApplicationFactoryTest {

	private static int score = 0;

	private static List<String> correctList;

	private static List<String> incorrectList;

	static {
		correctList = new ArrayList<>();
		incorrectList = new ArrayList<>();
	}

	@Test
	public void ホーム取得確認_0010() {

		ApplicationBase app = ApplicationFactory.getInstance("home");

		if (app instanceof Home) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 5;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void ホームシングルトン確認_0011() {

		ApplicationBase app1 = ApplicationFactory.getInstance("home");
		ApplicationBase app2 = ApplicationFactory.getInstance("home");

		if (app1 == app2) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 2;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void カメラ取得確認_0020() {

		ApplicationBase app = ApplicationFactory.getInstance("camera");

		if (app instanceof Camera) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 5;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void カメラシングルトン確認_0021() {

		ApplicationBase app1 = ApplicationFactory.getInstance("camera");
		ApplicationBase app2 = ApplicationFactory.getInstance("camera");

		if (app1 == app2) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 2;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void アルバム取得確認_0030() {

		ApplicationBase app = ApplicationFactory.getInstance("album");

		if (app instanceof Album) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 5;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void アルバムシングルトン確認_0031() {

		ApplicationBase app1 = ApplicationFactory.getInstance("album");
		ApplicationBase app2 = ApplicationFactory.getInstance("album");

		if (app1 == app2) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 2;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void 写真リストマネージャ確認_0031() throws Exception {

		ApplicationBase album = ApplicationFactory.getInstance("album");
		ApplicationBase camera = ApplicationFactory.getInstance("camera");

		/* リフレクションでprivateフィールドにアクセスする */
		Field camraField = Camera.class.getDeclaredField("photoListManager");
		camraField.setAccessible(true);
		PhotoListManager cameraManager = (PhotoListManager) camraField.get(camera);

		Field albumField = Album.class.getDeclaredField("photoListManager");
		albumField.setAccessible(true);
		PhotoListManager albumManager = (PhotoListManager) albumField.get(album);

		if (cameraManager == albumManager) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 5;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void 不正入力_入力a_0040() {

		try {
			ApplicationBase app = ApplicationFactory.getInstance("a");

		} catch(IllegalArgumentException e) {
			if (MessageConstant.ILLAGAL_APP_NAME_MSG.equals(e.getMessage())) {
				correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
				score += 2;
				return;
			}
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void 不正入力_空文字_0041() {

		try {
			ApplicationBase app = ApplicationFactory.getInstance("");

		} catch(IllegalArgumentException e) {
			if (MessageConstant.ILLAGAL_APP_NAME_MSG.equals(e.getMessage())) {
				correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
				score += 2;
				return;
			}
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@AfterClass
	public static void score() {
		System.out.println("【ApplicationFactory】  " + score + "/30点");
		System.out.println("  正解  ：" + correctList);
		System.out.println("  不正解：" + incorrectList);
	}
}
