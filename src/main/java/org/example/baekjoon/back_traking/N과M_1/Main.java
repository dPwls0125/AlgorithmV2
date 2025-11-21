package org.example.baekjoon.back_traking.N과M_1;

import java.io.*;

public class Main {
    static int[] ans = new int[9];
    static boolean[] visited = new boolean[9];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;

    /*
        입력
        - N : 1~N 까지의 수
        - M : 수열의 길이

        로직
        알고리즘 : 백트래킹

        출력
        - 1~N 까지의 자연수 중 *중복 없이 M개를 고른 수열

         */

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        String[] tokens = s.split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        permute(1);
        bw.close();
    }


    private static void permute(int location) throws IOException {
        // 종료조건
        if (location == m+1){
            for(int i=1; i<=m; i++){
                bw.write(Integer.toString(ans[i]) + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                ans[location] = i;
                visited[i] = true;
                permute(location+1);
                visited[i] = false;
            }
        }
    }
}
