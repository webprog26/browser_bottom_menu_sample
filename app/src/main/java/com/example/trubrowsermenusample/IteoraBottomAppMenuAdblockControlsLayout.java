package com.example.trubrowsermenusample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class IteoraBottomAppMenuAdblockControlsLayout extends RelativeLayout implements IteoraAppMenuAdblockSwitch.OnSwitchChangedListener {

    public interface OnAdblockControlsChangedListener {
        void onAdblockChanged(final boolean isEnabled);
        void onCookiesChanged(final boolean isEnabled);
        void onTrackingBlockerChanged(final boolean isEnabled);
        void onShowImagesChanged(final boolean isEnabled);
    }

    private OnAdblockControlsChangedListener adblockControlsChangedListener;

    private IteoraAppMenuAdblockSwitch switchAdblock;
    private IteoraAppMenuAdblockSwitch switchCookies;
    private IteoraAppMenuAdblockSwitch switchTrackingAdblocker;
    private IteoraAppMenuAdblockSwitch switchShowImages;

    public IteoraBottomAppMenuAdblockControlsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        switchAdblock = findViewById(R.id.switch_adblock);
        switchCookies = findViewById(R.id.switch_cookies);
        switchTrackingAdblocker = findViewById(R.id.switch_tracking_blocker);
        switchShowImages = findViewById(R.id.switch_show_images);

        switchAdblock.setOnSwitchChangedListener(this);
        switchCookies.setOnSwitchChangedListener(this);
        switchTrackingAdblocker.setOnSwitchChangedListener(this);
        switchShowImages.setOnSwitchChangedListener(this);
    }


    @Override
    public void onSwitchChanged(View view, boolean isChecked) {
        if (adblockControlsChangedListener != null) {
            final int id = view.getId();

            if (id == R.id.switch_adblock) {
                adblockControlsChangedListener.onAdblockChanged(isChecked);
            } else if (id == R.id.switch_cookies) {
                adblockControlsChangedListener.onCookiesChanged(isChecked);
            } else if (id == R.id.switch_tracking_blocker) {
                adblockControlsChangedListener.onTrackingBlockerChanged(isChecked);
            } else if (id == R.id.switch_show_images) {
                adblockControlsChangedListener.onShowImagesChanged(isChecked);
            }
        }
    }

    public void setOnAdblockControlsChangedListener(OnAdblockControlsChangedListener adblockControlsChangedListener) {
        this.adblockControlsChangedListener = adblockControlsChangedListener;
    }
}
