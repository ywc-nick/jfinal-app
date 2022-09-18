package nxu.it.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;


@Path(value = "/", viewPath = "/")
public class MainController extends Controller {
    public void index() {
        renderHtml("<h2>It works!</h2>");
    }

}
