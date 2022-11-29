package testing.odoo.page.contacto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testing.odoo.comun.TestConfig;
import testing.odoo.comun.TestComun;

/***
 * Clase que contiene las acciones sobre los elementos
 * de la pantalla inicial de "Contactos"
 */
public class ContactoHomePage {

    private String selectorBotonCrear = ".btn-primary";

    /***
     * Hace una validación de se visualice el botón "Crear"
     * en la Pantalla de Inicio de Contactos
     * 
     * @return
     */
    public boolean assertBotonCrear() {

        try {

            // Verifica que el elemneto esté disponible para hacer click
            WebElement elementoEnlaceContactos;
            elementoEnlaceContactos = TestComun.esperarQueElementoSeaClickableCSS(selectorBotonCrear);

            // Verifica que diga la palablar "CREAR"
            return elementoEnlaceContactos.getText().equals("CREAR") ? true : false;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Si se presenta algún error retorna False
        return false;

    }

    /***
     * Hacer clic en el botón "Crear" para mostrar el formulario de Creación
     */
    public void clickCrear() {
        TestConfig.driver.findElement(By.cssSelector(selectorBotonCrear)).click();
    }

}
