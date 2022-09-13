package nxu.it.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;


@Path("/")
public class MainController extends Controller {
    public void index(){
        renderHtml("<h2>It works!</h2>");
    }
}
