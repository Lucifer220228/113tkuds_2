package finalexam;

// 檔名：LC18_4Sum_Procurement.java

import java.util.*;

public class LC18_4Sum_Procurement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        sc.close();

        List<List<Integer>> res = fourSum(nums, target);
        for (List<Integer> quad : res) {
            for (int i = 0; i < quad.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(quad.get(i));
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重 i
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 去重 j
                long remain = (long) target - nums[i] - nums[j]; // 避免溢位
                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = (long) nums[l] + nums[r];
                    if (sum == remain) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++; // 去重 L
                        while (l < r && nums[r] == nums[r + 1]) r--; // 去重 R
                    } else if (sum < remain) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}

