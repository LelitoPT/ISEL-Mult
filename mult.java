import java.util.*;
import java.lang.*;
//skype matilde.pato
//System.out.println(Arrays.toString(int_m1));
//System.out.println(Arrays.toString(m2_ints));
//int_m1[0] += (tgt * Math.pow(10,(m1.length() - 1 - i)));
//System.out.println(Arrays.toString(tmp_cal));

public class Mult {
  public static void main (String [] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("M ? ");
    String m1 = in.nextLine();

    int [] int_m1 = new int[m1.length() + 1];
    for (int i = 0; i < m1.length() ; i++) {
      int tgt = (int)m1.charAt(i) - '0';
      int_m1[i+1] = tgt;
      int ten_pow = 1;
      for (int j = m1.length() - 1 ; j > i ; j--) {
        ten_pow *= 10;
      }
      int_m1[0] += tgt * ten_pow;
    }

    System.out.print("m ? ");
    String m2 = in.nextLine();
    int m2_len = m2.length();
    int [] m2_ints = new int[m2_len];

// separar string em int e guardar em array
    int z = m2_len - 1;
    int z2 = 0;
    do {
      int tmp = (int)m2.charAt(z) - '0';
      m2_ints[z2] = tmp;
      z--;
      z2++;
    } while (z >= 0);
    System.out.println("M = " + m1 + ", m = " + m2);

// calculos auxiliares para array
    int [] tmp_cal = new int [m2_len];
    int a = 0;
    do {
      tmp_cal[a] = int_m1[0] * m2_ints[a];
      a++;
    } while (a < m2_len);
/*
P0 = M x m0 = 25811 x 5 = 129055
P1 = M x m1 = 25811 x 2 = 51622
P2 = M x m2 = 25811 x 3 = 77433
*/
    int i = 0;
    int i2 = m2_len - 1;
    do {
      System.out.println(
        "P" + i + " = M x m" + i +  " = " +
        m1 + " x " + m2.charAt(i2) +" = " + tmp_cal[i]);
      i++;
      i2--;
    } while (i < m2_len);
/*
M x n = P0 + P1 x 10 + P2 x 100
*/
    System.out.print("M x n = P0 + ");
    int x = 1;
    do {
      System.out.print(
        "P" + x + " x " +
        (int) Math.pow(10,x)
      );
      tmp_cal[x] *= (int) Math.pow(10,x);

      if (x != m2_len - 1) {
        System.out.print(" + ");
      }
      x++;
    } while (x < m2_len);
/*
M x n = 129055 + 516220 + 7743300 = 8388575
*/
    System.out.println();
    System.out.print("M x n = " + tmp_cal[0] + " + ");
    int y = 1;
    int result = tmp_cal[0];
    do {
      System.out.print(tmp_cal[y]);
      result += tmp_cal[y];
      //.out.println(result);
      if (y != m2_len - 1) {
        System.out.print(" + ");
      }
      else {
        System.out.print(" = " + result);
      }
      y++;
    } while (y < m2_len);
  }
}
