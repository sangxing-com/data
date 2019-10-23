package com.cst.finance.service;

import com.cst.finance.entity.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser addSysUser(SysUser sysUser);

    int delSysUser(String id);

    int updateSysUser(String id,String UserName,String UserPwd);

    List<SysUser> findSysUserByName(String userName);

    List<SysUser> findSysUserByUserNameAndUserPwd(SysUser sysUser);

    List<SysUser> findSysUser();

}
