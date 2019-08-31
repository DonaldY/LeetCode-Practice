package bytedance.string;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 挑战字符串 - 简化路径
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * 题意： 模仿 Unix路径风格，简化路径
 *
 * 思路：
 * 1. 加入栈进行模拟
 */
public class SimplifyPath {

    public static void main(String[] args) {

        SimplifyPath simplifyPath = new SimplifyPath();

        System.out.println(simplifyPath.simplifyPath("/../"));
    }

    public String simplifyPath(String path) {

        if (path == null || path.length() == 0) return path;

        List<String> dirs = Arrays.asList(path.split("/"));

        dirs = dirs.stream().filter(dir -> !dir.isEmpty()).collect(Collectors.toList());

        Stack<String> stack = new Stack<>();
        Stack<String> revelStack = new Stack<>();

        for (String dir : dirs) {

            if ("..".equals(dir)) {

                if (!stack.isEmpty()) {

                    stack.pop();
                }

                continue;

            } else if (".".equals(dir)) {

                continue;
            }

            stack.push(dir);
        }

        while (!stack.isEmpty()) {

            revelStack.push(stack.pop());
        }

        if (revelStack.isEmpty()) {

            return "/";
        }

        StringBuilder result = new StringBuilder();

        while (!revelStack.isEmpty()) {

            result.append("/");

            String dir = revelStack.pop();

            result.append(dir);
        }

        return result.toString();
    }
}
