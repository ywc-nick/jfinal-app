<#--@ftlvariable name="hometownList" type="java.util.List<String>"-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <style>
        form{
            display: table;
        }
        form .field{
            display: table-row;
        }
        form .cell{
            display: table-cell;
        }

    </style>
</head>
<body>
<form action="/doRegister" method="post" >
    <div class="cell">
   <label for="username"> 用户名:</label>
        <input type="text" name="username" id="username" required>
    </div>
    <div class="field">
    <label for="password">密   码：</label>
        <input type="password" name="password" id="password" required><br>
    </div>
    <div class="field">
    性   别：<input type="radio" name="sex" id="gender-male" value="0" checked>男
    <input type="radio" name="sex" id="gender-female" value="1">女
    <input type="radio" name="sex" id="gender-unknown" value="2">保密<br>
    </div>
        <div class="field">
    年   龄：<input type="text" name="age" id="age" required><br>
        </div>
    <div class="field">籍   贯：<select id="hometown" name="hometown" required>
        <option value="">-----请选择-----</option>
            <#list hometownList as hometown>
                <option value="${hometown_index}">${hometown}</option>
            </#list>
    </select><br>
    </div>
    邮   箱：<input type="text" name="mail" id="mail" required><br>
    爱   好：
    <input type="checkbox" name="hobby" id="sing">唱歌
    <input type="checkbox" name="hobby" id="dance">跳舞
    <input type="checkbox" name="hobby" id="rap">rap
    <input type="checkbox" name="hobby" id="sport">篮球<br>
    <input type="submit" value="注册">
</form>
</body>
</html>