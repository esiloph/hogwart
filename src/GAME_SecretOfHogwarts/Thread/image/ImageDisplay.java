package GAME_SecretOfHogwarts.Thread.image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDisplay extends Thread{
    String 이미지경로;
    int 보여주는시간, 폭, 높이;

    public ImageDisplay(String 이미지경로, int 보여주는시간, int 폭, int 높이){
        this.이미지경로 = 이미지경로;
        this.보여주는시간 = 보여주는시간;
        this.폭 = 폭;
        this.높이 = 높이;
    }

    @Override
    public void run() {
        이미지보여주기();
    }

    public void 이미지보여주기() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon(이미지경로);
        Image image = imageIcon.getImage().getScaledInstance(폭, 높이, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImageIcon);

        frame.getContentPane().add(imageLabel);
        frame.pack();
        frame.setLocationRelativeTo(null);  // 중앙에 위치
        frame.setVisible(true);

        try {
            Thread.sleep(보여주는시간);  // 대기 시간
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.dispose();  // 프레임 닫기
    }
}
