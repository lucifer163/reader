package dhy.jc.reader.service;

import dhy.jc.reader.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface UserService extends BaseService<User> {

    public List<User> getUsersWithShelves();

    public User getUserWithShelves(int id);
}
