import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Market implements QueueBehaviour, MarketBehaviour {

    private List<Actor> actorsInMarket = new ArrayList<>();
    private Map<Actor, String> orders = new LinkedHashMap<>();
    private List<Actor> actorsInQueue = new ArrayList<>();

    @Override
    public void takeInQueue(Actor actor) {
        if (actor.isMakeOrder) {
            actorsInQueue.add(actor);
        }
        // System.out.println(actorsInQueue.size() + " - actorsInQueue.size TakeinQue");
    }

    @Override
    public void takeOrders() {

    }

    public void takeOrders(Actor actor, String order) {
        if (actorsInQueue.contains(actor)) {
            orders.put(actor, order);
            // System.out.println(orders.get(actor) + " ---<< takeOrders");
            // System.out.println(orders.values() + " ---<< values takeOrders");
            actor.isTakeOrder = true;
        }

    }

    @Override
    public void giveOrders() {
        releaseFromQueue();
        ;
    }

    public void giveOrders(Actor actor) {
        if (actor.isTakeOrder) {

            // System.out.println(actorsInQueue.getFirst().name + " actorsInQueue --
            // getFirst.getName ");
            releaseFromQueue(actor);
            System.out.println();
            System.out.println( "actor " +actor + " left in queue");
    
        }

    }

    @Override
    public void releaseFromQueue() {

    }

    public void releaseFromQueue(Actor actor) {
        actorsInQueue.remove(0);
        orders.remove(actor);
    }

    @Override
    public void acceptToMarket(Actor actor) {
        if (!actorsInMarket.contains(actor)) {
            actorsInMarket.add(actor);
        }
        // actors.add(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        actorsInMarket.removeAll(actors);
        System.out.println(actorsInMarket + " Market close");
    }

    public void releaseFromMarket(Actor actor) {
        actorsInMarket.remove(actor);
        System.out.println(actorsInMarket + " Market close");
    }

    @Override
    public void update() {
        System.out.println("Count actors in market: " + actorsInMarket.size() + " - : " + actorsInMarket);
        System.out.println("Count actors in queue: " + orders.size() + " - : " + orders);
        // for (Actor actor : actorsInMarket) {
        //     // System.out.println("order: " + orders.get(actor) + " - : " + orders.values());
        //     // System.out.println("OOorder - : " + orders);
        //     // System.out.println(actor.getName());
        // }
    }

}
