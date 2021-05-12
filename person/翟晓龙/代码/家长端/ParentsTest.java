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

	// δ��½�����������Ʒʧ��
	@Test
	public void test01() throws InterruptedException {
		mallPage = new MallPage(driver);
		mallPage.mall().click();
		mallPage.search().sendKeys("����");
		mallPage.btn_search().click();
		Thread.sleep(3000);
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

//		δ��½����´���Ʒ�����빺�ﳵ(û�н������ҳ��)
	@Test
	public void test02() throws InterruptedException {
		mallPage = new MallPage(driver);
		mallPage.mall().click();
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.shopping_Cart().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// ˵�����ڴ�ҳ��
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// δ��½����´���Ʒ����������(û�н������ҳ��)
	@Test
	public void test03() throws InterruptedException {
		mallPage = new MallPage(driver);
		mallPage.mall().click();
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.purchase().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// ˵�����ڴ�ҳ��
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// ��½�����������Ʒʧ��
	@Test
	public void test04() throws InterruptedException {
		login_parents();
		mallPage.search().sendKeys("����");
		mallPage.btn_search().click();
		Thread.sleep(3000);
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

	// ��ѵ�����Ƽ�
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

//	��½����´���Ʒ�����빺�ﳵ(û�н������ҳ��)
	@Test
	public void test06() throws InterruptedException {
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.shopping_Cart().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// ˵�����ڴ�ҳ��
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// ��½����´���Ʒ����������(û�н������ҳ��)
	@Test
	public void test07() throws InterruptedException {
		mallPage.commodity().click();
		Thread.sleep(3000);
		mallPage.purchase().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ShowBookInfoActivity");// ˵�����ڴ�ҳ��
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
	 * ʵ��һ������ͨ�õ����»����ķ���
	 */
	public void swipeDown() {
		// ����Ļ�Ŀ�͸���������������ʼ�����ֹ��
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		// ���»���
		TouchAction touchAction = new TouchAction(driver);
		// press����ѹĳһ������ moveTo:������ĳһ���� release:��ָ���ͷ�
		// ��������ʼ������
		PointOption pointOption1 = PointOption.point(width / 2, height * 3 / 4);
		// ��������ֹ������
		PointOption pointOption2 = PointOption.point(width / 2, height / 6);
		// waitAction������Ҫ����waitOption���͵Ĳ���
		Duration duration = Duration.ofMillis(1000);
		WaitOptions waitOptions = WaitOptions.waitOptions(duration);
		touchAction.press(pointOption1).waitAction(waitOptions).moveTo(pointOption2).release().perform();
	}
}
