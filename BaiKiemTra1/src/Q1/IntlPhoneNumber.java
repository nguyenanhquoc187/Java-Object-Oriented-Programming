package Q1;
public class IntlPhoneNumber extends PhoneNumber{
    private String maquocgia;

    public IntlPhoneNumber(String maquocgia, String mavung, String noivung) {
        super(mavung, noivung);
        this.maquocgia = maquocgia;
    }

    public String getMaquocgia() {
        return maquocgia;
    }

    public void setMaquocgia(String maquocgia) {
        this.maquocgia = maquocgia;
    }

    @Override
    public String toString() {
        return maquocgia + "-" + super.toString().substring(1) ; 
    }
    
    
}
