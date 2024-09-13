package Genericos.InferenciaTipos.InstanciaDeClasses;

public class InstanciaDeClasses {
    public static void main(String[] args) {
        // Você pode substituir os argumentos de tipo necessários para invocar o construtor de uma 
        // classe genérica por um conjunto vazio de parâmetros de tipo ( <>) desde que o compilador 
        // possa inferir os argumentos de tipo do contexto. Este par de colchetes angulares é 
        // informalmente chamado de losango.
    
        // Exemplo:
        // Map<String, List<String>> myMap = new HashMap<String, List<String>>();
        // or
        // Map<String, List<String>> myMap = new HashMap<>();
    }
}
