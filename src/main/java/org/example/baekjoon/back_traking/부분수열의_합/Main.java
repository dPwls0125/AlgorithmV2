package org.example.baekjoon.back_traking.부분수열의_합;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int s;
    static int[] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        // input
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        arr = new int[n+1];
        s = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        // logic
        backTracking(0,0);
        if(s == 0) result--; // 공집합 제외
        // output
        writeAnswer(result);
    }

    static void backTracking(int location, int sum){
        // exit condition
        if(location == n){
            if(sum == s) {
                ++result;
            }
            return;
        }
        // Traversal
        // 현재 location에 있는 값을 포함 하거나 안하거나 둘 중 하나.
        backTracking(location+1,sum); // select
        backTracking(location+1,sum+arr[location]); // non-select
    }

    static void writeAnswer(int result) throws IOException{
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
