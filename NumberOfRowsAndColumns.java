package assign_w4_d1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NumberOfRowsAndColumns {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> rows1 = driver.findElements(By.xpath("//div[@class='render']//tr"));
		int rows01 = rows1.size();
		List<WebElement> rows2 = driver.findElements(By.xpath("//div[@class='related-pages']//tr"));
		int rows02 = rows2.size();
		int rows = rows01 + rows02;
		System.out.println(rows);

		List<WebElement> cols1 = driver.findElements(By.xpath("//div[@class='render']//th"));
		int cols01 = cols1.size();
		List<WebElement> cols2 = driver.findElements(By.xpath("//div[@class='related-pages']//th"));
		int cols02 = cols2.size();
		int cols = cols01 + cols02;
		System.out.println(cols);

	}

}
