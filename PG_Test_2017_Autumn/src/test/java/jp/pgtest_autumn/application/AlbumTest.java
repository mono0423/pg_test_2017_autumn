package jp.pgtest_autumn.application;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import jp.pgtest_autumn.AllTests;
import jp.pgtest_autumn.model.PhotoListManager;
import jp.pgtest_autumn.model.bean.Photo;

public class AlbumTest {


	private static List<String> correctList;

	private static List<String> incorrectList;

	static {
		correctList = new ArrayList<>();
		incorrectList = new ArrayList<>();
	}

	@Before
	public void before() {
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
//			albumScore += 2;
//			return;
//		}
//
//		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
//		fail();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void 写真リスト_ソート確認_日付_0010() throws Exception {

		PhotoListManager input = new PhotoListManager();
		input.add(new Photo("20170101_000000.png"));
		input.add(new Photo("20170301_000000.png"));
		input.add(new Photo("20170201_000000.png"));

		/* ソートメソッドをリフレクションで実行 */
		Album album = new Album(input);
		Method method = Album.class.getDeclaredMethod("fetchLatest10Photo");
		method.setAccessible(true);
		List<Photo> actualList = (List<Photo>) method.invoke(album);

		List<Photo> expectedList = new ArrayList<>();
		expectedList.add(new Photo("20170301_000000.png"));
		expectedList.add(new Photo("20170201_000000.png"));
		expectedList.add(new Photo("20170101_000000.png"));

		if (actualList.size() != expectedList.size()) {
			incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			fail();
		}

		/*
		 * 実際の写真リストと期待する写真リストが全て一致するか調べる
		 * 一致しなければ、失敗
		 */
		for (int i = 0; i < actualList.size(); i++) {
			String actualPhotoName = actualList.get(i).getFileName();
			String expectedPhotoName = expectedList.get(i).getFileName();

			if (!actualPhotoName.equals(expectedPhotoName)) {
				incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
				fail();
			}
		}

		/* 全て一致すれば成功 */
		correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		AllTests.albumScore += 2;
		return;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void 写真リスト_ソート確認_時刻_0010() throws Exception {

		PhotoListManager input = new PhotoListManager();
		input.add(new Photo("20170101_100000.png"));
		input.add(new Photo("20170101_300000.png"));
		input.add(new Photo("20170101_200000.png"));

		/* ソートメソッドをリフレクションで実行 */
		Album album = new Album(input);
		Method method = Album.class.getDeclaredMethod("fetchLatest10Photo");
		method.setAccessible(true);
		List<Photo> actualList = (List<Photo>) method.invoke(album);

		List<Photo> expectedList = new ArrayList<>();
		expectedList.add(new Photo("20170101_300000.png"));
		expectedList.add(new Photo("20170101_200000.png"));
		expectedList.add(new Photo("20170101_100000.png"));

		if (actualList.size() != expectedList.size()) {
			incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			fail();
		}

		/*
		 * 実際の写真リストと期待する写真リストが全て一致するか調べる
		 * 一致しなければ、失敗
		 */
		for (int i = 0; i < actualList.size(); i++) {
			String actualPhotoName = actualList.get(i).getFileName();
			String expectedPhotoName = expectedList.get(i).getFileName();

			if (!actualPhotoName.equals(expectedPhotoName)) {
				incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
				fail();
			}
		}

		/* 全て一致すれば成功 */
		correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		AllTests.albumScore += 2;
		return;
	}

	@AfterClass
	public static void albumScore() {
		System.out.println("【Album】  " + AllTests.albumScore + "/30点");
		System.out.println("正解  ：" + correctList);
		System.out.println("不正解：" + incorrectList);
	}
}
