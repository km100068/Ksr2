package pl.lodz.p.edu.krs.task2.logic;

import net.sourceforge.jFuzzyLogic.membership.*;

import java.util.ArrayList;
import java.util.List;

public class FuzzySetFactory {

    public FuzzySet createTrapezoidalFuzzySet(double a, double b, double c, double d) {
        MembershipFunction membershipFunction = new MembershipFunctionTrapetzoidal(
                new Value(a),
                new Value(b),
                new Value(c),
                new Value(d)
        );

        return new FuzzySet(membershipFunction::membership);
    }

    public FuzzySet createTriangularFuzzySet(double a, double b, double c, List<Double> universe) {
        MembershipFunction membershipFunction = new MembershipFunctionTriangular(
                new Value(a),
                new Value(b),
                new Value(c)
        );

        return new FuzzySet(membershipFunction::membership);
    }

    public FuzzySet createGaussianFuzzySet(double mean, double stdev) {
        MembershipFunction membershipFunction = new MembershipFunctionGaussian(new Value(mean), new Value(stdev));

        return new FuzzySet(membershipFunction::membership);
    }

    public static void main(String[] args) {
        Quantifier q = new QuantifierRelative("a", null);
        System.out.println(q.getClass().getName().substring(30));

        System.out.println((QuantifierRelative) q);

//        List<Double> set = new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//            set.add((double) i);
//        }
//
//        FuzzySet f = new FuzzySetFactory().createTrapezoidalFuzzySet(0, 5, 10, 50, set);
//
    }
}
