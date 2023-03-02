package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private int num;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingController() {
        num = 0;
        wiseSayings = new ArrayList<>();
    }

    // ** 등록 **
    public void write(){
        int id = ++num;
        System.out.print("명언 : ");
        String text = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();

        wiseSayings.add(new WiseSaying(id, text, author));
        System.out.println(id+"번 명언이 등록되었습니다.");

    }

    // ** 목록 **
    public void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(int i = wiseSayings.size()-1; i>=0; i--){
            wiseSayings.get(i).print();
        }
    }

    // ** 삭제 **
    public void remove(Rq rq){
        int id = rq.getIntParam("id", -1);

        if(id == -1){
            System.out.println(id+"번 명언은 존재하지 않습니다.");
        }

        System.out.println(id+"번 명언이 삭제되었습니다.");
    }

    // ** 수정 **
    public void modify (Rq rq){
        int id = rq.getIntParam("id", -1);
        int idx = id - 1;
        if(id == -1){
            System.out.println(id+"번 명언은 존재하지 않습니다.");
        }

        System.out.println("명언(기존) : "+wiseSayings.get(idx).getText());
        System.out.print("명언 : ");
        String text = Container.getScanner().nextLine();
        System.out.println("작가(기존) : "+wiseSayings.get(idx).getAuthor());
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();

        wiseSayings.set(idx, new WiseSaying(id, text, author));

        if(id == -1){
            System.out.println(id+"번 명언은 존재하지 않습니다.");
        }
    }
}
