package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseDriver_Parents;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.LoginPage;
import pages.MallPage;
import pages.ParentsEditor;
import pages.ParentsListPage;
import pages.TitleEditor;

public class ParentsTest extends BaseDriver_Parents {
	ParentsEditor nateditor;
	ParentsListPage parentsListPage;
	TitleEditor TitleEditor;
	MallPage mallPage;

	// 未登陆情况下搜索商品失败
	@Test
	public void test01() throws InterruptedException {
		mallPage = new MallPage(driver);
		mallPage.mall().click();
		mallPage.search().sendKeys("计算");
		mallPage.btn_search().click();
		Thread.sleep(3000);
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

//		未登陆情况下打开商品并加入购物车(没有进入相关页面)
	@Test
	public void test02() throws InterruptedException {
		mallPage = new MallPage(driver);
		mallPage.mall().click();
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.shopping_Cart().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// 说明还在此页面
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 未登陆情况下打开商品并立即购买(没有进入相关页面)
	@Test
	public void test03() throws InterruptedException {
		mallPage = new MallPage(driver);
		mallPage.mall().click();
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.purchase().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// 说明还在此页面
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 登陆情况下搜索商品失败
	@Test
	public void test04() throws InterruptedException {
		login_parents();
		mallPage.search().sendKeys("计算");
		mallPage.btn_search().click();
		Thread.sleep(3000);
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

	// 培训机构推荐
	@Test
	public void test05() throws InterruptedException {
		mallPage.search().click();
		swipeDown();
		mallPage.institutions().click();
		Thread.sleep(3000);
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowSchoolInfoActivity");
		Thread.sleep(1000);
		driver.navigate().back();
	}

//	登陆情况下打开商品并加入购物车(没有进入相关页面)
	@Test
	public void test06() throws InterruptedException {
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.shopping_Cart().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// 说明还在此页面
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 登陆情况下打开商品并立即购买(没有进入相关页面)
	@Test
	public void test07() throws InterruptedException {
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.purchase().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// 说明还在此页面
		Thread.sleep(1000);
		driver.navigate().back();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void login_parents() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login_success("15533676833", "123456");
		mallPage = new MallPage(driver);
		mallPage.mall().click();
	}

	/*
	 * 实现一个更加通用的向下滑动的方法
	 */
	public void swipeDown() {
		// 由屏幕的宽和高来决定滑动的起始点和终止点
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		// 向下滑动
		TouchAction touchAction = new TouchAction(driver);
		// press：按压某一个坐标 moveTo:滑动到某一个点 release:手指的释放
		// 滑动的起始点坐标
		PointOption pointOption1 = PointOption.point(width / 2, height * 3 / 4);
		// 滑动的终止点坐标
		PointOption pointOption2 = PointOption.point(width / 2, height / 6);
		// waitAction方法需要传入waitOption类型的参数
		Duration duration = Duration.ofMillis(1000);
		WaitOptions waitOptions = WaitOptions.waitOptions(duration);
		touchAction.press(pointOption1).waitAction(waitOptions).moveTo(pointOption2).release().perform();
	}
}
