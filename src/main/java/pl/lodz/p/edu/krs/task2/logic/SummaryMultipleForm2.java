package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public class SummaryMultipleForm2 extends  SummaryMultiple {
    private final Label w;

    public SummaryMultipleForm2(List<Song> set1, List<Song> set2, String set1Name, String set2Name, Quantifier q, Label w, Label s) {
        super(set1, set2, set1Name, set2Name, q, s);

        this.w = w;
    }


    @Override
    public double T1() {
        double up = s.getFuzzySet().cardinality(set1) / set1.size();
        double down = up + s.getFuzzySet().mupliply(w.getFuzzySet()).cardinality(set2) / set2.size();
        double res = up / down;

        return q.getFunction().membership(res);
    }

    @Override
    public String toString() {
        return q.getName() + ' ' + set1Name + " w porównaniu do tych " + set2Name + ", które są " + w.getLabelName() + ", jest " + s.getLabelName();
    }
}
