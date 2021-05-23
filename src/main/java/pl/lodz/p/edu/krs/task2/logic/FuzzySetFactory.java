package pl.lodz.p.edu.krs.task2.logic;

import net.sourceforge.jFuzzyLogic.membership.*;

import java.util.ArrayList;
import java.util.List;

public class FuzzySetFactory {

    public FuzzySet createTrapezoidalFuzzySet(double a, double b, double c, double d, List<Double> universe) {
        MembershipFunction membershipFunction = new MembershipFunctionTrapetzoidal(
                new Value(a),
                new Value(b),
                new Value(c),
                new Value(d)
        );

        return new FuzzySet(universe, membershipFunction::membership);
    }

    public FuzzySet createTriangularFuzzySet(double a, double b, double c, List<Double> universe) {
        MembershipFunction membershipFunction = new MembershipFunctionTriangular(
                new Value(a),
                new Value(b),
                new Value(c)
        );

        return new FuzzySet(universe, membershipFunction::membership);
    }

    public FuzzySet createGaussianFuzzySet(double mean, double stdev, List<Double> universe) {
        MembershipFunction membershipFunction = new MembershipFunctionGaussian(new Value(mean), new Value(stdev));

        return new FuzzySet(universe, membershipFunction::membership);
    }

    public static void main(String[] args) {
        List<Double> set = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            set.add((double) i);
        }

        FuzzySet f = new FuzzySetFactory().createTrapezoidalFuzzySet(0, 5, 10, 50, set);

    }
}
