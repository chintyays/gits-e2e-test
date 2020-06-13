import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;



public class StepDefinition {

    static WebDriver webDriver;

    @Given("^Open Gists page$")
    public void open_Gists_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chintya\\Desktop\\SARAH\\chromedriver_win32 (2)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://gist.github.com/");
    }

    @Then("^User click Sign in$")
    public void user_click_Sign_in() throws Throwable {
        webDriver.findElement(By.linkText("Sign in")).click();
    }

    @Then("^User input \"([^\"]*)\" on username field$")
    public void user_input_on_username_field(String username) throws Throwable {
        webDriver.findElement(By.id("login_field")).sendKeys(username);
    }

    @Then("^User input \"([^\"]*)\" on password field$")
    public void user_input_on_password_field(String password) throws Throwable {
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User click button Sign in$")
    public void user_click_button_Sign_in() throws Throwable {
        webDriver.findElement(By.cssSelector("input[type=submit]")).click();
    }

    @When("^User open create new gist page$")
    public void user_open_create_new_gist_page() throws Throwable {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//div[@class='Header-item']/a[@href='/']")).click();
    }


    @Then("^User input \"([^\"]*)\" on Gists description field$")
    public void user_input_on_Gists_description_field(String gist_description) throws Throwable {
        webDriver.findElement(By.cssSelector("input[name='gist[description]']")).sendKeys(gist_description);
    }


    @Then("^User click button Create public gists$")
    public void user_click_button_Create_public_gists() throws Throwable {
        webDriver.findElement(By.cssSelector("button[value='1']")).click();
    }

    @Then("^System display gist with title \"([^\"]*)\"$")
    public void system_display_gist_with_title(String gists_title_expected_result) throws Throwable {
        if ("Test.java".equals(gists_title_expected_result)){
            String actual_result = webDriver.findElement(By.xpath("//a[.='Test.java']")).getText();
            Assert.assertEquals(gists_title_expected_result, actual_result);
        } else if ("Testing.java".equals(gists_title_expected_result)){
            String actual_result = webDriver.findElement(By.xpath("//a[.='Testing.java']")).getText();
            Assert.assertEquals(gists_title_expected_result, actual_result);
        }else if ("gist_secret_single.txt".equals(gists_title_expected_result)){
            String actual_result = webDriver.findElement(By.xpath("//a[.='gist_secret_single.txt']")).getText();
            Assert.assertEquals(gists_title_expected_result, actual_result);
        } else if ("Testing Secret Gists Multiple-2.java".equals(gists_title_expected_result)){
            String actual_result = webDriver.findElement(By.xpath("//a[.='Testing Secret Gists Multiple-2.java']")).getText();
            Assert.assertEquals(gists_title_expected_result, actual_result);
        } else if ("Edit Testing Secret Gists Multiple-2.java".equals(gists_title_expected_result)){
            String actual_result = webDriver.findElement(By.xpath("//a[.='Edit Testing Secret Gists Multiple-2.java']")).getText();
            Assert.assertEquals(gists_title_expected_result, actual_result);
        }
    }

    @Then("^User click button Create secret gists$")
    public void user_click_button_Create_secret_gists() throws Throwable {
        webDriver.findElement(By.xpath("//button[@class='btn btn-secret js-gist-create ']")).click();
    }

    @Then("^User click button Edit$")
    public void user_click_button_Edit() throws Throwable {
        webDriver.findElement(By.xpath("//a[contains(.,'Edit')]")).click();
    }

    @Then("^User update \"([^\"]*)\" on Filename field$")
    public void user_update_on_Filename_field(String filename) throws Throwable {
        WebElement toClear = webDriver.findElement(By.cssSelector("[placeholder='Filename including extension…']"));
        toClear.click();
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
        webDriver.findElement(By.cssSelector("[placeholder='Filename including extension…']")).sendKeys(filename);
    }

    @Then("^User click button Update public gist$")
    public void user_click_button_Update_public_gist() throws Throwable {
        webDriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }

    @Then("^User click button Delete$")
    public void user_click_button_Delete() throws Throwable {
        webDriver.findElement(By.xpath("//button[@class='btn btn-sm btn-danger']")).click();
    }

    @Then("^User click \"([^\"]*)\" on popup notification$")
    public void user_click_on_popup_notification(String arg1) throws Throwable {
        webDriver.switchTo().alert().accept();
    }

    @Then("^User open home page to see all my lists of gists$")
    public void user_open_home_page_to_see_all_my_lists_of_gists() throws Throwable {
        webDriver.findElement(By.className("dropdown-caret")).click();
        webDriver.findElement(By.xpath("//a[.='Your gists']")).click();
    }

    @Then("^System display message \"([^\"]*)\"$")
    public void system_display_message(String expected_message) throws Throwable {
        String actual_message = webDriver.findElement(By.xpath("//div[@class='container-lg px-2']")).getText();
        Assert.assertEquals(expected_message, actual_message);
    }


    @Then("^User click button Add file$")
    public void user_click_button_Add_file() throws Throwable {
        webDriver.findElement(By.cssSelector(".js-add-gist-file")).click();
    }

    @Then("^User input \"([^\"]*)\" on \"([^\"]*)\" Filename field$")
    public void user_input_on_Filename_field(String filename, String filename_field_order) throws Throwable {
        if ("first".equals(filename_field_order)){
            webDriver.findElement(By.cssSelector("[name='gist[contents][][name]']")).sendKeys(filename);
        }else if ("second".equals(filename_field_order)){
            webDriver.findElement(By.cssSelector("div#gists > div:nth-of-type(3) [name='gist[contents][][name]']")).sendKeys(filename);
        }
    }

    @Then("^User input \"([^\"]*)\" on \"([^\"]*)\" text box$")
    public void user_input_on_text_box(String file_text, String textbox_field_order) throws Throwable {
        if ("first".equals(textbox_field_order)){
            webDriver.findElement(By.cssSelector(".CodeMirror-line")).sendKeys(file_text);
        }else if ("second".equals(textbox_field_order)){
            webDriver.findElement(By.cssSelector("div#gists > div:nth-of-type(3) pre:nth-of-type(1)")).sendKeys(file_text);
        }
    }

    @Given("^User on \"([^\"]*)\" detail gists page$")
    public void user_on_detail_gists_page(String gists_title_expected_result) throws Throwable {
        if ("Testing Secret Gists Multiple-2.java".equals(gists_title_expected_result)){
            String actual_result = webDriver.findElement(By.xpath("//a[.='Testing Secret Gists Multiple-2.java']")).getText();
            Assert.assertEquals(gists_title_expected_result, actual_result);
        } else if ("Edit Testing Secret Gists Multiple-2.java".equals(gists_title_expected_result)){
            String actual_result = webDriver.findElement(By.xpath("//a[.='Edit Testing Secret Gists Multiple-2.java']")).getText();
            Assert.assertEquals(gists_title_expected_result, actual_result);
        }
    }

    @Then("^User click button Cancel$")
    public void user_click_button_Cancel() throws Throwable {
        webDriver.findElement(By.xpath("//a[.='Cancel']")).click();
    }

}
