package com.nexters.winepick.user.api;

import com.nexters.winepick.base.BaseResponse;
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

  @GetMapping("/")
  public String test() {
    return "Hello World";
  }

  @PostMapping(path = "/")
  public BaseResponse<User> createUser(@RequestBody UserDTO userDTO) {
    return new BaseResponse<>(200, "0",
            this.userService.createUserEntity(this.modelMapper.map(userDTO, User.class)));
  }
}
