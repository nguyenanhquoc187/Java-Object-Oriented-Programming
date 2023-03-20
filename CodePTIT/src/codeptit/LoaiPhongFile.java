package codeptit;
import java.util.*;
import java.io.File;
import java.io.IOException;
public class LoaiPhongFile {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }

}
class LoaiPhong implements Comparable<LoaiPhong>{

   
    private String symbol,typeRoom,pricePerDay, serviceCharge;
    public LoaiPhong(String s) {
        String[] a = s.split(" ");
        symbol = a[0];
        typeRoom = a[1];
        pricePerDay = a[2];
        serviceCharge = a[3];
    }
    
    @Override
    public String toString() {
        System.out.print(symbol + " " + typeRoom + " " + pricePerDay + " " + serviceCharge );
        return "";
    }

    public String getTypeRoom() {
        return typeRoom;
    }
    
    @Override 
    public int compareTo(LoaiPhong o) {
        return this.typeRoom.compareTo(o.getTypeRoom() );
    }
}
