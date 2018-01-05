import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by think on 2018/1/2.
 */
public class main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 6, 7, 8, 4};
        //int[] nums = {6, 5, 5};
        System.out.println(majorityElement3(nums));
    }

    public static int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int maxKey = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
            if (max < map.get(nums[i])) {
                max = map.get(nums[i]);
                maxKey = nums[i];
            }
        }
        return maxKey;
    }

    //time:O(n) space:O(n)
    public static int majorityElement1Plus(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxKey = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (nums.length / 2 < map.get(num)) {
                maxKey = num;
                break;
            }
        }
        return maxKey;
    }

    //time:O(nlog) space:O(1)
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //time:O(n) space:O(1)
    //每次都找一对不同的数删掉，因为主要元素的个数一定大于n/2所以一定会把主要元素剩下来
    public static int majorityElement3(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (res != num) {
                count--;
            } else count++;
        }
        return res;
    }
}
