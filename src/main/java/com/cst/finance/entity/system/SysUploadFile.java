package com.cst.finance.entity.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "SysUploadFile")
public class SysUploadFile {

    @Id
    private String id;
    @Field("FileName")
    private String FileName;
    @Field("FilePath")
    private String FilePath;
    @Field("CountentType")
    private String CountentType;
    @Field("FileSize")
    private double FileSize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public String getCountentType() {
        return CountentType;
    }

    public void setCountentType(String countentType) {
        CountentType = countentType;
    }

    public double getFileSize() {
        return FileSize;
    }

    public void setFileSize(double fileSize) {
        FileSize = fileSize;
    }
}
