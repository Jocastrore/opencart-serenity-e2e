Feature: Compra como invitado en OpenCart
  Scenario: Comprar dos productos con Guest Checkout
    Given el usuario abre la tienda OpenCart
    When agrega los productos "MacBook" y "iPhone" al carrito
    And visualiza el carrito
    And completa el checkout como invitado
    Then ve el mensaje "Your order has been placed!"