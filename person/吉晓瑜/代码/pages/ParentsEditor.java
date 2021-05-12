//NoteEditor��
package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class ParentsEditor {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

//	���췽��
	public ParentsEditor(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);

	}	
	
	public AndroidElement edit_content() {
		return driver.findElementById("com.example.homeworkcorrect:id/ss_edit_content");
	}

	public AndroidElement photo_add() {
		return driver.findElementById("com.example.homeworkcorrect:id/main_gridView_item_photo");
	}
	public AndroidElement photo_save() {
		return driver.findElementById("com.example.homeworkcorrect:id/button_apply");
	}
	
	public AndroidElement btn_save() {
		return driver.findElementById("com.example.homeworkcorrect:id/ss_send");
	}
//	Ԥ��
	public AndroidElement preview() {
		return driver.findElementById("com.example.homeworkcorrect:id/button_preview");
	}
//	ʹ��
	public AndroidElement apply() {
		return driver.findElementById("com.example.homeworkcorrect:id/button_apply");
	}
//	ȡ��Ԥ��
	public AndroidElement btn_back() {
		return driver.findElementById("com.example.homeworkcorrect:id/button_back");
	}
//	ͼƬ·��
	public AndroidElement route() {
		return driver.findElementById("com.example.homeworkcorrect:id/selected_album");
	}
//	��ͼ
	public AndroidElement get_route_list() {
		return  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout");
	}
	public List<MobileElement> get_route_view(){
		return get_route_list().findElementsByClassName( "android.widget.RelativeLayout");
	}
//	Camera
	public AndroidElement camera() {
		return  driver.findElementByLinkText("Camera");
	}
//	��ͼѡ��
	public AndroidElement choose() {
		return driver.findElementById("com.example.homeworkcorrect:id/top_toolbar");
	}
	
	
	public AndroidElement get_photo_view() {
		return driver.findElementById("com.example.homeworkcorrect:id/recyclerview");
		
	}
	public List<MobileElement> get_photo_view2(){
		return get_photo_view().findElementsByClassName( "android.view.View");
	}
//	����Ԫ��
	public AndroidElement like() {
		return 	driver.findElementById("com.example.homeworkcorrect:id/fre_like_one");		
	}
	public AndroidElement like_size() {
		return driver.findElementById("com.example.homeworkcorrect:id/fre_like_size");
	}
//	����Ԫ��
	public AndroidElement share() {
		return 	driver.findElementById("com.example.homeworkcorrect:id/fre_forward");		
	}
	public AndroidElement share_size() {
		return driver.findElementById( "com.example.homeworkcorrect:id/fre_forward_size");
	}
//	����Ԫ��
	public AndroidElement comment() {
		return 	driver.findElementById(	"com.example.homeworkcorrect:id/fre_comment");		
	}
	public AndroidElement comment_size() {
		return driver.findElementById( "com.example.homeworkcorrect:id/fre_comment_size");
	}
	
	
	
//	ҳ�淽��
//	������
	public String get_like_size() {
		return like_size().getAttribute("text");
	}
//	������
	public String get_share_size() {
		return share_size().getAttribute("text");
	}
//	������
	public String get_comment_size() {
		return comment_size().getAttribute("text");
	}
	
//	��õ�һ��ͼƬ
	public MobileElement get_photo_first() {
		List<MobileElement> list_view=get_photo_view2();
		int count = list_view.size();
		if (count > 0) {
			return list_view.get(0);
		}
		return null;

	}
//	�����ͼ���
	public MobileElement get_screen_view_first() {
		List<MobileElement> list_view=get_route_view();
		System.out.println(list_view.isEmpty());
		int count = list_view.size();
		if (count > 0) {
//			�б�text=1
			return list_view.get(1);
		}
		
		return null;
	}
//	���camera���
	public MobileElement get_camera_view_first() {
		List<MobileElement> list_view=get_route_view();
		System.out.println(list_view.isEmpty());
		int count = list_view.size();
		if (count > 0) {
//			�б�text=2
			return list_view.get(2);
		}
		return null;
	}
//	���ͼƬ��
	public int get_photo_num() {
		AndroidElement listView = driver.findElementById("com.example.homeworkcorrect:id/recyclerview");
		List<MobileElement> list_view = listView.findElementsByClassName( "android.view.View");
		int count = list_view.size();
		
		return count;
	}
//	���ޣ���������
	public void give_like() {
		action.click(like());
	}
	public void cancel_like() {
		action.click(like());
	}
	public void give_share() {
		action.click(share());
	}
	public void cancel_share() {
		action.click(share());
	}
	public void give_comment() {
		action.click(comment());
	}
//	��ͼ״̬��ȡ��ѡ��
	public void photo_choose() {
		action.click(choose());
		action.click(photo_save());
	}
	
//	��������+��̬����
	public void inset_dynamic(String message) {
		action.type(edit_content(), message);
		action.click(photo_add());
//		��ӵ�һ��ͼƬ
		action.click(get_photo_first());
		action.click(photo_save());
		action.click(btn_save());
	}
//	�������ֶ�̬
	public void inset_dynamic_words(String message) {
		action.type(edit_content(), message);
		action.click(btn_save());
	}
	
//	Ԥ��camera+screenshot
	public void preview_cs() {
		action.click(photo_add());
		action.click(route());
		
		action.click(get_screen_view_first());
		action.click(get_photo_first());
		
		action.click(route());
		action.click(get_camera_view_first());
		action.click(get_photo_first());
		
		action.click(preview());
	}
	
	
//	����camera+screenshot
	public void inset_cs(String message) {
		action.type(edit_content(), message);
		action.click(photo_add());
		action.click(route());

		action.click(get_screen_view_first());
		action.click(get_photo_first());
		
		action.click(route());
		action.click(get_camera_view_first());
		action.click(get_photo_first());
		action.click(photo_save());
		action.click(btn_save());
	}
	
	
	
//	����̬ ѡ��ͼƬ->ȡ��ͼƬ->ѡ��ͼƬ
	public void inset_dynamic_cansel(String message) {
		action.type(edit_content(), message);
		action.click(photo_add());
//		��ӵ�һ��ͼƬ
		action.click(get_photo_first());
		action.click(get_photo_first());
		action.click(get_photo_first());
		action.click(photo_save());
		
		action.click(btn_save());
	}
//	��ͼƬ��̬
	public void inset_dynamic_photos() {
		action.click(photo_add());
		action.click(get_photo_first());
		action.click(photo_save());
		action.click(btn_save());
	}
//	��������+����ͼƬ
	public void inset_three_phtoto(String message) {
		action.type(edit_content(), message);
		action.click(photo_add());
		List<MobileElement> list_view=get_photo_view2();
		int count = list_view.size();
		for (int i = 2; i >= 0&&count>i; i--) {
			action.click(list_view.get(i));
		}
		action.click(photo_save());
		
		action.click(btn_save());
	}
//	Ԥ��
	public void photo_preview() {
		action.click(photo_add());
		action.click(get_photo_first());
		action.click(preview());
	}
	
	public void photo_previews() {
		action.click(photo_add());
		List<MobileElement> list_view=get_photo_view2();
		int count = list_view.size();
		for (int i = 2; i >= 0&&count>i; i--) {
			action.click(list_view.get(i));
		}
		action.click(preview());
		
	}
	
	
	public void photo_check() throws InterruptedException {
		action.SwipeLeft();
		Thread.sleep(1000);
		action.SwipeRight();
		
	}
	public void photo_back() {
		action.click(btn_back());
	}
	
	



	


}
