package ca.udem.ift1025.tp1.corrige;

public class Hero {
    private String name;
    protected int category;
    private double costMoney;
    private int costArmour;
    private double hp;

    public Hero(String name, int category, double costMoney, int costArmour, double hp) {
        this.name=name;
        this.category=category;
        this.costMoney=costMoney;
        this.costArmour=costArmour;
        this.hp=hp;

    }


    public void trainHero(Hero hero) {
        double costGold = 20*Math.log(hero.category+10);
        int costArmour = Math.ceil(Math.log(hero.category+10));

        //calculer si on a assez d'argent et d'armure pour faire l'amelioration et mettre une erreur sinon


            hero.category+=1;
            //modifier le Bank Account

        }

    }

}
