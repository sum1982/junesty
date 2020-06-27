/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EtsyTest;

import etsy.engine.WebOperation;
import etsy.read.excel.ReadExcelFile;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Tejas Shah
 */
public class LoginTest {

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
    public void CorrectLogin() throws IOException, Exception {

        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        file = new ReadExcelFile();
        operation = new WebOperation(webdriver);

        //Read Excel Sheet
        excelSheet = file.readExcel("C:\\Users\\User\\Desktop\\TestFileEtsy\\src\\main\\java\\etsy\\excel\\files\\LoginTest.xlsx", "CorrectLogin");

        // Find number Of Rows
        rowCount = excelSheet.getLastRowNum();

        //Read Excel File And Perform Test
        for (int i = 1; i < rowCount + 1; i++) {

            //loop to read each row in Excel
            Row row = excelSheet.getRow(i);

            //Check if the first cell contain a value, if yes, That means it is the new testcase name
            if (row.getCell(0).toString().equalsIgnoreCase("NA")) {

     //Print testcase detail on console
                // System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----"
                //+ row.getCell(3).toString() + "----" + row.getCell(4).toString());
                //Call perform function to perform operation on UI
                operation.perform(row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());

            }

        }
    }

    @Test
    public void WrongPassword() throws IOException, Exception {

        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        file = new ReadExcelFile();
        operation = new WebOperation(webdriver);

        //Read Excel Sheet
        excelSheet = file.readExcel("C:\\Users\\Tejas Shah\\Documents\\NetBeansProjects\\TestFileEtsy\\src\\"
                + "main\\java\\etsy\\excel\\files\\LoginTest.xlsx", "WrongPassword");

        // Find number Of Rows
        rowCount = excelSheet.getLastRowNum();

        //Read Excel File And Perform Test
        for (int i = 1; i < rowCount + 1; i++) {

            //loop to read each row in Excel
            Row row = excelSheet.getRow(i);

            //Check if the first cell contain a value, if yes, That means it is the new testcase name
            if (row.getCell(0).toString().equalsIgnoreCase("NA")) {

     //Print testcase detail on console
                // System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----"
                //+ row.getCell(3).toString() + "----" + row.getCell(4).toString());
                //Call perform function to perform operation on UI
                operation.perform(row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());

            }

        }

    }

    @Test
    public void InvalidEmail() throws IOException, Exception {

        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        file = new ReadExcelFile();
        operation = new WebOperation(webdriver);

        //Read Excel Sheet
        excelSheet = file.readExcel("C:\\Users\\Tejas Shah\\Documents\\NetBeansProjects\\TestFileEtsy\\src\\"
                + "main\\java\\etsy\\excel\\files\\LoginTest.xlsx", "InvalidEmail");

        // Find number Of Rows
        rowCount = excelSheet.getLastRowNum();

        //Read Excel File And Perform Test
        for (int i = 1; i < rowCount + 1; i++) {

            //loop to read each row in Excel
            Row row = excelSheet.getRow(i);

            //Check if the first cell contain a value, if yes, That means it is the new testcase name
            if (row.getCell(0).toString().equalsIgnoreCase("NA")) {

                //Print testcase detail on console
                // System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----"
                //+ row.getCell(3).toString() + "----" + row.getCell(4).toString());
                //Call perform function to perform operation on UI
                operation.perform(row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());

            }

        }
    }

    @Test
    public void BlankInput() throws IOException, Exception {

        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        file = new ReadExcelFile();
        operation = new WebOperation(webdriver);

        //Read Excel Sheet
        excelSheet = file.readExcel("C:\\Users\\Tejas Shah\\Documents\\NetBeansProjects\\TestFileEtsy\\src\\"
                + "main\\java\\etsy\\excel\\files\\LoginTest.xlsx", "BlankInput");

        // Find number Of Rows
        rowCount = excelSheet.getLastRowNum();

        //Read Excel File And Perform Test
        for (int i = 1; i < rowCount + 1; i++) {

            //loop to read each row in Excel
            Row row = excelSheet.getRow(i);

            //Check if the first cell contain a value, if yes, That means it is the new testcase name
            if (row.getCell(0).toString().equalsIgnoreCase("NA")) {

                //Print testcase detail on console
                // System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----"
                //+ row.getCell(3).toString() + "----" + row.getCell(4).toString());
                //Call perform function to perform operation on UI
                operation.perform(row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());

            }

        }
    }

}
