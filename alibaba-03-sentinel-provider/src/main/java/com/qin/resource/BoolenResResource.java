package com.qin.resource;

import com.alibaba.csp.sentinel.SphO;

/**
 * 返回布尔值方式定义资源:SphO 提供 if-else 风格的 API。用这种方式，当资源发生了限流之后会返回 false，
 * 这个时候可以根据返回值，进行限流之后的逻辑处理.
 *
 * 注意：SphO.entry(xxx) 需要与 SphO.exit()方法成对出现，匹配调用，位置正确，否则会导致调用链记录异常，
 * 抛出ErrorEntryFreeException 异常。
 */
public class BoolenResResource {

    public static String method(){
        // 资源名可使用任意有业务语义的字符串,这里定义了一个名为Boolen-Res-Resource的资源
        String res = null;
        if (SphO.entry("Boolen-Res-Resource")) {
            // 务必保证finally会被执行
            try {
                /**
                 * 被保护的业务逻辑
                 */

                System.out.println("【Boolen-Res-Resource】正常执行");
                res = "【Boolen-Res-Resource】正常执行";
            } finally {
                SphO.exit();
                return res;
            }
        } else {
            // 资源访问阻止，被限流或被降级
            // 进行相应的处理操作
            System.out.println("【Boolen-Res-Resource】限流或者降级执行");
            res = "【Boolen-Res-Resource】限流或者降级执行";
            return res;
        }
    }
}
