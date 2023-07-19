package GAME_SecretOfHogwarts.Thread.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BGM extends Thread {
    public String BGM파일경로;
    public Clip clip;

    public BGM(String BGM파일경로) {
        this.BGM파일경로 = BGM파일경로;
    }

    @Override
    public void run() {
        try {
            File music = new File(BGM파일경로);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(music);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(100);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } catch (InterruptedException ignored) {
            // InterruptedException은 음악 재생을 중지하려는 의도된 동작이므로 무시
        } finally {
            if (clip != null && clip.isOpen()) {
                clip.stop();
            }
        }
    }
    public void stopMusic() {
        this.interrupt();
        if (clip != null) {
            clip.stop();
        }
    }

    public void resumeMusic() {
        if (clip != null && !clip.isRunning()) {
            this.start();
        }
    }

    public void restartMusic() {
        this.stopMusic();
        this.start();
    }
}
