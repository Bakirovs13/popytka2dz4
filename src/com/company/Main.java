package com.company;

import java.util.Random;

public class Main {

    public static int bossHealth = 400;
    public static int bossDamage = 20;
    public static String bossDefenceType =" ";
    public static int heroHealth = 100;
    public static int heroDamage = 20;
    public static int doctorHealth = 100;
    public static int doctorHeal = 50;
    public static String heroAttackType = "magical";


    public static void main(String[] args) {
	// write your code here
        fightInfo();

        while (!isFinished()){
            round();

        }

    }

    public static void round() {

        bossHit();
        doctorHealhero();
        heroHit();
        fightInfo();
    }


    public static boolean isFinished() {     // если здоровье босса равно нулю ,игра закончена и выводится надпись Герой выиграл!
        if (bossHealth <= 0) {
            System.out.println("Hero won!");
            return true;
        }
        if (heroHealth<=0){
            System.out.println("Boss won! ");
            return true;
        }
        return false;

    }
    public static void bossHit(){
        for (int i = 0, i2 = 0; (i < heroHealth &&  i2 < doctorHealth); i ++, i2 ++);{
            if(heroHealth>0 && doctorHealth>0 && bossHealth >0){
                if(heroHealth - bossDamage < 0){

                    heroHealth = 0;

                }


                if(doctorHealth - bossDamage <0){
                    doctorHealth = 0;
                }else{
                    heroHealth = heroHealth-bossDamage;
                    doctorHealth = doctorHealth - bossDamage;
                }
            }
        }
    }
public static void heroHit(){
    for (int i = 0; i <heroDamage ; i++) {
        if(heroHealth>0 && bossHealth >0) {


            if (bossDefenceType.equals(heroAttackType)) {
                Random random = new Random();
                int coefficient = random.nextInt(4) * 2;
                if (bossHealth - heroDamage * coefficient < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - heroDamage * coefficient;
                }
                System.out.println(heroAttackType + "critical hit" + heroDamage * coefficient);
            } else {
                if (bossHealth - heroDamage < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - heroDamage;
                }
            }
        }

    }

    }




    public static void doctorHealhero() {

            if (heroHealth > 0 && doctorHealth > 0) {

                heroHealth = heroHealth + doctorHeal;



        }
    }

    public static void fightInfo(){
        System.out.println("____________________________");
        System.out.println("Boss health:" + bossHealth+""+bossDefenceType);
        System.out.println("Hero Health:" +heroHealth);
        System.out.println("Doctor Health"+doctorHealth);

        System.out.println("____________________________");
    }

}
