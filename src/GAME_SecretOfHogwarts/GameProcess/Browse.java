package GAME_SecretOfHogwarts.GameProcess;

import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.Item.ItemList;
import GAME_SecretOfHogwarts.Player.Player;
import GAME_SecretOfHogwarts.Thread.Show.Loading;
import GAME_SecretOfHogwarts.Thread.image.RecycleImage;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Browse {
    GameAssist GA=new GameAssist();
    Random random=new Random();
    Loading loading=new Loading();
    List<Item> 도서관아이템 =new ArrayList<Item>(){
        {
            add(ItemList.젤리빈주머니);
            add(ItemList.모래시계);
            add(ItemList.마법사형광팬);
        }
    };
    List<Item> 기숙사아이템 =new ArrayList<Item>(){
        {
            add(ItemList.뉴트스캐맨더의가면);
            add(ItemList.마법안경);
            add(ItemList.해리포터의비밀일기장);
        }
    };
    RecycleImage ring= new RecycleImage("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\호크룩스마볼로의반지.png",2000,746,494);
    RecycleImage diadem= new RecycleImage("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\호크룩스-래번클로의보관파괴.png",2000,830,473);
    RecycleImage locket= new RecycleImage("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\호크룩스-슬리데린의로켓.png",2000,843,473);

    public void 기숙사둘러보기(Player player){
        int chance= random.nextInt(100)+1;
        GA.게임진행대사("         기숙사 둘러보는 중...");
        loading.BrowseRun();
        if(chance<=5) {
            GA.화면클리어();
            Item 기숙사아이템 = this.기숙사아이템.get(random.nextInt(this.기숙사아이템.size()));
            GA.게임진행대사("      "+기숙사아이템.아이템이름 + "을(를) 획득했습니다!");
            player.아이템인벤토리.add(기숙사아이템);
        }else if(chance<=30) {
            GA.화면클리어();
            GA.게임진행대사("         체력포션을 획득했습니다...!");
            player.플레이어포션[0]++;
        }else if(player.기숙사이름.equals("그리핀도르") && player.레벨>=10 && chance<=5){
            if(player.아이템인벤토리.contains(ItemList.그리핀도르의검)){
                GA.화면클리어();
                GA.게임진행대사("         아무 것도 찾지 못했습니다...");

            }else{
                GA.화면클리어();
                GA.게임진행대사("스페셜 아이템 그리핀도르의 검을 획득했다.");

                player.아이템인벤토리.add(ItemList.그리핀도르의검);
            }
        }else if(player.레벨>=2 && chance<=90) {

            if (player.마볼로곤트의반지파괴 == true) {
                GA.화면클리어();
                GA.게임진행대사("         아무 것도 찾지 못했습니다...");
            } else {
                GA.화면클리어();
                ring.run();
                GA.게임진행대사("      호크룩스 마볼로곤트의 반지를 발견했다.");
                GA.아무키나();
                GA.게임진행대사("      마볼로곤트의 반지를 파괴했다.");
                player.마볼로곤트의반지파괴 = true;
                player.호크룩스파괴갯수++;
            }
        }else{
            GA.화면클리어();
            GA.게임진행대사("         아무 것도 찾지 못했습니다...");
        }
        GA.아무키나();
    }
    public void 도서관둘러보기(Player player){
        int chance= random.nextInt(100)+1;
        GA.게임진행대사("         도서관 둘러보는 중...");
        loading.BrowseRun();
        if(chance<=10) {
            GA.화면클리어();
            Item 도서관아이템 = this.도서관아이템.get(random.nextInt(this.도서관아이템.size()));
            GA.게임진행대사("      "+도서관아이템.아이템이름 + "을(를) 획득했습니다!");
            player.아이템인벤토리.add(도서관아이템);
        }else if(chance<=30) {
            GA.화면클리어();
            GA.게임진행대사("         체력포션을 획득했습니다...!");
            player.플레이어포션[0]++;
        } else if(player.레벨>=10 && chance<=90 && player.마볼로곤트의반지파괴==true) {
                if (player.로웨나래번클로의보관파괴 == true) {
                    GA.화면클리어();
                    GA.게임진행대사("         아무 것도 찾지 못했습니다...");
                } else {
                    GA.화면클리어();
                    diadem.run();
                    GA.게임진행대사("   호크룩스 로웨나 래번클로의 보관을 발견했다.");
                    GA.아무키나();
                    GA.게임진행대사("   로웨나 래번클로의 보관을 파괴했다.");
                    player.로웨나래번클로의보관파괴 = true;
                    player.호크룩스파괴갯수++;
                }
        }else {
            GA.화면클리어();
            GA.게임진행대사("         아무 것도 찾지 못했습니다...");
        }
        GA.아무키나();
    }
    public void 필요의방둘러보기(Player player){
        int chance= random.nextInt(100)+1;
        GA.게임진행대사("         필요의방 둘러보는 중...");
        loading.BrowseRun();
        if(chance<=10) {
            GA.화면클리어();
            Item 도서관아이템 = this.도서관아이템.get(random.nextInt(this.도서관아이템.size()));
            GA.게임진행대사("      "+도서관아이템.아이템이름 + "을(를) 획득했습니다!");
            player.아이템인벤토리.add(도서관아이템);
        }else if(chance<=20) {
            GA.화면클리어();
            GA.게임진행대사("         마력포션을 획득했습니다...!");
            player.플레이어포션[1]++;
        } else if(chance<=10){
            GA.화면클리어();
            GA.게임진행대사("         만능포션을 획득했습니다...!");
            player.플레이어포션[2]++;
        } else if(player.레벨>=15 && chance<=90 && player.마볼로곤트의반지파괴==true) {
            if (player.슬리데린의로켓파괴 == true) {
                GA.화면클리어();
                GA.게임진행대사("         아무 것도 찾지 못했습니다...");
            } else {
                GA.화면클리어();
                locket.run();
                GA.게임진행대사("   호크룩스 슬리데린의 로켓을 발견했다.");
                GA.아무키나();
                GA.게임진행대사("        슬리데린의 로켓을 파괴했다.");
                player.슬리데린의로켓파괴 = true;
                player.호크룩스파괴갯수++;
            }
        }else {
            GA.화면클리어();
            GA.게임진행대사("         아무 것도 찾지 못했습니다...");
        }
        GA.아무키나();
    }

}
