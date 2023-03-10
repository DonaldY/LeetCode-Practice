package interview;

/**
 * @author donald
 * @date 2023/03/02
 */
public class Interview05_02 {

    // Time: O(C), Space: O(C), Faster: 100%
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
