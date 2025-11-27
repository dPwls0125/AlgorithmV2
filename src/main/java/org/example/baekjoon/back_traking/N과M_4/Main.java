package org.example.baekjoon.back_traking.N과M_4;

import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean[] visited = new boolean[10];
    private static int[] answer = new int[10];

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        permute(0,1);

    }

    private static void permute(int location, int index) throws IOException {
        // location 0부터 시작
        if(location == m){
            for(int i=0; i<m; i++){
                bw.write(Integer.toString(answer[i]) + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for(int i = index; i<= n; i++){
            answer[location] = i;
            permute(location+1, i);

        }

    }
}
