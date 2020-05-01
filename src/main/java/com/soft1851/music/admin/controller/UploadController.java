package com.soft1851.music.admin.controller;

import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.test.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/5/1
 **/
@RestController
@RequestMapping("/api/upload")
@Slf4j
public class UploadController {

    @PostMapping("/single")
    public ResponseResult uploadSingle(@RequestParam("file") MultipartFile sourceFile) {
        String url = AliOssUtil.upload(sourceFile);
        return ResponseResult.success(url);
    }
}