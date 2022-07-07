package com.ll.exam;

import java.util.Scanner;
//# 요구사항
//          - 영속성
//        - DB 사용금지
//        - 파일사용가능
//        - JSON 형식 추천
//        - 실행예시
//        명령) 등록
//        명언 : 현재를 사랑하라.
//        작가 : 작자미상
//        1번 명언이 등록되었습니다.
//        명령) 등록
//        명언 : 과거에 집착하지 마라.
//        작가 : 작자미상
//        2번 명언이 등록되었습니다.
//        명령) 목록
//        번호 / 작가 / 명언
//        ----------------------
//        2 / 작자미상 / 과거에 집착하지 마라.
//        1 / 작자미상 / 현재를 사랑하라.
//        명령) 삭제?id=1
//        1번 명언이 삭제되었습니다.
//        명령) 삭제?id=1
//        1번 명언은 존재하지 않습니다.
//        명령) 수정?id=2
//        2번 명언을 수정합니다.
//        기존 명언 : 과거에 집착하지 마라.
//        새 명언 : 미래와 과거에 집착하지 마라.
//        2번 명언이 수정되었습니다.
//        명령) 목록
//        번호 / 작가 / 명언
//        ----------------------
//        2 / 작자미상 / 미래와 과거에 집착하지 마라.
public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        int wiseSayinglastId = 0;
        outer:while ( true ){
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine();
                    int id = ++wiseSayinglastId;
                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    System.out.println(wiseSaying);
                    System.out.println(id +"번 명언이 등록되었습니다.");
                    break;
                case "삭제":
                case "수정":
                case "목록":
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
