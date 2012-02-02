package server;

public class GlobalItems
{
public int spawntimer = 0;

public void LoadItems()
{
for (int i = 0; i <= 5000; i++){
if(spawntimer <= 1)
{
//ITEMID, COORDX, COORDY, AMOUNT - Jdog
ItemHandler.addItem(4151, 3091, 3495, 1, ItemHandler.globalItemController[i], false); // whip at edge(a test)
spawntimer = 100;
}
}
}

public void process()
{
LoadItems();
spawntimer -= 1;
}
}