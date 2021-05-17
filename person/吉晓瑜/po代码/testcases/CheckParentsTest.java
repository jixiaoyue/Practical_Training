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
//	10���ڼҳ�Ȧ�鿴��̬��ͼƬ
	@Test(priority = 10)
	public void test_show_photo_dy() throws InterruptedException {
		parentsListPage=new ParentsListPage(driver);
		parentsListPage.show_list();
		parentsListPage.show_dy_first_photo();
		driver.navigate().back();
		System.out.println("10�ڼҳ�Ȧ�鿴��̬��ͼƬ"+driver.currentActivity());
		assertEquals(driver.currentActivity(),".MainActivity");
	}
	
//	11���ڼҳ�Ȧ�鿴��̬ʱ���һ���ͼƬ
	@Test(priority = 11)
	public void test_shows_dy() throws InterruptedException {
		parentsListPage=new ParentsListPage(driver);
		parentsListPage.show_list();
		parentsListPage.show_dy_first_photo();
		parentsListPage.photo_check();
		driver.navigate().back();
		System.out.println("11���ڼҳ�Ȧ�鿴��̬ʱ���һ���ͼƬ");
	}
//	12������̬ʱ->Ԥ����һ��ͼƬ
	@Test(priority = 12)
	public void test_priew_photo() throws InterruptedException {
		System.out.println("12������̬ʱ->Ԥ����һ��ͼƬ");
		parentsListPage =new ParentsListPage(driver);
		editor=parentsListPage.add();
		Thread.sleep(3000);
		editor.photo_preview();
		Thread.sleep(3000);
	}
//	13������̬ʱ->Ԥ������ͼƬ
	@Test(priority = 13)
	public void test_priew_back_photo() throws InterruptedException {
		System.out.println("13������̬ʱ->Ԥ������ͼƬ");
		Thread.sleep(3000);
		System.out.println("����ͼƬ");
		editor.photo_back();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
	}
//	14,����̬ʱ->Ԥ��3��ͼƬ
	@Test(priority = 14)
	public void test_priew_photos() throws InterruptedException {
		System.out.println("14,����̬ʱ->Ԥ��3��ͼƬ");
		Thread.sleep(3000);
		editor.photo_previews();
		Thread.sleep(3000);
	}
//	15������̬ʱ->Ԥ��3��ͼƬ->���һ���
	@Test(priority = 15)
	public void test_priew_swipe_photos() throws InterruptedException {
		Thread.sleep(3000);
//		���һ���
		editor.photo_check();
		Thread.sleep(3000);
		editor.photo_back();
		driver.navigate().back();
		System.out.println("3ͼ���һ����ɹ�");
		driver.navigate().back();
		driver.navigate().back();
		System.out.println("���سɹ�");
		Thread.sleep(3000);
	}
}
