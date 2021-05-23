package pl.lodz.p.edu.krs.task2.logic;


public class QuantifierRelative extends Quantifier {
    public QuantifierRelative(String quantifierName, FuzzySet fuzzySet, Label label) {
        super(quantifierName, fuzzySet, label);
    }

    @Override
    public double degreeOfTruth() {
        return super.degreeOfTruth() / getFuzzySet().getUniverse().size();
    }
}
