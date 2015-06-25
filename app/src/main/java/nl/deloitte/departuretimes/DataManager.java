package nl.deloitte.departuretimes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import org.pojoxml.core.PojoXml;
import org.pojoxml.core.PojoXmlFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    public void SetEersteVertrektijdInTextView(String stationCode, TextView textView){

        ConnectivityManager connMgr = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            String url = "http://webservices.ns.nl/ns-api-avt?station=" + stationCode;
            // download from the url in the background
            ProcessDownloadParams params = new ProcessDownloadParams(url, textView);
            new DownloadWebpageTask().execute(params);

        } else {
            // display error
            textView.setText("Network not available");
        }

    }

    // This class is used to pass the needed information to the download task
    private class ProcessDownloadParams{
        public ProcessDownloadParams(String url, TextView textView){
            this.url = url;
            this.textView = textView;
        }
        public String url;
        public TextView textView;
    }

    // Uses AsyncTask to create a task away from the main UI thread. This task takes a
    // URL string and uses it to create an HttpUrlConnection. Once the connection
    // has been established, the AsyncTask downloads the contents of the webpage as
    // an InputStream. Finally, the InputStream is converted into a string, which is
    // displayed in the UI by the AsyncTask's onPostExecute method.
    private class DownloadWebpageTask extends AsyncTask<ProcessDownloadParams, Void, String> {

        private ProcessDownloadParams mParams[];

        @Override
        protected String doInBackground(ProcessDownloadParams... processParams) {

            // params comes from the execute() call: params[0] is the url.
            try {
                mParams = processParams;
                return downloadUrl(mParams[0].url);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            mParams[0].textView.setText(result);
        }

    }

    // Given a URL, establishes an HttpUrlConnection and retrieves
    // the web page content as a InputStream, which it returns as
    // a string.
    private String downloadUrl(String location) throws IOException {
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(location);
            String user = mContext.getResources().getString(R.string.user);
            String pass = mContext.getResources().getString(R.string.pass);
            String userpass = user + ":" + pass;

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            String encoded = Base64.encodeToString(userpass.getBytes(), Base64.NO_WRAP);
            conn.setRequestProperty("Authorization", "Basic "+encoded);

            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("HttpURLConnection", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = convertStreamToString(is);//readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
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
