package basic;

/**
 * @author xuzhangwang
 */
public class Rebot {
    private String name;

    public void sayHi(String  helloSentence) {
        System.out.println(helloSentence + " " + name);
    }

    public String torowHello(String tag) {
        return "hello" + tag;
    }
}
