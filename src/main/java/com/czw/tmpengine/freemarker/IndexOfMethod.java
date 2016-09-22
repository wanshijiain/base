package com.czw.tmpengine.freemarker;

import freemarker.template.SimpleNumber;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * @author ZeviChen ${datetime}
 */
public class IndexOfMethod  implements TemplateMethodModelEx {
    @Override
    public Object exec(List list) throws TemplateModelException {
        if (list.size() != 2) {
            throw new TemplateModelException("Wrong arguments");
        }
        //注：在Freemark以前的版本中list.get(0)可以直接强制转换成对应Java类型,实现的是TemplateMethodModel接口
        //在TemplateMethodModelEx中类型都是SimpleScalar,

        String right = ((SimpleScalar)list.get(1)).getAsString();
        String left = ((SimpleScalar)list.get(0)).getAsString();
        return new SimpleNumber(right.indexOf(left));
    }
}
