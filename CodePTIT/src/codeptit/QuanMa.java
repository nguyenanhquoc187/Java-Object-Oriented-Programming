package codeptit;
import java.util.*;
public class QuanMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> m = new HashMap<>();
        m.put('a', 1); m.put('b', 2); m.put('c', 3); m.put('d', 4);
        m.put('e', 5); m.put('f', 6); m.put('g', 7); m.put('h', 8);
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0) {
            int ans = Integer.MAX_VALUE;
            int[][] check = new int[9][9];
            for (int i = 1; i <= 8 ;i++) {
                for (int j = 1; j <=8 ; j++) check[i][j] = 0;
            }
            Queue<Data> q = new ArrayDeque<>();
            String[] s = sc.nextLine().split("\\s+");
            int x = m.get(s[0].charAt(0)), y = Integer.parseInt(s[0].charAt(1)+"");
            int u = m.get(s[1].charAt(0)), v = Integer.parseInt(s[1].charAt(1)+"");
            q.add(new Data(x, y, 0) );
            check[x][y] = 1;
            while (q.size() > 0) {
                Data tmp = new Data();
                tmp = q.poll();
                if (tmp.getX() == u && tmp.getY() == v) {
                        ans = Math.min(ans, tmp.getDem());
                } 
                for (int i = 0 ; i < 7 ;i++) {
                    int newX = tmp.getX() + dx[i], newY = tmp.getY() + dy[i];
                    if (newX >= 1 && newX <= 8 && newY >=1 && newY <= 8 && check[newX][newY] == 0) {
                        q.add(new Data(newX, newY, tmp.getDem()+1)  );
                        check[newX][newY] = 1;
                    };
                }
            }
            System.out.println(ans);
        }
    }

}
class Data {
    private int x, y , dem;

    public Data() {
    }

    public Data(int x, int y, int dem) {
        this.x = x;
        this.y = y;
        this.dem = dem;
    }

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}