package pl.lodz.p.edu.krs.task2.logic;

import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;
import net.sourceforge.jFuzzyLogic.membership.Value;

public class QuantifierFactory {
    public QuantifierAbsolute createAbsoluteQuantifierTriangular(String name, double a, double b, double c) {
        return new QuantifierAbsolute(name,
                new MembershipFunctionTriangular(new Value(a), new Value(b), new Value(c)));
    }

    public QuantifierAbsolute createAbsoluteQuantifierTrapezoidal(String name, double a, double b, double c, double d) {
        return new QuantifierAbsolute(name,
                new MembershipFunctionTrapetzoidal(new Value(a), new Value(b), new Value(c), new Value(d)));
    }

    public QuantifierRelative createRelativeQuantifierTriangular(String name, double a, double b, double c) {
        return new QuantifierRelative(name,
                new MembershipFunctionTriangular(new Value(a), new Value(b), new Value(c)));
    }

    public QuantifierRelative createRelativeQuantifierTrapezoidal(String name, double a, double b, double c, double d) {
        return new QuantifierRelative(name,
                new MembershipFunctionTrapetzoidal(new Value(a), new Value(b), new Value(c), new Value(d)));
    }
}
