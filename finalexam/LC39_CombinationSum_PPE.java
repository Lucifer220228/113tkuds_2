package finalexam;

import java.util.*;

public class LC39_CombinationSum_PPE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

        // Version I: unlimited use
        System.out.println("=== Combination Sum I ===");
        List<List<Integer>> res1 = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack1(candidates, 0, target, new ArrayList<>(), res1);
        printResult(res1);

        // Version II: each number only once
        System.out.println("=== Combination Sum II ===");
        List<List<Integer>> res2 = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack2(candidates, 0, target, new ArrayList<>(), res2);
        printResult(res2);
    }

    private static void backtrack1(int[] candidates, int start, int remain, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break;
            path.add(candidates[i]);
            backtrack1(candidates, i, remain - candidates[i], path, res); // unlimited use
            path.remove(path.size() - 1);
        }
    }

    private static void backtrack2(int[] candidates, int start, int remain, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue; // skip duplicates
            path.add(candidates[i]);
            backtrack2(candidates, i + 1, remain - candidates[i], path, res); // use once
            path.remove(path.size() - 1);
        }
    }

    private static void printResult(List<List<Integer>> res) {
        for (List<Integer> comb : res) {
            for (int i = 0; i < comb.size(); i++) {
                System.out.print(comb.get(i));
                if (i < comb.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}

