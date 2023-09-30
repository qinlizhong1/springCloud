package com.qin.rule;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//流控规则
@Component
public class FlowControllerRule {
    @PostConstruct
    public void init(){
        initFlowRule("/rule/t1");
    }

    private void initFlowRule(String resourceName) {
        //可以定义多条规则，因此用List
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule(resourceName);
        //设置阈值为 2
        rule.setCount(2);
        //限流QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //default 不区分调用来源
        rule.setLimitApp("default");
        //设置流控手段：快速失败
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);

        rules.add(rule);
        //加载配置好的流控规则
        FlowRuleManager.loadRules(rules);
    }
}
