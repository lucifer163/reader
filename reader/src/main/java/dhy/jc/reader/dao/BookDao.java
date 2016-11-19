package dhy.jc.reader.dao;

import dhy.jc.reader.model.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface BookDao extends BaseDao<Book> {

    /**
     * 获取包含书籍标签的书籍集合
     * @return
     */
    public List<Book> getBookListWithBrands();

}
