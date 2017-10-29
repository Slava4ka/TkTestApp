package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.IntermediaryFibo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author v.osepyan
 */

@Singleton
public class FibonachiControler extends Controller{

    private final IntermediaryFibo intermediaryFibo;

    @Inject
    public FibonachiControler (IntermediaryFibo intermediaryFibo){
        this.intermediaryFibo = intermediaryFibo;
    }

    public Result count(int n) {
        return ok(intermediaryFibo.getFibonachiSequence(n));
    }


}
