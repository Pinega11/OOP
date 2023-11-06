import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите количество ограничений: ");
            int numConstraints = scanner.nextInt();
            System.out.println("Введите количество переменных: ");
            int numVariables = scanner.nextInt();

            Function function = new Function(numVariables);
            function.setCoefficientsFromUserInput(scanner);

            Limits limits = new Limits(numConstraints, numVariables);
            limits.setCoefficientsConstraintsAndRightHandSideFromUserInput(scanner);

            System.out.println("Хотите максимизировать или минимизировать функцию? (Введите max или min)");
            String objective = scanner.next();

            double[] objectiveCoefficients = function.getCoefficients();
            double[][] coefficients = limits.getCoefficients();
            double[] rightHandSide = limits.getRightHandSide();
            String[] constraints = limits.getConstraints();

            SimplexResult result = Simplex.optimize(objectiveCoefficients, coefficients, rightHandSide, constraints, objective);

            double objectiveValue = result.getObjectiveValue();

            DecimalFormat decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
            String roundedObjectiveValue = decimalFormat.format(objectiveValue);

            System.out.println("Z = : " + roundedObjectiveValue);

            double[] solutionVariables = result.getSolutionVariables();
            System.out.println("Переменные решения:");
            for (int i = 0; i < solutionVariables.length; i++) {
                String roundedSolutionVariable = decimalFormat.format(solutionVariables[i]);
                System.out.println("x" + (i + 1) + ": " + roundedSolutionVariable);
            }

        } catch (Exception e) {
            System.out.println("Ошибка!");
        }
    }
}