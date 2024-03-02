package org.thescore.navigation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppNavigation {

    public static void openMenu(AndroidDriver<AndroidElement> driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/action_button_text"))).click();
    }

    public static void clickPrimaryButton(AndroidDriver<AndroidElement> driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/btn_primary"))).click();
    }

    public static void clickSearch(AndroidDriver<AndroidElement> driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/search_bar_placeholder"))).click();
    }

    public static void clickSearchBar(AndroidDriver<AndroidElement> driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/search_bar_text_view"))).click();
    }



    public static void search(AndroidDriver<AndroidElement> driver, WebDriverWait wait, String searchText) {
        AndroidElement searchInput = driver.findElement(By.id("com.fivemobile.thescore:id/search_src_text"));
        searchInput.sendKeys(searchText);
        // Wait for the search results
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/txt_name")));
    }

    public static void searchBar(AndroidDriver<AndroidElement> driver, WebDriverWait wait, String searchText) {
        AndroidElement searchInput = driver.findElement(By.id("com.fivemobile.thescore:id/search_src_text"));
        searchInput.sendKeys(searchText);
        // Wait for the search results
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/search_src_text")));
    }



    public static void clickTeamStatsSubTab(AndroidDriver<AndroidElement> driver, WebDriverWait wait, String text) {
        AndroidElement teamStatsSubTab = driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'TEAM STATS' or . = 'TEAM STATS')]"));
        teamStatsSubTab.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'STATS' or . = 'STATS') and @resource-id = 'com.fivemobile.thescore:id/header_text']")));

    }

    public static void clickBackButton(AndroidDriver<AndroidElement> driver, WebDriverWait wait) {
        AndroidElement teamStatsSubTab = driver.findElement(By.xpath("//*[@class = 'android.widget.ImageButton' and (@text = '' or . = '')]"));
        teamStatsSubTab.click();

    }




}
