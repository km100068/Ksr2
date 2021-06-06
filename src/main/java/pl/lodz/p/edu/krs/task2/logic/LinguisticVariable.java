package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;
import net.sourceforge.jFuzzyLogic.membership.Value;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LinguisticVariable implements Serializable {
    @Getter
    private final String name;
    @Getter
    private final ArrayList<Label> labels = new ArrayList<>();

    public LinguisticVariable(String name) {
        this.name = name;
    }

    private void addLabel(String labelName, MembershipFunction membershipFunction, Function<Song, Double> extractor) {
        labels.add(new Label(
                name,
                labelName,
                new FuzzySet(d -> membershipFunction.membership(extractor.apply(d)))
        ));
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

    public void addLabel(final String labelName, double a, double b, double c, double d, Function<Song, Double> extractor) {
        MembershipFunctionTrapetzoidal membershipFunction = new MembershipFunctionTrapetzoidal(new Value(a), new Value(b), new Value(c), new Value(d));
        addLabel(labelName, membershipFunction, extractor);
    }

    public void addLabel(final String labelName, double a, double b, double c, Function<Song, Double> extractor) {
        MembershipFunctionTriangular membershipFunction = new MembershipFunctionTriangular(new Value(a), new Value(b), new Value(c));
        addLabel(labelName, membershipFunction, extractor);
    }

    public void removeLabel(final String labelName) {
        Optional<Label> label = labels.stream().filter(l -> l.getLabelName().equals(labelName)).findFirst();

        label.ifPresent(labels::remove);
    }

    @Override
    public String toString() {
        return name;
    }
}
