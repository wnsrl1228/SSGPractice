package com.ll.exam;

import java.awt.desktop.AboutEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        WiseSayingContoller wiseSayingContoller = new WiseSayingContoller(sc);

        outer:while ( true ){
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()) {
                case "등록":
                    wiseSayingContoller.write();
                    break;
                case "삭제":
                    wiseSayingContoller.remove(rq);
                    break;
                case "수정":
                    wiseSayingContoller.modify(rq);
                    break;

                case "목록":
                    wiseSayingContoller.list();
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }


}
