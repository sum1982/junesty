/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EtsyTest;

import etsy.read.excel.ReadExcelFile;
import etsy.engine.WebOperation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Tejas Shah
 */
public class AccountTest {

    public WebDriver webdriver;
    public ReadExcelFile file;
    public WebOperation operation;
    public Sheet excelSheet;
    int rowCount;

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Data\\chromedriver.exe");
        /*webdriver = new ChromeDriver();
         webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

    }

    @Test
    public void CorrectAccountPage() throws IOException, Exception {

        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        file = new ReadExcelFile();
        operation = new WebOperation(webdriver);

        //Read Excel Sheet
        excelSheet = file.readExcel("C:\\Users\\User\\Desktop\\TestFileEtsy\\src\\main\\java\\etsy\\excel\\files\\AccountTest.xlsx", "CorrectAccountPage");

        // Find number Of Rows
        rowCount = excelSheet.getLastRowNum();

        //Read Excel File And Perform Test
        for (int i = 1; i < rowCount + 1; i++) {

            //loop to read each row in Excel
            Row row = excelSheet.getRow(i);

            //Check if the first cell contain a value, if yes, That means it is the new testcase name
            if (row.getCell(0).toString().equalsIgnoreCase("NA")) {

    //Print testcase detail on console
                //System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----"
                //+ row.getCell(3).toString() + "----" + row.getCell(4).toString());
                //Call perform function to perform operation on UI
                operation.perform(row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());

            }

        }

    }

    @Test
    public void IncorrectPasswordChange() throws IOException, Exception {

        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        file = new ReadExcelFile();
        operation = new WebOperation(webdriver);

        //Read Excel Sheet
        excelSheet = file.readExcel("C:\\Users\\Tejas Shah\\Documents\\NetBeansProjects\\TestFileEtsy\\src\\main\\java\\etsy\\excel\\files\\AccountTest.xlsx", "IncorrectPasswordChange");

        // Find number Of Rows
        rowCount = excelSheet.getLastRowNum();

        //Read Excel File And Perform Test
        for (int i = 1; i < rowCount + 1; i++) {

            //loop to read each row in Excel
            Row row = excelSheet.getRow(i);

            //Check if the first cell contain a value, if yes, That means it is the new testcase name
            if (row.getCell(0).toString().equalsIgnoreCase("NA")) {

    //Print testcase detail on console
                //System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----"
                // + row.getCell(3).toString() + "----" + row.getCell(4).toString());
                //Call perform function to perform operation on UI
                operation.perform(row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());

            }

        }

    }

}
