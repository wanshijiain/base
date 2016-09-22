<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <#-- freemarker comments -->
    <h9>---------------------------------赋值--------------------------------</h9><br/>
    <h1>Welcome ${user}!</h1>
    <p>Our latest product:
    <a href="${latestProduct.url}">${latestProduct.name}</a>!
    <h9>---------------------------------传入自定义方法--------------------------------</h9><br/>
    <#assign x = "something">
        foo在something中的位置：${indexOf("foo", x)}
        met在something中的位置：${indexOf("met", x)}<br/>
        <h9>---------------------------------自定义指令=字母大写-------------------------------</h9><br/>

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
    <h9>---------------------------------自定义指令=重复-------------------------------</h9><br/>
    <#assign x = 1>

    <@repeat count=4>
    x自增,重复四次 ${x}
        <#assign x++>
    </@repeat>

    <@repeat count=3 hr=true>
    重复三次
    </@repeat>

    <@repeat count=3; cnt>
    ${cnt}. 重复三次
    </@repeat>


</body>
</html>
