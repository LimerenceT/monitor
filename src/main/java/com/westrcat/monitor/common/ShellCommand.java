package com.westrcat.monitor.common;

/**
 * @author qiulong
 * @date 2018/9/10
 */
public class ShellCommand {
    public static String startCmd(String url, Integer id) {
        return "/bin/bash /opt/sh/rtspChangeRtmp.sh '' " + url +" "+ id;
    }

    public static String stopCmd(String url) {
        return "/bin/bash /opt/sh/rtspChangeRtmp.sh " + url + " '' '' ";
    }

}
