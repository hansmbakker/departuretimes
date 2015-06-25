package nl.deloitte.departuretimes.data.actuelevertrektijden;

public class VertrekkendeTrein
{
    private String VertrekVertraging;

    private String ReisTip;

    private String Vervoerder;

    private String EindBestemming;

    private String VertrekVertragingTekst;

    private VertrekSpoor VertrekSpoor;

    private String RitNummer;

    private String VertrekTijd;

    private String TreinSoort;

    public String getVertrekVertraging ()
    {
        return VertrekVertraging;
    }

    public void setVertrekVertraging (String VertrekVertraging)
    {
        this.VertrekVertraging = VertrekVertraging;
    }

    public String getReisTip ()
    {
        return ReisTip;
    }

    public void setReisTip (String ReisTip)
    {
        this.ReisTip = ReisTip;
    }

    public String getVervoerder ()
    {
        return Vervoerder;
    }

    public void setVervoerder (String Vervoerder)
    {
        this.Vervoerder = Vervoerder;
    }

    public String getEindBestemming ()
    {
        return EindBestemming;
    }

    public void setEindBestemming (String EindBestemming)
    {
        this.EindBestemming = EindBestemming;
    }

    public String getVertrekVertragingTekst ()
    {
        return VertrekVertragingTekst;
    }

    public void setVertrekVertragingTekst (String VertrekVertragingTekst)
    {
        this.VertrekVertragingTekst = VertrekVertragingTekst;
    }

    public VertrekSpoor getVertrekSpoor ()
    {
        return VertrekSpoor;
    }

    public void setVertrekSpoor (VertrekSpoor VertrekSpoor)
    {
        this.VertrekSpoor = VertrekSpoor;
    }

    public String getRitNummer ()
    {
        return RitNummer;
    }

    public void setRitNummer (String RitNummer)
    {
        this.RitNummer = RitNummer;
    }

    public String getVertrekTijd ()
    {
        return VertrekTijd;
    }

    public void setVertrekTijd (String VertrekTijd)
    {
        this.VertrekTijd = VertrekTijd;
    }

    public String getTreinSoort ()
    {
        return TreinSoort;
    }

    public void setTreinSoort (String TreinSoort)
    {
        this.TreinSoort = TreinSoort;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [VertrekVertraging = "+VertrekVertraging+", ReisTip = "+ReisTip+", Vervoerder = "+Vervoerder+", EindBestemming = "+EindBestemming+", VertrekVertragingTekst = "+VertrekVertragingTekst+", VertrekSpoor = "+VertrekSpoor+", RitNummer = "+RitNummer+", VertrekTijd = "+VertrekTijd+", TreinSoort = "+TreinSoort+"]";
    }
}