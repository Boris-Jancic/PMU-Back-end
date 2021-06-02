package com.PMU.Bamboo.web.converter;

import com.PMU.Bamboo.dto.SellerDto;
import com.PMU.Bamboo.model.Seller;
import com.PMU.Bamboo.model.User;
import com.PMU.Bamboo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SellerDtoToSeller implements Converter<SellerDto, Seller> {

    @Autowired
    private UserRepo userRepo;

    public SellerDtoToSeller() {
    }

    @Override
    public Seller convert(SellerDto dto) {
        Seller seller = new Seller();
        User user = new User(dto.getName(), dto.getLastName(), dto.getUsername(), dto.getPassword());
        seller.setUser(user);
        seller.setSellerName(dto.getSellerName());
        seller.setAddress(dto.getAddress());
        seller.setEmail(dto.getEmail());
        seller.setSellingSince(LocalDate.now());
        return seller;
    }
}
