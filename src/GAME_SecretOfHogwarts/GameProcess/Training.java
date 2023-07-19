package GAME_SecretOfHogwarts.GameProcess;

import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpellList;
import GAME_SecretOfHogwarts.Player.Player;
import GAME_SecretOfHogwarts.Thread.Show.Loading;
import GAME_SecretOfHogwarts.Thread.image.ImageDisplay;
import GAME_SecretOfHogwarts.Thread.image.RecycleImage;
import java.util.concurrent.TimeUnit;


public class Training {
    GameAssist GA=new GameAssist();
    Loading loading=new Loading();
    String[] 책 = {"마법이론","표준 마법주문서","마법 부작용", "고대 룬 문자 해석","스네이프의 고급 물약 도감"};
    MagicSpell[] 수련마법={MagicSpellList.아쿠아에릭토,MagicSpellList.엑스펙토페트로눔,MagicSpellList.아바다케다브다};
    String ImagePath="C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\ReadBook.png";
    RecycleImage readImage= new RecycleImage(ImagePath,8000,600,577);
    public void 독서하기(Player player){
        boolean 진행상황 = true;
        do {
            GA.화면클리어();
            GA.게임진행대사("             다음 행동을 선택하십시오. \n\n" +
                          "                       (1) 독서하기        (2) 그만두기 \n");
            int 숫자입력 = GA.번호입력(":", 2);
            if (숫자입력 == 1) {
                독서(player);
                break;
            } else {
                break;
            }
        }while(진행상황);
    }

    public void 독서(Player player){
        GA.화면클리어();
        readImage.run();
        GA.게임진행대사(책[player.도서번호]+"를(을) 책을 읽습니다....!");
        if(player.도서번호==0){
            loading.ReadRun();

            GA.아무키나();
            player.경험치+=5;
            player.공격력+=3;
            GA.게임진행대사(               "         독서를 완료했습니다\n\n" +
                          "                       경험치 5 만큼 얻었다.\n" +
                          "                       공격력 3 만큼 증가했다.");
            player.도서번호++;
            GA.아무키나();
        }else if(player.도서번호==1){
            loading.ReadRun();

            GA.아무키나();
            player.경험치+=5;
            player.마법공격력+=5;
            GA.게임진행대사(               "         독서를 완료했습니다\n" +
                    "                        경험치 5 만큼 얻었다.\n" +
                    "                      마법공격력 5 만큼 증가했다.");
            player.도서번호++;
            GA.아무키나();
        }else if(player.도서번호==2){
            loading.ReadRun();

            GA.아무키나();
            player.경험치+=10;
            player.마법공격력+=1;
            player.방어력+=10;
            GA.게임진행대사(               "         독서를 완료했습니다\n" +
                    "                        경험치 10 만큼 얻었다.\n" +
                    "                      마법공격력 1 만큼 증가했다.\n" +
                    "                        방어력 10 만큼 증가했다.");
            player.도서번호++;

            GA.아무키나();
        } else if (player.도서번호==3) {
            loading.ReadRun();

            GA.아무키나();
            player.경험치+=10;
            player.마법공격력+=10;
            player.방어력+=5;
            GA.게임진행대사(               "         독서를 완료했습니다\n" +
                          "                        경험치 10 만큼 얻었다.\n" +
                          "                      마법공격력 10 만큼 증가했다.\n" +
                          "                        방어력 5 만큼 증가했다.");
            player.도서번호++;
            GA.아무키나();
        } else if (player.도서번호==4) {
            loading.ReadRun();

            GA.아무키나();
            player.마법주문슬롯.add(MagicSpellList.섹튬셈프라);
            GA.게임진행대사(               "         독서를 완료했습니다\n" +
                          "                  책에서 스네이프의 비밀의 메모를 발견했다 !");
            GA.아무키나();
            GA.화면클리어();
            GA.게임진행대사("         이제부터 '섹튬셈프라' 주문을 사용할 수 있습니다!\n");
            GA.아무키나();
            player.도서번호++;
        }else{
            GA.게임진행대사("         더 이상 유익한 책이 없는 것 같다.");
        }
    }
    public void 마법주문수련(Player player){
        boolean 진행상황 = true;
        do {
            GA.화면클리어();
            if(player.레벨>=5) {
                GA.게임진행대사(수련마법[player.마법수련번호].이름 + "을(를) 수련할 수 있습니다.\n" +
                        "                            다음 행동을 선택하십시오. \n\n" +
                        "                       (1) 마법수련하기       (2) 그만두기 \n");
            }else{
                GA.게임진행대사("수련할 수 있는 마법 주문이 없습니다.(레벨 부족)");
                GA.아무키나();
                break;
            }
            int 숫자입력 = GA.번호입력(":", 2);
            if (숫자입력 == 1) {
                마법수련(player);
                break;
            } else {
                break;
            }
        }while(진행상황);

    }
    public void 마법수련(Player player){
        player.필요의방출입횟수--;
         if (player.레벨>=5) {
            마법수련과정(player);
        } else if (player.레벨>=10 && player.마법수련번호>=1) {
             마법수련과정(player);
         } else if (player.레벨>=20 && player.마법수련번호>=2) {
             마법수련과정(player);
         }else{
             GA.게임진행대사("현재 수련할 수 있는 마법 주문이 없습니다.");
         }
    }
    public void 마법수련과정(Player player){
        GA.게임진행대사("       "+수련마법[player.마법수련번호].이름+"을(를) 마법 수련합니다.");
        while(player.수련률<100){
            if(player.체력>10){
                player.수련률+=10;
                int 체력소모=10+10*player.마법수련번호;
                player.체력 -= 체력소모;
                System.out.println("                   체력이" +체력소모+ "소모되었습니다.\n" +
                              "    수련률이 10 올랐습니다. 현재 수련률: "+ player.수련률+"/ 100");

                System.out.println();
                try {
                    TimeUnit.SECONDS.sleep(player.마법수련번호+2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                GA.게임진행대사("체력이 부족합니다. 마법 수련을 중단합니다.");
                break;
            }
        }
        if(player.수련률>=100){
            player.마법주문슬롯.add(수련마법[player.마법수련번호]);
            GA.게임진행대사(수련마법[player.마법수련번호].이름 +"을 습득했습니다. 이제부터 마법을 사용할 수 있습니다.");
            player.마법수련번호++;
        }
    }
}
