package jp.pgtest_autumn.application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import jp.pgtest_autumn.constant.MessageConstant;
import jp.pgtest_autumn.model.PhotoListManager;

public class CameraTest {

	private Camera target;
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
		target = new Camera(manager);
	}

	@Test
	public void コンストラクタ確認_0010() {

	}

	@Test
	public void 音量UPボタン押下時確認_0010() {

		/* TODO:Calendarクラスをモック化 */
		String fileName = "20990909_090909.png";

		List<String> expected = new ArrayList<>(
										Arrays.asList(MessageConstant.CAMERA_SHOT_MSG,
													  fileName));

		List<String> actual = target.putVolumeUp();

		/* expectedとactualで一致しないものがないか調べる */
		for (String expectedMsg : expected) {
			if (!actual.contains(expectedMsg)) {
				fail();
			}
		}

		correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		score += 2;
	}

	@Test
	public void 音量DOWNボタン押下時確認_0010() {

		/* TODO:Calendarクラスをモック化 */
		String fileName = "20990909_090909.png";

		List<String> expected = new ArrayList<>(
										Arrays.asList(MessageConstant.CAMERA_SHOT_MSG,
													  fileName));

		List<String> actual = target.putVolumeUp();

		/* expectedとactualで一致しないものがないか調べる */
		for (String expectedMsg : expected) {
			if (!actual.contains(expectedMsg)) {
				fail();
			}
		}

		correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		score += 2;
	}


	@AfterClass
	public static void score() {
		System.out.println("【Camera】  " + score + "/30点");
		System.out.println("正解  ：" + correctList);
		System.out.println("不正解：" + incorrectList);
	}
}
