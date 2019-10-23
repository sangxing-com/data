package com.cst.finance.service.system;

import com.cst.finance.entity.system.SysUploadFile;
import org.springframework.web.multipart.MultipartFile;

public interface SysUploadFileService {

    SysUploadFile addSysUploadFile(MultipartFile file);
}
