package com.example.muthu.flashy;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.example.muthu.flashy.helper.FlashLightHelper;

import static android.telephony.SmsMessage.*;

/**
 * Created by Muthu on 11/11/2016.
 */
public class IncomingSms extends BroadcastReceiver {
    private static final String LOG_TAG = "SMSApp";

    /* package */ static final String ACTION =
            "android.provider.Telephony.SMS_RECEIVED";


    private void appendData(StringBuilder buf, String key, String value) {
        buf.append(", ");
        buf.append(key);
        buf.append('=');
        buf.append(value);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            StringBuilder buf = new StringBuilder();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                for (int i = 0; i < messages.length; i++) {
                    SmsMessage message = messages[i];
                    buf.append("Received SMS from  ");
                    buf.append(message.getDisplayOriginatingAddress());
                    buf.append(" - ");
                    buf.append(message.getDisplayMessageBody());
                }
            }
            Log.i(LOG_TAG, "[SMSApp] onReceiveIntent: " + buf);


        }
    }
}