package com.PMU.Bamboo.web.converter;

import com.PMU.Bamboo.dto.DiscountDto;
import com.PMU.Bamboo.model.Discount;
import com.PMU.Bamboo.repository.UserRepo;
import com.PMU.Bamboo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DiscountDtoToDiscount implements Converter<DiscountDto, Discount> {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Discount convert(DiscountDto dto) {
        Discount discount = new Discount();
        int per = Integer.parseInt(dto.getDiscountPercent());
        discount.setDiscountPercent(per);
        discount.setDescription(dto.getDescription());
        discount.setFromDate(dto.getFromDate());
        discount.setTillDate(dto.getTillDate());
        discount.setArticle(articleService.one(dto.getArticleId()));
        discount.setSeller(userRepo.findById(dto.getSellerId()).get());
        return discount;
    }
}
