package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver_Parents;
import pages.LoginPage;
import pages.ParentsEditor;
import pages.ParentsListPage;

public class IssueParentsTest extends BaseDriver_Parents{
	LoginPage loginPage;
	ParentsEditor editor;
	ParentsListPage parentsListPage;
	
	
	@BeforeClass
	public void test_login_success() {
		loginPage=new LoginPage(driver);
		loginPage.login_success("18831166933","123456");
		System.out.println(driver.currentActivity());
	}
	

//	16动态 camera图片+screenshot图片预览
	@Test(priority = 16)
	public void test_pre_cs() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.preview_cs();
		Thread.sleep(3000);
		System.out.println("预览"+driver.currentActivity());
	}
//	17预览下的左右滑动
	@Test(priority = 17)
	public void test_pre_swipe_cs() throws InterruptedException {
//		左右滑动
		editor.photo_check();
		System.out.println("左右滑动"+driver.currentActivity());
		assertEquals(driver.currentActivity(),"com.zhihu.matisse.internal.ui.SelectedPreviewActivity");
	}
//	18在预览状况下实现取消选中
	@Test(priority = 18)
	public void test_pre_choose_cs() throws InterruptedException {
//		左右滑动
		editor.photo_choose();
		Thread.sleep(1000);
		driver.navigate().back();
		System.out.println("取消选中"+driver.currentActivity());
		assertEquals(driver.currentActivity(),".launcher3.Launcher");
	}
	
	
//	19发表动态 camera图片+screenshot图片
	@Test(priority = 19)
	public void test_inert_cs() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_cs("选中camera+screenshot图片");
		Thread.sleep(3000);
	}
//	
//	
//	20发表文字+图片动态 选中->取消选中图片
	@Test(priority = 20)
	public void test_inert_cancel() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_dynamic_cansel("取消选中图片");
		Thread.sleep(3000);
	}
//	21仅发表文字
	@Test(priority = 21)
	public void test_inert_words() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_dynamic_words("仅发表文字");
		Thread.sleep(3000);
	}
	
//	22仅发表图片
	@Test(priority = 22)
	public void test_inert_only_phtos() throws InterruptedException {
		
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_dynamic_photos();
		Thread.sleep(6000);
	}
	


}
