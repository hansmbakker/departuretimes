package nl.deloitte.departuretimes.data.actuelevertrektijden;

public class VertrekSpoor
{
    private String content;

    private String wijziging;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getWijziging ()
    {
        return wijziging;
    }

    public void setWijziging (String wijziging)
    {
        this.wijziging = wijziging;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", wijziging = "+wijziging+"]";
    }
}