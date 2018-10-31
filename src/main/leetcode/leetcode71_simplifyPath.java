import java.util.LinkedList;

/**
 * @Auther: Think
 * @Date: 2018/10/31 21:33
 * @Description:
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 思路：
 * 重复连续出现的'/'，只按1个处理，即跳过重复连续出现的'/'；
 * 如果路径名是"."，则不处理；
 * 如果路径名是".."，则需要弹栈，如果栈为空，则不做处理；
 * 如果路径名为其他字符串，入栈。
 * 最后，再逐个取出栈中元素（即已保存的路径名），用'/'分隔并连接起来
 *
 * 代码参考：https://blog.csdn.net/cslbupt/article/details/53736911
 */
public class leetcode71_simplifyPath {
    public String solution(String path){
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> stack = new LinkedList<String>();
        for (String s:path.split("\\/")){
            if (s.equals("..")) {
                if (!stack.isEmpty()){
                    stack.removeLast();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.add(s);
            }
        }
        for (String s:stack){
            sb.append(s+"/");
        }
        if (!stack.isEmpty()){
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
}
