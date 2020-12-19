package a.event_handling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;

import java.util.Objects;

public class ButtonClick extends Fragment {

    private TextView tv;

    public ButtonClick() {
        super(R.layout.buttonclick);
    }

    private final View.OnClickListener bcListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tv.setText("Button clicked");
        }
    };

    private final View.OnLongClickListener bclongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            tv.setText("Long button click");
            return true;
        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.buttonclick, parent, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        tv = (TextView) Objects.requireNonNull(getView().findViewById(R.id.tv_bc));
        Button b = getView().findViewById(R.id.button);
        b.setOnClickListener(bcListener);
        b.setOnLongClickListener(bclongListener);
    }
}