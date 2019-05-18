package offer;

/**
 * 题目描述
 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 正确的句子应该是“I am a student.”。
 Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author: xuzhangwang
 */
public class 反转单词顺序列 {
    public static void main(String[] args) {
        String str = "student. a am I";
        String res = ReverseSentence(str);
        System.out.println(res);
    }

    public static String ReverseSentence(String str) {
        if (str == "") return str;
        String[] s = str.split(" ");
        String res = "";
        for (int i = s.length - 1; i >= 0; i--) {
            if (i == 0) {
                res += s[i];
            } else {
                res += s[i];
                res += " ";
            }
        }
        return res;
    }

    private static void resver(String[] s, int i, int j) {
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    private static void swap(String[] s, int i, int j) {
        String t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
