import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    // Function to find all subsets with a sum equal to target_sum
    public static List<List<Integer>> findSubsets(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsetsHelper(arr, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    // Helper method to find subsets using recursion
    private static void findSubsetsHelper(int[] arr, int targetSum, int index, List<Integer> current, List<List<Integer>> result) {
        // If we've gone through all elements, check if current subset sum matches targetSum
        if (targetSum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == arr.length) {
            return;
        }

        // Include the current element
        if (arr[index] <= targetSum) {
            current.add(arr[index]);
            findSubsetsHelper(arr, targetSum - arr[index], index + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }

        // Exclude the current element
        findSubsetsHelper(arr, targetSum, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 8, 3};
        int targetSum = 7;

        int[] b=new int[]{};

        List<List<Integer>> subsets = findSubsets(arr, targetSum);

        // Print the result
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
