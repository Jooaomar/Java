package Metodos.MetodosSobrecarga;

public class Calculadora {

    // Método que soma dois inteiros
    public int soma(int a, int b) {
        return a + b;
    }

    // Sobrecarga do método soma, que soma três inteiros
    public int soma(int a, int b, int c) {
        return a + b + c;
    }

    // Sobrecarga do método soma, que soma dois números de ponto flutuante (double)
    public double soma(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Chamando o método soma com dois inteiros
        int resultado1 = calc.soma(10, 20);
        System.out.println("Soma de dois inteiros: " + resultado1);

        // Chamando o método soma com três inteiros
        int resultado2 = calc.soma(10, 20, 30);
        System.out.println("Soma de três inteiros: " + resultado2);

        // Chamando o método soma com dois números de ponto flutuante
        double resultado3 = calc.soma(10.5, 20.3);
        System.out.println("Soma de dois doubles: " + resultado3);
    }
}
