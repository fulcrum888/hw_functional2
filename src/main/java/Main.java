import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    static final int MAX_LENGTH = 100;
    static final int MAX_WIDTH = 50;
    static final int MAX_PRICE = 100000;
    static final int DEALS_COUNT = 10;

    public static void main(String[] args) {

        System.out.println("Введите стоимость квадратного метра");
        double price = new Scanner(System.in).nextDouble();

        List<Deal> deals = randomDeals(DEALS_COUNT);

        for (Deal deal : deals) {
            System.out.println(isFair(deal, price, pricePerMeter()));
        }
    }

    public static List<Deal> randomDeals(int dealsCount) {
        List<Deal> deals = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < dealsCount; i++) {
            deals.add(new Deal(random.nextInt(MAX_LENGTH),
                    random.nextInt(MAX_WIDTH), random.nextInt(MAX_PRICE)));
        }
        return deals;
    }

    public static Function<Deal, Double> pricePerMeter() {
        return value -> value.getCost() / (value.getLength() * value.getWidth());
    }

    public static String isFair (Deal deal, double maxPrice, Function<Deal, Double> f) {
        if (maxPrice <= f.apply(deal)) {
            return deal + " Сделка честная";
        } else return deal + " Сделка не честная";
    }
}
