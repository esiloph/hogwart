package GAME_SecretOfHogwarts.Thread.Show;

public class Typing extends Thread{
    private volatile boolean running = true;  // 스레드를 중단시킬 변수를 추가
    public String text;

    public Typing(String text) {
        this.text = text;
    }

    public void terminate() {  // 스레드를 중단시키는 메소드
        running = false;
    }

    @Override
    public void run() {
        try {
            for (char c : text.toCharArray()) {
                if (!running) return;  // running이 false가 되면 run 메소드를 종료
                System.out.print(c);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
