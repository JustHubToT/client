package com.flow.controller;

import com.flow.common.Response;
import com.flow.exception.BussErrEnum;
import com.flow.model.SysUser;
import com.flow.service.SysUserService;
import com.flow.utils.JacksonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @ApiOperation(value = "根据用户id查询用户信息")
    @GetMapping("{id}")
    public Response<SysUser> queryUser(@PathVariable Integer id){
        log.info("根据id：{}查询用户信息", id);
        try {
            SysUser sysUser = userService.queryUser(id);
            if (StringUtils.isEmpty(sysUser)){
                log.info("查询用户信息结果为：null");
                return new Response<>(null, false, BussErrEnum.E_002.getErrCode(), BussErrEnum.E_002.getErrMsg());
            }
            log.info("查询用户信息结果为：{}", JacksonUtil.object2Json(sysUser));
            return new Response<>(sysUser, true, BussErrEnum.S_000.getErrCode(), BussErrEnum.S_000.getErrMsg());
        } catch (Exception e) {
            log.warn("系统错误");
            return new Response<>(null, false, BussErrEnum.E_001.getErrCode(), BussErrEnum.E_001.getErrMsg());
        }
    }

    @ApiOperation(value = "根据用户id删除用户信息")
    @DeleteMapping("{id}")
    public Response<Void> removeUser(@PathVariable Integer id){
        log.info("根据id：{}删除用户信息", id);
        try {
            int i = userService.removeUser(id);
            if (i == 0){
                log.info("删除用户信息失败");
                return new Response<>(false, BussErrEnum.E_003.getErrCode(), BussErrEnum.E_003.getErrMsg());
            }
            log.info("删除用户信息成功");
            return new Response<>(true, BussErrEnum.S_000.getErrCode(), BussErrEnum.S_000.getErrMsg());
        } catch (Exception e) {
            log.warn("系统错误");
            return new Response<>(null, false, BussErrEnum.E_001.getErrCode(), BussErrEnum.E_001.getErrMsg());
        }
    }
}
