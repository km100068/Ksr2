package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public abstract class SummaryMultiple extends Summary {
    protected final List<Song> set1;
    protected final List<Song> set2;
    protected final String set1Name;
    protected final String set2Name;

    public SummaryMultiple(List<Song> set1, List<Song> set2,
                           String set1Name, String set2Name,
                           Quantifier q, Label s) {
        super(q, s);

        this.set1 = set1;
        this.set2 = set2;
        this.set1Name = set1Name;
        this.set2Name = set2Name;
    }

    @Override
    public double T2() {
        return 0;
    }

    @Override
    public double T3() {
        return 0;
    }

    @Override
    public double T4() {
        return 0;
    }

    @Override
    public double T5() {
        return 0;
    }

    @Override
    public double T6() {
        return 0;
    }

    @Override
    public double T7() {
        return 0;
    }

    @Override
    public double T8() {
        return 0;
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
