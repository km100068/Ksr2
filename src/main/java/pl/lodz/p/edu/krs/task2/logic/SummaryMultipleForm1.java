package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public class SummaryMultipleForm1 extends  SummaryMultiple {

    public SummaryMultipleForm1(List<Song> universe,
                                List<Song> set1, List<Song> set2,
                                String set1Name, String set2Name,
                                Quantifier q, Label s) {
        super(universe, set1, set2, set1Name, set2Name, q, s);
    }

    @Override
    public double T1() {
        return q.getFunction()
                .membership((s.getFuzzySet().cardinality(set1) / set1.size()) / (s.getFuzzySet().cardinality(set1) / set1.size() + s.getFuzzySet().cardinality(set2) / set2.size()));
    }

    @Override
    public String toString() {
        return q.getName() + ' ' + set1Name + " w porównaniu do " + set2Name + " jest " + s.getLabelName();
    }
}
