package jp.pgtest_autumn.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

public class PhoneControllerTest {

	private static int score = 0;

	private static List<String> correctList;

	private static List<String> incorrectList;

	static {
		correctList = new ArrayList<>();
		incorrectList = new ArrayList<>();
	}

	@Test
	public void ホームボタン押下時確認_0010() {
		fail("まだ実装されていません");
	}

	@Test
	public void カメラアプリ押下時確認_ホームアプリ起動時_0010() {
		fail("まだ実装されていません");
	}

	@Test
	public void カメラアプリ押下時確認_カメラアプリ起動時_0020() {
		fail("まだ実装されていません");
	}

	@Test
	public void カメラアプリ押下時確認_アルバムアプリ起動時_0030() {
		fail("まだ実装されていません");
	}

	@Test
	public void アルバムアプリ押下時確認_ホームアプリ起動時_0010() {
		fail("まだ実装されていません");
	}

	@Test
	public void アルバムアプリ押下時確認_カメラアプリ起動時_0020() {
		fail("まだ実装されていません");
	}

	@Test
	public void アルバムアプリ押下時確認_アルバムアプリ起動時_0030() {
		fail("まだ実装されていません");
	}

	@Test
	public void 音量UPボタン押下時確認_アルバムアプリ起動時_0010() {
		fail("まだ実装されていません");
	}

	@Test
	public void 音量UPボタン押下時確認_カメラアプリ起動時_0020() {
		fail("まだ実装されていません");
	}

	@Test
	public void 音量DOWNボタン押下時確認_アルバムアプリ起動時_0010() {
		fail("まだ実装されていません");
	}

	@Test
	public void 音量DOWNボタン押下時確認_カメラアプリ起動時_0020() {
		fail("まだ実装されていません");
	}

	@Test
	public void ボタン名不正確認_0010() {
		fail("まだ実装されていません");
	}

	@AfterClass
	public static void score() {
		System.out.println("【Camera】  " + score + "/30点");
		System.out.println("正解  ：" + correctList);
		System.out.println("不正解：" + incorrectList);
	}
}
