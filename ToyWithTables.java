package assign_w4_d1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement elementTable = driver.findElement(By.xpath("//table"));
		List<WebElement> rows1 = elementTable.findElements(By.tagName("tr"));
		List<WebElement> cols1 = rows1.get(0).findElements(By.tagName("td"));
		System.out.println(rows1.get(2).getText());
		System.out.println(rows1.get(3).getText());
		System.out.println(rows1.get(4).getText());
		int rows = rows1.size();
		System.out.println(rows);
		List<WebElement> cols2 = elementTable.findElements(By.tagName("th"));
		int cols = cols2.size();
		System.out.println(cols);
		
		// To check the vital task for the least completed progress
		driver.findElement(By.xpath("(//input[@name='vital'])[5]")).click();
		List<WebElement> vitalTask = driver.findElements(By.xpath("//table//tr"));
		System.out.println('\n' + "the vital task for the least completed progress is :" + '\n');
		for (int i = 5; i < vitalTask.size(); i++) {
			System.out.println(vitalTask.get(i).getText());
		}

	}

}
