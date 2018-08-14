package com.example.popo.xylm.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by popo on 2018/8/9.
 */

public class NetWorkUtil {
    private static ConnectivityManager connectivityManager;
    //判断是否有网络链接

    public static boolean havaNetWork(Context context){
        //获取网络链接者管理对象
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取网络信息
        NetworkInfo Info = connectivityManager.getActiveNetworkInfo();
        if (Info==null || !Info.isConnected()){

            return false;
        }
        if (Info.isRoaming()){
            return false;
        }
        return true;
    }
    //判断是否有WIFI的方法

    public static boolean isWiFi(){
        if (connectivityManager!=null){
            //拿到所有网络连接数据组
            NetworkInfo[] Info = connectivityManager.getAllNetworkInfo();
            if (Info!=null){
                for(int i=0;i<Info.length;i++){
                    if (Info[i].getTypeName().equals("WIFI")&& Info[i].isConnected()){
                        return true;

                    }


                }


            }

        }

        return false;
    }

    public static boolean isMobileConnected(Context context){
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo!=null){

            return true;
        }

        return false;
    }
}
