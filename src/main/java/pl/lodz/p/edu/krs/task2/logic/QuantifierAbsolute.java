package pl.lodz.p.edu.krs.task2.logic;


import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;

import java.util.List;

public class QuantifierAbsolute extends Quantifier {
    public QuantifierAbsolute(String name, MembershipFunction function) {
        super(name, function, true);
    }
}
