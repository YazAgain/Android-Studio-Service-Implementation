package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class service extends Service {
    MediaPlayer player;


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.start();
        return START_STICKY;
        //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        //return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
       // Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show();
        player.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
