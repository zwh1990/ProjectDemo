package com.example.admin.openwpsdemo.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 打印日志类
 */

public class LOGUtils {
    public static  final boolean LOG_DEBUG = false/*APPConfig.DEBUG*/;
    private  static String tag = "# JZDLog #";
    private final static String logFileName = "jzd.log";
    private  static String logPath = "";
    private  static String month;
    private  static String time;
    private  static File file = null;


    @SuppressLint("SimpleDateFormat")
    public  static void initLog() {
        logPath = Environment.getExternalStorageDirectory().getPath() + File.separator + "shcelog" + File.separator;
        month = new SimpleDateFormat("yyyy-MM").format(new Date());
        time = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file = new File(logPath + logFileName + "_" + month +".txt");
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
        }
    }
    /**
     * Prints a message at VERBOSE priority.
     *
     * @param tag Tag for for the log data. Can be used to organize log statements.
     * @param msg The actual message to be logged.
     */
    public static void v(String tag, String msg) {
        if (LOG_DEBUG){
            Log.v(tag, msg, null);
            writeLog(msg);
        }
    }



    /**
     * Prints a message at DEBUG priority.
     *
     * @param tag Tag for for the log data. Can be used to organize log statements.
     * @param msg The actual message to be logged.
     */
    public static void d(String tag, String msg) {
        if (LOG_DEBUG){
            Log.d(tag, msg, null);
            writeLog(msg);
        }
    }



    /**
     * Prints a message at INFO priority.
     *
     * @param tag Tag for for the log data. Can be used to organize log statements.
     * @param msg The actual message to be logged.
     */
    public static void i(String tag, String msg) {
        if (LOG_DEBUG){
            Log.i(tag, msg, null);
            writeLog(msg);
        }
    }


    /**
     * Prints a message at WARN priority.
     *
     * @param tag Tag for for the log data. Can be used to organize log statements.
     * @param msg The actual message to be logged.
     */
    public static void w(String tag, String msg) {
        if (LOG_DEBUG){
            Log.w(tag, msg, null);
            writeLog(msg);
        }
    }


    /**
     * Prints a message at ERROR priority.
     *
     * @param tag Tag for for the log data. Can be used to organize log statements.
     * @param msg The actual message to be logged.
     */
    public static void e(String tag, String msg) {
        if (LOG_DEBUG){
            Log.e(tag, msg, null);
            writeLog(msg);
        }
    }



    /**
     * Prints a message at ASSERT priority.
     *
     * @param tag Tag for for the log data. Can be used to organize log statements.
     * @param msg The actual message to be logged.
     */
    public static void wtf(String tag, String msg) {
        if (LOG_DEBUG){
            Log.wtf(tag, msg, null);
            writeLog(msg);
        }
    }



    private static  void writeLog(String message) {
        if (file != null) {
            FileWriter fw = null;
            try {
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ) {
                    fw = new FileWriter(file, true);
                    fw.append(time).append("-->").append(tag).append(" [").append(message).append("]");
                    fw.append("\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    if(fw!=null){
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void delOldLog(){
        try {
            File filesDir = new File(logPath);
            FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.startsWith(logFileName);
                }
            };
            String[] delFiles = filesDir.list(filter);
            if (delFiles != null && delFiles.length > 0) {
                String y = month.split("-")[0];
                for (String fileName : delFiles) {
                    if (Integer.valueOf(y) > Integer.valueOf(fileName.split("_")[1].split("-")[0]))
                        new File(logPath, fileName).delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
