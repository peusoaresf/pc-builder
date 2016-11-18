package uva.pcbuilder.fuzzylogic.fuzzycontrollers;

import uva.pcbuilder.fuzzylogic.fuzzysets.CpuFuzzySet;

/**
 * Created by peuso on 18/11/2016.
 */

public class CpuFuzzySystem extends FuzzySystem {
    public CpuFuzzySystem() {
        super(new CpuFuzzySet());
    }
}
