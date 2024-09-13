package Genericos.Curingas.Ilimitados;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Método que aceita uma lista de qualquer tipo usando coringa ilimitado <?>
    public static void imprimirLista(List<?> lista) {
        for (Object elemento : lista) {
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {
        // Lista de Inteiros
        List<Integer> listaInteiros = new ArrayList<>();
        listaInteiros.add(1);
        listaInteiros.add(2);
        listaInteiros.add(3);

        // Lista de Strings
        List<String> listaStrings = new ArrayList<>();
        listaStrings.add("Um");
        listaStrings.add("Dois");
        listaStrings.add("Três");

        // O método imprimirLista aceita qualquer tipo de lista
        imprimirLista(listaInteiros);  // Funciona com Integer
        imprimirLista(listaStrings);   // Funciona com String
    }
}
