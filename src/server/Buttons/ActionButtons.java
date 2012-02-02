package server.Buttons; 

import server.client; 
import server.misc;
import server.server;
import server.PlayerHandler;
import server.Player;
import server.NPC;

public class ActionButtons { 
	
public void Buttons(int a){
client c = (client) PlayerHandler.players[a];
		switch(c.actionButtonId) {
			case 4169: // Charge arena spells
				if (c.arenaSpellTimer <= 0) {
					if (!c.playerHasItem(554, 3) || !c.playerHasItem(565, 3)
							|| !c.playerHasItem(556, 3)) {
						c.sM("You don't have enough runes to cast this spell.");
					} else {
						if (c.playerHasItem(554, 3) && c.playerHasItem(565, 3)
								&& c.playerHasItem(556, 3)) {
							if ((c.playerEquipment[c.playerCape] == 2412)
									|| (c.playerEquipment[c.playerCape] == 2413)
									|| (c.playerEquipment[c.playerCape] == 2414)) {
								c.deleteItem(554, c.getItemSlot(554), 3);
								c.deleteItem(565, c.getItemSlot(565), 3);
								c.deleteItem(556, c.getItemSlot(556), 3);
								c.setAnimation(1820);
								c.stillgfx(441, c.absY, c.absX);
								c.arenaSpellTimer = 120; // 2 Minutes
								if (c.playerEquipment[c.playerCape] == 2412) {
									c.SaradominStrike = true;
									c.sM("You summon the power of the gods and increase your Saradomin Strike's power.");
								}
								if (c.playerEquipment[c.playerCape] == 2413) {
									c.GuthixClaws = true;
									c.sM("You summon the power of the gods and increase your Claws of Guthix's power.");
								}
								if (c.playerEquipment[c.playerCape] == 2414) {
									c.ZamorakFlames = true;
									c.sM("You summon the power of the gods and increase your Flames of Zamorak's power.");
								}
							} else {
								c.sM("You need to be wearing a god cape to cast this spell.");
							}
						}
					}
				} else {
					c.sM("Your god spell is at it's full power.");
				}
				break;











				case 9154:
				// Log out
Player.client = c.getClient(c.trade_reqId);
if(c.trade_reqId > 0){ //Logout Dupe Fix -- Digistr
c.declineTrade(); // Prevents Players Logging Out After A Trade For 28 Clicks.
c.sM(""+c.playerName+" Has Declined The Trade");
c.declineTrade();
c.TradeLogout -= 2;
}
if(c.TradeLogout > 0){
c.TradeLogout -= 1; // Just Keep Clicking Kiddies.. You'll Logout
break;
}
				long currentTime = System.currentTimeMillis();
				if (c.inCombat) {
					c.sM("You must wait until you are out of combat before logging out!");
					break;
				}
if(c.action == 1){
c.sM("Suspicious activity!");
break;
}
				// if(c.currentHealth > 0)
				c.logout();
break;

case 33213:
server.Menu.OpenHerblore(c);
break;
case 34142:
server.Menu.OpenHerblore(c);
break;
case 34119:
server.Menu.OpenPotion(c);
break;



case 73176:
if(c.playerHasItem(553, 5) && c.playerHasItem(560, 5) && c.playerHasItem(563, 10)){
if(c.playerLevel[6] >= 96){
c.switchBooks();
c.deleteItem(553, 5);
c.deleteItem(560, 5);
c.deleteItem(563, 10);
} else
c.sM("You need a magic level of 96 or better to cast this spell.");
} else
c.sM("You don't have enough runes to cast this spell.");
break;
case 73172:
if(System.currentTimeMillis() - c.mageDelay < 7000) return;
if(c.playerHasItem(553, 5) && c.playerHasItem(560, 5) && c.playerHasItem(565, 10)){
if(c.playerLevel[6] >= 95){
c.mageDelay = System.currentTimeMillis();
//c.healAll();
c.deleteItem(553, 5);
c.deleteItem(560, 5);
c.deleteItem(565, 10);
} else
c.sM("You need a magic level of 95 or better to cast this spell.");
} else
c.sM("You don't have enough runes to cast this spell.");
break;
case 73124:
if(System.currentTimeMillis() - c.mageDelay < 7000) return;
if(c.playerHasItem(553, 1) && c.playerHasItem(557, 5)){
if(c.playerLevel[6] >= 71){
c.mageDelay = System.currentTimeMillis();
c.deleteItem(553, 1);
c.deleteItem(557, 5);
c.poisoned = false;
c.poisonDmg = false;
c.sM("You have cured yourself.");
} else
c.sM("You need a magic level of 71 or better to cast this spell.");
} else
c.sM("You don't have enough runes to cast this spell.");
break;
case 73128:
if(System.currentTimeMillis() - c.mageDelay < 7000) return;
if(c.playerHasItem(553, 3) && c.playerHasItem(557, 15)){
if(c.playerLevel[6] >= 74){
c.mageDelay = System.currentTimeMillis();
//c.cureAll();
} else
c.sM("You need a magic level of 74 or better to cast this spell.");
} else
c.sM("You don't have enough runes to cast this spell.");
break;

case 9157:
if(c.NpcDialogue == 9){

c.showInterface(14924);
}

if(c.NpcDialogue == 12){

c.NpcDialogue = 13;
c.NpcDialogueSend = false;
}
if(c.NpcDialogue == 17){

c.NpcDialogue = 18;
c.NpcDialogueSend = false;
}
if(c.NpcDialogue == 24){

c.NpcDialogue = 25;
c.NpcDialogueSend = false;
}
if(c.NpcDialogue == 29 && c.playerHasItem(995, 500)){

c.NpcDialogue = 30;
c.NpcDialogueSend = false;
c.deleteItem(995, 500);
c.q2 = 2;
}
if(c.NpcDialogue == 29 && !c.playerHasItem(995, 500)){

c.sM("You do not have enough coins.");
}

if(c.NpcDialogue == 104){

c.toX = 2917;
c.toY = 9692;
}
if(c.NpcDialogue == 110){

c.toX = 3500;
c.toY = 3487;
}
if(c.NpcDialogue == 117){

c.toX = 2855;
c.toY = 3338;
}
break;
case 9158:
if(c.NpcDialogue == 9 || c.NpcDialogue == 11 || c.NpcDialogue == 12 || c.NpcDialogue == 17 || c.NpcDialogue == 24 || c.NpcDialogue == 29 || c.NpcDialogue == 38 || c.NpcDialogue == 43 || c.NpcDialogue == 46 || c.NpcDialogue == 51 || c.NpcDialogue == 58 || c.NpcDialogue == 67 || c.NpcDialogue == 83 || c.NpcDialogue == 93 || c.NpcDialogue == 99 || c.NpcDialogue == 104 || c.NpcDialogue == 110 || c.NpcDialogue == 125 || c.NpcDialogue == 127 || c.NpcDialogue == 129 || c.NpcDialogue == 117){

}
break;
case 21076:
c.brightness = 1;
break;
case 24129:
c.brightness = 2;
break;
case 24131:
c.brightness = 3;
break;
case 24133:
c.brightness = 4;
break;
case 3185:
c.splitChat = 0;
break;
case 3184:
c.splitChat = 1;
break;
case 58074:
c.closeInterface();
break;


       
case 150:
c.autoRetaliate = 1;
break;
case 151:
c.autoRetaliate = 0;
break;
  
			
case 55095://yes (destroy item)
    c.deleteItem(c.publicDroppendItem, c.getItemSlot(c.publicDroppendItem), 1);
    c.closeInterface();
    break;
case 55096://no (destroy item)
    c.closeInterface();
    break;  
case 29063://axes
if (c.playerEquipment[c.playerWeapon] == 1377 && c.specialAmount <= 99) {//dba
c.sM("You do not have enough special energy left.");
}
if (c.playerEquipment[c.playerWeapon] == 1377 && c.specialAmount >= 100) {//dba
c.strPot = true;
c.strPotTimer = 20;
c.abc = c.getLevelForXP(c.playerXP[2]);
c.cba = c.abc / 10;
c.abc2 = c.cba * 2;
if (c.abc2 <= 1) {
c.abc2 = 2;
}
c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
c.playerLevel[2] += c.abc2;
c.sendFrame126(""+c.playerLevel[2]+"", 4006);
c.updateRequired = true;
c.appearanceUpdateRequired = true;
c.setAnimation(1670);
c.lowGFX(246, 0);
c.specialAmount -= 100;
c.specTimer = 70;
c.plrText = "Raarrrrrgggggghhhhhhh!";
c.plrTextUpdateRequired = true;
}
c.specAttack();
break;
case 40132:
c.option = 1;
break;
case 40133:
c.option = 2;
break;
case 25155:
c.option = 3;
break;
case 25160:
c.option = 4;
break;
case 40122:
if(c.option == 0 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You have not chosen a reward!");
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 1 && c.pcPoints > 4 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You have been rewarded the dragon weapon set!");
c.addItem(1377, 1);
c.addItem(4587, 1);
c.pcPoints -= 5;
c.closeInterface();
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 1 && c.pcPoints < 5 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You do not have enough points!");
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 2 && c.pcPoints > 99 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You have been rewarded full void knight!");
c.addItem(2520, 1);
c.addItem(2522, 1);
c.addItem(2518, 1);
c.addItem(2524, 1);
c.addItem(2526, 1);
c.pcPoints -= 100;
c.closeInterface();
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 2 && c.pcPoints < 100 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You do not have enough points!");
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 3 && c.pcPoints > 0 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You have been rewarded 30 ice arrows!");
c.addItem(78, 30);
c.pcPoints -= 1;
c.closeInterface();
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 3 && c.pcPoints == 0 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You do not have enough points!");
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 4 && c.pcPoints > 149 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You have been rewarded a bandos godsword!");
c.addItem(667, 1);
c.pcPoints -= 150;
c.closeInterface();
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
if(c.option == 4 && c.pcPoints < 150 && System.currentTimeMillis() - c.lastAction > c.actionInterval){
c.sM("You do not have enough points!");
c.actionInterval = 6000;
c.lastAction = System.currentTimeMillis();
}
break;
case 29113://bows
case 33033://halberds
case 29163://swords
case 29138://dds
case 48023://whip
try {
if(c.playerEquipment[c.playerWeapon] == 4153 && c.specialAmount > 49 && c.IsAttacking){
c.specialAtk(true, 50, 340, 1667);
c.hitDiff = misc.random(c.playerMaxHit) + misc.random(c.StrPrayer);
}
if(c.playerEquipment[c.playerWeapon] == 4153 && c.specialAmount > 49 && c.IsAttackingNPC){
c.specialAtkNPC(true, 50, 340, 1667);
c.hitDiff = misc.random(c.playerMaxHit) + misc.random(c.StrPrayer);
}
if (c.specOn == true && c.playerEquipment[c.playerWeapon] != 4153) {
c.specOn = false;
} else if (c.specOn == false && c.playerEquipment[c.playerWeapon] != 4153) {
c.specOn = true;
}
c.specAttack();
} catch (Exception popo) {
}
break;
case 51031:
c.triggerTele(2772, 2794, 0);
break;
case 73140:
case 29031:
c.triggerTele(2772, 2794, 0);
break;
case 73100:
case 4140:
case 50235:
c.triggerTele(2999+misc.random(3), 3377+misc.random(3), 0);
c.sM("LolWtfBBQ");
break;
case 9167:
if(c.teleEffect == 1)
c.triggerTele(3087+misc.random(2), 3498+misc.random(2), 0);
if(c.teleEffect == 2)
c.triggerTele(3020+misc.random(2), 4815+misc.random(2), 0);
break;
case 9168:
if(c.teleEffect == 1)
c.triggerTele(3244, 3518, 0);
if(c.teleEffect == 2)
c.closeInterface();
break;
case 9169:
if(c.teleEffect == 1)
c.triggerTele(2539+misc.random(2), 4716+misc.random(2), 0);
break;
case 17111:
		c.closeInterface();
					if (c.playerAncientMagics == 0) {
						 c.setSidebarInterface(6, 1151);
					}
					if (c.playerAncientMagics == 1) {
						c.setSidebarInterface(6, 12855);
					}
break;
case 59136:
if(c.interfaceGame == 1)
c.triggerTele(2670, 3710, 0);
if(c.interfaceGame == 2)
c.triggerTele(3564, 3288, 0);
break;
case 59137:
if(c.interfaceGame == 1)
c.triggerTele(2455, 10147, 0);
if(c.interfaceGame == 2)
c.triggerTele(2399, 5178, 0);
break;
case 59135:
if(c.interfaceGame == 1)
c.triggerTele(2896, 2725, 0);
if(c.interfaceGame == 2)
c.triggerTele(2659, 2676, 0);
break;
case 59139:
if(c.interfaceGame == 1)
c.triggerTele(3550, 9947, 0);
if(c.interfaceGame == 2)
c.triggerTele(2603, 3153, 0);
break;
case 59138:
if(c.interfaceGame == 1)
c.triggerTele(3428, 3537, 0);
break;
	
case 73168:
if(c.q10 != 15){
c.sM("You must have completed Lunar Spirit to use this spell.");
}
if(System.currentTimeMillis() - c.vengDelay < 30000){
c.sM("You can only cast vengeance spells every 30 seconds.");
return;
}
if(c.playerLevel[6] < 94){
c.sM("You need a magic level of 94 or better to cast this spell.");
}
if (!c.HasItemAmount(553, 4) || !c.HasItemAmount(560, 2) || !c.HasItemAmount(557, 10)) {
c.sM("You don't have enough runes to cast this spell.");
} else
if (c.HasItemAmount(553, 4) && c.HasItemAmount(560, 2) && c.HasItemAmount(557, 10) && c.playerLevel[6] > 93 && c.q8 == 15){
c.vengDelay = System.currentTimeMillis();
c.addSkillXP(500, 6);
c.specGFX(657);
c.setAnimation(1914);
c.vengon = true;
c.deleteItem(553, 4);
c.deleteItem(560, 2);
c.deleteItem(557, 10);
c.toX = c.absX;
c.toY = c.absY;
}
break;
case 21241: // protect 1 item
if(c.playerLevel[5] == 0){
c.setClientConfig(91, 0);
c.ProtItem = false;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 25){
c.setClientConfig(91, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 25 to use Protect 1 Item.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 25 to use this."); 
}
if(c.ProtItem != true && c.getLevelForXP(c.playerXP[5]) > 24 && c.playerLevel[5] > 0)
{
c.ProtItem = true;
c.praydrain = 4;
c.prayOn = true;
} else if(c.ProtItem == true && c.getLevelForXP(c.playerXP[5]) > 24 && c.playerLevel[5] > 0) {
c.setClientConfig(91, 0);
c.ProtItem = false;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21233: // thick skin
if(c.playerLevel[5] == 0){
c.setClientConfig(83, 0);
c.DefPray = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.StrPrayer = 0;
}
if(c.DefPray != 1 && c.getLevelForXP(c.playerXP[5]) > 0 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.DefPray = 1;
c.praydrain = 4;
c.setClientConfig(86, 0);
c.setClientConfig(92, 0);
c.prayOn = true;
} else if(c.DefPray == 1 && c.getLevelForXP(c.playerXP[5]) > 0 && c.playerLevel[5] > 0) {
c.setClientConfig(83, 0);
c.DefPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21236: // rock skin
if(c.playerLevel[5] == 0){
c.setClientConfig(86, 0);
c.DefPray = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.StrPrayer = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 10){
c.setClientConfig(86, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 10 to use Rock Skin.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 10 to use this."); 
}
if(c.DefPray != 2 && c.getLevelForXP(c.playerXP[5]) > 9 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.DefPray = 2;
c.praydrain = 4;
c.setClientConfig(83, 0);
c.setClientConfig(92, 0);
c.prayOn = true;
} else if(c.DefPray == 2 && c.getLevelForXP(c.playerXP[5]) > 9 && c.playerLevel[5] > 0) {
c.setClientConfig(86, 0);
c.DefPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21242: // steel skin
if(c.playerLevel[5] == 0){
c.setClientConfig(92, 0);
c.DefPray = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.StrPrayer = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 28){
c.setClientConfig(92, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 28 to use Steel Skin.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 28 to use this."); 
}
if(c.DefPray != 3 && c.getLevelForXP(c.playerXP[5]) > 27 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.DefPray = 3;
c.praydrain = 4;
c.setClientConfig(83, 0);
c.setClientConfig(86, 0);
c.prayOn = true;
} else if(c.DefPray == 3 && c.getLevelForXP(c.playerXP[5]) > 27 && c.playerLevel[5] > 0) {
c.setClientConfig(92, 0);
c.DefPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21234: // burst of strength
if(c.playerLevel[5] == 0){
c.setClientConfig(84, 0);
c.StrPrayer = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.DefPray = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 4){
c.setClientConfig(84, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 4 to use Burst of Strength.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 4 to use this."); 
}
if(c.StrPrayer != 1 && c.getLevelForXP(c.playerXP[5]) > 3 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.RangePray = 0;
c.MagePray = 0;
c.StrPrayer = 1;
c.praydrain = 4;
c.setClientConfig(87, 0);
c.setClientConfig(93, 0);
c.setClientConfig(89, 0);
c.setClientConfig(90, 0);
c.prayOn = true;
} else if(c.StrPrayer == 1 && c.getLevelForXP(c.playerXP[5]) > 3 && c.playerLevel[5] > 0) {
c.setClientConfig(84, 0);
c.StrPrayer = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21237: // superhuman strength
if(c.playerLevel[5] == 0){
c.setClientConfig(87, 0);
c.StrPrayer = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.DefPray = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 13){
c.setClientConfig(87, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 13 to use Superhuman Strength.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 13 to use this."); 
}
if(c.StrPrayer != 2 && c.getLevelForXP(c.playerXP[5]) > 12 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.RangePray = 0;
c.MagePray = 0;
c.StrPrayer = 2;
c.praydrain = 4;
c.setClientConfig(84, 0);
c.setClientConfig(93, 0);
c.setClientConfig(89, 0);
c.setClientConfig(90, 0);
c.prayOn = true;
} else if(c.StrPrayer == 2 && c.getLevelForXP(c.playerXP[5]) > 12 && c.playerLevel[5] > 0) {
c.setClientConfig(87, 0);
c.StrPrayer = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21243: // ultimate strength
if(c.playerLevel[5] == 0){
c.setClientConfig(93, 0);
c.StrPrayer = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.DefPray = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 31){
c.setClientConfig(93, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 31 to use Ultimate Strength.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 31 to use this."); 
}
if(c.StrPrayer != 3 && c.getLevelForXP(c.playerXP[5]) > 30 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.RangePray = 0;
c.MagePray = 0;
c.StrPrayer = 3;
c.praydrain = 4;
c.setClientConfig(84, 0);
c.setClientConfig(87, 0);
c.setClientConfig(89, 0);
c.setClientConfig(90, 0);
c.prayOn = true;
} else if(c.StrPrayer == 3 && c.getLevelForXP(c.playerXP[5]) > 30 && c.playerLevel[5] > 0) {
c.setClientConfig(93, 0);
c.StrPrayer = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21235: // clarity of thought
if(c.getLevelForXP(c.playerXP[5]) < 7 || c.playerLevel[5] == 0){
c.setClientConfig(85, 0);
c.AtkPray = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.StrPrayer = 0;
c.DefPray = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 7){
c.setClientConfig(85, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 7 to use Clarity of Thought.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 7 to use this."); 
}
if(c.AtkPray != 1 && c.getLevelForXP(c.playerXP[5]) > 6 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.RangePray = 0;
c.MagePray = 0;
c.AtkPray = 1;
c.setClientConfig(88, 0);
c.setClientConfig(94, 0);
c.setClientConfig(89, 0);
c.setClientConfig(90, 0);
c.praydrain = 4;
c.prayOn = true;
} else if(c.AtkPray == 1 && c.getLevelForXP(c.playerXP[5]) > 6 && c.playerLevel[5] > 0) {
c.setClientConfig(85, 0);
c.AtkPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21239: //hawk eye
if(c.playerLevel[5] == 0){
c.setClientConfig(89, 0);
c.StrPrayer = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.DefPray = 0;
c.StrPrayer = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 19){
c.setClientConfig(89, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 19 to use Hawk Eye.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 19 to use this."); 
}
if(c.RangePray != 5 && c.getLevelForXP(c.playerXP[5]) > 18 && c.playerLevel[5] > 0)
{
c.StrPrayer = 0;
c.AtkPray = 0;
c.MagePray = 0;
c.Chivalry = false;
c.Piety = false;
    c.setClientConfig(84, 0);
    c.setClientConfig(87, 0);
    c.setClientConfig(90, 0);
    c.setClientConfig(93, 0);
    c.setClientConfig(85, 0);
    c.setClientConfig(88, 0);
    c.setClientConfig(94, 0);
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.RangePray = 5;
c.praydrain = 4;
c.prayOn = true;
} else if(c.RangePray == 5 && c.getLevelForXP(c.playerXP[5]) > 18 && c.playerLevel[5] > 0) {
c.setClientConfig(89, 0);
c.RangePray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21240: //mystic lore
if(c.playerLevel[5] == 0){
c.setClientConfig(90, 0);
c.StrPrayer = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 0;
c.DefPray = 0;
c.StrPrayer = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 22){
c.setClientConfig(90, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 22 to use Mystic lore.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 22 to use this."); 
}
if(c.MagePray != 5 && c.getLevelForXP(c.playerXP[5]) > 21 && c.playerLevel[5] > 0)
{
c.StrPrayer = 0;
c.AtkPray = 0;
c.RangePray = 0;
c.Chivalry = false;
c.Piety = false;
    c.setClientConfig(84, 0);
    c.setClientConfig(87, 0);
    c.setClientConfig(89, 0);
    c.setClientConfig(93, 0);
    c.setClientConfig(85, 0);
    c.setClientConfig(88, 0);
    c.setClientConfig(94, 0);
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.MagePray = 5;
c.praydrain = 4;
c.prayOn = true;
} else if(c.MagePray == 5 && c.getLevelForXP(c.playerXP[5]) > 21 && c.playerLevel[5] > 0) {
c.setClientConfig(90, 0);
c.MagePray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21238: // improved reflexes
if(c.playerLevel[5] == 0){
c.setClientConfig(88, 0);
c.AtkPray = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.StrPrayer = 0;
c.DefPray = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 16){
c.setClientConfig(88, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 16 to use Improved Reflexes.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 16 to use this."); 
}
if(c.AtkPray != 2 && c.getLevelForXP(c.playerXP[5]) > 15 && c.playerLevel[5] > 0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 2;
c.praydrain = 4;
c.setClientConfig(85, 0);
c.setClientConfig(94, 0);
c.setClientConfig(89, 0);
c.setClientConfig(90, 0);
c.prayOn = true;
} else if(c.AtkPray == 2 && c.getLevelForXP(c.playerXP[5]) > 15 && c.playerLevel[5] > 0) {
c.setClientConfig(88, 0);
c.AtkPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21244: // incredible reflexes
if(c.playerLevel[5] == 0){
c.setClientConfig(94, 0);
c.AtkPray = 0;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.Chivalry || c.Piety){
c.Chivalry = false;
c.Piety = false;
c.StrPrayer = 0;
c.DefPray = 0;
}
if(c.getLevelForXP(c.playerXP[5]) < 34){
c.setClientConfig(94, 0);
//c.checkHead();
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 34 to use Incredible Reflexes.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 34 to use this."); 
}
if(c.AtkPray != 3 && c.getLevelForXP(c.playerXP[5]) > 33 && c.playerLevel[5] >  0)
{
c.setClientConfig(101, 0);
c.setClientConfig(102, 0);
c.Chivalry = false;
c.Piety = false;
c.AtkPray = 3;
c.praydrain = 4;
c.setClientConfig(85, 0);
c.setClientConfig(88, 0);
c.setClientConfig(89, 0);
c.setClientConfig(90, 0);
c.prayOn = true;
} else if(c.AtkPray == 3 && c.getLevelForXP(c.playerXP[5]) > 33 && c.playerLevel[5] > 0) {
c.setClientConfig(94, 0);
c.AtkPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21245: // Protect From Magic
if(c.playerLevel[5] == 0){
    c.setClientConfig(95, 0);
c.ProtMage = false;
c.checkHead();
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 37){
c.setClientConfig(95, 0);
c.sendFrame126("You need a @blu@Prayer level of 37 to use Protect from Magic.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 37 to use this."); 
}
if(c.ProtMage == false && c.getLevelForXP(c.playerXP[5]) > 36 && c.playerLevel[5] > 0)
{
c.ProtMage = true;
c.ProtMelee = false;
c.ProtRange = false;
c.Retribution = false;
c.Redemption = false;
c.Smite = false;
c.praydrain = 4;
    c.setClientConfig(96, 0);
    c.setClientConfig(97, 0);
    c.setClientConfig(98, 0);
    c.setClientConfig(99, 0);
    c.setClientConfig(100, 0);
c.getHead();
c.prayOn = true;
} else if(c.ProtMage == true && c.getLevelForXP(c.playerXP[5]) > 36 && c.playerLevel[5] > 0) {
    c.setClientConfig(95, 0);
c.ProtMage = false;
c.checkHead();
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21246: // Protect From Range
if(c.playerLevel[5] == 0){
    c.setClientConfig(96, 0);
c.ProtRange = false;
c.checkHead();
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 40){
c.setClientConfig(96, 0);
c.sendFrame126("You need a @blu@Prayer level of 40 to use Protect from Range.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 40 to use this."); 
}
if(c.ProtRange == false && c.getLevelForXP(c.playerXP[5]) > 39 && c.playerLevel[5] > 0)
{
c.headIcon = 2;
c.ProtRange = true;
c.ProtMage = false;
c.ProtMelee = false;
c.Retribution = false;
c.Redemption = false;
c.Smite = false;
c.praydrain = 4;
    c.setClientConfig(95, 0);
    c.setClientConfig(97, 0);
    c.setClientConfig(98, 0);
    c.setClientConfig(99, 0);
    c.setClientConfig(100, 0);
c.getHead();
c.prayOn = true;
} else if(c.ProtRange == true && c.getLevelForXP(c.playerXP[5]) > 39 && c.playerLevel[5] > 0) {
    c.setClientConfig(96, 0);
c.ProtRange = false;
c.checkHead();
c.praydrain = 0;
c.prayOn = false;
}
break;
case 21247: // Protect From Melee
if(c.playerLevel[5] == 0){
    c.setClientConfig(97, 0);
c.ProtMelee = false;
c.checkHead();
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 43){
c.setClientConfig(97, 0);
c.sendFrame126("You need a @blu@Prayer level of 43 to use Protect from Melee.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 43 to use this."); 
}
if(c.ProtMelee == false && c.getLevelForXP(c.playerXP[5]) > 42 && c.playerLevel[5] > 0)
{
c.headIcon = 1;
c.ProtMelee = true;
c.ProtMage = false;
c.ProtRange = false;
c.Retribution = false;
c.Redemption = false;
c.Smite = false;
c.praydrain = 4;
    c.setClientConfig(95, 0);
    c.setClientConfig(96, 0);
    c.setClientConfig(98, 0);
    c.setClientConfig(99, 0);
    c.setClientConfig(100, 0);
c.prayOn = true;
c.getHead();
} else if(c.ProtMelee == true && c.getLevelForXP(c.playerXP[5]) > 42 && c.playerLevel[5] > 0) {
c.setClientConfig(97, 0);
c.ProtMelee = false;
c.checkHead();
c.praydrain = 0;
c.prayOn = false;
}
break;
case 2171: //c.Retribution
if(c.playerLevel[5] == 0){
    c.setClientConfig(98, 0);
c.Retribution = false;
c.checkHead();
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 46){
c.setClientConfig(98, 0);
c.sendFrame126("You need a @blu@Prayer level of 46 to use Retribution.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 46 to use this."); 
}
if(c.Retribution == false && c.getLevelForXP(c.playerXP[5]) > 45 && c.playerLevel[5] > 0)
{
c.headIcon = 8;
c.ProtMelee = false;
c.ProtMage = false;
c.ProtRange = false;
c.Retribution = true;
c.Redemption = false;
c.Smite = false;
c.praydrain = 50;
    c.setClientConfig(95, 0);
    c.setClientConfig(96, 0);
    c.setClientConfig(97, 0);
    c.setClientConfig(99, 0);
    c.setClientConfig(100, 0);
c.prayOn = true;
c.getHead();
} else if(c.Retribution == true && c.getLevelForXP(c.playerXP[5]) > 45 && c.playerLevel[5] > 0) {
    c.setClientConfig(98, 0);
c.Retribution = false;
c.checkHead();
c.praydrain = 0;
c.prayOn = false;
}
break;
case 2172: //redemption
if(c.playerLevel[5] == 0){
    c.setClientConfig(99, 0);
c.Redemption = false;
c.checkHead();
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 49){
c.setClientConfig(99, 0);
c.sendFrame126("You need a @blu@Prayer level of 49 to use Redemption.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 49 to use this."); 
}
if(c.Redemption == false && c.getLevelForXP(c.playerXP[5]) > 48 && c.playerLevel[5] > 0)
{
c.headIcon = 32;
c.ProtMelee = false;
c.ProtMage = false;
c.ProtRange = false;
c.Retribution = false;
c.Redemption = true;
c.Smite = false;
c.praydrain = 50;
    c.setClientConfig(95, 0);
    c.setClientConfig(96, 0);
    c.setClientConfig(97, 0);
    c.setClientConfig(98, 0);
    c.setClientConfig(100, 0);
c.prayOn = true;
c.getHead();
} else if(c.Redemption == true && c.getLevelForXP(c.playerXP[5]) > 48 && c.playerLevel[5] > 0) {
    c.setClientConfig(99, 0);
c.Redemption = false;
c.checkHead();
c.praydrain = 0;
c.prayOn = false;
}
break;
case 2173: //Smite
if(c.playerLevel[5] == 0){
c.setClientConfig(100, 0);
c.Smite = false;
c.checkHead();
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 52){
c.setClientConfig(100, 0);
c.Smite = false;
c.headIcon = 0;
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 52 to use Smite.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 52 to use this."); 
}
if(c.Smite == false && c.getLevelForXP(c.playerXP[5]) > 51 && c.playerLevel[5] > 0)
{
c.headIcon = 16;
c.Smite = true;
c.ProtMelee = false;
c.ProtMage = false;
c.ProtRange = false;
c.Retribution = false;
c.Redemption = false;
c.praydrain = 4;
    c.setClientConfig(95, 0);
    c.setClientConfig(96, 0);
    c.setClientConfig(97, 0);
    c.setClientConfig(98, 0);
    c.setClientConfig(99, 0);
c.prayOn = true;
c.getHead();
} else if(c.Smite == true && c.getLevelForXP(c.playerXP[5]) > 51 && c.playerLevel[5] > 0) {
    c.setClientConfig(100, 0);
c.Smite = false;
c.checkHead();
c.praydrain = 0;
c.prayOn = false;
}
break;
case 74096: //Chivalry
if(c.playerLevel[5] == 0){
c.setClientConfig(101, 0);
c.Chivalry = false;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 60){
c.setClientConfig(101, 0);
c.Chivalry = false;
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 60 to use Chivalry.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 60 and a Defence level of 65 to use this."); 
}
if(c.getLevelForXP(c.playerXP[1]) < 65){
c.sM("You must have 65 defence to use this prayer.");
c.setClientConfig(101, 0);
}
if(c.q9 != 15){
c.sM("You must have finished Knight's Legend to use this prayer.");
c.setClientConfig(101, 0);
break;
}
if(c.Chivalry == false && c.getLevelForXP(c.playerXP[5]) > 59 && c.playerLevel[5] > 0)
{
c.Piety = false;
c.Chivalry = true;
c.StrPrayer = 5;
c.AtkPray = 7;
c.DefPray = 7; 
c.RangePray = 0;
c.MagePray = 0;
c.praydrain = 4;
    c.setClientConfig(89, 0);
    c.setClientConfig(90, 0);
    c.setClientConfig(83, 0);
    c.setClientConfig(86, 0);
    c.setClientConfig(92, 0);
    c.setClientConfig(84, 0);
    c.setClientConfig(87, 0);
    c.setClientConfig(93, 0);
    c.setClientConfig(85, 0);
    c.setClientConfig(88, 0);
    c.setClientConfig(94, 0);
    c.setClientConfig(102, 0);
c.prayOn = true;
} else if(c.Chivalry == true && c.getLevelForXP(c.playerXP[5]) > 59 && c.playerLevel[5] > 0) {
    c.setClientConfig(101, 0);
c.Chivalry = false;
c.AtkPray = 0;
c.StrPrayer = 0;
c.DefPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
case 74102: //Piety
if(c.playerLevel[5] == 0){
c.setClientConfig(102, 0);
c.Piety = false;
c.prayOn = false;
c.sM("You need to recharge your Prayer at an altar.");
}
if(c.getLevelForXP(c.playerXP[5]) < 70){
c.setClientConfig(102, 0);
c.Piety = false;
c.prayOn = false;
c.sendFrame126("You need a @blu@Prayer level of 70 to use Piety.", 357);
c.sendFrame164(356);
c.sM("You need a Prayer level of 70 and a Defence level of 70 to use this."); 
}
if(c.getLevelForXP(c.playerXP[1]) < 70){
c.sM("You must have 70 defence to use this prayer.");
c.setClientConfig(102, 0);
}
if(c.q9 != 15){
c.sM("You must have finished Knight's Legend to use this prayer.");
c.setClientConfig(102, 0);
break;
}
if(c.Piety == false && c.getLevelForXP(c.playerXP[5]) > 69 && c.playerLevel[5] > 0)
{
c.Chivalry = false;
c.Piety = true;
c.StrPrayer = 7;
c.AtkPray = 10;
c.DefPray = 10; 
c.RangePray = 0;
c.MagePray = 0;
c.praydrain = 4;
    c.setClientConfig(89, 0);
    c.setClientConfig(90, 0);
    c.setClientConfig(83, 0);
    c.setClientConfig(86, 0);
    c.setClientConfig(92, 0);
    c.setClientConfig(84, 0);
    c.setClientConfig(87, 0);
    c.setClientConfig(93, 0);
    c.setClientConfig(85, 0);
    c.setClientConfig(88, 0);
    c.setClientConfig(94, 0);
    c.setClientConfig(101, 0);
c.prayOn = true;
} else if(c.Piety == true && c.getLevelForXP(c.playerXP[5]) > 69 && c.playerLevel[5] > 0) {
    c.setClientConfig(102, 0);
c.Piety = false;
c.AtkPray = 0;
c.StrPrayer = 0;
c.DefPray = 0;
c.praydrain = 0;
c.prayOn = false;
}
break;
			case 73148:
			case 4146: 
				c.triggerTele(2757, 3477, 0);
				break;
			case 50253:
				c.triggerTele(2870, 3589, 0);
				break;
			case 73136:
			case 4143:
			case 50245: // edgeville teleport 
				c.teleEffect = 1;
				c.sendQuest("Which wild zone?", 2470);
				c.sendQuest("Edgeville", 2471);
				c.sendQuest("Varrock", 2472);
				c.sendQuest("Mage bank", 2473);
				c.sendFrame164(2469);
				break;
			case 4150: // catherby teleport 
				c.triggerTele(2809, 3439, 0);
				break;
			case 73144:
			case 51005: // catherby teleport 
				c.triggerTele(2809, 3439, 0);
				break;
			case 73120:
			case 6004: // training teleport
    c.sendQuest("Rock crabs", 15240);
    c.sendQuest("Dagg lair", 15241);
    c.sendQuest("Island", 15239);
    c.sendQuest("Cave", 15243);
    c.sendQuest("Slayer tower", 15242);
    c.setSidebarInterface(6, 3209); // magic tab (ancient = 12855)
    c.interfaceGame = 1;
				break;
			case 51013: // training teleport
    c.sendQuest("Rock crabs", 15240);
    c.sendQuest("Dagg lair", 15241);
    c.sendQuest("Island", 15239);
    c.sendQuest("Cave", 15243);
    c.sendQuest("Slayer tower", 15242);
    c.setSidebarInterface(6, 3209); // magic tab (ancient = 12855)
    c.interfaceGame = 1;
				break;
			case 73116:
			case 6005: // training teleport
    c.sendQuest("Barrows", 15240);
    c.sendQuest("Fight pits", 15241);
    c.sendQuest("Pest ctrl", 15239);
    c.sendQuest("Assault", 15243);
    c.sendQuest("", 15242);
    c.setSidebarInterface(6, 3209); // magic tab (ancient = 12855)
    c.interfaceGame = 2;
				break;
			case 51023: // training teleport
    c.sendQuest("Barrows", 15240);
    c.sendQuest("Fight pits", 15241);
    c.sendQuest("Pest ctrl", 15239);
    c.sendQuest("Assault", 15243);
    c.sendQuest("", 15242);
    c.setSidebarInterface(6, 3209); // magic tab (ancient = 12855)
    c.interfaceGame = 2;
				break;
			case 26076:
				// frame36(6575, 1);
				break;
			case 53245:
				// frame36(13813, 1);
				break;

			
			case 10252:
			case 11000:
			case 10253:
			case 11001:
			case 10254:
			case 10255:
			case 11002:
			case 11011:
			case 11013:
			case 11014:
			case 11010:
			case 11012:
			case 11006:
			case 11009:
			case 11008:
			case 11004:
			case 11003:
			case 11005:
			case 47002:
			case 54090:
			case 11007:
				if (c.randomed && (c.actionButtonId == c.statId[c.random_skill])) {
					c.randomed = false;
					c.closeInterface();
				}
				break;
			case 14067:
				c.appearanceUpdateRequired = true;
				c.updateRequired = true;
				c.closeInterface();
				c.RemoveAllWindows();
				break;

			case 153:
				if (c.playerEnergy > 0) {
					c.isRunning2 = true;
					c.isRunning = true;
				}
				break;
			case 152:
				c.isRunning2 = false;
				c.isRunning = false;
				break;

			case 130:
				// close interface
				c.println_debug("Closing Interface");
				break;
			case 33018:
				// jab (hally)
			case 9125:
				// Accurate
			case 22228:
				// punch (unarmed)
			case 48010:
				// flick (whip)
			case 21200:
				// spike (pickaxe)
			case 1080:
				// bash (staff)
			case 6168:
				// chop (axe)
			case 6236:
				// accurate (long bow)
			case 17102:
				// accurate (darts)
			case 8234:
				// stab (dagger)
				c.FightType = 1;
				c.SkillID = 0;
				break;

			case 9126:
				// Defensive
			case 48008:
				// deflect (whip)
			case 22229:
				// block (unarmed)
			case 21201:
				// block (pickaxe)
			case 1078:
				// focus - block (staff)
			case 6169:
				// block (axe)
			case 18078:
				// block (spear)
			case 8235:
				// block (dagger)
				c.FightType = 4;
				c.SkillID = 1;
				break;
			case 33019:
				// fend (hally)
			case 9127:
				// Controlled
			case 48009:
				// lash (whip)
			case 6234:
				// longrange (long bow)
			case 18077:
				// lunge (spear)
			case 18080:
				// swipe (spear)
			case 18079:
				// pound (spear)
			case 17100:
				// longrange (darts)
				c.FightType = 3;
				c.SkillID = 3;
				break;

			case 9128:
				// Aggressive
			case 22230:
				// kick (unarmed)
			case 21203:
				// impale (pickaxe)
			case 21202:
				// smash (pickaxe)
			case 1079:
				// pound (staff)
			case 6171:
				// hack (axe)
			case 6170:
				// smash (axe)
			case 33020:
				// swipe (hally)
			case 6235:
				// rapid (long bow)
			case 17101:
				// repid (darts)
			case 8237:
				// lunge (dagger)
			case 8236:
				// slash (dagger)
				c.FightType = 2;
				c.SkillID = 2;
				break;

			case 21011:
				c.takeAsNote = false;
				break;

			case 21010:
				c.takeAsNote = true;
				break;


			case 13092:
				if (System.currentTimeMillis() - c.lastButton < 400) {
					c.lastButton = System.currentTimeMillis();
					break;
				} else {
					c.lastButton = System.currentTimeMillis();
				}
				if (c.inTrade && !c.tradeConfirmed) {
					c.lastButton = System.currentTimeMillis();
					client other = c.getClient(c.trade_reqId);
					c.tradeConfirmed = true;
other.TradeLogout = 30;
c.TradeLogout = 30;
					if (other.tradeConfirmed) {
other.TradeLogout = 30;
c.TradeLogout = 30;
						c.confirmScreen();
						other.confirmScreen();
						break;
					}
					c.sendFrame126("Waiting for other player...", 3431);
					if (c.validClient(c.trade_reqId)) {
						other.sendFrame126("Other player has accepted", 3431);
					}
				}
				break;

			case 13218:
				client other = c.getClient(c.trade_reqId);
				if (!c.validClient(c.trade_reqId))
					break;
				if (System.currentTimeMillis() - c.lastButton < 1000) {
					c.lastButton = System.currentTimeMillis();
					break;
				} else {
					c.lastButton = System.currentTimeMillis();
				}
				c.lastButton = System.currentTimeMillis();
				if (c.inTrade && c.tradeConfirmed && other.tradeConfirmed
						&& !c.tradeConfirmed2) {
					c.lastButton = System.currentTimeMillis();
					c.tradeConfirmed2 = true;
other.TradeLogout = 30;
c.TradeLogout = 30;
					c.actionInterval = 10000;
					c.lastAction = System.currentTimeMillis();
					if (other.tradeConfirmed2) {
other.TradeLogout = 30;
c.TradeLogout = 30;
						c.giveItems();
						other.giveItems();
						c.savegame(false);
						other.savegame(false);
						c.sM("Accepted trade.");
						other.sM("Accepted trade.");
						break;
					}
					other.sendQuest("Other player has accepted.", 3535);
					c.sendQuest("Waiting for other player...", 3535);
				}
				break;

case 1097:
	    if(c.playerAncientMagics == 0 && c.playerEquipment[c.playerWeapon] == 4675)
	    {
		c.sM("You cannot auto cast normal magics with an ancient staff!");
		break;
	    }
	    if(c.playerAncientMagics == 1 && c.playerEquipment[c.playerWeapon] != 4675)
	    {
		c.sM("You cannot auto cast ancient magics with a regular staff!");
		break;
	    }
	    if(c.playerAncientMagics == 2)
	    {
		c.sM("You cannot auto cast lunar magics");
		break;
	    }
            if(c.playerEquipment[c.playerWeapon] == 4675)
            {
                c.setSidebarInterface(0, 1689);
            } else
            {
                c.setSidebarInterface(0, 1829);
            }
break;

case 1093:
if(c.autocastID == 0){
c.sM("You must choose a spell first.");
break;
}
if(!c.autocasting){
c.autocasting = true;
c.setClientConfig(108, 1);
break;
}
if(c.autocasting){
c.autocasting = false;
c.setClientConfig(108, 0);
break;
}
break;


        case 51133: 
            c.autocastID = 12939;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51185: 
            c.autocastID = 12987;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51091: 
            c.autocastID = 12901;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 24018: 
            c.autocastID = 12861;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51159: 
            c.autocastID = 12963;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51211: 
            c.autocastID = 13011;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51111: 
            c.autocastID = 12919;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51069: 
            c.autocastID = 12881;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51146: 
            c.autocastID = 12951;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51198: 
            c.autocastID = 12999;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51102: 
            c.autocastID = 12911;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51058: 
            c.autocastID = 12871;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51172: 
            c.autocastID = 12975;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51224: 
            c.autocastID = 13023;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51122: 
            c.autocastID = 12929;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 51080: 
            c.autocastID = 12891;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7038: 
            c.autocastID = 1152;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7039: 
            c.autocastID = 1154;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7040: 
            c.autocastID = 1156;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7041: 
            c.autocastID = 1158;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7042: 
            c.autocastID = 1160;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7043: 
            c.autocastID = 1163;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7044: 
            c.autocastID = 1166;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7045: 
            c.autocastID = 1169;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7046: 
            c.autocastID = 1172;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7047: 
            c.autocastID = 1175;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7048: 
            c.autocastID = 1177;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7049: 
            c.autocastID = 1181;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7050: 
            c.autocastID = 1183;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7051: 
            c.autocastID = 1185;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7052: 
            c.autocastID = 1188;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7053: 
            c.autocastID = 1189;
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;

        case 7212: 
        case 24017: 
	    c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
	    c.setSidebarInterface(0, 328);
            break;
}
}
}