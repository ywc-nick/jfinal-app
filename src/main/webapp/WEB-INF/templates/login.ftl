<#-- @ftlvariable name="errorMessage" type="nxu.it.controller.MainController" -->
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <style>
        .error{
                font-size: 0.7rem;
            font-style: italic;
            color: tomato;
        }

    </style>
</head>
<body>
<form action="loginCheck">
    <div class="field" id="id1">
        <label for="username">用户名：</label><input type="text" name="username" id="username" placeholder="请输入用户名">
    </div>
    <div class="field" id="id2">
        <label for="password">密码：</label><input type="password" name="password" id="password" placeholder="请输入密码">
    </div>
    <div class="error">
        ${errorMessage!""}
    </div>
    <div class="field">
        <input type="submit" value="登录">
    </div>
</form>
</body>
</html>