package leetcode;

public class miBoxes {

    /**
     * 有一个立方体房间，其长度、宽度和高度都等于 n 个单位。请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下：
     * <p>
     * 你可以把盒子放在地板上的任何地方。
     * 如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。
     * 给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/building-boxes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * i×(i+1)/2
     *
     * @param n
     * @return
     */
    // 。随着 ii 的增加，成平方级增长。
    public static int minimumBoxes(int n) {
        int cur = 1, i = 1, j = 1;
        while (n > cur) {
            n -= cur;
            i++;
            cur += i;
        }
        cur = 1;
        while (n > cur) {
            n -= cur;
            j++;
            cur++;
        }
        return (i - 1) * i / 2 + j;
    }

    public static void main(String[] args) {
        System.out.println(minimumBoxes(10));
    }
}
