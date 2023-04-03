package se.liu.malha079.lab1;


public class Exercise6
{
    public static void main(String[] args) {
	System.out.println(Exercise6.isPrime(5));
	System.out.println(Exercise6.isPrime(4));
    }
    public static boolean isPrime(int number){
	for (int i = 2; i < number; i++){
	    int rest = number % i;
	    if (rest == 0) {
		return false;
		// number är en jämn multipel av i
	    }
	}
    return true;
    }
}
