/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author vegeta
 */
public class Test {
    public Test(){
        System.setProperty("webdriver.chrome.driver","/home/vegeta/Downloads/chromedriver");
        
    }
    public void doo(String url){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        
    }
    public static void main(String[] args) {
           
    }
    
}
