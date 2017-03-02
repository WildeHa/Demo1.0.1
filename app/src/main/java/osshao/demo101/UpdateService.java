package osshao.demo101;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by LSCM on 2/3/2017.
 */

public class UpdateService extends Service {

    private final static String TAG = "UpdateService";
    private FirstEvent firstEvent;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        firstEvent = new FirstEvent();
        int count = 0;
        do {

            Log.v("MainActivity", "Sending Event" + count);

            firstEvent.setTitle("Counting");
            firstEvent.setContent("Times: " + count);

            EventBus.getDefault().post(firstEvent);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;

        } while (count < 20);

    }
}
