/**
 * Inferência de tipo é a capacidade de um compilador Java de olhar para cada invocação de método e declaração 
 * correspondente para determinar o argumento de tipo (ou argumentos) que tornam a invocação aplicável. O algoritmo 
 * de inferência determina os tipos dos argumentos e, se disponível, o tipo que o resultado está sendo atribuído 
 * ou retornado. Finalmente, o algoritmo de inferência tenta encontrar o tipo mais específico que funciona com todos 
 * os argumentos.
 */

package Genericos.InferenciaTipos;

import Genericos.TiposDelimitados.Box;

public class BoxeDemo {
    
    public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }


    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
          U boxContents = box.get();
          System.out.println("Box #" + counter + " contains [" +
                 boxContents.toString() + "]");
          counter++;
        }
      }

    public static void main(String[] args) {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>();
        // o mesmo que: java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<Box<Integer>>();
        BoxeDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes); // Infere tipo Integer explicitamente
        BoxeDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);  // Infere tipo Integer implicitamente
        BoxeDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes); // Infere tipo Integer implicitamente
        BoxeDemo.outputBoxes(listOfIntegerBoxes); // Infere tipo objeto Box<Integer> implicitamente
    }
}
