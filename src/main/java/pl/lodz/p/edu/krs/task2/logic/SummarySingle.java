package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SummarySingle implements Summary {
    private Label s;
    private Label w;
    private Quantifier q;

    public String form1(List<Double> universe) {
        return q.getName() + " " + subject + " są " + s.getLabelName() + " [" + Degresses.truth(q, w, s, universe) + "]";
    }

    public String form2(List<Double> universe) {
        return q.getName() + " " + subject + " będących " + w.getLabelName() + " są " + s.getLabelName() + " [" + Degresses.truth((QuantifierRelative) q,w,s,universe);
    }
}
