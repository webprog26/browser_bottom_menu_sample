package com.example.trubrowsermenusample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IteoraBottomAppMenuItem extends LinearLayout {

    private ImageView icon;
    private TextView title;

    interface OnItemClickListener {
        void onItemClicked(final View itemView);
        void onItemReleased();
    }

    private OnItemClickListener onItemClickListener;

    private View iconContainer;

    public IteoraBottomAppMenuItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void init(final Context context, @Nullable final AttributeSet attrs) {
        setGravity(Gravity.CENTER);
        setOrientation(VERTICAL);
        final View rootView = LayoutInflater.from(context).inflate(R.layout.bottom_app_menu_item, this, true);
        icon = rootView.findViewById(R.id.iv_icon);
        title = rootView.findViewById(R.id.tv_title);

        if (attrs != null) {
            final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IteoraBottomAppMenuItem, 0, 0);
            try {
                final int itemIconId = ta.getResourceId(R.styleable.IteoraBottomAppMenuItem_android_src, 0);
                if (itemIconId != 0) {
                    setIcon(itemIconId);
                }
                final int itemTextId = ta.getResourceId(R.styleable.IteoraBottomAppMenuItem_android_text, 0);
                if (itemTextId != 0) {
                    setTitle(itemTextId);
                }
            } finally {
                ta.recycle();
            }
        }

        iconContainer = rootView.findViewById(R.id.icon_container);
    }

    protected void setIconBackground(final Drawable background) {
        iconContainer.setBackground(background);
    }

    protected void onActionDown() {
        if (onItemClickListener != null) {
            setIconBackground(ContextCompat.getDrawable(getContext(), R.drawable.bottom_app_menu_item_icon_bg_active));
            onItemClickListener.onItemClicked(IteoraBottomAppMenuItem.this);
            Log.i("it_bt_menu", "down");
        }
    }

    protected void onActionUp() {
        if (onItemClickListener != null) {
            setIconBackground(ContextCompat.getDrawable(getContext(), R.drawable.bottom_app_menu_item_icon_bg_inactive));
            if (getId() != R.id.more) {
                onItemClickListener.onItemReleased();
            }
            Log.i("it_bt_menu", "up");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (onItemClickListener != null) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    onActionDown();
                    return true;
                case MotionEvent.ACTION_UP:
                    onActionUp();
                    return true;
            }
        }
        return super.onTouchEvent(event);
    }

    public void setIcon(@DrawableRes final int iconRes) {
        icon.setImageDrawable(ContextCompat.getDrawable(getContext(), iconRes));
    }

    public void setTitle(@StringRes final int titleRes) {
        title.setText(getContext().getString(titleRes));
    }
}
