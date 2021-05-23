package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Label {
    private String linguisticVariableName;
    private String labelName;
    private FuzzySet fuzzySet;

    public double getMembership(Double value) {
        return fuzzySet.getMembership(value);
    }

    public Label and(Label l) {
        return new Label(linguisticVariableName, labelName + " i " + l.labelName, fuzzySet.mupliply(l.fuzzySet));
    }

    public Label or(Label l) {
        return new Label(linguisticVariableName, labelName + " czy " + l.labelName, fuzzySet.mupliply(l.fuzzySet));
    }

    public Label not() {
        return new Label(linguisticVariableName, "Nie " + labelName, fuzzySet.complete());
    }
}
