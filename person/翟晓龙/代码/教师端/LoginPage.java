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
	
	//我的
	public AndroidElement mine() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/mine_img");
	}
	//点击登录按钮
	public AndroidElement btn_loginClick() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/login_kip");
	}
	//账号密码登录按钮
	public AndroidElement btn_pwd() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/tv_login");
	}
	public AndroidElement edit_username() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/et_numberwithpassword");
	}
	
	public AndroidElement edit_password() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/et_password");
	}
	
	public AndroidElement btn_login() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/bt_loginwithpass");
	}
	
	public MainPage login_success(String username,String password) {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return new MainPage(driver);
	
	}
	
	public String login_fail(String username,String password) {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return action.getToast();
	
	}
}
