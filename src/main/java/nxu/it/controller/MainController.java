package nxu.it.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.Kv;
import nxu.it.config.Result;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Path(value = "/", viewPath = "/")
public class MainController extends Controller {
    public void index() {
        renderHtml("<h2>It works!</h2>");
    }
 public void  hello(){
        String username=get("username");
        Integer age=getInt("age");
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
}
