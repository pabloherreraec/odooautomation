package testing.odoo.page.contacto;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import testing.odoo.comun.TestComun;
import testing.odoo.comun.TestConfig;

/***
 * Clase que contiene las acciones sobre los elementos
 * de la pantalla para crear nuevo "Contacto"
 */
public class ContactoNewPage {

        /***
         * Hacer clic en el botón "Crear" para mostrar el formulario de Creación
         */
        public void crearContacto(String nombreContacto, String calle1, String calle2, String ciudad, String provincia,
                        String codigoPostal, String telefono1, String telefono2, String email, String webSite,
                        String categoria) {

                try {

                        // Verifica que el elemneto esté disponible para hacer click
                        WebElement inputNombreContacto = TestComun
                                        .esperarQueElementoSeaClickableCSS(
                                                        ".o_field_widget > .o-autocomplete > .o-autocomplete--input");
                        inputNombreContacto.click();
                        inputNombreContacto.sendKeys(nombreContacto);

                        // Llena la calle
                        TestConfig.driver.findElement(By.id("street")).click();
                        TestConfig.driver.findElement(By.id("street")).sendKeys(calle1);

                        // Llena la calle 2
                        TestConfig.driver.findElement(By.id("street2")).click();
                        TestConfig.driver.findElement(By.id("street2")).sendKeys(calle2);

                        // Llena la ciudad
                        TestConfig.driver.findElement(By.id("city")).click();
                        TestConfig.driver.findElement(By.id("city")).sendKeys(ciudad);

                        // Selecciona la provincia
                        seleccionarProvincia(provincia);

                        // Llena el código ZIP
                        TestConfig.driver.findElement(By.id("zip")).click();
                        TestConfig.driver.findElement(By.id("zip")).sendKeys(codigoPostal);

                        // Se selecciona le campo País (toma automático de la ciuidad y provincia)
                        TestConfig.driver.findElement(By.id("country_id")).click();
                        TestConfig.driver.findElement(By.id("country_id")).click();
                        TestConfig.driver.findElement(
                                        By.cssSelector(".o_inner_group:nth-child(2) > .o_wrap_field:nth-child(1) > .o_cell:nth-child(1)"))
                                        .click();
                        TestConfig.driver.findElement(
                                        By.cssSelector(".o_inner_group:nth-child(2) > .o_wrap_field:nth-child(2) > .o_cell:nth-child(1)"))
                                        .click();

                        // Llena el teléfono / email / web site y categoría
                        TestConfig.driver.findElement(By.id("phone")).click();
                        TestConfig.driver.findElement(By.id("phone")).sendKeys(telefono1);
                        TestConfig.driver.findElement(By.id("mobile")).click();
                        TestConfig.driver.findElement(By.id("mobile")).sendKeys(telefono2);
                        TestConfig.driver.findElement(By.id("email")).click();
                        TestConfig.driver.findElement(By.id("email")).sendKeys(email);
                        TestConfig.driver.findElement(By.id("website")).click();
                        TestConfig.driver.findElement(By.id("website")).sendKeys(webSite);
                        TestConfig.driver.findElement(By.id("category_id")).click();
                        TestConfig.driver.findElement(By.id("category_id")).click();
                        TestConfig.driver.findElement(By.id("category_id")).sendKeys(categoria);

                        // Pulsa el botón Crear
                        TestConfig.driver.findElement(By.cssSelector(".o_form_button_create")).click();

                        // Pulsa el link de contactos para volver a la Home contactos
                        TestConfig.driver.findElement(By.cssSelector(".breadcrumb .breadcrumb-item > a")).click();

                        // Realiza una búsqueda por filtro por nombre de contacto
                        WebElement inputBuscar = TestComun
                                        .esperarQueElementoSeaClickableCSS(".o_searchview_input_container > input");
                        inputBuscar.click();
                        inputBuscar.sendKeys(nombreContacto);
                        inputBuscar.sendKeys(Keys.RETURN);
                        Thread.sleep(2000);

                        // Verifica que aparezca la tarjeta del contacto
                        // Se obtiene el título de la tarjeta
                        WebElement txtTituloContacto = TestComun
                                        .esperarQueElementoSeaClickableCSS(".o_kanban_record_title > span");
                        String titulo = txtTituloContacto.getText();

                        // Si aparece un elemento filtrado y el nombre es igual al creado, entonces la
                        // prueba es exitosa
                        Assert.assertEquals(titulo.equals(nombreContacto), true,
                                        "No se encontró el contacto registrado");

                } catch (Exception e) {
                        // TODO: handle exception
                }
        }

        private void seleccionarProvincia(String provincia) throws Exception {
                // Selecciona la provincia
                WebElement comboProvincias = TestComun
                                .esperarQueElementoSeaClickableID("state_id");

                comboProvincias.click();

                comboProvincias.sendKeys(provincia.replace(" (EC)", ""));

                WebElement provinciaLink = TestComun
                                .esperarQueElementoSeaClickableTextLink(provincia);

                provinciaLink.click();
        }

}
