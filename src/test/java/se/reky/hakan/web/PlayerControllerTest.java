package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/*TODO
*     --GAME STATS--
*   * Jonas 0 Points *
*   * Håkan 16 Points *
* */

@Disabled
class PlayerControllerTest {

    private WebDriver driver;
    private final String url = "http://localhost:8080";
    private WebDriverWait wait;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
    public void testTitlePlayers() {
        driver.get(url +"/players");
        assertEquals("Players List", driver.getTitle());
    }

    @Test
    public void testButtonText(){
        driver.get(url + "/players");
        assertEquals("Logga in", driver.findElement(By.tagName("button")).getText());
    }

    @Test
    public void testLinkAndPlayerName() {
        driver.get(url + "/players");
        driver.findElement(By.tagName("a")).click();
        wait.until(ExpectedConditions.titleIs("Player Stats"));
        assertTrue(driver.findElement(By.className("player-name")).isDisplayed());
    }

    @Test
    public void testLinkAndNumberOfStats() {
        driver.get(url + "/players");
        driver.findElement(By.tagName("a")).click();
        wait.until(ExpectedConditions.titleIs("Player Stats"));
        List<WebElement> playerStats = driver.findElements(By.tagName("li"));
        assertEquals(6, playerStats.size());
    }

    @Test
    public void testLinkAndUrlId() {
        driver.get(url + "/players");
        driver.findElement(By.tagName("a")).click();
        wait.until(ExpectedConditions.titleIs("Player Stats"));
        char urlID = driver.getCurrentUrl().charAt(driver.getCurrentUrl().length() - 1);
        assertEquals('2', urlID);
    }


}