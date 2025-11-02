package com.hungdev.firstproject.service;

import com.hungdev.firstproject.exception.MyException;
import com.hungdev.firstproject.model.PasswordDTO;
import com.hungdev.firstproject.model.UserDTO;

public interface IUserService {

    UserDTO findOneByUserName(String userName);
//    UserDTO findUserById(long id);
    UserDTO registerNewUser(UserDTO userDTO);
    UserDTO login(UserDTO userDTO) throws MyException;
    UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws MyException;
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    void delete(long[] ids);
}
