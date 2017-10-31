package controllers;

import model.SequenceModel;
import play.mvc.Controller;
import play.mvc.Result;
import services.InterfaceFibonachiService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author v.osepyan
 */

@Singleton
public class FibonachiControler extends Controller {

    private final InterfaceFibonachiService interfaceFibonachiService;

    @Inject
    public FibonachiControler(InterfaceFibonachiService interfaceFibonachiService) {
        this.interfaceFibonachiService = interfaceFibonachiService;
    }

    public Result count(int n) {
        SequenceModel sequence = new SequenceModel(interfaceFibonachiService.getFibonachiSequence(n));
        return ok(sequence.getSequenceJson());
    }

}
