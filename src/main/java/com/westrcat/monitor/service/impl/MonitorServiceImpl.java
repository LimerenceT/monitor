package com.westrcat.monitor.service.impl;

import com.westrcat.monitor.entity.Monitor;
import com.westrcat.monitor.mapper.MonitorMapper;
import com.westrcat.monitor.service.MonitorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.westrcat.monitor.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ql
 * @since 2018-09-07
 */
@Service
public class MonitorServiceImpl extends ServiceImpl<MonitorMapper, Monitor> implements MonitorService {
    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public Map<String, Object> getAllDevices() {
        List<Monitor> monitors = monitorMapper.selectList(null);
        return ResponseUtil.success().put("data", monitors);
    }

}
