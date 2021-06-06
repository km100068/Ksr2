package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public class SummarySingleForm2 extends SummarySingle {
    private final Label w;

    public SummarySingleForm2( List<Song> universe, QuantifierRelative q, Label w, Label s) {
        super(universe, q, s);

        this.w = w;
    }

    @Override
    public double T1() {
        return  q.getFunction().membership(
                universe
                        .stream()
                        .mapToDouble(value -> Math.min(s.getMembership(value), w.getMembership(value)))
                        .sum() / universe.stream().mapToDouble(w::getMembership).sum());
    }

    @Override
    public double T3() {
        return s.getFuzzySet().mupliply(w.getFuzzySet()).support(universe).stream().mapToDouble(Double::doubleValue).sum() /
                w.getFuzzySet().support(universe).stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public double T9() {
        return 1 - 1.0*w.getFuzzySet().support(universe).size() / universe.size();
    }

    @Override
    public double T10() {
        return 1 - w.getFuzzySet().cardinality(universe) / universe.size();
    }

    @Override
    public double T11() {
        return 2 * Math.pow(0.5, w.getLabels().size());
    }

    @Override
    public String toString() {
        return q.getName() + " " + subject + " będących " + w.getLabelName() + " są " + s.getLabelName();
    }
}
