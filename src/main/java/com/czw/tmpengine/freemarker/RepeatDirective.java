package com.czw.tmpengine.freemarker;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

/**
 * TemplateDirectiveModel 对象通常不应该是有状态的，这一点非常重要。
 * 一个经常犯的错误是存储指令的状态然后在对象的属性中调用执行。
 * 想一下相同指令的嵌入调用，或者指令对象被用作共享变量， 并通过多线程同时访问。
 *
 * 不幸的是， TemplateDirectiveModel 不支持传递参数的位置(而不是参数名称)。
 * 从 FreeMarker 2.4 版本开始，它将被修正。
 *
 * Created by Administrator on 2016/9/22.
 */
public class RepeatDirective implements TemplateDirectiveModel {

    private static final String PARAM_NAME_COUNT = "count";
    private static final String PARAM_NAME_HR = "hr";

    public void execute(Environment env,
                        Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // ---------------------------------------------------------------------
        // Processing the parameters:

        int countParam = 0;
        boolean countParamSet = false;
        boolean hrParam = false;

        Iterator paramIter = params.entrySet().iterator();
        while (paramIter.hasNext()) {
            Map.Entry ent = (Map.Entry) paramIter.next();

            String paramName = (String) ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();

            if (paramName.equals(PARAM_NAME_COUNT)) {
                if (!(paramValue instanceof TemplateNumberModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_HR + "\" parameter "
                                    + "must be a number.");
                }
                countParam = ((TemplateNumberModel) paramValue)
                        .getAsNumber().intValue();
                countParamSet = true;
                if (countParam < 0) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_HR + "\" parameter "
                                    + "can't be negative.");
                }
            } else if (paramName.equals(PARAM_NAME_HR)) {
                if (!(paramValue instanceof TemplateBooleanModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_HR + "\" parameter "
                                    + "must be a boolean.");
                }
                hrParam = ((TemplateBooleanModel) paramValue)
                        .getAsBoolean();
            } else {
                throw new TemplateModelException(
                        "Unsupported parameter: " + paramName);
            }
        }
        if (!countParamSet) {
            throw new TemplateModelException(
                    "The required \"" + PARAM_NAME_COUNT + "\" paramter"
                            + "is missing.");
        }

        if (loopVars.length > 1) {
            throw new TemplateModelException(
                    "At most one loop variable is allowed.");
        }

        // Yeah, it was long and boring...

        // ---------------------------------------------------------------------
        // Do the actual directive execution:

        Writer out = env.getOut();
        if (body != null) {
            for (int i = 0; i < countParam; i++) {
                // Prints a <hr> between all repetations if the "hr" parameter
                // was true:
                if (hrParam && i != 0) {
                    out.write("<hr>");
                }

                // Set the loop variable, if there is one:
                if (loopVars.length > 0) {
                    loopVars[0] = new SimpleNumber(i + 1);
                }

                // Executes the nested body (same as <#nested> in FTL). In this
                // case we don't provide a special writer as the parameter:
                body.render(env.getOut());
            }
        }
    }

}
