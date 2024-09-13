package Genericos.SubTipos;

import Genericos.TiposDelimitados.Box;

// é possível atribuir um objeto de um tipo a um objeto de outro tipo, desde que os tipos sejam compatíveis.

public class SubTipos {
    public void someMethod(Number n) {/** */}

    public void main(String[] args) {

        // você pode atribuir um Integera um Object, já que Objecté um dos Integer supertipos de :
        Object somObject = new Object();
        Integer somInteger = new Integer(10);
        somObject = somInteger;  // OK

        someMethod(new Double(10.1)); // Ok
        someMethod(new Integer(10)); // Ok

        // O mesmo também é verdade com genéricos.
        // Box<Number> box = new Box<Number>();
        // box.add(new Integer(10));   // OK
        // box.add(new Double(10.1));  // OK

    }

}
