package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public abstract class SummaryMultiple extends Summary {
    protected final List<Song> set1;
    protected final List<Song> set2;
    protected final String set1Name;
    protected final String set2Name;

    public SummaryMultiple(List<Song> universe, List<Song> set1, List<Song> set2,
                           String set1Name, String set2Name,
                           Quantifier q, Label s) {
        super(universe, q, s);

        this.set1 = set1;
        this.set2 = set2;
        this.set1Name = set1Name;
        this.set2Name = set2Name;
    }

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

    @Override
    public double T5() {
        return 2 * Math.pow(0.5, s.getLabels().size());
    }

    @Override
    public double T6() {
        double res = q.support();

        if (q instanceof QuantifierAbsolute) {
            res /= universe.size();
        }

        return 1 - res;
    }

    @Override
    public double T7() {
        double res = q.cardinality();

        if (q instanceof QuantifierAbsolute) {
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
