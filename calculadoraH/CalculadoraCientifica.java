public class CalculadoraCientifica extends Calculadora {

    // Método para calcular potência (exponenciação)
    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    // Método para calcular a raiz quadrada
    public double raizQuadrada(double numero) {
        if (numero >= 0) {
            return Math.sqrt(numero);
        } else {
            System.out.println("Erro: Número negativo");
            return -1;  // Retorna um valor inválido
        }
    }
}