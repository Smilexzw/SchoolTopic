package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:5018. 驼峰式匹配  显示英文描述
 * 用户通过次数 220
 * 用户尝试次数 268
 * 通过次数 227
 * 提交次数 469
 * 题目难度 Medium
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 * <p>
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 */
public class _5018 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        List<Boolean> booleans = camelMatch(queries, pattern);
        System.out.println(booleans.toString());
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        int l = pattern.length();
        for (String s : queries) {
            // 判断当前数组中位置的是否为合法
            if (ok(s,pattern)) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

    private static boolean ok(String s, String p) {
        // 分大小写，小写是可以插入无数次，所以分为大小写
        char[] qs = s.toCharArray();
        char[] ps = p.toCharArray();

        int g = 0;
        int len = ps.length;
        for (char c : qs) {
            if (c >= 'a' &&  c <= 'z') {
                if (g == len) {

                } else {
                    if (c == ps[g]) {
                        ++g;
                    }
                }
            } else {
                if (g == len) return false;

                if (c == ps[g]) {
                    ++g;
                } else if(c != ps[g]) {
                    return false;
                }
            }
        }
        return g == len;
    }
}
