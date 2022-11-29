package testing.odoo.comun;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Clase que contiene métodos comunes que pueden ser utilizados durante un Test
 */
public class TestComun {

    /**
     * Método que espera a que un elemento sea clickeable y devuelve dicho elemento.
     * El selector debe ser de tipo CSS
     * 
     * @param selectorCSS Especifica el elemento mediante CSS selector
     * @return Elemento seleccionado.
     */
    public static WebElement esperarQueElementoSeaClickableCSS(String selectorCSS) throws Exception {

        Parametros parametros = Parametros.getParametros();

        WebElement elementoEnlaceContactos = new WebDriverWait(
                TestConfig.driver,
                Duration.ofSeconds(parametros.TIEMPO_MEDIO))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectorCSS)));
        return elementoEnlaceContactos;

    }

    /**
     * Método que espera a que un elemento sea clickeable y devuelve dicho elemento.
     * El selector debe ser de tipo ID
     * 
     * @param selectorCSS Especifica el elemento mediante ID
     * @return Elemento seleccionado.
     */
    public static WebElement esperarQueElementoSeaClickableID(String ID) throws Exception {

        Parametros parametros = Parametros.getParametros();

        WebElement elementoEnlaceContactos = new WebDriverWait(
                TestConfig.driver,
                Duration.ofSeconds(parametros.TIEMPO_MEDIO))
                .until(ExpectedConditions.elementToBeClickable(By.id(ID)));
        return elementoEnlaceContactos;

    }

    /**
     * Método que espera a que un elemento sea clickeable y devuelve dicho elemento.
     * El selector debe ser de tipo textLink
     * 
     * @param selectorCSS Especifica el elemento mediante ID
     * @return Elemento seleccionado.
     */
    public static WebElement esperarQueElementoSeaClickableTextLink(String textLink) throws Exception {

        Parametros parametros = Parametros.getParametros();

        WebElement elementoEnlaceContactos = new WebDriverWait(
                TestConfig.driver,
                Duration.ofSeconds(parametros.TIEMPO_MEDIO))
                .until(ExpectedConditions.elementToBeClickable(By.linkText(textLink)));
        return elementoEnlaceContactos;

    }

}
