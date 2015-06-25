package nl.deloitte.departuretimes.data.actuelevertrektijden;

public class Opmerkingen
{
    private String Opmerking;

    public String getOpmerking ()
    {
        return Opmerking;
    }

    public void setOpmerking (String Opmerking)
    {
        this.Opmerking = Opmerking;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Opmerking = "+Opmerking+"]";
    }
}