import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
  public static int uniqueWolfs(List<Integer> arr) {
    // Gelistirmeyi bu alana yapiniz
    int minLen = Integer.MAX_VALUE;
    int n = arr.size();
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr.get(i) == arr.get(j)) {
          minLen = Math.min(minLen, i - j + 1);
        }
      }
    }
    if (minLen == Integer.MAX_VALUE) {
      return -1;
    }

    return minLen;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
        .collect(toList());
    int result = Result.uniqueWolfs(arr);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedReader.close();
    bufferedWriter.close();
  }
}