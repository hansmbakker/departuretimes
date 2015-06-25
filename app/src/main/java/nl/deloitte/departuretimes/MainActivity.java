package nl.deloitte.departuretimes;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {

    public final static String EXTRA_DEPARTURE_STATION = "nl.deloitte.departuretimes.DEPARTURE_STATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }

    /*
    public void searchStation(View view){
        //Do something here to search the station
        EditText stationQuery = (EditText) findViewById(R.id.edit_station_query);

        Intent intent = new Intent(this, DisplayDepartureTimesForStation.class);
        String departure_station = stationQuery.getText().toString();
        intent.putExtra(EXTRA_DEPARTURE_STATION, departure_station);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
