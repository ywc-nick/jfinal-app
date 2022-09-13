package nxu.it.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;


@Path("/")
public class MainController extends Controller {
    public void hello(){
        String username = get("username");
        String htmlTpl= "<h2>你好，%s!</h2>";
        String html = String.format(htmlTpl, username);
        renderHtml(html);
    }

    public void bye(){
        renderHtml("<h2>再见!</h2>");
    }
}
