package GAME_SecretOfHogwarts.Info;

import GAME_SecretOfHogwarts.BattleProcess.MagicSpellList;
import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.GameProcess.GameLogic;
import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.Item.Potion;
import GAME_SecretOfHogwarts.Player.Player;
import GAME_SecretOfHogwarts.GameProcess.Story;

public class Information {
    GameAssist GA=new GameAssist();
    Calculation cal=new Calculation();
    Story story=new Story();
    public void 플레이어정보(Player player, Potion 포션[], Item item){
        int 체력증가 = player.풀체-GameLogic.초기풀체;
        String 체력증가표시=(체력증가 >= 0) ? "+ " + 체력증가 : String.valueOf(체력증가);
        int 마력증가 = player.풀마-GameLogic.초기풀마;
        String 마력증가표시=(마력증가 >= 0) ? "+ " + 마력증가 : String.valueOf(마력증가);
        int 공격력증가 = player.공격력-GameLogic.초기공격력;
        String 공격력증가표시=(공격력증가 >= 0) ? "+ " + 공격력증가 : String.valueOf(공격력증가);
        int 방어력증가 = player.방어력-GameLogic.초기방어력;
        String 방어력증가표시=(방어력증가 >= 0) ? "+ " + 방어력증가 : String.valueOf(방어력증가);
        int 마법공격력증가 = player.마법공격력-GameLogic.초기마법공격력;
        String 마법공격력증가표시=(마법공격력증가 >= 0) ? "+ " + 마법공격력증가 : String.valueOf(마법공격력증가);

        GA.화면클리어();
        GA.절취선(50);
        System.out.println("\n<플레이어 정보> \n"+
                "소속 기숙사: "+player.기숙사이름+"          이름 : " + player.이름 +  "      보유 골드 : " + player.골드+
                "\n체력 : " + player.체력 +" / " +player.풀체+" ("+체력증가표시+")" + " | 마력 : " + player.마력 + " / " + player.풀마+" ("+마력증가표시+")"  + " 경험치 : " + player.경험치 +
                "\n\n<플레이어 능력치> \n" +
                "공격력 : "+player.공격력+" ("+공격력증가표시+") " + " | 방어력 : "+player.방어력+" ("+방어력증가표시+") "+ " | 마법공격력 : "+player.마법공격력+" ("+마법공격력증가표시+")");
        System.out.println("파괴한 호그룩스 갯수 :  " + player.호크룩스파괴갯수);
        GA.절취선(50);
        System.out.println(
                "\n<보유 포션>\n" +
                        포션[0].아이템이름 + " : " + player.플레이어포션[0] + "개 | " + 포션[1].아이템이름 + " : " + player.플레이어포션[1] + "개 | " + 포션[2].아이템이름 + " : " + player.플레이어포션[2] + "개\n");
        GA.절취선(50);
        if (player.무기번호 > 0) {
            System.out.println("당신의 착용하고 있는 무기 :  " + player.기본무기[player.무기번호 - 1]+"\n");
        }
        if (player.방어구번호 > 0) {
            System.out.println("당신의 착용하고 있는 방어구 : " + player.기본방어구[player.방어구번호 - 1]+"\n");
        }
        player.마법주문슬롯보기(player);
        System.out.println("\n< 보유 아이템 >");
        for (int i = 0; i < player.아이템인벤토리.size(); i++) {
            Item 아이템 = player.아이템인벤토리.get(i);
            if(아이템==null){
                GA.정보알림("보유한 아이템이 없습니다.");
            }else {
                GA.절취선(50);
                System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);
            }
        }
        GA.절취선(50);
        System.out.println("\n\n< 착용 아이템 >");
        for (int i = 0; i < player.착용아이템.length; i++) {
            Item 아이템 = player.착용아이템[i];
            if (아이템 != null) {
                GA.절취선(50);
                System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);
            }else{
                GA.절취선(50);
                System.out.println("[" + (i + 1) +"] <비어있음>");
            }
        }
        GA.절취선(50);
        GA.아무키나();
    }
    public void 기본아이템마법(Player player){

        GA.화면클리어();
        GA.게임진행대사("        기본아이템을 선택해주세요~!\n\n" +
                      "               (1) "+player.기본무기[player.무기번호] + "      (2) "+player.기본방어구[player.방어구번호]);
        int 아이템입력=GA.번호입력(":",2);
        GA.화면클리어();
        if(아이템입력==1){
            GA.게임진행대사("                "+player.기본무기[player.무기번호]+" 선택");
            player.무기번호++;
        }else{
            GA.게임진행대사("                "+player.기본방어구[player.방어구번호]+" 선택");
            player.방어구번호++;
        }
        GA.아무키나();
        GA.화면클리어();
        GA.게임진행대사("        기본마법을 선택해주세요~!\n\n" +
                "                     (1) "+ MagicSpellList.인센디오.이름+"       (2) "+MagicSpellList.리덕토.이름);
        int 기본마법입력=GA.번호입력(":",2);
        if(기본마법입력==1){
            GA.게임진행대사("                "+MagicSpellList.인센디오.이름+" 선택");
            player.마법주문슬롯.add(MagicSpellList.인센디오);
        }else{
            GA.게임진행대사("                "+MagicSpellList.리덕토.이름+"  선택");
            player.마법주문슬롯.add(MagicSpellList.리덕토);
        }
        GA.아무키나();
        GA.화면클리어();
    }

    public void 아이템능력업그레이드(Player player){

        GA.화면클리어();
        GA.게임진행대사(               "기본 아이템의 능력을 업그레이드할 수 있습니다.\n" +
                      "                        아이템을 선택해 주십시오!!\n" +
                      "(1) "+player.기본무기[player.무기번호] +"\n"+
                      "               (2) "+player.기본방어구[player.방어구번호]);
        int 아이템입력=GA.번호입력(":",2);
        GA.화면클리어();
        if(아이템입력==1){
            GA.게임진행대사("                "+player.기본무기[player.무기번호]+" 선택");
            if(player.무기번호==4){

            }else{
                player.무기번호++;
            }

        }else{
            GA.게임진행대사("                "+player.기본방어구[player.방어구번호]+" 선택");
            player.방어구번호++;
        }
        GA.아무키나();
        GA.화면클리어();
    }
    public void 아이템정보(Player player) {
        boolean 반복 = true;
        do {
            GA.화면클리어();
            GA.정보알림("              아이템 정보");
            GA.게임진행대사("        다음 행동을 선택하십시오. \n\n" +
                    " (1) 보유한 아이템을 확인한다. \n" +
                    " (2) 착용된 아이템을 확인한다.\n" +
                    " (3) 뒤로가기");

            int 숫자입력 = GA.번호입력(":", 3);
            if (숫자입력 == 1) {
                player.보유아이템목록보기(player);
            } else if (숫자입력 == 2) {
                player.착용아이템목록보기(player);
            } else if (숫자입력 == 3) {
                반복 = false;
            }
        } while (반복);
    }
}