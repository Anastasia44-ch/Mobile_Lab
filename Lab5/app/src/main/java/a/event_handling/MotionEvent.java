package a.event_handling;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class MotionEvent extends Fragment {
    public MotionEvent() {
        super(R.layout.motionevent);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.motionevent, parent, false);
    }
}