package leetcode130;

/**
 * @Auther: Think
 * @Date: 2018/11/23 21:38
 * @Description:
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 判断是否是回文串
 */
public class leetcode125_ValidPalindrome {
    public boolean isPalindrome(String s){
        char[] word = s.toLowerCase().toCharArray();
        int len = s.length();
        int left = 0,right = len - 1;
        while (left < right) {
            if (!((word[left]>='0'&&word[left]<='9')||(word[left]>='a' && word[left]<='z' )))
                left++;
            if (!((word[right]>='0'&&word[right]<='9')||(word[right]>='a'&&word[right]<='z')))
                right--; //空格视为有效的回文串
            else if (word[left]==word[right]){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
