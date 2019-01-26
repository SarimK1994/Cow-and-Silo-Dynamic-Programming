/**************************************************************************
*                                                                         *
*     John B. Student                              CSCI 509               *
*     27 November 2017                             Special Topics         *
*                                                                         *
*     The Cow and the Silo                                                *
*                                                                         *
*     A cow is tied to the side of a circular silo of radius 10 feet      *
*     with a rope of length 20 feet.  What is the area of the region      *
*     in which the cow can graze?                                         *
*                                                                         *
*     Input:  none                                                        *
*     Output: screen                                                      *
*                                                                         *
**************************************************************************/
import java.util.Random;

public class CowAndSilo
{
   public static void main(String[] args)
   {
      int i, Counter=0;
      double p, q, Area;
      Random RNG = new Random();

      for (i = 1; i <= 10000000; i++)
      {
         p = 20.0*RNG.nextDouble() - 10.0;
         q = 20.0*RNG.nextDouble();

         if (p*p + q*q > 100.0 && CowCanReach(p,q))
            Counter++;
         // end if
      }
      // end for

      Area = 400*Counter/10000000.0;
      System.out.println(2*Area + 200*3.14159265);
   }
   // end function main

/**************************************************************************
*                                                                         *
*     This is a user-defined function named CowCanReach. This function    *
*     will return true if the cow can reach the point (p,q) and return    *
*     false otherwise.                                                    *
*                                                                         *
**************************************************************************/
   public static boolean CowCanReach(double p, double q)
   {
      double x, y, distance;

      x = FindTangentPoint(p,q);
      y = Math.sqrt(100.0 - x*x);

      distance = 10*Math.acos(x/10) + Math.sqrt((q-y)*(q-y) + (p-x)*(p-x));

      if (distance <= 20.0)
         return true;
      else
         return false;
      // end if
   }
   // end method CowCanReach

/**************************************************************************
*                                                                         *
*     This is a user-defined function named FindTangentPoint which will   *
*     determine the x-coordinate of the point of tangency on the circle   *
*     x*x + y*y = 100  which connects a tangent line to the point (p,q).  *
*                                                                         *
**************************************************************************/
   public static double FindTangentPoint(double p, double q)
   {
      double a, b, x=0, Fa, Fb, Fx;

      if (q >= 10.0)
      {
         a = 0;
         b = 10;
      }
      else if (p <= 0)
      {
         a = p;
         b = 0;
      }
      else
      {
         a = p;
         b = 10;
      }
      // end if                                

      for (int i = 1; i <= 30; i++)
      {
         x = 0.5*(a + b);
         
         Fa = q*Math.sqrt(100 - a*a) - 100 + p*a;
         Fb = q*Math.sqrt(100 - b*b) - 100 + p*b;
         Fx = q*Math.sqrt(100 - x*x) - 100 + p*x;

         if (Math.abs(Fx) < 0.00000001)
            break;
         else
            if (Fa*Fx < 0.0)
               b = x;
            else
               a = x;
            // end if
         // end if
      }
      // end for
      return x;
   }
   // end method FindTangentPoint
}
// end class CowAndSilo
        
