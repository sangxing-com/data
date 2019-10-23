package com.cst.finance.dao.system;

import com.cst.finance.entity.system.SysUploadFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysUploadFileDao extends MongoRepository<SysUploadFile,String> {
}
