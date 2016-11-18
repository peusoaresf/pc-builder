package uva.pcbuilder.fuzzylogic.fuzzycontrollers;

import uva.pcbuilder.fuzzylogic.fuzzysets.FuzzySet;
import uva.pcbuilder.fuzzylogic.fuzzysets.RamFuzzySet;

/**
 * Created by peuso on 18/11/2016.
 */

public class RamFuzzySystem extends FuzzySystem {
    public RamFuzzySystem() {
        super(new RamFuzzySet());
    }
}
