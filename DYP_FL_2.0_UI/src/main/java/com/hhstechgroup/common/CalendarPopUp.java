package com.hhstechgroup.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.Month;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringBefore;


/**
 * This class enables interaction with a calendar popup.
 */
public class CalendarPopUp extends BaseActions {

    /**
     * This constructor method creates a CalendarPopUp object using driver and wait arguments
     * @param driver
     * @param wait
     */
    public CalendarPopUp(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method selects the calendar popup hour value using the hour argument
     * @param hour
     */
    public void setHour(int hour) {
        String hourElement = format(Data.CLICK_HOURSORMINUTES, hour);
        driver.findElement(By.xpath(hourElement)).click();
    }

    /**
     * This method selects a calendar popup minute value using the minute argument
     * @param minute
     */
    public void setMinute(int minute) {
        String minuteElement = format(Data.CLICK_HOURSORMINUTES, minute);
        driver.findElement(By.xpath(minuteElement)).click();
    }

    /**
     * This method clicks the calendar popup year header, then selects a year value using the year argument
     * @param year
     */
    public void setYear(int year) {
        String yearElement = format(Data.YEAR, year);
        ajaxClick(By.xpath(Data.YEAR_HEADER));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(yearElement)));
        performClick(By.xpath(yearElement));

    }

    /**
     * This method selects a calendar popup year value using the year argument
     * @param year
     */
    public void setYear1(int year) {
        String yearElement = format(Data.YEAR, year);
        driver.findElement(By.xpath(yearElement)).click();
    }

    /**
     * This method selects a calendar popup month by click the previous month arrow or next month arrow and comparing
     * the month argument with the month displayed on the popup.
     * @param month
     */
    public void setMonth(int month) {
        int currentMonth = Month.valueOf(substringBefore(driver.findElement(By.xpath(Data.MONTH)).getText(), " ").toUpperCase()).getValue();
        while (currentMonth != month) {
            if (currentMonth < month) {
                driver.findElement(By.xpath(Data.MONTH_ARROW_RIGHT)).click();
                currentMonth = Month.valueOf(substringBefore(driver.findElement(By.xpath(Data.MONTH)).getText(), " ").toUpperCase()).getValue();
            } else if (currentMonth > month) {
                driver.findElement(By.xpath(Data.MONTH_ARROW_LEFT)).click();
                currentMonth = Month.valueOf(substringBefore(driver.findElement(By.xpath(Data.MONTH)).getText(), " ").toUpperCase()).getValue();
            }
        }
    }

    /**
     * This method selects a calendar popup day value using the dayOfMonth argument
     * @param dayOfMonth
     */
    public void setDayOfMonth(int dayOfMonth) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(format(Data.DAY_OF_MONTH, dayOfMonth))));
        driver.findElement(By.xpath(format(Data.DAY_OF_MONTH, dayOfMonth))).click();
        //waitForCalendarPopUpClosed();
    }

    /**
     * This method clicks the Calendar popup OK button to close the popup
     */
    public void clickOk() {
        driver.findElement(By.xpath(Data.OK_BUTTON)).click();
    }

    /**
     * This method waits until the calendar popup is no longer visible
     */
    public void waitForCalendarPopUpClosed() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(Data.CALENDAR_POP_UP))));
    }

    /**
     * This method waits until the calendar popup is visible, then selects the DOB year, DOB month and DOB day of
     * month using current local month and day of month values.
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        LocalDateTime date = LocalDateTime.now();
        ajaxClick(By.xpath(Data.DATE_OF_BIRTH));
        waitForCalendarPopUpOpened();
        driver.findElement(By.xpath(Data.CALENDAR)).click();
        //setYear(date.getYear());
        // setMonth(date.getMonthValue());
        // setDayOfMonth(date.getDayOfMonth());

    }

    /**
     * This method waits until the calendar popup is visible then selects the effective month and effective day of
     * month using current local month and day of month values.
     */
    public void setEffectiveDate() {
        //   LocalDateTime date = DateConverter.toLocalDate1(effectiveDate);
        LocalDateTime date = LocalDateTime.now();
        ajaxClick(By.xpath(Data.EFFECTIVE_DATE_CALENDAR));
        waitForCalendarPopUpOpened();
        //setYear(date.getYear());
        setMonth(date.getMonthValue());
        setDayOfMonth(date.getDayOfMonth());

    }

    /**
     * This method waits until the calendar popup is visible then selects the effective end month and effective end
     * day of month using current local month and day of month values.
     */
    public void setEndEffectiveDate() {
        //   LocalDateTime date = DateConverter.toLocalDate1(effectiveDate);
        LocalDateTime date = LocalDateTime.now();
        ajaxClick(By.xpath(Data.END_EFFECTIVE_DATE_CALENDAR));
        waitForCalendarPopUpOpened();
        //setYear(date.getYear());
        setMonth(date.getMonthValue());
        setDayOfMonth(date.getDayOfMonth() + 1);

    }

    /**
     * This method waits until the calendar popup is visible.
     */
    public void waitForCalendarPopUpOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Data.CALENDAR_POP_UP))));
    }
}
