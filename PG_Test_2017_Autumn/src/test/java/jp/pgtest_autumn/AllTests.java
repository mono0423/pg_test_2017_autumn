package jp.pgtest_autumn;

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
}
