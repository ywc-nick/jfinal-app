<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .vip{
            font-size: 1.2em;
            color: teal;
            font-style:italic;
        }
    </style>
</head>
<body>

<h2>你好,<span class="vip">${ username!"无名氏" }！</span></h2>
<div>
    您今年${age}岁了,
    <#if (age>=18)>已经成年了！
    <#else>尚未成年</#if>
</div>
<#list names as name>
    ${name} <br>
</#list>
</body>
</html>