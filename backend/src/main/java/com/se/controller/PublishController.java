package com.se.controller;

import com.se.entity.GoodsInformation;
import com.se.service.GoodsService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PublishController {
    @Autowired
    private GoodsService goodsService;

    //发布时插入商品信息
    /*@RequestMapping("/insertGoodsInformation")
    private List<GoodsInformation> goodsinformationInsert(){
        goodsService.insert_Service(0, "11", 400, "2",  10 );
       return goodsService.query_ByIdService();
    }*/

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/insertGoodsInformation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    private List<GoodsInformation> goodsinformationInsert(HttpServletRequest request, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String goods_name=request.getParameter("goods_name");
        int price=Integer.valueOf(request.getParameter("price"));
        String goods_detail=request.getParameter("goods_detail");
        int class_id=Integer.valueOf(request.getParameter("class_id"));

        goodsService.insert_Service(0, goods_name, price, goods_detail,  class_id ,"111");
        return goodsService.query_ByIdService();
    }

    @ResponseBody
    @RequestMapping("/addData")
    public Map<String,Object> adddata(@RequestParam MultipartFile file,HttpServletRequest request  ) throws IOException
    {
        Map<String,Object> map=new HashMap<String,Object>();
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        //设置图片上传路径
        //获取项目根路径下面自己新建的upload123文件夹，用于存储图片
        String url = request.getSession().getServletContext().getRealPath("/upload123");
        File filex=new File(url);
        if(!filex.exists()){
            filex.mkdir();
        }
        //以绝对路径保存重名命后的图片
        file.transferTo(new File(url+"/"+name + "." + ext));
        //把图片存储路径保存到数据库
        String urlxxx="upload123/"+name + "." + ext;
        goodsService.insert_Service(0, "111", 11, "111", 1 ,urlxxx);
        return map;
    }
}
