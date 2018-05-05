package me.microcool.servicedemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate executed");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);

    }

    private DownloadBinder mBinder = new DownloadBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;

    }


    class DownloadBinder extends Binder {

        public void startDownload() {
            Toast.makeText(getApplicationContext(), "startDownload", Toast.LENGTH_SHORT).show();
            Log.d("MyService", "startDownload executed");
        }

        public int getProgress() {
            Toast.makeText(getApplicationContext(), "startDownload", Toast.LENGTH_SHORT).show();
            Log.d("MyService", "gsetProgress executed");
            return 0;
        }
    }
}
