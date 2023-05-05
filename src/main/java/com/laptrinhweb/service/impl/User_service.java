package com.laptrinhweb.service.impl;

import com.laptrinhweb.dao.IUserDao;
import com.laptrinhweb.model.user;
import com.laptrinhweb.service.IUser_service;

import javax.inject.Inject;

public class User_service implements IUser_service {
    @Inject
    private IUserDao userDao;
    @Override
    public user findusernameandpassword(String username, String password) {
        return userDao.findusernameandpassword(username,password);
    }

    @Override
    public Integer save(user us) {
        Integer id_us = userDao.save(us);
        return id_us;
    }

    @Override
    public user check_user_password(String username, String password) {
        return userDao.check_user_password(username,password);
    }

    @Override
    public void delete(Integer[] ids) {
        for(int i = 0;i < ids.length;i ++){
            userDao.delete(ids[i]);
        }
    }


}
