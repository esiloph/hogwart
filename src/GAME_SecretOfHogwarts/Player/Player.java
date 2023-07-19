package GAME_SecretOfHogwarts.Player;

import GAME_SecretOfHogwarts.BattleProcess.MagicSpellList;
import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;

import java.util.ArrayList;

public abstract class Player {
    GameAssist GA = new GameAssist();
    public String 기숙사이름, 이름;
    public String 기숙사암호확정;
    public String[] 기숙사암호={"비밀의열쇠","신비한우정","성장과배움의길","오리온","카시오페아","크루시오"};

    public int 풀체, 풀마, 체력, 마력, 경험치, 무기번호, 공격력, 방어력, 마법공격력, 방어구번호, 골드, 남은휴식횟수, 체력포션,레벨, 마력포션, 만능포션, 필요의방출입횟수,마법경험치,도서번호,수련률,마법수련번호;
    public static int 계산용마법공격력;
    public static int 계산용풀마;
    public String[] 기본무기= {"지팡이","빛의 지팡이","유니콘의 힘이 깃는 지팡이","불사조 힘이 깃든 지팡이","떡갈나무 지팡이"};
    public String[] 기본방어구={"망토","가죽 망토","빛나는 망토","영원의 망토","미쓰릴 갑옷"};
    public ArrayList<Item> 아이템인벤토리;
    public ArrayList<MagicSpell> 마법주문슬롯;
    public Item[] 착용아이템;
    public boolean 기숙사출입허용=false;
    public boolean 마볼로곤트의반지파괴=false;
    public boolean 톰리들의일기장파괴=false;
    public boolean 슬리데린의로켓파괴=false;
    public boolean 헬가후플푸프의잔파괴=false;
    public boolean 로웨나래번클로의보관파괴=false;

    public int 호크룩스파괴갯수=0;

    public int[] 플레이어포션;
    public Player(String 이름, int 풀체,int 풀마, int 경험치, int 골드, int 공격력, int 방어력,int 마법공격력){
        this.이름=이름;
        this.레벨=1;
        this.풀체=풀체;
        this.풀마=풀마;
        this.경험치=경험치;
        this.체력=풀체;
        this.마력=풀마;
        this.공격력=공격력;
        this.마법공격력=마법공격력;
        this.계산용마법공격력=마법공격력;
        this.계산용풀마=풀마;
        this.방어력=방어력;
        this.무기번호=0;
        this.방어구번호=0;
        this.골드=골드;
        this.남은휴식횟수=1;
        this.마법경험치=0;
        this.도서번호=0;
        this.마법수련번호=0;
        this.수련률=0;
        this.기숙사암호확정=기숙사암호[(int) (Math.random() *7-1)];
        플레이어포션= new int[]{this.체력포션=0, this.마력포션=0, this.만능포션=0};
        아이템인벤토리=new ArrayList<Item>();
        마법주문슬롯=new ArrayList<MagicSpell>();
        착용아이템 =new Item[3];
        for (int i = 0; i < 착용아이템.length; i++) {
            착용아이템[i] = null;
        }
    }
    public void set마법공격력(int 마법공격력) {
        this.마법공격력 = 마법공격력;
        계산용마법공격력 = 마법공격력;
    }
    public void set풀마(int 풀마) {
        this.풀마 = 풀마;
        계산용풀마 = 풀마;
    }

    public void 마법주문슬롯보기 (Player player){
        System.out.println("<현재 사용가능한 마법>");
        GA.절취선(50);
        for(int i=0;i < 마법주문슬롯.size();i++){
            MagicSpell 마법주문 =마법주문슬롯.get(i);
            System.out.println("["+(i+1)+"] "+마법주문.이름);
        }
    }
    public void 보유아이템목록보기(Player player) {
        if (아이템인벤토리.isEmpty()) {
            System.out.println("보유한 아이템이 없습니다.");
        } else {
            System.out.println("<보유 아이템 목록>");
            for (int i = 0; i < 아이템인벤토리.size(); i++) {
                Item 아이템 = 아이템인벤토리.get(i);
                if (아이템 == null) {
                    GA.절취선(50);
                    System.out.println("[" + (i + 1) + "] [비어있음]");
                } else {
                    GA.절취선(50);
                    System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);
                }
            }
        }
        GA.아무키나();
    }

    public void 착용아이템목록보기(Player player) {
        System.out.println("<착용된 아이템 목록>");
        for (int i = 0; i < 착용아이템.length; i++) {
            if (착용아이템[i] != null) {

                System.out.println((i + 1) + ". " + 착용아이템[i].아이템이름);
            } else {

                System.out.println((i + 1) + ". [비어있음]");
            }
        }
        GA.중간띄우기();
        GA.아무키나();
    }
    public void 보유착용아이템목록보기(Player player) {
        if (아이템인벤토리.isEmpty()) {
            System.out.println("보유한 아이템이 없습니다.");
        } else {
            GA.절취선(50);
            System.out.println("<보유 아이템 목록>");
            for (int i = 0; i < 아이템인벤토리.size(); i++) {
                Item 아이템 = 아이템인벤토리.get(i);
                if (아이템 == null) {
                    GA.절취선(50);
                    System.out.println("[" + (i + 1) + "] [비어있음]");

                } else {
                    GA.절취선(50);
                    System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);

                }
            }
            GA.절취선(50);
        }

        System.out.println("<착용된 아이템 목록>");
        for (int i = 0; i < 착용아이템.length; i++) {
            if (착용아이템[i] != null) {
                GA.절취선(50);
                System.out.println((i + 1) + ". " + 착용아이템[i].아이템이름);
                GA.절취선(50);
            } else {
                GA.절취선(50);
                System.out.println((i + 1) + ". [비어있음]");

            }
        }
    }

    public abstract void 기숙사출입();

    public int 일반공격(){
        return (int) (Math.random()*(공격력+마법공격력+5*무기번호)+레벨);
    }
    public int 방어() {
        return (int) (Math.random()*방어력+3*방어구번호+레벨*2);
    }

}
