package com.PMU.Bamboo.web.rest;

import com.PMU.Bamboo.dto.NewArticleDto;
import com.PMU.Bamboo.model.Article;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin
public interface ArticleApi {

    @RequestMapping(value = "/addArticle",
            produces = {MediaType.IMAGE_PNG_VALUE, "application/json"})
    ResponseEntity<?> addArticle(@Valid @RequestBody NewArticleDto newArticleDto);

    @PostMapping(value = "/plants",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity postPlant(@Valid @RequestBody Article article);

    @GetMapping(value = "/allArticles",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getAllArticles() throws IOException;

    @GetMapping(value = "/sellerArticles/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getSellerArticles(@PathVariable("id") Long id) throws IOException;

    @GetMapping(value = "/plant/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getArticle(@PathVariable("id") Long id);

    @PutMapping(value = "/update/plant",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity updateArticle(@Valid @RequestBody Article article);

    @DeleteMapping(value = "/plants/{id}")
    ResponseEntity<?> deleteArticle(@PathVariable("id") Long id);

}
