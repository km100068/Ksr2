package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public class SummaryMultipleForm4 extends SummaryMultiple {

    public SummaryMultipleForm4(List<Song> set1, List<Song> set2, String set1Name, String set2Name, Label s) {
        super(set1, set2, set1Name, set2Name, null, s);
    }

    private double I(double p, double q) {
        return 1 - p + p*q;
    }

    @Override
    public double T1() {
        return I(s.getFuzzySet().cardinality(set1) / set1.size(), s.getFuzzySet().cardinality(set2) / set2.size());
    }

    @Override
    public String toString() {
        return "Więcej " + set1Name + " niż " + set2Name + " jest " + s.getLabelName();
    }
}
