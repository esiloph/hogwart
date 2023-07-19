package GAME_SecretOfHogwarts.GameProcess;

import GAME_SecretOfHogwarts.Thread.Show.Typing;
import GAME_SecretOfHogwarts.Thread.image.ImageDisplay;


public class Story {
    GameAssist GA = new GameAssist();
    public void 게임시작스토리(){
        ImageDisplay StartImage1 =new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\덤블도어와볼드모트.png",7500,800,450);
        StartImage1.start();
        Typing typing1=new Typing("호그와트 마법학교는 한때 전설적인 마법사 알버스 덤블도어 교장 시절 톰 마볼로 리들에 의해서 어둠의 기운이 드리우게 되었다.\n" +
                                      "그의 계획에 의해서 알버스 덤블도어를 살해하는 데 성공하여 호그와트 마법학교의 엄청난 위기를 맞이하게 되었다.\n");
        typing1.start();
        // 일시적인 딜레이
        try {
            Thread.sleep(8500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ImageDisplay StartImage2 =new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\해리포터.png",4500,720,776);
        StartImage2.start();
        Typing typing2=new Typing("하지만 그리핀도르의 위대한 마법사 해리포터와 그 일행들에 의해 이름을 말할 수 없는 그를 쓰러뜨릴 수 있었다.\n");
        typing2.start();
        // 일시적인 딜레이
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ImageDisplay StartImage3 =new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\해리포터20주년.png",6000,1024,576);
        Typing typing3=new Typing("20년의 시간이 흐른 뒤 어둠의 마법사가 돌아왔다는 소문이 들렸다. 호그와트 졸업생들은 이를 지키기 위해 다시 호그와트에 도착했다.\n");
        StartImage3.start();
        typing3.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GA.아무키나();
        GA.중간띄우기();

    }
    public void 액트시작(){
        GA.화면클리어();
        ImageDisplay actstart =new ImageDisplay("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\폐허가 된 호그와트.png",6000,865,517);
        Typing typing4=new Typing("이미 호그와트가 침공당했다. 어둠의 마법사 볼드모트가 부활이 임박한 것 같다. 호크룩스! 호크룩스를 파괴해야해! \n");
        actstart.start();
        typing4.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GA.아무키나();
        GA.게임진행대사("기숙사, 도서관, 필요의방에서 둘러보기하여 호크룩스를 찾아 파괴할 수 있습니다.");
        GA.아무키나();
    }

    public void 액트2시작(){
        GA.화면클리어();
        GA.게임진행대사("액트2 시작");
        GA.아무키나();
    }
    public void 게임클리어(){

    }
}
