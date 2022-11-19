package nxu.it.security;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import nxu.it.entity.SysUser;

public class RequireLogin implements Interceptor {

public  static  final  String USER_SESSION_KEY="user";

public  static  final  String LOGIN_REDIRECT_URL_KEY="redirectUrl";
    @Override
    public void intercept(Invocation invocation) {
        Controller controller=invocation.getController();
        SysUser  sysUser =controller.getSessionAttr(USER_SESSION_KEY);
        if (sysUser  == null) {
            StringBuffer requestURL = controller.getRequest().getRequestURL();
            controller.setSessionAttr (LOGIN_REDIRECT_URL_KEY,requestURL.toString());
            controller.redirect("/login");
        }else{
            invocation.invoke();//调用被拦截的方法
        }
    }
}
