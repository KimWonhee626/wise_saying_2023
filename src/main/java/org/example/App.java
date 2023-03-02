package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App(Scanner sc){
        this.sc = sc;
    }

    public void run(){
        System.out.println("== 명언 앱 ==");

        int num = 1;
        List<WiseSaying> list = new LinkedList<>();

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim(); // 좌우 공백 제거

            if(cmd.equals("종료")){
                break;
            }
            else if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String text = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                list.add(new WiseSaying(num, text, author));
                System.out.println(num+"번 명언이 등록되었습니다.");
                num++;
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i = list.size()-1; i>=0; i--){
                    list.get(i).print();
                }
            }


        }

        sc.close();
    }
}
