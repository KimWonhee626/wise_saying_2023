package org.example.wiseSaying.repository;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.table.WiseSayingTable;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private WiseSayingTable wiseSayingTable;


    public WiseSayingRepository(){
        wiseSayingTable = new WiseSayingTable();
    }

    // ** id로 객체 검색 **
    public WiseSaying findById(long id) {
        return wiseSayingTable.findById(id);
    }

    // ** 등록 **
    public long save(String text, String author){
        long id = wiseSayingTable.getLastId() + 1;

        WiseSaying wiseSaying = new WiseSaying(id, text, author);

        return wiseSayingTable.save(wiseSaying);
    }

    // ** 목록 **
    public List<WiseSaying> findAll() {

        return wiseSayingTable.findAll();
    }

    // ** 삭제 **
    public void remove(WiseSaying wiseSaying){
        wiseSayingTable.remove(wiseSaying);
    }

    // ** 수정 **
    public void update(WiseSaying wiseSaying, String text, String author){
        wiseSayingTable.update(wiseSaying, text, author);
    }
}
