package LinkedList;

public class LinkedList {
    private Node head;  // primeiro nó da lista

    // Construtor da lista (inicia vazia)
    public LinkedList() {
        this.head = null;
    }

    // Método para adicionar um nó ao final da lista
    public void add(int data) {
        Node newNode = new Node(data);

        // Se a lista estiver vazia, o novo nó é o primeiro
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            // Percorre até o final da lista
            while (current.next != null) {
                current = current.next;
            }
            // Adicionar o novo nó no final
            current.next = newNode;
        }
    }

    // Método para remover o primeiro nó com um valor específico
    public void remove(int data) {
        if (head == null) {
            System.out.println("A lista está vazia");
            return;
        }

        // Se o nó a ser removido for o primeiro
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // Se encontrou o valor, remove o nó
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Valor não encontrado");
        }
    }

    // Método para exibir todos os elementos da lista
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
