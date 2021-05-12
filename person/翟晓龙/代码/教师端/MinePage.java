package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MinePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	public MinePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action = new BaseAction (driver);
	}
	
	//�ҵ�Ǯ��
	public AndroidElement myWallet() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/mywallet");
	}
	
	//������
	public AndroidElement conduct() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/ll_doing");
	}
	
	//�����
	public AndroidElement completed() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/finished_liner");
	}
	//�������İ�ť
	public AndroidElement correction() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/continuebtn");
	}
	//�ύ���İ�ť
	public AndroidElement submit() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/submit");
	}

	//�鿴��������
	public AndroidElement detail() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/detail");
	}
	
	//��ϵ����
	public AndroidElement contactus() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/contactUs");
	}
	
	//��ӹ�΢
	public AndroidElement wechat() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/wechat");
	}
	
	//����
	public AndroidElement setting() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/setting_relative");
	}
	//ע���˺�
	public AndroidElement logoff() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/logoff");
	}
	
	//��ʦ����
	public AndroidElement correct() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/correct_self_text");
	}
	
	//ok��ť
	public AndroidElement but_ok() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/dialog_button");
	}
	
	//�ҵ�
	public AndroidElement mine() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/mine");
	}
}
