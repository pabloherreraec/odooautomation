package testing.odoo.test.login;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testing.odoo.comun.Parametros;
import testing.odoo.comun.TestConfig;
import testing.odoo.page.HomePage;
import testing.odoo.page.login.LoginPage;

public class LoginTest {  

  Parametros parametros = Parametros.getParametros();

  @BeforeClass
  public void setUp() {
    TestConfig.setupChromeWebDriver();
  }

  @AfterClass
  public void tearDown() {
    TestConfig.quitBrowser();

  }

  @Test
  public void login() {

    // Invoca a Login
    LoginPage loginPage = new LoginPage();
    loginPage.login(parametros.LOGIN_USER, parametros.LOGIN_PASS);

    // Verifica que haya llegado a la pantalla de login
    HomePage homePage = new HomePage();
    Assert.assertTrue(homePage.assertEnlaceContactos());

    TestConfig.closeDriver();

  }

}
