import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

public class Simplex {
    public static SimplexResult optimize(double[] objectiveCoefficients, double[][] coefficients, double[] rightHandSide, String[] constraints, String objective) {
        int numVariables = objectiveCoefficients.length;
        LinearObjectiveFunction f = new LinearObjectiveFunction(objectiveCoefficients, 0);
        GoalType goalType = (objective.equals("max")) ? GoalType.MAXIMIZE : GoalType.MINIMIZE;
        LinearConstraintSet constraintsSet = createConstraints(coefficients, rightHandSide, constraints, numVariables);

        SimplexSolver solver = new SimplexSolver();
        PointValuePair solution = solver.optimize(new MaxIter(100), goalType, f, constraintsSet);

        double[] solutionVariables = solution.getPoint();
        double objectiveValue = solution.getValue();

        return new SimplexResult(solutionVariables, objectiveValue);
    }

    private static LinearConstraintSet createConstraints(double[][] coefficients, double[] rightHandSide, String[] constraints, int numVariables) {
        LinearConstraint[] linearConstraints = new LinearConstraint[constraints.length];
        for (int i = 0; i < constraints.length; i++) {
            Relationship relationship = getRelationship(constraints[i]);
            linearConstraints[i] = new LinearConstraint(coefficients[i], relationship, rightHandSide[i]);
        }
        return new LinearConstraintSet(linearConstraints);
    }

    private static Relationship getRelationship(String constraint) {
        switch (constraint) {
            case "=":
                return Relationship.EQ;
            case ">=":
                return Relationship.GEQ;
            case "<=":
                return Relationship.LEQ;
            default:
                return null;
        }
    }

}