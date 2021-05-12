package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.CorrectionPage;
import pages.LoginPage;
import pages.ParentsEditor;
import pages.ParentsListPage;
import pages.TitleEditor;
import utils.ReadProperties;

public class CorrectionTest extends BaseDriver{
	ParentsEditor nateditor;
	ParentsListPage parentsListPage;
	TitleEditor TitleEditor;
	
	
	@BeforeClass
	public void test_login_success() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_sucess("15128985756","123456");	
	}
	
//	//数据驱动
//	@Test
//	public void test01() throws IOException {
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.login_sucess(ReadProperties.getPropertyValue("username"),ReadProperties.getPropertyValue("password"));	
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
//	//相册单张上传(存在的图片)
//	@Test
//	public void test02() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbum1Submit(1);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
//	//相册单张上传(存在的图片)
//	@Test
//	public void test03() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbum1Submit(9);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//相册单张上传(不选中图片)
//	@Test
//	public void test04() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbum0Submit();
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//相册上传(多选)
//	@Test
//	public void test05() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbumsSubmit(1,3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
//	//相册上传(多选)bug(9张上传软件崩溃，界面错乱)
//	@Test
//	public void test06() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbumsSubmit(1,9);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//相册上传(多选)
//	@Test
//	public void test07() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbumsSubmit(3,3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}	
	
//	//相册上传(选中一张，然后删除后，上传，上传成功)
//	@Test
//	public void test08(){
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbum1DeleteSubmit(2);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//相册上传(选中多张，然后删除，剩余一张上传，上传成功)
//	@Test
//	public void test09(){
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbumsDeleteSubmit(3, 3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//相册上传(选中多张，然后删除，剩余一张上传，上传成功)
//	@Test
//	public void test10(){
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.photoAlbumsDeleteAllSubmit(3, 3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//查看信息
//	@Test
//	public void test11() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.viewMessage(3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//多次查看信息
//	@Test
//	public void test12() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.SomeviewMessage(1, 3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//查看信息,回复信息
//	@Test
//	public void test13() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.ReplyMessage(3, "谢谢老师，老师辛苦了");
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//多次查看信息,回复信息
//	@Test
//	public void test14() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.SomereplyMessage(1,3, "谢谢老师，老师辛苦了");
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//置顶消息
//	@Test
//	public void test15() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.TopMessage(3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//多次置顶消息
//	@Test
//	public void test16() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.SomeTopMessage(2);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//单次取消置顶消息
//	@Test
//	public void test17() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.TopMessage(1);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//多次取消置顶消息
//	@Test
//	public void test18() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.CancelTopMessage(2);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
//	//删除消息
//	@Test
//	public void test19() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.DeleteMessage(3);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}

//	//多次删除消息
//	@Test
//	public void test20() {
//		CorrectionPage  correctionPage = new CorrectionPage(driver);
//		correctionPage.DeleteSomeMessage(1,2);
//		String result = driver.currentActivity();
//		assertEquals(driver.currentActivity(),result);
//	}
	
}
