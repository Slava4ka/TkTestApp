package services;
import javax.inject.Singleton;
/**
 * @author v.osepyan
 */

@Singleton
public class FibonachiService implements IntermediaryFibo{


    @Override
    public String getFibonachiSequence(int n) {
        FibonachiAction fibonachi = new FibonachiAction(n);
        String a = "0";
        for (int i=1; i<fibonachi.getSequence().size(); i++){
            a += ", " + fibonachi.getSequence().get(i).toString();
        }
        return a;
    }
}
