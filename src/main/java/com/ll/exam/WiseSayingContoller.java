package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingContoller {

    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;
    WiseSayingContoller(Scanner sc){
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();
    }
    public void modify(Rq rq) {
        int paramId = rq.getIntParam("id",0);
        if (paramId == 0){
            System.out.println("id를 입력해주세요");
            return;
        }
        WiseSaying wiseSaying = wiseSayingRepository.findById(paramId);

        if (wiseSaying == null ){
            System.out.println("존재하지 않은 id입니다");
            return;
        }

        System.out.println("기존의 명언 : " + wiseSaying.content);
        System.out.printf("새 명언 : ");
        String content = sc.nextLine();
        wiseSaying.content = content;

        System.out.printf("%d번 명언이 수정되었습니다.\n",paramId);

    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = wiseSayingRepository.wiseSayings.size()-1; i >=0 ; i--) {
            WiseSaying wiseSaying_ = wiseSayingRepository.wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id,wiseSaying_.content,wiseSaying_.author);
        }
    }
    public void remove(Rq rq) {
        //url에서 입력된 id값 얻기
        int paramId = rq.getIntParam("id",0);

        // url에 입력된 id가 없는 경우 중지
        if(paramId == 0){
            System.out.println("id를 입력해주세요");
            return;
        }
        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);

        // 존재하는 id값이 없을 경우 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }
        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayingRepository.wiseSayings.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }



    public void write() {
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();
        int id = ++wiseSayingRepository.wiseSayinglastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingRepository.wiseSayings.add(wiseSaying);
        System.out.println(id +"번 명언이 등록되었습니다.");
    }
}
