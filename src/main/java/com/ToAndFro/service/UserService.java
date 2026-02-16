package com.ToAndFro.service;

import com.ToAndFro.exceptions.EmailIsAlreadyTakenException;
import com.ToAndFro.exceptions.UserNotFoundException;
import com.ToAndFro.models.dto.request.CreateUserRequestDto;
import com.ToAndFro.models.dto.request.PatchUserRequestDto;
import com.ToAndFro.models.dto.request.UpdateUserRequestDto;
import com.ToAndFro.models.dto.response.UserResponseDto;
import com.ToAndFro.models.entities.User;
import com.ToAndFro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .toList();
    }

    public UserResponseDto findUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Transactional
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        isEmailTaken(createUserRequestDto.getEmail());

        User user = modelMapper.map(createUserRequestDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto) {
        isEmailTaken(updateUserRequestDto.getEmail());

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

        modelMapper.map(updateUserRequestDto, user);
        return modelMapper.map(userRepository.save(user), UserResponseDto.class);
    }

    @Transactional
    public UserResponseDto patchUser(Long id, PatchUserRequestDto patchUserRequestDto) {
        isEmailTaken(patchUserRequestDto.getEmail());

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

        modelMapper.map(patchUserRequestDto, user);
        return modelMapper.map(userRepository.save(user), UserResponseDto.class);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        userRepository.delete(user);
    }

    private void isEmailTaken(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new EmailIsAlreadyTakenException("Email is already taken");
        }
    }
}
