/**
 * @author youyusong
 * @date 2018/8/19
 */
public class Solution2 {

    /**
     * 时间复杂度: O(len(s))
     * 空间复杂度: O(len(charset))
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];

        int l = 0;
        int r = -1;
        int res = 0;

        // 相比于solution1, 改变循环中止条件
        while (r + 1 < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r ++;
                freq[s.charAt(r)] ++;
            } else {
                freq[s.charAt(l)] --;
                l ++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
