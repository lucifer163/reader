package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/21.
 */
@Alias("Recommand")
@Component("recommand")
public class Recommand {
    private int id;
    private String localtime;
    private String reason;
    private int thumbsize;
}
