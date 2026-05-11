package top.dyw.write_exam.kuaishou;

public class K2阿拉伯数字转人民币中文 {

    public static void main(String[] args) {
        System.out.println(numberToChinese(101));
    }

    // 中文数字
    private static final String[] NUMS = {
            "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"
    };

    // 小单位
    private static final String[] UNITS = {
            "", "拾", "佰", "仟"
    };

    //大单位
    private static final String[] GROUP_UNITS = {
            "", "万", "亿"
    };

    public static String numberToChinese(int num) {
        if (num == 0) {
            return "零元整";
        }

        StringBuilder sb = new StringBuilder();
        int groupIndex = 0;
        boolean needZero = false;

        while(num > 0) {
            //每次取4位
            int part = num % 10000;
            if (part != 0) {
                String partStr = convertPart(part);

                if (needZero) {
                    sb.insert(0, "零");
                }

                sb.insert(0, partStr + GROUP_UNITS[groupIndex]);

                // 当前组不足4位
                needZero = part < 1000;
            } else {
                needZero = false;
            }

            num /= 10000;
            groupIndex++;
        }
        sb.append("元");
        return sb.toString();
    }

    /**
     * 转换0～9999
     */
    private static String convertPart(int num) {
        StringBuilder sb = new StringBuilder();

        int unitIndex = 0;
        boolean zeroFlag = false;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                if (!zeroFlag && sb.length() > 0) {
                    sb.insert(0, "零");
                }

                zeroFlag = true;
            } else {
                sb.insert(0, NUMS[digit] + UNITS[unitIndex]);
                zeroFlag = false;
            }

            unitIndex++;
            num/=10;
        }
        return sb.toString();
    }
}
