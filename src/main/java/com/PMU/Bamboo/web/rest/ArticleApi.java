package com.PMU.Bamboo.web.rest;

import com.PMU.Bamboo.model.Article;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@CrossOrigin
public interface ArticleApi {

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST,
            produces = {MediaType.IMAGE_PNG_VALUE, "application/json"})
    ResponseEntity<?> addArticle(@RequestParam("picture")MultipartFile file,
                                    @RequestParam("name") String name,
                                    @RequestParam("description") String description,
                                    @RequestParam("price") String price,
                                    @RequestParam("sellerId") Long sellerId);

    @PostMapping(value = "/plants",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity postPlant(@Valid @RequestBody Article article);

    @GetMapping(value = "/allArticles",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getAllArticles();

    @GetMapping(value = "/sellerArticles/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getSellerArticles(@PathVariable("id") Long id);

    @GetMapping(value = "/getArticle/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getArticle(@PathVariable("id") Long id);

    @PutMapping(value = "/update/plant",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity updateArticle(@Valid @RequestBody Article article);

    @DeleteMapping(value = "/plants/{id}")
    ResponseEntity<?> deleteArticle(@PathVariable("id") Long id);

}
