package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Quantifier {
    private String quantifierName;
    private FuzzySet fuzzySet;
    private Label label;

    public double degreeOfTruth() {
      return fuzzySet.getMembership(label.getFuzzySet().cardinality());
    };
}
