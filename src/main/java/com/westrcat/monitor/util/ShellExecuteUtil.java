package com.westrcat.monitor.util;

import java.io.*;

/**
 * @author qiulong
 * @date 2018/9/10
 */
public class ShellExecuteUtil {
    public static void runCommand(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}