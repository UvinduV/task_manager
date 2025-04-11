package com.example.task_manager_backend.service.Impl;


import com.example.task_manager_backend.dao.UserDao;
import com.example.task_manager_backend.dto.Impl.UserDTO;
import com.example.task_manager_backend.entity.Impl.User;
import com.example.task_manager_backend.secure.JWTAuthResponse;
import com.example.task_manager_backend.secure.SignIn;
import com.example.task_manager_backend.service.AuthService;
import com.example.task_manager_backend.service.JWTService;
import com.example.task_manager_backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserDao userDao;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getUsername(),signIn.getPassword()));
        var user=userDao.findByUsername(signIn.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken=jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        //save user
       User saveUser= userDao.save(mapping.toUserEntity(userDTO));
       //generate token and return
       var generateToken= jwtService.generateToken(saveUser);
       return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        //extract user name
       var userName = jwtService.extractUserName(accessToken);
       //check the user availability
        var findUser = userDao.findByUsername(userName)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.refreshToken(findUser);
        return JWTAuthResponse.builder().token(refreshToken).build();
    }
}
