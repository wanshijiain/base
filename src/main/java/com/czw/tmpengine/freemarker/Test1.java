package com.czw.tmpengine.freemarker;

import com.czw.util.ComUtils;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * TemplateModel 不是线程安全的，所以在多线程使用configuration中不要共享它的实现类。包含下列指令：
 * capture_output       freemarker.template.utility.CaptureOutput
 * compress             freemarker.template.utility.StandardCompress
 * html_escape          freemarker.template.utility.HtmlEscape
 * normalize_newlines	freemarker.template.utility.NormalizeNewlines
 * xml_escape	        freemarker.template.utility.XmlEscape
 *
 * @author ZeviChen ${datetime}
 */
public class Test1 {

    public static void main(String[] args) throws IOException, TemplateException {
        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        String filepath = ComUtils.getFilePath(Test1.class,"com.czw.tmpengine.freemarker","",true);

        cfg.setDirectoryForTemplateLoading(new File(filepath));
        cfg.setDefaultEncoding("UTF-8");

        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        //一般将常用的指令放到Configuration中，用于指令共享，而不是在每个模版使用的时候都放入一次
        //cfg.setSharedVariable("warp", new WarpDirective());
        cfg.setSharedVariable("author", "ZeviChen");

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        Map root = new HashMap();
        root.put("user", "Big Joe");
        Map latest = new HashMap();

        //传入自定义方法或指令
        root.put("indexOf",new IndexOfMethod());
        root.put("upper", new UpperDirective());
        root.put("repeat", new RepeatDirective());

        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("test1.ftl");

        //获取Freemarker运行环境
        Environment env = Environment.getCurrentEnvironment();


        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.

        out.close();
    }


}
