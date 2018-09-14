package com.westrcat.monitor.controller;

import com.westrcat.monitor.service.MonitorService;
import com.westrcat.monitor.service.ShellCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ql
 * @since 2018-09-07
 */
@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    @Autowired
    private ShellCommandService shellCommandService;

    @GetMapping("/allDevices")
    public Map<String, Object> getAllDevices() {
        return monitorService.getAllDevices();
    }

    @PostMapping("/startDeviceByIds")
    public Map<String, Object> startOrStopDeviceById(Integer[] startIds, Integer[] stopIds) {
        return shellCommandService.startAndStopDeviceById(startIds, stopIds);
    }

}
