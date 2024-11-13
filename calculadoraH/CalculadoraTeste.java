public class CalculadoraTeste {
    public static void main(String[] args) {
        // Testando a classe Calculadora
        Calculadora calc = new Calculadora();
        System.out.println("Soma: " + calc.somar(10, 5));
        System.out.println("Subtração: " + calc.subtrair(10, 5));
        System.out.println("Multiplicação: " + calc.multiplicar(10, 5));
        System.out.println("Divisão: " + calc.dividir(10, 5));
        System.out.println("Resultado Final: " + calc.getResultado());

        // Testando a classe CalculadoraCientifica
        CalculadoraCientifica calcCientifica = new CalculadoraCientifica();
        System.out.println("Potência: " + calcCientifica.potencia(2, 3));  // 2^3 = 8
        System.out.println("Raiz Quadrada: " + calcCientifica.raizQuadrada(16));  // √16 = 4
        System.out.println("Raiz Quadrada de número negativo: " + calcCientifica.raizQuadrada(-16));

        // Demonstrando Polimorfismo
        Calculadora calcPolimorfismo = new CalculadoraCientifica();
        System.out.println("Soma com polimorfismo: " + calcPolimorfismo.somar(7, 3));
    }
}