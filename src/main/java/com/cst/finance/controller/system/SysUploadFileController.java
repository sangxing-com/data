package com.cst.finance.controller.system;

import com.cst.finance.entity.system.SysUploadFile;
import com.cst.finance.service.system.SysUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/system/sysuploadfile")
public class SysUploadFileController {

    @Autowired
    SysUploadFileService sysUploadFileService;

    @PostMapping("/upload")
    public SysUploadFile upload(@RequestBody MultipartFile file)throws Exception{
        return sysUploadFileService.addSysUploadFile(file);
    }
}
