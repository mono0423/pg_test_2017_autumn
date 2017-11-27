package jp.pgtest_autumn.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;

import jp.pgtest_autumn.application.Camera;
import jp.pgtest_autumn.application.Home;
import jp.pgtest_autumn.constant.MessageConstant;

public class PhoneControllerTest {

	@InjectMocks
	private PhoneController target = new PhoneController();

	private static int score = 0;

	private static List<String> correctList;

	private static List<String> incorrectList;

	static {
		correctList = new ArrayList<>();
		incorrectList = new ArrayList<>();
	}

	@BeforeClass
	public static void setup() {

	}

	@Test
	public void ホームボタン押下時確認_0010() {

		/* 一旦カメラを起動し、ホームに切り替える */
		target.exe("camera");
		List<String> actualmessageList = target.exe("home");

		/* 起動中のアプリがホームか確認 */
		if (target.getCurrentApp() instanceof Home) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 10;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void カメラアプリ押下時確認_ホームアプリ起動時_0010() {

		List<String> actualmessageList = target.exe("camera");

		/* 起動中のアプリがカメラか確認 */
		if (target.getCurrentApp() instanceof Camera) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 10;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void カメラアプリ押下時確認_カメラアプリ起動時_0020() {

		List<String> expectedMessageList = new ArrayList<>(Arrays.asList(MessageConstant.ILLAGAL_APP_CHANGE_MSG));

		/* 一旦カメラを起動し、カメラに切り替える */
		target.exe("camera");
		List<String> actualMessageList = target.exe("camera");

		/* 起動中のアプリがホームか確認 */
		if (!(target.getCurrentApp() instanceof Camera)) {
			incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			fail();
		}

		/* メッセージリストのnullチェック */
		if (actualMessageList == null || actualMessageList.size() == 0) {
			incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			fail();
		}

		/* メッセージリストサイズの比較 */
		if (actualMessageList.size() != expectedMessageList.size()) {
			incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			fail();
		}

		for (int i = 0; i < actualMessageList.size(); i++) {
			String actualMessage = actualMessageList.get(i);
			String expectedMessage = expectedMessageList.get(i);

			if (!actualMessage.equals(expectedMessage)) {
				incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
				fail();
			}
		}

		correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		score += 10;
		return;
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
		System.out.println("【PhoneController】  " + score + "/60点");
		System.out.println("  正解  ：" + correctList);
		System.out.println("  不正解：" + incorrectList);
	}
}
