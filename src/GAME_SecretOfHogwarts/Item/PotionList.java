package GAME_SecretOfHogwarts.Item;

import java.util.ArrayList;
import java.util.List;

public class PotionList {
    public static List<Item> 포션상점;
    public static HealingPotion 포션[] ={new HealingPotion("체력포션", 10,"노말", "힐링",20,0),
            new HealingPotion("마력포션", 20, "노말","힐링",0,20),
            new HealingPotion("만능포션", 50, "노말","힐링",30,30) };

    public static Item 개구리초콜릿= new StatPotion("개구리 초콜릿",10,"노말","스탯",3,0,0);
    public static Item 버터맥주= new StatPotion("버터맥주",50,"레어","스탯",1,5,0);
    public static Item 호박주스= new StatPotion("호박주스",50,"레어","스탯",5,1,2);
    public static Item 요정이만든포도주= new StatPotion("요정이 만든 포도주",100,"유니크","스탯",20,10,20);
    public static Item 로즈메르타부인의꿀술= new StatPotion("로즈 메르타부인의 꿀술",100,"유니크","스탯",20,20,5);
    public static Item 펠릭스펠리시스= new StatPotion("펠릭스펠리시스",500,"유니크","스탯",30,30,50);
    public static void 스탯포션상점(){
        포션상점=new ArrayList<Item>();
        포션상점.add(개구리초콜릿);
        포션상점.add(버터맥주);
        포션상점.add(호박주스);
        포션상점.add(요정이만든포도주);
        포션상점.add(로즈메르타부인의꿀술);
    }
}
