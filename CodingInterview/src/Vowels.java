import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Vowels {

    public static void main(String[] args) throws Exception {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        if (T >= 1 && T <= 20) {
            for (int t = 0; t < T; t++) {
                int n = Integer.parseInt(br.readLine());
                String line = br.readLine();

                int count = 0;
                int vowelCount = 0;

                if (n >= 1 && n <= 100000) {
                    if (line.length() >= 3) {
                        for (int i = 0; i < n - 3; i++) {
                            String subString = line.substring(i);
                            vowelCount = 0;
                            for (int j = 0; j < subString.length(); j++) {
                                if (vowels.contains(subString.charAt(j))) {
                                    vowelCount++;
                                }
                                if (vowelCount == 3) {
                                    count++;
                                    break;
                                }
                            }
                        }
                        System.out.println(count);
                    }
                }
            }
        }

    }
}
