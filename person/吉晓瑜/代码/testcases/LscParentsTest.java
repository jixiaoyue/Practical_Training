package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver_Parents;
import dataprovider.NSDataProvider;
import pages.LoginPage;
import pages.ParentsEditor;
import pages.ParentsListPage;

public class LscParentsTest extends BaseDriver_Parents {
	LoginPage loginPage;
	ParentsEditor editor;
	ParentsListPage parentsListPage;

	@BeforeClass
	public void test_login_success() {
		loginPage = new LoginPage(driver);
		loginPage.login_success("18831166933", "123456");
		System.out.println(driver.currentActivity());
	}

//	1��չʾ��̬
	@Test(priority = 1)
	public void test_list_dy() {
		System.out.println(driver.currentActivity());
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.show_list();
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

//	2���鿴��һ����̬��ͼƬ
	@Test(priority = 2)
	public void test_show_dy() throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		parentsListPage.show_first_dy();
		driver.navigate().back();
		System.out.println("2" + driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

//	3�����ޣ����Խ��
	@Test(priority = 3)
	public void test_like_dy() throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.show_list();
		int size1 = Integer.parseInt(editor.get_like_size());
		System.out.println("����ǰ��Ϊ��" + size1);
		editor.give_like();
		int size2 = Integer.parseInt(editor.get_like_size());
		System.out.println("���޺���Ϊ��" + size2);
		assertEquals(size1 + 1, size2);
		Thread.sleep(1000);
	}

//	4��ȡ�����ޣ����Խ��
	@Test(priority = 4)
	public void test_unlike_dy() throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.show_list();
		int size1 = Integer.parseInt(editor.get_like_size());
		System.out.println("����ǰ��Ϊ��" + size1);
		editor.cancel_like();
		int size2 = Integer.parseInt(editor.get_like_size());
		System.out.println("���޺���Ϊ��" + size2);
		assertEquals(size1 - 1, size2);
		Thread.sleep(1000);
	}

//	5���������Խ��
	@Test(priority = 5)
	public void test_share_dy() throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.show_list();
		int size1 = Integer.parseInt(editor.get_share_size());
		System.out.println("����ǰ��Ϊ��" + size1);
		editor.give_share();
		int size2 = Integer.parseInt(editor.get_share_size());
		System.out.println("�������Ϊ��" + size2);
		assertEquals(size1 + 1, size2);
		Thread.sleep(1000);
	}

//	6��ȡ���������Խ��
	@Test(priority = 6)
	public void test_unshare_dy() throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.show_list();
		int size1 = Integer.parseInt(editor.get_share_size());
		System.out.println("����ǰ��Ϊ��" + size1);
		editor.cancel_share();
		int size2 = Integer.parseInt(editor.get_share_size());
		System.out.println("�������Ϊ��" + size2);
		assertEquals(size1 - 1, size2);
		Thread.sleep(1000);
	}

//	7���������
	@Test(priority = 7)
	public void test_discuss_dy() throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.show_list();

		int size1 = Integer.parseInt(editor.get_comment_size());
		System.out.println("����ǰ��Ϊ��" + size1);
		editor.give_comment();
		int size2 = Integer.parseInt(editor.get_comment_size());
		System.out.println("���ۺ���Ϊ��" + size2);
//		����
		assertEquals(size1 + 1, size2);
		Thread.sleep(1000);
	}

//	8����������+ͼƬ��̬������)
	@Test(priority = 8, dataProvider = "words", dataProviderClass = NSDataProvider.class)
	public void test_inert_dy(String words) throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.add();
		Thread.sleep(3000);
		editor.inset_dynamic(words);
		Thread.sleep(6000);
		System.out.println("8" + driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");

	}

//	9����������+3��ͼƬ��̬
	@Test(priority = 9, dataProvider = "photos", dataProviderClass = NSDataProvider.class)
	public void test_inert_dys(String photos) throws InterruptedException {
		parentsListPage = new ParentsListPage(driver);
		editor = parentsListPage.add();
		Thread.sleep(1000);
		editor.inset_three_phtoto(photos);
		Thread.sleep(3000);
		System.out.println("9����������+3��ͼƬ��̬" + driver.currentActivity());
		assertEquals(driver.currentActivity(), ".MainActivity");
	}

//	16��̬ cameraͼƬ+screenshotͼƬԤ��
//	@Test(priority = 16)
//	public void test_pre_cs() throws InterruptedException {
//		parentsListPage =new ParentsListPage(driver);
//		editor=parentsListPage.add();
//		Thread.sleep(3000);
//		editor.preview_cs();
//		Thread.sleep(3000);
//		System.out.println("Ԥ��"+driver.currentActivity());
//	}
////	17Ԥ���µ����һ���
//	@Test(priority = 17)
//	public void test_pre_swipe_cs() throws InterruptedException {
////		���һ���
//		editor.photo_check();
//		System.out.println("���һ���"+driver.currentActivity());
//		assertEquals(driver.currentActivity(),"com.zhihu.matisse.internal.ui.SelectedPreviewActivity");
//	}
////	18��Ԥ��״����ʵ��ȡ��ѡ��
//	@Test(priority = 18)
//	public void test_pre_choose_cs() throws InterruptedException {
////		���һ���
//		editor.photo_choose();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		System.out.println("ȡ��ѡ��"+driver.currentActivity());
//		assertEquals(driver.currentActivity(),".launcher3.Launcher");
//	}
//	
//	
////	19����̬ cameraͼƬ+screenshotͼƬ
//	@Test(priority = 19)
//	public void test_inert_cs() throws InterruptedException {
//		parentsListPage =new ParentsListPage(driver);
//		editor=parentsListPage.add();
//		Thread.sleep(3000);
//		editor.inset_cs("ѡ��camera+screenshotͼƬ");
//		Thread.sleep(3000);
//	}
////	
////	
////	20��������+ͼƬ��̬ ѡ��->ȡ��ѡ��ͼƬ
//	@Test(priority = 20)
//	public void test_inert_cancel() throws InterruptedException {
//		parentsListPage =new ParentsListPage(driver);
//		editor=parentsListPage.add();
//		Thread.sleep(3000);
//		editor.inset_dynamic_cansel("ȡ��ѡ��ͼƬ");
//		Thread.sleep(3000);
//	}
////	21����������
//	@Test(priority = 21)
//	public void test_inert_words() throws InterruptedException {
//		parentsListPage =new ParentsListPage(driver);
//		editor=parentsListPage.add();
//		Thread.sleep(3000);
//		editor.inset_dynamic_words("����������");
//		Thread.sleep(3000);
//	}
//	
////	22������ͼƬ
//	@Test(priority = 22)
//	public void test_inert_only_phtos() throws InterruptedException {
//		
//		parentsListPage =new ParentsListPage(driver);
//		editor=parentsListPage.add();
//		Thread.sleep(3000);
//		editor.inset_dynamic_photos();
//		Thread.sleep(6000);
//	}

}
