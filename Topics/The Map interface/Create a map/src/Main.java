import java.util.*;

class Main {
    private static Map<String, Integer> createStatuses() {
        // implement me
        Map<String, Integer> statuses = new HashMap<>();
        statuses.put("SUCCESS", 0);
        statuses.put("FAIL", 1);
        statuses.put("WARN", 2);

        return statuses;
    }

    // do not change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = createStatuses();
        String status = scanner.next();
        int result = map.getOrDefault(status, -1);
        System.out.println(result);
    }
}