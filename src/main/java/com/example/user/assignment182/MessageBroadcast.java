package com.example.user.assignment182;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by user on 18-12-2017.
 */

//MesaageBroadcast class extending BroadcastReceiver
public class MessageBroadcast extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

   //onReceive method
    @Override
    public void onReceive(Context context, Intent intent) {

        //checking if permissions are correctly taken
        if (intent.getAction().equals(SMS_RECEIVED))
        {

            //taking values in Bundle
            Bundle bundle=intent.getExtras();

            //SmsMessage variable
            SmsMessage[] messages=null;

            String str="";
            if(bundle!=null)
            {
                //making a pdus object
                Object[] pdus= (Object[]) bundle.get("pdus");
               //setting pdus in message
                messages=new SmsMessage[pdus.length];

                for(int i=0;i<messages.length;i++)
                {
                    //fetching data from PDU
                    messages[i]=SmsMessage.createFromPdu((byte[])pdus[i]);

                    //storing data in str variable
                    str += "SMS from " + messages[i].getOriginatingAddress();
                    str += " :\n";
                    str += "message:"+messages[i].getMessageBody().toString();
                    str += "\n";

                }

                //Toast message
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

                    }
                }
        }

        }


