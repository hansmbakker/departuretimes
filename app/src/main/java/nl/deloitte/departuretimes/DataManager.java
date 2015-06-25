package nl.deloitte.departuretimes;

import android.content.Context;

import org.pojoxml.core.PojoXml;
import org.pojoxml.core.PojoXmlFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import nl.deloitte.departuretimes.data.stations.Station;
import nl.deloitte.departuretimes.data.stations.Stations;

public class DataManager {

    private Context mContext;

    public DataManager(Context context){
        mContext = context;
    }

    public List<Station> GetStationList(){

        InputStream stationListStream = mContext.getResources().openRawResource(R.raw.stationlist);
        String stationXmlString = convertStreamToString(stationListStream);

        PojoXml pojoXml = PojoXmlFactory.createPojoXml();

        Stations stations = (Stations) pojoXml.getPojo(stationXmlString, Stations.class);
        List<Station> stationList = stations.getStationList();

        return stationList;
    }

    // Convert the InputStream into a string
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
