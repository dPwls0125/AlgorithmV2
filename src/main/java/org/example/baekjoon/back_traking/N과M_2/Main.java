package org.example.baekjoon.back_traking.N과M_2;

import java.io.*;

public class Main {

    // 1~N까지 자연수 중에서 중복 없이 M개를 고른 수열
    // 오름차순
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] answer = new int[10];
    private static boolean[] visited = new boolean[10];

    static int n;

    static int m;

    public static void main(String[] args) throws IOException {

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        bt(0,1);
        bw.close();

    }


    public static void bt(final int location, final int index) throws IOException {
        if (location == m){
            for(int i=0; i<m; i++){
                bw.write(Integer.toString(answer[i]) +  " ");
            }
            bw.write("\n");
            bw.flush();
        }

        for(int i=index; i<=n; i++){
            if(!visited[i]){
                answer[location] = i;
                visited[i] = true;
                bt(location+1, i + 1);
                visited[i] = false;
            }
        }
    }

}
