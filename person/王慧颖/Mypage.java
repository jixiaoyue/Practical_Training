package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class Mypage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	public Mypage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action= new BaseAction(driver);
	}


	//我的订单
		public AndroidElement my_orders() {
			
			return driver.findElementById("com.example.homeworkcorrect:id/my_order");
		}
		//设置
		public AndroidElement settings() {
			return driver.findElementById("com.example.homeworkcorrect:id/setting");
		}
		//注销账号
		public AndroidElement quit() {
			return driver.findElementById("com.example.homeworkcorrect:id/logoff");
		}
		
		//错题本
		public AndroidElement error_book() {
			return driver.findElementById("com.example.homeworkcorrect:id/error_book");
		}
		//头像区域
		public AndroidElement picture() {
			return driver.findElementById("com.example.homeworkcorrect:id/image_user");
		}
		//头像
		public AndroidElement image() {
			return driver.findElementById("com.example.homeworkcorrect:id/change_img");
		}
		//
		//昵称
		public AndroidElement nickname() {
			return driver.findElementById("com.example.homeworkcorrect:id/change_nickname");
		}
		//输入昵称
		public AndroidElement input_nickname() {
			return driver.findElementById("com.example.homeworkcorrect:id/et_nickname");
		}
		//完成
		public AndroidElement finish() {
			return driver.findElementById("com.example.homeworkcorrect:id/bt_finish");
		}
		//性别
		public AndroidElement sex() {
			return driver.findElementById("com.example.homeworkcorrect:id/change_sex");
		}
		//女
		public AndroidElement female() {
			return driver.findElementById("com.example.homeworkcorrect:id/rb_2");
		}
		//完成
		public AndroidElement finish2() {
			return driver.findElementById("com.example.homeworkcorrect:id/bt_finish2");
		}
		//手机号
		public AndroidElement phoneNumber() {
			return driver.findElementById("com.example.homeworkcorrect:id/tv_phonenum");
		}
		//修改手机号
		public AndroidElement edit_phoneNumber() {
			return driver.findElementById("com.example.homeworkcorrect:id/et_phonenumber");
			
		}
		//完成
		public AndroidElement finish4() {
			return driver.findElementById("com.example.homeworkcorrect:id/bt_finish4");
		}
		//将作业批推荐给好友
		public AndroidElement shareTofriends() {
			return driver.findElementById("com.example.homeworkcorrect:id/recommend");
		}
		  //save as...
		public AndroidElement save_as() {
			return driver.findElementById("");
		}
		  //蓝牙
		public AndroidElement bluetooth() {
			return driver.findElementById("");
		}
		
		//我的积分
		//联系我们
		public AndroidElement connectTous() {
			return driver.findElementById("com.example.homeworkcorrect:id/contactUs");
			
		}
		//拨打客服热线
		public AndroidElement hotline() {
			return driver.findElementById("com.example.homeworkcorrect:id/callUsText");
		}
		//添加官微
		public AndroidElement wechat() {
			return driver.findElementById("com.example.homeworkcorrect:id/wechatText");
		}
		//密码
		public AndroidElement password() {
			return driver.findElementById("com.example.homeworkcorrect:id/change_password");
		}
		//输入密码
		public AndroidElement edit_password() {
			return driver.findElementById("com.example.homeworkcorrect:id/et_password");
		}
		//完成
		public AndroidElement finish5() {
			return driver.findElementById("com.example.homeworkcorrect:id/bt_finish4");
		}
		
		
		
		//、点击我的“我的订单”
		public ParentsEditor click_my_orders() {
			action.click(my_orders());
			return new ParentsEditor(driver);
		}
}
