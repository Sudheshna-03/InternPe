import java.util.*;
class numberguess
{
   static void guessingnum()
   {
     Scanner sc=new Scanner(System.in);
	 int num=1+(int)(100*Math.random());
	 int l=5;
	 int i,guess;
	 System.out.println("Some Number is chosen between 1 to 100");
	 System.out.println("Guess the Number within 5 trials");
	 for(i=0;i<l;i++)
	 {
	   System.out.println("Guess the Number");
	   guess=sc.nextInt();
	   if(num==guess)
	   {
	     System.out.println("Congratulations!");
		 System.out.println("You have Guessed the Number correctly");
		 if(l==0)
		 {
		    System.out.println("YOU WON 100 POINTS");
			}
		else if(l==1)
		 {
		    System.out.println("YOU WON 90 POINTS");
			}
	    else if(l==2)
		 {
		    System.out.println("YOU WON 80 POINTS");
			}
	    else if(l==3)
		 {
		    System.out.println("YOU WON 70 POINTS");
			}
		else if(l==4)
		{		
			System.out.println("YOU WON 50 POINTS"); 
		}
	   else if(l==5)
		{
			System.out.println("NO POINTS BUT BETTER LUCK NEXT TIME!");
		}
		break;
	   }
	   else if(num>guess && i!=l-1)
	   {
 		   System.out.println("The Number is greater than "+guess);
	   }
	   else if(num<guess && i!=l-1)
	   {
		   System.out.println("The Number is less than "+guess);
	   }
	 }
	 if(i==l)
	 {
		 System.out.println("You have completed "+l+" Trials");
		 System.out.println("The Number is "+num);
	 }
	}
	 public static void main(String args[])
	 {
		 guessingnum();
	 }
}