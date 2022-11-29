package testing.odoo.comun;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Parametros {

    /**
     * Ubicación donde se encuentra el archivo "chromedriver.exe"
     */
    public String RUTA_chromeDriver = "C:\\Programas\\chromedriver\\chromedriver.exe";

    /**
     * URL del sitio de Odoo que se va a probar
     */
    public String URL_BASE = "https://testingodoo1.odoo.com/web";

    /**
     * Usuario para ingresar al portal Web
     */
    public String LOGIN_USER = "irriru.info@gmail.com";

    /**
     * Password para ingresar al portal Web
     */
    public String LOGIN_PASS = "N72x6tqigfvvchA";

    public long TIEMPO_CORTO = 5;
    public long TIEMPO_MEDIO = 10;
    public long TIEMPO_LARGO = 20;
    public long TIME_OUT = 60;

    private static Parametros parametros = null;

    private Parametros() {

    }

    public static Parametros getParametros() {

        if (parametros == null) {
            parametros = new Parametros();

            Properties properties = new Properties();

            try {
                                                         
                properties.load(new FileReader("src/test/java/resources/config.properties"));

                parametros.LOGIN_PASS = properties.getProperty("LOGIN_PASS");
                parametros.LOGIN_USER = properties.getProperty("LOGIN_USER");
                parametros.RUTA_chromeDriver = properties.getProperty("RUTA_chromeDriver");
                parametros.TIEMPO_CORTO = Long.parseLong(properties.getProperty("TIEMPO_CORTO"));
                parametros.TIEMPO_LARGO = Long.parseLong(properties.getProperty("TIEMPO_LARGO"));
                parametros.TIEMPO_MEDIO = Long.parseLong(properties.getProperty("TIEMPO_MEDIO"));
                parametros.TIME_OUT = Long.parseLong(properties.getProperty("TIME_OUT"));
                parametros.URL_BASE = properties.getProperty("URL_BASE");


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                parametros = null;
            }
        }

        return parametros;

    }

}
