import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Test
{
    public static void main(String args[])
    {
        // ChromeDriverのパスを設定
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");

        // WebDriverのインスタンスを作成
        WebDriver driver = new ChromeDriver();

        // 開きたいサイトのURLを引数に指定
        driver.get("http://www.google.com");

     // ③ 検索文字を入力するテキストボックスを取得
     		WebElement element = driver.findElement(By.name("q"));
     		// ④ 検索文字を入力する
     		element.sendKeys("水");

     		// ⑤ サブミット
     		element.submit();
    }

}