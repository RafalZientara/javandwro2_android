package com.sdaacademy.zientara.rafal.awesomewidget.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.sdaacademy.zientara.rafal.awesomewidget.R;

import java.util.Random;

/**
 * Created by Evil on 13.04.2017.
 */

public class AwesomeWidgetProvider extends AppWidgetProvider {

    public static final String TAG = AwesomeWidgetProvider.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(TAG, "onReceive");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.d(TAG, "onUpdate");

        ComponentName thisWidget = new ComponentName(context, AwesomeWidgetProvider.class);

        int[] widgetsIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : widgetsIds) {
            updateWidget(context, appWidgetManager, appWidgetIds, widgetId);
        }


    }

    private void updateWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds, int widgetId) {
        int random = new Random().nextInt(1000);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.widget_layout);
        remoteViews.setTextViewText(R.id.randomText, String.valueOf(random));

        setButtonAction(context, appWidgetIds, remoteViews);

        appWidgetManager.updateAppWidget(widgetId, remoteViews);
    }

    private void setButtonAction(Context context, int[] appWidgetIds, RemoteViews remoteViews) {
        //tworzymy widget aktualizujący widok
        Intent intent = new Intent(context, AwesomeWidgetProvider.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        //broadcast by wysłać intent do WSZYSTKICH naszych widgetow
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.randomText, pendingIntent);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.d(TAG, "onDeleted");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(TAG, "onEnabled");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.d(TAG, "onDisabled");
    }
}
