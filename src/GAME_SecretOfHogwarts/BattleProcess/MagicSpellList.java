package GAME_SecretOfHogwarts.BattleProcess;

import GAME_SecretOfHogwarts.Player.Player;

public class MagicSpellList {
        //초급마법
         public static MagicSpell 인센디오 =new MagicSpell("인센디오",(int)(Math.random()*300),10,"엄청난 화력의 화염이 발생했다!");
        public static  MagicSpell 리덕토=new MagicSpell("리덕토", (int) (Math.random()*300), 10, "주변의 바위를 깨뜨려 상대에게 데미지를 줬다!");

        //중급마법
        public static MagicSpell 아쿠아에릭토 = new MagicSpell("아쿠아에릭토", (int) (Math.random()*600), 20, "물줄기를 소환하여 상대에게 데미지를 입혔다!");
        public static  MagicSpell 브래키움엠멘도=new MagicSpell("브래키움 엠멘도",(int)(Math.random()*600),20,"상대의 뼈가 없어져 치명적인 데미지를 입혔다.");

        public static MagicSpell 스투페파이 =new MagicSpell("스투페파이",(int)(Math.random()*2000),30,"상대가 기절하고 치명적인 데미지를 입혔다");

        //고급마법
        public static MagicSpell 섹튬셈프라=new MagicSpell("섹튬셈프라", (int) (Math.random() * 3000), 50, "상대의 몸에 칼자국이 나며 치명적인 상처가 나타나 엄청난 괴로움을 느끼고 있다.");
        public static MagicSpell 엑스펙토페트로눔=new MagicSpell("엑스펙토 패트로눔",(int)(Math.random()*6*3000),40,"페트로누스가 소환되어 상대 몬스터에게 피해를 주었다.");
        public static MagicSpell 페트리피쿠스토탈루스=new MagicSpell("페트리피쿠스 토탈루스",(int)(Math.random()*3500),70,"상대의 몸이 화석처럼 굳어져 데미지를 입혔다.");
        //용서할 수 없는 마법
        public static MagicSpell 크루시오= new MagicSpell("크루시오",(int)(Math.random()*9756), 100,"상대는 엄청난 고통을 느끼고 있다.");
        public static MagicSpell 아바다케다브다= new MagicSpell("아바다 케다브다", 9999999, 150, "지팡이에서 붉은 빛을 내며 주문이 시전되었다. " +"\n  상대의 영혼이 분리되며 사라진다.");



}
