package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.List;

@Getter
@Setter
public class SummarySingleForm1 extends SummarySingle {

    public SummarySingleForm1(List<Song> universe, Quantifier q, Label s) {
        super(universe, q, s);
    }

    @Override
    public double T1() {
        return q
                .getFunction()
                .membership(universe
                        .stream()
                        .mapToDouble(s::getMembership)
                        .sum() / (q.isAbs() ? 1 : (universe.size())));
    }

    @Override
    public String toString() {
        return q.getName() + " " + subject + " są " + s.getLabelName();
    }
}
