package org.thescore.verification;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultVerification {

    public static AndroidElement verifySearchResult(AndroidDriver<AndroidElement> driver, WebDriverWait wait, String expectedResult) {
        // Wait for the presence of the search result element
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/txt_name")));

        // Find the search result element
        AndroidElement searchResult = driver.findElement(By.id("com.fivemobile.thescore:id/txt_name"));

        // Get the text of the search result
        String searchResultText = searchResult.getText();

        // Check if the search result contains the expected text
        if (searchResultText.contains(expectedResult)) {
            System.out.println("Search result contains: " + expectedResult);
            return searchResult;
        } else {
            System.out.println(expectedResult + " not found in search results.");
            return null;
        }
    }

    public static void verifyTeamName(AndroidDriver<AndroidElement> driver, WebDriverWait wait,
                                      String expectedTeamName) {
        // Wait for the presence of the team name element
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/team_name")));

        // Find the team name element
        AndroidElement teamNameElement = driver.findElement(By.id("com.fivemobile.thescore:id/team_name"));

        // Get the text of the team name element
        String teamNameText = teamNameElement.getText();

        // Assert that the team name text matches the expected text
        if (!teamNameText.equals(expectedTeamName)) {
            System.out.println("Team name does not match expected value.");
            // Or throw an exception
            throw new AssertionError("Team name does not match expected value.");
        }
    }
}
