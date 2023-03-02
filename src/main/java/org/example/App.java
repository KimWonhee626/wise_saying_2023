package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

public class App {

    public void run(){
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while(true){
            System.out.print("명령) ");
            String cmd = Container.getScanner().nextLine().trim(); // 좌우 공백 제거
            Rq rq = new Rq(cmd);

            if(rq.getActionCode().equals("종료")){
                systemController.exit();
                break;
            }
            else if(rq.getActionCode().equals("등록")){
                wiseSayingController.write();
            }
            else if(rq.getActionCode().equals("목록")){
                wiseSayingController.list();
            }
            else if(rq.getActionCode().equals("삭제")){
                wiseSayingController.remove(rq);
            }
            else if(rq.getActionCode().equals("수정")){
                wiseSayingController.update(rq);
            }

        }

    }
}
