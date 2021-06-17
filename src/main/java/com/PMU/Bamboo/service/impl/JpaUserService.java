package com.PMU.Bamboo.service.impl;

import com.PMU.Bamboo.dto.UserPasswordChangeDto;
import com.PMU.Bamboo.model.Seller;
import com.PMU.Bamboo.model.User;
import com.PMU.Bamboo.repository.SellerRepo;
import com.PMU.Bamboo.repository.UserRepo;
import com.PMU.Bamboo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaUserService implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SellerRepo sellerRepo;

    @Override
    public Optional<User> one(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<User> all(int pageNo) {
        return null;
    }

    @Override
    public List<Seller> sellers() { return sellerRepo.findAll(); }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(String username) { userRepo.deleteByUsername(username); }

    @Override
    public User findByUsername(String username) {
        User user = userRepo.findByUsername(username);

        if (user != null) {
            System.out.println(user);
            return user;
        }

        return null;
    }

    @Override
    public boolean changePassword(UserPasswordChangeDto userPasswordChangeDto) {
        return false;
    }

    @Override
    public Seller findSellerByUser(Long id) {
        return sellerRepo.findByUserId(id);
    }
}
