package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class PlayerControllerTest {

    private WebDriver driver;
    private final String url = "http://localhost:8080";

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAmountOfPlayers() {
        driver.get(url + "/players");
        List<WebElement> listItems = driver.findElements(By.tagName("li"));
        assertEquals(2,listItems.size());
    }

    @Test
    public void testIsFirstPlayerRendered() {
        driver.get(url +"/players");
        WebElement element = driver.findElement(By.tagName("li"));
        assertTrue(element.isDisplayed());
    }

    @Test
    public void testTitle() {
        driver.get(url +"/players");
        assertEquals("Players List", driver.getTitle());
    }

    @Test
    public void testButtonText(){
        driver.get(url + "/players");
        assertEquals("Logga in", driver.findElement(By.tagName("button")).getText());
    }
}