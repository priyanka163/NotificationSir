package com.example.bridgelabz.notificationsir;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        notify = (Button)findViewById(R.id.button_notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                Intent i = new Intent(MainActivity.this,Notification_class.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,i,0);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Facebook");
                builder.setContentText("Hi gm and happy weekend to all enjoy the day in jsp");
                builder.setTicker("Message from Jspider");
                builder.setSmallIcon(R.drawable.fb);


                builder.setVibrate(new long[]{1000,1000,1000,1000,1000});

                Uri sound =  RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(sound);

                builder.setContentIntent(pendingIntent);
                builder.build();

                Notification notification = builder.getNotification();

                notificationManager.notify(111,notification);








            }
        });

    }
}