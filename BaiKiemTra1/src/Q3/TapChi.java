package Q3;
public class TapChi extends TaiLieu{
    private int soph, thangph;

    public TapChi() {
    }

    public TapChi( String ma, String tenNxb, int sobanph, int soph, int thangph) {
        super(ma, tenNxb, sobanph);
        this.soph = soph;
        this.thangph = thangph;
    }

    public int getSoph() {
        return soph;
    }

    public void setSoph(int soph) {
        this.soph = soph;
    }

    public int getThangph() {
        return thangph;
    }

    public void setThangph(int thangph) {
        this.thangph = thangph;
    }
    
}
