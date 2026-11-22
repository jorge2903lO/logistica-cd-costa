package logistica;

import java.util.Arrays;
import java.util.Vector;

/** Comprobación repetible de los datos iniciales y las reglas de cada estructura. */
public class PruebaEstructuras {
    private static void comprobar(boolean valor) {
        if (!valor) throw new AssertionError("Resultado inesperado");
    }
    public static void main(String[] args) {
        ArbolInventario arbol = new ArbolInventario();
        ColaCamiones cola = new ColaCamiones();
        GrafoRutas grafo = new GrafoRutas();
        DatosEjemplo.cargar(arbol, cola, grafo);
        Vector<Producto> salida = new Vector<>();
        arbol.inOrden(salida);
        comprobar(salida.size() == 5 && arbol.altura() == 3);
        for (int i = 1; i < salida.size(); i++)
            comprobar(salida.get(i - 1).getCodigo() < salida.get(i).getCodigo());
        comprobar(grafo.bfs("Trujillo").size() == 5);
        comprobar(grafo.distanciaRuta(Arrays.asList("Chicama", "Virú", "Trujillo")) == 66);
        comprobar(cola.desencolar().getPlaca().equals("TCA-301"));
        int stock = arbol.buscar(430).getStock();
        arbol.descontarStock(430, 3);
        comprobar(arbol.buscar(430).getStock() == stock - 3);
        try { arbol.descontarStock(430, stock + 1); throw new AssertionError(); }
        catch (IllegalStateException esperado) { comprobar(arbol.buscar(430).getStock() == stock - 3); }
        System.out.println("Pruebas de ABB, FIFO, BFS, distancia y stock correctas.");
    }
}
