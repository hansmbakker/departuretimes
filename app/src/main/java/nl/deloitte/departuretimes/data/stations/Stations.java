package nl.deloitte.departuretimes.data.stations;

import java.util.ArrayList;
import java.util.Arrays;

public class Stations
{
    public ArrayList<Station> getStationList(){return new ArrayList<Station>(Arrays.asList(Station));}

    //generated code below

    private Station[] Station;

    public Station[] getStation ()
    {
        return Station;
    }

    public void setStation (Station[] Stations)
    {
        this.Station = Stations;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Station = "+Station+"]";
    }
}