package a.event_handling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class CommonGestures extends Fragment {
    public CommonGestures() {
        super(R.layout.commongestures);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.commongestures, parent, false);
    }
}