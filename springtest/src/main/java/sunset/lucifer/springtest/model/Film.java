package sunset.lucifer.springtest.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/17.
 */
@Alias("Film")
@Component("film")
public class Film {
    private int id;
    private String name;

    public Film(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Film() {
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
