package com.darlanmarangoni.financeapi.resources;

import com.darlanmarangoni.financeapi.domain.dtos.UserDto;
import com.darlanmarangoni.financeapi.domain.entities.UserEntity;
import com.darlanmarangoni.financeapi.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        var entity = new UserEntity(userDto.name(), userDto.email());
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userRepository.save(entity)).toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll()
                .stream()
                .map(m -> new UserDto(m.getId(), m.getName(), m.getEmail()))
                .toList());
    }
}
