import com.google.inject.AbstractModule;
import services.*;

public class Module extends AbstractModule {

    @Override
    public void configure() {

        bind(InterfaceFibonachiService.class).to(FibonachiService.class);
        bind(InterfaceLogic.class).to(FibonachiLogic.class);
    }

}
