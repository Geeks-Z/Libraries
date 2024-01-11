package cn.edu.buaa.controller;

import cn.edu.buaa.model.dto.UploadFileParamsDto;
import cn.edu.buaa.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName MediaFilesController
 * @Description TODO
 * @Author hwzhao
 * @Data 2023/8/26 14:58
 * @Version 1.0
 **/
@RestController
public class MediaFilesController {

    @Autowired
    MediaFileService mediaFileService;

    @RequestMapping(value = "/upload/photo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart("filedata") MultipartFile filedata,
                                      @RequestParam(value= "objectName",required=false) String objectName) throws Exception {

        //准备上传文件的信息
        UploadFileParamsDto uploadFileParamsDto = new UploadFileParamsDto();
        //原始文件名称
        uploadFileParamsDto.setFilename(filedata.getOriginalFilename());
        //文件大小
        uploadFileParamsDto.setFileSize(filedata.getSize());
        //文件类型
        uploadFileParamsDto.setFileType("001001");
        //创建一个临时文件
        File tempFile = File.createTempFile("minio", ".temp");
        filedata.transferTo(tempFile);
        Long companyId = 1232141425L;
        //文件路径
        String localFilePath = tempFile.getAbsolutePath();

        //调用service上传图片
        mediaFileService.uploadFile(companyId, uploadFileParamsDto, localFilePath,objectName);

    }

}
