import java.util.Scanner;

public class Function {
    private final double[] coefficients;

    public Function(int numVariables) {
        coefficients = new double[numVariables];
    }

    public void setCoefficientsFromUserInput(Scanner scanner) {
        System.out.println("Введите коэффициенты целевой функции:");
        for (int i = 0; i < coefficients.length; i++) {
            System.out.print("Коэффициент x" + (i + 1) + ": ");
            coefficients[i] = scanner.nextDouble();
        }
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}