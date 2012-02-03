package server.Skills;

import server.client;
import server.Skills.Exp;

public class Herblore
{
    public void Identify(client c,int UnidentifiedHerb, int IdentifiedHerb, int HerbXP, int HerbLevel)
    {
        if(c.playerHasItem(UnidentifiedHerb, 1) && c.playerLevel[15] >= HerbLevel)
        {
            c.deleteItem(UnidentifiedHerb, 1);
            c.addSkillXP(HerbXP, 15); //Herblore skill (15)
            c.addItem(IdentifiedHerb, 1);
            c.sM("You have Identified " + c.getItemName(IdentifiedHerb) + ".");
        } else {
            if(c.playerLevel[15] < HerbLevel)
            {
                c.sM("You need level " + HerbLevel + " herblore to identify this herb.");
            }
        }
    }


    public void HerbIdentify(client c, int item, int slot, int ID)
    {
        boolean used = true;
        if (item != c.playerItems[slot] - 1) {
            return;
        }
        if (c.playerHasItem(item)) {
            switch (item) {

            case 199:
                Identify(c, 199, 249, 3, 3); 		// Guam Leaf
                break;

            case 201:
                Identify(c, 201, 251, 4, 5);	 	// Marrentill
                break;

            case 203:
                Identify(c, 203, 253, 5, 11);		 // Tarromin
                break;

            case 205:
                Identify(c, 205, 255, 6, 20); 	// Harralander
                break;

            case 207:
                Identify(c, 203, 257, 8, 25); 	// Ranarr weed
                break;

            case 2998:
                Identify(c, 2998, 3049, 8, 30); 	// Toad Flax
                break;

            case 209:
                Identify(c, 209, 259, 9, 40); 	// Irit leaf
                break;

            case 211:
                Identify(c, 211, 261, 10, 48); 	// Avantoe
                break;

            case 213:
                Identify(c, 213, 263, 11, 54); 	// Kwuam
                break;

            case 3000:
                Identify(c, 3000, 3051, 12, 59); 	// Snapdragon
                break;

            case 215:
                Identify(c, 215, 265, 13, 65); 	// Cadantine
                break;

            case 2481:
                Identify(c, 2481, 2485, 13, 67);	// Lantadyme
                break;

            case 217:
                Identify(c, 217, 267, 14, 70); 	// Dwarf weed
                break;

            case 219:
                Identify(c, 219, 269, 15, 75); 	// Torstol
                break;


            default:
                used = false;
                break;
            }
        }
    }

    public void MakeUnfinishedPotion(client c, int Herb, int Unfinished)
    {
        int Water = 227;
        int Animation = 363;

        c.setAnimation(Animation);
        c.deleteItem(Herb, 1);
        c.deleteItem(Water, 1);
        c.addItem(Unfinished, 1);
        c.sM("You put the " + c.getItemName(Herb) + " into the vial of water.");
    }
    public void MakeFinishedPotion(client c, int Unfinished, int Mixed, int Potion, int level, int xp)
    {
        int Animation = 363;
        if(c.playerHasItem(Unfinished) && c.playerHasItem(Mixed) && c.playerLevel[15] >= level)
        {
            c.addSkillXP(xp, 15);
            c.setAnimation(Animation);
            c.deleteItem(Unfinished, 1);
            c.deleteItem(Mixed, 1);
            c.addItem(Potion, 1);
            c.sM("You put the " + c.getItemName(Mixed) + " into the "+ c.getItemName(Unfinished) + ".");
        } else {
            c.sM("Your Herblore level is not high enough to make this position.");
        }
    }

    public void FinishedPotion(client c, int itemUsed, int otherItem)
    {
        boolean used = true;
        if (c.playerHasItem(itemUsed))
        {
            switch (otherItem)
            {

            case 91:
                MakeFinishedPotion(c, 91, 221, 2428, 3, 25);
                break;

            case 93:
                MakeFinishedPotion(c, 93, 235, 2446, 5, 38);
                break;


            default:
                used = false;
                break;
            }
        }
    }

    public void UnfinishedPotion(client c, int itemUsed, int otherItem)
    {
        boolean used = true;
        if (c.playerHasItem(itemUsed))
        {
            switch (itemUsed)
            {

            case 249:
                MakeUnfinishedPotion(c, 249, 91);
                break;

            case 251:
                MakeUnfinishedPotion(c, 251, 93);
                break;

            case 1534:
                MakeUnfinishedPotion(c, 1534, 4840);
                break;

            case 253:
                MakeUnfinishedPotion(c, 253, 95);
                break;

            case 255:
                MakeUnfinishedPotion(c, 255, 97);
                break;


            default:
                used = false;
                break;
            }
        }
    }

    public void Crush(client c, int item, int other)
    {
        int Animation = 363;
        if(c.playerHasItem(item))
        {
            c.setAnimation(Animation);
            c.deleteItem(item, 1);
            c.addItem(other, 1);
            c.sM("You Crush the " + c.getItemName(item) + " into " + c.getItemName(other) + ".");
        }
    }

    public void Pestel(client c, int itemUsed, int otherItem)
    {
        boolean used = true;
        if (c.playerHasItem(itemUsed))
        {
            switch (otherItem)
            {

            case 233:
                Crush(c, 237, 235);
                break;

            default:
                used = false;
                break;
            }
        }
    }










}