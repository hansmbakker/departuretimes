package nl.deloitte.departuretimes.data.stations;

public class Namen
{
    private String Lang;

    private String Middel;

    private String Kort;

    public String getLang ()
    {
        return Lang;
    }

    public void setLang (String Lang)
    {
        this.Lang = Lang;
    }

    public String getMiddel ()
    {
        return Middel;
    }

    public void setMiddel (String Middel)
    {
        this.Middel = Middel;
    }

    public String getKort ()
    {
        return Kort;
    }

    public void setKort (String Kort)
    {
        this.Kort = Kort;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Lang = "+Lang+", Middel = "+Middel+", Kort = "+Kort+"]";
    }
}