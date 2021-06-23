package com.PMU.Bamboo.service.impl;

import com.PMU.Bamboo.dto.NewArticleDto;
import com.PMU.Bamboo.model.Article;
import com.PMU.Bamboo.model.Discount;
import com.PMU.Bamboo.repository.ArticleRepo;
import com.PMU.Bamboo.repository.DiscountRepo;
import com.PMU.Bamboo.service.ArticleService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class JpaArticleService implements ArticleService {

    private final String imageDirectory = System.getProperty("user.dir") + "/images/";

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private DiscountRepo discountRepo;

    @Override
    public List<Article> getAll() { return articleRepo.findAll(); }

    @Override
    public List<Article> getSellerArticles(Long id) {
        return articleRepo.getSellerArticles(id);
    }

    @Override
    public Article save(Article article) {
        if (article != null) {
            this.articleRepo.save(article);
        }
        return article;
    }

    @Override
    public void delete(Long id) {
        Optional<Article> articleOptional = this.articleRepo.findById(id);
        if(articleOptional.isPresent()) {
            Article article = articleOptional.get();
            articleRepo.deleteById(id);
            discountRepo.deleteByArticleId(id);
        }
    }

    @Override
    public Article one(Long id) {
        List<Discount> discounts = discountRepo.getActualDiscounts(id);
        Optional<Article> articleOptional = articleRepo.findById(id);

        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            double articlePrice = article.getPrice();
            double discountPrice = 0;

            for (Discount discount : discounts) {
                if (discount.getArticle().getId().equals(article.getId())) {
                    discountPrice = articlePrice - articlePrice * (discount.getDiscountPercent() * 0.01);
                    article.setPrice(discountPrice);
                }
            }

            return article;
        }
        return null;
    }
    @Override
    public Article saveNewArticle(NewArticleDto newArticleDto) {
        //This will decode the String which is encoded by using Base64 class
        byte[] imageByte = Base64.decodeBase64(newArticleDto.getBase64Image());
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory, newArticleDto.getImgName() + ".jpg");
        Article article = new Article(
                newArticleDto.getName(),
                newArticleDto.getDescription(),
                Double.parseDouble(newArticleDto.getPrice()),
                newArticleDto.getImgName() + ".jpg",
                newArticleDto.getSellerId());
        try {
            Files.write(fileNamePath, imageByte);
            this.articleRepo.save(article);
            return article;
        } catch (IOException ex) {
            return null;
        }
    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
