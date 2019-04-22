package com.se.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

//@RestController
//@RequestMapping("/upload")
//@CrossOrigin
@RestController
@RequestMapping("/api")
public class UploadController {
    @RequestMapping("/addImage")
    @ResponseBody
    public String addImage(@RequestParam(name = "image_data", required = false) MultipartFile file) {
        //文件上传
        if (!file.isEmpty()) {
            try {
                //图片命名
                String newCompanyImageName = "newPIC";
                String newCompanyImagepath = "C:\\"+newCompanyImageName;
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                System.out.println("图片上传成功！");
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("图片上传失败！1");
                return "图片上传失败！";
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("图片上传失败！2");
                return "图片上传失败！";
            }
        }
        System.out.println("图片上传失败！3");
        return "图片上传失败！";
    }
}
