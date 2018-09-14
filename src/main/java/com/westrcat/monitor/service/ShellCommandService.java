package com.westrcat.monitor.service;

import java.util.Map;

/**
 * @author qiulong
 * @date 2018/9/10
 */
public interface ShellCommandService {
    /**
     * 打开和关闭设备
     *
     * @param startIds
     * @param stopIds
     * @return
     */
    Map<String, Object> startAndStopDeviceById(Integer[] startIds, Integer[] stopIds);

}
