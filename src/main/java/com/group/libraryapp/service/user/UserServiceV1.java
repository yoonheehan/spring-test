package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//3단 분리를 layered architecture라고 한다.
@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userRepository) {
        this.userJdbcRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userJdbcRepository.getUsers();
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        boolean isUserNotExist = userJdbcRepository.isUserNotExist(request.getId());

        if(isUserNotExist){
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    @Transactional
    public void deleteUser(String name){
        boolean isUserNotExist = userJdbcRepository.isUserNotExist(name);

        if(isUserNotExist){
            throw new IllegalArgumentException();
        }

        userJdbcRepository.deleteUser(name);
    }

}
