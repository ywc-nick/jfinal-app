package nxu.it.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;

@Path("/user")
public class UserController extends Controller {

    public void login(){
        renderText("登录");
    }

    public void logout(){
        renderText("退出");
    }
}
