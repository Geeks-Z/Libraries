package cn.edu.buaa.service;

import cn.edu.buaa.model.dto.UploadFileParamsDto;
import cn.edu.buaa.model.po.MediaFiles;

public interface MediaFileService {

    /**
     * 上传文件
     * @param companyId 机构id
     * @param uploadFileParamsDto 文件信息
     * @param localFilePath 文件本地路径
     * @param objectname 如果传入objectname要按objectname的目录去存储，如果不传就按年月日目录结构去存储
     * @return UploadFileResultDto
     */
    public void uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, String localFilePath, String objectname) throws Exception;

    public MediaFiles addMediaFilesToDb(Long companyId, String fileMd5, UploadFileParamsDto uploadFileParamsDto, String bucket, String objectName);

    /**
     * 将文件上传到minio
     * @param localFilePath 文件本地路径
     * @param mimeType 媒体类型
     * @param bucket 桶
     * @param objectName 对象名
     * @return
     */
    public boolean addMediaFilesToMinIO(String localFilePath,String mimeType,String bucket, String objectName);
}
