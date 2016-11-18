package sunset.lucifer.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sunset.lucifer.springtest.Enum.MessageEnum;
import sunset.lucifer.springtest.dao.FilmDao;
import sunset.lucifer.springtest.model.Film;
import sunset.lucifer.springtest.service.FilmService;

/**
 * Created by Administrator on 2016/11/17.
 */
@Service("filmService")
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {

    @Autowired
    private FilmDao filmDao;

    @Autowired
    public void setBaseDao() {
        super.setBaseDao(filmDao);
    }

    @Override
    public int insertRecord(Film record) {
        Film film = filmDao.getRecordByName(record.getName());
        if (film != null) {
            return MessageEnum.USER_EXITED.getValue();
        }
        int count = filmDao.insertRecord(record);
        if (count > 0) {
            return MessageEnum.OPERATE_SUCCESS.getValue();
        }
        return MessageEnum.OPERATE_ERROR.getValue();

    }

    @Override
    public int deleteRecordByID(int id) {
        int count = filmDao.deleteRecordByID(id);
        if (count > 0) {
            return MessageEnum.OPERATE_SUCCESS.getValue();
        } else {
            return MessageEnum.OPERATE_ERROR.getValue();
        }
    }
}
