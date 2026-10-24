package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenCartPage extends PageObject {

    private static final String URL_TIENDA = "http://opencart.abstracta.us/";
    private static final String URL_CARRITO = "http://opencart.abstracta.us/index.php?route=checkout/cart";
    private static final Duration ESPERA = Duration.ofSeconds(20);

    private void clicCuandoEsteListo(By locator) {
        $(locator).withTimeoutOf(ESPERA).waitUntilClickable().click();
    }

    public void abrirTienda() {
        openUrl(URL_TIENDA);
    }

    public void agregarProducto(String idProducto, String nombre) {
        clicCuandoEsteListo(By.cssSelector("button[onclick*=\"cart.add('" + idProducto + "'\"]"));
        new WebDriverWait(getDriver(), ESPERA).until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector(".alert-success"), nombre));
    }

    public void abrirCarrito() {
        openUrl(URL_CARRITO);
    }

    public String contenidoCarrito() {
        return $(By.id("content")).withTimeoutOf(ESPERA).waitUntilVisible().getText();
    }

    public void irACheckout() {
        clicCuandoEsteListo(By.linkText("Checkout"));
    }

    public void elegirInvitado() {
        clicCuandoEsteListo(By.cssSelector("input[name='account'][value='guest']"));
        clicCuandoEsteListo(By.id("button-account"));
    }

    public void llenarDatosFacturacion() {
        $(By.id("input-payment-firstname")).withTimeoutOf(ESPERA).waitUntilVisible().type("Alejandro");
        $(By.id("input-payment-lastname")).type("Castro");
        $(By.id("input-payment-email")).type("alejandro.test@mail.com");
        $(By.id("input-payment-telephone")).type("3001234567");
        $(By.id("input-payment-address-1")).type("Calle 10 # 20-30");
        $(By.id("input-payment-city")).type("Medellin");
        $(By.id("input-payment-postcode")).type("050001");
        $(By.id("input-payment-country")).selectByVisibleText("Colombia");
        waitABit(2000); // las regiones se cargan despues de elegir el pais
        $(By.id("input-payment-zone")).selectByIndex(1);
        clicCuandoEsteListo(By.id("button-guest"));
    }

    public void continuarMetodoEnvio() {
        clicCuandoEsteListo(By.id("button-shipping-method"));
    }

    public void aceptarTerminosYMetodoPago() {
        clicCuandoEsteListo(By.cssSelector("input[name='agree']"));
        clicCuandoEsteListo(By.id("button-payment-method"));
    }

    public void confirmarOrden() {
        clicCuandoEsteListo(By.id("button-confirm"));
    }

    public String tituloFinal(String esperado) {
        new WebDriverWait(getDriver(), ESPERA).until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("#content h1"), esperado));
        return $(By.cssSelector("#content h1")).getText();
    }
}