package nxu.it.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.Kv;
import nxu.it.security.RequireAdmin;
import nxu.it.security.RequireLogin;
import nxu.it.config.Result;
import nxu.it.entity.Student;
import nxu.it.entity.SysUser;
import nxu.it.validator.LoginFormValidator;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.*;

import static nxu.it.security.RequireLogin.*;


@Path(value = "/", viewPath = "/")
public class MainController extends Controller {
    public void index() {
        renderHtml("<h2>It works!</h2>");
    }
 public void  hello(){
        String username=get("username");
        //获取值
        Integer age=getInt("age",20);
        set("username",username);
        set("age",age);
        String[] names={"caoli","yangxiaoyan","666","zhuyan"};
        set("names",names);
        renderFreeMarker("hello.ftl");
//        String html="<h2>你好，"+username+"</h2>";
//        renderHtml(html);
//        renderQrCode("你好，请问做核酸了吗",240,240);


 }
 public void  bye(){
        String username=get("username","曹理");
//        String html="<h2>再见，"+username+"</h2>";
//        renderHtml(html);
//     renderQrCode("再见",240,240);
}
 public void json(){
/*
        String jsonStr;
     jsonStr = "{\"code\" : 200, \"message\" :\"请求成功\", \"data\"  :\"数据\"}";
     Map<String,Object> jsonData=new HashMap<>();
     jsonData.put("code",200);
     jsonData.put("message","请求成功");
     jsonData.put("data","你好"+get("username"));
*/
//     Kv jsonData=Kv.create();
//     jsonData.set("code",200)
//             .set("message","请求成功")
//             .set("data","你好"+get("username"));
//     renderJson(jsonData);
     Result<String> result=new Result("你好"+get("username"));
     renderJson(result);
 }
 public  void  today(){
     String jsonStr;
     jsonStr ="{\"year\": 2021,\"month\": 4, \"day\": 14, \"hour\": 9, \"minute\": 15,\"weekday\":\" Wednesday\"}";
     LocalDateTime now=LocalDateTime.now();
     Kv jsonData=Kv.create()
             .set("year",now.getYear())
             .set("month",now.getMonth())
             .set("day",now.getDayOfMonth())
             .set("weekday",now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CANADA));
     renderJson(jsonData);
 }
 public  void register(){
     List<String> hometownList=List.of("宁夏","陕西","甘肃","青海","内蒙古","四川","北京","河南","河北");
     set("hometownList",hometownList);
        renderFreeMarker("register.ftl");
 }

    public void doRegister() {
        String username=get("username");
        String password=get("password");
        String sex=get("sex");
         Integer age=getInt("age");
        String hometown=get("hometown");
        String mail=get("mail");
         String hobby=get("hobby");
        set("username",username);
         set("password",password);
         set("sex",sex);
         set("hometown",hometown);
         set("hobby",hobby);
         renderTemplate("register-result.html");
//renderHtml("注册成功");
    }

    public  void student(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(001,"曹理","男",20));
        students.add(new Student(002,"杨晓燕","女",20));
        students.add(new Student(003,"失败的慢","男",30));
        students.add(new Student(004,"666","未知",0));
        renderFreeMarker("student.ftl");
    }

    public void login(){
        renderFreeMarker("login.ftl");
    }

    public  void logout(){
        removeSessionAttr(USER_SESSION_KEY);
        redirect("/login");
    }
@Before(LoginFormValidator.class)
    public  void  loginCheck(){
        String username=get("username");
        String password=get("password");
        if (username.equals("admin")&&password.equals("123456")||password.equals("nxu") ){
            SysUser sysUser=new SysUser(username);
            setSessionAttr(USER_SESSION_KEY,sysUser);
            String redirectUrl = getSessionAttr(LOGIN_REDIRECT_URL_KEY) ;
            if (redirectUrl!=null&&!redirectUrl.isBlank()){
                redirect(redirectUrl);
            }else   {
            renderHtml("<h2 style=\"color:blue;\">登陆成功！</h2>");
            }
//            setCookie("username",username,30*60,true);
        }else {
            renderHtml("<h2 style=\"color:red;\">登录失败！</h2>");
        }
    }

    public  boolean  checkUserLogin(){
        String username = getSessionAttr("username");
        if (username == null) {
            redirect("/login");
            return  false;
        }
        return true;
    }

@Before(RequireLogin.class)
    public  void  main() {
    SysUser  sysUser = getSessionAttr(USER_SESSION_KEY);
    set("sysUser",sysUser);
    renderFreeMarker("main.ftl");
    }

@Before(RequireLogin.class)
        public  void  test(){
            renderHtml("<h2>这是个测试页面</h2>");
    }
    @Before({RequireLogin.class, RequireAdmin.class})
    public  void  admin(){
        renderHtml("管理员页面");
    }
}
