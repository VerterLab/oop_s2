import java.util.ArrayList;
import java.util.List;

public class programQue {
    public static void main(String[] args) {
        Market market = new Market();
        Actor human1 = new Human("hum1");
        Actor human2 = new Human("hum2");
        Actor human3 = new Human("hum3");
        Actor human4 = new Human("hum4");
        Actor human5 = new Human("hum5");
        List<Actor> humans = List.of(human1, human2, human3, human4, human5);

       String orderA = "orderA";
        String orderB = "orderB";
        String orderC = "orderC";
        String orderD = "orderD";
        String orderE = "orderE";

        for (Actor human : humans) {
            market.acceptToMarket(human);
        }
        market.update();
        
        human2.setMakeOrder(true);
        market.takeInQueue(human2);

        human3.setMakeOrder(true);
        market.takeInQueue(human3);

        human1.setMakeOrder(true);
        market.takeInQueue(human1);

        human4.setMakeOrder(true);
        market.takeInQueue(human4);

        market.takeInQueue(human5);

        market.takeOrders(human2, orderA);
        market.takeOrders(human3, orderB);
        market.takeOrders(human1, orderC);
        market.takeOrders(human4, orderD);
        market.takeOrders(human5, orderE);

        market.update();
        // --------------------------------------------------

        for (Actor human : humans) {
            if (human.isMakeOrder)
            market.giveOrders(human);
            market.update();
            // System.out.println();
        }
        market.releaseFromMarket(humans);
        market.update();

    }
}
