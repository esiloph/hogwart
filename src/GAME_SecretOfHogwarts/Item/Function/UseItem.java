package GAME_SecretOfHogwarts.Item.Function;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Item.*;
import GAME_SecretOfHogwarts.Player.Player;

public class UseItem {
    GameAssist GA = new GameAssist();
    public String 이름;
    String[] 플레이어회복 = {"체력", "마력", "체력 및 마력"};
    public void 포션사용(Player player, HealingPotion 포션[], int 포션입력) {
        if (player.플레이어포션[포션입력 - 1] > 0 && (player.체력 < player.풀체 || player.마력<player.풀마)) {
            GA.게임진행대사("                "+포션[포션입력 - 1].아이템이름 + "을 사용하겠습니까? (" + player.플레이어포션[포션입력 - 1] + "개 남음)\n" +
                    "(1) 예\n" +
                    "(2) 아니오 ");

            int 숫자입력 = GA.번호입력(":", 3);
            if (숫자입력 == 1) {
                player.체력 += 포션[포션입력 - 1].체력회복;
                player.마력 += 포션[포션입력 - 1].마력회복;
                if (player.체력 >= player.풀체) {
                    player.체력 = player.풀체;
                    GA.아무키나();
                }
                GA.화면클리어();
                GA.게임진행대사(포션[포션입력 - 1].아이템이름 + "을 사용했다.\n"
                            +" 체력 "+ 포션[포션입력-1].체력회복+"만큼 회복했다." +
                           "\n 마력 "+ 포션[포션입력-1].마력회복+"만큼 회복했다.");
                GA.아무키나();
            }
        } else if (player.플레이어포션[0] == 0) {
            GA.게임진행대사("현재 가지고 있는 " + 포션[포션입력 - 1].아이템이름 + "이 없습니다.");
            GA.아무키나();
        } else {
            GA.게임진행대사("이미 " + 플레이어회복[포션입력 - 1] + "이 넘칩니다.!");
            GA.아무키나();
        }
    }
    public void 아이템착용해제(Player player) {
        GA.화면클리어();
        GA.정보알림("         아이템 착용 및 해제");
        GA.게임진행대사("            다음 행동을 선택하십시오. \n\n" +
                "  (1) 아이템 착용 \n" +
                "  (2) 아이템 해제\n" +
                "  (3) 뒤로가기\n");

        int 숫자입력 = GA.번호입력(":", 3);
        if (숫자입력 == 1) {
            player.보유착용아이템목록보기(player);
            GA.아무키나();
            System.out.println("\n보유아이템에서 착용할 아이템을 선택해주세요\n");

            for (int i = 0; i < player.아이템인벤토리.size(); i++) {
                Item 착용할아이템 = player.아이템인벤토리.get(i);
                int 선택보유아이템 = GA.번호입력(":", player.아이템인벤토리.size() + 1);
                if (선택보유아이템 == i + 1) {
                    boolean 착용완료 = false;
                    for (int j = 0; j < player.착용아이템.length; j++) {
                        if (player.착용아이템[j] == null) {
                            player.착용아이템[j] = player.아이템인벤토리.get(i);
                            착용완료 = true;
                            player.아이템인벤토리.remove(i);
                            아이템착용(player, 착용할아이템);
                            GA.아무키나();
                            break;
                        }
                    }
                    if (!착용완료) {
                        System.out.println("더 이상 착용할 수 없습니다.");
                        GA.아무키나();
                    }
                }
            }
        } else if (숫자입력 == 2) {
            GA.정보알림("               (2) 아이템 해제");
            player.착용아이템목록보기(player);
            GA.절취선(30);
            System.out.println(" 해제할 아이템을 선택해주세요");
            int 선택해제아이템 = GA.번호입력(":", player.착용아이템.length + 1);
            if (선택해제아이템 > 0 && 선택해제아이템 <= player.착용아이템.length) {
                int 인덱스 = 선택해제아이템 - 1;
                Item 해제아이템 = player.착용아이템[인덱스];
                player.착용아이템[인덱스] = null;
                player.아이템인벤토리.add(해제아이템);
                아이템해제(player, 해제아이템);
                GA.화면클리어();
                GA.게임진행대사(해제아이템.아이템이름 + "을(를) 해제했다.");
                GA.아무키나();
            }
        }
    }
    public void 아이템착용(Player player,Item item) {
        if (item instanceof NormalItem) {
            NormalItem normalItem = (NormalItem) item;
            player.풀체 += normalItem.체력증가;
            player.풀마 += normalItem.마력증가;
            item.능력치향상정보();


        } else if (item instanceof RareItem) {
            RareItem rareItem = (RareItem) item;
            player.풀체 += rareItem.체력증가;
            player.풀마 += rareItem.마력증가;
            player.공격력 += rareItem.공격력증가;
            player.방어력 += rareItem.방어력증가;
            item.능력치향상정보();

        } else if (item instanceof UniqueItem) {
            if (item instanceof SpecialItem) {
                SpecialItem specialItem = (SpecialItem) item;
                if (player.기숙사이름.equals(specialItem.적용기숙사)) {
                    player.풀체 *= specialItem.체력증가;
                    player.풀마 *= specialItem.마력증가;
                    player.공격력 *= specialItem.공격력증가;
                    player.방어력 *= specialItem.방어력증가;
                    player.마법공격력 *= specialItem.마법공격력증가;
                    item.능력치향상정보();
                    ((SpecialItem) item).마법주문추가(player);
                }
            } else {
                UniqueItem uniqueItem = (UniqueItem) item;
                player.풀체 += uniqueItem.체력증가;
                player.풀마 += uniqueItem.마력증가;
                player.공격력 += uniqueItem.공격력증가;
                player.방어력 += uniqueItem.방어력증가;
                player.마법공격력 += uniqueItem.마법공격력증가;
                item.능력치향상정보();
            }
        }
    }

    public void 아이템해제(Player player,Item item){
        if (item instanceof NormalItem) {
            NormalItem normalItem = (NormalItem) item;
            player.풀체 -= normalItem.체력증가;
            player.풀마 -= normalItem.마력증가;

        } else if (item instanceof RareItem) {
            RareItem rareItem = (RareItem) item;
            player.풀체 -= rareItem.체력증가;
            player.풀마 -= rareItem.마력증가;
            player.공격력 -= rareItem.공격력증가;
            player.방어력 -= rareItem.방어력증가;

        }else if (item instanceof UniqueItem) {
            if (item instanceof SpecialItem) {
                SpecialItem specialItem = (SpecialItem) item;
                if (player.기숙사이름.equals(specialItem.적용기숙사)) {
                    player.풀체 /= specialItem.체력증가;
                    player.풀마 /= specialItem.마력증가;
                    player.공격력 /= specialItem.공격력증가;
                    player.방어력 /= specialItem.방어력증가;
                    player.마법공격력 /= specialItem.마법공격력증가;
                ((SpecialItem) item).마법주문제거(player);
                }
            } else {
                UniqueItem uniqueItem = (UniqueItem) item;
                player.풀체 -= uniqueItem.체력증가;
                player.풀마 -= uniqueItem.마력증가;
                player.공격력 -= uniqueItem.공격력증가;
                player.방어력 -= uniqueItem.방어력증가;
                player.마법공격력 -= uniqueItem.마법공격력증가;
            }
        }
    }
}
