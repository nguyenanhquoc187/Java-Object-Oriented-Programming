package codeptit;
import java.util.Scanner;
public class SapXepDoiChoTrucTiep {
    public static void main(String[] args){
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int []a;
        a=new int [n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int buoc=1;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j]){
                    int tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                }
            }
            System.out.print("Buoc "+(buoc++)+": ");
            for(int x=0;x<n;x++) System.out.print(a[x]+" ");
            System.out.println();
        }
    }
}
