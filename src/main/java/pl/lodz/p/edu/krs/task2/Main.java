package pl.lodz.p.edu.krs.task2;

import com.opencsv.exceptions.CsvException;
import pl.lodz.p.edu.krs.task2.logic.*;
import pl.lodz.p.edu.krs.task2.model.CsvReader;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CsvException, ParseException {
        List<Song> songs = CsvReader.getSongList();

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


        popularityLabels.add(new Label("popularność", "mało popularne", ff.createTrapezoidalFuzzySet(0, 0.15, 0.27, 0.35, Song::getPopularity)));
        popularityLabels.add(new Label("popularity", "średnio popularne", ff.createTrapezoidalFuzzySet(0.33, 0.46, 0.58, 0.66, Song::getPopularity)));
        popularityLabels.add(new Label("popularity", "popularne", ff.createTrapezoidalFuzzySet(0.65, 0.79, 0.88, 1, Song::getPopularity)));

        duration_msLables.add(new Label("trwałość", "bardzo któtkie", ff.createTrapezoidalFuzzySet(3400, 6000, 8000, 10000, Song::getDuration_ms)));
        duration_msLables.add(new Label("trwałość", "któtkie", ff.createTrapezoidalFuzzySet(9900, 13000, 16000, 20000, Song::getDuration_ms)));
        duration_msLables.add(new Label("trwałość", "przeciętne", ff.createTrapezoidalFuzzySet(19000, 25000, 37000, 50000, Song::getDuration_ms)));
        duration_msLables.add(new Label("trwałość", "długie", ff.createTrapezoidalFuzzySet(49000, 120000, 200000, 400000, Song::getDuration_ms)));
        duration_msLables.add(new Label("trwałość", "bardzo długie", ff.createTrapezoidalFuzzySet(399000, 1200000, 3000000, 5700000, Song::getDuration_ms)));

        danceabilityLables.add(new Label("taneczność", "mało taneczne", ff.createTrapezoidalFuzzySet(0, 0.10, 0.18, 0.30, Song::getDanceability)));
        danceabilityLables.add(new Label("taneczność", "średnio taneczne", ff.createTrapezoidalFuzzySet(0.29, 0.34, 0.44, 0.60, Song::getDanceability)));
        danceabilityLables.add(new Label("taneczność", "bardzo taneczne", ff.createTrapezoidalFuzzySet(0.59, 0.65, 0.80, 1, Song::getDanceability)));

        energyLables.add(new Label("energiczność","mało energiczne",ff.createTrapezoidalFuzzySet(0.13, 0.15, 0.19, 0.35, Song::getEnergy)));
        energyLables.add(new Label("energiczność","średnio energiczne",ff.createTrapezoidalFuzzySet(0.33, 0.46, 0.58, 0.66, Song::getEnergy)));
        energyLables.add(new Label("energiczność","mało energiczne",ff.createTrapezoidalFuzzySet(0.65, 0.79, 0.88, 0.98, Song::getEnergy)));

        loudnessLables.add(new Label("głośność","ciche",ff.createTrapezoidalFuzzySet(0, 0.05, 0.10, 0.15, Song::getLoudness)));
        loudnessLables.add(new Label("głośność","przeciętnie głośne",ff.createTrapezoidalFuzzySet(0.14, 0.18, 0.22, 0.26, Song::getLoudness)));
        loudnessLables.add(new Label("głośność","głośne",ff.createTrapezoidalFuzzySet(0.25, 0.31, 0.37, 0.43, Song::getLoudness)));
        loudnessLables.add(new Label("głośność","bardzo głośne",ff.createTrapezoidalFuzzySet(0.42, 0.49, 0.55, 0.60, Song::getLoudness)));

        speechinessLables.add(new Label("wokalność","mało wokalne",ff.createTrapezoidalFuzzySet(0, 0.15, 0.27, 0.37, Song::getSpeechiness)));
        speechinessLables.add(new Label("wokalność","średnio wokalne",ff.createTrapezoidalFuzzySet(0.36, 0.46, 0.58, 0.66, Song::getSpeechiness)));
        speechinessLables.add(new Label("wokalność","bardzo wokalne",ff.createTrapezoidalFuzzySet(0.65, 0.79, 0.88, 1, Song::getSpeechiness)));

        acousticnessLables.add(new Label("akustyczność","mało akustyczne",ff.createTrapezoidalFuzzySet(0.12, 0.25, 0.29, 0.35, Song::getAcousticness)));
        acousticnessLables.add(new Label("akustyczność","średnio akustyczne",ff.createTrapezoidalFuzzySet(0.33, 0.46, 0.58, 0.69, Song::getAcousticness)));
        acousticnessLables.add(new Label("akustyczność","bardzo akustyczne",ff.createTrapezoidalFuzzySet(0.65, 0.79, 0.88, 1, Song::getAcousticness)));

        instrumentalnessLables.add(new Label("instrumentalność","mało instrumentalne",ff.createTrapezoidalFuzzySet(0.14, 0.21, 0.27, 0.35, Song::getInstrumentalness)));
        instrumentalnessLables.add(new Label("instrumentalność","średnio instrumentalne",ff.createTrapezoidalFuzzySet(0.33, 0.46, 0.58, 0.69, Song::getInstrumentalness)));
        instrumentalnessLables.add(new Label("instrumentalność","bardzo instrumentalne",ff.createTrapezoidalFuzzySet(0.67, 0.79, 0.88, 0.98, Song::getInstrumentalness)));

        livenessLables.add(new Label("nastrój","smutne",ff.createTrapezoidalFuzzySet(0.16, 0.21, 0.29, 0.35, Song::getLiveness)));
        livenessLables.add(new Label("nastrój","pogodne",ff.createTrapezoidalFuzzySet(0.34, 0.46, 0.58, 0.72, Song::getLiveness)));
        livenessLables.add(new Label("nastrój","wesole",ff.createTrapezoidalFuzzySet(0.71, 0.79, 0.88, 0.99, Song::getLiveness)));


        tempoLables.add(new Label("tempo","słabe",ff.createTrapezoidalFuzzySet(0, 37, 43, 47, Song::getTempo)));
        tempoLables.add(new Label("tempo","średnie",ff.createTrapezoidalFuzzySet(46, 53, 80, 99, Song::getTempo)));
        tempoLables.add(new Label("tempo","szybkie",ff.createTrapezoidalFuzzySet(98, 120, 140, 170, Song::getTempo)));
        tempoLables.add(new Label("tempo","bardzo szybkie",ff.createTrapezoidalFuzzySet(169, 200, 230, 270, Song::getTempo)));


        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTrapezoidal("Mniej niż 500",0,0,99,499));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 500",490,600,700));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 750",690,750,900));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 1000",890,950,1500));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 2000",1490,2000,2500));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTrapezoidal("Więcej niż 2000",1900,2500,586654,586654));

        relativeQuantifiers.add(qf.createRelativeQuantifierTrapezoidal("Mniej niż jedna piąta",0,0,0.2,0.25));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około ćwiartki",0.24,0.33,0.41));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około połowy",0.4,0.5,0.6));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około  trzech czwartych",0.59,0.66,0.76));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Większość",0.75,0.83,0.93));
        relativeQuantifiers.add(qf.createRelativeQuantifierTrapezoidal("Prawie całość",0.85,0.9,1,1.05));


//        for (QuantifierRelative quantifier: relativeQuantifiers) {
//            for (Label label: danceabilityLables) {
//                System.out.println(SummarySingle.form1(songs, quantifier, label));
//            }
//        }
    }
}
