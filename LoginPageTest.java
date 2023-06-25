function runLoginPageTests() {
  import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
public static void main(String[] args) {
    // Set the path to the chromedriver executable
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

    // Create a new instance of the ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Open the Login page
    driver.get("https://sakshingp.github.io/assignment/login.html");

    // Verify that the page is loaded successfully
    String pageTitle = driver.getTitle();
    System.out.println("Page Title: " + pageTitle);

    // Perform functional testing scenarios on the Login page
    testEmptyUsernameAndPassword(driver);
    testEmptyUsername(driver);
    testEmptyPassword(driver);
    testSuccessfulLogin(driver);
    testInvalidUsernameWithValidPassword(driver);
    testValidUsernameWithInvalidPassword(driver);
    testInvalidUsernameAndPassword(driver);

    // Close the browser
    driver.quit();
}

private static void testEmptyUsernameAndPassword(WebDriver driver) {
    // Clear the username and password fields
    clearFields(driver);

    // Click the Log In button
    WebElement loginButton = driver.findElement(By.id("log-in"));
    loginButton.click();

    // Validate the error message for empty username and password
    WebElement errorMessage = driver.findElement(By.id("random_id_8"));
    String expectedErrorMessage = "Both Username and Password must be present";
    validateErrorMessage(errorMessage, expectedErrorMessage);
}

private static void testEmptyUsername(WebDriver driver) {
    // Clear the username and password fields
    clearFields(driver);

    // Enter a valid password
    WebElement passwordField = driver.findElement(By.id("password"));
    passwordField.sendKeys("password123");

    // Click the Log In button
    WebElement loginButton = driver.findElement(By.id("log-in"));
    loginButton.click();

    // Validate the error message for empty username
    WebElement errorMessage = driver.findElement(By.id("random_id_8"));
    String expectedErrorMessage = "Username must be present";
    validateErrorMessage(errorMessage, expectedErrorMessage);
}

private static void testEmptyPassword(WebDriver driver) {
    // Clear the username and password fields
    clearFields(driver);

    // Enter a valid username
    WebElement usernameField = driver.findElement(By.id("username"));
    usernameField.sendKeys("username123");

    // Click the Log In button
    WebElement loginButton = driver.findElement(By.id("log-in"));
    loginButton.click();

    // Validate the error message for empty password
    WebElement errorMessage = driver.findElement(By.id("random_id_8"));
    String expectedErrorMessage = "Password must be present";
    validateErrorMessage(errorMessage, expectedErrorMessage);
}

private static void testSuccessfulLogin(WebDriver driver) {
    // Clear the username and password fields
    clearFields(driver);

    // Enter a valid username and password
    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    usernameField.sendKeys("username123");
    passwordField.sendKeys("password123");

    // Click the Log In button
    WebElement loginButton = driver.findElement(By.id("log-in"));
    loginButton.click();

    // Validate successful login
    String currentUrl = driver.getCurrentUrl();
    if (currentUrl.equals("https://sakshingp.github.io/assignment/home.html")) {
        System.out.println("Login successful!");
    } else {
        System.out.println("Login failed!");
    }
}

private static void testInvalidUsernameWithValidPassword(WebDriver driver) {
    // Clear the username and password fields
    clearFields(driver);

    // Enter an invalid username and a valid password
    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    usernameField.sendKeys("invalidusername");
    passwordField.sendKeys("password123");

    // Click the Log In button
    WebElement loginButton = driver.findElement(By.id("log-in"));
    loginButton.click();

    // Validate the error message for invalid username
    WebElement errorMessage = driver.findElement(By.id("random_id_8"));
    String expectedErrorMessage = "Invalid username or password";
    validateErrorMessage(errorMessage, expectedErrorMessage);
}

private static void testValidUsernameWithInvalidPassword(WebDriver driver) {
    // Clear the username and password fields
    clearFields(driver);

    // Enter a valid username and an invalid password
    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    usernameField.sendKeys("username123");
    passwordField.sendKeys("invalidpassword");

    // Click the Log In button
    WebElement loginButton = driver.findElement(By.id("log-in"));
    loginButton.click();

    // Validate the error message for invalid password
    WebElement errorMessage = driver.findElement(By.id("random_id_8"));
    String expectedErrorMessage = "Invalid username or password";
    validateErrorMessage(errorMessage, expectedErrorMessage);
}

private static void testInvalidUsernameAndPassword(WebDriver driver) {
    // Clear the username and password fields
    clearFields(driver);

    // Enter an invalid username and an invalid password
    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    usernameField.sendKeys("invalidusername");
    passwordField.sendKeys("invalidpassword");

    // Click the Log In button
    WebElement loginButton = driver.findElement(By.id("log-in"));
    loginButton.click();

    // Validate the error message for invalid username and password
    WebElement errorMessage = driver.findElement(By.id("random_id_8"));
    String expectedErrorMessage = "Invalid username or password";
    validateErrorMessage(errorMessage, expectedErrorMessage);
}

private static void clearFields(WebDriver driver) {
    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    usernameField.clear();
    passwordField.clear();
}

private static void validateErrorMessage(WebElement errorMessage, String expectedErrorMessage) {
    String actualErrorMessage = errorMessage.getText();
    if (actualErrorMessage.equals(expectedErrorMessage)) {
        System.out.println("Test Passed: " + actualErrorMessage);
    } else {
        System.out.println("Test Failed: Expected - " + expectedErrorMessage + ", Actual - " + actualErrorMessage);
    }
}
}

  
}

// Call the function to trigger the automation tests
runLoginPageTests();

// JavaScript code goes here