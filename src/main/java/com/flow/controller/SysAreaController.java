package com.flow.controller;


import com.flow.common.Response;
import com.flow.exception.BussErrEnum;
import com.flow.model.SysArea;
import com.flow.service.SysAreaService;
import com.flow.utils.JacksonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(tags = "地区管理接口")
@RestController
@RequestMapping("/sys/area")
public class SysAreaController {

    @Autowired
    private SysAreaService areaService;

    @ApiOperation(value = "分页查询所有地区信息")
    @GetMapping
    public Response<List<SysArea>> queryAll(@RequestParam("pageNum") int pageNum,
                                            @RequestParam("pageSize") int pageSize){
        log.info("分页查询所有地区信息，pageNum：{}，pageSize：{}", pageNum, pageSize);
        try {
            List<SysArea> sysAreas = areaService.queryAll(pageNum, pageSize);
            if (CollectionUtils.isEmpty(sysAreas)){
                log.info("查询地区信息结果为：null");
                return new Response<>(null, false, BussErrEnum.E_002.getErrCode(), BussErrEnum.E_002.getErrMsg());
            }
            log.info("查询地区信息结果为：{}", JacksonUtil.list2Json(sysAreas));
            return new Response<>(sysAreas, true, BussErrEnum.S_000.getErrCode(), BussErrEnum.S_000.getErrMsg());
        } catch (Exception e){
            log.warn("系统错误");
            return new Response<>(null, false, BussErrEnum.E_001.getErrCode(), BussErrEnum.E_001.getErrMsg());
        }
    }
}
