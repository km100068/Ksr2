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

        energyLables.add(new Label("energiczność","mało energiczna",ff.createTrapezoidalFuzzySet(13, 15, 19, 35)));
        energyLables.add(new Label("energiczność","średnio energiczna",ff.createTrapezoidalFuzzySet(33, 46, 58, 66)));
        energyLables.add(new Label("energiczność","mało energiczna",ff.createTrapezoidalFuzzySet(65, 79, 88, 98)));

        loudnessLables.add(new Label("głośność","cicha",ff.createTrapezoidalFuzzySet(0, 5, 10, 15)));
        loudnessLables.add(new Label("głośność","przeciętnie głośna",ff.createTrapezoidalFuzzySet(14, 18, 22, 26)));
        loudnessLables.add(new Label("głośność","głośna",ff.createTrapezoidalFuzzySet(25, 31, 37, 43)));
        loudnessLables.add(new Label("głośność","bardzo głośna",ff.createTrapezoidalFuzzySet(42, 49, 55, 60)));

        speechinessLables.add(new Label("wokalność","mało wokalna",ff.createTrapezoidalFuzzySet(0, 15, 27, 37)));
        speechinessLables.add(new Label("wokalność","średnio wokalna",ff.createTrapezoidalFuzzySet(36, 46, 58, 66)));
        speechinessLables.add(new Label("wokalność","bardzo wokalna",ff.createTrapezoidalFuzzySet(65, 79, 88, 100)));

        acousticnessLables.add(new Label("akustyczność","mało akustyczna",ff.createTrapezoidalFuzzySet(12, 25, 29, 35)));
        acousticnessLables.add(new Label("akustyczność","średnio akustyczna",ff.createTrapezoidalFuzzySet(33, 46, 58, 69)));
        acousticnessLables.add(new Label("akustyczność","bardzo akustyczna",ff.createTrapezoidalFuzzySet(65, 79, 88, 100)));

        instrumentalnessLables.add(new Label("instrumentalność","mało instrumentalna",ff.createTrapezoidalFuzzySet(14, 21, 27, 35)));
        instrumentalnessLables.add(new Label("instrumentalność","średnio instrumentalna",ff.createTrapezoidalFuzzySet(33, 46, 58, 69)));
        instrumentalnessLables.add(new Label("instrumentalność","bardzo instrumentalna",ff.createTrapezoidalFuzzySet(67, 79, 88, 98)));

        livenessLables.add(new Label("nastrój","smutna",ff.createTrapezoidalFuzzySet(16, 21, 29, 35)));
        livenessLables.add(new Label("nastrój","pogodna",ff.createTrapezoidalFuzzySet(34, 46, 58, 72)));
        livenessLables.add(new Label("nastrój","wesoła",ff.createTrapezoidalFuzzySet(71, 79, 88, 99)));


        tempoLables.add(new Label("tempo","słąbe",ff.createTrapezoidalFuzzySet(0, 37, 43, 47)));
        tempoLables.add(new Label("tempo","średnie",ff.createTrapezoidalFuzzySet(46, 53, 80, 99)));
        tempoLables.add(new Label("tempo","szybkie",ff.createTrapezoidalFuzzySet(98, 120, 140, 170)));
        tempoLables.add(new Label("tempo","bardzo szybke",ff.createTrapezoidalFuzzySet(169, 200, 230, 270)));


        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTrapezoidal("Mniej niż 500",0,0,99,499));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 500",490,600,700));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 750",690,750,900));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 1000",890,950,1500));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 2000",1490,2000,2500));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTrapezoidal("Więcej niż 2000",1900,2500,1200,12000));

        relativeQuantifiers.add(qf.createRelativeQuantifierTrapezoidal("Mniej niż jedna piąta",0,0,0.2,0.25));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około ćwiartki",0.24,0.33,0.41));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około połowy",0.4,0.5,0.6));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około  trzech czwartych",0.59,0.66,0.76));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Większość",0.75,0.83,0.93));
        relativeQuantifiers.add(qf.createRelativeQuantifierTrapezoidal("Prawie całość",0.85,0.9,1,1.05));


    }
}
