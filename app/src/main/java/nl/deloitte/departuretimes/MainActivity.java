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
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup;

import java.util.List;

import nl.deloitte.departuretimes.data.stations.Station;


public class MainActivity extends ListActivity {

    public final static String EXTRA_DEPARTURE_STATION = "nl.deloitte.departuretimes.DEPARTURE_STATION";
    public final static String EXTRA_DEPARTURE_STATION_CODE = "nl.deloitte.departuretimes.DEPARTURE_STATION_CODE";

    public DataManager dataManager;
    public List<Station> stationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        dataManager = new DataManager(this);
        stationList = dataManager.GetStationList();
        ArrayAdapter<Station> myAdapter = new ArrayAdapter<Station>(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, stationList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                Station station = stationList.get(position);
                text1.setText(station.getNamen().getLang());
                text2.setText(station.getType());
                return view;
            }
        };

        // assign the list adapter
        setListAdapter(myAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        //This method will be called when an item in the list is selected.

        Intent intent = new Intent(this, DisplayDepartureTimesForStation.class);
        String departure_stationCode = stationList.get(position).getCode();
        intent.putExtra(EXTRA_DEPARTURE_STATION_CODE, departure_stationCode);

        startActivity(intent);
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
