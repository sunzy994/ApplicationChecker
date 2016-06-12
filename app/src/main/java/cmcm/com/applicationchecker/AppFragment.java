package cmcm.com.applicationchecker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by sunzy on 16-6-10.
 */
public class AppFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        ListView listView = new ListView(getContext());
        listView.setOnItemClickListener(this);
        listView.setAdapter(new AppListAdapter(getContext(), position));
        return listView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AppDetailActivity.startDefault(getContext(), view.getTag().toString());
    }
}
