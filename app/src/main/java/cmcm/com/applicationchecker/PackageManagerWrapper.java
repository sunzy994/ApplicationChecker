package cmcm.com.applicationchecker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzy on 16-6-10.
 */
public class PackageManagerWrapper {

    private static List<PackageInfo> userPackageInfos = new ArrayList<>();
    private static List<PackageInfo> sysPackageInfos = new ArrayList<>();

    public static List<PackageInfo> getUserAppInfo(Context context){
        if(userPackageInfos.size() == 0){
            init(context);
        }
        return userPackageInfos;
    }

    public static List<PackageInfo> getSystemAppInfo(Context context){
        if(sysPackageInfos.size() == 0){
            init(context);
        }
        return sysPackageInfos;
    }

    private static void init(Context context){
        List<PackageInfo> packageInfos = context.getPackageManager().getInstalledPackages(0);
        for (PackageInfo pinfo : packageInfos){
            ApplicationInfo info = pinfo.applicationInfo;
            if(((info.flags & ApplicationInfo.FLAG_SYSTEM) != 0 || (info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0)){
                sysPackageInfos.add(pinfo);
            } else {
                userPackageInfos.add(pinfo);
            }
        }
    }
}
