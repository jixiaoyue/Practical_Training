package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BaseAction {
	public AndroidDriver<AndroidElement> driver;
	public AndroidTouchAction action;

	public BaseAction(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		action = new AndroidTouchAction(driver);

	}

	/**
	 * @param by
	 */
	public void click(By by) {
		driver.findElement(by).click();
	}

	public void click(WebElement elemnet) {
		elemnet.click();
	}

	/**
	 * 坐标点击
	 */
	public void clickElement_OverScreen(int[][] arr) {
		TouchAction ta = new TouchAction(driver);

		int width = driver.manage().window().getSize().width;

		int height = driver.manage().window().getSize().height;

		int P_base_X = arr[0][0]; // 元素基准位置坐标

		int P_base_y = arr[0][1];

		int P_base_Screen_X = arr[1][0];// 元素所在页的屏幕基准尺寸

		int P_base_Screen_Y = arr[1][1];

		int point_X = this.formatNumber(P_base_X, P_base_Screen_X, width);

		int point_Y = this.formatNumber(P_base_y, P_base_Screen_Y, height);

		PointOption point_Concat = PointOption.point(point_X, point_Y);

		ta.press(point_Concat).release().perform();

	}

	public int formatNumber(int P_1, int P_2, int P_3) {
		float dd = (float) P_1 / (float) P_2;

		DecimalFormat df = new DecimalFormat("0.00000000");// 格式化小数，不足的补0

		String rat = df.format((double) dd);

		float ff = Float.parseFloat(rat);

		int formatNum = (int) (ff * P_3);

		return formatNum;

	}

	/**
	 * 输入
	 * 
	 * @param by
	 * @param value
	 */
	public void type(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);

	}

	public void type(WebElement element, String context) {
		element.clear();
		element.sendKeys(context);
	}

	/**
	 * 长按
	 * 
	 * @param element
	 */
	public void longPress(WebElement element) {
		LongPressOptions longPressOptions = LongPressOptions.longPressOptions();
		longPressOptions.withElement(ElementOption.element(element));
		action.longPress(longPressOptions).release().perform();
	}

	/**
	 * 坐标点的滑动
	 * 
	 * @param fromOption
	 * @param toOption
	 */
	public void slide(PointOption fromOption, PointOption toOption) {
		action.press(fromOption).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(toOption)
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}

	/**
	 * 上滑
	 * @param driver
	 */
    public void SwipeUp() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(width / 2, 100))
                .moveTo(PointOption.point(width / 2, height - 100)).release()
                .perform();
    }
    /**
     * 下滑
     * @param driver
     */
    public void SwipeDown() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height - 100))
                .moveTo(PointOption.point(width / 2, 100)).release().perform();
    }
    /**
     * 左滑
     * @param driver
     */
    public void SwipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }
    /**
     * 右滑
     * @param driver
     */
    public void SwipeRight() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }
	/**
	 * 元素间的滑动
	 * 
	 * @param fromEle
	 * @param toEle
	 */
	public void slide(WebElement fromEle, WebElement toEle) {

		slide(ElementOption.element(fromEle), ElementOption.element(toEle));
	}

	/**
	 * 长按拖动
	 * 
	 * @param element
	 */
	public void dragAndSlide(AndroidElement element) {

		LongPressOptions longPressOptions = LongPressOptions.longPressOptions();
		longPressOptions.withElement(ElementOption.element(element));

		action.longPress(longPressOptions).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(100, element.getLocation().getY()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}

	/**
	 * 多点触控功能实现
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 */
	public void multiTouch(int x1, int y1, int x2, int y2, int x3, int y3) {
		MultiTouchAction multiAction = new MultiTouchAction(driver);
		AndroidTouchAction action1 = new AndroidTouchAction(driver);
		AndroidTouchAction action2 = new AndroidTouchAction(driver);
		AndroidTouchAction action3 = new AndroidTouchAction(driver);
		AndroidTouchAction action4 = new AndroidTouchAction(driver);
		AndroidTouchAction action5 = new AndroidTouchAction(driver);

		action1.longPress(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();
		action2.longPress(PointOption.point(x2, y2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();
		action3.longPress(PointOption.point(x3, y3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();

		multiAction.add(action1).add(action2).add(action3).add(action4).add(action5).perform();
	}

	/**
	 * 返回Toast的文本信息
	 */
	public String getToast() {
		return driver.findElementByXPath("//*[@class='android.widget.Toast']").getText();
	}
}
