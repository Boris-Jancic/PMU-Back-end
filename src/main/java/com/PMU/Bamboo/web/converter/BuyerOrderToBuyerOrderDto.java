package com.PMU.Bamboo.web.converter;

import com.PMU.Bamboo.dto.BuyerOrderDto;
import com.PMU.Bamboo.model.BuyerOrder;
import org.springframework.core.convert.converter.Converter;

public class BuyerOrderToBuyerOrderDto implements Converter<BuyerOrder, BuyerOrderDto> {
    @Override
    public BuyerOrderDto convert(BuyerOrder buyerOrder) {
        BuyerOrderDto dto = new BuyerOrderDto();
        dto.setComment(buyerOrder.getComment());
        dto.setAnonymousComment(buyerOrder.isAnonymousComment());
        dto.setArchivedComment(buyerOrder.isArchivedComment());
        dto.setDelivered(buyerOrder.isDelivered());
        dto.setGrade(buyerOrder.getGrade());
        dto.setUsername(buyerOrder.getUser());
        return dto;
    }
}
