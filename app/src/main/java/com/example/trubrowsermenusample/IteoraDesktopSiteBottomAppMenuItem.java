package com.example.trubrowsermenusample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

public class IteoraDesktopSiteBottomAppMenuItem extends IteoraBottomAppMenuItem {

    public IteoraDesktopSiteBottomAppMenuItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void setChecked(final boolean isChecked) {
        IteoraBottomAppSettingsLayout.log(getClass().getSimpleName() + "setChecked(): " + isChecked);
        setIconBackground(isChecked ?
                ContextCompat.getDrawable(getContext(), R.drawable.bottom_app_menu_item_icon_bg_active)
                : ContextCompat.getDrawable(getContext(), R.drawable.bottom_app_menu_item_icon_bg_inactive));
    }

    @Override
    protected void onActionDown() {

    }
}
