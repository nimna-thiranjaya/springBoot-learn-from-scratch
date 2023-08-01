package com.nimna.usermanagementtest.service;

import com.nimna.usermanagementtest.dto.request.UserSaveRequestDTO;
import com.nimna.usermanagementtest.dto.request.UserUpdateDTO;
import com.nimna.usermanagementtest.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser(UserSaveRequestDTO userSaveRequestDTO);

    UserResponseDTO userUpdate(UserUpdateDTO userUpdateDTO);
}
