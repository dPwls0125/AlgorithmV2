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

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        // Read Input
        String input = br.readLine();
        n = Integer.parseInt(input);
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];


        for(int i=0; i<n; i++){
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        // Logic
        for(int start=0; start<n; start++){ // Starting Point
            visited[start] = true;
            backTrack(start, start,1,0 );
            visited[start] = false;
        }

        // Write Output
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();


    }

    private static void backTrack(int start_location, int location, int count, int sum){

        if(count == n){
            if(arr[location][start_location] > 0){
                min = Math.min(min, sum + arr[location][start_location]);
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i] && arr[location][i] > 0 ){
                visited[i] = true;
                backTrack(start_location, i,count +1, sum + arr[location][i]);
                visited[i] = false;
            }
        }
    }


}
