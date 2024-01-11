package cn.edu.buaa;

import cn.edu.buaa.mapper.MediaFilesMapper;
import cn.edu.buaa.model.po.MediaFiles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FileUploadApplicationTests {


    @Autowired
    private MediaFilesMapper mediaFilesMapper;

    @Test
    void contextLoads() {
        List<MediaFiles> users = mediaFilesMapper.selectList(null);
        for (MediaFiles user : users) {
            System.out.println(user);
        }
    }

}
