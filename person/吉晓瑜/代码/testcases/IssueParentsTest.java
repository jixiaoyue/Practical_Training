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
	

//	16��̬ cameraͼƬ+screenshotͼƬԤ��
	@Test(priority = 16)
	public void test_pre_cs() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.preview_cs();
		Thread.sleep(3000);
		System.out.println("Ԥ��"+driver.currentActivity());
	}
//	17Ԥ���µ����һ���
	@Test(priority = 17)
	public void test_pre_swipe_cs() throws InterruptedException {
//		���һ���
		editor.photo_check();
		System.out.println("���һ���"+driver.currentActivity());
		assertEquals(driver.currentActivity(),"com.zhihu.matisse.internal.ui.SelectedPreviewActivity");
	}
//	18��Ԥ��״����ʵ��ȡ��ѡ��
	@Test(priority = 18)
	public void test_pre_choose_cs() throws InterruptedException {
//		���һ���
		editor.photo_choose();
		Thread.sleep(1000);
		driver.navigate().back();
		System.out.println("ȡ��ѡ��"+driver.currentActivity());
		assertEquals(driver.currentActivity(),".launcher3.Launcher");
	}
	
	
//	19����̬ cameraͼƬ+screenshotͼƬ
	@Test(priority = 19)
	public void test_inert_cs() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_cs("ѡ��camera+screenshotͼƬ");
		Thread.sleep(3000);
	}
//	
//	
//	20��������+ͼƬ��̬ ѡ��->ȡ��ѡ��ͼƬ
	@Test(priority = 20)
	public void test_inert_cancel() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_dynamic_cansel("ȡ��ѡ��ͼƬ");
		Thread.sleep(3000);
	}
//	21����������
	@Test(priority = 21)
	public void test_inert_words() throws InterruptedException {
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_dynamic_words("����������");
		Thread.sleep(3000);
	}
	
//	22������ͼƬ
	@Test(priority = 22)
	public void test_inert_only_phtos() throws InterruptedException {
		
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_dynamic_photos();
		Thread.sleep(6000);
	}
	


}
