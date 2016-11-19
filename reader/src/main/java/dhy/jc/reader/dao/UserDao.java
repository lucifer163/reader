package dhy.jc.reader.dao;

import dhy.jc.reader.model.User;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface UserDao extends BaseDao<User> {

    public User getRecordByEmail(User user);

    public User getRecordByMobile(User user);

    public User getRecordByMobiles(String mobile);

    public User getRecordByQQ(User user);

    public User getRecordByWechat(User user);
}
