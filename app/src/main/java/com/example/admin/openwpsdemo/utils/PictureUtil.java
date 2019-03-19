package com.example.admin.openwpsdemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * @Created by zwh.
 * @description：图片转化成base64
 * @date 2019/1/10 09:44
 * @邮箱：zhaowh@zgjzd.cn
 */
public class PictureUtil {

    private static final String TAG = PictureUtil.class.getSimpleName();

    public static String Bitmap2Base64(String mCurrentPhotoPath) {
        // Get the dimensions of the View
        int targetW = 512;
        int targetH = 512;

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap image = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int q = 80;
        LOGUtils.w("TAG", "图片大小---->" + baos.toByteArray().length);
        while (baos.toByteArray().length / 1024 > 50) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, q, baos);//这里压缩options%，把压缩后的数据存放到baos中
            q -= 10;//每次都减少10
        }
        image.recycle();
        LOGUtils.w(TAG, "压缩后图片大小---->" + baos.toByteArray().length);
        byte[] data = baos.toByteArray();

        return Base64.encodeToString(data, Base64.DEFAULT);

    }

}
