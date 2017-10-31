package services;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

/**
 * @author v.osepyan
 */

@Singleton
public class FibonachiService implements InterfaceFibonachiService {

    private final InterfaceLogic interfaceLogic;

    @Inject
    public FibonachiService(InterfaceLogic interfaceLogic) {
        this.interfaceLogic = interfaceLogic;
    }

    @Override
    public String getFibonachiSequence(int n) {
        String a = "0";
        ArrayList tempSeq = interfaceLogic.makeFibonachiSequence(n);
        for (int i=1; i<tempSeq.size(); i++){
            a += ", " + tempSeq.get(i).toString();
        }
        return a;
    }
}
