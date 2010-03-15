package com.cruisedroid;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CruiseDroidDataAdapter implements ListAdapter {

  String[] columns = new String[] { "Build", "Result" };
  String[][] data = new String[][] { { "MMH", "Fail" }, { "MMH-Email", "Success" }, { "MMH-Domain", "Fail" }, { "MMH-Web", "Success" } };
  private final Context context;
  private int selectedBuild;

  public CruiseDroidDataAdapter(Context context) {
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
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
    TextView textView = new TextView(context);
    textView.append(data[arg0][0]);
    ImageView imageView = new ImageView(context);
    imageView.setImageResource(data[arg0][1].equals("Success") ? R.drawable.passed : R.drawable.failed);
    imageView.setMaxHeight(10);
    imageView.setMaxWidth(10);
    linearLayout.addView(imageView);
    linearLayout.addView(textView);
    return linearLayout;
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
  public void registerDataSetObserver(DataSetObserver dataSetObserver) {
  }

  @Override
  public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
  }

  @Override
  public boolean areAllItemsEnabled() {
    return true;
  }

  @Override
  public boolean isEnabled(int position) {
    return true;
  }

  public void selectBuild(int buildId) {
    this.selectedBuild = buildId;

  }

  public String getSelectedBuild() {
    return data[selectedBuild][0];
  }
}
