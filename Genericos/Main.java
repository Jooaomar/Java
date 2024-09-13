package Genericos;

public class Main {
    Pair<Integer, String> p1 = new Pair<Integer,String>(1, "apple");
    Pair<Integer, String> p2 = new Pair<Integer,String>(2, "pear");

    boolean same = Util.<Integer, String>compare(p1, p2);
    // boolean same = Util.compare(p1, p2); // modo implícito
}
