package com.westrcat.monitor.service;

import com.baomidou.mybatisplus.service.IService;
import com.westrcat.monitor.entity.Monitor;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ql
 * @since 2018-09-07
 */
public interface MonitorService extends IService<Monitor> {
    /**
     * 获得所有设备信息
     * @return Map
     */
    Map<String, Object> getAllDevices();

}
