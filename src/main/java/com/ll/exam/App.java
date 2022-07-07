package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        int i = 1;
        outer:while ( true ){
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.printf("명언 : ");
                    String say = sc.nextLine();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine();
                    System.out.println(i +"번 명언이 등록되었습니다.");
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
