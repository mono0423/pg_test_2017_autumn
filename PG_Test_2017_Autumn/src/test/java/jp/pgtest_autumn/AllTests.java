package jp.pgtest_autumn;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import jp.pgtest_autumn.application.AlbumTest;
import jp.pgtest_autumn.application.CameraTest;
import jp.pgtest_autumn.controller.PhoneControllerTest;
import jp.pgtest_autumn.factory.ApplicationFactoryTest;

@RunWith(Suite.class)
@SuiteClasses({
	AlbumTest.class,
	CameraTest.class,
	PhoneControllerTest.class,
	ApplicationFactoryTest.class
})
public class AllTests {

	public static int albumScore = 0;
	public static int cameraScore = 0;
	public static int factoryScore = 0;
	public static int controllerScore = 0;

	public static void main(String[] args) {
		JUnitCore.main(AllTests.class.getName());
		System.out.println(albumScore);
	}
}
