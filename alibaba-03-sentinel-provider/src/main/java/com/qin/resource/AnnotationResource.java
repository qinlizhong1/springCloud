package com.qin.resource;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 使用 @SentinelResource 注解可以更加的灵活的定义资源
 *
 * @SentinelResource 注解包含以下属性：
 * value:资源名称，必需项
 * blockHandler / blockHandlerClass：blockHandler 指定函数负责处理 BlockException 异常
 *          blockHandler 函数默认需要和原方法在同一个类中，通过指定 blockHandlerClass 为对应类的 Class 对象，
 *          则可以指定其他类中的函数，但注意对应的函数必需为 static 函数，否则无法解析。
 * fallback /fallbackClass： fallback 指定的函数负责处理业务运行的异常，可选项
 *          fallback 函数默认需要和原方法在同一个类中，通过指定 fallbackClass 为对应类的 Class 对象，
 *          则可以指定指定为其他类的函数，但注意对应的函数必需为 static 函数，否则无法解析。
 *
 *
 */
public class AnnotationResource {
    //
    @SentinelResource(value = "sentinel-annotation-Resource",
                        blockHandler = "methodBlockHandler",
                        fallback= "methodFallback")
    public static String method(){
        System.out.println("【sentinel-annotation-Resource】正常执行");
        String res = "【sentinel-annotation-Resource】method 正常执行";
        return res;
    }

    public  String methodBlockHandler(BlockException e){
        return "【sentinel-annotation-Resource】methodBlockHandler 执行";
    }
    public  String methodFallback(){
        return "【sentinel-annotation-Resource】methodFallback 执行";
    }
}
