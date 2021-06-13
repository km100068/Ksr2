package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public class SummaryMultipleForm2 extends  SummaryMultiple {
    private final Label w;

    public SummaryMultipleForm2(List<Song> universe, List<Song> set1, List<Song> set2, String set1Name, String set2Name, Quantifier q, Label w, Label s) {
        super(universe, set1, set2, set1Name, set2Name, q, s);

        this.w = w;
    }


    @Override
    public double T1() {
        return (s.getFuzzySet().cardinality(set1) / set1.size()) / (s.getFuzzySet().cardinality(set1) / set1.size() + s.getFuzzySet().mupliply(w.getFuzzySet()).cardinality(set2) / set2.size());
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
        return q.getName() + ' ' + set1Name + " w porównaniu do tych " + set2Name + ", które są " + w.getLabelName() + ", jest " + s.getLabelName();
    }
}
