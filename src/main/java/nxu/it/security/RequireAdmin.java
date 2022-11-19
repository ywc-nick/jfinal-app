package nxu.it.security;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import nxu.it.entity.SysUser;

import static nxu.it.security.RequireLogin.USER_SESSION_KEY;

public class RequireAdmin implements Interceptor {


    @Override
    public void intercept(Invocation invocation) {
        Controller controller=invocation.getController();
        SysUser  sysUser =controller.getSessionAttr(USER_SESSION_KEY);
        if (sysUser  == null|| !sysUser.isAdmin()) {
            controller.renderHtml("<h2 style=\"color:red;\">您无权访问</h2>");
        }else{
            invocation.invoke();//调用被拦截的方法
        }
    }
}
