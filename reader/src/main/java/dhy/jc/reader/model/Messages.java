package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * 用户私信实体
 * Created by Administrator on 2016/11/18.
 */
@Alias("Messages")
@Component("messages")
public class Messages {
    private int id;
    private String name;

    public Messages() {
    }

    public Messages(int id, String name) {
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
