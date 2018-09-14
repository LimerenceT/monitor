package com.westrcat.monitor.service.impl;

import com.westrcat.monitor.entity.Monitor;
import com.westrcat.monitor.mapper.MonitorMapper;
import com.westrcat.monitor.service.ShellCommandService;
import com.westrcat.monitor.util.ResponseUtil;
import com.westrcat.monitor.common.ShellCommand;
import com.westrcat.monitor.util.ShellExecuteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author qiulong
 * @date 2018/9/10
 */
@Service
public class ShellCommandServiceImpl implements ShellCommandService {
    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public Map<String, Object> startAndStopDeviceById(Integer[] startIds, Integer[] stopIds) {

        String cmd;
        if (startIds != null) {
            List<Integer> startList = Arrays.asList(startIds);
            if (!startList.isEmpty()) {
                List<Monitor> openMonitors = monitorMapper.selectBatchIds(startList);
                for (Monitor monitor : openMonitors) {
                    String url = monitor.getUrl();
                    cmd = ShellCommand.startCmd(url, monitor.getId());
                    ShellExecuteUtil.runCommand(cmd);
                }
            }
        }

        if (stopIds != null) {
            List<Integer> stopList = Arrays.asList(stopIds);
            ArrayList<Integer> closeIds = new ArrayList<>(stopList);
            if (startIds != null) {
                closeIds.removeAll(Arrays.asList(startIds));
            }
            if (!closeIds.isEmpty()) {
                List<Monitor> closeMonitors = monitorMapper.selectBatchIds(closeIds);
                for (Monitor monitor : closeMonitors) {
                    String url = monitor.getUrl();
                    cmd = ShellCommand.stopCmd(url);
                    ShellExecuteUtil.runCommand(cmd);
                }
            }
        }
        return ResponseUtil.success();
    }
}
