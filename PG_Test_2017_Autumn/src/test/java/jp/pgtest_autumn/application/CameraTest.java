package jp.pgtest_autumn.application;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import jp.pgtest_autumn.constant.MessageConstant;
import jp.pgtest_autumn.model.PhotoListManager;
import jp.pgtest_autumn.model.bean.Photo;
import mockit.Mock;
import mockit.MockUp;

public class CameraTest {

	private PhotoListManager manager = new PhotoListManager();

	@InjectMocks
	private Camera target = new Camera(manager);

	private static int score = 0;
	private static List<String> correctList;
	private static List<String> incorrectList;

	static {
		correctList = new ArrayList<>();
		incorrectList = new ArrayList<>();
	}

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void コンストラクタ確認_0010() throws Exception {
		/* リフレクションでprivateフィールドにアクセスする */
		Field field = Camera.class.getDeclaredField("photoListManager");
		field.setAccessible(true);

		PhotoListManager actual = (PhotoListManager) field.get(target);

		/* 一致すれば成功 */
		if (actual == manager) {
			correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
			score += 10;
			return;
		}

		incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		fail();
	}

	@Test
	public void 音量UPボタン押下時確認_0020() {

		/* shotメソッドをモック化 */
		String fileName = "20990909_090909";
		Photo expectedPhoto = new Photo(fileName);

		new MockUp<Camera>() {
			@Mock
			private Photo shot() {
				return expectedPhoto;
			}
		};

		List<String> expected = new ArrayList<>(Arrays.asList(MessageConstant.CAMERA_SHOT_MSG, expectedPhoto.getFileNameWithExtension()));

		List<String> actual = target.putVolumeUp();

		/* expectedとactualで一致しないものがあれば失敗 */
		for (String expectedMsg : expected) {
			if (!actual.contains(expectedMsg)) {
				incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
				fail();
			}
		}

		/* 全て一致すれば成功 */
		correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		score += 30;
	}

	@Test
	public void 音量DOWNボタン押下時確認_0030() {

		/* shotメソッドをモック化 */
		String fileName = "20990909_090909";
		Photo expectedPhoto = new Photo(fileName);

		new MockUp<Camera>() {
			@Mock
			private Photo shot() {
				return expectedPhoto;
			}
		};

		List<String> expected = new ArrayList<>(Arrays.asList(MessageConstant.CAMERA_SHOT_MSG, expectedPhoto.getFileNameWithExtension()));

		List<String> actual = target.putVolumeUp();

		/* expectedとactualで一致しないものがあれば失敗 */
		for (String expectedMsg : expected) {
			if (!actual.contains(expectedMsg)) {
				incorrectList.add(new Object() {}.getClass().getEnclosingMethod().getName());
				fail();
			}
		}

		/* 全て一致すれば成功 */
		correctList.add(new Object() {}.getClass().getEnclosingMethod().getName());
		score += 30;
	}

	@AfterClass
	public static void score() {
		System.out.println("【Camera】  " + score + "/70点");
		System.out.println("  正解  ：" + correctList);
		System.out.println("  不正解：" + incorrectList);
	}
}
