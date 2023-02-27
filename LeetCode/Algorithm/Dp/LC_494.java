package LeetCode.Algorithm.Dp;

import java.util.HashMap;
import java.util.Map;

public class LC_494 {


    private Map<Integer, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    /**
     *
     * @param nums       数组
     * @param start      当前点
     * @param curSum     当前数字和
     * @param target     目标和
     * @return
     */
    private int dfs(int[] nums, int start, int curSum, int target) {
        if (start == nums.length) {  // 枚举到最后一个位置
            return curSum == target ? 1 : 0;
        }
        int key = start * 10000 + curSum;   // 映射key
        if (memo.containsKey(key)) return memo.get(key);
        int res = 0;
        // 每个位置数字两种选择 + -
        int a = dfs(nums, start + 1, curSum - nums[start], target);
        int b = dfs(nums, start + 1, curSum + nums[start], target);
        res += a + b;
        memo.put(key, res);
        return res;
    }


    public static void main(String[] args) {

    }
}
