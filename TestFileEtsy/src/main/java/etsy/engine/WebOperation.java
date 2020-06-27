/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etsy.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author Tejas Shah
 */
public class WebOperation {

    WebDriver driver;

    public WebOperation(WebDriver driver) {
        this.driver = driver;

    }

    //public void startExecution(WebDriver driver, String action, String locatorName, String locatorValue, String value) {
    public void perform(String operation, String objectName, String objectType, String value) throws Exception {
        switch (operation.toUpperCase()) {

            case "GOTOURL":
                driver.get(value);
                break;

            case "QUIT":
                Thread.sleep(2000);
                driver.quit();
                break;

            case "SLEEP":
                Thread.sleep(2000);
                break;

            default:
                break;

        }

        //Check If The User Enterd Xpath
        if (objectType.equalsIgnoreCase("XPATH")) {

            WebElement element = driver.findElement(By.xpath(objectName));
            //JavascriptExecutor je =(JavascriptExecutor) driver;

            if (operation.equalsIgnoreCase("sendkeys")) {
                element.clear();
                element.sendKeys(value);
            } else if (operation.equalsIgnoreCase("click")) {
                element.click();
            } else if (operation.equalsIgnoreCase("select")) {
                Select dropDown = new Select(element);
                element.click();
                Thread.sleep(1000);
                dropDown.selectByVisibleText(value);
            }
        } else if (objectType.equalsIgnoreCase("NA")) {

        } else {
            System.out.println("Please Use Xpath");
            Assert.fail("Use XPATH For All Test Cases");
        }

        //Check If An Object Is Displayed 
        if (operation.equalsIgnoreCase("CHECKOBJECT")) {

            boolean checkObject = driver.findElement(By.xpath(objectName)).isDisplayed();

            if (!checkObject) {
                Assert.fail("Object Is Not Present");
            }

        }

        //Check If Proper Page Is Loded
        if (operation.equalsIgnoreCase("CHECKURL")) {

            String url = driver.getCurrentUrl();
            boolean CHECKURL = url.equals(value);

            if (!CHECKURL) {
                Assert.fail("Incorrect Page Loaded: " + url);
            }

        }

        //Check If Text Matches
        if (operation.equalsIgnoreCase("CHECKTEXT")) {

            String getText = driver.findElement(By.xpath(objectName)).getText();
            boolean CHECKTEXT = getText.equals(value);

            if (!CHECKTEXT) {
                Assert.fail("Incorrect Text Displayed: " + getText);
            }
        }


        /* System.out.println("");
         switch (operation.toUpperCase()) {
         case "CLICK":
         //Perform click
         driver.findElement(this.getObject(p, objectName, objectType)).click();
         break;
   
         case "SETTEXT":
         //Set text on control
         driver.findElement(this.getObject(p, objectName, objectType)).sendKeys(value);
                
         break;

         case "GOTOURL":
         //Get url of application
         driver.get(p.getProperty(value));
         //driver.get(value);
         break;
     
         case "GETTEXT":
         //Get text of an element
         driver.findElement(this.getObject(p, objectName, objectType)).getText();
         break;
     
         default:
         break;
         }
         }
    
         private By getObject(Properties p,String objectName,String objectType) throws Exception{
        
         //Find by xpath
         if(objectType.equalsIgnoreCase("XPATH")){
        
         return By.xpath(p.getProperty(objectName));
         //return By.xpath(objectName);
        
         }
        
         //Find by id
         if(objectType.equalsIgnoreCase("ID")){
        
         return By.id(p.getProperty(objectName));
         }
        
         //find by class
         else if(objectType.equalsIgnoreCase("CLASSNAME")){
        
         return By.className(p.getProperty(objectName));
        
         }
        
         //find by name
         else if(objectType.equalsIgnoreCase("NAME")){
        
         return By.name(p.getProperty(objectName));
        
         }
        
         //Find by css
         else if(objectType.equalsIgnoreCase("CSS")){
        
         return By.cssSelector(p.getProperty(objectName));
        
         }
        
         //find by link
         else if(objectType.equalsIgnoreCase("LINK")){
        
         return By.linkText(p.getProperty(objectName));
            
         }
        
         //find by partial link
         else if(objectType.equalsIgnoreCase("PARTIALLINK")){
            
         return By.partialLinkText(p.getProperty(objectName));
            
         }
        
         //Incorrect Object type
         else
         {
         throw new Exception("Wrong object type");
         }*/
    }

}
