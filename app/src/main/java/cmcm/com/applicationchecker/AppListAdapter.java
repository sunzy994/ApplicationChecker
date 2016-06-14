package cmcm.com.applicationchecker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sunzy on 16-6-10.
 */
public class AppListAdapter extends BaseAdapter {

    private List<PackageInfo> mData;
    private Context mContext;
    private PackageManager mPackageManager;

    public AppListAdapter(Context context, int position){
        mContext = context;
        mData = position == 0 ? PackageManagerWrapper.getUserAppInfo(mContext):PackageManagerWrapper.getSystemAppInfo(mContext);
        mPackageManager = context.getPackageManager();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PackageInfo info = mData.get(position);
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_app, null);
        }
        convertView.setTag(info.packageName);
        convertView.findViewById(R.id.icon_app).setBackground(mPackageManager.getApplicationIcon(info.applicationInfo));
        ((TextView)convertView.findViewById(R.id.app_label)).setText(mPackageManager.getApplicationLabel(info.applicationInfo));
        ((TextView)convertView.findViewById(R.id.app_pkg)).setText(info.packageName);

        return convertView;
    }
}
