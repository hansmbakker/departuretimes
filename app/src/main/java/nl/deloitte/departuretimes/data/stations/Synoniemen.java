package nl.deloitte.departuretimes.data.stations;

public class Synoniemen
{
    private String[] Synoniem;

    public String[] getSynoniem ()
    {
        return Synoniem;
    }

    public void setSynoniem (String[] Synoniem)
    {
        this.Synoniem = Synoniem;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Synoniem = "+Synoniem+"]";
    }
}