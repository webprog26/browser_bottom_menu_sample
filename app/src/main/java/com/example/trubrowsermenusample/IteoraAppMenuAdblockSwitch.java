package com.example.trubrowsermenusample;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IteoraAppMenuAdblockSwitch extends RelativeLayout {

    private SwitchCompat adblockControlSwitch;

    interface OnSwitchChangedListener {
        void onSwitchChanged(final View view, final boolean isChecked);
    }

    private OnSwitchChangedListener switchChangedListener;

    public IteoraAppMenuAdblockSwitch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(final Context context, @Nullable final AttributeSet attrs) {
        final View rootView = LayoutInflater.from(context).inflate(R.layout.iteora_app_menu_adblock_switch, this, true);
        adblockControlSwitch = rootView.findViewById(R.id.adblock_control_switch);
        adblockControlSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (switchChangedListener != null) {
                switchChangedListener.onSwitchChanged(IteoraAppMenuAdblockSwitch.this, isChecked);
            }
        });

        if (attrs != null) {
            final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IteoraBottomAppMenuItem, 0, 0);
            try {
                final int itemIconId = ta.getResourceId(R.styleable.IteoraBottomAppMenuItem_android_src, 0);
                if (itemIconId != 0) {
                    ((ImageView) rootView.findViewById(R.id.adblock_control_icon)).setImageDrawable(ContextCompat.getDrawable(getContext(), itemIconId));
                }
                final int itemTextId = ta.getResourceId(R.styleable.IteoraBottomAppMenuItem_android_text, 0);
                if (itemTextId != 0) {
                    ((TextView) rootView.findViewById(R.id.adblock_control_title)).setText(getContext().getString(itemTextId));
                }
            } finally {
                ta.recycle();
            }
        }
    }

    public void setOnSwitchChangedListener(OnSwitchChangedListener switchChangedListener) {
        this.switchChangedListener = switchChangedListener;
    }
}
