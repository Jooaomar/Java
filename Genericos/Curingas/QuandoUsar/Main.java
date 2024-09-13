/**
 * Um dos aspectos mais confusos ao aprender a programar com genéricos é determinar quando usar um 
 * curinga de limite superior e quando usar um curinga de limite inferior.
 */

package Genericos.Curingas.QuandoUsar;


public class Main {
    public static void main(String[] args) {
        // Pense em variáveis ​​como fornecendo uma de duas funções: 'in' ou 'out'
        // Uma variável "In". Uma variável "in" serve dados para o código.
        
        // Imagine um método copy com dois argumentos: copy(src, dest). O 'src' argumento 
        // fornece os dados a serem copiados, então é o parâmetro "in".
        // Uma variável "Out". Uma variável "out" contém dados para uso em outro lugar. No 
        // exemplo de cópia, copy(src, dest), o 'dest' argumento aceita dados, então é o parâmetro "out".
        
        // É claro que algumas variáveis ​​são usadas tanto para propósitos de "entrada" quanto de "saída" — esse 
        // cenário também é abordado nas diretrizes.

        // Você pode usar o princípio "in" e "out" ao decidir se deve usar um curinga e qual tipo de curinga é apropriado.

        // Uma variável "in" é definida com um curinga com limite superior, usando a extends palavra-chave.
        // Uma variável "out" é definida com um curinga de limite inferior, usando a super palavra-chave.
        // No caso em que a variável "in" pode ser acessada usando métodos definidos na Object classe, use um curinga ilimitado.
        // No caso em que o código precisa acessar a variável como uma variável "de entrada" e "de saída", não use um curinga.

        // OBS: Essas diretrizes não se aplicam ao tipo de retorno de um método. 
        //  Usar um curinga como tipo de retorno deve ser evitado porque força os programadores 
        // que usam o código a lidar com curingas.

        // Uma lista definida por List<? extends ...>pode ser informalmente considerada somente leitura, mas isso não é uma
        // garantia estrita. Suponha que você tenha as duas classes a seguir

        // class NaturalNumber {

        //     private int i;
        
        //     public NaturalNumber(int i) { this.i = i; }
        // }
        
        // class EvenNumber extends NaturalNumber {
        
        //     public EvenNumber(int i) { super(i); }
        // }

        // List<EvenNumber> le = new ArrayList<>();
        // List<? extends NaturalNumber> ln = le;
        // ln.add(new NaturalNumber(35));  // compile-time error

        // List<EvenNumber>é um subtipo de List<? extends NaturalNumber>, você pode atribuir le a ln. 
        // Mas você não pode usar lnpara adicionar um número natural a uma lista de números pares. 
        // As seguintes operações na lista são possíveis:
        // Você pode adicionar null.
        // Você pode invocar clear().
        // Você pode obter o iterador e invocar remove().
        // Você pode capturar o curinga e escrever elementos que você leu da lista.

        // Você pode ver que a lista definida por List<? extends NaturalNumber> não é somente leitura no sentido 
        // mais estrito da palavra, mas você pode pensar dessa forma porque não é possível armazenar um novo 
        // elemento ou alterar um elemento existente na lista.
    }
}
