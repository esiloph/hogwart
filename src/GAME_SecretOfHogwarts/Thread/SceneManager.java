package GAME_SecretOfHogwarts.Thread;

import GAME_SecretOfHogwarts.Thread.Sound.BGM;
import GAME_SecretOfHogwarts.Thread.image.ImageDisplay;

public class SceneManager {
    public BGM currentBGM;
    public ImageDisplay currentImageDisplay;

    public void 씬변경(String scene){
        if (currentBGM != null) {
            currentBGM.stopMusic();
        }
        if (currentImageDisplay != null) {
            currentImageDisplay.interrupt();
        }
        switch (scene) {
            case "Start":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\HogwartBGM.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\HogwartImage.png", 3000, 800, 600);  // 게임시작 이미지
                break;

            case "Menu":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\theGreatHall.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\HogwartGreatHall.png", 2000, 800, 600);  // 메뉴 이미지
                break;
                
            case "DiagonAlley":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\DiagonAlley.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\DiagonAlley.png", 2000, 1000, 438);  // 다이아건엘리 이미지
                break;

            case "기숙사":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\TheDuelingClub.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\기숙사.png", 2000, 900, 600);  // 기숙사 이미지
                break;

            case "도서관":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\도서관.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\호그와트 도서관.png", 2000, 900, 600);  //
                break;

            case "필요의방":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\필요의방.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\필요의방.png", 2000, 887, 665);  //
                break;

            case "독서":
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\ReadBook.png", 8000, 600, 577);  //
                break;

            case "호그스미드":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\Aunt-Marges-Waltz.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\호그스미드.png", 2000, 850, 478);  //
                break;

            case "호그와트지하":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\호그와트의비밀.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\지하감옥.png", 2000, 850, 478);  //
                break;

            case "비밀의방":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\호그와트의비밀.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\비밀의방_잃어버린미궁.wav", 2000, 850, 478);  //
                break;

            case "잃어버린주문의미궁":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\호그와트의비밀.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\비밀의방_잃어버린미궁.wav", 2000, 850, 478);  //
                break;

            case "바실리스크":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\중간보스.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\바실리스크.png", 2000, 800, 819);  //
                break;

                case "벨라트릭스":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\중간보스.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\벨라트릭스.png", 2000, 700, 924);  //
                break;

                case "볼드모트":
                currentBGM = new BGM("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\wave변환사운드\\중간보스.wav");
                currentImageDisplay = new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\볼드모트.png", 2000, 640, 960);  //
                break;

            default:
                throw new IllegalArgumentException("씬 변경 실패: " + scene);
        }

        currentBGM.start();
        currentImageDisplay.start();
    }

    public void stopMusic() {
        if (currentBGM != null) {
            currentBGM.stopMusic();
        }
    }

    public void resumeMusic() {
        if (currentBGM != null) {
            currentBGM.resumeMusic();
        }
    }
}
