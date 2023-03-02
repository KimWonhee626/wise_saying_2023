package org.example;

public class WiseSaying {
    int id;
    String text;
    String author;

    WiseSaying(){}

    WiseSaying(int id, String text, String author){
        this.id = id;
        this.text = text;
        this.author = author;
    }

    void print(){
        System.out.println(id+" / "+author+" / "+text);
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
