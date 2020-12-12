package com.example.trubrowsermenusample;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class IteoraBottomAppMenuBasicNtpItems extends LinearLayout implements IteoraBottomAppMenuItem.OnItemClickListener, View.OnClickListener {

    public interface OnIteoraBottomAppMenuItemClickListener {

        void onAddToBookmarksClick();
        void onSearchOnPageClick();
        void onPrivateTabClick();
        void onDarkModeClick();
        void onProtectTabClick();
        void onBookmarksClick();
        void onDownloadsClick();
        void onAddToHomeScreenClick();
        void onMyDataClicked();
        void onTranslateClicked();
        void onLogOutClicked();
        void onRecentTabsClicked();
        void onHistoryClicked();
        void onDesktopSiteClicked();
        void onSettingsClicked();
        void onCloseAppClicked();
        void onItemReleased();
    }

    protected OnIteoraBottomAppMenuItemClickListener itemClickListener;

    private IteoraDesktopSiteBottomAppMenuItem desktopSite;

    public IteoraBottomAppMenuBasicNtpItems(Context context) {
        super(context);
        init(context);
    }

    public IteoraBottomAppMenuBasicNtpItems(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setItemClickListener(final OnIteoraBottomAppMenuItemClickListener listener) {
        this.itemClickListener = listener;
    }

    private void init(final Context context) {
        setOrientation(VERTICAL);
        final View rootView = LayoutInflater.from(context).inflate(getLayoutRes(), this, true);
        onInitialize(rootView);
    }

    protected void onInitialize(final View rootView) {

        final IteoraBottomAppMenuItem privateTab = rootView.findViewById(R.id.private_tab);
        final IteoraBottomAppMenuItem darkMode = rootView.findViewById(R.id.dark_mode);
        final IteoraBottomAppMenuItem protectTab = rootView.findViewById(R.id.protect_tab);
        final IteoraBottomAppMenuItem bookmarks = rootView.findViewById(R.id.bookmarks);
        final IteoraBottomAppMenuItem downloads = rootView.findViewById(R.id.downloads);
        final IteoraBottomAppMenuItem myData = rootView.findViewById(R.id.my_data);
        final IteoraBottomAppMenuItem logout = rootView.findViewById(R.id.logout);
        final IteoraBottomAppMenuItem recentTabs = rootView.findViewById(R.id.recent_tabs);
        final IteoraBottomAppMenuItem history = rootView.findViewById(R.id.history);
        desktopSite = rootView.findViewById(R.id.desktop_site);
        final IteoraBottomAppMenuItem settings = rootView.findViewById(R.id.settings);
        final IteoraBottomAppMenuItem closeApp = rootView.findViewById(R.id.close_app);

        privateTab.setOnItemClickListener(this);
        darkMode.setOnItemClickListener(this);
        protectTab.setOnItemClickListener(this);
        bookmarks.setOnItemClickListener(this);
        downloads.setOnItemClickListener(this);
        myData.setOnItemClickListener(this);
        logout.setOnItemClickListener(this);
        recentTabs.setOnItemClickListener(this);
        history.setOnItemClickListener(this);
        desktopSite.setOnItemClickListener(this);
        settings.setOnItemClickListener(this);
        closeApp.setOnItemClickListener(this);
    }

    @LayoutRes
    protected int getLayoutRes() {
        return R.layout.bottom_app_menu_basic_items;
    }

    @Override
    public void onItemClicked(View itemView) {
        onClick(itemView);
    }

    @Override
    public void onItemReleased() {
        itemClickListener.onItemReleased();
    }

    public void initDesktopSiteItem(final boolean isInDesktopMode) {
        if (desktopSite != null) {
            IteoraBottomAppSettingsLayout.log(getClass().getSimpleName() + "initDesktopSiteItem(): " + isInDesktopMode);
            desktopSite.setChecked(isInDesktopMode);
        } else {
            IteoraBottomAppSettingsLayout.log(getClass().getSimpleName() + "initDesktopSiteItem(): " + "not an instanceof IteoraDesktopSiteBottomAppMenuItem");
        }
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            final int id = v.getId();
            if (id == R.id.private_tab) {
                itemClickListener.onPrivateTabClick();
            } else if (id == R.id.dark_mode) {
                itemClickListener.onDarkModeClick();
            } else if (id == R.id.protect_tab) {
                itemClickListener.onProtectTabClick();
            } else if (id == R.id.bookmarks) {
                itemClickListener.onBookmarksClick();
            } else if (id == R.id.downloads) {
                itemClickListener.onDownloadsClick();
            } else if (id == R.id.my_data) {
                itemClickListener.onMyDataClicked();
            } else if (id == R.id.logout) {
                itemClickListener.onLogOutClicked();
            } else if (id == R.id.recent_tabs) {
                itemClickListener.onRecentTabsClicked();
            } else if (id == R.id.history) {
                itemClickListener.onHistoryClicked();
            } else if (id == R.id.desktop_site) {
                itemClickListener.onDesktopSiteClicked();
            } else if (id == R.id.settings) {
                itemClickListener.onSettingsClicked();
            } else if (id == R.id.close_app) {
                itemClickListener.onCloseAppClicked();
            }
        }
    }
}
