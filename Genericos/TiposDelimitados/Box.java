/***
 * 
 *  liste o nome do parâmetro de tipo, seguido pela extendspalavra-chave, seguida por seu limite superior, que neste exemplo é Number.
 */

package Genericos.TiposDelimitados;

public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        // integerBox.inspect("sometext");
        integerBox.inspect(10);
    }
}

// Limites Múltiplos
// <T extends B1 & B2 & B3>

// Uma variável de tipo com múltiplos limites é um subtipo de todos os tipos listados no limite. Se um dos 
// limites for uma classe, ele deve ser especificado primeiro. Por exemplo:
// Class A { /* ... */ }
// interface B { /* ... */ }
// interface C { /* ... */ }
// class D <T extends A & B & C> { /* ... */ }

// Se bound Anão for especificado primeiro, você receberá um erro de tempo de compilação:
// class D <T extends B & A & C> { /* ... */ }  // compile-time error

