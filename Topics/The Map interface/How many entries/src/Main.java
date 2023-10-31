import java.util.*;

class Main {
    private static void log(Map<Long, String> map) {

        /*Implement method log.Print output depending on size:
        Too many objects if size is greater than 1, Something in the map if it is exactly 1 and There is no objects if
        it is empty*/




        // implement me
        if (map.size() > 1) System.out.println("Too many objects");
        if (map.size() == 1) System.out.println("Something in the map");
        if (map.isEmpty()) System.out.println("There is no objects");
    }

    // do not change the code below
    public static void main(String[] args) {
        String valueBase = "value-";
        Scanner scanner = new Scanner(System.in);

        Map<Long, String> m = new HashMap<>();
        long size = scanner.nextLong();
        for (long i = 0; i < size; ++i) {
            Long key = i;
            String value = valueBase + i;
            m.put(key, value);
        }
        log(Map.copyOf(m));
    }
}