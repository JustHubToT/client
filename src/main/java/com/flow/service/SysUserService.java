package com.flow.service;

import com.flow.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("flow-server")
public interface SysUserService {
    @DeleteMapping("/sys/user/{id}")
    int removeUser(@PathVariable("id") Integer id);

    @GetMapping("/sys/user/{id}")
    SysUser queryUser(@PathVariable("id") Integer id);
}
