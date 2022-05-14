package assign_w4_d1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals'][1]")).click();
		List<WebElement> securityName = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[4]"));
		for (int i = 0; i < securityName.size(); i++) {
			System.out.println(securityName.get(i).getText());

		}
		List<WebElement> list1 = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[4]"));
		List<String> strings = new ArrayList<String>();
		;
		for (WebElement Security : list1) {
			strings.add(Security.getText());
		}
		System.out.println();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String Dup : strings) {
			if (map.containsKey(Dup)) {
				map.put(Dup, map.get(Dup) + 1);
			} else {
				map.put(Dup, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1)
				System.out.println('\n' + "duplicate found:" + entry.getKey());
			else
				System.out.println('\n' + "no duplicate found:" + entry.getKey());
		}
	}

}
