package GAME_SecretOfHogwarts.GameProcess;

import GAME_SecretOfHogwarts.BattleProcess.Battle;
import GAME_SecretOfHogwarts.BattleProcess.Rest;
import GAME_SecretOfHogwarts.Enemy.Monster;
import GAME_SecretOfHogwarts.Info.DefaultSetting;
import GAME_SecretOfHogwarts.Info.Information;
import GAME_SecretOfHogwarts.Item.*;
import GAME_SecretOfHogwarts.Item.Function.UseItem;
import GAME_SecretOfHogwarts.Player.*;
import GAME_SecretOfHogwarts.Thread.SceneManager;
import GAME_SecretOfHogwarts.Thread.Show.Loading;
import GAME_SecretOfHogwarts.Thread.image.ImageDisplay;
import GAME_SecretOfHogwarts.Thread.image.RecycleImage;

import java.util.Scanner;

public class GameLogic {
     //게임에 필요한 변수 및 객체 선언
    Talking talking=new Talking();
    Loading loading=new Loading();
    Training training=new Training();
    LevelSystem levelSystem=new LevelSystem();
    SceneManager sceneManager=new SceneManager();
    Browse browse=new Browse();
    Item item;
    Place place=new Place();
    Battle battle = new Battle();
    UseItem useItem=new UseItem();
    Information info = new Information();
    GameAssist GA = new GameAssist();
    Scanner sc = new Scanner(System.in);
    Story story = new Story();
    Rest rest = new Rest();
    public int 기숙사입력, 포션입력;
    public static int 초기풀체, 초기풀마, 초기공격력, 초기방어력, 초기마법공격력;
    String 이름;
    RecycleImage loadingImage= new RecycleImage("C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\Loading.png",5700,600,577);

    public boolean 게임진행상황;
    public int 장소 = 0, 액트 = 0;
    public String[] 액트장소 = {"호그와트 지하","숨겨진 저주의 지하실", "비밀의 방","잃어버린 주문의 미궁","리틀 랭글턴의 묘지"};
    public String[] 몬스터 = {"고블린", "고블린", "타란툴라", "픽시", "픽시"};
    public String[] 무작위상황 = {"전투", "전투", "전투", "전투", "휴식"};
    //현재장소
    public boolean 호그와트지하=true;
    public boolean 비밀의방=false;
    public boolean 잃어버린주문의미궁=false;
    public boolean 리틀랭글턴의묘지=false;
    public boolean 바실리스크대결=false;
    public boolean 벨라트릭스대결=false;
    public boolean 볼드모트대결=false;
    public boolean 바실리스크처치=false;
    public boolean 벨라트릭스처치=false;
    public boolean 볼드모트처치=false;

    Player[] players = new Player[4];
    Player 선택된플레이어 = null;

