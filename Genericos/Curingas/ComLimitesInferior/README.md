Os **curingas com limite inferior** em Java são usados para restringir o tipo genérico para que aceite apenas um tipo específico ou seus supertipos. O curinga com limite inferior é representado por `<? super T>`, onde `T` é um tipo específico. Isso significa que você pode passar qualquer tipo que seja `T` ou um supertipo de `T`.

Essa funcionalidade é útil quando você quer garantir que o tipo genérico pode aceitar um valor do tipo `T`, ou de um subtipo de `T`, mas pode operar com um supertipo de `T` no contexto de leitura ou escrita.

### Exemplo:
Vamos criar um exemplo com uma classe `Number` e suas subclasses, como `Integer` e `Double`, e usar curingas com limite inferior.

```java
import java.util.List;
import java.util.ArrayList;

public class Main {

    // Método usando curinga com limite inferior <? super Integer>
    public static void adicionarNumeros(List<? super Integer> lista) {
        // Adiciona inteiros na lista
        lista.add(10);
        lista.add(20);
        lista.add(30);
    }

    public static void main(String[] args) {
        // Lista de Number (superclasse de Integer)
        List<Number> listaNumeros = new ArrayList<>();
        
        // Chama o método que aceita qualquer superclasse de Integer
        adicionarNumeros(listaNumeros);
        
        // Imprime os elementos da lista
        System.out.println(listaNumeros);
    }
}
```

### Explicação:
1. **Limite Inferior (`<? super Integer>`)**:
   - O método `adicionarNumeros(List<? super Integer> lista)` aceita qualquer `List` cujo tipo genérico seja `Integer` ou um **supertipo** de `Integer`. No exemplo, `Number` é um supertipo de `Integer`.
   - Isso permite que o método adicione valores do tipo `Integer` ou seus subtipos à lista, já que a lista pode aceitar qualquer tipo `Number` ou seus subtipos.

2. **Adicionando Elementos**:
   - Dentro do método, estamos adicionando inteiros (números do tipo `Integer`) à lista. Como a lista aceita `Integer` ou supertipos, isso é permitido.

3. **Impressão da Lista**:
   - Após adicionar os inteiros, a lista contém os valores adicionados e, quando a imprimimos, ela mostra `[10, 20, 30]`.

### Saída Esperada:
```
[10, 20, 30]
```

### Benefícios:
- Usar curingas com limite inferior permite flexibilidade ao passar tipos genéricos, garantindo que você possa trabalhar com superclasses.
- Isso é particularmente útil em situações onde você só precisa garantir que um valor do tipo `T` (neste caso, `Integer`) ou seus subtipos podem ser adicionados a uma estrutura de dados, mas você não precisa se preocupar com o tipo específico da lista além disso.

### Resumo:
- `<? super T>` permite que você trabalhe com `T` e seus **supertipos**.
- Isso é útil principalmente quando você deseja **adicionar** valores a uma estrutura de dados (como uma `List`) que pode operar com um supertipo de `T`.

### Entenda melhor:

No exemplo com **limite inferior** (`<? super Integer>`), ele **não aceita apenas `List<Number>`**. A ideia dos curingas com limite inferior é que a lista pode ser do tipo `Integer` ou de qualquer **supertipo** de `Integer`, ou seja, aceita `List<Number>`, `List<Object>`, mas **não** aceita `List<Double>`, `List<Float>`, ou `List<String>`.

Aqui está uma explicação detalhada:

### O que o `<? super Integer>` aceita?

- **`List<Number>`**: Sim, pois `Number` é um supertipo de `Integer`.
- **`List<Object>`**: Sim, pois `Object` é o supertipo mais alto de todos os tipos em Java, incluindo `Integer`.
- **`List<Integer>`**: Sim, pois `Integer` é o próprio tipo que estamos especificando.

### O que `<? super Integer>` **não** aceita?

- **`List<Double>`**: Não, pois `Double` é um **subtipo** de `Number`, mas não um supertipo de `Integer`.
- **`List<Float>`**: Não, pelo mesmo motivo que `List<Double>`. Embora ambos sejam subtipos de `Number`, eles não são supertipos de `Integer`.
- **`List<String>`**: Não, pois `String` não tem nenhuma relação com `Integer` na hierarquia de tipos.

### Exemplo de código para demonstrar o comportamento:

```java
import java.util.List;
import java.util.ArrayList;

public class Main {

    // Método com curinga de limite inferior <? super Integer>
    public static void adicionarNumeros(List<? super Integer> lista) {
        lista.add(10); // Adiciona Integers
        lista.add(20);
    }

    public static void main(String[] args) {
        List<Number> listaNumeros = new ArrayList<>();   // Aceito
        List<Object> listaObjetos = new ArrayList<>();   // Aceito
        List<Integer> listaInteiros = new ArrayList<>(); // Aceito
        
        adicionarNumeros(listaNumeros);
        adicionarNumeros(listaObjetos);
        adicionarNumeros(listaInteiros);

        // List<Double> listaDoubles = new ArrayList<>(); // Não aceito
        // adicionarNumeros(listaDoubles);               // Vai dar erro de compilação
    }
}
```

### Conclusão:

- `<? super Integer>` aceita qualquer `List` cujo tipo seja `Integer` ou um **supertipo** de `Integer`, como `Number` e `Object`.
- Não aceita subtipos de `Number`, como `Double` ou `Float`, porque o curinga está restrito aos **supertipos** de `Integer`.