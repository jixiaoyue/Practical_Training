package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.asm.Advice.Return;
import utils.BaseAction;

public class RewardPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	通过构造方法对于driver初始化；
	public RewardPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action= new BaseAction(driver);
	}
	//单个元素
	public AndroidElement main() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/main");
	}
	public AndroidElement find_first_details() {
		return driver.findElementByXPath("//androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.Button");
	}
	public AndroidElement img() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/img_homework111");
	}
	
	
	public AndroidElement acceptOrder() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/checkdetail");
	}
	public AndroidElement agree() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/positiveTextView");
	}
	public AndroidElement yes() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/positiveTextView");
	}
	
	public AndroidElement english() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/english");
	}
	public AndroidElement math() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/math");
	}
	public AndroidElement massage() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/iv_ring");
	}
	public AndroidElement begin_time() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/time");
	}
	public AndroidElement end_time() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/deadline");
	}
	public AndroidElement last_time() {
		return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.example.homeworkcorrectteacher:id/transparentPrompt\")");
	}
	public AndroidElement user() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_conversation_title");
	}
	public AndroidElement voice_message() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_voice_toggle");
	}
	public AndroidElement send_voice_message() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_audio_input_toggle");
	}
	public AndroidElement play_voice_message() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_voice_toggle");
	}
	public AndroidElement text_message() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_voice_toggle");
	}
	public AndroidElement edit_text() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_edit_text");
	}
	public AndroidElement send_text_massage() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_send_toggle");
	}
	public AndroidElement img_message() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_plugin_toggle");
	}
	public AndroidElement img_message_1() {
		return driver.findElementByXPath("//*[@text='图片']");
	}
	public AndroidElement img_message_2() {
		return driver.findElementByXPath("//*[@text='文件']");
	}
	public AndroidElement choice_img() {
		return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.example.homeworkcorrectteacher:id/checkbox\")");
	}
	public AndroidElement send_img() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/send");
	}
	public AndroidElement file_phone() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_ac_tv_file_manager_mobile_memory");
	}
	public AndroidElement file_picture() {
		return driver.findElementByXPath("//*[@text='Pictures']");
	}
	public AndroidElement file_picture_1() {
		return driver.findElementByXPath("//*[@text='1620027040426.jpg']");
	}
	public AndroidElement send_file() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_ad_tv_file_list_select_state");
	}
	public AndroidElement emo_message() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_emoticon_toggle");
	}
	public AndroidElement choice_emo() {
		return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.example.homeworkcorrectteacher:id/rc_ext_emoji_item\")");
	}
	public AndroidElement send_emo() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/rc_send_toggle");
	}
	public AndroidElement massage_1() {
		return driver.findElementByXPath("//*[@text='撤回消息']");
	}
	public AndroidElement massage_2() {
		return driver.findElementByXPath("//*[@text='删除消息']");
	}
	public AndroidElement massage_3() {
		return driver.findElementByXPath("//*[@text='转发消息']");
	}
	public AndroidElement massage_4() {
		return driver.findElementByXPath("//*[@text='复制粘贴消息']");
	}
	public AndroidElement massage_copy() {
		return driver.findElementByXPath("//*[@text='复制消息']");
	}
	public AndroidElement user_top() {
		return driver.findElementByXPath("//*[@text='置顶该会话']");
	}
	public AndroidElement user_delete() {
		return driver.findElementByXPath("//*[@text='从会话列表中移除']");
	}
	
	//验证能否查看悬赏内容
	public void test1() {
		System.out.println("----------------验证能否查看悬赏内容-----------------");
		action.click(main());
		action.click(find_first_details());
		action.click(img());
		driver.navigate().back();
		driver.navigate().back();
	}
	//验证能否悬赏接单
	public void test2() {
		System.out.println("----------------验证能否悬赏接单-----------------");
		action.click(main());
		action.click(find_first_details());
		action.click(acceptOrder());
		action.click(agree());
		action.click(yes());
		driver.navigate().back();
	}
	//验证能否切换不同学科的悬赏
	public void test3() throws InterruptedException {
		System.out.println("----------------验证能否切换不同学科的悬赏-----------------");
		action.click(main());
		action.click(english());
		Thread.sleep(1000);
		//下滑
		action.SwipeDown(driver);
		action.click(math());
//		//向左滑动
		Thread.sleep(1000); 
		action.SwipeLeft(driver);
//		向右滑动
		Thread.sleep(1000);		
		action.SwipeRight(driver);
		Thread.sleep(1000);		
	}
	//验证悬赏大厅能否进行上下滑动查看
	public void test4() throws InterruptedException {
		System.out.println("----------------验证悬赏大厅能否进行上下滑动查看-----------------");
		action.click(main());
		Thread.sleep(1000);
		//上滑
		action.SwipeUp(driver);
		Thread.sleep(1000);
		//下滑
		action.SwipeDown(driver);
		Thread.sleep(1000);
	}
	//验证能否查看消息提示
	public void test5() throws InterruptedException {
		System.out.println("----------------验证能否查看消息提示-----------------");
		action.click(main());
		action.click(massage());
		Thread.sleep(1000);
		driver.navigate().back();
	}
	//验证悬赏的发布时间和截止时间是否正确
	public void test6() throws InterruptedException {
		System.out.println("----------------验证悬赏的发布时间和截止时间是否正确-----------------");
		action.click(main());
		action.click(find_first_details());
		String begintime=begin_time().getAttribute("text");
		String endtime=end_time().getAttribute("text");
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher btime = p.matcher(begintime);
		Matcher etime = p.matcher(endtime);
		begintime=btime.replaceAll("").trim();
		endtime=etime.replaceAll("").trim();
		System.out.println("开始时间:"+begintime+"  截止时间:"+endtime);
		if(endtime.compareTo(begintime)>=1) {
			System.out.println("截止时间大于截止时间，符合预期");
		}
		Thread.sleep(1000);
		driver.navigate().back();
	}
	//验证悬赏的剩余截止时间是否正确
	public void test7() throws InterruptedException {
		System.out.println("----------------验证悬赏的剩余截止时间是否正确----------------");
		action.click(main());
		action.click(find_first_details());
		String endtime=end_time().getAttribute("text");
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher etime = p.matcher(endtime);
		endtime=etime.replaceAll("").trim();
		System.out.println("endtime:"+endtime);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		String time=df.format(new Date());
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		Thread.sleep(1000);
		driver.navigate().back();
		String lasttime=last_time().getAttribute("text");
		System.out.println("剩余截止时间："+lasttime);
		if(time.compareTo(endtime)>=1&&!lasttime.equals("已截止")) {
			System.out.println("作业悬赏已截止，但是没有显示'已截止'，不符合预期");
		}
	}
	//验证悬赏-消息能否发送语音消息
	public void test8() {
		System.out.println("----------------验证悬赏-消息能否发送语音消息-----------------");
		action.click(main());
		action.click(massage());
		action.click(user());
		action.click(voice_message());
		action.longPress(send_voice_message());
	}
	//验证悬赏-消息语音消息能否被正常播放
	public void test9() throws InterruptedException {
		System.out.println("----------------验证悬赏-消息语音消息能否被正常播放-----------------");
		action.click(play_voice_message());
		Thread.sleep(5000);
	}
	//验证悬赏-消息语音消息能否暂停然后继续收听
	public void test10() throws InterruptedException {
		System.out.println("----------------验证悬赏-消息语音消息能否暂停然后继续收听-----------------");
		action.click(play_voice_message());//播放
		Thread.sleep(2000);
		action.click(play_voice_message());//暂停
		Thread.sleep(2000);
		action.click(play_voice_message());//播放
		Thread.sleep(3000);
	}
	//验证悬赏-消息能否发送文字消息
	public void test11(String a){
		System.out.println("----------------验证悬赏-消息能否发送文字消息-----------------");
		action.click(text_message());	
		action.type(edit_text(), a);	
		action.click(send_text_massage());
	}
	//验证悬赏-消息能否发送图片消息
	public void test12() throws InterruptedException{
		System.out.println("----------------验证悬赏-消息能否发送图片消息----------------");
		action.click(img_message());	
		action.click(img_message_1());
		action.click(choice_img());
		action.click(send_img());
		Thread.sleep(2000);
	}
	//验证悬赏-消息能否发送文件
	public void test13() throws InterruptedException{
		System.out.println("----------------验证悬赏-消息能否发送文件----------------");	
		action.click(img_message_2());
		Thread.sleep(2000);
		action.click(file_phone());
		action.click(file_picture());
		action.click(file_picture_1());
		action.click(send_file());
	}
	//验证悬赏-消息能否发送表情
	public void test14(){
		System.out.println("----------------验证悬赏-消息能否发送表情----------------");
		action.click(emo_message());	
		action.click(choice_emo());
		action.click(send_emo());
	}
	//验证悬赏-消息能否发送字符串消息
	public void test15(){
		System.out.println("----------------验证悬赏-消息能否发送字符串消息----------------");
		action.type(edit_text(), "abcd%?<>90");
		action.click(send_text_massage());
	}
	//验证悬赏-消息能否撤回消息
	public void test16() throws InterruptedException{
		System.out.println("----------------验证悬赏-消息能否撤回消息----------------");
		action.type(edit_text(), "撤回消息");
		Thread.sleep(2000);
		action.click(send_text_massage());
		action.longPress(massage_1());
		driver.navigate().back();
	}
	//验证悬赏-消息能否删除
	public void test17() throws InterruptedException{
		System.out.println("----------------验证悬赏-消息能否删除----------------");
		action.type(edit_text(), "删除消息");
		Thread.sleep(2000);
		action.click(send_text_massage());
		action.longPress(massage_2());
		action.longPress(massage_2());
	}
	//验证悬赏-消息能否转发消息
	public void test18() throws InterruptedException{
		System.out.println("----------------验证悬赏-消息能否转发消息---------------");
		action.type(edit_text(), "转发消息");
		action.click(send_text_massage());
		Thread.sleep(2000);
		action.longPress(massage_3());
		driver.navigate().back();
	}
	//验证悬赏-消息能否进行消息的复制粘贴
	public void test19() throws InterruptedException{
		System.out.println("----------------验证悬赏-消息能否进行消息的复制粘贴---------------");
		action.type(edit_text(), "复制粘贴消息");
		action.click(send_text_massage());
		Thread.sleep(2000);
		action.longPress(massage_4());
		action.longPress(massage_copy());
		action.longPress(edit_text());
		//点击粘贴
		int[][] keyboardArr = {{88,1168}, {720,1280}}; //手机键盘的搜索按钮坐标
		action.clickElement_OverScreen(driver, keyboardArr); //屏幕构造坐标点位并点击
		action.click(send_text_massage());
		Thread.sleep(1000);
		driver.navigate().back();
		driver.navigate().back();
	}
	//验证好友列表中的好友能否置顶
	public void test20(){
		System.out.println("----------------验证好友列表中的好友能否置顶---------------");
		action.longPress(user());
		action.click(user_top());
	}
	//验证好友列表中的好友能否删除
	public void test21(){
		System.out.println("----------------验证好友列表中的好友能否删除---------------");
		action.longPress(user());
		action.click(user_delete());
	}
}
