package com.hcaglar.ticketapplication.service.security;

import com.hcaglar.ticketapplication.converter.UserConverter;
import com.hcaglar.ticketapplication.dto.request.UserRequest;
import com.hcaglar.ticketapplication.dto.response.UserResponse;
import com.hcaglar.ticketapplication.entity.security.User;
import com.hcaglar.ticketapplication.exception.EmptyOrNullException;
import com.hcaglar.ticketapplication.repository.UserRepository;
import com.hcaglar.ticketapplication.service.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Service
public class UserServiceImpl implements IBaseService<UUID, UserRequest, UserResponse> {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse findById(UUID id) {

        var user = userRepository
                .findById(id).orElseThrow(
                        () -> new EmptyOrNullException(
                                this.getClass().getName(),
                                "findById method id is empty or not found."));

        return UserConverter.INSTANCE.convert(user);
    }

    @Override
    public Page<UserResponse> findAll(Integer page, Integer size) {
        var pageRequest = PageRequest.of(page, size);
        var pageUsers = userRepository.findAll(pageRequest);

        return UserConverter.INSTANCE.convert(pageUsers);
    }

    @Override
    @Transactional
    public UserResponse save(UserRequest userRequest) {
        var user = UserConverter.INSTANCE.convert(userRequest);
        var registeredUser = userRepository.save(user);

        return UserConverter.INSTANCE.convert(registeredUser);
    }

    @Override
    @Transactional
    public UserResponse update(UserRequest userRequest, UUID id) {
        var registeredUser = userRepository.findById(id)
                .orElseThrow(() -> new EmptyOrNullException(
                        this.getClass().getName(),
                        "update method id is empty or not found."));
        userRequest.setPassword(registeredUser.getPassword());

        return this.save(userRequest);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new EmptyOrNullException(
                        this.getClass().getName(),
                        "update method id is empty or not found."));

        userRepository.delete(user);
    }

    @Transactional
    public User findUserByUserName(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    @Transactional
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
