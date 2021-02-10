package com.nexters.winepick.user.api;

import com.nexters.winepick.base.BaseResponse;
import com.nexters.winepick.user.api.dto.RenewAccessTokenDTO;
import com.nexters.winepick.user.api.dto.UserDTO;
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

  @GetMapping(path = "/{userId}/{accessToken}")
  public BaseResponse<User> getUserByIdAndAccessToken(@PathVariable Integer userId,
                                                      @PathVariable String accessToken) {
    return new BaseResponse<>(200, "0",
            this.userService.getUserByIdAndAccessToken(userId, accessToken));
  }

  @PostMapping(path = "/accessToken")
  public BaseResponse<User> updateUserAccessToken(@RequestBody RenewAccessTokenDTO tokenDTO) {
    return new BaseResponse<>(200, "0",
            this.userService.updateUserAccessToken(tokenDTO));
  }
}
