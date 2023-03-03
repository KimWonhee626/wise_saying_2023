package org.example.wiseSaying.service;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

// 서비스에는 처리 로직만 넣음
public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService(){
        wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying findById(long id){
        return wiseSayingRepository.findById(id);
    }


    // ** 등록 **
    public long save(String text, String author){
        return wiseSayingRepository.save(text, author);
    }

    // ** 목록 **
    public List<WiseSaying> findAll() {
       return wiseSayingRepository.findAll();
    }

    // ** 삭제 **
    public void remove(WiseSaying wiseSaying){
        wiseSayingRepository.remove(wiseSaying);
    }

    // ** 수정 **
    public void update(WiseSaying wiseSaying, String text, String author){
        wiseSayingRepository.update(wiseSaying, text, author);
    }

}
