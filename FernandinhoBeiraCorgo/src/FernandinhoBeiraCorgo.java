import java.util.Stack;

public class FernandinhoBeiraCorgo {
    public static double calcularExpressaoPosFixa(String expressao) {
        Stack<Double> pilha = new Stack<>();
        String[] elementos = expressao.split(" ");

        for (String elemento : elementos) {
            if (elemento.matches("\\d+(\\.\\d+)?")) {
                // Se for um número, empilhe na pilha
                pilha.push(Double.parseDouble(elemento));
            } else {
                // Caso contrário, é um operador, desempilhe operandos e aplique a operação
                double operando2 = pilha.pop();
                double operando1 = pilha.pop();
                double resultado = aplicarOperador(elemento, operando1, operando2);
                pilha.push(resultado);
            }
        }

        // O resultado final estará no topo da pilha
        return pilha.pop();
    }

    public static double aplicarOperador(String operador, double a, double b) {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Operador desconhecido: " + operador);
        }
    }

    public static void main(String[] args) {
        String expressaoPosFixa = "2 3 + 4 *"; // Exemplo de expressão em notação pós-fixa
        double resultado = calcularExpressaoPosFixa(expressaoPosFixa);

        System.out.println("Resultado da expressão: " + resultado);
    }
}