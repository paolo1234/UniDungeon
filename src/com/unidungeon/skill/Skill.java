package com.unidungeon.skill;
import com.unidungeon.game.Role;
import com.unidungeon.entity.Entity;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusStun;
import com.unidungeon.entity.player.Player;

import java.util.Random;

public class Skill {
        private String name;
        private String description;
        private int cost_sp;
        private int dmg;
        private int prob_malus;
        private Malus malus;
        private Role role;
        private int lv_unlock;
        final float CRIT_DMG = 1.25f;

        public Skill(String name,String description,int cost_sp,int dmg,int prob_malus,Malus malus,Role role,int lv_unlock){
            this.name=name;
            this.description=description;
            this.cost_sp=cost_sp;
            this.dmg=dmg;
            this.prob_malus=prob_malus;
            this.malus=malus;
            this.role=role;
            this.lv_unlock=lv_unlock;
        }

        //Execute the skill -- Skill dmg * Exectuer dmg moltiplicator * Counter role moltiplicator * (Crit or NotCrit) / Receiver def moltiplicator.
        public void executeSkill(Entity executer, Entity receiver, Malus malus[], int malusT[], int index){
            Random random = new Random();
            if(executer instanceof Player)
                ((Player) executer).decreaseSp(this.cost_sp);
            //Checks if crit hits.
            float damage = (this.dmg*executer.getDmg())*Role.counter(this.role,receiver.getRole())/receiver.getDef();
            //System.out.println(Role.counter(this.role,receiver.getRole()));
            //System.out.println("DMG: "+ damage);
            if(executer.hasCrit()){
                receiver.decreaseHp((int)(damage*this.CRIT_DMG)); //CRIT    40 * 1,25 /2   int 40/2 20   float 502 25
            }
            else{
                receiver.decreaseHp((int)(damage));   //NOT CRIT
                //System.out.println(receiver.getHp());
            }
            //Gives the malus
            if(!receiver.isKO()){
                if(this.hasMalus()){
                    malus[index]=this.malus;
                    if(this.malus instanceof MalusStun)
                        malusT[index]= ((MalusStun) this.malus).getTurn();
                    else
                        malusT[index]=3;
                }
            }else
                //If receiver is KO after the attack, remove the malus is possessed
                if(malus[index]!=null)
                    malus[index]=null;
        }

        //Returns true if the malus does hit otherwise false if the malus doesn't hit.
        public boolean hasMalus(){
            Random random = new Random();
            if(random.nextInt(100)<=this.prob_malus && prob_malus>0)
                return true;
            else
                return false;
        }

        public String getName(){
            return this.name;
        }

        public String getDescription(){
            return this.description;
        }

        public int getCostSp(){
            return this.cost_sp;
        }

        public int getDmg(){
            return this.dmg;
        }

        public int getProbMalus(){
            return this.prob_malus;
        }

        //Returns the malus of the skill.
        public Malus getMalus(){
            return this.malus;
        }

        public Role getRole(){
            return this.role;
        }

        public int getLvUnlock(){
            return this.lv_unlock;
        }

}