package jp.pgtest_autumn.application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import jp.pgtest_autumn.model.PhotoListManager;
import jp.pgtest_autumn.model.bean.Photo;

public class AlbumTest {

	private Album target;
	private PhotoListManager manager;

	private static int score = 0;

	private static List<String> correctList;

	private static List<String> incorrectList;

	static {
		correctList = new ArrayList<>();
		incorrectList = new ArrayList<>();
	}

	@Before
	public void before() {
		manager = new PhotoListManager();
		target = new Album(manager);
	}

	@Test
	public void コンストラクタ確認_0010() throws Exception {

//		PhotoListManager expected = new PhotoListManager();
//		Album target = new Album(expected);
//
//		// リフレクション
//		Class<Album> album = Album.class;
//
//		// フィールド(str)の取得
//		Field f = album.getDeclaredField("photoListManager");
//		f.setAccessible(true);
//
//		PhotoListManager actual = (PhotoListManager) f.get(album);
//		if (actual == expected) {
//			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
//			score += 2;
//			return;
//		}
//
//		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
//		fail();
	}

	@Test
	public void 写真リスト_ソート_0010() throws Exception {

		List<Photo> expected = new ArrayList<>();
		expected.add(new Photo("20170101_000000.png"));
		expected.add(new Photo("20170301_000000.png"));
		expected.add(new Photo("20170201_000000.png"));

		/* ソートメソッドをリフレクションで実行 */

//		if (actual == expected) {
//			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
//			score += 2;
//			return;
//		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@AfterClass
	public static void score() {
		System.out.println("【Album】  " + score + "/30点");
		System.out.println("正解  ：" + correctList);
		System.out.println("不正解：" + incorrectList);
	}
}
