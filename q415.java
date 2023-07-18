class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder num1SB = new StringBuilder(num1);
        num1SB = num1SB.reverse();
        StringBuilder num2SB = new StringBuilder(num2);
        num2SB = num2SB.reverse();

        for (int i = 0, j = 0; i < num1SB.length() || j < num2SB.length(); i++, j++) {
            int num1Int = 0, num2Int = 0;

            if (i >= num1SB.length()) {
                num1Int = 0;
                num2Int = Integer.parseInt(String.valueOf(num2SB.charAt(j)));
            } else if (j >= num2SB.length()) {
                num1Int = Integer.parseInt(String.valueOf(num1SB.charAt(i)));
                num2Int = 0;
            } else {
                num1Int = Integer.parseInt(String.valueOf(num1SB.charAt(i)));
                num2Int = Integer.parseInt(String.valueOf(num2SB.charAt(j)));
            }

            if (carry == 0) {
                if (num1Int + num2Int <= 9) {
                    res.append(num1Int + num2Int + "");
                } else if (num1Int + num2Int > 9) {
                    res.append(((num1Int + num2Int) % 10) + "");
                    carry = 1;
                }
            } else if (carry == 1) {
                if (num1Int + num2Int + carry <= 9) {
                    res.append(num1Int + num2Int + carry + "");
                    carry = 0;
                } else if (num1Int + num2Int + carry > 9) {
                    res.append(((num1Int + num2Int + carry) % 10) + "");
                }
            }
        }

        if (carry == 1) {
            res.append("1");
        }

        return String.valueOf(res.reverse());
    }
}
