package testing.odoo.comun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestConfig {

    /**
     * Variable para establecer el Driver
     */
    public static WebDriver driver;   
    
    
    /***
     * Obtiene el Driver para automatizar con el Navegador Chrome
     * 
     * @return
     */
    public static WebDriver setupChromeWebDriver() {
        if (driver == null) {
            Parametros parametros = Parametros.getParametros();
            System.setProperty("webdriver.chrome.driver", parametros.RUTA_chromeDriver);
            driver = new ChromeDriver();
        }
        return driver;
    }

    /***
     * Cierra el driver
     */
    public static void closeDriver() {
        if (driver != null)
            driver.close();
        driver = null;
    }

    /***
     * Cierra el Navegador
     */
    public static void quitBrowser() {
        if (driver != null)
            driver.quit();
        driver = null;
    }

}
