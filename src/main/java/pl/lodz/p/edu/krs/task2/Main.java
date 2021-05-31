package pl.lodz.p.edu.krs.task2;

import pl.lodz.p.edu.krs.task2.logic.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<QuantifierAbsolute> absoluteQuantifiers = new ArrayList<>();
        List<QuantifierRelative> relativeQuantifiers = new ArrayList<>();

        List<Label> popularityLabels = new ArrayList<>();
        List<Label> duration_msLables = new ArrayList<>();
        List<Label> danceabilityLables = new ArrayList<>();
        List<Label> energyLables = new ArrayList<>();
        List<Label> loudnessLables = new ArrayList<>();
        List<Label> speechinessLables = new ArrayList<>();
        List<Label> acousticnessLables = new ArrayList<>();
        List<Label> instrumentalnessLables = new ArrayList<>();
        List<Label> livenessLables = new ArrayList<>();
        List<Label> valenceLables = new ArrayList<>();
        List<Label> tempoLables = new ArrayList<>();


        QuantifierFactory qf = new QuantifierFactory();
        FuzzySetFactory ff = new FuzzySetFactory();


        popularityLabels.add(new Label("popularność", "mało popularna", ff.createTrapezoidalFuzzySet(0, 15, 27, 35)));
        popularityLabels.add(new Label("popularity", "średnio popularna", ff.createTrapezoidalFuzzySet(33, 46, 58, 66)));
        popularityLabels.add(new Label("popularity", "popularna", ff.createTrapezoidalFuzzySet(65, 79, 88, 100)));

        duration_msLables.add(new Label("trwałość", "bardzo któtka", ff.createTrapezoidalFuzzySet(3400, 6000, 8000, 10000)));
        duration_msLables.add(new Label("trwałość", "któtka", ff.createTrapezoidalFuzzySet(9900, 13000, 16000, 20000)));
        duration_msLables.add(new Label("trwałość", "przeciętna", ff.createTrapezoidalFuzzySet(19000, 25000, 37000, 50000)));
        duration_msLables.add(new Label("trwałość", "długa", ff.createTrapezoidalFuzzySet(49000, 120000, 200000, 400000)));
        duration_msLables.add(new Label("trwałość", "bardzo długa", ff.createTrapezoidalFuzzySet(399000, 1200000, 3000000, 5700000)));

        danceabilityLables.add(new Label("taneczność", "mało taneczna", ff.createTrapezoidalFuzzySet(0, 10, 18, 30)));
        danceabilityLables.add(new Label("taneczność", "średnio taneczna", ff.createTrapezoidalFuzzySet(29, 34, 44, 60)));
        danceabilityLables.add(new Label("taneczność", "bardzo taneczna", ff.createTrapezoidalFuzzySet(59, 65, 80, 100)));


    }
}