    //게임실행
    public GameLogic() {;}
    public static void main(String[] args) {
        // 게임 초기 설정 실행
        GameLogic GL = new GameLogic();
        GL.게임초기설정();
    }
    public void 게임초기설정() {
        //게어미가 게임에 필요한 설정들을 입력
        sceneManager.씬변경("Start");
        //이름과 기숙사 설정 ---- DS.이름설정, DS.기숙사설정
        DefaultSetting DS = new DefaultSetting();
        GA.게임제목();
        loadingImage.run();
        loading.loadingRun();
        GA.화면클리어();
        story.게임시작스토리();

        loadingImage.run();
        GA.loading.loadingRun();
        GA.화면클리어();

        //기숙사 설정하기
        GA.게임진행대사("         당신의 이름을 말씀해주세요");
        DS.이름설정(이름 = sc.next());
        GA.화면클리어();
        GA.게임진행대사("        출신 기숙사를 설정해주세요.\n\n" +
                " (1) 용감하고 대단한 자들의 '그리핀도르'\n" +
                " (2) 성실하고 진실된 자들의 '후플푸프'\n" +
                " (3) 현명하고 사려 깊은 자들의 '래번클로'\n" +
                " (4) 순수한 혈통을 지닌 자들을 위한 '슬리데린'");

        DS.기숙사설정(기숙사입력 = sc.nextInt());
        players[0]= new GryffindorPlayer(이름,60,80,0,10000,20,2,20);
        players[1]= new HufflepuffPlayer(이름,40,100,0,10000,20,2,20);
        players[2]= new RavenclawPlayer(이름,30,110,0,10000,20,5,30);
        players[3]= new SlytherinPlayer(이름,25,105,0,10000,20,5,30);



        if (기숙사입력>=1 && 기숙사입력 <= players.length){
            선택된플레이어 = players[기숙사입력-1];

            if(선택된플레이어 instanceof GryffindorPlayer){
                GryffindorPlayer gryffindorPlayer=(GryffindorPlayer) 선택된플레이어;
                String GFImagePath="C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\기숙사\\Gryffindor.png";
                ImageDisplay GFImage= new ImageDisplay(GFImagePath,2000,540,600);
                GFImage.start();
                try {
                    Thread.sleep(500); // 일시적인 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (선택된플레이어 instanceof HufflepuffPlayer) {
                HufflepuffPlayer hufflepuffPlayer=(HufflepuffPlayer) 선택된플레이어;
                String HFImagePath="C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\기숙사\\Hufflepuff.png";
                ImageDisplay HFImage= new ImageDisplay(HFImagePath,2000,540,600);
                HFImage.start();
                try {
                    Thread.sleep(500); // 일시적인 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (선택된플레이어 instanceof RavenclawPlayer) {
                RavenclawPlayer ravenclawPlayer=(RavenclawPlayer) 선택된플레이어;
                String RVImagePath="C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\기숙사\\Ravenclaw.png";
                ImageDisplay RVImage= new ImageDisplay(RVImagePath,2000,540,600);
                RVImage.start();
                try {
                    Thread.sleep(500); // 일시적인 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (선택된플레이어 instanceof SlytherinPlayer) {
                SlytherinPlayer slytherinPlayer=(SlytherinPlayer) 선택된플레이어;
                String SLImagePath="C:\\Users\\82102\\Desktop\\과제콘텐츠 저장소\\Image모음\\png 변경완료\\기숙사\\Slytherin.png";
                ImageDisplay SLImage= new ImageDisplay(SLImagePath,2000,540,600);
                SLImage.start();
                try {
                    Thread.sleep(500); // 일시적인 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            GA.게임진행대사(이름 + "님은 '" + 선택된플레이어.기숙사이름 + "' 기숙사를 선택하였습니다.");


            초기풀체=선택된플레이어.풀체; 초기풀마=선택된플레이어.풀마; 초기공격력=선택된플레이어.공격력; 초기방어력=선택된플레이어.방어력; 초기마법공격력=선택된플레이어.마법공격력;

            info.기본아이템마법(선택된플레이어);
            if(선택된플레이어 instanceof GryffindorPlayer||선택된플레이어 instanceof SlytherinPlayer){
                GA.게임진행대사("기숙사 암호는 ' "+선택된플레이어.기숙사암호확정+" ' 이니 꼭 기억하라!!!");
                GA.아무키나();
            }
            게임루프();
        } else {
            게임진행상황 = false;
        }
    }
    public void 게임루프() {
        //게임에서 메인메뉴로 게임의 전반적인 루프를 담당한다.
        boolean 진행상황 = true;
        sceneManager.stopMusic();
        try {
            Thread.sleep(100); // 일시적인 딜레이
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sceneManager.씬변경("Menu");
        do {

            GA.화면클리어();
            GA.정보알림("               호그와트 대연회장");
            GA.게임진행대사("            다음 행동을 선택하십시오. \n\n" +
                    " (1) " + 선택된플레이어.기숙사이름 + " 기숙사로 순간이동 (포션 상점, 아이템 상점) \n" +
                    " (2) 덤블도어 도서관으로 순간이동 (독서하기) \n" +
                    " (3) 필요의 방으로 순간이동 (마법 수련) \n" +
                    " (4) 호그와트 비밀을 파헤친다.(스토리 진행)\n" +
                    " (5) 캐릭터 정보를 확인한다.(플레이어의 체력, 마력 및 기본정보를 확인)\n" +
                    " (6) 아이템 정보를 확인한다.(보유 아이템 및 착용 아이템 정보 확인)\n" +
                    " (7) 아이템 착용 및 해제 \n" +
                    " (8) 게임을 종료한다.");
            int 숫자입력 = GA.번호입력(":", 8);
            if (숫자입력 == 1) {
                선택된플레이어.기숙사출입();
                if (선택된플레이어.기숙사출입허용 == true) {
                    기숙사로이동();
                } else {
                    continue;
                }
            } else if (숫자입력==2) {
                도서관();
            } else if (숫자입력==3) {
                if(선택된플레이어.필요의방출입횟수>0){
                필요의방();}
                else{
                    GA.정보알림("         필요의방을 들어갈 수 없습니다.");
                    GA.아무키나();
                    continue;
                }
            } else if (숫자입력 == 4) {
                호그와트비밀파헤치기();
            } else if (숫자입력 == 5) {
                info.플레이어정보(선택된플레이어, PotionList.포션, item);
            } else if (숫자입력 == 6) {
                info.아이템정보(선택된플레이어);
            } else if (숫자입력==7) {
                useItem.아이템착용해제(선택된플레이어);
            }else if(숫자입력==8)
            {
                게임종료();
            }
        } while (진행상황);
    }
    public void 게임종료(){
        GA.게임진행대사(               "정말 게임을 종료하시겠습니까? \n\n" +
                      "                (1) 예          (2)아니오");
        int 숫자입력=GA.번호입력(":", 2);
        if(숫자입력==1){
            System.exit(0);
        }else{
            게임루프();
        }
    }
    public void 기숙사로이동() {
        boolean 진행상황 = true;
        sceneManager.stopMusic();
        try {
            Thread.sleep(100); // 일시적인 딜레이
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sceneManager.씬변경("기숙사");
        do {
            GA.화면클리어();
            GA.정보알림("               " + 선택된플레이어.기숙사이름 + "기숙사");
            GA.게임진행대사("             다음 행동을 선택하십시오. \n\n" +
                    " (1) 기숙사 침대에서 휴식\n" +
                    " (2) 기숙사 둘러보기\n"+
                    " (3) 호그스미드 포션 상점으로 텔레포트\n" +
                    " (4) 다이애건앨리 아이템 상점으로 텔레포트\n"+
                    " (5) 기숙사 밖으로 나가기\n");

            int 숫자입력 = GA.번호입력(":", 5);
            if (숫자입력 == 1) {
                rest.기숙사휴식(선택된플레이어);
                기숙사로이동();
            } else if (숫자입력 ==2) {
                browse.기숙사둘러보기(선택된플레이어);
            } else if (숫자입력 == 3) {
                sceneManager.stopMusic();
                try {
                    Thread.sleep(100); // 일시적인 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sceneManager.씬변경("호그스미드");
                place.호그스미드포션상점(선택된플레이어);
            } else if (숫자입력 == 4) {
                sceneManager.stopMusic();
                try {
                    Thread.sleep(100); // 일시적인 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sceneManager.씬변경("DiagonAlley");
                place.다이애건앨리아이템상점(선택된플레이어);

            } else if (숫자입력 == 5) {
                break;
            }
        } while (진행상황);
    }

    public void 도서관 () {
        boolean 진행상황 = true;
        sceneManager.stopMusic();
        try {
            Thread.sleep(100); // 일시적인 딜레이
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sceneManager.씬변경("도서관");
        do {
            GA.화면클리어();
            GA.정보알림("                덤블도어 도서관");
            GA.게임진행대사("             다음 행동을 선택하십시오. \n\n" +
                    " (1) 도서관 사서와 대화하기\n" +
                    " (2) 도서관 둘러보기\n" +
                    " (3) 독서하기\n" +
                    " (4) 도서관 나가기" );
            int 숫자입력 = GA.번호입력(":", 4);
            if (숫자입력 == 1) {
                talking.도서관대화();
            } else if (숫자입력 == 2) {
                browse.도서관둘러보기(선택된플레이어);
            } else if (숫자입력 == 3) {
                training.독서하기(선택된플레이어);
                levelSystem.LevelUp(선택된플레이어);
            } else if (숫자입력 == 4) {
                break;
            }
        } while (진행상황);
    }
    public void 필요의방(){
        boolean 진행상황 = true;
        sceneManager.stopMusic();
        try {
            Thread.sleep(100); // 일시적인 딜레이
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sceneManager.씬변경("필요의방");
        do {
            GA.화면클리어();
            GA.정보알림("                    필요의 방");
            GA.게임진행대사("             다음 행동을 선택하십시오. \n\n" +
                    " (1) 새로운 마법주문을 수련한다\n" +
                    " (2) 필요의방 둘러보기\n" +
                    " (3) 필요의방 나가기\n");
            int 숫자입력 = GA.번호입력(":", 3);
            if (숫자입력 == 1) {
                training.마법주문수련(선택된플레이어);
            } else if (숫자입력 == 2) {
                browse.필요의방둘러보기(선택된플레이어);
            } else if (숫자입력 == 3) {
                break;
            }
        } while (진행상황);
    }
    public void 호그와트비밀파헤치기() {
        액트확인();
        //호그와트 지하 & 숨겨진 저주의 지하실
        if(호그와트지하==true&&바실리스크대결==false&&벨라트릭스대결==false&&볼드모트대결==false){
            sceneManager.stopMusic();
            try {
                Thread.sleep(100); // 일시적인 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneManager.씬변경("호그와트지하");
            무작위여행();

            //비밀의방
        }else if (비밀의방==true&&바실리스크대결==false&&벨라트릭스대결==false&&볼드모트대결==false) {
            sceneManager.stopMusic();
            try {
                Thread.sleep(100); // 일시적인 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneManager.씬변경("비밀의방");
            무작위여행();

        }else if(바실리스크대결==true&&벨라트릭스대결==false&&볼드모트대결==false){
            바실리스크();
        }
        else if (잃어버린주문의미궁==true&&바실리스크대결==false&&벨라트릭스대결==false&&볼드모트대결==false) {
            sceneManager.stopMusic();
            try {
                Thread.sleep(100); // 일시적인 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneManager.씬변경("잃어버린주문의미궁");
            무작위여행();
        }else if (장소==4) {

        }

    }
    public void 액트확인() {
        if (선택된플레이어.레벨>=3 && 액트 == 0) {//호그와트 지하
            story.액트시작();
            액트 = 1;
            장소 = 0;

        } else if (선택된플레이어.레벨 >= 10 && 액트 == 1) {//숨겨진 저주의 지하실
            액트 = 2;
            장소 = 1;
            몬스터[0] = "고블린";
            몬스터[1] = "픽시";
            몬스터[2] = "오거";
            몬스터[3] = "오거";
            몬스터[4] = "스네이크";
            무작위상황[3] = "전투";

        }else if(선택된플레이어.레벨>=15&&액트==2){//비밀의방

            호그와트지하=false;
            비밀의방=true;
            액트 = 3;
            장소 = 2;
            몬스터[0] = "애크로맨툴라";
            몬스터[1] = "애크로맨툴라";
            몬스터[2] = "타란툴라";
            몬스터[3] = "스네이크";
            몬스터[4] = "애쉬윈더";

        }else if(선택된플레이어.레벨>=23&&액트==3){//바실리스크와 대결
            액트=4;
            바실리스크대결=true;

        } else if (바실리스크처치==true) {  //잃어버린 주문의 미궁 /중간보스 bullean으로 만들자
            비밀의방=false;
            잃어버린주문의미궁=true;
            액트 = 4;
            장소 = 3;
            몬스터[0] = "디멘터";
            몬스터[1] = "디멘터";
            몬스터[2] = "헝가리 혼테일";
            몬스터[3] = "라이언 드래곤";
            몬스터[4] = "리지백 드래곤";                 //중간보드 만들어야 함
        }else if(선택된플레이어.레벨>=20&&액트==6){
            벨라트릭스대결=true;
        }else if(벨라트릭스처치==true){      //리틀 랭글턴의 묘지
            액트=7;
            장소=4;
            볼드모트대결=true;
        }

    }
    public void 바실리스크(){
        전투(new Monster("바실리스크",1000));

    }
    public void 벨라트릭스(){
        전투(new Monster("벨라트릭스",3000));
    }
    public void 볼드모트(){
        전투(new Monster("볼드모트",5000));
    }

    public void 무작위여행() {
        int random = (int) (Math.random() * 무작위상황.length);
        if (무작위상황[random].equals("전투")) {
            무작위전투();
        } else if (무작위상황[random].equals("휴식")) {
            rest.휴식(선택된플레이어);
            무작위여행();
        }
    }
    public void 무작위전투() {
        GA.화면클리어();
        GA.게임진행대사("    희미하게 무엇인가 보인다. 전투준비를 하자!");
        GA.아무키나();
        전투(new Monster(몬스터[(int) (Math.random() *0.5* 몬스터.length)], 선택된플레이어.경험치));
    }
    public void 전투(Monster monster) {
        if(볼드모트대결==true){
            sceneManager.stopMusic();
            try {
                Thread.sleep(100); // 일시적인 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneManager.씬변경("볼드모트");
        }else if(벨라트릭스대결==true){
            sceneManager.stopMusic();
            try {
                Thread.sleep(100); // 일시적인 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneManager.씬변경("벨라트릭스");
        }else if(바실리스크대결==true){
            sceneManager.stopMusic();
            try {
                Thread.sleep(100); // 일시적인 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneManager.씬변경("바실리스크");
        }

        while (true) {
            GA.화면클리어();
            GA.정보알림("                 "+monster.이름 +
                    "\n                          체력  " + monster.체력 + "  /  " + monster.풀체);
            GA.정보알림("                 "+선택된플레이어.이름 + "" +
                    "\n                          체력  " + 선택된플레이어.체력 + "  /  " + 선택된플레이어.풀체 +
                    "\n                          마력  " + 선택된플레이어.마력 + "  /  " + 선택된플레이어.풀마);
            GA.정보알림("          다음 행동을 선택하세요 \n\n" +
                    " (1) 일반 공격한다. \n" +
                    " (2) 마법주문을 외운다.\n" +
                    " (3) 포션을 사용한다. \n" +
                    " (4) 도망간다.");

            int 숫자입력 = GA.번호입력(":", 4);
            if (숫자입력 == 1) {
                battle.일반공격(선택된플레이어,monster);

                if (선택된플레이어.체력 <= 0) {
                    죽음();
                    break;

                } else if (monster.체력 <= 0) {
                    전투결과(monster);

                    break;
                }
            } else if (숫자입력 == 2) {
                GA.정보알림("        시전할 마법을 선택해주세요");
                for (int i = 0; i < 선택된플레이어.마법주문슬롯.size(); i++) {
                    int 마법번호 = i + 1;
                    System.out.println("(" + 마법번호 + ") " + 선택된플레이어.마법주문슬롯.get(i).이름);
                }
                int 마법입력 = GA.번호입력(":", 선택된플레이어.마법주문슬롯.size());
                if (마법입력 >= 1 && 마법입력<=선택된플레이어.마법주문슬롯.size()) {
                    battle.마법공격(선택된플레이어, monster, 마법입력);

                    if (선택된플레이어.체력 <= 0) {
                        죽음();
                        break;

                    } else if (monster.체력 <= 0) {
                        전투결과(monster);

                        break;
                    }
                }
            } else if (숫자입력 == 3) {
                boolean 포션선택 = false;
                GA.정보알림("사용할 포션을 선택해주세요");
                int i;
                for(i=0;i<PotionList.포션.length;i++){
                    int 포션번호=i+1;
                    System.out.println("("+포션번호+") "+PotionList.포션[i].아이템이름+" ("+PotionList.포션[i].아이템이름+" : " + 선택된플레이어.플레이어포션[i]+"개 남음 )"   );
                }
                포션입력 = GA.번호입력(":", i);
                do {
                    if (포션입력 >= 1 && 포션입력 <= i)
                       useItem.포션사용(선택된플레이어,PotionList.포션, 포션입력);
                    포션선택 = true;
                } while (!포션선택);
            } else if (숫자입력 == 4) {
                도망(선택된플레이어,monster);
            }
        }
    }
    public void 전투결과(Monster monster){
        if(볼드모트대결==true||벨라트릭스대결==true||바실리스크대결==true){
            보스승리();
        }else{
            battle.전투결과(선택된플레이어,monster);
            전투후선택();
        }

    }
    public void 도망(Player player, Monster monster) {
        GA.화면클리어();
        if (볼드모트대결 == true || 바실리스크대결 == true || 벨라트릭스대결 == true) {
            GA.게임진행대사("             도망칠 수 없습니다.");
            GA.아무키나();
        } else {
            if (Math.random() * 10 + 1 <= 3.5) {
                GA.게임진행대사("         " + monster.이름 + "에게서 도망쳤다!");
                GA.아무키나();
                전투후선택();
            } else {
                GA.게임진행대사("         " + monster.이름 + "에게서 도망치지 못했다.");
                int 받은데미지 = monster.일반공격();
                System.out.println(monster.이름 + "에게서 " + 받은데미지 + " 만큼의 데미지를 받았다!");
                player.체력 -= 받은데미지;
                GA.아무키나();
                if (player.체력 <= 0) {
                    죽음();
                }
            }
        }
    }
    public void 보스승리(){
        if(바실리스크대결==true){
            GA.게임진행대사("         바실리스크와 대결에서 승리했습니다.");
            GA.아무키나();
        }
    }
    public void 죽음(){
        GA.화면클리어();
        GA.게임진행대사("아쉽게도 플레이어가 죽음을 맞이했습니다.");
        System.exit(0);
    }
    public void 전투후선택() {
        levelSystem.LevelUp(선택된플레이어);
        if(선택된플레이어.레벨%3==0){
            info.아이템능력업그레이드(선택된플레이어);
        }
        GA.화면클리어();
        GA.정보알림("          현재위치: " +액트장소[장소]+
                "\n\n                          현재 플레이어 상태 " +
                "\n 플레이어 레벨:  " + 선택된플레이어.레벨 +
                "\n 체력 : " + 선택된플레이어.체력 + " / " + 선택된플레이어.풀체 +
                "\n 마력 : " + 선택된플레이어.마력 + " / " + 선택된플레이어.풀마 +
                "\n 골드 : " + 선택된플레이어.골드);
        GA.게임진행대사("          다음 행동을 선택해주세요" +
                "\n(1) 모험을 계속한다" +
                "\n(2) 힐링포션을 사용한다." +
                "\n(3) 이 장소에서 나간다.");

        int 선택입력;
        do {
            선택입력 = GA.번호입력(":", 3);

            if (선택입력 == 1) {
                무작위여행();
            } else if (선택입력 == 2) {
                boolean 포션선택 = false;
                GA.정보알림("사용할 포션을 선택해주세요");
                int i;
                for(i = 0; i < PotionList.포션.length; i++) {
                    int 포션번호 = i + 1;
                    System.out.println("(" + 포션번호 + ") " + PotionList.포션[i].아이템이름 + " (" + PotionList.포션[i].아이템이름 + " : " + 선택된플레이어.플레이어포션[i] + "개 남음 )");
                }

                int 포션입력;
                do {
                    포션입력 = GA.번호입력(":", i);

                    if (포션입력 >= 1 && 포션입력 <= i) {
                        useItem.포션사용(선택된플레이어, PotionList.포션, 포션입력);
                        전투후선택();
                    }

                    포션선택 = true;
                } while (!포션선택);

            } else {
                게임루프();
            }
        } while (선택입력 != 1 && 선택입력 != 2 && 선택입력 != 3);
    }
}