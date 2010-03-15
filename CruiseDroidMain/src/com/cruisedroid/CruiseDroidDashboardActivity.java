package com.cruisedroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

public class CruiseDroidDashboardActivity extends ListActivity {
  private static final int RESTART_ID = Menu.FIRST;
  private CruiseDroidDataAdapter cruiseDataAdapter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cruise_job_list);
    cruiseDataAdapter = new CruiseDroidDataAdapter(this);
    setListAdapter(cruiseDataAdapter);
  }

  @Override
  protected void onListItemClick(ListView list, View view, int position, long id) {
    super.onListItemClick(list, view, position, id);
    cruiseDataAdapter.selectBuild((int) id);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public boolean onContextItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case RESTART_ID:
      Toast.makeText(this, "Build " + cruiseDataAdapter.getSelectedBuild() + "has been triggered", Toast.LENGTH_SHORT).show();
      break;
    default:
      break;
    }
    return super.onContextItemSelected(item);
  }

  
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case RESTART_ID:
      Toast.makeText(this, "Build " + cruiseDataAdapter.getSelectedBuild() + " has been triggered", Toast.LENGTH_SHORT).show();
      break;
    default:
      break;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    menu.add(0, RESTART_ID, 0, R.string.menu_restart_job);
    return true;
  }
}