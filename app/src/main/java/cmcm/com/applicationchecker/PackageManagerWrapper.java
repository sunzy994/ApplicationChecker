package cmcm.com.applicationchecker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzy on 16-6-10.
 */
public class PackageManagerWrapper {

    private static List<PackageInfo> packageInfos;

    public static List<PackageInfo> getUserAppInfo(Context context){

    }

    public static List<PackageInfo> getSystemAppInfo(Context context){

    }

    private static List<PackageInfo> getAppInfo(Context context, int type){
        if(packageInfos == null){
            packageInfos = context.getPackageManager().getInstalledPackages(0);
        }
        for (PackageInfo info : packageInfos){
            //info.
        }
    }
}
