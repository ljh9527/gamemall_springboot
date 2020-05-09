package com.gamemall.gamemall.controller;

import com.gamemall.gamemall.utils.AjaxResponse;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class FileController {

    @GetMapping(value = "/file")
    public String file() {
        return "file";
    }

    @PostMapping(value = "/fileUpload")
    public AjaxResponse fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "F:\\biyesheji\\gamemall_springboot\\src\\main\\resources\\static\\image\\"; // 上传后的路径
        //获取项目classes/static的地址
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(staticPath + File.separator + "image" + File.separator + fileName);
        log.info("dest"+dest);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/image/" + fileName;
        model.addAttribute("filename", filename);
        log.info("model"+model);
        return AjaxResponse.success(model);
    }
}