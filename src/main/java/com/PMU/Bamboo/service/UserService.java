package com.PMU.Bamboo.service;

import com.PMU.Bamboo.dto.UserPasswordChangeDto;
import com.PMU.Bamboo.model.Seller;
import com.PMU.Bamboo.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> one(Long id);

    Page<User> all(int pageNo);

    List<Seller> sellers();

    User save(User user);

    void delete(String username);

    User findByUsername(String username);

    boolean changePassword(UserPasswordChangeDto userPasswordChangeDto);

    Seller findSellerByUser(Long id);
}
