package com.oguchok.isite.dao;

import com.oguchok.isite.models.User;

public interface UserDao {

	User findByUserName(String username);
}
