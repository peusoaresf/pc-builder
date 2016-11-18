package uva.pcbuilder.fuzzylogic.fuzzycontrollers;

import uva.pcbuilder.fuzzylogic.fuzzysets.FuzzySet;
import uva.pcbuilder.fuzzylogic.fuzzysets.MoboFuzzySet;

/**
 * Created by peuso on 18/11/2016.
 */

public class MoboFuzzySystem extends FuzzySystem {

    public MoboFuzzySystem() {
        super(new MoboFuzzySet());
    }
}
