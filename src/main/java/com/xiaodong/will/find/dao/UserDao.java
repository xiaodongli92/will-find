package com.xiaodong.will.find.dao;

import com.xiaodong.will.find.model.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * UserDao
 */
public interface UserDao extends CrudRepository<User, Long> {
}
