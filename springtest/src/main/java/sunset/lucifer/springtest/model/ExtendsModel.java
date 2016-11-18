package sunset.lucifer.springtest.model;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/17.
 * 一般的返回项
 */
@Component("extendsModel")
public class ExtendsModel {
    private String returnMsg;
    private String returnCode;

    public ExtendsModel(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public ExtendsModel() {
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
