package testing.odoo.page.login;

import org.openqa.selenium.By;

import testing.odoo.comun.TestConfig;
import testing.odoo.comun.Parametros;

/**
 * Contiene las acciones que se pueden realizar sobre la Pantalla de Login
 */
public class LoginPage {   

    /***
     * Realiza el Login
     * 
     * @param user Usuario
     * @param pwd  Password
     */
    public void login(String user, String pwd) {

        Parametros parametros = Parametros.getParametros();
        TestConfig.driver.get(parametros.URL_BASE);
        TestConfig.driver.findElement(By.id("login")).sendKeys(user);
        TestConfig.driver.findElement(By.id("password")).click();
        TestConfig.driver.findElement(By.id("password")).sendKeys(pwd);
        TestConfig.driver.findElement(By.cssSelector(".btn")).click();

    }    

}
