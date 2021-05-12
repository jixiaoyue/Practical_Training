package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MallPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

//	ͨ�����췽������driver��ʼ����
	public MallPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
		;
	}

	public BaseAction action() {
		return action;
	}

	public AndroidElement mall() {
		return driver.findElementById("com.example.homeworkcorrect:id/shop_img");
	}
	//�̳�������
	public AndroidElement search() {
		return driver.findElementById("com.example.homeworkcorrect:id/search_tv_search");
	}
	//�̳�������ť
	public AndroidElement btn_search() {
		return driver.findElementByClassName("android.widget.TextView");
	}
	//�̳���Ʒ
	public AndroidElement commodity() {
		return driver.findElementById("com.example.homeworkcorrect:id/commodity_img");
	}

	public AndroidElement institutions() {
		return driver.findElementByClassName("android.widget.Button");
	}

	// ���빺�ﳵ��ťԪ��
	public AndroidElement shopping_Cart() {
		return driver.findElementsByClassName("android.widget.Button").get(0);
	}

	// ��������ťԪ��
	public AndroidElement purchase() {
		return driver.findElementsByClassName("android.widget.Button").get(1);
	}
	//����
	public AndroidElement setting() {
		return driver.findElementById("com.example.homeworkcorrect:id/setting_relative");
	}
	//�ҵ�
	public AndroidElement mine() {
		return driver.findElementById("com.example.homeworkcorrect:id/mine_img");
	}
	//ע���˺�
	public AndroidElement logoff() {
		return driver.findElementById("com.example.homeworkcorrect:id/logoff");
	}
}
