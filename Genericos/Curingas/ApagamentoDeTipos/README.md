## Apagamento de Tipos Genéricos

Os genéricos foram introduzidos na linguagem Java para fornecer verificações de tipo mais rigorosas em tempo de compilação e para dar suporte à programação genérica. Para implementar genéricos, o compilador Java aplica apagamento de tipo a:

* Substitua todos os parâmetros de tipo em tipos genéricos com seus limites ou Object se os parâmetros de tipo forem ilimitados. O bytecode produzido, portanto, contém apenas classes, interfaces e métodos comuns.
* Insira moldes de tipos, se necessário, para preservar a segurança dos tipos.
* Gere métodos de ponte para preservar o polimorfismo em tipos genéricos estendidos.
A eliminação de tipos garante que nenhuma nova classe seja criada para tipos parametrizados; consequentemente, os genéricos não incorrem em sobrecarga de tempo de execução.

Durante o processo de eliminação de tipo, o compilador Java apaga todos os parâmetros de tipo e substitui cada um pelo seu primeiro limite, se o parâmetro de tipo for limitado ou Objectse o parâmetro de tipo for ilimitado.

Considere a seguinte classe genérica que representa um nó em uma lista encadeada simples:


```java

public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}

```

Como o parâmetro de tipo Tnão tem limites, o compilador Java o substitui por Object:


```java
public class Node {

    private Object data;
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
    // ...
}

```

No exemplo a seguir, a Node classe genérica usa um parâmetro de tipo limitado:

```java
public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}
```

O compilador Java substitui o parâmetro de tipo limitado Tpela primeira classe limitada, Comparable:

```java
public class Node {

    private Comparable data;
    private Node next;

    public Node(Comparable data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data; }
    // ...
}

```

## Apagamento de métodos genéricos

O compilador Java também apaga parâmetros de tipo em argumentos de métodos genéricos. Considere o seguinte método genérico:

```java
// Counts the number of occurrences of elem in anArray.
//
public static <T> int count(T[] anArray, T elem) {
    int cnt = 0;
    for (T e : anArray)
        if (e.equals(elem))
            ++cnt;
        return cnt;
}
```

Como T não é limitado, o compilador Java o substitui por Object:

```java
public static int count(Object[] anArray, Object elem) {
    int cnt = 0;
    for (Object e : anArray)
        if (e.equals(elem))
            ++cnt;
        return cnt;
}
```

Suponha que as seguintes classes sejam definidas:

```java
class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }
```

Você pode escrever um método genérico para desenhar formas diferentes:

```java
public static <T extends Shape> void draw(T shape) { /* ... */ }
```

O compilador Java substitui T por Shape:

```java
public static void draw(Shape shape) { /* ... */ }
```

## Efeitos dos métodos de apagamento de tipo e ponte

Às vezes, a eliminação de tipo causa uma situação que você pode não ter previsto. O exemplo a seguir mostra como isso pode ocorrer. O exemplo a seguir mostra como um compilador às vezes cria um método sintético, que é chamado de método de ponte, como parte do processo de eliminação de tipo.

Dadas as duas classes seguintes:

```java
public class Node<T> {

    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

public class MyNode extends Node<Integer> {
    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
```
Considere o seguinte código:

```java
MyNode mn = new MyNode(5);
Node n = mn;            // A raw type - compiler throws an unchecked warning
n.setData("Hello");     // Causes a Class CastException to be thrown.
Integer x = mn.data;    
```

Após a eliminação do tipo, este código se torna:

```java
MyNode mn = new MyNode(5);
Node n = (MyNode)mn;         // A raw type - compiler throws an unchecked warning
n.setData("Hello");          // Causes a ClassCastException to be thrown.
Integer x = (String)mn.data; 
```
## Métodos de Ponte

Ao compilar uma classe ou interface que estende uma classe parametrizada ou implementa uma interface parametrizada, o compilador pode precisar criar um método sintético, que é chamado de método de ponte, como parte do processo de eliminação de tipo. Normalmente, você não precisa se preocupar com métodos de ponte, mas pode ficar confuso se um aparecer em um rastreamento de pilha.

Após a eliminação do tipo, as classes Node e MyNode se tornam:

```java
public class Node {

    public Object data;

    public Node(Object data) { this.data = data; }

    public void setData(Object data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

public class MyNode extends Node {

    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}

```

Após a eliminação do tipo, as assinaturas do método não correspondem; o Node.setData(T) método se torna Node.setData(Object). Como resultado, o MyNode.setData(Integer) método não substitui o Node.setData(Object) método.

Para resolver esse problema e preservar o polimorfismo de tipos genéricos após a eliminação de tipos, o compilador Java gera um método de ponte para garantir que a subtipagem funcione conforme o esperado.

Para a MyNodeclasse, o compilador gera o seguinte método de ponte para setData():

```java
class MyNode extends Node {

    // Bridge method generated by the compiler
    //
    public void setData(Object data) {
        setData((Integer) data);
    }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }

    // ...
}
```
O método bridge MyNode.setData(object) delega para o MyNode.setData(Integer) método original. Como resultado, a n.setData("Hello");declaração chama o método MyNode.setData(Object), e a ClassCastException é lançado porque "Hello"não pode ser convertido para Integer.

## Tipos não reificáveis

