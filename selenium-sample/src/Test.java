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
        // ChromeDriver�̃p�X��ݒ�
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");

        // WebDriver�̃C���X�^���X���쐬
        WebDriver driver = new ChromeDriver();

        // �J�������T�C�g��URL�������Ɏw��
        driver.get("http://www.google.com");

     // �B ������������͂���e�L�X�g�{�b�N�X���擾
     		WebElement element = driver.findElement(By.name("q"));
     		// �C ������������͂���
     		element.sendKeys("��");

     		// �D �T�u�~�b�g
     		element.submit();
    }

}