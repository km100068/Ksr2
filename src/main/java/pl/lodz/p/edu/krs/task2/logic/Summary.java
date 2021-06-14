package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

@AllArgsConstructor
public abstract class Summary {
    protected static final String subject = "piosenek";
    protected final Quantifier q;
    protected final Label s;

    public abstract double T1();
    public abstract double T2();
    public abstract double T3();
    public abstract double T4();
    public abstract double T5();
    public abstract double T6();
    public abstract double T7();
    public abstract double T8();
    public abstract double T9();
    public abstract double T10();
    public abstract double T11();
}
