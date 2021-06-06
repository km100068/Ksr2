package pl.lodz.p.edu.krs.task2.logic;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuzzySet {
    private Function<Song, Double> membershipFunction;

    public double getMembership(Song song) {
        return membershipFunction.apply(song);
    }

    public FuzzySet complete() {
        return new FuzzySet((d) -> 1 - membershipFunction.apply(d));
    }

    public FuzzySet mupliply(FuzzySet f) {
        return new FuzzySet(d -> Double.min(membershipFunction.apply(d), f.membershipFunction.apply(d)));
    }

    public FuzzySet add(FuzzySet f) {
        return new FuzzySet(d -> Double.max(membershipFunction.apply(d), f.membershipFunction.apply(d)));
    }

    public double height(List<Song> universe) {
        Optional<Double> res = universe.stream().map(this::getMembership).max(Double::compare);

        return res.orElse(Double.NaN);
    }

    public double cardinality(List<Song> universe) {
        return universe.stream().map(this::getMembership).mapToDouble(Double::doubleValue).sum();
    }

    public List<Double> support(List<Song> universe) {
        return universe.stream()
                .map(item -> new Object[] {item, getMembership(item)})
                .filter(item -> (double) item[1] > 0)
                .map(item -> (Double) item[1])
                .collect(Collectors.toList());
    }

    public List<Double> alphacut(List<Song> universe, double alpha) {
        return universe.stream()
                .map(item -> new Object[] {item, getMembership(item)})
                .filter(item -> (double) item[1] >= alpha)
                .map(item -> (Double) item[0])
                .collect(Collectors.toList());
    }

    public boolean isEmpty(List<Song> universe) {
        return universe.stream().map(this::getMembership).mapToDouble(Double::doubleValue).sum() == 0;
    }

    public boolean isConvex() {
        //TODO
        return false;
    }

    public boolean isNormal(List<Song> universe) {
        return height(universe) == 1;
    }
}
