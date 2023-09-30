package com.qin.resource;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 *
 */
public class ThrowExceptionResource {

    public static String method() {
        // 资源名可使用任意有业务语义的字符串,这里定义了一个名为Boolen-Res-Resource的资源
        String res = null;

        // 资源名可使用任意有业务语义的字符串，比如方法名、接口名或其它可唯一标识的字符串。
        try (Entry entry = SphU.entry("Throw-Exception-Resource")) {
            // 被保护的业务逻辑在此处处理
            System.out.println("【Throw-Exception-Resource】正常执行");
            res = "【Throw-Exception-Resource】正常执行";
            return res;
        } catch (BlockException ex) {
            // 资源访问阻止，被限流或被降级时，在此处进行相应的处理操作
            System.out.println("【Throw-Exception-Resource】限流或者降级执行");
            res = "【Throw-Exception-Resource】限流或者降级执行";
            return res;
        }
    }
}
