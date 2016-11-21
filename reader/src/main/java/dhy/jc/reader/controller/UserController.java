package dhy.jc.reader.controller;

import dhy.jc.reader.enums.MessageEnum;
import dhy.jc.reader.model.Book;
import dhy.jc.reader.model.ExtendModel;
import dhy.jc.reader.model.Shelves;
import dhy.jc.reader.model.User;
import dhy.jc.reader.service.UserService;
import dhy.jc.reader.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
@Scope("prototype")
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

    /**
     * 获取包含用户自定义书架的用户集合
     *
     * @return 用户详细信息 用户自定义书架
     */
    @RequestMapping(value = "user/getUsersWithShelves.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUsersWithShelves() {
        List<User> users = userService.getUsersWithShelves();
        String jsonStr = JsonUtil.createJsonList(users);
        return jsonStr;
    }

    /**
     * 获取查找用户的自定义书架
     *
     * @param jsonCode 用户id
     * @return 自定义书架集合
     */
    @RequestMapping(value = "user/getUserWithShelves.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getShelvesByUserId(@RequestBody String jsonCode) {
        String jsonStr = "";
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        if (map.get("id") == null || "".equals(map.get("id"))) {
            extendModel.setReturnMsg(MessageEnum.JSON_ACCESS_ERROR.getDescription());
            extendModel.setReturnCode("1100001");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        } else {
            double id = (Double) map.get("id");
            List<Shelves> shelves = userService.getUserWithShelves((int) id).getShelves();
            jsonStr = JsonUtil.createJsonList(shelves);
            return jsonStr;
        }
    }

    /**
     * 获取用户信息集合
     *
     * @return
     */
    @RequestMapping(value = "user/getUsersWithoutAnything.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUsersWithoutAnything() {
        List<User> users = userService.getRecords();
        String jsonStr = JsonUtil.createJsonList(users);
        return jsonStr;
    }

    /**
     * 根据id获取单个用户信息
     *
     * @param jsonCode id
     * @return
     */
    @RequestMapping(value = "user/getUserById.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserById(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        User user = userService.getRecord((int) id);
        String jsonStr = JsonUtil.createJsonString(user);
        return jsonStr;
    }

    /**
     * 删除用户 （管理员权限）
     *
     * @param jsonCode id
     * @return
     */
    @RequestMapping(value = "user/deleteUserById.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteUserById(@RequestBody String jsonCode) {
        String jsonStr = "";
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        int value = userService.deleteRecordByID((int) id);
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
     * 根据id获取单个用户推荐书籍信息
     *
     * @param jsonCode id
     * @return
     */
    @RequestMapping(value = "user/getRecommandsByUserId.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRecommandsByUserId(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        List<Book> books = userService.getRecommandsByUserId((int) id).getRecommandBooks();
        String jsonStr = JsonUtil.createJsonString(books);
        return jsonStr;
    }

    /**
     * 根据id获取单个用户搜藏书籍信息
     *
     * @param jsonCode id
     * @return
     */
    @RequestMapping(value = "user/getStoreBookByUserId.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getStoreBookByUserId(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        List<Book> books = userService.getStoreBookByUserId((int) id).getStoreBooks();
        String jsonStr = JsonUtil.createJsonString(books);
        return jsonStr;
    }
}
