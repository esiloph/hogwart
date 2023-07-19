package GAME_SecretOfHogwarts.Thread.Show;

public class Loading {

    public static final int MAX_COUNT = 20;
    public void loadingRun() {
        for (int i = 1; i <= MAX_COUNT; i++) {
            try {
                System.out.print("\r로딩중... " + i * 5 + "% ");
                for(int j = 0; j < 3*i; j++) {
                    System.out.print("■");
                }
                System.out.flush();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
    public void BrowseRun() {
        for (int i = 1; i <= MAX_COUNT; i++) {
            try {
                System.out.print("\r둘러보는 중... " + i * 5 + "% ");
                for(int j = 0; j < 3*i; j++) {
                    System.out.print("■");
                }
                System.out.flush();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
    public void ReadRun() {
        for (int i = 1; i <= MAX_COUNT; i++) {
            try {
                System.out.print("\r독서 중... " + i * 5 + "% ");
                for(int j = 0; j < 3*i; j++) {
                    System.out.print("■");
                }
                System.out.flush();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
