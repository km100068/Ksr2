package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public class SummaryMultipleForm3 extends SummaryMultiple {
    private final Label w;

    public SummaryMultipleForm3(List<Song> set1, List<Song> set2, String set1Name, String set2Name, Quantifier q, Label w, Label s) {
        super(set1, set2, set1Name, set2Name, q, s);

        this.w = w;
    }

    @Override
    public double T1() {
        double up = s.getFuzzySet().mupliply(w.getFuzzySet()).cardinality(set1) / set1.size();

        return up / (up + s.getFuzzySet().cardinality(set2) / set2.size());
    }

    @Override
    public String toString() {
        return q.getName() + ' ' + set1Name + ", które są " + w.getLabelName() + ", w porównaniu do " + set2Name + ", jest " + s.getLabelName();
    }
}
