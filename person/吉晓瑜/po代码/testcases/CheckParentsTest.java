package testcases;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver_Parents;
import dataprovider.NSDataProvider;
import pages.LoginPage;
import pages.ParentsEditor;
import pages.ParentsListPage;


public class CheckParentsTest extends BaseDriver_Parents {
	LoginPage loginPage;
	ParentsEditor editor;
	ParentsListPage parentsListPage;
	
	
	@BeforeClass
	public void test_login_success() {
		loginPage=new LoginPage(driver);
		loginPage.login_success("18831166933","123456");
		System.out.println(driver.currentActivity());
	}
//	10，在家长圈查看动态的图片
	@Test(priority = 10)
	public void test_show_photo_dy() throws InterruptedException {
		parentsListPage=new ParentsListPage(driver);
		parentsListPage.show_list();
		parentsListPage.show_dy_first_photo();
		driver.navigate().back();
		System.out.println("10在家长圈查看动态的图片"+driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	
//	11，在家长圈查看动态时左右滑动图片
	@Test(priority = 11)
	public void test_shows_dy() throws InterruptedException {
		parentsListPage=new ParentsListPage(driver);
		parentsListPage.show_list();
		parentsListPage.show_dy_first_photo();
		parentsListPage.photo_check();
		driver.navigate().back();
		System.out.println("11，在家长圈查看动态时左右滑动图片");
	}
//	12，发表动态时->预览第一个图片
	@Test(priority = 12)
	public void test_priew_photo() throws InterruptedException {
		System.out.println("12，发表动态时->预览第一个图片");
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.photo_preview();
		Thread.sleep(3000);
	}
//	13，发表动态时->预览返回图片
	@Test(priority = 13)
	public void test_priew_back_photo() throws InterruptedException {
		System.out.println("13，发表动态时->预览返回图片");
		Thread.sleep(3000);
		System.out.println("返回图片");
		editor.photo_back();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
	}
//	14,发表动态时->预览3张图片
	@Test(priority = 14)
	public void test_priew_photos() throws InterruptedException {
		System.out.println("14,发表动态时->预览3张图片");
		Thread.sleep(3000);
		editor.photo_previews();
		Thread.sleep(3000);
	}
//	15，发表动态时->预览3张图片->左右滑动
	@Test(priority = 15)
	public void test_priew_swipe_photos() throws InterruptedException {
		Thread.sleep(3000);
//		左右滑动
		editor.photo_check();
		Thread.sleep(3000);
		editor.photo_back();
		driver.navigate().back();
		System.out.println("3图左右滑动成功");
		driver.navigate().back();
		driver.navigate().back();
		System.out.println("返回成功");
		Thread.sleep(3000);
	}
}
