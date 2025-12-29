package org.example.baekjoon.data_structure.큐2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    // poll, peek 은 큐가 비어있을 때 null을 반환. 따라서 primitive 자료형으로 받으면 안됨.
    // remove, Element는 동일한 상황에서 Exception을 터뜨림.

    public static void main(String[] args) throws IOException {

        // input
        N = Integer.parseInt(br.readLine());
        String[][] commands = new String[N][2];

        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine().split(" ");
        }

        // queue 구현
        Queue<Integer> queue = new LinkedList<>();
        int last = -1; // ✅ back 용 변수 추가

        for (int i = 0; i < N; i++) {

            if (commands[i][0].equals("push")) {
                last = Integer.parseInt(commands[i][1]);
                queue.add(last);
            }

            if (commands[i][0].equals("pop")) {
                Integer result = queue.poll();
                if (result == null) {
                    bw.write("-1\n");
                } else {
                    bw.write(result + "\n");
                }
            }

            if (commands[i][0].equals("size")) {
                bw.write(queue.size() + "\n");
            }

            if (commands[i][0].equals("empty")) {
                bw.write(queue.isEmpty() ? "1\n" : "0\n");
            }

            if (commands[i][0].equals("front")) {
                Integer result = queue.peek();
                if (result == null) bw.write("-1\n");
                else bw.write(result + "\n");
            }

            if (commands[i][0].equals("back")) {
                if (queue.isEmpty()) bw.write("-1\n");
                else bw.write(last + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
