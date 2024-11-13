public class Calculadora {
    private double resultado;  // A variável de resultado é privada (encapsulada).

    // Método para somar
    public double somar(double a, double b) {
        resultado = a + b;
        return resultado;
    }

    // Método para subtrair
    public double subtrair(double a, double b) {
        resultado = a - b;
        return resultado;
    }

    // Método para multiplicar
    public double multiplicar(double a, double b) {
        resultado = a * b;
        return resultado;
    }

    // Método para dividir
    public double dividir(double a, double b) {
        if (b != 0) {
            resultado = a / b;
        } else {
            System.out.println("Erro: Divisão por zero");
            resultado = 0;
        }
        return resultado;
    }

    // Método para obter o resultado
    public double getResultado() {
        return resultado;
    }
}