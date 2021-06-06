package pl.lodz.p.edu.krs.task2.logic;

import lombok.Getter;
import lombok.Setter;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Label implements Serializable {
    private final String linguisticVariableName;
    private final String labelName;
    private final FuzzySet fuzzySet;

    private List<Label> labels = new ArrayList<>();

    public Label(String linguisticVariableName, String labelName, FuzzySet fuzzySet) {
        this.linguisticVariableName = linguisticVariableName;
        this.labelName = labelName;
        this.fuzzySet = fuzzySet;
        this.labels.add(this);
    }

    public double getMembership(Song song) {
        return fuzzySet.getMembership(song);
    }

    public Label and(Label l) {
        Label newLabel = new Label(linguisticVariableName + " i " + l.linguisticVariableName, labelName + " i " + l.labelName, fuzzySet.mupliply(l.fuzzySet));
        List<Label> labels = new ArrayList<>(this.labels);
        labels.add(l);
        newLabel.setLabels(labels);
        return newLabel;
    }

    public Label or(Label l) {
        Label newLabel = new Label(linguisticVariableName + " czy " + l.linguisticVariableName, labelName + " czy " + l.labelName, fuzzySet.mupliply(l.fuzzySet));
        List<Label> labels = new ArrayList<>(this.labels);
        labels.add(l);
        newLabel.setLabels(labels);
        return newLabel;
    }

    public Label not() {
        Label newLabel = new Label(linguisticVariableName, "Nie " + labelName, fuzzySet.complete());
        List<Label> labels = new ArrayList<>(this.labels);
        newLabel.setLabels(labels);
        return newLabel;
    }

    @Override
    public String toString() {
        return labelName;
    }
}
