package a.event_handling;

import android.os.Bundle;
import android.view.*;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;

public class CommonGestures extends Fragment implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private TextView tv;
    private GestureDetectorCompat gestureDetectorCompat;

    public CommonGestures() {
        super(R.layout.commongestures);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.commongestures, parent, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        tv = getView().findViewById(R.id.tv_cg);
        this.gestureDetectorCompat = new GestureDetectorCompat(this.getContext(), this);
        gestureDetectorCompat.setOnDoubleTapListener(this);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, android.view.MotionEvent event) {
                return gestureDetectorCompat.onTouchEvent(event);
            }
        });
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        tv.setText("Single tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        tv.setText("Double tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        tv.setText("Double event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        tv.setText("Backlighting");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tv.setText("Single tap");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tv.setText("Scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tv.setText("Long press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        tv.setText("flick");
        return true;
    }
}