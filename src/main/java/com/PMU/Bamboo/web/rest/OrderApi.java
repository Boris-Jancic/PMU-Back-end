package com.PMU.Bamboo.web.rest;

import com.PMU.Bamboo.dto.BuyerOrderDto;
import com.PMU.Bamboo.dto.OrderedArticleDto;
import com.PMU.Bamboo.model.BuyerOrder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public interface OrderApi {

    @PermitAll
    @PostMapping(value = "/order/post",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity postOrder(@Valid @RequestBody BuyerOrderDto dto);

    @PermitAll
    @PostMapping(value = "/cart/plant",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity postOrderedArticle(@Valid @RequestBody OrderedArticleDto dto);

    @PermitAll
    @GetMapping(value = "/seller/comments/{username}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity sellerComments(@PathVariable("username") String username);

    @PermitAll
    @GetMapping(value = "/seller/grade/{username}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity sellerGrade(@PathVariable("username") String username);

    @PermitAll
    @GetMapping(value = "/buyer/orders/{username}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getOrders(@PathVariable("username") String username);

    @PermitAll
    @PutMapping(value = "/order/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity updateOrder(@Valid @RequestBody BuyerOrder buyerOrder);


}
