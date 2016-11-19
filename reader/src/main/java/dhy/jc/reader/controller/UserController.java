package dhy.jc.reader.controller;

import dhy.jc.reader.enums.MessageEnum;
import dhy.jc.reader.model.ExtendModel;
import dhy.jc.reader.model.User;
import dhy.jc.reader.service.UserService;
import dhy.jc.reader.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private ExtendModel extendModel;

    /**
     * 用户信息注册接口
     * 请求数据格式：
     * {"username":"",
     * "password":"",
     * "mobile":""}
     *
     * @param jsonCode 请求信息json
     * @return jsonStr 发送信息json
     */
    @RequestMapping(value = "user/regist.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String regist(@RequestBody String jsonCode) {
        String jsonStr = "";
        User user = JsonUtil.changeJsonToObject(jsonCode, User.class);
        int value = userService.insertRecord(user);
        if (value == 0) {
            extendModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendModel.setReturnCode("1100000");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        } else {
            extendModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendModel.setReturnCode("1100011");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        }
    }

    /**
     * 用户信息完善接口
     * 请求数据格式：
     * {"id":"12",
     * "username":"狼皇啸霜月",
     * "mobile":"157068445801",
     * "qq":"12345678901",
     * "wechat":"12345678901",
     * "email":"12345678901",
     * "gender":"1"}
     *
     * @param jsonCode 请求数据json
     * @return jsonStr 返回数据json
     */
    @RequestMapping(value = "user/update.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(@RequestBody String jsonCode) {
        String jsonStr = "";
        User user = JsonUtil.changeJsonToObject(jsonCode, User.class);
        int value = userService.updateRecord(user);
        if (value == 0) {
            extendModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendModel.setReturnCode("1100000");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        } else {
            extendModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendModel.setReturnCode("1100011");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        }
    }
}
