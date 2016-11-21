package dhy.jc.reader.dao;

import dhy.jc.reader.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface UserDao extends BaseDao<User> {

    public User getRecordByEmail(User user);

    public User getRecordByMobile(User user);

    public User getRecordByMobiles(String mobile);

    public User getRecordByQQ(User user);

    public User getRecordByWechat(User user);

    /**
     * 获取包含用户自定义书架的用户列表
     *
     * @return 用户列表；仅用户名 用户名自定义书架名称
     */
    public List<User> getUsersWithShelves();

    /**
     * 根据id 获取包含用户自定义书架的用户信息
     *
     * @return 单一用户信息；用户全部信息 用户自定义书架名称
     */
    public User getUserWithShelves(int id);
}
