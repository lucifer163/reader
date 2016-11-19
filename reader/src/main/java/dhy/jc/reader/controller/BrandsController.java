package dhy.jc.reader.controller;

import dhy.jc.reader.model.Book;
import dhy.jc.reader.model.ExtendModel;
import dhy.jc.reader.service.BookService;
import dhy.jc.reader.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
public class BrandsController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Autowired
    private ExtendModel extendModel;

    /**
     * 获得包含有书籍标签的书籍信息，每一本书籍都至少有一个属于自己的书籍标签
     * @return 书籍信息 json
     */
    @RequestMapping(value = "brands/getBooksWithBrands.json", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBooksWithBrands() {
        List<Book> books = bookService.getBookListWithBrands();
        String jsonStr = JsonUtil.createJsonList(books);
        return jsonStr;
    }
}
