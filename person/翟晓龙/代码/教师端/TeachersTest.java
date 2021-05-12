package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver_Teachers;
import dataProvider.ExcelDataProvider;
import pages.LoginPage;
import pages.MinePage;

public class TeachersTest extends BaseDriver_Teachers {
	LoginPage loginPage;
	MinePage minePage;
	ExcelDataProvider excelDataProvider;
	// 登陆不输入密码
	@Test
	public void test01() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_fail("15533676833","");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".LoginWithPasswordActivity");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
	}
	// 登陆输入错误密码
	@Test
	public void test02() throws InterruptedException, IOException {
		Object[][] data=getData();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_fail(data[0][0].toString(), data[0][1].toString());
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".LoginWithPasswordActivity");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 登陆输入错误账号
	@Test
	public void test03() throws InterruptedException, IOException {
		Object[][] data=getData();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_fail(data[1][0].toString(), data[1][1].toString());
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".LoginWithPasswordActivity");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
	}

// 登陆不输入账号
	@Test
	public void test04() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_fail("", "123456");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".LoginWithPasswordActivity");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 登陆输入错误的账号密码
	@Test
	public void test05() throws InterruptedException, IOException {
		Object[][] data=getData();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_fail(data[2][0].toString(), data[2][1].toString());
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".LoginWithPasswordActivity");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 登陆不输入账号和密码
	@Test
	public void test06() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_fail("", "");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".LoginWithPasswordActivity");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 登陆成功
	@Test
	public void test07() throws IOException {
		Object[][] data=getData();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_success("15533676833","123456");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

	// 查看我的钱包
	@Test
	public void test08() throws InterruptedException {
		minePage = new MinePage(driver);
		minePage.myWallet().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MyWallet");
		Thread.sleep(1000);
		driver.navigate().back();
	}

	// 进行中->继续批改
	@Test
	public void test09() throws InterruptedException {
		minePage = new MinePage(driver);
		minePage.conduct().click();
		minePage.correction().click();// 进入页面
		Thread.sleep(1000);
		minePage.submit().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".CorrectingHomeworkDetailActivity");
		minePage.but_ok().click();
	}

	// 进行中->继续批改并添加评论
	@Test
	public void test10() throws InterruptedException {
		minePage = new MinePage(driver);
		minePage.mine().click();
		minePage.conduct().click();
		minePage.correction().click();// 进入页面
		Thread.sleep(1000);
		minePage.correct().sendKeys("真不错！");
		minePage.submit().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".CorrectingHomeworkDetailActivity");
		minePage.but_ok().click();
	}

	// 已完成->查看批改详情
	@Test
	public void test11() throws InterruptedException {
		minePage = new MinePage(driver);
		minePage.mine().click();
		minePage.completed().click();
		minePage.detail().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".FinishedHomeworkDetailActivity");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
	}

//	// 联系我们->添加官微
	@Test
	public void test12() throws InterruptedException {
		minePage = new MinePage(driver);
		minePage.contactus().click();
		minePage.wechat().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".ContactUsActivity");
		Thread.sleep(1000);
		driver.navigate().back();
	}

//	// 设置->注销账号（失败）
	@Test
	public void test13() throws InterruptedException {
		minePage = new MinePage(driver);
		minePage.setting().click();
		minePage.logoff().click();
		Thread.sleep(3000);
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}
	
	
	//登录功能
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.mine().click();
		loginPage.btn_loginClick().click();
		loginPage.btn_pwd().click();
		loginPage.login_success("15533676833", "123456");
	}
	
	//获取数据功能
	public Object[][] getData() throws IOException {
		excelDataProvider=new ExcelDataProvider();
		return excelDataProvider.getTestDataByExcel("C:\\Users\\74083\\Desktop\\data.xls", "Sheet1"); 
	}
}
