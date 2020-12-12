package com.example.trubrowsermenusample;

import android.content.Context;
import android.view.View;

public class IteoraBottomAppMenuItems extends IteoraBottomAppMenuBasicNtpItems {

    private IteoraBottomAppMenuItem more;
    private IteoraBottomAppMenuItem recentTabs;
    private View additionalItemsRow;

    public IteoraBottomAppMenuItems(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.bottom_app_menu_items;
    }

    @Override
    protected void onInitialize(View rootView) {
        super.onInitialize(rootView);
        final IteoraBottomAppMenuItem addToBookmarks = findViewById(R.id.add_to_bookmarks);
        final IteoraBottomAppMenuItem searchOnPage = findViewById(R.id.search_on_page);
        final IteoraBottomAppMenuItem addToHomeScreen = findViewById(R.id.add_to_home_screen);
        final IteoraBottomAppMenuItem translate = findViewById(R.id.translate);
        more  = findViewById(R.id.more);
        recentTabs = findViewById(R.id.recent_tabs);

        additionalItemsRow = getChildAt(3);

        addToBookmarks.setOnItemClickListener(this);
        searchOnPage.setOnItemClickListener(this);
        addToHomeScreen.setOnItemClickListener(this);
        translate.setOnItemClickListener(this);
        more.setOnItemClickListener(this);
        recentTabs.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (itemClickListener != null) {
            final int id = v.getId();
            if (id == R.id.add_to_bookmarks) {
                itemClickListener.onAddToBookmarksClick();
            } else if (id == R.id.search_on_page) {
                itemClickListener.onSearchOnPageClick();
            } else if (id == R.id.add_to_home_screen) {
                itemClickListener.onAddToHomeScreenClick();
            } else if (id == R.id.translate) {
                itemClickListener.onTranslateClicked();
            } else if (id == R.id.more) {
                onMoreClicked();
            }
        }
    }

    public void setItemClickListener(final OnIteoraBottomAppMenuItemClickListener listener) {
        this.itemClickListener = listener;
    }

    private void onMoreClicked() {
        IteoraBottomAppSettingsLayout.log("onMoreClicked()");
        manageMoreButton(true);
        additionalItemsRow.setVisibility(View.VISIBLE);
    }

    public void onMenuClosed() {
        manageMoreButton(false);
        additionalItemsRow.setVisibility(View.GONE);
    }

    private void manageMoreButton(final boolean isShowMore) {
        more.setVisibility(isShowMore ? View.GONE : View.VISIBLE);
        recentTabs.setVisibility(isShowMore ? View.VISIBLE : View.GONE);
        IteoraBottomAppSettingsLayout.log(more.getVisibility() == VISIBLE ? " more is visible" : " more is gone");
    }
}
