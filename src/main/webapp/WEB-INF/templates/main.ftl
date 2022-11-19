<#-- @ftlvariable name="sysUser" type="nxu.it.entity.SysUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
</head>
<body>
<h2>${sysUser.username},你好，欢迎再次访问！</h2>
<div>
        <#if sysUser.isAdmin()>
            <p>这是你能看到的吗？管理员才能看到</p>
            <#else >
            <p>啥也没有</p>
        </#if>
</div>
</body>
</html>