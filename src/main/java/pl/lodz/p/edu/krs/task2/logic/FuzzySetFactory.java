package pl.lodz.p.edu.krs.task2.logic;

import net.sourceforge.jFuzzyLogic.membership.*;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.function.Function;

public class FuzzySetFactory {

    public FuzzySet createTrapezoidalFuzzySet(double a, double b, double c, double d, Function<Song, Double> extractor) {
        MembershipFunction membershipFunction = new MembershipFunctionTrapetzoidal(
                new Value(a),
                new Value(b),
                new Value(c),
                new Value(d)
        );

        return new FuzzySet(song -> membershipFunction.membership(extractor.apply(song)));
    }

    public FuzzySet createTriangularFuzzySet(double a, double b, double c, Function<Song, Double> extractor) {
        MembershipFunction membershipFunction = new MembershipFunctionTriangular(
                new Value(a),
                new Value(b),
                new Value(c)
        );

        return new FuzzySet(song -> membershipFunction.membership(extractor.apply(song)));
    }

    public FuzzySet createGaussianFuzzySet(double mean, double stdev, Function<Song, Double> extractor) {
        MembershipFunction membershipFunction = new MembershipFunctionGaussian(new Value(mean), new Value(stdev));

        return new FuzzySet(song -> membershipFunction.membership(extractor.apply(song)));
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
