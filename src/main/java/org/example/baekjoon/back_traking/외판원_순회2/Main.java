package org.example.baekjoon.back_traking.외판원_순회2;

import java.io.*;

public class Main {

    // 문제 :
    // 1. 한번 갔던 도시는 다시 방문할 수 없음.
    // 2. 시작점으로 돌아오는 것은 가능. -> 원래의 도시로 돌아와야 함.
    // 3. 가장 적은 비용이 드는 도시로 가는 계획.

    // 로직 :
    // 1. 가능한 모든 경우의 수를 구해, 최소 비용을 구한다.
    // 2. start point를 기억해 두고 돌아와야함. 마지막 지점에서 돌아갈 수 없는 경우에 대해서도 분기 처리해야 함.
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int n;
    public static int[][] arr;

    public static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        // Read Input
        String input = br.readLine();
        n = Integer.parseInt(input);
        arr = new int[n+1][n+1];

        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];

        for(int i=0; i<n; i++){
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        // Logic
        for(int start=0; start<n; start++){ // Starting Point
            backTrack(start,start,visited,cost,0);
        }

        // Write Output


    }

    private static void backTrack(int start_location, int location, boolean[] visited, int[] cost, int num){

        visited[location] = true;
        num += 1;

        if(num > n && arr[location][start_location] > 0){
            cost[start_location] = Math.min()
        }

        for(int i=0; i<n; i++){
            if(!visited[i] && arr[location][i] != 0 ){
                cost[start_location] += arr[location][i];
                backTrack(start_location,i,visited,cost,num);
            }
        }
    }


}
