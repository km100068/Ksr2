package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class Quantifier {
    protected String name;
    protected MembershipFunction function;
    protected boolean abs;
}
