package org.example.baekjoon.data_structure.괄호의_값;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Object> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                int temp = 0;

                // 스택이 비어있으면 잘못된 괄호열
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                // 숫자들을 꺼내어 내부 값을 계산
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    temp += (int)stack.pop();
                }

                // 이제 열린 괄호가 나와야 함
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                char open = (char)stack.pop();

                // 괄호 매칭 확인
                if (c == ')' && open != '(' || c == ']' && open != '[') {
                    System.out.println(0);
                    return;
                }

                // temp == 0 → 내부 값이 없는 경우 기본값 적용
                if (temp == 0)
                    temp = (c == ')') ? 2 : 3;
                else
                    temp *= (c == ')') ? 2 : 3;

                stack.push(temp);
            }
        }

        // 스택에 숫자만 남아있는지 확인
        int result = 0;
        while (!stack.isEmpty()) {
            if (!(stack.peek() instanceof Integer)) {
                System.out.println(0);
                return;
            }
            result += (int)stack.pop();
        }

        System.out.println(result);
    }
}
