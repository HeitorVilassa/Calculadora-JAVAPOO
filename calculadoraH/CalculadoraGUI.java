import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {
    private JTextField campoTexto;
    private Calculadora calculadora;
    private String operador;
    private double primeiroNumero, segundoNumero;

    public CalculadoraGUI() {
        // Inicializando a calculadora e a interface gráfica
        calculadora = new Calculadora();
        operador = "";

        // Configuração da janela (tamanho, título, etc.)
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(40, 40, 40));  // Cor de fundo da janela

        // Configuração do campo de texto para exibir os números e o resultado
        campoTexto = new JTextField();
        campoTexto.setEditable(false);
        campoTexto.setFont(new Font("Arial", Font.BOLD, 30));
        campoTexto.setBackground(new Color(60, 60, 60));
        campoTexto.setForeground(Color.WHITE);
        campoTexto.setHorizontalAlignment(SwingConstants.RIGHT);  // Alinhar o texto à direita
        campoTexto.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Bordas internas
        add(campoTexto, BorderLayout.NORTH);

        // Configuração do painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(5, 4, 10, 10));  // Grid de 5 linhas e 4 colunas
        painelBotoes.setBackground(new Color(40, 40, 40));

        // Definindo os botões com números e operações
        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE"
        };

        // Adicionando botões ao painel
        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.setBackground(new Color(50, 50, 50));
            botao.setForeground(Color.WHITE);
            botao.setFocusPainted(false);  // Remove o foco do botão
            botao.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
            botao.addActionListener(this);
            botao.setPreferredSize(new Dimension(80, 80));  // Tamanho dos botões
            painelBotoes.add(botao);
        }

        // Adicionando o painel de botões à janela
        add(painelBotoes, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "C":
                campoTexto.setText("");
                primeiroNumero = segundoNumero = 0;
                operador = "";
                break;
            case "CE":
                campoTexto.setText("");
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                primeiroNumero = Double.parseDouble(campoTexto.getText());
                operador = comando;
                campoTexto.setText("");
                break;
            case "=":
                segundoNumero = Double.parseDouble(campoTexto.getText());
                calcularResultado();
                break;
            default:  // Se for um número ou ponto decimal
                campoTexto.setText(campoTexto.getText() + comando);
                break;
        }
    }

    private void calcularResultado() {
        double resultado = 0;
        switch (operador) {
            case "+":
                resultado = calculadora.somar(primeiroNumero, segundoNumero);
                break;
            case "-":
                resultado = calculadora.subtrair(primeiroNumero, segundoNumero);
                break;
            case "*":
                resultado = calculadora.multiplicar(primeiroNumero, segundoNumero);
                break;
            case "/":
                resultado = calculadora.dividir(primeiroNumero, segundoNumero);
                break;
        }
        campoTexto.setText(String.valueOf(resultado));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI calculadoraGUI = new CalculadoraGUI();
            calculadoraGUI.setVisible(true);
        });
    }
}