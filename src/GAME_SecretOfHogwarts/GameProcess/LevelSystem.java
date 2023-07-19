package GAME_SecretOfHogwarts.GameProcess;

import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpellList;
import GAME_SecretOfHogwarts.Player.Player;

public class LevelSystem {
    GameAssist GA=new GameAssist();
    public void LevelUp(Player player) {
        if(player.경험치>= 2*(player.레벨*player.레벨+ player.레벨)){
            player.레벨++;
            player.풀체+=10;
            player.마력+=10;
            player.공격력+=player.레벨;
            player.방어력+=1;
            player.마법공격력+=10;
            player.체력= player.풀체;
            player.마력= player.풀마;
            GA.정보알림(           "        레벨이 올랐습니다!  현재 레벨 : "+player.레벨+"\n\n" +
                      "                       10 만큼 체력과 마력이 올랐습니다.\n" +
                      "                        "+player.레벨+" 만큼 공격력이 올랐습니다.\n" +
                      "                       1 만큼의 방어력이 올랐습니다.\n" +
                      "                       5 만큼의 마법공격력이 올랐습니다.");
            GA.중간띄우기();
            GA.아무키나();
            if(player.레벨%2==0){
            player.필요의방출입횟수++;
            GA.정보알림(               "  필요의 방 출입 횟수가 1 증가했습니다.");
            GA.중간띄우기();
            GA.아무키나();
            }

            if(player.레벨==3){
                player.마법주문슬롯.add(MagicSpellList.스투페파이);
                GA.정보알림(            "이제부터 스투페파이 마법을 사용할 수 있습니다.");
                GA.중간띄우기();
                GA.아무키나();

            }else if(player.레벨==10){
                player.마법주문슬롯.add(MagicSpellList.페트리피쿠스토탈루스);
                GA.정보알림(            "이제부터 페트리피쿠스토탈루스 마법을 사용할 수 있습니다.");
                GA.중간띄우기();
                GA.아무키나();
            }
        }
    }
}
