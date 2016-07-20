package com.globant.training.google.maps.services;


import com.google.inject.Inject;

import com.globant.training.google.maps.daos.UserDao;
import com.globant.training.google.maps.entities.AppUser;

import java.util.List;

/**
 * {@link UserService} Implementation
 * 
 * @author gabriel.sideri
 */
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Inject
  public UserServiceImpl(UserDao userDao) {
    super();
    this.userDao = userDao;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.services.UserService#getAllUsers()
   */
  @Override
  public List<AppUser> getAllUsers() {
    return (List<AppUser>) userDao.getAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.globant.training.google.maps.services.UserService#addUser(com.globant.training.google.maps.
   * entities.MapsUser)
   */
  @Override
  public void addUser(AppUser user){
    //userDao.put(user);
  }
  

}
