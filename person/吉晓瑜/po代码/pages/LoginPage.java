package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class LoginPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	通过构造方法对于driver初始化；
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action= new BaseAction(driver);
	}
	public AndroidElement mine() {
		return driver.findElementById("com.example.homeworkcorrect:id/mine_text");
	}
	public AndroidElement action_login() {
		return driver.findElementById("com.example.homeworkcorrect:id/login_kip");
	}
	public AndroidElement account_password() {
		return driver.findElementById("com.example.homeworkcorrect:id/tv_login");
	}
	public AndroidElement edit_username() {
		return driver.findElementById("com.example.homeworkcorrect:id/et_numberwithpassword");
	}
	
	public AndroidElement edit_password() {
		return driver.findElementById("com.example.homeworkcorrect:id/et_password");
	}
	
	public AndroidElement btn_login() {
		return driver.findElementById("com.example.homeworkcorrect:id/bt_loginwithpass");
	}
	
	public ParentsListPage login_success(String username,String password) {
		action.click(mine());
		action.click(action_login());
		action.click(account_password());
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return new ParentsListPage(driver);
	
	}
//	
//	public String login_fail(String username,String password) {
//		action.type(edit_username(), username);
//		action.type(edit_password(), password);
//		action.click(btn_login());
//		return action.getToast();
//	
//	}
}
