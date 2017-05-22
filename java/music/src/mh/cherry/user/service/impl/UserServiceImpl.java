package mh.cherry.user.service.impl;

import mh.cherry.core.service.impl.BaseServiceImpl;
import mh.cherry.user.dao.UserDao;
import mh.cherry.user.dao.impl.UserDaoImpl;
import mh.cherry.user.entity.User;
import mh.cherry.user.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	//这里没有框架就手动注入dao咯
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.setBaseDao(userDao);
		this.userDao = userDao;
	}
	
    public UserServiceImpl() {
		this.setUserDao(new UserDaoImpl());
	}

	
}
