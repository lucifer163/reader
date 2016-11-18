package sunset.lucifer.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sunset.lucifer.springtest.Enum.MessageEnum;
import sunset.lucifer.springtest.model.ExtendsModel;
import sunset.lucifer.springtest.model.Film;
import sunset.lucifer.springtest.service.FilmService;
import sunset.lucifer.springtest.util.JsonUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 */
@Controller
public class FilmController {

    @Autowired
    @Qualifier(value = "filmService")
    private FilmService filmService;

    @Autowired
    private ExtendsModel extendsModel;

    @RequestMapping(value = "index/getFilm.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getFilm(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        Film film = filmService.getRecord((int) id);
        String filmJson = JsonUtil.createJsonString(film);
        return filmJson;
    }

    @RequestMapping(value = "index/getFilms.json", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getFilms() {
        List<Film> film = filmService.getRecords();
        String filmJson = JsonUtil.createJsonList(film);
        return filmJson;
    }

    @RequestMapping(value = "index/insertFilm.json", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertFilm(@RequestBody String jsonCode) {
        String jsonStr = "";
        Film film = JsonUtil.changeJsonToObject(jsonCode, Film.class);
        int value = filmService.insertRecord(film);
        if (value == 0) {
            extendsModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendsModel.setReturnCode("1100000");
            jsonStr = JsonUtil.createJsonString(extendsModel);
            return jsonStr;
        } else {
            extendsModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendsModel.setReturnCode("1100011");
            jsonStr = JsonUtil.createJsonString(extendsModel);
            return jsonStr;
        }
    }

    @RequestMapping(value = "index/deleteFilm.json", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteFilm(@RequestBody String jsonCode) {
        String jsonStr = "";
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        int value = filmService.deleteRecordByID((int) id);
        if (value == 0) {
            extendsModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendsModel.setReturnCode("1100000");
            jsonStr = JsonUtil.createJsonString(extendsModel);
            return jsonStr;
        } else {
            extendsModel.setReturnMsg(MessageEnum.getValue(value).getDescription());
            extendsModel.setReturnCode("1100011");
            jsonStr = JsonUtil.createJsonString(extendsModel);
            return jsonStr;
        }
    }

}
