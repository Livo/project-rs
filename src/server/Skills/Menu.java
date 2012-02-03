package server.Skills;

import server.client;

public class Menu
{
    public void MenuHerb(client c)
    {
        /*Menu Numbers*/

        c.sendFrame126("Herbs",8846); 		// 1 - Herbs
        c.sendFrame126("Potions",8823);		// 2 - Potions
        c.sendFrame126("",8824);			// 3 - N/A
        c.sendFrame126("",8827);			// 4 - N/A
        c.sendFrame126("",8837);			// 5 - N/A
        c.sendFrame126("",8840);			// 6 - N/A
        c.sendFrame126("",8843);			// 7 - N/A
        c.sendFrame126("",8859);			// 8 - N/A
        c.sendFrame126("",8862);			// 9 - N/A
        c.sendFrame126("",8865);			// 10 - N/A
        c.sendFrame126("",15303);			// 11 - N/A
        c.sendFrame126("",15306);			// 12 - N/A
        c.sendFrame126("",15309);			// 13 - N/A
        c.sendFrame126("",8849);			// Top left side
    }

    public void sendFrame34(client c, int frame, int item, int slot, int amount) // Shows item image
    {
        c.outStream.createFrameVarSizeWord(34);
        c.outStream.writeWord(frame);
        c.outStream.writeByte(slot);
        c.outStream.writeWord(item+1);
        c.outStream.writeByte(255);
        c.outStream.writeDWord(amount);
        c.outStream.endFrameVarSizeWord();
    }

    public void OpenHerblore(client c)
    {
        c.sendFrame126("@dre@Herblore ~ Herbs", 8716);
        for(int q = 0; q<50; q++)
        {
            sendFrame34(c, 8847,-1,q,1);
        }
        for(int i = 8720; i<8799; i++)
        {
            c.sendFrame126("",i);
        }
        c.sendFrame126("3",8720);
        c.sendFrame126("Guam Leaf",8760);
        sendFrame34(c, 8847,249,0,1);			// Guam Leaf

        c.sendFrame126("3",8721);
        c.sendFrame126("Snake Weed",8761);
        sendFrame34(c, 8847,1526,1,1);		// Snake Weed

        c.sendFrame126("3",8722);
        c.sendFrame126("Ardrial",8762);
        sendFrame34(c, 8847,1528,2,1);		// Ardrial

        c.sendFrame126("3",8723);
        c.sendFrame126("Sito Foil",8763);
        sendFrame34(c, 8847,1530,3,1);		// Sito Foil

        c.sendFrame126("3",8724);
        c.sendFrame126("Colencia Moss",8764);
        sendFrame34(c, 8847,1532,4,1);		// Volencia Moss

        c.sendFrame126("3",8725);
        c.sendFrame126("Rogue",8765);
        sendFrame34(c, 8847,1534,5,1);		// Rogue

        c.sendFrame126("5",8726);
        c.sendFrame126("Marrentill", 8766);
        sendFrame34(c, 8847,251,6,1);			// Marrentill

        c.sendFrame126("11",8727);
        c.sendFrame126("Tarromin",8767);
        sendFrame34(c, 8847,253,7,1);			// Tarromin

        c.sendFrame126("20",8728);
        c.sendFrame126("Harralander", 8768);
        sendFrame34(c, 8847,255,8,1);			// Harralander

        c.sendFrame126("25",8729);
        c.sendFrame126("Ranarr weed", 8769);
        sendFrame34(c, 8847,257,9,1);			// Ranarr Weed

        c.sendFrame126("30",8730);
        c.sendFrame126("Toad Flax", 8770);
        sendFrame34(c, 8847,2998,10,1);		// Toad Flax

        c.sendFrame126("40",8731);
        c.sendFrame126("Irit leaf",8771);
        sendFrame34(c, 8847,259,11,1);		//Irit leaf

        c.sendFrame126("48",8732);
        c.sendFrame126("Avantoe", 8772);
        sendFrame34(c, 8847,261,12,1);		// Avantoe

        c.sendFrame126("54",8733);
        c.sendFrame126("Kwuam", 8773);
        sendFrame34(c, 8847,263,13,1);		// Kwuam

        c.sendFrame126("59",8734);
        c.sendFrame126("Snapdragon", 8774);
        sendFrame34(c, 8847,3000,14,1);		// Snapdragon

        c.sendFrame126("65", 8735);
        c.sendFrame126("Cadantine", 8775);
        sendFrame34(c, 8847,265,15,1);		// Cadantine

        c.sendFrame126("67",8736);
        c.sendFrame126("Lantadyme", 8776);
        sendFrame34(c, 8847, 2481,16,1);		// Lantadyme

        c.sendFrame126("70", 8737);
        c.sendFrame126("Dwarf weed", 8777);
        sendFrame34(c, 8847,267,17,1);		// Dwarf weed

        c.sendFrame126("75", 8738);
        c.sendFrame126("Torstol", 8778);
        sendFrame34(c, 8847,269,18,1);		// Torstol


        MenuHerb(c);
        c.showInterface(8714);

    }

    public void OpenPotion(client c)
    {
        c.sendFrame126("@dre@Herblore ~ Potions", 8716);
        for(int q = 0; q<50; q++)
        {
            sendFrame34(c, 8847,-1,q,1);
        }
        for(int i = 8720; i<8799; i++)
        {
            c.sendFrame126("", i);
        }

        c.sendFrame126("3",8720);
        c.sendFrame126("Attack Potion",8760);
        sendFrame34(c, 8847,2428,0,1);		// Attack Potion

        c.sendFrame126("5",8721);
        c.sendFrame126("Anti-Poison", 8761);
        sendFrame34(c,8847,2446,1,1);			// Anti-Poison

        c.sendFrame126("8",8722);
        c.sendFrame126("Relicym's Balm", 8762);
        sendFrame34(c,8847,4842,2,1);			// Relicym's Balm

        c.sendFrame126("12",8723);
        c.sendFrame126("Strength", 8763);
        sendFrame34(c,8847,113,3,1);			// Srength

        c.sendFrame126("15",8724);
        c.sendFrame126("Serum 207", 8764);
        sendFrame34(c,8847,3408,4,1);			// Serum 207

        c.sendFrame126("22",8725);
        c.sendFrame126("Restore", 8765);
        sendFrame34(c,8847,2430,5,1);			// Restore

        MenuHerb(c);
        c.showInterface(8714);
    }


}