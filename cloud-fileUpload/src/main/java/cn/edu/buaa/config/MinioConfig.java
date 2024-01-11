package cn.edu.buaa.config;

/**
 * @ClassName MinioConfig
 * @Description TODO
 * @Author hwzhao
 * @Data 2023/8/25 15:25
 * @Version 1.0
 **/

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MinioConfig
 * @Description minio配置
 * @Author hwzhao
 * @Data 2023/8/20 10:40
 * @Version 1.0
 **/
@Configuration
public class MinioConfig {
    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {

        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();
        return minioClient;
    }


}

