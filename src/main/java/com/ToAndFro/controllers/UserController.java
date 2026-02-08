package com.ToAndFro.controllers;

import com.ToAndFro.models.dto.request.CreateUserRequestDto;
import com.ToAndFro.models.dto.request.PatchUserRequestDto;
import com.ToAndFro.models.dto.request.UpdateUserRequestDto;
import com.ToAndFro.models.dto.response.UserResponseDto;
import com.ToAndFro.repository.UserRepository;
import com.ToAndFro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<UserResponseDto> findAll() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDto findByEmail(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody @Validated CreateUserRequestDto createUserRequestDto) {
        return userService.createUser(createUserRequestDto);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id,
                                      @RequestBody @Validated UpdateUserRequestDto updateUserRequestDto) {
        return userService.updateUser(id, updateUserRequestDto);
    }

    @PatchMapping("/{id}")
    public UserResponseDto patchUser(@PathVariable Long id,
                                        @RequestBody PatchUserRequestDto patchUserRequestDto) {
        return userService.patchUser(id, patchUserRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
