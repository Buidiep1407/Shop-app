package com.project.shopapp.services;

import com.project.shopapp.dtos.UserDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Role;
import com.project.shopapp.models.User;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserService implements IUserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User createUser(UserDTO userDTO) throws DataNotFoundException {
        String phoneNumber = userDTO.getPhoneNumber();

        //Kiểm tra xem số điện thoại đã tồn tại hay chưa
        if (userRepository.existsByPhoneNumber(phoneNumber)){
            throw new DataIntegrityViolationException("Phone number already exist !");
        }

        //Convert from user DTO ==> user
        User newUser = User.builder()
                .fullName(userDTO.getFullname())
                .phoneNumber(userDTO.getPhoneNumber())
                .password(userDTO.getPassword())
                .address(userDTO.getAddress())
                .dateOfBirth(userDTO.getDateOfBirth())
                .facebookAccountId(userDTO.getFacebookAccountId())
                .googleAccountId(userDTO.getGoogleAccountId())
                .build();
        Role role = roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(()-> new DataNotFoundException("Role not found!"));
        newUser.setRole(role);

        //Kiem tra neu co accountId, khong yeu cau mat khau
        if (userDTO.getFacebookAccountId() == 0 && userDTO.getGoogleAccountId() ==0){
            String password = userDTO.getPassword();
            // Ma hoa mat khau: (Spring Security)
            // String encodedPassword = passwordEncoder.encode(password);
            //newUser.setPassword(encodedPassword);
        }

        return userRepository.save(newUser);
    }

    @Override
    public String login(String phoneNumber, String password) {
        //Security
        return null;
    }
}
