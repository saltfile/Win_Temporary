package leetcode;

/**
 * 1754. 构造字典序最大的合并字符串
 * 给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继续操作：
 * <p>
 * 如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
 * 例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。
 * 如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
 * 例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。
 * 返回你可以构造的字典序 最大 的合并字符串 merge 。
 * <p>
 * 长度相同的两个字符串 a 和 b 比较字典序大小，如果在 a 和 b 出现不同的第一个位置，a 中字符在字母表中的出现顺序位于 b 中相应字符之后，就认为字符串 a 按字典序比字符串 b 更大。例如，"abcd" 按字典序比 "abcc" 更大，因为两个字符串出现不同的第一个位置是第四个字符，而 d 在字母表中的出现顺序位于 c 之后。
 */


public class StringMerge {
    public static String largestMerge(String word1, String word2) {
        StringBuilder res = new StringBuilder();

        int wd1_len = 0;
        int wd2_len = 0;

        while (wd1_len < word1.length() || wd2_len < word2.length()) {
            if (wd1_len < word1.length() &&
                    word1.substring(wd1_len).compareTo(word2.substring(wd2_len)) > 0) {
                res.append(word1.charAt(wd1_len));
                wd1_len++;
            } else {
                res.append(word2.charAt(wd2_len));
                wd2_len++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //"cbcabaaaaa"
        System.out.println(largestMerge("cabaa", "bcaaa"));
    }
}
