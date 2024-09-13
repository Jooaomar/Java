package Genericos.Curingas.ComLimitesInferior;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Método usando curinga com limite inferior <? super Integer> 
    // Significa que o método aceita qualquer classe superior em Integer
    //  ou seja Integer extends ClassNameAlguma
    public static void adicionarNumeros(List<? super Integer> lista) {
        // Adiciona inteiros na lista
        lista.add(10);
        lista.add(20);
    }

    public static void main(String[] args) {
        // Lista de Number (superclasse de Integer)
        List<Number> listNumeros = new ArrayList<>(); // Aceito
        List<Object> listObjetos = new ArrayList<>();
        List<Integer> listInteiros = new ArrayList<>();
        
        adicionarNumeros(listNumeros);
        adicionarNumeros(listObjetos);
        adicionarNumeros(listInteiros);
    }
}
