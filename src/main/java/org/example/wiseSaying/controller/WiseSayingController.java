package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {

    private final WiseSayingService wiseSayingService;

    public WiseSayingController() {
        wiseSayingService = new WiseSayingService();
    }

    // ** 등록 **
    public void write() {
        System.out.print("명언 : ");
        String text = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();

        int id = wiseSayingService.write(text, author);

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    // ** 목록 **
    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            wiseSayings.get(i).print();
        }

    }

    // ** 삭제 **
    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);

        // 입력된 id와 일치하는 WiseSaying객체 찾기
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        // 찾은 객체 리스트에서 제거
        wiseSayingService.remove(wiseSaying);

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    // ** 수정 **
    public void update(Rq rq) {
        int id = rq.getIntParam("id", -1);

        // 입력된 id와 일치하는 WiseSaying객체 찾기
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + wiseSaying.getText());
        System.out.print("명언 : ");
        String text = Container.getScanner().nextLine();
        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();

        wiseSayingService.update(wiseSaying, text, author);

        System.out.println(id + "번 명언이 수정되었습니다.");

    }
}
