package org.example.baekjoon.back_traking.애너그램;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // 입력 받은 영단어의 철자들로 만들 수 있는 모든 단어를 출력.
    // 여러 단어들을 입력 받을 수 있으며, 입력 받은 char은 중복될 수 있으나, 출력되는 단어는 유일 집합이어야 함.
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static String[] answer;
    static boolean[] visited;
    static Set<String> result;
    public static void main(String[] args) throws IOException{
        String input = br.readLine();
        N = Integer.parseInt(input);

        for(int i=0; i<N; i++){
            input = br.readLine();
            List<String> list = new ArrayList<String>();
            for(int j=0; j<input.length(); j++){
                list.add(String.valueOf(input.charAt(j)));
            }
            List<String> sortedList = list.stream()
                    .sorted()
                    .collect(Collectors.toList());

            visited = new boolean[sortedList.size()];
            result = new HashSet<>();
            answer = new String[sortedList.size()];
            dfs(0,sortedList);
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int location, List<String> list) throws IOException {
        // backTracking 종료 조건
        if(location == list.size()){
            StringBuilder str = new StringBuilder();
            for(int i=0; i<list.size(); i++){
                str.append(answer[i]);
            }

            if(!result.contains(str.toString())) {
                bw.write(str.toString());
                bw.newLine();
                result.add(str.toString());
            }
            return;
        }

        String prev = "";

        // 백트레킹
        for(int i=0; i<list.size(); i++){
            if(visited[i]) continue;
            if(list.get(i).equals(prev)) continue;
            prev = list.get(i);

            answer[location] = list.get(i);
            visited[i] = true;
            dfs(location+1,list);
            visited[i] = false;
        }
    }
}
