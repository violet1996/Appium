package amazon;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
public class AmazonMobileAppTest extends BaseTestAmazon {

    @Test
    public void amazonAppTest() {
        // Log in to Amazon
        loginToAmazon("testuser@example.com", "password@123");

        // Search for a product
        searchForProduct("wireless headphones");

        // Apply filter 
        applyFilter();

        int price =0;
        // Select the first item from filtered results
        selectFirstItem(price);
        
        // Add the item to the cart
        addItemToCart();

        // Navigate to the cart
        goToCart();

        // Proceed to checkout (stop at payment step)
        proceedToCheckout();

        // Verify correct item and price in checkout summary
        verifyCheckoutSummary("wireless headphones");
    }

    private void loginToAmazon(String username, String password) {
        // Locate and interact with login elements
        // Logic depends on the login flow of the Amazon app

        // Example: finding the sign-in button and input fields
        driver.findElement(By.id("sign_in_button")).click();
        driver.findElement(By.id("email_login")).sendKeys(username);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    private void searchForProduct(String productName) {
        driver.findElement(By.id("search_src_text")).sendKeys(productName);
        driver.findElement(By.id("search_submit_button")).click();
    }

    private void applyFilter() {
        // Example filter: Select 4 stars and above rating
        driver.findElement(By.xpath("//android.widget.TextView[@text='Avg. Customer Review']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='4 Stars & above']")).click();
    }

    private void selectFirstItem(int price) {
        driver.findElement(By.xpath("(//android.view.View)[1]")).click();
    
    }

    private void addItemToCart() {
        driver.findElement(By.id("add_to_cart_button")).click();
    }

    private void goToCart() {
        driver.findElement(By.id("nav_cart")).click();
    }

    private void proceedToCheckout() {
        driver.findElement(By.id("proceed_to_checkout")).click();
    }

    private void verifyCheckoutSummary(String expectedProductName) {
        String actualProductName = driver.findElement(By.id("checkout_product_name")).getText();
        Assert.assertTrue(actualProductName.contains(expectedProductName), "Product name does not match in checkout summary");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

