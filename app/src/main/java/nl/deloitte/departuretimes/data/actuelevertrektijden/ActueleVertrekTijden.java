package nl.deloitte.departuretimes.data.actuelevertrektijden;

import java.util.ArrayList;
import java.util.Arrays;

public class ActueleVertrekTijden
{
    public ArrayList<VertrekkendeTrein> getVertrekkendeTreinenList(){return new ArrayList<VertrekkendeTrein>(Arrays.asList(VertrekkendeTrein));}

    //generated code below

    private VertrekkendeTrein[] VertrekkendeTrein;


    public VertrekkendeTrein[] getVertrekkendeTrein ()
    {
        return VertrekkendeTrein;
    }

    public void setVertrekkendeTrein (VertrekkendeTrein[] VertrekkendeTrein)
    {
        this.VertrekkendeTrein = VertrekkendeTrein;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [VertrekkendeTrein = "+VertrekkendeTrein+"]";
    }
}