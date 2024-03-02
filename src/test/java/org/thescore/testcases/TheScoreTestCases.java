package org.thescore.testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.thescore.navigation.AppNavigation;
import org.thescore.verification.SearchResultVerification;
import org.thescore.verification.FavoriteScreenVerification;
import org.thescore.capabilities.CapabilitiesManager;


import java.net.MalformedURLException;
import java.net.URL;

public class TheScoreTestCases {

    private static AndroidDriver<AndroidElement> driver;
    private static WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set up desired capabilities using the manager
        DesiredCapabilities caps = CapabilitiesManager.getDesiredCapabilities();

        // Initialize driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Test initial search and adding to favorites")
    public void testFirstSearch() {
        AppNavigation.openMenu(driver, wait);
        AppNavigation.clickPrimaryButton(driver, wait);
        AppNavigation.clickSearch(driver, wait);
        AppNavigation.search(driver, wait, "Tor");
        AndroidElement searchResult = SearchResultVerification.verifySearchResult(driver, wait, "Toronto Raptors");
        searchResult.click();
        AppNavigation.clickPrimaryButton(driver, wait);
        AppNavigation.clickPrimaryButton(driver, wait);

        FavoriteScreenVerification.verifyFavoriteScreen(driver, wait);
    }

    @Test(description = "Searching for a Team", dependsOnMethods = "testFirstSearch")
    public void testTeamSearch() {
        AppNavigation.clickSearchBar(driver, wait); // Click on the search bar
        AppNavigation.search(driver, wait, "Tor");
        AndroidElement searchResult = SearchResultVerification.verifySearchResult(driver, wait, "Toronto Raptors");
        searchResult.click();
        SearchResultVerification.verifyTeamName(driver, wait, "Toronto Raptors");
        AppNavigation.clickTeamStatsSubTab(driver, wait, "TEAM STATS");
        SearchResultVerification.verifyTeamName(driver, wait, "Toronto Raptors");

    }

    @Test(description = "Back Button returns to the Search", dependsOnMethods = "testTeamSearch")
    public void testBackButton() {
        AppNavigation.clickBackButton(driver, wait);
        AndroidElement searchResult = SearchResultVerification.verifySearchResult(driver, wait, "Toronto Raptors");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            // Quit the driver without closing the app
            driver.quit();
        }
    }
}
