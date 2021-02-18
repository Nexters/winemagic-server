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

  @GetMapping("/")
  public String test() {
    return "Hello World";
  }

  @PostMapping(path = "/")
  public BaseResponse<UserResponse> createUser(@RequestBody UserDTO userDTO) {
    UserResponse user = userService.createUserEntity(userDTO);
    return new BaseResponse<>(200, "0", user);
  }

  @GetMapping(path = "/{userId}/{accessToken}")
  public BaseResponse<UserResponse> getUserByIdAndAccessToken(@PathVariable Integer userId,
                                                      @PathVariable String accessToken) {
    UserResponse user = userService.getUserByIdAndAccessToken(userId, accessToken);
    return new BaseResponse<>(200, "0", user);
  }

  @PostMapping(path = "/accessToken")
  public BaseResponse<User> updateUserAccessToken(@RequestBody RenewAccessTokenDTO tokenDTO) {
    return new BaseResponse<>(200, "0",
            this.userService.updateUserAccessToken(tokenDTO));
  }
}
