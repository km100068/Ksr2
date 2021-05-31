package pl.lodz.p.edu.krs.task2.logic;

import java.util.List;
import java.util.stream.IntStream;

public class Degresses {
    public static double truth(Quantifier q, Label w, Label s, List<Double> universe) {
        if (w != null) {
            return q.getFunction().membership(
                    universe
                            .stream()
                            .mapToDouble(value -> Math.min(s.getMembership(value), w.getMembership(value)))
                            .sum() / universe.stream().mapToDouble(w::getMembership).sum());
        }

        double sum = universe.stream().mapToDouble(s::getMembership).sum() /
                (q.isAbs() ? 1 : universe.size());

        System.out.println("SUM: " + sum);

        return q.getFunction().membership(sum);
    }
}
