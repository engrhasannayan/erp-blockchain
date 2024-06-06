import java.util.HashMap;

/**
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer.



 Example 1:

 Input: s = "III"
 Output: 3
 Explanation: III = 3.
 **/

public class Solution {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] stringArray = s.toCharArray();
        int sum = map.get(stringArray[0]);
        for (int i = 1; i < stringArray.length; i++) {
            if (map.get(stringArray[i]) > map.get(stringArray[i-1])){
                sum += map.get(stringArray[i]) - 2*map.get(stringArray[i-1]);
            }
            else {
                sum += map.get(stringArray[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Example decimal value
        int decimalValue = 8094184;

        // Convert the decimal value to a 32-bit binary string
        String binaryString = String.format("%32s", Integer.toBinaryString(decimalValue)).replace(' ', '0');

        // Ensure the binary string is exactly 32 bits long
        binaryString = binaryString.substring(binaryString.length() - 32);

        System.out.println("32-bit binary representation: " + binaryString);

        // Split the binary string into two 16-bit parts
        String first16Bits = binaryString.substring(0, 16);
        String second16Bits = binaryString.substring(16);

        System.out.println("First 16 bits: " + first16Bits);
        System.out.println("Second 16 bits: " + second16Bits);

        // Convert each 16-bit part back to decimal
        int first16BitsDecimal = Integer.parseInt(first16Bits, 2);
        int second16BitsDecimal = Integer.parseInt(second16Bits, 2);

        System.out.println("First 16 bits in decimal: " + first16BitsDecimal);
        System.out.println("Second 16 bits in decimal: " + second16BitsDecimal);
    }
}
