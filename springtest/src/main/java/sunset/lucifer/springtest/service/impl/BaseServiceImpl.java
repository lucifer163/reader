package sunset.lucifer.springtest.service.impl;

import sunset.lucifer.springtest.dao.BaseDao;
import sunset.lucifer.springtest.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    private BaseDao<T> baseDao;

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    public int insertRecord(T record) {
        return baseDao.insertRecord(record);
    }

    public int deleteRecordByID(int id) {
        return baseDao.deleteRecordByID(id);
    }

    public int updateRecord(T record) {
        return baseDao.updateRecord(record);
    }

    public T getRecord(int id) {
        return baseDao.getRecord(id);
    }

    public List<T> getRecords() {
        return baseDao.getRecords();
    }

    public T getRecordByName(String name) {
        return baseDao.getRecordByName(name);
    }
}
