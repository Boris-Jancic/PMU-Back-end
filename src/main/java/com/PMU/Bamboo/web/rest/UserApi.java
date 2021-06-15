package com.PMU.Bamboo.web.rest;

import com.PMU.Bamboo.dto.AuthDto;
import com.PMU.Bamboo.dto.BuyerDto;
import com.PMU.Bamboo.dto.SellerDto;
import com.PMU.Bamboo.dto.UserPasswordChangeDto;
import com.PMU.Bamboo.model.Buyer;
import com.PMU.Bamboo.model.Seller;
import com.PMU.Bamboo.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public interface UserApi {

    @PostMapping(value = "/seller/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Seller> registerSeller(@Valid @RequestBody SellerDto dto);

    @PostMapping(value = "/buyer/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Buyer> registerBuyer(@Valid @RequestBody BuyerDto dto);

    @PostMapping(value = "/users/auth",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<User> login(@RequestBody AuthDto dto);

    @GetMapping(value = "/user/{username}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<User> getUser(@PathVariable("username") String username);

    @GetMapping(value = "/users",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<User> getUsers();

    @GetMapping(value = "/sellers",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<User> getSellers();

    @PutMapping(value = "/user/changePass/{username}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Void> changePassword(@Valid @RequestBody UserPasswordChangeDto dto);

    @PutMapping(value = "/user/edit",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<User> updateUser(@Valid @RequestBody User user);
}
