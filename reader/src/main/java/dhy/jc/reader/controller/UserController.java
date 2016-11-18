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
}
