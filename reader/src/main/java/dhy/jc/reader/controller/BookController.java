package dhy.jc.reader.controller;

import dhy.jc.reader.enums.MessageEnum;
import dhy.jc.reader.model.Book;
import dhy.jc.reader.model.ExtendModel;
import dhy.jc.reader.service.BookService;
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
public class BookController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Autowired
    private ExtendModel extendModel;

    /**
     * 获得包含有书籍标签的书籍信息，每一本书籍都至少有一个属于自己的书籍标签
     *
     * @return 书籍信息 json
     */
    @RequestMapping(value = "book/getBooksWithBrands.json", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBooksWithBrands() {
        List<Book> books = bookService.getBookListWithBrands();
        String jsonStr = JsonUtil.createJsonList(books);
        return jsonStr;
    }

    /**
     * 获得不包含有书籍标签的书籍信息
     *
     * @return
     */
    @RequestMapping(value = "book/getBooksWithoutBrands.json", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBookWithOutBrands() {
        List<Book> books = bookService.getRecords();
        String jsonStr = JsonUtil.createJsonList(books);
        return jsonStr;
    }

    /**
     * 书名模糊查询
     * 请求参数:
     * {"bookname":"无"}
     *
     * @param jsonCode
     * @return
     */
    @RequestMapping(value = "book/getBooksByVague.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBooksByVague(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        String bookname = String.valueOf(map.get("bookname"));
        List<Book> books = bookService.getRecordByVague(bookname);
        String jsonStr = JsonUtil.createJsonList(books);
        return jsonStr;
    }

    /**
     * 根据id获取书籍信息
     * 请求参数：
     * {"id":"1"}
     *
     * @param jsonCode
     * @return
     */
    @RequestMapping(value = "book/getBookById.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBookById(@RequestBody String jsonCode) {
        String jsonStr = "";
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        if (map.get("id") == null || "".equals(map.get("id"))) {
            extendModel.setReturnMsg(MessageEnum.JSON_ACCESS_ERROR.getDescription());
            extendModel.setReturnCode("1100001");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        }
        double id = (Double) map.get("id");
        Book book = bookService.getRecord((int) id);
        jsonStr = JsonUtil.createJsonString(book);
        return jsonStr;
    }
}
