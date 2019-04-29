package com.se.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    @RequestMapping(value = "/img/{imgname}",produces = "get")
    @ResponseBody
    public BufferedImage getImage(@PathVariable String imgname) throws IOException {

        return ImageIO.read(new FileInputStream(new File(UPLOAD_FOLDER + "/static/img/" + imgname)));
    }

}
