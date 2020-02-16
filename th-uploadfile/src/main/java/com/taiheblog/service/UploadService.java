package com.taiheblog.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;


import com.taiheblog.config.UploadProperties;
import com.taiheblog.enums.ResultEnums;
import com.taiheblog.exception.ThException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private UploadProperties props;
    public String uploadImage(MultipartFile file) {
        try {
            //校验文件类型
            if(!props.getAllowTypes().contains(file.getContentType())){
                throw  new ThException(ResultEnums.INVALID_FILE_TYPE);
            }
            //校验内容,如果不是图片就返回null
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null){
                throw  new ThException(ResultEnums.INVALID_FILE_TYPE);
            }
            //上传到FastDFS
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            //四个参数 文件流、文件大小、 文件类型、第四个可以为空
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            //返回路径
            return props.getBaseUrl() + storePath.getFullPath();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("[上传文件] 上传文件失败",e);
            throw  new ThException(ResultEnums.UPLOAD_FILE_ERROR);
        }

    }
}
