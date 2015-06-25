package nl.deloitte.departuretimes;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nl.deloitte.departuretimes.data.actuelevertrektijden.VertrekkendeTrein;


public class DisplayDepartureTimesForStation extends ListActivity implements ApiResponseConsumer {

    public ArrayAdapter<VertrekkendeTrein> vertrekkendeTreinAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_display_departure_times_for_station);

        //Get the incoming Intent
        Intent intent = getIntent();
        String departureStation = intent.getStringExtra(MainActivity.EXTRA_DEPARTURE_STATION_CODE);

        //TextView resultLabel = (TextView) findViewById(R.id.label_query_result);

        final List<VertrekkendeTrein> vertrekkendeTreinList = new ArrayList<VertrekkendeTrein>();

        vertrekkendeTreinAdapter = new ArrayAdapter<VertrekkendeTrein>(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, vertrekkendeTreinList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                VertrekkendeTrein vertrekkendeTrein = vertrekkendeTreinList.get(position);
                if(vertrekkendeTrein != null) {
                    text1.setText(vertrekkendeTrein.getEindBestemming());
                    text2.setText(vertrekkendeTrein.getVertrekTijd());
                }
                return view;
            }
        };

        // assign the list adapter
        setListAdapter(vertrekkendeTreinAdapter);

        DataManager dataManager = new DataManager(this);
        dataManager.CallVertrekkendeTreinenApi(departureStation, this);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_departure_times_for_station, menu);
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

    @Override
    public void HandleError(String error) {
        //Show an error message instead of the list
    }

    @Override
    public void HandleDownloadResponse(String response) {
        //Handle the downloaded xml
        DataManager dataManager = new DataManager(this);

        List<VertrekkendeTrein> trains = dataManager.ParseVertrekkendeTreinen(response);

        vertrekkendeTreinAdapter.addAll(trains);
        vertrekkendeTreinAdapter.notifyDataSetChanged();
    }
}
