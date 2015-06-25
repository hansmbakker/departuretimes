package nl.deloitte.departuretimes.data.stations;

public class Station
{
    private Synoniemen Synoniemen;

    private Namen Namen;

    private String Land;

    private String Type;

    private String Lat;

    private String Lon;

    private String Code;

    private String UICCode;

    public Synoniemen getSynoniemen ()
    {
        return Synoniemen;
    }

    public void setSynoniemen (Synoniemen Synoniemen)
    {
        this.Synoniemen = Synoniemen;
    }

    public Namen getNamen ()
    {
        return Namen;
    }

    public void setNamen (Namen Namen)
    {
        this.Namen = Namen;
    }

    public String getLand ()
    {
        return Land;
    }

    public void setLand (String Land)
    {
        this.Land = Land;
    }

    public String getType ()
    {
        return Type;
    }

    public void setType (String Type)
    {
        this.Type = Type;
    }

    public String getLat ()
    {
        return Lat;
    }

    public void setLat (String Lat)
    {
        this.Lat = Lat;
    }

    public String getLon ()
    {
        return Lon;
    }

    public void setLon (String Lon)
    {
        this.Lon = Lon;
    }

    public String getCode ()
    {
        return Code;
    }

    public void setCode (String Code)
    {
        this.Code = Code;
    }

    public String getUICCode ()
    {
        return UICCode;
    }

    public void setUICCode (String UICCode)
    {
        this.UICCode = UICCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Synoniemen = "+Synoniemen+", Namen = "+Namen+", Land = "+Land+", Type = "+Type+", Lat = "+Lat+", Lon = "+Lon+", Code = "+Code+", UICCode = "+UICCode+"]";
    }
}