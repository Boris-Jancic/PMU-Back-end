package com.PMU.Bamboo.web.rest;

import com.PMU.Bamboo.dto.DiscountDto;
import com.PMU.Bamboo.model.Discount;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public interface DiscountApi {

    @PostMapping(value = "/postDiscount",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity postDiscount(@Valid @RequestBody DiscountDto dto);

    @PutMapping(value = "/discounts/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity postDiscount(@Valid @RequestBody Discount discount);

    @GetMapping(value = "/discounts/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getCurrentDiscounts(@PathVariable Long id);

    @DeleteMapping(value = "/discounts/delete/{id}")
    ResponseEntity<?> deleteDiscount(@PathVariable Long id);
}
