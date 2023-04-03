package se.liu.malha079.lab1;

public class Exercise10
{
    public static void main(String[] args) {
	int number = 16777216;
	double decimal = number;
	int interagain = (int)decimal;
	System.out.println(number);
	System.out.println((decimal));
	System.out.println(interagain);
	number = 16777217;
	decimal = number;
	interagain = (int)decimal;
	System.out.println(number);
	System.out.println((decimal));
	System.out.println(interagain);
	int big = 2147483647;
	long bigger = big+1L;
	long bigger2 = (long)big+1;
	System.out.println(big);
	System.out.println(bigger);
	System.out.println(bigger2);

    }
}
