package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public abstract class SummarySingle extends Summary {

    public SummarySingle(List<Song> universe, Quantifier q, Label s) {
        super(universe, q, s);
    }

    @Override
    public abstract double T1();

    @Override
    public double T2() {
        return 1 - Math.pow(
                s.getLabels()
                        .stream()
                        .map(label -> 1.0*label.getFuzzySet().support(universe).size() / universe.size())
                        .mapToDouble(Double::doubleValue)
                        .reduce(1, (a,b) -> a*b), 1.0 / s.getLabels().size());
    }

    @Override
    public double T3() {
        return 0;
    }

    @Override
    public double T4() {
        return s.getLabels()
                .stream()
                .map(label -> universe
                        .stream()
                        .map(song -> label.getMembership(song) > 0 ? 1 : 0)
                        .mapToDouble(Integer::doubleValue).sum() / universe.size())
                .mapToDouble(Double::doubleValue).reduce(1, (a, b) -> a*b) - T3();
    }

    public double T5() {
        return 2 * Math.pow(0.5, s.getLabels().size());
    }

    public double T6() {
        double res = q.support();

        if (q instanceof QuantifierRelative) {
            res /= universe.size();
        }

        return 1 - res;
    }

    public double T7() {
        double res = q.support();

        if (q instanceof QuantifierRelative) {
            res /= universe.size();
        }

        return 1 - res;
    }

    @Override
    public double T8() {
        return 1 - s.getLabels()
                .stream()
                .map(label -> 1.0*label.getFuzzySet().support(universe).size() / universe.size())
                .mapToDouble(Double::doubleValue)
                .reduce(1, (a, b) -> a*b);
    }

    @Override
    public double T9() {
        return 0;
    }

    @Override
    public double T10() {
        return 0;
    }

    @Override
    public double T11() {
        return 0;
    }
}
