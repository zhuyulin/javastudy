import java.util.*;

public class task1 {
    private static final String[] NUMBER = { "零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖" };
    private static final String[] UNIT = { "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟" };

    public static String convert(long OrignNumber ) {
        int count=0;
        StringBuffer sbf = new StringBuffer();
        while (OrignNumber != 0) {
            sbf.insert(0, UNIT[count++]);//插入单位
            sbf.insert(0, NUMBER[(int)(OrignNumber % 10)]);//插入值
            OrignNumber = OrignNumber / 10;
        }
        return sbf.toString().replaceAll("零[仟佰拾]", "零").replaceAll("零+万", "万").replaceAll("零+亿", "亿").replaceAll("亿万", "亿零").replaceAll("零+", "零").replaceAll("零元", "元").replaceAll("零[角分]", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入16位以内的阿拉伯数字：");
        long OrignNumber = sc.nextLong();
        String s = task1.convert(OrignNumber);
        System.out.println("你输入的金额为：【"+ OrignNumber +"】" + "\n"  +"转化后的金额 [" +s.toString()+"]");
    }
}
