package com.openmarkethub.services;

import com.openmarkethub.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    void deleteUser(Integer id);

    UserDTO updateUser(UserDTO userDTO, Integer userId);

    UserDTO getUserByID(Integer id);

    List<UserDTO> getAllUser();

}
