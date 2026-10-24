Prueba tecnica - Ejercicio 1: E2E de compra en OpenCart con Serenity BDD

Requisitos
- Java 21
- Maven 3.9.16 o superior
- Microsoft Edge instalado (configurado en src/test/resources/serenity.conf)
- Conexion a internet

Pasos a ejecutar
1) Clonar el repositorio:
    git clone https://github.com/Jocastrore/opencart-serenity-e2e.git
2) Entrar a la carpeta:
    cd opencart-serenity-e2e
3) Ejecutar la prueba (se abrira una ventana de Edge):
    mvn clean verify
4) Ver el reporte en el navegador:
    target/site/serenity/index.html
    (una copia de una ejecucion exitosa esta en evidencias/serenity-report/)

URL de la aplicacion
http://opencart.abstracta.us/ 

Que se prueba
Un escenario E2E: agregar dos productos (MacBook e iPhone), visualizar el
carrito, completar el Guest Checkout y llegar a la confirmacion
"Your order has been placed!".

Notas
- Para usar Chrome, cambiar driver = edge por driver = chrome en serenity.conf
  y ajustar las opciones del navegador.