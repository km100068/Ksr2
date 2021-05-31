package pl.lodz.p.edu.krs.task2.logic;


import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;

import java.util.List;

public class QuantifierRelative extends Quantifier {
    public QuantifierRelative(String name, MembershipFunction function) {
        super(name, function, false);
    }
}
