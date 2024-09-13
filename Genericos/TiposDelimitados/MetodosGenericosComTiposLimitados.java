package Genericos.TiposDelimitados;

/**
 * Teremos erro de compilação nessa situação
 */
// public static <T> int countGreaterThan(T[] anArray, T elem) {
//     int count = 0;
//     for (T e : anArray)
//         if (e > elem)  // compiler error, isso porque anArray poder ser muitas coisas, inclusive um objeto que não seja compatível com a notação "e > elem"
//             ++count;
//     return count;
// }

public class MetodosGenericosComTiposLimitados {
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e: anArray)
            if (e.comparableTo(elem) > 0)
                ++count;
        return count;
    }
}
