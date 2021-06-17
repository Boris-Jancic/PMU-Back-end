package com.PMU.Bamboo.web.rest.impl;

import com.PMU.Bamboo.dto.AuthDto;
import com.PMU.Bamboo.dto.BuyerDto;
import com.PMU.Bamboo.dto.SellerDto;
import com.PMU.Bamboo.dto.UserPasswordChangeDto;
import com.PMU.Bamboo.model.Buyer;
import com.PMU.Bamboo.model.Seller;
import com.PMU.Bamboo.model.User;
import com.PMU.Bamboo.model.enums.UserRole;
import com.PMU.Bamboo.repository.BuyerRepo;
import com.PMU.Bamboo.repository.SellerRepo;
import com.PMU.Bamboo.repository.UserRepo;
import com.PMU.Bamboo.service.UserService;
import com.PMU.Bamboo.web.converter.BuyerDtoToBuyer;
import com.PMU.Bamboo.web.converter.SellerDtoToSeller;
import com.PMU.Bamboo.web.rest.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
public class UserApiImpl implements UserApi {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SellerRepo sellerRepo;

    @Autowired
    private BuyerRepo buyerRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private SellerDtoToSeller sellerToEntity;

    @Autowired
    private BuyerDtoToBuyer buyerToEntity;


    @Override
    public ResponseEntity registerSeller(@Valid SellerDto dto) {
        System.out.println(dto);
        if (dto != null) {
            Seller seller = this.sellerToEntity.convert(dto);
            seller.getUser().setRole(UserRole.SELLER);
            userRepo.save(seller.getUser());
            sellerRepo.save(seller);
            return new ResponseEntity<>(seller, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Buyer> registerBuyer(@Valid BuyerDto dto) {
        System.out.println(dto);
        if (dto != null) {
            Buyer buyer = this.buyerToEntity.convert(dto);
            buyer.getUser().setRole(UserRole.BUYER);
            userRepo.save(buyer.getUser());
            buyerRepo.save(buyer);
            return new ResponseEntity<>(buyer, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<User> login(@RequestBody AuthDto dto) {
        User user = userRepo.findByUsername(dto.getUsername());
        System.out.println("AAAAAAAAAAA");
        System.out.println(dto.getUsername());
        System.out.println(dto.getPassword());
        System.out.println(user);
        System.out.println("AAAAAAAAAAA");
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity getUser(String username) {
        Optional<User> user = Optional.ofNullable(userRepo.findByUsername(username));
        return user
                .<ResponseEntity>map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    @Override
    public ResponseEntity getUsers() {
        List<User> users = userRepo.getAllUsersExeptAdmins();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getSellers() {
        List<Seller> sellers = userService.sellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Seller> getSeller(Long id) {
        return new ResponseEntity<>(userService.findSellerByUser(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> changePassword(UserPasswordChangeDto dto) {
        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            boolean result;
            try {
                result = this.userService.changePassword(dto);
            } catch (EntityNotFoundException var5) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            return result ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<User> updateUser(@Valid User user) {
        if (user != null) {
            System.out.println(user);
            userRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
