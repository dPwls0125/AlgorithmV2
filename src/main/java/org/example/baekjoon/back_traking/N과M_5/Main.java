package org.example.baekjoon.back_traking.N과M_5;

import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] answer = new int[10];
    private static boolean[] visited = new boolean[10];
    private static int m;
    private static int n;

    private static String[] inputs;

    public static void main(String[] args) throws IOException {

        inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int[] nums = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        permute(0, nums);
        bw.close();
        br.close();
    }

    private static void permute(int location, int[] nums) throws IOException{

        if (location == m) {
            for (int i = 0; i < m; i++) {
                bw.write(answer[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }


        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[location] = nums[i];
                permute(location+1,nums);
                visited[i] = false;
            }
        }

    }
}
