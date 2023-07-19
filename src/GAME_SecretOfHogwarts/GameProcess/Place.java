package GAME_SecretOfHogwarts.GameProcess;

import GAME_SecretOfHogwarts.Item.Function.BuyItem;
import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.Item.ItemList;
import GAME_SecretOfHogwarts.Item.Potion;
import GAME_SecretOfHogwarts.Item.PotionList;
import GAME_SecretOfHogwarts.Player.Player;
import GAME_SecretOfHogwarts.Thread.SceneManager;

import java.util.ArrayList;

public class Place {
    GameAssist GA = new GameAssist();
    SceneManager sceneManager=new SceneManager();
    BuyItem buyItem = new BuyItem();

    public void 다이애건앨리아이템상점(Player player) {
        boolean 진행상황 = true;
        do {
            GA.화면클리어();
            GA.정보알림("             다이애건앨리 아이템 상점");
            GA.정보알림("           구입할 아이템을 말씀해주세요.\n\n" +
                    "                      현재 소지한 골드 : " + player.골드 + " 골드");
            ItemList.다이애건앨리상점();
            for (int i = 0; i < ItemList.아이템상점.size(); i++) {
                Item item = ItemList.아이템상점.get(i);
                int 아이템번호 = i + 1;
                System.out.println("(" + 아이템번호 + ") " + item.아이템이름 + "(가격 :" + item.아이템가격 + "골드, 등급:" + item.아이템등급 + ")");
            }
            System.out.println("(" + (ItemList.아이템상점.size() + 1) + ") 상점나가기");
            GA.중간띄우기();
            int 아이템입력 = GA.번호입력(":", ItemList.아이템상점.size() + 1);
            if (아이템입력 >= 1 && 아이템입력 <= ItemList.아이템상점.size()) {
                Item 선택한아이템 = ItemList.아이템상점.get(아이템입력 - 1);
                System.out.println();
                buyItem.아이템구입(player, 선택한아이템);
            } else if (아이템입력 == ItemList.아이템상점.size() + 1) {
                진행상황 = false;
            }
        } while (진행상황);
    }

    public void 호그스미드포션상점(Player player) {
        boolean 진행상황 = true;
        do {
            GA.화면클리어();
            GA.정보알림("             호그스미드 포션 상점");
            GA.정보알림("          구입할 포션을 말씀해주세요.\n\n" +
                    "                      현재 소지한 골드 : " + player.골드 + " 골드");
            for (int i = 0; i < PotionList.포션.length; i++) {
                int 포션번호 = i + 1;
                System.out.println("(" + 포션번호 + ") " + PotionList.포션[i].아이템이름 + "(가격 :" + PotionList.포션[i].아이템가격 + "골드)");
            }
            System.out.println("(" + (PotionList.포션.length + 1) + ") 상점나가기");
            GA.중간띄우기();
            int 포션입력 = GA.번호입력(":", 4);
            if (포션입력 >= 1 && 포션입력 <= 3) {
                System.out.println();
                buyItem.포션구입(player, PotionList.포션, 포션입력);
            } else if (포션입력 == PotionList.포션.length + 1) {
                진행상황 = false;
            } else {
                진행상황 = true;
            }
        } while (진행상황);
    }
}
