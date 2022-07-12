package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    public List<WiseSaying> wiseSayings;
    public int wiseSayinglastId;
    WiseSayingRepository() {
        wiseSayings = new ArrayList<>();
        wiseSayinglastId = 0;
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId){
                return wiseSaying;
            }
        }
        return null;
    }
}
