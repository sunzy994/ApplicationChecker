package cmcm.com.applicationchecker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AppDetailActivity extends Activity {

    public static final String PACKAGE_NAME = "package_name";
    private PackageInfo mInfo;
    private TextView tvLabel;
    private TextView tvPkg;
    private TextView tvVersionCode;

    public static void startDefault(Context context, String pkg){
        Intent intent = new Intent(context, AppDetailActivity.class);
        intent.putExtra(PACKAGE_NAME, pkg);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);
        try {
            mInfo = getPackageManager().getPackageInfo(getIntent().getStringExtra(PACKAGE_NAME), 0);
        } catch (Exception e){
            e.printStackTrace();
        }
        tvLabel = (TextView) findViewById(R.id.tv_label);
        tvLabel.setText(getPackageManager().getApplicationLabel(mInfo.applicationInfo));
        tvPkg = (TextView) findViewById(R.id.tv_pkg);
        tvPkg.setText(mInfo.packageName);
        findViewById(R.id.app_detail_icon).setBackground(getPackageManager().getApplicationIcon(mInfo.applicationInfo));
        tvVersionCode = (TextView)findViewById(R.id.version_code);
        tvVersionCode.setText("version code:" + mInfo.versionCode);
    }
}
