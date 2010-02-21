package com.cruisedroid;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CruiseDataAdapter implements ListAdapter {
  
  String[] columns = new String[]{"Build", "Result"};
  String[][] data = new String[][] {{"MMH","Fail"},{"MMH-Email", "Success"},{"MMH-Domain", "Fail"},{"MMH-Web", "Success"}};
  private final Context context;

  
  public CruiseDataAdapter(Context context) {
    super();
    this.context = context;
  }

  @Override
  public int getCount() {
    return data.length;
  }

  @Override
  public Object getItem(int arg0) {
    return data[arg0];
  }

  @Override
  public long getItemId(int arg0) {
    return arg0;
  }

  @Override
  public int getItemViewType(int arg0) {
    return 0;
  }

  @Override
  public View getView(int arg0, View arg1, ViewGroup arg2) {
    TextView textView = new TextView(context);
    textView.append(data[arg0][0]+":"+data[arg0][1]);
    return textView;
  }

  @Override
  public int getViewTypeCount() {
    return 1;
  }

  @Override
  public boolean hasStableIds() {
    return true;
  }

  @Override
  public boolean isEmpty() {
    return data.length == 0;
  }

  @Override
  public void registerDataSetObserver(DataSetObserver arg0) {
  }

  @Override
  public void unregisterDataSetObserver(DataSetObserver arg0) {
  }

  @Override
  public boolean areAllItemsEnabled() {
    return true;
  }

  @Override
  public boolean isEnabled(int position) {
    return true;
  }
}
