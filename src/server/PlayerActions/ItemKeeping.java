package server.PlayerActions;

import server.client;
import server.Player;
import server.PlayerHandler;
import server.server;
import server.Player;
import server.PlayerHandler;

public class ItemKeeping {
	
	client c;

	public ItemKeeping(client client) {
			this.c = client;
		}

	public ItemKeeping() {
		// TODO Auto-generated constructor stub
	}


/*
 * Losing items on death - lostmyphat
*/

    public void keepItem1()
    {
        int highest = 0;
        for (int i = 0; i < c.playerItems.length; i++)
        {
            int value = (int)Math.floor(c.GetItemValue(c.playerItems[i]-1));
            if(value > highest && c.playerItems[i]-1 != -1)
            {
                highest = value;
                c.ItemKept1 = c.playerItems[i]-1;
                c.ItemKept1Slot = i;
                c.itemSlot1 = true;
            }
        }
        for (int i = 0; i < c.playerEquipment.length; i++)
        {
            int value = (int)Math.floor(c.GetItemValue(c.playerEquipment[i]));
            if(value > highest && c.playerEquipment[i] != -1)
            {
                highest = value;
                c.ItemKept1 = c.playerEquipment[i];
                c.ItemKept1Slot = i;
                c.itemSlot1 = true;
            }
        }
    }

    /*
     * ^^ - lostmyphat
    */
    
    public void keepItem2() {
        int highest = 0;
        for (int i = 0; i < c.playerItems.length; i++)
        {
            if (c.ItemKept1Slot != i)
            {
                int value = (int)Math.floor(c.GetItemValue(c.playerItems[i]-1));
                if(value > highest && c.playerItems[i]-1 != -1)
                {
                    highest = value;
                    c.ItemKept2 = c.playerItems[i]-1;
                    c.ItemKept2Slot = i;
                    c.itemSlot2 = true;
                }
            }
        }
        for (int i = 0; i < c.playerEquipment.length; i++)
        {
            if (c.ItemKept1Slot != i)
            {
                int value = (int)Math.floor(c.GetItemValue(c.playerEquipment[i]));
                if(value > highest && c.playerEquipment[i] != -1)
                {
                    highest = value;
                    c.ItemKept2 = c.playerEquipment[i];
                    c.ItemKept2Slot = i;
                    c.itemSlot2 = false;
                }
            }
        }
    }

    /*
     * ^^ - lostmyphat
    */
    
    public void keepItem3()
    {
        int highest = 0;
        for (int i = 0; i < c.playerItems.length; i++)
        {
            if (c.ItemKept1Slot != i && c.ItemKept2Slot != i)
            {
                int value = (int)Math.floor(c.GetItemValue(c.playerItems[i]-1));
                if(value > highest && c.playerItems[i]-1 != -1)
                {
                    highest = value;
                    c.ItemKept3 = c.playerItems[i]-1;
                    c.ItemKept3Slot = i;
                    c.itemSlot3 = true;
                }
            }
        }
        for (int i = 0; i < c.playerEquipment.length; i++)
        {
            if (c.ItemKept1Slot != i && c.ItemKept2Slot != i)
            {
                int value = (int)Math.floor(c.GetItemValue(c.playerEquipment[i]));
                if(value > highest && c.playerEquipment[i] != -1)
                {
                    highest = value;
                    c.ItemKept3 = c.playerEquipment[i];
                    c.ItemKept3Slot = i;
                    c.itemSlot3 = false;
                }
            }
        }
    }
    
    /*
     * ^^ - lostmyphat
    */
    

    public void keepItem4()
    {
        int highest = 0;
        for (int i = 0; i < c.playerItems.length; i++)
        {
            if (c.ItemKept1Slot != i && c.ItemKept2Slot != i && c.ItemKept3Slot != i)
            {
                int value = (int)Math.floor(c.GetItemValue(c.playerItems[i]-1));
                if(value > highest && c.playerItems[i]-1 != -1)
                {
                    highest = value;
                    c.ItemKept4 = c.playerItems[i]-1;
                    c.ItemKept4Slot = i;
                    c.itemSlot4 = true;
                }
            }
        }
        for (int i = 0; i < c.playerEquipment.length; i++)
        {
            if (c.ItemKept1Slot != i && c.ItemKept2Slot != i && c.ItemKept3Slot != i)
            {
                int value = (int)Math.floor(c.GetItemValue(c.playerEquipment[i]));
                if(value > highest && c.playerEquipment[i] != -1)
                {
                    highest = value;
                    c.ItemKept4 = c.playerEquipment[i];
                    c.ItemKept4Slot = i;
                    c.itemSlot4 = false;
                }
            }
        }
    }
}