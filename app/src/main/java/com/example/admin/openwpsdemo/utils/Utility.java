package com.example.admin.openwpsdemo.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by admin on 2017/3/6.
 */

public class Utility {
    private static final String PICTRUE_DIR = "/Cbrian/";
    public static final String JPEG_FILE_SUFFIX = ".png";
    private static final String TAG = Utility.class.getSimpleName();

    /**
     * 获取缓存目录
     *
     * @return
     */
    public static File getCacheDir() {
        return null;/*MemoApplication.getContextObject().getExternalCacheDir().getAbsoluteFile()*/
    }

    /**
     * * 获取SD卡目录，返回文件路径
     *
     * @param filename 文件名
     * @return
     */

    public static String getStorageDirectory(String filename) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + filename + ".png";
    }

    //获取运行屏幕宽度
    public static int getScreenWidth(Context cxt) {
        WindowManager wm = (WindowManager) cxt.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;

        return screenWidth;
    }

    //获取运行屏幕宽度
    public static int getScreenHeight(Context cxt) {
        WindowManager wm = (WindowManager) cxt.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int screenHeight = dm.heightPixels;
        return screenHeight;
    }

    public static void setImageLayout(Context cxt, ImageView imageview) {
        LinearLayout.LayoutParams params;
        params = (LinearLayout.LayoutParams) imageview.getLayoutParams();
        params.width = Utility.getScreenWidth(cxt) * 9 / 16;
        params.height = Utility.getScreenHeight(cxt) * 9 / 16;
        imageview.setLayoutParams(params);
    }


    //DP转PX
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //PX转DP
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 创建文件
     *
     * @param fileName
     * @return
     */
    public static File CreatePictrueFile(String fileName) {
        if (fileName == null) return null;
        File pictrueFile = null;
        try {
            pictrueFile = new File(getPictrueDir().getPath() + File.separator + fileName + JPEG_FILE_SUFFIX);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pictrueFile;
    }

    /**
     * h获取文件名
     *
     * @param path
     * @return
     */
    public static String getFileName(String path) {
        File file = new File(path);
        return file.getName();
    }


    /**
     * 获取版本号
     *
     * @param cxt
     * @return
     */
    public static String getAppInfo(Context cxt) {
        String name = cxt.getPackageName();
        try {
            String verName = cxt.getPackageManager().getPackageInfo(name, 0).versionName;
            return verName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "-1";
    }

    /**
     * 创建图片文件夹
     *
     * @return
     */
    public static File getPictrueDir() {
//        String bh = (String) SPUtil.getInstance(
//                MemoApplication.getContextObject()).get("bh","bh");
//
//        LOGUtils.w("TAG","dirname----->"+bh);
//        if (bh==null) return null;
//        File file = new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),bh);
//            if (!file.mkdirs()){
//                if (!file.exists()){
//                    return null;
//                }
//            }
//        return file;
        return null;
    }

    /**
     * 创建地图文件夹
     *
     * @return
     */
    public static String createMapDir(String dirName) {
        if (dirName == null) return null;
        File file = new File(Environment.getExternalStorageDirectory(), dirName);
        if (!file.mkdirs()) {
            if (!file.exists()) {
                return null;
            }
        }
        return file.getAbsolutePath();
    }

    //拍照时返回的的图片显示在ImageView上面,带有缩放
    public static Bitmap setToImageView(String path) {

        int width = 120;
        int height = 120;
        BitmapFactory.Options factoryOptions = new BitmapFactory.Options();

        factoryOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, factoryOptions);

        int imageWidth = factoryOptions.outWidth;
        int imageHeight = factoryOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(imageWidth / width, imageHeight
                / height);

        // Decode the image file into a Bitmap sized to fill the
        // View
        factoryOptions.inJustDecodeBounds = false;
        factoryOptions.inSampleSize = scaleFactor;
        factoryOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(path, factoryOptions);

        return bitmap;
    }


    //拍照时返回的的图片显示在地图的ImageView上面，不缩放
    public static Bitmap setToMapImageView(String path) {

        int width = 120;
        int height = 120;
        BitmapFactory.Options factoryOptions = new BitmapFactory.Options();

        factoryOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, factoryOptions);

        int imageWidth = factoryOptions.outWidth;
        int imageHeight = factoryOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(imageWidth / width, imageHeight
                / height);

        // Decode the image file into a Bitmap sized to fill the
        // View
        factoryOptions.inJustDecodeBounds = false;
        factoryOptions.inSampleSize = 1;
        factoryOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(path, factoryOptions);

        return bitmap;
    }

    /**
     * Check how much usable space is available at a given path.
     *
     * @param path The path to check
     * @return The space available in bytes
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static long getUsableSpace(File path) {
        if (hasGingerbread()) {
            return path.getUsableSpace();
        }
        final StatFs stats = new StatFs(path.getPath());
        return (long) stats.getBlockSize() * (long) stats.getAvailableBlocks();
    }

    public static boolean hasFroyo() {
        //8
        // Can use static final constants like FROYO, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    public static boolean hasGingerbread() {
        //9
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean hasHoneycomb() {
        //11
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean hasHoneycombMR1() {
        //12
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    public static boolean hasJellyBean() {
        //16
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * @param context
     * @param fileName 拷贝的文件名称
     * @param desDir   拷贝到目标文件夹路径
     * @throws Exception
     */
    public static void CopyAssetFile(Context context, String fileName, String desDir) throws Exception {
        String strCpSdPath = desDir + File.separator + fileName;//
        File file = new File(strCpSdPath);
        if (!file.exists()) {
            file.createNewFile();
            InputStream myInput = context.getAssets().open(fileName);
            OutputStream myOutput = new FileOutputStream(file, true);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }

    }

    public static String getAssetsJson(Context mContext, String fileName) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        AssetManager am = mContext.getAssets();
        try {
            InputStream ins = am.open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    ins));

            String next = "";
            while (null != (next = br.readLine())) {
                sb.append(next);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }

    public static InputStream getAssetsInputStream(Context mContext, String fileName) throws IOException {
        // TODO Auto-generated method stub
        AssetManager am = mContext.getAssets();
        InputStream inputStream = am.open(fileName);
        return inputStream;
    }

}
