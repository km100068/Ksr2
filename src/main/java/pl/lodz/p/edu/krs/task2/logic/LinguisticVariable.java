package pl.lodz.p.edu.krs.task2.logic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LinguisticVariable {
    @Getter
    private final String name;
    private final ArrayList<Label> labels = new ArrayList<>();
    private final List<Double> universe;

    public LinguisticVariable(String name,
                              List<Double> universe) {
        this.name = name;
        this.universe = universe;
    }

    public void addLabel(final String labelName, final Function<Double, Double> membershipFunction) {
        labels.add(new Label(
                name,
                labelName,
                new FuzzySet(universe, membershipFunction)
        ));
    }

    public void removeLabel(final String labelName) {
        Optional<Label> label = labels.stream().filter(l -> l.getLabelName().equals(labelName)).findFirst();

        label.ifPresent(labels::remove);
    }

    private double getCompatibilyLevelsFor(Label label, Double value) {
        return label.getMembership(value);
    }

    public List<Object[]> getCompatibilityLevels(Double value) {
        return labels
                .stream().map(label -> new Object[] {label.getLabelName(), label.getMembership(value)})
                .collect(Collectors.toList());
    }
}
