package nxu.it;

import com.jfinal.config.*;
import com.jfinal.template.Engine;
import nxu.it.controller.MainController;

public class MainConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.scan("nxu.it.controller");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
