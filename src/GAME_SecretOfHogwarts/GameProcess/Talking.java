package GAME_SecretOfHogwarts.GameProcess;

import java.util.Random;

public class Talking {
    GameAssist GA=new GameAssist();
    public void 도서관대화(){
        String[] 대화={
                "          이 도서관은 위대한 마법사 덤블도어를 기리기 위해 이름을 지었지",
                "          해리포터는 이름을 말할 수 없는 그와 싸우고 다시 돌아오지 않았데",
                "          덤블도어 도서관에서는 마법 관련 책을 읽고 경험치를 쌓을 수 있어",
                "          해리포터는 이름을 말할 수 없는 그를 죽이기 위해 호크룩스를 파괴했어",
                "          뉴트 스캐맨더의 신비한 동물사전은 정말 좋은 책이야!",
                "          론 위즐리는 해리포터의 친구였지!!",
                "          호그와트의 교장이었던 덤블도어 교수, 그는 위대한 마법사였지!"};
        Random random=new Random();
        int 무작위대화=random.nextInt(대화.length);
        String 선택된대화=대화[무작위대화];
        GA.화면클리어();
        GA.게임진행대사("[헬레나 파즐스워스(덤블도어 도서관 사서)]\n\n"+선택된대화);
        GA.아무키나();
    }
}
