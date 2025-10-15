package main;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static java.util.Set<Integer> squareTable = new java.util.HashSet<>();

    public static void createTable(){
        for(int i=0;i<31622;i++){
            squareTable.add(i*i);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void permute(char[] arr, int index, java.util.Set<Integer> results, int count) {
        if (index == arr.length) {
            String numStr = new String(arr);
            if (numStr.charAt(0) != '0') { // 排除前导零的情况
                results.add(Integer.parseInt(numStr));
            }
            return;
        }
        java.util.Set<Character> appeared = new java.util.HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (appeared.contains(arr[i])) continue; // 跳过重复字符
            appeared.add(arr[i]);
            if(squareTable.contains(Integer.parseInt(new String(arr)))){
                count++;
            }
            swap(arr, index, i);
            permute(arr, index + 1, results, count);
            swap(arr, index, i); // 回溯
        }
    }
    

    public static void powNums(int x) {
        int count = 0;
        String str = String.valueOf(x);
        int n = str.length();
        boolean[] used = new boolean[n];
        java.util.Set<Integer> results = new java.util.HashSet<>();
        java.util.Arrays.fill(used, false);
        java.util.Arrays.sort(str.toCharArray());
        // backtrack(str, used, path, results);
        // 优化：直接用全排列生成数字
        permute(str.toCharArray(), 0, results, count);
        return;
    }
    public int findContentChildren(int[] g, int[] s) {
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
    public static void main(String[] args) {
        createTable();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int input = in.nextInt();
            powNums(input);
        }
    }
}