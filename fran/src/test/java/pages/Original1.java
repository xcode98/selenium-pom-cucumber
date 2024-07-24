package pages;

import java.io.File;
import org.openqa.selenium.By;


public class Original1 extends BasePage{

    public Original1(){
        super(driver);
    }


    public void idk(){
        File file = new File("/Users/francis/Downloads/MOCK_DATA.csv");
        String path = file.getAbsolutePath();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        /*
        String text = driver.findElement(By.id("uploaded-files")).getText ();
        assertEquals("KarineTest123.txt",text);
        */
    }



}
