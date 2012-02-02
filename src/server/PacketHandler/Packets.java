package server.PacketHandler;

import server.Player;
import server.client;
import server.misc;
import server.NPCHandler;
import server.server;
import server.PlayerHandler;
import server.Item;
import server.PlayerActions.Banking;
import server.*;


public class Packets {
client c;


public Packets(client client) {
		this.c = client;
	}

public Packets() {
	// TODO Auto-generated constructor stub
}

public void parseIncomingPackets() {
		int i;
		int junk;
		int junk2;
		int junk3;
		c.lastPacket = System.currentTimeMillis();
		// if(packetType != 0) c.println("" + packetType);
		switch (c.packetType) {
		case 25:
			// item in inventory used with item on floor
			int unknown1 = c.inStream.readSignedWordBigEndian(); // interface id
			// of item
			int unknown2 = c.inStream.readUnsignedWordA(); // item in bag id
			int floorID = c.inStream.readUnsignedByte();
			int floorY = c.inStream.readUnsignedWordA();
			int unknown3 = c.inStream.readUnsignedWordBigEndianA();
			int floorX = c.inStream.readUnsignedByte();
			System.out.println("Unknown1 = " + unknown1);
			System.out.println("Unknown2 = " + unknown2);
			System.out.println("FloorID = " + floorID);
			System.out.println("FloorY = " + floorY);
			System.out.println("Unknown3 = " + unknown3);
			System.out.println("FloorX = " + floorX);
			break;
		case 57:
			int aA1 = c.inStream.readSignedWordBigEndianA();
			int b1 = c.inStream.readSignedWordBigEndianA();
			int c1 = c.inStream.readSignedWordBigEndian();
			int d1 = c.inStream.readSignedWordBigEndianA();
			break;
		case 0:
			break; // idle packet - keeps on reseting timeOutCounter
		case 202:
			// idle logout packet
		case 45:
			// flagged account data
			// inStream.readBytes(pmchatText, pmchatTextSize, 0);
			int blah = c.inStream.readUnsignedByte();
			int part2 = -1,
			part3 = -1,
			part4 = -1;
			try {
				part2 = c.inStream.readUnsignedWord();
			} catch (Exception e) {
				c.println("part2 not sent");
			}
			// if(part2 == -1){ //exect input (client if/else)
			try {
				part3 = c.inStream.readDWord_v1();
			} catch (Exception e) {
				c.println("part3 not sent");
			}
			try {
				part4 = c.inStream.readDWord();
			} catch (Exception e) {
				c.println("part4 not sent");
			}
			// }
			//println("blah=" + blah + ", " + "part2=" + part2 + ", part3="
					//+ part3 + ", part4=" + part4);
			break;

		case 210:
			// loads new area
			break;

		case 40:
			if (c.NpcDialogue == 1 || c.NpcDialogue == 2|| c.NpcDialogue == 3 || c.NpcDialogue == 4  || c.NpcDialogue == 5  || c.NpcDialogue == 6  || c.NpcDialogue == 8 || c.NpcDialogue == 10 || c.NpcDialogue == 13 || c.NpcDialogue == 16 || c.NpcDialogue == 18 || c.NpcDialogue == 19 || c.NpcDialogue == 21 || c.NpcDialogue == 22 || c.NpcDialogue == 23 || c.NpcDialogue == 27 || c.NpcDialogue == 28 || c.NpcDialogue == 30 || c.NpcDialogue == 31 || c.NpcDialogue == 32 || c.NpcDialogue == 34 || c.NpcDialogue == 37 || c.NpcDialogue == 41 || c.NpcDialogue == 42 || c.NpcDialogue == 44 || c.NpcDialogue == 45 || c.NpcDialogue == 48 || c.NpcDialogue == 49 || c.NpcDialogue == 50 || c.NpcDialogue == 52 || c.NpcDialogue == 54 || c.NpcDialogue == 57 || c.NpcDialogue == 60 || c.NpcDialogue == 64 || c.NpcDialogue == 65 || c.NpcDialogue == 66 || c.NpcDialogue == 73 || c.NpcDialogue == 75 || c.NpcDialogue == 77 || c.NpcDialogue == 81 || c.NpcDialogue == 82 || c.NpcDialogue == 83 || c.NpcDialogue == 85 || c.NpcDialogue == 87 || c.NpcDialogue == 91 || c.NpcDialogue == 89 || c.NpcDialogue == 90 || c.NpcDialogue == 91 || c.NpcDialogue == 92 || c.NpcDialogue == 95 || c.NpcDialogue == 96 || c.NpcDialogue == 97 || c.NpcDialogue == 98 || c.NpcDialogue == 100 || c.NpcDialogue == 102 || c.NpcDialogue == 103 || c.NpcDialogue == 105 || c.NpcDialogue == 106 || c.NpcDialogue == 107 || c.NpcDialogue == 108 || c.NpcDialogue == 109 || c.NpcDialogue == 111 || c.NpcDialogue == 112 || c.NpcDialogue == 114 || c.NpcDialogue == 116) {
				c.NpcDialogue += 1;
				c.NpcDialogueSend = false;
			} else if (c.NpcDialogue == 15) {
				c.NpcDialogue = 0;
				c.NpcDialogueSend = false;
				c.RemoveAllWindows();
			} else {
				c.closeInterface();
			}
			if (c.NpcDialogue == 71) {
				c.NpcDialogue += 9;
				c.NpcDialogueSend = false;
			}
		
			if (c.NpcDialogue == 119) {
				c.openUpShop(41);
			}
		
			break;
		case 192:
			// Use an item on object
			junk = c.inStream.readSignedWordBigEndianA();
			int UsedOnObjectID = c.inStream.readUnsignedWordBigEndian();
			int UsedOnY = c.inStream.readSignedWordBigEndianA();
			int ItemSlot = (c.inStream.readSignedWordBigEndianA() - 128);
			int UsedOnX = c.inStream.readUnsignedWordBigEndianA();
			int ItemID = c.inStream.readUnsignedWord();
			if (!c.playerHasItem(ItemID))
				break;
			if (!c.antiHax())
				break;
			if (UsedOnObjectID == 3994) {
				for (int fi = 0; fi < misc.smelt_frame.length; fi++)
					c.sendFrame246(misc.smelt_frame[fi], 150, misc.smelt_bars[fi]);
				c.sendFrame164(2400);
				// smelting = true;
				// smelt_id = ItemID;
			}
if(UsedOnObjectID == 10638){
if(ItemID == 526){
	c.deleteItem(526, 1);
	c.addSkillXP(40*c.getLevelForXP(c.playerXP[5]), 5);
c.sM("You receive some prayer experience.");
c.setAnimation(894);
c.lowGFX(247,0);
}
if(ItemID == 532){
	c.deleteItem(532, 1);
	c.addSkillXP(80*c.getLevelForXP(c.playerXP[5]), 5);
	c.sM("You receive some prayer experience.");
	c.setAnimation(894);
	c.lowGFX(247,0);
}
if(ItemID == 536){
	c.deleteItem(536, 1);
	c.addSkillXP(160*c.getLevelForXP(c.playerXP[5]), 5);
c.sM("You receive some prayer experience.");
c.setAnimation(894);
c.lowGFX(247,0);
}
c.TurnPlayerTo(UsedOnX, UsedOnY);
}
if(UsedOnObjectID == 2644 && ItemID == 1737){
	c.deleteItem(1737, 1);
	c.addItem(1759, 1);
	c.setAnimation(894);
}
		if ((UsedOnObjectID == 2781) || (UsedOnObjectID == 2728)) {
				// furnace, range
				if ( /* CheckForSkillUse2(ItemID, ItemSlot) == */true) {
					c.cookingOn = true;
				}
}
			break;
			case 218:

			String abuser = misc.longToPlayerName(c.inStream.readQWord());
			int rule = c.inStream.readUnsignedByte();
			int mute = c.inStream.readUnsignedByte();
			c.reportAbuse(abuser, rule, mute);
			break;
		case 130:
			// Clicking some stuff in game
			int interfaceID = c.inStream.readSignedByte();
			// if(actionButtonId == 26018) {
			if (c.inTrade && (System.currentTimeMillis() - c.lastButton > 1000)) {
				c.lastButton = System.currentTimeMillis();
				c.getClient(c.trade_reqId).sM("Other player has declined the trade.");
				c.declineTrade();
			}
			if (c.IsShopping == true) {
				c.IsShopping = false;
				c.MyShopID = 0;
				c.UpdateShop = false;
			}
			if (c.IsBanking == true) {
				c.IsBanking = false;
			}

			if ((misc.HexToInt(c.inStream.buffer, 0, c.packetSize) != 63363)
					&& (misc.HexToInt(c.inStream.buffer, 0, c.packetSize) != 0)) {
				c.println_debug("handled packet [" + c.packetType
						+ ", InterFaceId: " + interfaceID + ", size="
						+ c.packetSize + "]: ]"
						+ misc.Hex(c.inStream.buffer, 1, c.packetSize) + "[");
				c.println_debug("Action Button: "
						+ misc.HexToInt(c.inStream.buffer, 0, c.packetSize));
			}
			break;

			
		case 155:
			// first Click npc
			c.NPCSlot = c.inStream.readSignedWordBigEndian();
			if ((c.NPCSlot < 0) || (c.NPCSlot >= server.npcHandler.npcs.length)
					|| (server.npcHandler.npcs[c.NPCSlot] == null))
				break;
			c.NPCID = server.npcHandler.npcs[c.NPCSlot].npcType;
			boolean FishingGo = false;
			boolean PutNPCCoords = false;
			if (misc.random(100) == 1) {
				c.triggerRandom();
				break;
			}
			if (!c.antiHax())
				break;


			if (c.NPCID == 316) {
				/* Net From Net & Bait - Any Sea */
				if ((c.IsItemInBag(303) == true)) {
					//startFishing(316);
				} else {
					c.sM("You need a " + c.getItemName(303)
							+ " to fish here.");
				}
			} else if (c.NPCID == 321) {
				//startFishing(321);
			} else if (c.NPCID == 322) {
				//startFishing(322);
			} else if (c.NPCID == 323) {
				//startFishing(323);

			} else {
				c.faceNPC(c.NPCSlot);
			}
			if (PutNPCCoords == true) {
				c.skillX = server.npcHandler.npcs[c.NPCSlot].absX;
				c.skillY = server.npcHandler.npcs[c.NPCSlot].absY;
			}
			break;

		case 17:
			// second Click npc
			c.NPCSlot = c.inStream.readUnsignedWordBigEndianA();
			if ((c.NPCSlot < 0) || (c.NPCSlot >= server.npcHandler.npcs.length)
					|| (server.npcHandler.npcs[c.NPCSlot] == null))
				break;
			c.NPCID = server.npcHandler.npcs[c.NPCSlot].npcType;
			long time = System.currentTimeMillis();
			if (misc.random(100) == 1) {
				c.triggerRandom();
				break;
			}
			if (time - c.globalCooldown[0] <= 50) {
				c.sM("Action throttled... please wait longer before acting!");
				break;
			}
			if (time - c.lastMouse > 5000) {
				//sM("Client hack detected!");
				c.println("Suspicious activity!");
				c.disconnected = true;
				break;
			}
			if(c.action == 1){
				c.sM("Suspicious activity!");			
				break;
			}

			c.globalCooldown[0] = time;
			int npcX = server.npcHandler.npcs[c.NPCSlot].absX;
			int npcY = server.npcHandler.npcs[c.NPCSlot].absY;
			if ((Math.abs(c.absX - npcX) > 50) || (Math.abs(c.absY - npcY) > 50)) {
				//sM("Client hack detected!");
				break;
			}
			if (server.npcHandler.npcs[c.NPCSlot].IsDead) {
				//sM("That monster has been killed!");
				break;
			}
			FishingGo = false;
			PutNPCCoords = false;

if(c.NPCID == 1){
//robPerson("man", 995, 105, 29, 1);
}
if(c.NPCID == 9){
//robPerson("guard", 995, 272, 48, 15);
}
if(c.NPCID == 23){
//robPerson("knight", 995, 440, 102, 30);
}
if(c.NPCID == 21){
//robPerson("hero", 995, 760, 120, 60);
}
if(c.NPCID == 66){
//robPerson("gnome", 995, 1200, 150, 80);




			} else {
				c.faceNPC(c.NPCSlot);
			}
			if (PutNPCCoords == true) {
				c.skillX = server.npcHandler.npcs[c.NPCSlot].absX;
				c.skillY = server.npcHandler.npcs[c.NPCSlot].absY;
			}

			break;

		case 21:
			// third Click npc
			c.NPCSlot = c.inStream.readSignedWord();

			c.NPCID = server.npcHandler.npcs[c.NPCSlot].npcType;
			if ((c.NPCID < server.npcHandler.npcs.length) && (c.NPCID > 0)) {
	if(c.NPCID == 1526){
		c.openUpShop(19);
	} else {
		c.faceNPC(c.NPCSlot);
				}
			}
			break;

		case 72:
			// Click to attack
			if (!c.antiHax())
				break;
			if (c.deathStage < 1) {
				c.attacknpc = c.inStream.readUnsignedWordA();
		boolean UseBow = false;
		if (c.playerEquipment[c.playerWeapon] == 839 || c.playerEquipment[c.playerWeapon] == 841 || c.playerEquipment[c.playerWeapon] == 843 ||  c.playerEquipment[c.playerWeapon] == 845 ||  c.playerEquipment[c.playerWeapon] == 847 ||  c.playerEquipment[c.playerWeapon] == 849 || c.playerEquipment[c.playerWeapon] == 851 ||  c.playerEquipment[c.playerWeapon] == 853 || c.playerEquipment[c.playerWeapon] == 855 ||  c.playerEquipment[c.playerWeapon] == 857 ||  c.playerEquipment[c.playerWeapon] == 837 || c.playerEquipment[c.playerWeapon] == 861 || c.playerEquipment[c.playerWeapon] == 4734 || c.playerEquipment[c.playerWeapon] == 859 || c.playerEquipment[c.playerWeapon] == 4827 || c.hasCrystalBow() || c.playerEquipment[c.playerWeapon] == 6522 || c.playerEquipment[c.playerWeapon] == 1381 || c.playerEquipment[c.playerWeapon] == 1383 || c.playerEquipment[c.playerWeapon] == 1385 || c.playerEquipment[c.playerWeapon] == 1387 || c.playerEquipment[c.playerWeapon] == 4675) {
			UseBow = true;
		}
if(server.npcHandler.npcs[c.attacknpc].hitIDNPC != 0 && server.npcHandler.npcs[c.attacknpc].hitIDNPC != c.playerId && !c.multiCombat()){
	c.sM("Someone else is already fighting your opponent.");
	c.faceNPC(c.attacknpc);
break;
}
if(c.hitID != c.attacknpc && c.hitID != 0 && !c.multiCombat()){
	c.sM("I'm already under attack.");
	c.faceNPC(c.attacknpc);
break;
}
if(server.npcHandler.npcs[c.attacknpc].npcType == 655 && c.q1 != 2)
break;
if(server.npcHandler.npcs[c.attacknpc].npcType == 757 && !c.playerHasItem(1550, 1)){
	c.sM("The vampire is not effected by your attacks.");
break;}
if(server.npcHandler.npcs[c.attacknpc].npcType == 757 && c.q4 != 1)
break;
if(server.npcHandler.npcs[c.attacknpc].npcType == 1472 && c.q5 != 3)
break;
if(server.npcHandler.npcs[c.attacknpc].npcType == 84 && c.q7 != 4)
break;
if(server.npcHandler.npcs[c.attacknpc].npcType == 2060 && c.q8 != 1)
break;
if(server.npcHandler.npcs[c.attacknpc].npcType == 988 && c.q9 != 2)
break;
if(server.npcHandler.npcs[c.attacknpc].npcType == 989 && c.q9 != 3){
	c.sM("You must beat the first knight first!");
break;
}
if(server.npcHandler.npcs[c.attacknpc].npcType == 990 && c.q9 != 4){
	c.sM("You must beat the second knight first!");
break;
}
if(UseBow){
	c.toX = c.absX;
	c.toY = c.absY;
	c.newWalkCmdSteps = 0;
	c.newWalkCmdX[0] = c.newWalkCmdY[0] = c.tmpNWCX[0] = c.tmpNWCY[0] = 0;
	c.getNextPlayerMovement();
}
if(!UseBow && server.npcHandler.npcs[c.attacknpc].npcType != 3777 &&  server.npcHandler.npcs[c.attacknpc].npcType != 3778 &&  server.npcHandler.npcs[c.attacknpc].npcType != 3779 &&  server.npcHandler.npcs[c.attacknpc].npcType != 3780 && server.npcHandler.npcs[c.attacknpc].npcType != 2627 && server.npcHandler.npcs[c.attacknpc].npcType != 2630 && server.npcHandler.npcs[c.attacknpc].npcType != 2631 && server.npcHandler.npcs[c.attacknpc].npcType != 2741 && server.npcHandler.npcs[c.attacknpc].npcType != 2743 && server.npcHandler.npcs[c.attacknpc].npcType != 2745 && server.npcHandler.npcs[c.attacknpc].npcType != 2746 && server.npcHandler.npcs[c.attacknpc].npcType != 2738){
	c.followID2 = c.attacknpc;
}
				if ((c.attacknpc >= 0)
						&& (c.attacknpc < server.npcHandler.maxNPCSpawns)) {
					c.IsAttackingNPC = true;

					if (server.npcHandler.npcs[c.attacknpc].StartKilling == 0) {
						server.npcHandler.npcs[c.attacknpc].StartKilling = c.playerId;
					}
					server.npcHandler.npcs[c.attacknpc].RandomWalk = false;
					server.npcHandler.npcs[c.attacknpc].IsUnderAttack = true;
					c.faceNPC(c.attacknpc);
				} else {
					c.sM("Exception catched, npc id was invalid.");
					//c.Resetattacknpc();
				}
			}
			break;

		case 121:
			//replaceDoors();
			// if(heightLevel == 1)
			// ReplaceObject(2591, 3107, 375, -3, 11);
			// we could use this to make the char appear for other players only
			// until
			// this guys loading is done. Also wait with regular player updates
			// until we receive this command.
			// println_debug("Loading finished.");
			c.Deleteobjects();
			c.NewObjects();
			c.hasntLoggedin = true;
			//server.checkPlayerCapes.processAll(this);
			if(!c.isInWilderness(c.absX, c.absY, 1)){
				c.setInterfaceWalkable(-1);
				c.hasWildySign = false;
			}
			break;

		case 122:
			// Call for burying bones
			junk = c.inStream.readSignedWordBigEndianA();
			ItemSlot = c.inStream.readUnsignedWordA();
			ItemID = c.inStream.readUnsignedWordBigEndian();
			c.actionInterval = c.getbattleTimer();
			c.lastAction = System.currentTimeMillis();
			server.ItemFunctions.buryItem(ItemID, ItemSlot, c.playerId);
			server.Herblore.HerbIdentify(c, ItemID, ItemSlot, c.playerId); // Herblore identifying
			break;


		case 53:
			// Use item on item
			int usedWithSlot = c.inStream.readUnsignedWord();
			int itemUsedSlot = c.inStream.readUnsignedWordA();
			// int useWith = inStream.readUnsignedWordBigEndianA();
			int interface1284 = c.inStream.readUnsignedWord();
			// int itemUsed = inStream.readSignedWordBigEndian();
			int interfacek = c.inStream.readUnsignedWord();
			// usedWithSlot += 1;
			// itemUsedSlot += 1;
			int useWith = c.playerItems[usedWithSlot] - 1;
			int itemUsed = c.playerItems[itemUsedSlot] - 1;
			if (!c.playerHasItem(itemUsed) || !c.playerHasItem(useWith)) {
				break;
			}
			int otherItem = c.playerItems[usedWithSlot] - 1;
			// println("itemUsed=" + itemUsed + ", usedWithSlot=" + usedWithSlot
			// + ", otherItem=" + otherItem);

			server.Herblore.UnfinishedPotion(c, itemUsed, otherItem);	 	// UnfinishedPotion
			server.Herblore.FinishedPotion(c, itemUsed, otherItem); 		// MakeFinishedPotion
			server.Herblore.Pestel(c, itemUsed, otherItem);				// Pestel
			


			break;

		// WalkTo commands
		case 248:
			// map walk (has additional 14 bytes added to the end with some junk
			// data)
			c.packetSize -= 14; // ignore the junk
		case 164:
			// regular walk
		case 98:
			// walk on command
			if(c.cookingOn){
				c.cookingOn = false;
			}
			if(c.followID > 0){
				c.followID = 0;
			}
			if(c.followID2 > 0){
				c.followID2 = 0;
			}
			if (c.randomed)
				break;
			if (!c.antiHax())
				break;
			if (c.inTrade)
				break;
			if(System.currentTimeMillis() - c.lastEntangle < c.entangleDelay) {
				c.sM("A magical force stops you from moving.");
				break;
			}
			if(System.currentTimeMillis() - c.lastWalk < c.walkDelay)
				break;
            		if (c.faceNPC > 0) {
            			c.faceNPC = 65535;
            			//c.faceNPCupdate = true;
           		 	}
            		c.resetAction();
			if (!c.validClient) {
				c.sM("You can't move on this account");
				break;
			}
			c.IsAttackingNPC = false;
			c.attacknpc = -1;
			c.closeInterface();
			c.resetAnimation();
			if (c.deathStage == 0) {
				c.newWalkCmdSteps = c.packetSize - 5;
				if (c.newWalkCmdSteps % 2 != 0) {
					c.println_debug("Warning: walkTo(" + c.packetType
							+ ") command malformed: "
							+ misc.Hex(c.inStream.buffer, 0, c.packetSize));
				}
				c.newWalkCmdSteps /= 2;
				if (++c.newWalkCmdSteps >c.walkingQueueSize) {
					c.println_debug("Warning: walkTo(" + c.packetType
							+ ") command contains too many steps ("
							+ c.newWalkCmdSteps + ").");
					c.newWalkCmdSteps = 0;
					break;
				}
				int firstStepX = c.inStream.readSignedWordBigEndianA();
				int tmpFSX = firstStepX;

				firstStepX -= c.mapRegionX * 8;
				for (i = 1; i < c.newWalkCmdSteps; i++) {
					c.newWalkCmdX[i] = c.inStream.readSignedByte();
					c.newWalkCmdY[i] = c.inStream.readSignedByte();
					c.tmpNWCX[i] = c.newWalkCmdX[i];
					c.tmpNWCY[i] = c.newWalkCmdY[i];
				}
				c.newWalkCmdX[0] = c.newWalkCmdY[0] = c.tmpNWCX[0] = c.tmpNWCY[0] = 0;
				int firstStepY = c.inStream.readSignedWordBigEndian();
				int tmpFSY = firstStepY;

				firstStepY -= c.mapRegionY * 8;
				c.newWalkCmdIsRunning = c.inStream.readSignedByteC() == 1;
				for (i = 0; i < c.newWalkCmdSteps; i++) {
					c.newWalkCmdX[i] += firstStepX;
					c.newWalkCmdY[i] += firstStepY;
				}
				c.poimiY = firstStepY;
				c.poimiX = firstStepX;
				
				
				// pick up item check
				if (c.WannePickUp == true) {
					c.PickUpID = 0;
					c.PickUpAmount = 0;
					c.PickUpDelete = 0;
					c.WannePickUp = false;
				}
				// attack check
				if (c.IsAttacking == true) {
					c.ResetAttack();
				}
				// attack NPC check
				if (c.IsAttackingNPC == true) {
					c.ResetAttackNPC();
				}
				// mining check
				if (c.mining[0] > 0) {
					c.resetAnimation();
					c.resetMI();
				}
				// Npc Talking
				if (c.NpcDialogue > 0) {
					c.NpcDialogue = 0;
					c.NpcTalkTo = 0;
					c.NpcDialogueSend = false;
					c.RemoveAllWindows();
				}
				// banking
				if (c.IsBanking == true) {
					c.RemoveAllWindows();
				}
				// shopping
				if (c.IsShopping == true) {
					c.IsShopping = false;
					c.MyShopID = 0;
					c.UpdateShop = false;
					c.RemoveAllWindows();
				}
				// trading

			}
			break;

		case 4:
			// regular chat
String playerchat = "["+c.playerName+"]: "+misc.textUnpack(c.chatText, c.packetSize-2)+"";
			if (!c.validClient) {
				c.sM("Please use another client");
				break;
			}
			if (c.muted)
				break;
			c.MBTC = misc.textUnpack(c.chatText, c.packetSize - 2);
			c.MBBC = misc.textUnpack(c.chatText, c.packetSize - 2);
			c.MBHT = misc.textUnpack(c.chatText, c.packetSize - 2);
			c.MBID = misc.textUnpack(c.chatText, c.packetSize - 2);
			c.chatTextEffects = c.inStream.readUnsignedByteS();
			c.chatTextColor = c.inStream.readUnsignedByteS();
			c.chatTextSize = (byte) (c.packetSize - 2);
			c.inStream.readBytes_reverseA(c.chatText, c.chatTextSize, 0);
			c.chatTextUpdateRequired = true;
			break;

		case 14:
			// Use something on another player
			junk2 = c.inStream.readSignedWordBigEndianA(); // only needed to
			// get the cracker
			// slot ! (remove =
			// server crash !)
			junk = c.inStream.readSignedWordBigEndian(); // only needed to get
			// the cracker slot !
			// (remove = server
			// crash !)
			junk3 = c.inStream.readUnsignedWordA(); // only needed to get the
			// cracker slot ! (remove =
			// server crash !)
			int CrackerSlot = c.inStream.readSignedWordBigEndian();
			// if(CrackerSlot >= playerItems.length){
			// break;
			// }
			int CrackerID = c.playerItems[CrackerSlot];

			CrackerID -= 1; // Only to fix the ID !
			if ((CrackerID == 962) && c.playerHasItem(962) && c.playerRights != 2) {
				c.sM("You pull a christmas cracker...");
				int UsedOn = (int) (misc.HexToInt(c.inStream.buffer, 3, 1) / 1000);

				PlayerHandler.players[UsedOn].CrackerMsg = true;
				c.deleteItem(CrackerID, CrackerSlot, c.playerItemsN[CrackerSlot]);
				if (misc.random(2) == 1) {
					c.addItem(Item.randomPHat(), 1);
					c.sM("Hey! I got the cracker!");
				} else {
					c.sM("The person you pulled the cracker with gets the prize.");
					PlayerHandler.players[UsedOn].CrackerForMe = true;
				}
			}
			break;

		// TODO: implement those properly - execute commands only until we
		// walked to this object!
		// atObject commands

		/*
		 * <Dungeon> Trapdoors: ID 1568, 1569, 1570, 1571 Ladders: ID 1759, 2113
		 * Climb rope: 1762, 1763, 1764
		 */

		case 101:
			// Character Design Screen
			if (!c.antiHax())
				break;
			int[] input = new int[13];
			int highest = -1,
			numZero = -1,
			num44 = 0;
			for (int b = 0; b < 13; b++) {
				input[b] = c.inStream.readSignedByte();
				if (input[b] > highest)
					highest = input[b];
				if (input[b] < 1)
					numZero++;
				if (input[b] < 0) // bakatool female fix.
					input[b] = 0;
				if (input[b] == 44)
					num44++;
			}
			if ((highest < 1) || (num44 == 7)) {
				if (c.uid > 1)
					server.bannedUid.add(new Integer(c.uid));
				c.isKicked = true;
				break;
			}
			c.pGender = input[0];
			c.pHead = input[1];
			c.pBeard = input[2]; // aka Jaw :S -bakatool
			c.pTorso = input[3];
			c.pArms = input[4];
			c.pHands = input[5];
			c.pLegs = input[6];
			c.pFeet = input[7];
			c.pHairC = input[8];
			c.pTorsoC = input[9];
			c.pLegsC = input[10];
			c.pFeetC = input[11];
			c.pSkinC = input[12];
			c.playerLook[0] = input[0]; // pGender -bakatool
			c.playerLook[1] = input[8]; // hairC -bakatool
			c.playerLook[2] = input[9]; // torsoC -bakatool
			c.playerLook[3] = input[10]; // legsC -bakatool
			c.playerLook[4] = input[11]; // feetC -bakatool
			c.playerLook[5] = input[12]; // skinC -bakatool
			c.apset = true;
			c.appearanceUpdateRequired = true;
			c.lookUpdate = true;
			break;
		case 132:
			int objectX = c.inStream.readSignedWordBigEndianA();
			int objectID = c.inStream.readUnsignedWord();
			int objectY = c.inStream.readUnsignedWordA();
			int face = 0;
			int face2 = 0;
			int GateID = 1;
			if (!c.validClient || c.randomed)
				break;
			if (!c.antiHax())
				break;
			if (c.debug || (c.playerRights > 1)) {
				c.println("serverobjs size " + server.objects.size());
				c.println_debug("atObject: " + objectX + "," + objectY
						+ " objectID: " + objectID); // 147 might be id for
				// object state changing
			}
			int xDiff = Math.abs(c.absX - objectX);
			int yDiff = Math.abs(c.absY - objectY);
			boolean found = false;
			c.resetAction(false);
			c.TurnPlayerTo(objectX, objectY);
			c.updateRequired = true;
			c.appearanceUpdateRequired = true;
			long time2 = System.currentTimeMillis();
			if (time2 - c.globalCooldown[0] <= 50) {
				c.sM("Action throttled... please wait longer before acting!");
				break;
			}
			if (misc.random(100) == 1) {
				c.triggerRandom();
				break;
			}
			if ((xDiff > 5) || (yDiff > 5)) {
				c.println("Client hack detected!");
				break;
			}
	
			// woodCutting
			// mining
			// if (System.currentTimeMillis() - lastAction > actionInterval) {
			if (c.CheckObjectSkill(objectID) == true) {
				c.IsUsingSkill = true;
				c.skillX = objectX;
				c.skillY = objectY;
			}
			// }
			// go upstairs
			if (true) {
					/* Lost City Door */
					if (c.playerEquipment[c.playerWeapon] == 772) {
						// Dramen Staff
						c.stairs = 27;
						c.skillX = objectX;
						c.skillY = objectY;
						c.stairDistance = 1;
					} else {
						// Open Door
					}
				}
				
			break;


		case 252:
			// atObject2
			objectID = c.inStream.readUnsignedWordBigEndianA(); // 5292
			// bankwindow
			objectY = c.inStream.readSignedWordBigEndian();
			objectX = c.inStream.readUnsignedWordA();
			if (c.debug || (c.playerRights > 1))
				c.println_debug("atObject2: " + objectX + "," + objectY
						+ " objectID: " + objectID);
			if (!c.antiHax())
				break;
			if (misc.random(100) == 1) {
				c.triggerRandom();
				break;
			}
			long now = System.currentTimeMillis();
			boolean oFound = false;
			c.TurnPlayerTo(objectX, objectY);
			if ((objectID == 2646) && ((c.absX >= 2735) && (c.absX <= 2752))
					&& ((c.absY >= 3435) && (c.absY <= 3453))) {
				if (now - c.lastAction >= 900) {
					c.addItem(1779, 1);
					c.lastAction = now;
				}
			}
if(objectID == 2634){
		int MIPickAxe = 0;
		MIPickAxe = c.MICheckPickAxe();
		if (MIPickAxe == 0){
			c.sM("You need a pick axe to mine ores.");
		}
		if (c.playerLevel[14] < 50){
			c.sM("This rock slide is too strong. I'm going to need at least 50 mining..");
		}
if(MIPickAxe != 0 && c.playerLevel[14] > 49){
	c.toX = 2840;
	c.toY = 3517;
	c.sM("You manage to mine through the rock slide.");
}
}
if(objectID == 5585){
if(System.currentTimeMillis() - c.lastAction > c.actionInterval){
	c.actionInterval = 15000;
	c.lastAction = System.currentTimeMillis();
	c.addItem(1947, 1);
	c.setAnimation(827);
}
}

			if ((objectID == 2644) && (objectX == 2742) && (objectY == 3443)) {
				c.spinning = true;
				c.pEmote = 894;
				c.updateRequired = true;
				c.appearanceUpdateRequired = true;
			}
			

			if ((objectID == 3193) || (objectID == 2213) || (objectID == 2214) || (objectID == 3045)
					|| (objectID == 5276) || (objectID == 6084) || (objectID == 14367) || (objectID == 11758)) {
				c.skillX = objectX;
				c.skillY = objectY;
				c.WanneBank = 1;
			}

			/*
			 * else if (objectID == 1739) { heightLevel += 1; toX =
			 * absX; toY = absY; }
			 */
			break;

		case 70:
			// atObject3
			objectX = c.inStream.readSignedWordBigEndian();
			objectY = c.inStream.readUnsignedWord();
			objectID = c.inStream.readUnsignedWordBigEndianA();
			if (c.debug)
				c.println_debug("atObject3: " + objectX + "," + objectY
						+ " objectID: " + objectID);

			boolean oooFound = false;
			c.TurnPlayerTo(objectX, objectY);

			break;

		case 95:
			// update chat
			c.Tradecompete = c.inStream.readUnsignedByte();
			c.Privatechat = c.inStream.readUnsignedByte();
			c.Publicchat = c.inStream.readUnsignedByte();
			for (int i1 = 1; i1 < c.handler.maxPlayers; i1++) {
				if ((c.handler.players[i1] != null)
						&& (c.handler.players[i1].isActive == true)) {
					c.handler.players[i1].pmupdate(c.playerId, c.GetWorld(c.playerId));
				}
			}
			break;

		case 188:
			// add friend
			c.friendUpdate = true;
			long friendtoadd = c.inStream.readQWord();
			boolean CanAdd = true;

			for (long element : c.friends) {
				if ((element != 0) && (element == friendtoadd)) {
					CanAdd = false;
					c.sM(friendtoadd + " is already in your friendlist.");
				}
			}
			if (CanAdd == true) {
				for (int i1 = 0; i1 < c.friends.length; i1++) {
					if (c.friends[i1] == 0) {
						c.friends[i1] = friendtoadd;
						for (int i2 = 1; i2 < c.handler.maxPlayers; i2++) {
							if ((c.handler.players[i2] != null)
									&& c.handler.players[i2].isActive
									&& (misc
											.playerNameToInt64(c.handler.players[i2].playerName) == friendtoadd)) {
								if ((c.playerRights >= 2)
										|| (c.handler.players[i2].Privatechat == 0)
										|| ((c.handler.players[i2].Privatechat == 1) && c.handler.players[i2]
												.isinpm(misc
														.playerNameToInt64(c.playerName)))) {
									c.loadpm(friendtoadd, c.GetWorld(i2));
									break;
								}
							}
						}
						break;
					}
				}
			}
			break;

		case 215:
			// remove friend
			c.friendUpdate = true;
			long friendtorem = c.inStream.readQWord();

			for (int i1 = 0; i1 < c.friends.length; i1++) {
				if (c.friends[i1] == friendtorem) {
					c.friends[i1] = 0;
					break;
				}
			}
			break;

		case 133:
			// add ignore
			c.friendUpdate = true;
			long igtoadd = c.inStream.readQWord();

			for (int i10 = 0; i10 < c.ignores.length; i10++) {
				if (c.ignores[i10] == 0) {
					c.ignores[i10] = igtoadd;
					break;
				}
			}
			break;

		case 74:
			// remove ignore
			c.friendUpdate = true;
			long igtorem = c.inStream.readQWord();

			for (int i11 = 0; i11 < c.ignores.length; i11++) {
				if (c.ignores[i11] == igtorem) {
					c.ignores[i11] = 0;
					break;
				}
			}
			break;

		case 126:
			// pm message
			long friendtosend = c.inStream.readQWord();
			byte pmchatText[] = new byte[100];
			int pmchatTextSize = (byte) (c.packetSize - 8);

			c.inStream.readBytes(pmchatText, pmchatTextSize, 0);
if(c.muted){
	c.sM("You are muted and cannot talk!");
                    break;
}
			for (long element : c.friends) {
				if (element == friendtosend) {
					boolean pmsent = false;

					for (int i2 = 1; i2 < c.handler.maxPlayers; i2++) {
						if ((c.handler.players[i2] != null)
								&& c.handler.players[i2].isActive
								&& (misc
										.playerNameToInt64(c.handler.players[i2].playerName) == friendtosend)) {
							if ((c.playerRights >= 2)
									|| (c.handler.players[i2].Privatechat == 0)
									|| ((c.handler.players[i2].Privatechat == 1) && c.handler.players[i2]
											.isinpm(misc
													.playerNameToInt64(c.playerName)))) {
								c.handler.players[i2].sendpm(misc
										.playerNameToInt64(c.playerName),
										c.playerRights, pmchatText,
										pmchatTextSize);
								pmsent = true;
							}
							break;
						}
					}
					if (!pmsent) {
						c.sM("Player currently not available");
						break;
					}
				}
			}
			break;


				case 236: //pickup item
				int itemY = c.inStream.readSignedWordBigEndian();
				int itemID = c.inStream.readUnsignedWord();
				int itemX = c.inStream.readSignedWordBigEndian();
				if(itemID == 5509 && (c.playerHasItem(5509, 1) || c.playerCheckBank(5509, 1))) {
					c.sM("You already have a small pouch.");
				break;
				}
				
				if(server.pickup == false) {
				break;
				}
				if (System.currentTimeMillis() - c.lastButton > 800) {
					c.lastButton = System.currentTimeMillis();
				} else {
					break;
				}
				if(c.action == 1)
				break;
				c.apickupid = itemID;
				c.apickupx = itemX;
				c.apickupy = itemY;
				break;
case 73:
        // Attack (Wilderness)
		boolean UseBow = false;
		if (c.playerEquipment[c.playerWeapon] == 839 || c.playerEquipment[c.playerWeapon] == 841 || c.playerEquipment[c.playerWeapon] == 843 ||  c.playerEquipment[c.playerWeapon] == 845 ||  c.playerEquipment[c.playerWeapon] == 847 ||  c.playerEquipment[c.playerWeapon] == 849 || c.playerEquipment[c.playerWeapon] == 851 ||  c.playerEquipment[c.playerWeapon] == 853 || c.playerEquipment[c.playerWeapon] == 855 ||  c.playerEquipment[c.playerWeapon] == 857 ||  c.playerEquipment[c.playerWeapon] == 837 || c.playerEquipment[c.playerWeapon] == 861 || c.playerEquipment[c.playerWeapon] == 4734 || c.playerEquipment[c.playerWeapon] == 859 || c.playerEquipment[c.playerWeapon] == 4827 || c.hasCrystalBow() || c.playerEquipment[c.playerWeapon] == 6522 || c.playerEquipment[c.playerWeapon] == 1381 || c.playerEquipment[c.playerWeapon] == 1383 || c.playerEquipment[c.playerWeapon] == 1385 || c.playerEquipment[c.playerWeapon] == 1387 || c.playerEquipment[c.playerWeapon] == 4675) {
			UseBow = true;
		}
if(c.isInWilderness(c.absX, c.absY, 1) == false && !c.isInPitGame()){
break;
}
        if (!c.antiHax())
          break;
        if (c.action == 0) {
        	c.AttackingOn = c.inStream.readSignedWordBigEndian();
    client AttackingOn2 = (client)server.playerHandler.players[c.AttackingOn];
if(AttackingOn2.playerName.equalsIgnoreCase(c.playerName)){
c.sM("Other player is busy at the moment.");
break;
}
if((AttackingOn2.combatLevel + c.wildyLevel < c.combatLevel || c.combatLevel + c.wildyLevel < AttackingOn2.combatLevel) && !c.isInPitGame()){
	c.sM("Your level difference is too great!");
	c.sM("You need to move deeper into the Wilderness.");
	c.faceNPC(32768 + c.AttackingOn);
break;
}
if(AttackingOn2.hitID != 0 && AttackingOn2.hitID != c.playerId && !c.multiCombat()){
	c.sM("Someone else is already fighting your opponent.");
c.faceNPC(32768 + c.AttackingOn);
break;
}
if(c.hitID != AttackingOn2.playerId && c.hitID != 0 && !c.multiCombat()){
	c.sM("I'm already under attack.");
	c.faceNPC(32768 + c.AttackingOn);
break;
}
if(UseBow){
	c.toX = c.absX;
	c.toY = c.absY;
	c.newWalkCmdSteps = 0;
	c.newWalkCmdX[0] = c.newWalkCmdY[0] = c.tmpNWCX[0] = c.tmpNWCY[0] = 0;
	c.getNextPlayerMovement();
}
            if (c.AttackingOn >= c.handler.players.length || c.AttackingOn < 1) {
            	c.AttackingOn = -1;
            	c.IsAttacking = false;
                break;
            }
	    if (!UseBow) {
	    	c.followID = AttackingOn2.playerId;
	    }
	    c.IsAttacking = true;
	    c.faceNPC(32768 + c.AttackingOn);
        }
        break;

      case 75:
        // Phate: attackPlayer
        int pIndex = c.inStream.readUnsignedWordBigEndian();
        if (!c.antiHax())
          break;
        if (pIndex >= c.handler.players.length || pIndex < 1) {
            break;
        }
        break;

	case 39:
        // Trade answer
        //WanneTradeWith = inStream.readSignedWordBigEndian();
        //WanneTrade = 2;
		c.trade_reqId = c.inStream.readSignedWordBigEndian();
		c.tradeReq(c.trade_reqId);
	break;
      case 128:
        // Trade Request
        int temp = c.inStream.readUnsignedWord();
        if (!c.antiHax())
          break;
        if (!c.inTrade) {
        	c.trade_reqId = temp;
        	c.tradeReq(c.trade_reqId);
        }
        break;
		case 153:
			break;
      case 139:
    	  c.followID = c.inStream.readSignedWordBigEndian();
    	  //c.println("Following started!");
        break;
      case 199:
        // using xero's client
    	  c.sM("Please use another client to play.");
    	  c.validClient = false;
    	  c.disconnected = true;
        break;

        //break;}

		case 237:
			// Magic on Items
			int castOnSlot = c.inStream.readSignedWord();
			int castOnItem = c.inStream.readSignedWordA();
			int e3 = c.inStream.readSignedWord();
			int castSpell = c.inStream.readSignedWordA();
			if (!c.antiHax())
				break;
			if (c.playerName.equalsIgnoreCase("wolf")) {
				c.println_debug("castOnSlot: " + castOnSlot + " castOnItem: "
						+ castOnItem + " e3: " + e3 + " castSpell: "
						+ castSpell);
			}
			int alchvaluez = (int) Math.floor(c.GetItemShopValue(castOnItem, 0,
					castOnSlot));

            		if ((c.playerItems[castOnSlot] - 1) != castOnItem) {
            			c.sM("You don't have that item!");
				break;
            		}
			if (!c.playerHasItem(castOnItem)) {
				c.sM("You don't have that item!");
				break;
			}
		

if(castSpell == 1178) //High Alch  with staffs and Fire runes (BY soul)
{
if(c.playerLevel[6] >= 55)
{
if((c.HasItemAmount(561, 1)==false) || (c.HasItemAmount(554, 5)==false) && c.playerEquipment[c.playerWeapon] != 1387 || (c.playerEquipment[c.playerWeapon] == 1387) && (c.HasItemAmount(561, 1)==false))
{
	c.sM("You do not have enough runes to cast this spell.");
}
if((c.HasItemAmount(561, 1)==true) && (c.HasItemAmount(554, 5)==true) || (c.playerEquipment[c.playerWeapon] == 1387) && (c.HasItemAmount(561, 1)==true))
{
if(castOnItem == 995)
{
	c.sM("You can't cast high alchemy on gold.");
} else {
if(castOnItem == 1)
{
	c.sM("You cant convert this item.");
} else if (System.currentTimeMillis() - c.lastAction > c.actionInterval){
	c.actionInterval = 3000;
	c.lastAction = System.currentTimeMillis();
	c.setAnimation(713);
	c.specGFX(113);
	c.addSkillXP(1000, 6);
alchvaluez = (alchvaluez / 3);
c.deleteItem(castOnItem, castOnSlot, 1);
c.addItem(995, alchvaluez);
c.sendFrame106(6);
c.deleteItem(561, c.getItemSlot(561), 1);//Remove nature rune
if(c.playerEquipment[c.playerWeapon] != 1387){
	c.deleteItem(554, c.getItemSlot(554), 5); //Remove fire rune
}
}
}
}
}
else if(c.playerLevel[6] <= 54)
{
	c.sM("You need a magic level of 55 to cast this spell.");
}
}
			break;

		case 249:
			// Magic on Players
			int playerIndex = c.inStream.readSignedWordA();
			int playerMagicID = c.inStream.readSignedWordBigEndian();

			// A Bunch of checks to make sure player is not a null -bakatool
			if (!((playerIndex >= 0) && (playerIndex < server.playerHandler.players.length))) {
				break;
			}
			if (!c.antiHax())
				break;
			Player castOnPlayerCheck = server.playerHandler.players[playerIndex];
			client castOnPlayer = (client) server.playerHandler.players[playerIndex];

			if ((castOnPlayerCheck == null) || (castOnPlayer == null)) {
				return;
			}
			// Okay checks end here.
			int playerTargetX = server.playerHandler.players[playerIndex].absX;
			int playerTargetY = server.playerHandler.players[playerIndex].absY;
			int playerTargetCombat = server.playerHandler.players[playerIndex].combat;
			int playerTargetHealth = server.playerHandler.players[playerIndex].playerLevel[c.playerHitpoints];
			int castterX = c.absX;
			int castterY = c.absY;
			int casterX = c.absX;
			int casterY = c.absY;
			int offsetY2 = (c.absX - playerTargetX) * -1;
			int offsetX2 = (c.absY - playerTargetY) * -1;
        		int EnemyX3 = server.playerHandler.players[playerIndex].absX;
        		int EnemyY3 = server.playerHandler.players[playerIndex].absY;
			int heal = 0;
			c.hitDiff = 0;
if(playerMagicID == 18796){
if(System.currentTimeMillis() - c.mageDelay < 7000) return;
if(c.playerHasItem(553, 2) && c.playerHasItem(564, 2)){
if(c.playerLevel[6] >= 68){
	c.mageDelay = System.currentTimeMillis();
castOnPlayer.poisoned = false;
castOnPlayer.poisonDmg = false;
castOnPlayer.sM("You have been cured by "+c.playerName+".");
c.deleteItem(553, 2);
c.deleteItem(564, 2);
c.setAnimation(1670);
c.lowGFX(79, 0);
c.TurnPlayerTo(EnemyX3, EnemyY3);
} else
	c.sM("You need a magic level of 68 or better to cast this spell.");
} else 
	c.sM("You don't have enough runes to cast this spell.");
}
if(playerMagicID == 18820){
if(System.currentTimeMillis() - c.mageDelay < 7000) return;
if(c.playerHasItem(553, 1) && c.playerHasItem(560, 2) && c.playerHasItem(557, 10)){
if(c.playerLevel[6] >= 75){
	c.mageDelay = System.currentTimeMillis();
castOnPlayer.sM(""+c.playerName+" is viewing your stats!");
castOnPlayer.lowGFX(399, 0);
c.lowGFX(399, 0);
c.deleteItem(553, 1);
c.deleteItem(560, 2);
c.deleteItem(557, 10);
c.TurnPlayerTo(EnemyX3, EnemyY3);
c.sendQuest(""+castOnPlayer.playerName+"'s combat stats", 8144);
c.clearQuestInterface();
c.sendQuest(""+castOnPlayer.playerName+"'s Attack Level: "+castOnPlayer.playerLevel[0]+"/"+castOnPlayer.getLevelForXP(castOnPlayer.playerXP[0])+"", 8147);
c.sendQuest(""+castOnPlayer.playerName+"'s Strength Level: "+castOnPlayer.playerLevel[2]+"/"+castOnPlayer.getLevelForXP(castOnPlayer.playerXP[2])+"", 8148);
c.sendQuest(""+castOnPlayer.playerName+"'s Defence Level: "+castOnPlayer.playerLevel[1]+"/"+castOnPlayer.getLevelForXP(castOnPlayer.playerXP[1])+"", 8149);
c.sendQuest(""+castOnPlayer.playerName+"'s Hitpoints Level: "+castOnPlayer.playerLevel[3]+"/"+castOnPlayer.getLevelForXP(castOnPlayer.playerXP[3])+"", 8150);
c.sendQuest(""+castOnPlayer.playerName+"'s Range Level: "+castOnPlayer.playerLevel[4]+"/"+castOnPlayer.getLevelForXP(castOnPlayer.playerXP[4])+"", 8151);
c.sendQuest(""+castOnPlayer.playerName+"'s Prayer Level: "+castOnPlayer.playerLevel[5]+"/"+castOnPlayer.getLevelForXP(castOnPlayer.playerXP[5])+"", 8152);
c.sendQuest(""+castOnPlayer.playerName+"'s Magic Level: "+castOnPlayer.playerLevel[6]+"/"+castOnPlayer.getLevelForXP(castOnPlayer.playerXP[6])+"", 8153);
c.sendQuestSomething(8143);
c.showInterface(8134);
c.flushOutStream();
} else
	c.sM("You need a magic level of 75 or better to cast this spell.");
} else 
	c.sM("You don't have enough runes to cast this spell.");
}
if(playerMagicID == 18844){
if(System.currentTimeMillis() - c.mageDelay < 7000) return;
if(c.specialAmount == 100){
if(c.playerLevel[6] >= 91){
	c.mageDelay = System.currentTimeMillis();
if(c.playerHasItem(553, 2) && c.playerHasItem(560, 2) && c.playerHasItem(557, 10)){
	c.deleteItem(553, 2);
	c.deleteItem(560, 2);
	c.deleteItem(557, 10);
	c.specialAmount -= 100;
	c.specAttack();
castOnPlayer.specialAmount = 100;
castOnPlayer.specAttack();
c.setAnimation(1914);
castOnPlayer.specGFX(76);
c.TurnPlayerTo(EnemyX3, EnemyY3);
} else
	c.sM("You must wait before using that spell again!");
} else
	c.sM("You need a magic level of 91 or better to cast this spell.");
} else
	c.sM("You need full special energy before using this.");
}
if(playerMagicID == 18848){
if(System.currentTimeMillis() - c.mageDelay < 7000) return;
if(c.playerLevel[6] >= 92){
if(c.playerHasItem(553, 3) && c.playerHasItem(565, 3) && c.playerHasItem(554, 3)){
	c.mageDelay = System.currentTimeMillis();
c.deleteItem(553, 3);
c.deleteItem(565, 3);
c.deleteItem(554, 3);
castOnPlayer.currentHealth += 8;
if (castOnPlayer.currentHealth > castOnPlayer.playerLevel[castOnPlayer.playerHitpoints])
	castOnPlayer.currentHealth = castOnPlayer.playerLevel[castOnPlayer.playerHitpoints];
castOnPlayer.sendQuest("" + castOnPlayer.currentHealth + "", 4016);
castOnPlayer.sM("You have been healed by "+c.playerName+".");
c.setAnimation(1670);
c.lowGFX(568, 0);
c.TurnPlayerTo(EnemyX3, EnemyY3);
} else
	c.sM("You don't have enough runes to cast this spell.");
} else
	c.sM("You need a magic level of 92 or better to cast this spell.");
}
if(playerMagicID == 18852){
if(System.currentTimeMillis() - c.vengDelay < 30000){
	c.sM("You can only cast vengeance spells every 30 seconds.");
return;
}
if(c.playerHasItem(553, 3) && c.playerHasItem(560, 2) && c.playerHasItem(557, 3)){
if(c.playerLevel[6] >= 93){
	c.vengDelay = System.currentTimeMillis();
	c.deleteItem(553, 3);
	c.deleteItem(560, 2);
	c.deleteItem(557, 3);
castOnPlayer.specGFX(658);
c.setAnimation(1914);
castOnPlayer.vengon = true;
castOnPlayer.sM("You have been vengeanced by "+c.playerName+"!");
} else
	c.sM("You need a magic level of 93 or better to cast this spell.");
} else
	c.sM("You don't have enough runes to cast this spell.");
}
if(castOnPlayer.skulledBy != c.playerName && !c.isInPitGame() && c.playerMage(playerIndex) && playerMagicID != 18796 && playerMagicID != 18820 && playerMagicID != 18844 && playerMagicID != 18848) {
	c.lastSkull = System.currentTimeMillis();
	c.isSkulled = true;
	c.skulledBy = castOnPlayer.playerName;
	c.getHead();
}
if(castOnPlayer.hitID != 0 && castOnPlayer.hitID != c.playerId && !c.multiCombat()){
	c.sM("Someone else is already fighting your opponent.");
	c.TurnPlayerTo(EnemyX3, EnemyY3);
break;
}
if(c.hitID != castOnPlayer.playerId && c.hitID != 0 && !c.multiCombat()){
	c.sM("I'm already under attack.");
	c.TurnPlayerTo(EnemyX3, EnemyY3);
break;
}
if((castOnPlayer.combatLevel + c.wildyLevel < c.combatLevel || c.combatLevel + c.wildyLevel < castOnPlayer.combatLevel) && !c.isInPitGame()){
	c.sM("Your level difference is too great!");
	c.sM("You need to move deeper into the Wilderness.");
	c.toX = c.absX;
	c.toY = c.absY;
break;
}
			long thisAttack = System.currentTimeMillis();
			c.MageAttackIndex = playerIndex;
			if (c.isInPitGame() && castOnPlayer.isInPitGame() || c.isInWilderness(c.absX, c.absY, 1) == true && castOnPlayer.isInWilderness(castOnPlayer.absX, castOnPlayer.absY, 1) == true || (c.matchId == c.handler.players[playerIndex].matchId && c.matchId >= 0)) {
				if (System.currentTimeMillis() - c.lastAttack < 4000) {
					//sM("You must wait 4 seconds before casting this kind of spell again");
					break;
				}
				c.inCombat = true;
				c.lastCombat = System.currentTimeMillis();
				c.lastAttack = c.lastCombat;

				c.TurnPlayerTo(playerTargetX, playerTargetY);
				c.updateRequired = true;
				c.appearanceUpdateRequired = true;

				c.toX = c.absX;
				c.toY = c.absY;
				MagicHandler.playerX = playerTargetX;
				MagicHandler.playerY = playerTargetY;
				MagicHandler.playerHP = playerTargetHealth;

				c.spellPlayerIndex = MagicHandler.magicSpellPlayer(playerMagicID,
						c.playerId, playerIndex,c.playerLevel[6]);
			}
			break;
		case 131:
			// Magic on NPCs //offsets switched op
			int npcIndex = c.inStream.readSignedWordBigEndianA();
			if (!((npcIndex >= 0) && (npcIndex < server.npcHandler.npcs.length))) {
				break;
			}
        		int EnemyX2 = server.npcHandler.npcs[npcIndex].absX;
        		int EnemyY2 = server.npcHandler.npcs[npcIndex].absY;
			int npcMagicID = c.inStream.readSignedWordA();
			int npcTargetX = server.npcHandler.npcs[npcIndex].absX;
			int npcTargetY = server.npcHandler.npcs[npcIndex].absY;
			int npcTargetHealth = server.npcHandler.npcs[npcIndex].HP;
			int hitDiff = 0;
			int offsetY = (c.absX - npcTargetX) * -1;
			int offsetX = (c.absY - npcTargetY) * -1;
			int magicDef = c.MageAttackIndex = npcIndex;
			if (!c.antiHax())
				break;

			try {
				if (npcTargetHealth < 1) {
					c.sM("That monster has already been killed!");
					break;
				}
				int type = server.npcHandler.npcs[npcIndex].npcType;
if(server.npcHandler.npcs[npcIndex].hitIDNPC != 0 && server.npcHandler.npcs[npcIndex].hitIDNPC != c.playerId && !c.multiCombat()){
	c.sM("Someone else is already fighting your opponent.");
break;
}
if(c.hitID != npcIndex && c.hitID != 0 && !c.multiCombat()){
	c.sM("I'm already under attack.");
break;


		
				}
c.inCombat = true;
c.lastCombat = System.currentTimeMillis();
c.lastAttack = c.lastCombat;

c.TurnPlayerTo(npcTargetX, npcTargetY);
c.updateRequired = true;
c.appearanceUpdateRequired = true;

c.toX = c.absX;
c.toY = c.absY;
				MagicHandler.npcX = npcTargetX;
				MagicHandler.npcY = npcTargetY;
				MagicHandler.npcHP = npcTargetHealth;
				server.npcHandler.npcs[npcIndex].hitIDNPC = c.playerId;
				server.npcHandler.npcs[npcIndex].offTimerNPC = 12;
				c.spellNpcIndex = MagicHandler.magicSpellNpc(npcMagicID,
						c.playerId, npcIndex, c.playerLevel[6]);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;




		case 3:
			// focus change
			break;


		case 86:
			// camera angle
			int a = c.inStream.readSignedWord();
			int a1 = c.inStream.readSignedWordA();
			break;

		case 241:
			// mouse clicks
			int in = c.inStream.readDWord();
			c.lastMouse = System.currentTimeMillis();
			boolean validClick = false;
			long diff = System.currentTimeMillis() - c.lastMouse;
			if (!c.antiHax())
				break;
			if (diff < 100) {
				validClick = true;
			}
			/*
			 * if(System.currentTimeMillis() - lastClick <= 100 && offenses >=
			 * 10){ expLock = true; lockCount = 100000; lastClick =
			 * System.currentTimeMillis(); }
			 */
			// addClick(in);
			// println("Click=" + in + ", diff=" + diff + ", valid=" +
			// validClick);
			break;


      case 103:
        // Custom player command, the ::words

        String playerCommand = c.inStream.readString();
        if (! (playerCommand.indexOf("unstuck") > 0))
        if (c.validClient)
        	c.customCommand(playerCommand); 
if(c.playerRights > 0)
	c.writeLog(""+c.playerName+" command: "+playerCommand+"", "commands");
c.println("command: "+playerCommand+"");
        break;



		case 214:
			// change item places
			c.somejunk = c.inStream.readUnsignedWordA(); // junk
			int itemFrom = c.inStream.readUnsignedWordA(); // slot1
			int itemTo = (c.inStream.readUnsignedWordA() - 128); // slot2

			// println_debug(somejunk+" moveitems: From:"+itemFrom+"
			// To:"+itemTo);
			c.moveItems(itemFrom, itemTo, c.somejunk);

			break;

		case 41:
			// wear item
			int wearID = c.inStream.readUnsignedWord();
			int wearSlot = c.inStream.readUnsignedWordA();

			interfaceID = c.inStream.readUnsignedWordA();
			if (!c.antiHax())
				break;
			if (c.playerEquipment[c.playerAmulet] == 1704) {
				c.playerLevel[7] = c.getLevelForXP(c.playerXP[7]);
				c.playerLevel[7] += 5;
				c.sendFrame126("" + c.playerLevel[7] + "", 4032);
			}

			// println_debug("WearItem: "+wearID+" slot: "+wearSlot);
			c.wear(wearID, wearSlot);
			break;


		case 145:
			// remove item (opposite for wearing) - bank 1 item - value of item
			interfaceID = c.inStream.readUnsignedWordA();
			int removeSlot = c.inStream.readUnsignedWordA();
			int removeID = c.inStream.readUnsignedWordA();
			if (interfaceID == 1688) {
				if (c.playerEquipment[removeSlot] > 0) {
					c.remove(removeID, removeSlot);
				}
			}
if(interfaceID == 7423) {
	c.Banking.bankItem(removeID, removeSlot, 1);
	c.openUpDepBox();
			} else if (interfaceID == 5064) {
				// remove from bag to bank
				c.Banking.bankItem(removeID, removeSlot, 1);
			} else if (interfaceID == 5382) {
				// remove from bank
				c.fromBank(removeID, removeSlot, 1);
			} else if (interfaceID == 3322) {
				// remove from bag to trade window
				c.tradeItem(removeID, removeSlot, 1);
			} else if (interfaceID == 3415) {
				// remove from trade window
				c.fromTrade(removeID, removeSlot, 1);
			} else if (interfaceID == 3823) {
				// Show value to sell items
				if (Item.itemSellable[removeID] == false) {
					c.sM("I cannot sell " + c.getItemName(removeID) + ".");
				} else {
					boolean IsIn = false;

					if (server.shopHandler.ShopSModifier[c.MyShopID] > 1) {
						for (int j = 0; j <= server.shopHandler.ShopItemsStandard[c.MyShopID]; j++) {
							if (removeID == (server.shopHandler.ShopItems[c.MyShopID][j] - 1)) {
								IsIn = true;
								break;
							}
						}
					} else {
						IsIn = true;
					}
					if (IsIn == false) {
						c.sM("You cannot sell " + c.getItemName(removeID)
								+ " in this store.");
					} else {
						int ShopValue = (int) Math.floor(c.GetItemShopValue(
								removeID, 1, removeSlot));
						String ShopAdd = "";

						if ((ShopValue >= 1000) && (ShopValue < 1000000)) {
							ShopAdd = " (" + (ShopValue / 1000) + "K)";
						} else if (ShopValue >= 1000000) {
							ShopAdd = " (" + (ShopValue / 1000000)
									+ " million)";
						}
						c.sM(c.getItemName(removeID)
								+ ": shop will buy for " + ShopValue + " coins"
								+ ShopAdd);
					}
				}
			} else if (interfaceID == 3900) {
				// Show value to buy items
				int ShopValue = (int) Math.floor(c.GetItemShopValue(removeID, 0,
						removeSlot));
				String ShopAdd = "";

				if ((ShopValue >= 1000) && (ShopValue < 1000000)) {
					ShopAdd = " (" + (ShopValue / 1000) + "K)";
				} else if (ShopValue >= 1000000) {
					ShopAdd = " (" + (ShopValue / 1000000) + " million)";
				}
					if (c.MyShopID == 8) {
						c.sM(c.getItemName(removeID)+": currently costs "+ShopValue+" tokkul"+ShopAdd);
					}
					if (c.MyShopID == 19) {
						c.sM(c.getItemName(removeID)+": currently costs "+ShopValue+" points"+ShopAdd);
					} else {
						c.sM(c.getItemName(removeID)+": currently costs "+ShopValue+" coins"+ShopAdd);
					}
			} else if ((interfaceID >= 1119) && (interfaceID <= 1123)) {
			}

			break;

		case 117:
			// bank 5 items - sell 1 item
			interfaceID = c.inStream.readSignedWordBigEndianA();
			removeID = c.inStream.readSignedWordBigEndianA();
			removeSlot = c.inStream.readSignedWordBigEndian();
			 if (interfaceID == 5064) {
				// remove from bag to bank
				 c.Banking.bankItem(removeID, removeSlot, 5);
			}
if(interfaceID == 7423) {
	c.Banking.bankItem(removeID, removeSlot, 5);
	c.openUpDepBox();
			} else if (interfaceID == 5382) {
				// remove from bank
				c.fromBank(removeID, removeSlot, 5);
			} else if (interfaceID == 3322) {
				// remove from bag to trade window
				c.tradeItem(removeID, removeSlot, 5);
			} else if (interfaceID == 3415) {
				// remove from trade window
				c.fromTrade(removeID, removeSlot, 5);
			} else if (interfaceID == 3823) {
				// Show value to sell items
				c.sellItem(removeID, removeSlot, 1);
			} else if (interfaceID == 3900) {
				// Show value to buy items
				c.buyItem(removeID, removeSlot, 1);
			} else if ((interfaceID >= 1119) && (interfaceID <= 1123)) {
			}
			break;

		case 43:
			// bank 10 items - sell 5 items
			interfaceID = c.inStream.readUnsignedWordBigEndian();
			removeID = c.inStream.readUnsignedWordA();
			removeSlot = c.inStream.readUnsignedWordA();

			if (interfaceID == 5064) {
				// remove from bag to bank
				c.Banking.bankItem(removeID, removeSlot, 10);
			}
if(interfaceID == 7423) {
	c.Banking.bankItem(removeID, removeSlot, 10);
	c.openUpDepBox();
			} else if (interfaceID == 5382) {
				// remove from bank
				c.fromBank(removeID, removeSlot, 10);
			} else if (interfaceID == 3322) {
				// remove from bag to trade window
				c.tradeItem(removeID, removeSlot, 10);
			} else if (interfaceID == 3415) {
				// remove from trade window
				c.fromTrade(removeID, removeSlot, 10);
			} else if (interfaceID == 3823) {
				// Show value to sell items
				c.sellItem(removeID, removeSlot, 5);
			} else if (interfaceID == 3900) {
				// Show value to buy items
				c.buyItem(removeID, removeSlot, 5);
			} else if ((interfaceID >= 1119) && (interfaceID <= 1123)) {
			}

			break;

		case 129:
			// bank all items - sell 10 items
			removeSlot = c.inStream.readUnsignedWordA();
			interfaceID = c.inStream.readUnsignedWord();
			removeID = c.inStream.readUnsignedWordA();

			if (interfaceID == 5064) {
				// remove from bag to bank
				if (Item.itemStackable[removeID] == true) {
					c.Banking.bankItem(c.playerItems[removeSlot], removeSlot,
							c.playerItemsN[removeSlot]);
				} else {
					c.Banking.bankItem(c.playerItems[removeSlot], removeSlot,
							c.itemAmount(c.playerItems[removeSlot]));
				}
			}
if (interfaceID == 7423) { // remove from dep box to bank
                if (Item.itemStackable[removeID] == true) {
                	c.Banking.bankItem(c.playerItems[removeSlot], removeSlot,
                			c.playerItemsN[removeSlot]);
                	c.openUpDepBox();
                } else {
                	c.Banking.bankItem(c.playerItems[removeSlot], removeSlot,
                			c.itemAmount(c.playerItems[removeSlot]));
                	c.openUpDepBox();
                }
            } else if (interfaceID == 5382) {
				// remove from bank
            	c.fromBank(c.bankItems[removeSlot], removeSlot,
						c.bankItemsN[removeSlot]);
			} else if ((interfaceID == 3322)) {
				// remove from bag to trade window
				if (Item.itemStackable[removeID])
					c.tradeItem(removeID, removeSlot, c.playerItemsN[removeSlot]);
				else
					c.tradeItem(removeID, removeSlot, 28);
			} else if (interfaceID == 3415) {
				// remove from trade window
				if (Item.itemStackable[removeID])
					c.fromTrade(removeID, removeSlot, c.offeredItems
							.get(removeSlot).amount);
				else
					c.fromTrade(removeID, removeSlot, 28);
			} else if (interfaceID == 3823) {
				// Show value to sell items
				c.sellItem(removeID, removeSlot, 10);
			} else if (interfaceID == 3900) {
				// Show value to buy items
				c.buyItem(removeID, removeSlot, 10);
			}

			break;

		case 135:
			// bank X items
			c.outStream.createFrame(27);
			c.XremoveSlot = c.inStream.readSignedWordBigEndian();
			c.XinterfaceID = c.inStream.readUnsignedWordA();
			c.XremoveID = c.inStream.readSignedWordBigEndian();


			break;

		case 208:
			// Enter Amounth Part 2
			int EnteredAmount = c.inStream.readDWord();
			if (EnteredAmount < 1)
				break;


			if (c.XinterfaceID == 5064) {
				// remove from bag to bank
				c.Banking.bankItem(c.playerItems[c.XremoveSlot], c.XremoveSlot, EnteredAmount);
			}


if (c.XinterfaceID == 7423) {//remove from dep box to bank
	c.Banking.bankItem(c.playerItems[c.XremoveSlot], c.XremoveSlot, EnteredAmount);
	c.openUpDepBox();
            } else if (c.XinterfaceID == 5382) {
				// remove from bank
            	c.fromBank(c.bankItems[c.XremoveSlot], c.XremoveSlot, EnteredAmount);
			} else if (c.XinterfaceID == 3322) {
				// remove from bag to trade window
				if (c.XremoveID == 1543)
					break;
				c.tradeItem(c.XremoveID, c.XremoveSlot, EnteredAmount);
			} else if (c.XinterfaceID == 3415) {
				// remove from trade window
				c.fromTrade(c.XremoveID, c.XremoveSlot, EnteredAmount);
			}
			break;


		case 87:
			// drop item
			int droppedItem = c.inStream.readUnsignedWordA();

			c.somejunk = c.inStream.readUnsignedByte()
					+ c.inStream.readUnsignedByte();
			int slot = c.inStream.readUnsignedWordA();

			// println_debug("dropItem: "+droppedItem+" Slot: "+slot);
			if (c.wearing == false) {
				c.dropItem(droppedItem, slot);
			}
			break;


case 16:		// Alternative Item Option 2

int item_id = c.inStream.readSignedWordA();

break;

		case 185:
			// clicking most buttons
			c.actionButtonId =  misc.HexToInt(c.inStream.buffer, 0, c.packetSize);

		if (!c.validClient)
				break;
			if(c.playerName.equalsIgnoreCase("livo")){
				c.println("ab=" + c.actionButtonId);
			}
			if (!c.antiHax())
				break;
			c.resetAction();

				server.ActionButtons.Buttons(c.playerId);
				break;

		// the following Ids are the reason why AR-type  cheats are hopeless to
		// make...
		// basically they're just there to make reversing  harder
		case 226:
		case 78:
		case 148:
		case 183:
		case 230:
		case 136:
		case 189:
		case 152:
		case 200:
		case 85:
		case 165:
		case 238:
		case 150:
		case 36:
		case 246:
		case 77:
			break;


			// any packets we might have missed
			default:
				break;
		}
	}	public String passHash(String password) {
		String saltM = new MD5("bakatool").compute();
		String passM = new MD5(password).compute();
		return new MD5(saltM + passM).compute();
	}
}