package testcases;

import static org.testng.Assert.assertEquals;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.LoginPage;
import pages.Mypage;
import pages.ParentsEditor;
import pages.ParentsListPage;
import pages.TitleEditor;

public class ParentsTest extends BaseDriver{
	ParentsEditor nateditor;
	ParentsListPage parentsListPage;
	TitleEditor TitleEditor;
	Mypage mypage;
	
	
	@BeforeClass
	public void test_login_success() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_sucess("15630137321","123456");
	}
	
	@Test
	//4、测试我的订单
	public void test01() {
		mypage=new Mypage(driver);
		mypage.click_my_orders();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	
	
	//测试12位手机号能否登录
	@Test
	public void test02() {
		mypage=new Mypage(driver);
		mypage.settings().click();
		mypage.quit().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_sucess("156301373210","123456");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".LoginWithPasswordActivity");
		
	}
	//测试不输入账号和密码能否登录
	@Test
	public void test03() {
		
		mypage=new Mypage(driver);
		mypage.settings().click();
		mypage.quit().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_sucess("","");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".LoginWithPasswordActivity");
			
		
	}
	
	//5、能否查看错题本
	@Test
	public void test04() {
		mypage=new Mypage(driver);
		mypage.error_book().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".ErrorTopicBookActivity");
		
	}
	
	
	//8、测试能否修改昵称
	@Test
	public void test05() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.nickname().click();
		mypage.input_nickname().sendKeys("王慧颖王慧颖王慧颖");
		mypage.finish().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".SelfInformationActivity");
		
	}
	//测试超过16个字母能否修改
	@Test
	public void test06() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.nickname().click();
		mypage.input_nickname().sendKeys("whywhywhywhywhywhy");
		mypage.finish().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".SelfInformationActivity");
		
		
	}
	//测试昵称能否为空
	@Test
	public void test07() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.nickname().click();
		mypage.input_nickname().sendKeys("");
		mypage.finish().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".SelfInformationActivity");
	}

	//测试30天内是否只能修改一次昵称
	@Test
	public void test08() throws InterruptedException {
		for(int i=0;i<=1;i++) {
			mypage=new Mypage(driver);
			mypage.picture().click();
			mypage.nickname().click();
			mypage.input_nickname().sendKeys("why王慧颖"+i);
			mypage.finish().click();
			Thread.sleep(3000);
			driver.navigate().back();
			}
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	//测试能否修改性别
	@Test
	public void test09() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.sex().click();
		mypage.female().click();
		mypage.finish2().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".SelfInformationActivity");
	}
	//测试能否修改手机号
	@Test
	public void test10() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.phoneNumber().click();
		mypage.edit_phoneNumber().sendKeys("13363257576");
		mypage.finish4();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".PhoneNumberActivity");
		
	}
	//能否联系我们（拨打客服热线）bug
	@Test
	public void test11() {
		mypage=new Mypage(driver);
		mypage.connectTous().click();
		mypage.hotline().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".ContactUsActivity");
	}
	
	//能否联系我们（添加官微）
	@Test
	public void test12() {
		mypage=new Mypage(driver);
		mypage.connectTous().click();
		mypage.wechat().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".ContactUsActivity");
	}
	//测试能否正常注销账号
	@Test
	public void test13() {
		mypage=new Mypage(driver);
		mypage.settings().click();
		mypage.quit().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	//测试是否30天内只能修改一次手机号
	@Test
	public void test14() throws InterruptedException {
		for(int i=0;i<=1;i++) {
			mypage=new Mypage(driver);
			mypage.picture().click();
			mypage.phoneNumber().click();
			mypage.edit_phoneNumber().sendKeys("15630137321");
			mypage.finish4().click();
			Thread.sleep(3000);
			driver.navigate().back();
		}
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	//测试能否修改手机号为12位
	@Test
	public void test15() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.phoneNumber().click();
		mypage.edit_phoneNumber().sendKeys("156301373210");
		mypage.finish4().click();
		
	}
	//测试能否修改密码
	@Test
	public void test16() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.password().click();
		mypage.edit_password().sendKeys("123456");
		mypage.finish5().click();
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".SelfInformationActivity");	
	}
	//测试30天内能否只修改一次
	@Test
	public void test17() throws InterruptedException {
		for(int i=0;i<=1;i++) {
			mypage=new Mypage(driver);
			mypage.picture().click();
			mypage.password().click();
			mypage.edit_password().sendKeys("123456");
			mypage.finish5().click();
			Thread.sleep(3000);
			driver.navigate().back();
		}
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");	
	}
	//测试只输入手机号不输入密码能否登录
	@Test
	public void test18() {
		mypage=new Mypage(driver);
		mypage.settings().click();
		mypage.quit().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_sucess("15630137321","");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".LoginWithPasswordActivity");	
	}
	//测试不输入账号只输入密码能否登录
	@Test
	public void test19() {
		mypage=new Mypage(driver);
		mypage.settings().click();
		mypage.quit().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_sucess("","123456");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".LoginWithPasswordActivity");	
	}
	//测试能否修改手机号为空
	@Test
	public void test20() {
		mypage=new Mypage(driver);
		mypage.picture().click();
		mypage.phoneNumber().click();
		mypage.edit_phoneNumber().sendKeys("");
		mypage.finish4().click();
		
	}
}

