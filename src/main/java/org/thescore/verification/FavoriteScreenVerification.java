package org.thescore.verification;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoriteScreenVerification {

    public static void verifyFavoriteScreen(AndroidDriver<AndroidElement> driver, WebDriverWait wait) {
        // Wait for the presence of the element containing the text "Favorites" in the navigation bar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fivemobile.thescore:id/navigation_bar_item_large_label_view")));

        // Get the text of the element
        AndroidElement navigationBarElement = driver.findElement(By.id("com.fivemobile.thescore:id/navigation_bar_item_large_label_view"));
        String text = navigationBarElement.getText();

        // Check if the text contains "Favorites"
        if (text.contains("Favorites")) {
            System.out.println("You are on the Favorites screen.");
        } else {
            System.out.println("Favorites screen not detected.");
        }
    }
}
