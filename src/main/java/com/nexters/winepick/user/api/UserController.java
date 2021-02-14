package com.nexters.winepick.user.api;

import com.nexters.winepick.base.BaseResponse;
import com.nexters.winepick.user.api.dto.RenewAccessTokenDTO;
import com.nexters.winepick.user.api.dto.UserDTO;
import com.nexters.winepick.user.api.dto.UserResponse;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.service.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Data
public class UserController {

  private final UserService userService;
  private final ModelMapper modelMapper;

  @PostMapping(path = "/")
  public BaseResponse<User> createUser(@RequestBody UserDTO userDTO) {
    return new BaseResponse<>(200, "0",
            this.userService.createUserEntity(this.modelMapper.map(userDTO, User.class)));
  }

  @GetMapping(path = "/me/{accessToken}")
  public BaseResponse<UserResponse> getUserByAccessToken(@PathVariable String accessToken) {
    return new BaseResponse<>(200, "0", UserResponse.of(this.userService.getUserIdByAccessToken(accessToken)));
  }

  @PutMapping(path = "/me/{accessToken}")
  public BaseResponse<UserResponse> updateUserEntity(
          @PathVariable String accessToken,
          @RequestBody UserDTO userDTO) {
    return new BaseResponse<>(200, "0",
            UserResponse.of(this.userService.updateUserEntity(accessToken, userDTO)));
  }
}
