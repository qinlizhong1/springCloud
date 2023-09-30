package com.qin.rule;
//降级规则设置


import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//熔断降级规则
@Component
public class DegradeControllerRule {
    @PostConstruct
    public void init(){
        initDegradeRule("/rule/t2");
    }

    public void initDegradeRule(String resourceName)
    {
        //熔断规则： 1min内调用接口出现异常次数超过2的时候, 进行熔断
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource(resourceName);
        rule.setCount(2);
        //熔断规则：异常数
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //70s后关闭熔断
        rule.setTimeWindow(70);
        degradeRules.add(rule);
        //加载配置好的降级规则
        DegradeRuleManager.loadRules(degradeRules);
    }
}
