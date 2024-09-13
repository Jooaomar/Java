package Genericos.Curingas.Wildcard;

import java.util.List;

public class Map {
    
    // Em alguns casos, o compilador infere o tipo de um curinga. Por exemplo, uma lista pode ser 
    // definida como List<?>mas, ao avaliar uma expressão, o compilador infere um tipo específico 
    // do código. Esse cenário é conhecido como captura de curinga.

    // void foo(List<?> i) {
    //     i.set(0, i.get(0));
    // }

    // Terá um erro:
    // WildcardError.java:6: error: method set in interface List<E> cannot be applied to given types;
    // i.set(0, i.get(0));
    // required: int, CAP#1
    // found: int, Object
    // reason: actual argument Object cannot be converted to CAP#1 by method invocation conversion
    // where E is a type-variable:
    //     E extends Object declared in interface List
    // where CAP#1 is a fresh type-variable:
    //     CAP#1 extends Object from capture of ?

    // Neste exemplo, o código está tentando executar uma operação segura, então como você pode contornar 
    // o erro do compilador? Você pode corrigi-lo escrevendo um método auxiliar privado que captura o 
    // curinga. Neste caso, você pode contornar o problema criando o método auxiliar privado, , fooHelper()
    // conforme mostrado em WildcardFixed:

    // void foo(List<?> i) {
    //     fooHelper(i);
    // }
    // private <T> void fooHelper(List<T> l) {
    //     l.set(0, l.get(0));
    // }

    // Graças ao método helper, o compilador usa inferência para determinar que T é CAP#1, a variável de captura, 
    // na invocação. O exemplo agora compila com sucesso.

}
