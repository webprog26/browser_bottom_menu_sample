package com.example.trubrowsermenusample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class IteoraBottomAppSettingsLayout extends LinearLayout implements IteoraBottomAppMenuBasicNtpItems.OnIteoraBottomAppMenuItemClickListener,
        IteoraBottomAppMenuHeaderLayout.OnAppMenuCloseClickedListener, IteoraBottomAppMenuAdblockControlsLayout.OnAdblockControlsChangedListener {

    private IteoraAdblockStatisticsLayout adblockStatisticsLayout;
    private IteoraBottomAppMenuBasicNtpItems iteoraBottomAppMenuItems;

    private ViewGroup itemsView;

    public IteoraBottomAppSettingsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init () {
        setOrientation(VERTICAL);
        setPadding(0, 0, 0, (int)getResources().getDimension(R.dimen.button_height));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        log(getClass().getSimpleName() + ".onFinishInflate()");
        findViewById(R.id.app_settings_view_shadow).setOnClickListener(v -> hideBottomAppSettings());

        final View bottomAppSettingsContent = findViewById(R.id.bottom_app_settings_content);
        itemsView = bottomAppSettingsContent.findViewById(R.id.bottom_app_menu_items);

        final IteoraBottomAppMenuHeaderLayout menuHeaderLayout = findViewById(R.id.app_menu_header_layout);
        menuHeaderLayout.setMenuCloseClickedListener(this);

        adblockStatisticsLayout = menuHeaderLayout.findViewById(R.id.adblock_statistics_layout);

        final IteoraBottomAppMenuAdblockControlsLayout adblockControlsLayout = findViewById(R.id.adblock_controls_layout);
        adblockControlsLayout.setOnAdblockControlsChangedListener(this);
    }


    public void toggleBottomAppSettingsLayout() {
        log("toggleBottomAppSettingsLayout()");
        final int visibility = getVisibility();
        if (visibility == View.GONE) {
            updateSettings();
            setVisibility(View.VISIBLE);
        } else {
            hideBottomAppSettings();
        }
    }

    private void updateSettings() {
        final boolean isNtp = true;
        iteoraBottomAppMenuItems = isNtp ? new IteoraBottomAppMenuBasicNtpItems(getContext()) : new IteoraBottomAppMenuItems(getContext());
        iteoraBottomAppMenuItems.setItemClickListener(this);

        itemsView.addView(iteoraBottomAppMenuItems);

        initDesktopSiteItem(true);
        adblockStatisticsLayout.setAdsBlocked(999);
        adblockStatisticsLayout.setTrackingBlocked(999);
        adblockStatisticsLayout.setTrafficSaved(999);

        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        adblockStatisticsLayout.setTrafficSavedDate(calendar.get(Calendar.DAY_OF_MONTH),
                new SimpleDateFormat("MMM", Locale.getDefault()).format(calendar.getTime()));

    }

    private void hideBottomAppSettings() {
        log("hideBottomAppSettings()");
        itemsView.removeAllViews();
        if (iteoraBottomAppMenuItems instanceof IteoraBottomAppMenuItems) {
            ((IteoraBottomAppMenuItems) iteoraBottomAppMenuItems).onMenuClosed();
        }
        setVisibility(View.GONE);
    }

    private void initDesktopSiteItem(final boolean isInDesktopMode) {
        iteoraBottomAppMenuItems.initDesktopSiteItem(isInDesktopMode);
    }

    @Override
    public void onAddToBookmarksClick() {
        log("onAddToBookmarksClick()");
    }

    @Override
    public void onSearchOnPageClick() {
        log("onSearchOnPageClick()");
    }

    @Override
    public void onPrivateTabClick() {
        log("onPrivateTabClick()");
    }

    @Override
    public void onDarkModeClick() {
        log("onDarModeClick()");
    }

    @Override
    public void onProtectTabClick() {
        log("onProtectTabClick()");
    }

    @Override
    public void onBookmarksClick() {
        log("onBookmarksClick()");
    }

    @Override
    public void onDownloadsClick() {
        log("onDownloadsClick()");
    }

    @Override
    public void onAddToHomeScreenClick() {
        log("onAddToHomeScreenClick()");
    }

    @Override
    public void onMyDataClicked() {
        log("onMyDataClicked()");
    }

    @Override
    public void onTranslateClicked() {
        log("onTranslateClicked()");
    }

    @Override
    public void onLogOutClicked() {
        log("onLogOutClicked()");
    }

    @Override
    public void onRecentTabsClicked() {
        log("onRecentTabsClicked()");
    }

    @Override
    public void onHistoryClicked() {
        log("onHistoryClicked()");
    }

    @Override
    public void onDesktopSiteClicked() {
        log("onDesktopSiteClicked()");
        initDesktopSiteItem(false);
    }

    @Override
    public void onSettingsClicked() {
        log("onSettingsClicked()");
    }

    @Override
    public void onCloseAppClicked() {
        log("onCloseAppClicked()");
    }

    @Override
    public void onItemReleased() {
        hideBottomAppSettings();
    }

    @Override
    public void onAdblockChanged(boolean isEnabled) {
        log("onAdblockChanged(): " + isEnabled);
    }

    @Override
    public void onCookiesChanged(boolean isEnabled) {
        log("onCookiesChanged(): " + isEnabled);
    }

    @Override
    public void onTrackingBlockerChanged(boolean isEnabled) {
        log("onTrackingBlockerChanged(): " + isEnabled);
    }

    @Override
    public void onShowImagesChanged(boolean isEnabled) {
        log("onShowImagesChanged(): " + isEnabled);
    }

    @Override
    public void onAppMenuCloseClicked() {
        log("onAppMenuCloseClicked()");
        hideBottomAppSettings();
    }

    public static void log(final String message) {
        Log.i("bt_app_sets_deb", message);
    }
}
