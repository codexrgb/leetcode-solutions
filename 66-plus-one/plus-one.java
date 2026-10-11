
class Solution {
    public int[] plusOne(int[] digits) {
        int right = digits.length - 1;

        while (right >= 0 && digits[right] == 9) {
            digits[right] = 0;
            right--;
        }

        if (right >= 0) {
            digits[right]++;
            return digits;
        }

        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;

        return newArr;
    }
}
