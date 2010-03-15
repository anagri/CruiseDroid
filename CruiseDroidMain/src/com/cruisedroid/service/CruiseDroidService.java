package com.cruisedroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CruiseDroidService extends Service {
  private CruiseJobService cruiseJobService;

  @Override
  public void onStart(Intent intent, int startId) {
    super.onStart(intent, startId);
  }

  @Override
  public void onCreate() {
    super.onCreate();
    cruiseJobService = new CruiseJobService();
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}
