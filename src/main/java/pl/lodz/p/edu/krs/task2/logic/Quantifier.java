package pl.lodz.p.edu.krs.task2.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class Quantifier {
    protected String name;
    protected MembershipFunction function;
    protected boolean abs;

    public double support() {
        return function.getParameter(function.getParametersLength() - 1) - function.getParameter(0);
    }

    public double cardinality() {
        return (function instanceof MembershipFunctionTrapetzoidal ?
                ((function.getParameter(3) - function.getParameter(0)) + (function.getParameter(2) - function.getParameter(1))) :
                (function.getParameter(2) - function.getParameter(0))) / 2;
    }

    @Override
    public String toString() {
        return name;
    }
}
