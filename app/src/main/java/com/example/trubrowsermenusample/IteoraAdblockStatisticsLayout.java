package com.example.trubrowsermenusample;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IteoraAdblockStatisticsLayout extends LinearLayout {

    private Resources resources;

    private TextView adsBlocked;
    private TextView trackingBlocked;
    private TextView trafficSaved;
    private TextView trafficSavedDate;

    public IteoraAdblockStatisticsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        resources = getContext().getResources();

        adsBlocked = findViewById(R.id.ads_blocked);
        trackingBlocked = findViewById(R.id.tracking_blocked);
        trafficSaved = findViewById(R.id.traffic_saved);
        trafficSavedDate = findViewById(R.id.tracking_saved_date);
    }

    public void setAdsBlocked(final int removed) {
        adsBlocked.setText(resources.getString(R.string.adblock_counter_ads_removed, removed));
    }

    public void setTrackingBlocked(final int blocked) {
        trackingBlocked.setText(resources.getString(R.string.adblock_counter_tracking_blocked, blocked));
    }

    public void setTrafficSaved(final int saved) {
        trafficSaved.setText(resources.getString(R.string.adblock_counter_traffic_saved, saved));
    }

    public void setTrafficSavedDate(final int day, final String month) {
        trafficSavedDate.setText(resources.getString(R.string.adblock_counter_traffic_saved_date, day, month));
    }
}
