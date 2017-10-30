package services;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

/**
 * @author v.osepyan
 */

@Singleton
public class FibonachiService implements IntermediaryFibo{

    private final IntermediaryLogicService intermediaryLogicService;

    @Inject
    public FibonachiService(IntermediaryLogicService intermediaryLogicService) {
        this.intermediaryLogicService = intermediaryLogicService;
    }

    @Override
    public String getFibonachiSequence(int n) {
        String a = "0";
        ArrayList tempSeq = intermediaryLogicService.makeFibonachiSequence(n);
        for (int i=1; i<tempSeq.size(); i++){
            a += ", " + tempSeq.get(i).toString();
        }
        return a;
    }
}
