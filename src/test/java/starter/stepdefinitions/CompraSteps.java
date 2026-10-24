package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.OpenCartPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CompraSteps {

    OpenCartPage tienda;

    @Given("el usuario abre la tienda OpenCart")
    public void abrirTienda() {
        tienda.abrirTienda();
    }

    @When("agrega los productos {string} y {string} al carrito")
    public void agregarProductos(String primero, String segundo) {
        tienda.agregarProducto(idDe(primero), primero);
        tienda.agregarProducto(idDe(segundo), segundo);
    }

    @When("visualiza el carrito")
    public void visualizarCarrito() {
        tienda.abrirCarrito();
        assertThat(tienda.contenidoCarrito()).contains("MacBook").contains("iPhone");
    }

    @When("completa el checkout como invitado")
    public void completarCheckout() {
        tienda.irACheckout();
        tienda.elegirInvitado();
        tienda.llenarDatosFacturacion();
        tienda.continuarMetodoEnvio();
        tienda.aceptarTerminosYMetodoPago();
        tienda.confirmarOrden();
    }

    @Then("ve el mensaje {string}")
    public void veMensaje(String esperado) {
        assertThat(tienda.tituloFinal(esperado)).contains(esperado);
    }

    private String idDe(String producto) {
        return switch (producto) {
            case "MacBook" -> "43";
            case "iPhone" -> "40";
            default -> throw new IllegalArgumentException("Producto no soportado: " + producto);
        };
    }
}