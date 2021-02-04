package com.antorparvez.firebaseapp2appnotification.notification_sevice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAgzuocUw:APA91bFIeoLPBDzgK8_yROSzdkYfUQxaK2ChfzESeHJDv8ePlvWZuVFTsoMXNPUoEoZXJo8fPX8enwAzcDJyGb4J8C-lt2O6pG9P3C-i9txQDhev5jZIIxeafEhmWlGjaJoNzz4vgdcs" // Your server key refer to video for finding your server key
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotifcation(@Body NotificationSender body);
}

