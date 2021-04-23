public class Rabbit {

    public static void main(String[] args) {
        int num = (int)(Math.random()*100);
        System.out.println(num);
        System.out.println(breed(num));
    }

    public static int breed(int originalRabbitCount) {

        int endOfTheMonthRabbitCount = 0;
        if ( originalRabbitCount <= 1) {
            endOfTheMonthRabbitCount = originalRabbitCount;
        }
        else {
            endOfTheMonthRabbitCount = originalRabbitCount + (originalRabbitCount / 2 * 5);
        }
        return endOfTheMonthRabbitCount;
    }
}


