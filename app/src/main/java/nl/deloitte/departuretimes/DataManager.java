package nl.deloitte.departuretimes;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static List<Station> GetStationList(){
        Station amsterdamCs = new Station() {{
            Name = "Amsterdam Centraal";
            Code = "ASD";
            Type = "megastation";
        }};

        Station amsterdamMuiderpoort = new Station() {{
            Name = "Amsterdam Muiderpoort";
            Code = "ASDM";
            Type = "stoptreinstation";
        }};

        Station amsterdamAmstel = new Station() {{
            Name = "Amsterdam Amstel";
            Code = "ASA";
            Type = "intercitystation";
        }};

        List<Station> stationList = new ArrayList<Station>();
        stationList.add(amsterdamCs);
        stationList.add(amsterdamMuiderpoort);
        stationList.add(amsterdamAmstel);

        return stationList;
    }
}
