package com.example.trubrowsermenusample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class IteoraBottomAppMenuItems extends LinearLayout implements IteoraBottomAppMenuItem.OnItemClickListener, View.OnClickListener {

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
        void onMoreClicked();
        void onRecentTabsClicked();
        void onHistoryClicked();
        void onDesktopSiteClicked();
        void onSettingsClicked();
        void onCloseAppClicked();
        void onItemReleased();
    }

    private OnIteoraBottomAppMenuItemClickListener itemClickListener;

    private IteoraBottomAppMenuItem more;
    private IteoraBottomAppMenuItem recentTabs;
    private IteoraDesktopSiteBottomAppMenuItem desktopSite;
    private View additionalItemsRow;

    public IteoraBottomAppMenuItems(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        IteoraBottomAppSettingsLayout.log(getClass().getSimpleName() + ".onFinishInflate()");
        final IteoraBottomAppMenuItem addToBookmarks = findViewById(R.id.add_to_bookmarks);
        final IteoraBottomAppMenuItem searchOnPage = findViewById(R.id.search_on_page);
        final IteoraBottomAppMenuItem privateTab = findViewById(R.id.private_tab);
        final IteoraBottomAppMenuItem darkMode = findViewById(R.id.dark_mode);
        final IteoraBottomAppMenuItem protectTab = findViewById(R.id.protect_tab);
        final IteoraBottomAppMenuItem bookmarks = findViewById(R.id.bookmarks);
        final IteoraBottomAppMenuItem downloads = findViewById(R.id.downloads);
        final IteoraBottomAppMenuItem addToHomeScreen = findViewById(R.id.add_to_home_screen);
        final IteoraBottomAppMenuItem myData = findViewById(R.id.my_data);
        final IteoraBottomAppMenuItem translate = findViewById(R.id.translate);
        final IteoraBottomAppMenuItem logout = findViewById(R.id.logout);
        more  = findViewById(R.id.more);
        recentTabs = findViewById(R.id.recent_tabs);
        final IteoraBottomAppMenuItem history = findViewById(R.id.history);
        desktopSite = findViewById(R.id.desktop_site);
        final IteoraBottomAppMenuItem settings = findViewById(R.id.settings);
        final IteoraBottomAppMenuItem closeApp = findViewById(R.id.close_app);

        additionalItemsRow = getChildAt(3);

        addToBookmarks.setOnItemClickListener(this);
        searchOnPage.setOnItemClickListener(this);
        privateTab.setOnItemClickListener(this);
        darkMode.setOnItemClickListener(this);
        protectTab.setOnItemClickListener(this);
        bookmarks.setOnItemClickListener(this);
        downloads.setOnItemClickListener(this);
        addToHomeScreen.setOnItemClickListener(this);
        myData.setOnItemClickListener(this);
        translate.setOnItemClickListener(this);
        logout.setOnItemClickListener(this);
        more.setOnItemClickListener(this);
        recentTabs.setOnItemClickListener(this);
        history.setOnItemClickListener(this);
        desktopSite.setOnItemClickListener(this);
        settings.setOnItemClickListener(this);
        closeApp.setOnItemClickListener(this);
    }

    @Override
    public void onItemClicked(View itemView) {
        onClick(itemView);
    }

    @Override
    public void onItemReleased() {
        itemClickListener.onItemReleased();
    }

    @Override
    public void onClick(View v) {
        IteoraBottomAppSettingsLayout.log("onClick()");
        if (itemClickListener != null) {
            final int id = v.getId();
            if (id == R.id.add_to_bookmarks) {
                itemClickListener.onAddToBookmarksClick();
            } else if (id == R.id.search_on_page) {
                itemClickListener.onSearchOnPageClick();
            } else if (id == R.id.private_tab) {
                itemClickListener.onPrivateTabClick();
            } else if (id == R.id.dark_mode) {
                itemClickListener.onDarkModeClick();
            } else if (id == R.id.protect_tab) {
                itemClickListener.onProtectTabClick();
            } else if (id == R.id.bookmarks) {
                itemClickListener.onBookmarksClick();
            } else if (id == R.id.downloads) {
                itemClickListener.onDownloadsClick();
            } else if (id == R.id.add_to_home_screen) {
                itemClickListener.onAddToHomeScreenClick();
            } else if (id == R.id.my_data) {
                itemClickListener.onMyDataClicked();
            } else if (id == R.id.translate) {
                itemClickListener.onTranslateClicked();
            } else if (id == R.id.logout) {
                itemClickListener.onLogOutClicked();
            } else if (id == R.id.more) {
                itemClickListener.onMoreClicked();
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

    public void setItemClickListener(final OnIteoraBottomAppMenuItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public void onMoreClicked() {
        manageMoreButton(false);
        additionalItemsRow.setVisibility(View.VISIBLE);
    }

    public void onMenuClosed() {
        manageMoreButton(true);
        additionalItemsRow.setVisibility(View.GONE);
    }

    public void initDesktopSiteItem(final boolean isInDesktopMode) {
        if (desktopSite instanceof IteoraDesktopSiteBottomAppMenuItem) {
            IteoraBottomAppSettingsLayout.log(getClass().getSimpleName() + "initDesktopSiteItem(): " + isInDesktopMode);
            ((IteoraDesktopSiteBottomAppMenuItem) desktopSite).setChecked(isInDesktopMode);
        } else {
            IteoraBottomAppSettingsLayout.log(getClass().getSimpleName() + "initDesktopSiteItem(): " + "not an instanceof IteoraDesktopSiteBottomAppMenuItem");
        }
    }

    private void manageMoreButton(final boolean isShowLess) {
        more.setVisibility(isShowLess ? View.VISIBLE : View.GONE);
        recentTabs.setVisibility(isShowLess ? View.GONE : View.VISIBLE);
    }
}
