package mx.ipn.cic.pushnotificationexample.fcm;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static String TAG = MyFirebaseMessagingService.class.getName();

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);

        Log.i(TAG, "Nuevo token: " + token);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.i(TAG, remoteMessage.getData().toString());

        String title = remoteMessage.getData().get("title");
        String body = remoteMessage.getData().get("body");

        Log.i(TAG, remoteMessage.getData().toString());
        Log.i(TAG, "Title: " + title);
        Log.i(TAG, "Body: " + body);

    }
}
