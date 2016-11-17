import java.util.*;
import java.lang.*;
//skype matilde.pato
public class Mult {
  public static void main (String [] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("M ? ");
    String m1 = in.nextLine();
    int int_m1 = Integer.parseInt(m1);

    System.out.print("m ? ");
    String m2 = in.nextLine();
    int int_m2 = Integer.parseInt(m2);
// mudar nome de last_n
    int last_n = m2.length();

    int [] m2_ints = new int[last_n];
// separar string em int e guardar em array
    int z = last_n - 1;
    int z2 = 0;
    do {
      int tmp = Character.getNumericValue(m2.charAt(z));
      m2_ints[z2] = tmp;
      z--;
      z2++;
    } while (z >= 0);
    //System.out.println(Arrays.toString(m2_ints));
    System.out.println("M = " + m1 + ", m = " + m2);

    int [] tmp_cal = new int [last_n];
// calculos auxiliares para array
    int a = 0;
    do {
      tmp_cal[a] = int_m1 * m2_ints[a];
      a++;
    } while (a < last_n);
    //System.out.println(Arrays.toString(tmp_cal));
/*
P0 = M x m0 = 25811 x 5 = 129055
P1 = M x m1 = 25811 x 2 = 51622
P2 = M x m2 = 25811 x 3 = 77433
*/
    int i = 0;
    int i2 = last_n - 1;
    do {
      System.out.println(
        "P" + i + " = M x m" + i +  " = " +
        m1 + " x " + m2.charAt(i2) +
        " = " + tmp_cal[i]
      );
      i++;
      i2--;
    } while (i < last_n);
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

      if (x != last_n - 1) {
        System.out.print(" ");
      }
      x++;
    } while (x < last_n);
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
      if (y != last_n - 1) {
        System.out.print(" + ");
      }
      else {
        System.out.print(" = " + result);
      }
      y++;
    } while (y < last_n);
  }
}
