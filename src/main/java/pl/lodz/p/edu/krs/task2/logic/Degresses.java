package pl.lodz.p.edu.krs.task2.logic;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

public class Degresses {
    public static double T1(Quantifier q, Label w, Label s, List<Song> universe) {
        if (w != null) {
//            return
        }

        double sum = universe.stream().mapToDouble(s::getMembership).sum();

        return q.getFunction().membership(sum /
                (q.isAbs() ? 1 : (universe.size())));
    }
}
