O **coringa ilimitado** em Java é representado pelo símbolo `<?>` e é usado quando não há restrições sobre o tipo genérico. Ele permite que um método ou classe aceite qualquer tipo de parâmetro genérico, sem limites superiores ou inferiores. Esse coringa é útil quando você precisa manipular uma coleção ou objeto genérico, mas não precisa realizar operações específicas que dependam do tipo exato.

Aqui está um exemplo prático:

### Exemplo de Coringa Ilimitado (`<?>`)

```java
import java.util.List;
import java.util.ArrayList;

public class Main {

    // Método que aceita uma lista de qualquer tipo usando coringa ilimitado <?>
    public static void imprimirLista(List<?> lista) {
        for (Object elemento : lista) {
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {
        // Lista de Inteiros
        List<Integer> listaInteiros = new ArrayList<>();
        listaInteiros.add(1);
        listaInteiros.add(2);
        listaInteiros.add(3);

        // Lista de Strings
        List<String> listaStrings = new ArrayList<>();
        listaStrings.add("Um");
        listaStrings.add("Dois");
        listaStrings.add("Três");

        // O método imprimirLista aceita qualquer tipo de lista
        imprimirLista(listaInteiros);  // Funciona com Integer
        imprimirLista(listaStrings);   // Funciona com String
    }
}
```

### Explicação:

1. **Coringa Ilimitado (`<?>`)**:
   - O método `imprimirLista(List<?> lista)` aceita uma lista de **qualquer tipo**. Isso significa que a lista pode conter `Integer`, `String`, ou qualquer outro tipo.
   - O uso de `<?>` torna o método flexível, permitindo trabalhar com listas de diferentes tipos sem precisar especificar um tipo exato.

2. **Uso de `Object` no Laço**:
   - Como o método não sabe qual é o tipo específico da lista, ele trata os elementos como `Object`. No `for`, usamos `Object elemento` para iterar sobre os elementos da lista, já que `Object` é o supertipo de todos os tipos em Java.

3. **Polimorfismo**:
   - Esse método pode ser chamado com listas de qualquer tipo, seja `List<Integer>`, `List<String>`, ou qualquer outro tipo, o que demonstra a flexibilidade do coringa ilimitado.

### Saída Esperada:
```
1
2
3
Um
Dois
Três
```

### Restrições:
- **Adicionar elementos**: Ao usar `<?>`, você não pode adicionar elementos à lista dentro do método, porque o tipo exato não é conhecido. Só é possível ler os elementos.
- **Limitações no tipo de retorno**: Como não há restrições de tipo, você não pode usar métodos específicos de um tipo genérico (por exemplo, métodos definidos para `Integer` ou `String`) sem realizar castings.

### Conclusão:
O coringa ilimitado (`<?>`) é útil quando você precisa de flexibilidade máxima, mas não precisa realizar operações que dependam do tipo exato da coleção ou objeto. Ele permite que você trabalhe com qualquer tipo genérico, mas limita algumas operações como adição de elementos à lista.