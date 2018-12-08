package com.flow.service;

import com.flow.model.SysArea;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("flow-server")
public interface SysAreaService {
    @GetMapping("/sys/area")
    List<SysArea> queryAll(@RequestParam("pageNum") int pageNum,
                           @RequestParam("pageSize") int pageSize);
}
