package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * 书籍标签
 * Created by Administrator on 2016/11/18.
 */
@Alias("Brands")
@Component("brands")
public class Brands {
    private int id;
    private String name;

    public Brands() {
    }

    public Brands(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
