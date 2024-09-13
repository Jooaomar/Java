package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adicionando elementos
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Exibindo a lista
        System.out.print("Lista atual");
        list.printList();

        // Removendo um elemento
        list.remove(20);
        System.out.print("Após remover 20");
        list.printList();

        // Removendo um elemento que não está na lista
        list.remove(50);
    }
}
