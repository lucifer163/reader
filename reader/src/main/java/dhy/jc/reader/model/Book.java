package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * 书籍实体类
 * Created by Administrator on 2016/11/18.
 */
@Alias("Book")
@Component("book")
public class Book {
    private int id;
    private String bookname;
    private String author;
    private String wordsize;
    private String chaptersize;
    private int updated;
    private int reply;
    private int store;              //被收藏数
    private String item;

    public Book() {
    }

    public Book(String author, String bookname, String chaptersize, int id, String item, int reply, int store, int updated, String wordsize) {
        this.author = author;
        this.bookname = bookname;
        this.chaptersize = chaptersize;
        this.id = id;
        this.item = item;
        this.reply = reply;
        this.store = store;
        this.updated = updated;
        this.wordsize = wordsize;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getChaptersize() {
        return chaptersize;
    }

    public void setChaptersize(String chaptersize) {
        this.chaptersize = chaptersize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public String getWordsize() {
        return wordsize;
    }

    public void setWordsize(String wordsize) {
        this.wordsize = wordsize;
    }
}
