package cmcm.com.applicationchecker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by sunzy on 16-6-10.
 */
public class AppFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        ListView listView = new ListView(getContext());
        listView.setAdapter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
