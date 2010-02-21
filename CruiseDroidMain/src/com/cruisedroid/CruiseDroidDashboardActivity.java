package com.cruisedroid;

import android.app.ListActivity;
import android.os.Bundle;

public class CruiseDroidDashboardActivity extends ListActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cruise_job_list);
    CruiseDataAdapter cruiseDataAdapter = new CruiseDataAdapter(this);
    setListAdapter(cruiseDataAdapter);
  }
}