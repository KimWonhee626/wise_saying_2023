package org.example.wiseSaying.entity;

public class WiseSaying {
    private long id;
    private String text;
    private String author;

    WiseSaying(){}

    public WiseSaying(long id, String text, String author){
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public void print(){
        System.out.println(id+" / "+author+" / "+text);
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toJson(){
        return """
                {
                    "id": %d,
                    "text": "%s",
                    "author": "%s"
                }
                """
                .stripIndent()
                .formatted(id, text, author)
                .trim();
    }
}
