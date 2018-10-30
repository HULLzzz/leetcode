/**
 * @Auther: Think
 * @Date: 2018/10/29 16:56
 * @Description:
 * 判断输入的是否为数字
 */
public class leetcode65_isNumber {

            public boolean isNumber(String s) {
                s=s.trim();
                if(s.length()==0){
                    return false;
                }
                String reg = "^[-|+]*[.]*(e[-|+]*[0-9]+)?$"; //以.开头是正确的，以.结尾是正确的，但是e前面又必须有数字，
                //二者是矛盾的,先排除一个矛盾，另一个就不存在了,所以这道题，不觉得好。
                if(s.matches(reg))
                    return false;
                reg = "^[-|+]?[0-9]*[.]?[0-9]*(e[-|+]?[0-9]+)?$";
                return s.matches(reg);


            }



}
