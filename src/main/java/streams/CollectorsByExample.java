package streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Item {
    String name;
    int quantity;
    BigDecimal price;

    public Item(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
public class CollectorsByExample {
    static void groupByNumber() {
        List<Integer> nums = Arrays.asList(1,1,2,2,2,3,3,4,4,4,5,5,5);
        Map<Integer, Long> map = nums.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        System.out.println(map);
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                    Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                    Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQuantity)));

        System.out.println(sum);
        groupByNumber();
    }
}
