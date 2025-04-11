package com.example.task_manager_backend.controller;

import com.example.task_manager_backend.dto.Impl.UserDTO;
import com.example.task_manager_backend.exeption.UserNotFoundExeption;
import com.example.task_manager_backend.secure.JWTAuthResponse;
import com.example.task_manager_backend.secure.SignIn;
import com.example.task_manager_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/auth/")
@RestController
@RequiredArgsConstructor
public class authUserController {
    private final AuthService authService;
    //private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "signup",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> createUser(@RequestBody UserDTO userDTO) {

        try {
            var buildUser = new UserDTO();
            buildUser.setUsername(userDTO.getUsername());
            buildUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            buildUser.setRole(userDTO.getRole());

            return ResponseEntity.ok(authService.signUp(buildUser));
        }catch (UserNotFoundExeption e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn){
        return ResponseEntity.ok(authService.signIn(signIn));
    }
    @PostMapping("refresh")
    public ResponseEntity<JWTAuthResponse> RefreshToken(@RequestParam("existingToken") String existingToken) {
        return ResponseEntity.ok(authService.refreshToken(existingToken));
    }
}
