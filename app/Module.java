import com.google.inject.AbstractModule;
import services.*;

public class Module extends AbstractModule {

    @Override
    public void configure() {

        bind(IntermediaryFibo.class).to(FibonachiService.class);
        bind(IntermediaryLogicService.class).to(FibonachiLogic.class);
    }

}
