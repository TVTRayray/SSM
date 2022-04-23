package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传：
 *          1.导入pom坐标
 *          2.在Spring—mvc中注册文件上传解析器
 *          3.编写前端表单，enctype="multipart/form-data"
 *          4.后端接收参数，MultipartFile的参数名称必须和前端提交的参数名称一致
 */
@Controller
@RequestMapping("/user2")
public class UserController2 {

    @RequestMapping("/quick1")
    @ResponseBody
    public void save1(String username, MultipartFile uploadFile) throws IOException {
//        System.out.println(username);
//        System.out.println(uploadFile);
        //获取文件名称
        String originalFilename = uploadFile.getOriginalFilename();
        //保存文件
        uploadFile.transferTo(new File("C:\\Users\\70918\\Desktop\\"+originalFilename));
    }

    @RequestMapping("/quick2")
    @ResponseBody
    public void save2(String username, MultipartFile[] uploadFile) throws IOException {
//        System.out.println(username);
//        System.out.pri//获取文件名称
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\Users\\70918\\Desktop\\"+originalFilename));
        }
    }
}
