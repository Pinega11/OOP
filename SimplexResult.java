public class SimplexResult {
    private final double[] solutionVariables;
    private final double objectiveValue;

    public SimplexResult(double[] solutionVariables, double objectiveValue) {
        this.solutionVariables = solutionVariables;
        this.objectiveValue = objectiveValue;
    }

    public double[] getSolutionVariables() {
        return solutionVariables;
    }

    public double getObjectiveValue() {
        return objectiveValue;
    }
}