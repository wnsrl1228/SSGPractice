package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
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

        List<WiseSaying> wiseSayings = new ArrayList<>();
        int wiseSayinglastId = 0;
        outer:while ( true ){
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine();
                    int id = ++wiseSayinglastId;
                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    wiseSayings.add(wiseSaying);
                    System.out.println(id +"번 명언이 등록되었습니다.");
                    break;
                case "삭제":
                    //url에서 입력된 id값 얻기
                    int paramId = rq.getIntParam("id",0);

                    // url에 입력된 id가 없는 경우 중지
                    if(paramId == 0){
                        System.out.println("id를 입력해주세요");
                        continue;
                    }
                    // URL에 입력된 id에 해당하는 명언객체 찾기
                    WiseSaying wiseSaying__ = null;

                    for (WiseSaying wiseSaying___ : wiseSayings) {
                        if (wiseSaying___.id == paramId){
                            wiseSaying__ = wiseSaying___;
                            break;
                        }
                    }
                    // 존재하는 id값이 없을 경우 중지
                    if (wiseSaying__ == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
                        continue;
                    }
                    // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
                    wiseSayings.remove(wiseSaying__);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);

                    break;
                case "수정":
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-------------------");
                    for (int i = wiseSayings.size()-1; i >=0 ; i--) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id,wiseSaying_.content,wiseSaying_.author);

                    }
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
