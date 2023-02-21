package com.openmarkethub.services;

import com.openmarkethub.dtos.UserDTO;
import com.openmarkethub.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void createUser(UserDTO userDTO);

    public void deleteUser(Integer id);

    public void updateUser(UserDTO userDTO);

    public User getUser(Integer id);

    public List<User> getAllUser();

}
