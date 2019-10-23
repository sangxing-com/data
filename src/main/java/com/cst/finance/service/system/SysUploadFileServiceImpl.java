package com.cst.finance.service.system;

import com.cst.finance.dao.system.SysUploadFileDao;
import com.cst.finance.entity.system.SysUploadFile;
import com.cst.finance.utils.CommonUtils;
import com.cst.finance.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class SysUploadFileServiceImpl implements SysUploadFileService {

    @Value("${uploadfile.path}")
    private String UploadFilePath;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public SysUploadFile addSysUploadFile(MultipartFile file) {
        try{
            String fileName = file.getOriginalFilename();
            String filepath=UploadFilePath;
            filepath=filepath+ DateTimeUtils.getDateNow().replaceAll("-","/")+"/"+ CommonUtils.getUUID()+"/"+fileName;

            SysUploadFile sysUploadFile=new SysUploadFile();
            sysUploadFile.setFileName(fileName);
            sysUploadFile.setFilePath(filepath);
            sysUploadFile.setFileSize(file.getSize());
            sysUploadFile.setCountentType(file.getContentType());

            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");

            File upload = new File(path.getAbsolutePath(),filepath);
            if(!upload.exists()) upload.mkdirs();

            File dest = new File(path.getAbsolutePath(),filepath);
            file.transferTo(dest);

            mongoTemplate.insert(sysUploadFile);

            return sysUploadFile;
        }catch (IOException ce){
            return null;
        }
    }
}
