package com.example.trubrowsermenusample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class IteoraBottomAppMenuHeaderLayout extends LinearLayout {

    public interface OnAppMenuCloseClickedListener {
        void onAppMenuCloseClicked();
    }

    private OnAppMenuCloseClickedListener menuCloseClickedListener;

    public IteoraBottomAppMenuHeaderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        IteoraBottomAppSettingsLayout.log(getClass().getSimpleName() + ".onFinishInflate()");
        findViewById(R.id.app_menu_close).setOnClickListener((v) -> {
            if (menuCloseClickedListener != null) {
                menuCloseClickedListener.onAppMenuCloseClicked();
            }
        });
    }

    public void setMenuCloseClickedListener(OnAppMenuCloseClickedListener menuCloseClickedListener) {
        this.menuCloseClickedListener = menuCloseClickedListener;
    }
}
