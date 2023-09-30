package com.qin.rule;
//降级规则设置


import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//黑白名单
@Component
public class AuthorizeControllerRule implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 判断header中是否有此参数
        String origin = request.getHeader("origin");

        // 判断请求参数中是否有此参数
        if(StringUtils.isBlank(origin)){
            origin = request.getParameter("origin");
        }

        if (StringUtils.isBlank(origin)) {
            // 或者自定义异常处理
            throw new IllegalArgumentException("请求参数不合法");
        }
        return origin;
    }
}
