package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LinguisticVariable {
    @Getter
    private final String name;
    private final ArrayList<Label> labels = new ArrayList<>();
    private final List<Double> universe;

    public void addLabel(final String labelName, final Function<Double, Double> membershipFunction) {
        labels.add(new Label(
                name,
                labelName,
                new FuzzySet(membershipFunction)
        ));
    }

    public void removeLabel(final String labelName) {
        Optional<Label> label = labels.stream().filter(l -> l.getLabelName().equals(labelName)).findFirst();

        label.ifPresent(labels::remove);
    }

    private double getCompatibityLevelsFor(int index, Double value) {
        return labels.get(index).getMembership(value);
    }

    public List<Object[]> getCompatibilityLevels(Double value) {
        return labels
                .stream().map(label -> new Object[] {label.getLabelName(), label.getMembership(value)})
                .collect(Collectors.toList());
    }
}
