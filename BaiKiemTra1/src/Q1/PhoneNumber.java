package Q1;
public class PhoneNumber implements Comparable<PhoneNumber>{
    private String mavung,noivung;

    public PhoneNumber() {
    }

    public PhoneNumber(String mavung, String noivung) {
        this.mavung = mavung;
        this.noivung = noivung;
    }
    
    
    public String getMavung() {
        return mavung;
    }

    public void setMavung(String mavung) {
        this.mavung = mavung;
    }

    public String getNoivung() {
        return noivung;
    }

    public void setNoivung(String noivung) {
        this.noivung = noivung;
    }

    @Override
    public String toString() {
        return "0" + mavung + "-" + noivung;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        // sap xep tang dan
        return (mavung+noivung).compareTo(o.getMavung()+o.getNoivung());
    }
    
}
