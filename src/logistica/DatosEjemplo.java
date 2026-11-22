package logistica;

/** Datos ficticios del centro para reproducir la demostración. */
final class DatosEjemplo {
    private DatosEjemplo() {}
    static void cargar(ArbolInventario inventario, ColaCamiones cola, GrafoRutas red) {
        inventario.insertar(new Producto(430, "Aceite vegetal", 90));
        inventario.insertar(new Producto(215, "Arroz superior", 120));
        inventario.insertar(new Producto(670, "Sal de mesa", 80));
        inventario.insertar(new Producto(125, "Azúcar rubia", 70));
        inventario.insertar(new Producto(310, "Fideos cortos", 65));
        cola.encolar(new Camion("TCA-301", "Ana Rojas", 5));
        cola.encolar(new Camion("TCA-302", "Luis Gil", 8));
        cola.encolar(new Camion("TCA-303", "Eva León", 6));
        red.agregarCiudad("Trujillo");
        red.agregarCiudad("Virú");
        red.agregarCiudad("Chao");
        red.agregarCiudad("Chicama");
        red.agregarCiudad("Ascope");
        red.agregarRuta("Trujillo", "Virú", 48);
        red.agregarRuta("Trujillo", "Chao", 52);
        red.agregarRuta("Virú", "Chicama", 18);
        red.agregarRuta("Chao", "Ascope", 23);
    }
}
