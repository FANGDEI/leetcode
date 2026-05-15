package top.dyw.write_exam.kuaishou;

public class K2阿拉伯数字转人民币中文 {

    public static void main(String[] args) {
        System.out.println(numberToChinese(90000009));
    }

    private static final String[] NUMS = new String[]{
        "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"
    };

    private static final String[] UNITS = new String[]{
        "", "拾", "佰", "仟"
    };

    private static final String[] GROUP_UNITS = new String[]{
        "元", "万", "亿"
    };

    public static String numberToChinese(int num) {
        if (num == 0) {
            return "零元";
        }

        StringBuilder sb = new StringBuilder();
        int groupIndex = 0;
        boolean needZero = false;

        while (num > 0) {
            int part = num % 10000;
            if (part != 0) {
                String partStr = convertPart(part);
                if (needZero) {
                    sb.insert(0, "零");
                }

                sb.insert(0, partStr + GROUP_UNITS[groupIndex]);

                needZero = part < 1000;
            } else {
                needZero = false;
            }

            num /= 10000;
            groupIndex++;
        }

//        sb.append("元");
        return sb.toString();
    }

    private static String convertPart(int part) {
        StringBuilder sb = new StringBuilder();
        int unitIndex = 0;
        boolean zeroFlag = false;

        while (part > 0) {
            int digit = part % 10;
            if (digit == 0) {
                if (!zeroFlag && sb.length() > 0) {
                    sb.insert(0, "零");
                }

                zeroFlag = true;
            } else {
                sb.insert(0, NUMS[digit] + UNITS[unitIndex]);
                zeroFlag = false;
            }

            part /= 10;
            unitIndex++;
        }
        return sb.toString();
    }


}
