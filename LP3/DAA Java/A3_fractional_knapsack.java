import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class A3_fractional_knapsack {
    public static void fractionalKnapsack() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        Item[] items = new Item[weights.length];
        for (int i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double ratio1 = (double) item1.value / item1.weight;
                double ratio2 = (double) item2.value / item2.weight;
                return Double.compare(ratio2, ratio1);
            }
        });

        double res = 0.0;

        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }
            if (item.weight > capacity) {
                res += capacity * ((double) item.value / item.weight);
                capacity = 0;
            } else {
                res += item.value;
                capacity -= item.weight;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        fractionalKnapsack();
    }
}
