package dhy.jc.reader.dao;

import dhy.jc.reader.model.User;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface UserDao extends BaseDao<User> {

    public User getRecordByEmail(String email);

    public User getRecordByMobile(String mobile);

    public User getRecordByQQ(String qq);

    public User getRecordByWechat(String wechat);
}
