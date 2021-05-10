public class WordCount extends Thread {

    public static void main(String[] argv) {
        String[] list = {"mary1.txt", "mary2.txt"};
        countFiles(list);
    }

    public static void countFiles(String[] args){
        for (int i = 0; i < args.length; i++) {
            WordCountRunnable wcr = new WordCountRunnable(args[i]);
            Thread t = new Thread(wcr);
            t.start();
        }
    }
}
