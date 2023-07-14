package primeNumber;

public class isPrime {

    private  int number;

    public isPrime(int number) {
        this.number = number;
    }

    public isPrime() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isNumberPrime(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }



   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input integer positive number: ");
            int n = scanner.nextInt();
            //boolean isPrime = true;
            boolean isPrime = isNumberPrime(n);
            System.out.println("n =  " + n);

            if (isPrime) {
                System.out.println("Number " + n + " is prime.");
            } else {
                System.out.println("Number " + n + " is NOT prime.");
            }
        }
    }
*/
}
