package org.example.wiseSaying.service;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

// 서비스에는 처리 로직만 넣음
public class WiseSayingService {

    private int num;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingService(){
        num = 0;
        wiseSayings = new ArrayList<>();
    }

    // ** id로 객체 검색 **
    public WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    // ** 등록 **
    public int write(String text, String author){
        int id = ++num;

        WiseSaying wiseSaying = new WiseSaying(id, text, author);
        wiseSayings.add(wiseSaying);

        return id;
    }

    // ** 목록 **
    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    // ** 삭제 **
    public void remove(WiseSaying wiseSaying){
        wiseSayings.remove(wiseSaying);
    }

    // ** 수정 **
    public void update(WiseSaying wiseSaying, String text, String author){
        wiseSaying.setText(text);
        wiseSaying.setAuthor(author);
    }

}
