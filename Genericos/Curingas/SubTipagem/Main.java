package Genericos.Curingas.SubTipagem;

public class Main {
    public static void main(String[] args) {
        /**
         * Quando uma classe herda de outra, exemplo: Class B extends A
         * A classe A é supertipo de B e a classe B é subtipo de A
         * 
         * class A { ... }
         * class B extends A { ... }
         * 
         * B b = new B();
         * A a = b;  // ok
         */

        //  List<B> lb = new ArrayList<>();
        //  List<A> la = lb;   // compile-time error
        // Isso por que List<A> não é subtipo de List<B>
        // Embora B seja um subtipo de A, List<B> não é subtipo de List<A>
        
        // Para criar um relacionamento podemos usar curinga com limite superior.
        // Exemplo: List<Integer> não é subtipo de List<Number>, mas possuem um pai comum
        // que é List<?>
        // Logo podemos usar limite superior para relacionalos como:
        // List<? extends Integer> intList = new ArrayList<>();
        // List<? extends Number> numList = inList; // Estamos dizendo: "Aceitamos subtipos de List<Number>"
        // Logo para List<A> la = lb; funcionar basta fazer:
        // List<? extends B> lb = new ArrayList<>() e List<? extends A> la = lb
    }
}
