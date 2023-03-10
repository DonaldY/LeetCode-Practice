package chapter6.topic3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author donald
 * @date 2023/03/07
 */
public class LeetCode_1096 {
    String expression;
    int idx;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.idx = 0;
        Set<String> ret = expr();
        return new ArrayList<>(ret);
    }

    // item . letter | { expr }
    private Set<String> item() {
        Set<String> ret = new TreeSet<String>();
        if (expression.charAt(idx) == '{') {
            idx++;
            ret = expr();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(expression.charAt(idx));
            ret.add(sb.toString());
        }
        idx++;
        return ret;
    }

    // term . item | item term
    private Set<String> term() {
        // 初始化空集合，与之后的求解结果求笛卡尔积
        Set<String> ret = new TreeSet<String>() {{
            add("");
        }};
        // item 的开头是 { 或小写字母，只有符合时才继续匹配
        while (idx < expression.length() && (expression.charAt(idx) == '{' || Character.isLetter(expression.charAt(idx)))) {
            Set<String> sub = item();
            Set<String> tmp = new TreeSet<String>();
            for (String left : ret) {
                for (String right : sub) {
                    tmp.add(left + right);
                }
            }
            ret = tmp;
        }
        return ret;
    }

    // expr . term | term, expr
    private Set<String> expr() {
        Set<String> ret = new TreeSet<>();
        while (true) {
            // 与 term() 求解结果求并集
            ret.addAll(term());
            // 如果匹配到逗号则继续，否则结束匹配
            if (idx < expression.length() && expression.charAt(idx) == ',') {
                idx++;
                continue;
            } else {
                break;
            }
        }
        return ret;
    }
}
