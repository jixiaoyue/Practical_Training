package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver_Teacher;
import dataprovider.ExcelDataProvider;
import pages.LoginPage;
import pages.RewardPage;

public class RewardTest extends BaseDriver_Teacher{
	RewardPage rewardpage;	
	LoginPage loginpage;
	@DataProvider(name="text_message")
	public  Object[] getoneData(){
		return new  Object[] {
			"·¢ËÍÎÄ×Ö"
			};
	}
	@BeforeClass
	public void test00_initPage() {
		this.loginpage=new LoginPage(driver);
		this.rewardpage=loginpage.login_sucess("18732627309","123456");
		System.out.println(driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");	
	}
	//²âÊÔÓÃÀı
	@Test
	public void test01() {
		rewardpage.test1();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	@Test
	public void test02() {
		rewardpage.test2();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	@Test
	public void test03() throws InterruptedException {
		rewardpage.test3();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	@Test
	public void test04() throws InterruptedException {
		rewardpage.test4();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	@Test
	public void test05() throws InterruptedException {
		rewardpage.test5();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	@Test
	public void test06() throws InterruptedException {
		rewardpage.test6();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	@Test
	public void test07() throws InterruptedException {
		rewardpage.test7();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	@Test
	public void test08() throws InterruptedException {
		rewardpage.test8();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}
	@Test
	public void test09() throws InterruptedException {
		rewardpage.test9();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}
	@Test
	public void test10() throws InterruptedException {
		rewardpage.test10();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}
	
	@Test(dataProvider = "text_message")
	public void test11(String a) {
		rewardpage.test11(a);
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}
	@Test
	public void test12() throws InterruptedException {
		rewardpage.test12();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}
	@Test
	public void test13() throws InterruptedException {
		rewardpage.test13();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}
	@Test
	public void test14() {
		rewardpage.test14();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}@Test
	public void test15() {
		rewardpage.test15();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}@Test
	public void test16() throws InterruptedException {
		rewardpage.test16();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}@Test
	public void test17() throws InterruptedException {
		rewardpage.test17();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}@Test
	public void test18() throws InterruptedException {
		rewardpage.test18();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationActivity");
	}
	@Test
	public void test19() throws InterruptedException {
		rewardpage.test19();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationListActivity");
	}
	@Test
	public void test20() {
		rewardpage.test20();
		System.out.println(driver.currentActivity()+"ĞüÉÍ");
		assertEquals(driver.currentActivity(),".ConversationListActivity");
	}
}
