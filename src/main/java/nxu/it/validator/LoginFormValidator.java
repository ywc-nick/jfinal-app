package nxu.it.validator;


import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginFormValidator extends Validator {
private static final String ERROR_KEY="errorMessage";
    @Override
    protected void validate(Controller controller) {
        setShortCircuit(true);
validateRequiredString("username",ERROR_KEY,"用户名为空");

validateRequiredString("password",ERROR_KEY,"密码为空");
    }

    @Override
    protected void handleError(Controller controller) {
        String errorMessage = controller.getAttr(ERROR_KEY);
        controller.renderHtml("<h2 style=\"color:red;\">提交的数据不合法,原因："+errorMessage+"</h2>");
    }
}
