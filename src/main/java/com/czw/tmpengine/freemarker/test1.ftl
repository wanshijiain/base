<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <#-- freemarker comments -->
    <h9>---------------------------------赋值--------------------------------</h9>
    <h1>Welcome ${user}!</h1>
    <p>Our latest product:
    <a href="${latestProduct.url}">${latestProduct.name}</a>!
    <h9>---------------------------------传入自定义方法--------------------------------</h9>
    <#assign x = "something">
    met在something中的位置：${indexOf("met", x)}<br/>
    foo在something中的位置：${indexOf("foo", x)}
    <h9>---------------------------------自定义指令-------------------------------</h9>
    <#-- Maybe you have directives that you have implemented in FTL -->
    <#macro something>
        ...
    </#macro>
    <#-- Now you can't use <#macro upper>, but instead you can: -->
    <#assign upper = "com.czw.tmpengine.freemarker.UpperDirective"?new()>
    打印方式类似<pre></pre>会对内部数据进行原样输出.
    <@upper>
    zhangSaN
    It's a Fine dAY ToDaY!
    </@upper>

</body>
</html>
