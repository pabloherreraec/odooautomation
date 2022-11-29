package testing.odoo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testing.odoo.comun.TestConfig;
import testing.odoo.comun.TestComun;

/**
 * Contiene las acciones que se pueden realizar sobre la Pantalla de Home
 */
public class HomePage {
    
    private String selectorEnlaceContactos = "#result_app_1 > div";

    /***
     * Hace una validación de se visualice el enlace de Contactos
     * en la Pantalla de Inicio 
     * @return
     */
    public boolean assertEnlaceContactos()
    { 
        
        try {

            // Verifica que el elemneto esté disponible para hacer click
            WebElement elementoEnlaceContactos = TestComun.esperarQueElementoSeaClickableCSS(selectorEnlaceContactos);

            // Verifica que diga la palablar "Contactos"
            return elementoEnlaceContactos.getText().equals("Contactos") ? true:false;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }           

        // Si se presenta algún error retorna False
        return false;

    }

    /***
     * Hace clic en el botón de Contactos
     * para ingresar a la pantalla de ContactosHome
     */
    public void clickContactos()
    {        

        TestConfig.driver.findElement(By.cssSelector(selectorEnlaceContactos)).click();

    }

    /**
     * Cierra Sesión (Logout)
     */
    public void cerrarSesion()
    {
        TestConfig.driver.findElement(By.cssSelector(".oe_topbar_name")).click();
        TestConfig.driver.findElement(By.linkText("Cerrar sesión")).click();
    }

}
