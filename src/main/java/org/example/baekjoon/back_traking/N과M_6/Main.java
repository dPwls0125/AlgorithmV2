package org.example.baekjoon.back_traking.N과M_6;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] nums;
    static int[] ans;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        ans = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums); // ⭐ 사전순 출력의 핵심

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    // depth: 현재 몇 개 골랐는지.
    // start: 다음에 고를 수 있는 시작 인덱스.
    static void dfs(int depth, int start) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(ans[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i < n; i++) {
            ans[depth] = nums[i];
            dfs(depth + 1, i + 1);
        }
    }
}
