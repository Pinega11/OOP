import java.util.Scanner;

public class Limits {
    private final double[][] coefficients;
    private final double[] rightHandSide;
    private final String[] constraints;

    public Limits(int numConstraints, int numVariables) {
        coefficients = new double[numConstraints][numVariables];
        rightHandSide = new double[numConstraints];
        constraints = new String[numConstraints];
    }

    public void setCoefficientsConstraintsAndRightHandSideFromUserInput(Scanner scanner) {
        System.out.println("Введите коэффициенты ограничений, знаки и правую часть:");
        for (int i = 0; i < coefficients.length; i++) {
            for (int j = 0; j < coefficients[i].length; j++) {
                System.out.print("Коэффициент a" + (j + 1) + (j + 1) +" в ограничении " + (i + 1) + ": ");
                coefficients[i][j] = scanner.nextDouble();
            }
            System.out.print("Знак ограничения (=, >=, <=) в ограничении " + (i + 1) + ": ");
            constraints[i] = scanner.next();
            System.out.print("Правая часть b" + (i + 1) + ": ");
            rightHandSide[i] = scanner.nextDouble();
        }
    }

    public double[][] getCoefficients() {
        return coefficients;
    }

    public double[] getRightHandSide() {
        return rightHandSide;
    }

    public String[] getConstraints() {
        return constraints;
    }
}