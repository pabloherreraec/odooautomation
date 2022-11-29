package testing.odoo.test.contacto;

import testing.odoo.comun.TestConfig;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testing.odoo.comun.Parametros;
import testing.odoo.page.HomePage;
import testing.odoo.page.contacto.ContactoHomePage;
import testing.odoo.page.contacto.ContactoNewPage;
import testing.odoo.page.login.LoginPage;

public class ContactoCrearTest {

    Parametros parametros = Parametros.getParametros();

    @BeforeClass
    public void setUp() {
        TestConfig.setupChromeWebDriver();
    }

    @AfterClass
    public void tearDown() {
        // TestConfig.quitBrowser();
    }

    @Test
    public void CrearContacto() {

        // Invoca a Login
        LoginPage loginPage = new LoginPage();
        loginPage.login(parametros.LOGIN_USER, parametros.LOGIN_PASS);

        // Verifica que haya llegado a la pantalla de login
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.assertEnlaceContactos());

        // Hace clic sobre el botón "Contactos"
        homePage.clickContactos();

        // Pulsa el botón crear que se encuentra en la pantalla ConcactoHomePage
        ContactoHomePage contactoHomePage = new ContactoHomePage();
        Assert.assertTrue(contactoHomePage.assertBotonCrear());
        contactoHomePage.clickCrear();

        // Envía a crear el contacto
        ContactoNewPage contactoNewPage = new ContactoNewPage();
        contactoNewPage.crearContacto("Juan Perez 22",
                "Av. de prueba", 
                "calle segunda", 
                "Quito", 
                "Pichincha (EC)",
                "170303", 
                "0993122344", "0968988788", 
                "test@test.com",
                "ninguno", "Proveedores");

        // TestConfig.closeDriver();

    }

}
