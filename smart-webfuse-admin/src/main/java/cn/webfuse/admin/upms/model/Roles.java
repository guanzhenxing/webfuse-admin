package cn.webfuse.admin.upms.model;

import javax.annotation.Generated;

public class Roles {

    private Long id;


    private String code;


    private String name;


    private String status;


    private String type;


    private String remark;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}