package marathon.testcases;
	// Print the first resulting bag info from Amazon
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Amazon {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys",Keys.ENTER);
		WebElement results = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
		String text2 = results.getText();
		String[] array=text2.split(" ");
			for (int i = 0; i < array.length; i++) {
			}
		System.out.println("Total number of results: " +array[3]);
		driver.findElement(By.xpath("//span[text()='Skybags']/parent::a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Gear']/parent::a")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("a-dropdown-prompt")).click();
		driver.findElement(By.linkText("Newest Arrivals")).click();
		String bagName = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[1]")).getText();
		String bagPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("First Resulting Bag Name: " +bagName);
		System.out.println("First Resulting Bag Price: " +bagPrice);
		String title = driver.getTitle();
		System.out.println("title: "+title);
		driver.close();
		
	}

}
