package com.PMU.Bamboo.web.converter;

import com.PMU.Bamboo.dto.ArticleDto;
import com.PMU.Bamboo.dto.NewArticleDto;
import com.PMU.Bamboo.model.Article;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;

@Component
public class ArticleToArticleDto implements Converter<Article, NewArticleDto> {
    private final String imageDirectory = System.getProperty("user.dir") + "/images/";
    public ArticleToArticleDto() {
    }

    @Override
    public NewArticleDto convert(Article article) {
        NewArticleDto dto = new NewArticleDto();

        byte[] fileContent = new byte[0];

        try {
            File imgPath = new File(imageDirectory + article.getImageName());
            fileContent = Files.readAllBytes(imgPath.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        dto.setId(String.valueOf(article.getId()));
        dto.setName(article.getName());
        dto.setDescription(article.getDescription());
        dto.setPrice(String.valueOf(article.getPrice()));
        dto.setImgName(article.getImageName());
        dto.setSellerId(article.getSellerId());
        dto.setBase64Image(encodedString);

        return dto;
    }

    public List<NewArticleDto> convert(List<Article> articles) throws IOException {

        List<NewArticleDto> retVal = new ArrayList<>();

        for (Article a : articles) {
            NewArticleDto dto = this.convert(a);
            retVal.add(dto);
        }

        return retVal;
    }
}
