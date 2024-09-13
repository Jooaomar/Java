/**
 * O curinga com limite superior é representado por <? extends T>, onde T é um tipo específico, e significa que 
 * a variável pode aceitar qualquer tipo que seja uma subclasse de T (ou o próprio T).
 * Veja isso em Zoologico.java
 */
package Genericos.Curingas.ComLimitesSuperior;

import java.util.ArrayList;
import java.util.List;


public class Mains {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();

        // Lisata de cachorros
        List<Cachorro> cachorros = new ArrayList<>();
        cachorros.add(new Cachorro());
        cachorros.add(new Cachorro());

        // Lista de gatos
        List<Gato> gatos = new ArrayList<>();
        gatos.add(new Gato());
        gatos.add(new Gato());


        // Fazendo barulhocom listas de diferentes tipos
        System.out.println("Barulhos dos cachorros:");
        zoologico.fazerBarulho(cachorros); // Aceita List<? extends Animal>

        System.out.println("\nBarulhosdos gatos:");
        zoologico.fazerBarulho(gatos); // Aceita List<? extends Animal>
    }
}
