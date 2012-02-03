package server;

import server.Buttons.ActionButtons;
import server.Wearing.Equipemotes;

import server.PacketHandler.Packets;
import server.PlayerActions.FollowHandler;
import server.Wearing.Equipemotes;
import server.PlayerActions.NPChitting;
import server.PlayerActions.Banking;
import server.PlayerActions.ItemKeeping;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class client extends Player implements Runnable {
    public Banking Banking = new Banking(this);
    public Packets Packets = new Packets(this);
    public FollowHandler FollowHandler = new FollowHandler(this);
    public NPChitting NPChitting = new NPChitting(this);
    public Equipemotes Equipemotes = new Equipemotes(this);
    public ItemKeeping ItemKeeping = new ItemKeeping(this);


    /*
    	 * All ints and booleans for player tasks - lostmyphat
    */
    public boolean hasAccepted = false;
    public int TradeLogout = 0;
    public int hlevel = 0;
    public boolean onlyxp = false;
    public int total = 0;
    public int itemKept1, itemKept2, itemKept3, itemKept4;
    public int totalXP = 0;
    public int apickupid = -1;
    public int apickupx = -1;
    public int apickupy = -1;
    public int KillerId = playerId;
    public boolean hasntLoggedin = false;
    public int ItemKept1;
    public int ItemKept2;
    public int ItemKept3;
    public int ItemKept4;
    public int ItemKept5;
    public int itemKept1Slot;
    public int itemKept2Slot;
    public int itemKept3Slot;
    public int itemKept4Slot;
    public boolean itemSlot1;
    public boolean itemSlot2;
    public boolean itemSlot3;
    public boolean itemSlot4;


    /*
     * Handles something like icons - lostmyphat
    */

    public void frame61(int i1) {
        outStream.createFrame(61);
        outStream.writeByte(i1);
        updateRequired = true;
        appearanceUpdateRequired = true;
    }

    /*
     *  Handles ending of non projectile and projectile spells? - lostmyphat
    */

    public void getEnd() {
        if(Projectile(MagicHandler.spellID)) {
            stillgfx(ffinishid, fenemyY, fenemyX);
        }
        if(!Projectile(MagicHandler.spellID)) {
            stillgfx(fcastid, fenemyY, fenemyX);
        }
    }

    /*
     * GFX for arrow ids, it will show the rune arrow as blue when shooting. - lostmyphat
    */

    public int getarrowgfxnow() {
        if (playerEquipment[playerArrows] == 892) {
            return 15;
        }
        if (playerEquipment[playerArrows] == 890) {
            return 13;
        }
        if (playerEquipment[playerArrows] == 888) {
            return 12;
        }
        if (playerEquipment[playerArrows] == 886) {
            return 11;
        }
        if (playerEquipment[playerArrows] == 884) {
            return 9;
        }
        if (playerEquipment[playerArrows] == 882) {
            return 10;
        } else {
            return -1;
        }
    }

    /*
     * Handles updating of spec bar - lostmyphat
    */

    public void removeSpec(int id) {
        outStream.createFrame(171);
        outStream.writeByte(1);
        outStream.writeWord(id);
        flushOutStream();
    }

    /*
     * Handles NPC hitting - lostmyphat
    */

    public void npcDamage(int extraDamage) {
        int voidmelee = 0;
        if(FullVMelee()) {
            voidmelee += 10;
        }
        if(NPChitting.npcHit()) {
            hitDiff = misc.random(playerMaxHit) + misc.random(StrPrayer) + misc.random(voidmelee) + misc.random(extraDamage);
        }
        if(!NPChitting.npcHit()) {
            hitDiff = 0;
        }
    }

    /*
     * Calculates total level - lostmyphat
    */

    public void getTotalXP() {
        if(playerRights >= 2)
            return;
        int a0 = getLevelForXP(playerXP[0]);
        int a1 = getLevelForXP(playerXP[1]);
        int a2 = getLevelForXP(playerXP[2]);
        int a3 = getLevelForXP(playerXP[3]);
        int a4 = getLevelForXP(playerXP[4]);
        int a5 = getLevelForXP(playerXP[5]);
        int a6 = getLevelForXP(playerXP[6]);
        int a7 = getLevelForXP(playerXP[7]);
        int a8 = getLevelForXP(playerXP[8]);
        int a9 = getLevelForXP(playerXP[9]);
        int a10 = getLevelForXP(playerXP[10]);
        int a11 = getLevelForXP(playerXP[11]);
        int a12 = getLevelForXP(playerXP[12]);
        int a13 = getLevelForXP(playerXP[13]);
        int a14 = getLevelForXP(playerXP[14]);
        int a15 = getLevelForXP(playerXP[15]);
        int a16 = getLevelForXP(playerXP[16]);
        int a17 = getLevelForXP(playerXP[17]);
        int a18 = getLevelForXP(playerXP[18]);
        int a19 = getLevelForXP(playerXP[19]);
        int a20 = getLevelForXP(playerXP[20]);
        int a21 = getLevelForXP(playerXP[21]);
        int b0 = getXPForLevel(a0);
        int b1 = getXPForLevel(a1);
        int b2 = getXPForLevel(a2);
        int b3 = getXPForLevel(a3);
        int b4 = getXPForLevel(a4);
        int b5 = getXPForLevel(a5);
        int b6 = getXPForLevel(a6);
        int b7 = getXPForLevel(a7);
        int b8 = getXPForLevel(a8);
        int b9 = getXPForLevel(a9);
        int b10 = getXPForLevel(a10);
        int b11 = getXPForLevel(a11);
        int b12 = getXPForLevel(a12);
        int b13 = getXPForLevel(a13);
        int b14 = getXPForLevel(a14);
        int b15 = getXPForLevel(a15);
        int b16 = getXPForLevel(a16);
        int b17 = getXPForLevel(a17);
        int b18 = getXPForLevel(a18);
        int b19 = getXPForLevel(a19);
        int b20 = getXPForLevel(a20);
        int b21 = getXPForLevel(a21);
        /*
         * Terrible way of adding up total xp... - lostymphat
        */

        totalXP = b1+b2+b3+b4+b5+b6+b7+b8+b9+b10+b11+b12+b13+b14+b15+b16+b17+b18+b19+b20+b21;
    }

    /*
     * Calculates Prayer dissipating - lostymphat
    */

    public void prayerRestore() {
        if(getLevelForXP(playerXP[5]) >= 1 && getLevelForXP(playerXP[5]) <= 3) {
            playerLevel[5] += 7;
        } else if(getLevelForXP(playerXP[5]) >= 4 && getLevelForXP(playerXP[5]) <= 7) {
            playerLevel[5] += 8;
        } else if(getLevelForXP(playerXP[5]) >= 8 && getLevelForXP(playerXP[5]) <= 11) {
            playerLevel[5] += 9;
        } else if(getLevelForXP(playerXP[5]) >= 12 && getLevelForXP(playerXP[5]) <= 15) {
            playerLevel[5] += 10;
        } else if(getLevelForXP(playerXP[5]) >= 16 && getLevelForXP(playerXP[5]) <= 19) {
            playerLevel[5] += 11;
        } else if(getLevelForXP(playerXP[5]) >= 20 && getLevelForXP(playerXP[5]) <= 23) {
            playerLevel[5] += 12;
        } else if(getLevelForXP(playerXP[5]) >= 24 && getLevelForXP(playerXP[5]) <= 27) {
            playerLevel[5] += 13;
        } else if(getLevelForXP(playerXP[5]) >= 28 && getLevelForXP(playerXP[5]) <= 31) {
            playerLevel[5] += 14;
        } else if(getLevelForXP(playerXP[5]) >= 32 && getLevelForXP(playerXP[5]) <= 35) {
            playerLevel[5] += 15;
        } else if(getLevelForXP(playerXP[5]) >= 36 && getLevelForXP(playerXP[5]) <= 39) {
            playerLevel[5] += 16;
        } else if(getLevelForXP(playerXP[5]) >= 40 && getLevelForXP(playerXP[5]) <= 43) {
            playerLevel[5] += 17;
        } else if(getLevelForXP(playerXP[5]) >= 44 && getLevelForXP(playerXP[5]) <= 47) {
            playerLevel[5] += 18;
        } else if(getLevelForXP(playerXP[5]) >= 48 && getLevelForXP(playerXP[5]) <= 51) {
            playerLevel[5] += 19;
        } else if(getLevelForXP(playerXP[5]) >= 52 && getLevelForXP(playerXP[5]) <= 55) {
            playerLevel[5] += 20;
        } else if(getLevelForXP(playerXP[5]) >= 56 && getLevelForXP(playerXP[5]) <= 59) {
            playerLevel[5] += 21;
        } else if(getLevelForXP(playerXP[5]) >= 60 && getLevelForXP(playerXP[5]) <= 63) {
            playerLevel[5] += 22;
        } else if(getLevelForXP(playerXP[5]) >= 64 && getLevelForXP(playerXP[5]) <= 67) {
            playerLevel[5] += 23;
        } else if(getLevelForXP(playerXP[5]) >= 68 && getLevelForXP(playerXP[5]) <= 71) {
            playerLevel[5] += 24;
        } else if(getLevelForXP(playerXP[5]) >= 72 && getLevelForXP(playerXP[5]) <= 75) {
            playerLevel[5] += 25;
        } else if(getLevelForXP(playerXP[5]) >= 76 && getLevelForXP(playerXP[5]) <= 79) {
            playerLevel[5] += 26;
        } else if(getLevelForXP(playerXP[5]) >= 80 && getLevelForXP(playerXP[5]) <= 83) {
            playerLevel[5] += 27;
        } else if(getLevelForXP(playerXP[5]) >= 84 && getLevelForXP(playerXP[5]) <= 87) {
            playerLevel[5] += 28;
        } else if(getLevelForXP(playerXP[5]) >= 88 && getLevelForXP(playerXP[5]) <= 91) {
            playerLevel[5] += 29;
        } else if(getLevelForXP(playerXP[5]) >= 92 && getLevelForXP(playerXP[5]) <= 95) {
            playerLevel[5] += 30;
        } else if(getLevelForXP(playerXP[5]) >= 96 && getLevelForXP(playerXP[5]) <= 99) {
            playerLevel[5] += 31;
        }
        if(playerLevel[5] > getLevelForXP(playerXP[5])) {
            playerLevel[5] = getLevelForXP(playerXP[5]);
        }
    }

    /*
     * How long a spell freezes for - lostmyphat
    */

    public int getFreezeTimer(int spell) {
        if (spell == 12861) {
            return 10000;
        }
        if (spell == 12881) {
            return 20000;
        }
        if (spell == 12871) {
            return 30000;
        }
        if (spell == 12891 && multiCombat()) {
            attackPlayersWithin(369, 30, 2);
        }
        if (spell == 1572) {
            return 10000;
        }
        if (spell == 1582) {
            return 20000;
        }
        if (spell == 1592) {
            return 30000;
        }
        return 30;
    }

    /*
     * Handles if spell id is a projectile spell. - lostmyphat
    */

    public boolean Projectile(int spell) {
        if (spell == 12939) {
            return false;
        }
        if (spell == 12987) {
            return false;
        }
        if (spell == 12901) {
            return false;
        }
        if (spell == 12861) {
            return false;
        }
        if (spell == 12951) {
            return false;
        }
        if (spell == 12999) {
            return false;
        }
        if (spell == 12911) {
            return false;
        }
        if (spell == 12871) {
            return false;
        }
        if (spell == 12963) {
            return false;
        }
        if (spell == 13011) {
            return false;
        }
        if (spell == 12919) {
            return false;
        }
        if (spell == 12881) {
            return false;
        }
        if (spell == 12975) {
            return false;
        }
        if (spell == 13023) {
            return false;
        }
        if (spell == 12929) {
            return false;
        }
        if (spell == 12891) {
            return false;
        }
        return true; // Default return true - lostmyphat
    }

    /*
     * Handles most of casting on npcs - lostmyphat
    */

    public void appendHitToNpc(int index, int hitDiff, boolean stillSpell) {
        boolean splash = false;
        if (!playerMage2(index)) {
            splash = true;
        }
        if (!splash) {
            getEnd();
        }
        if (splash) {
            stillgfx(85, fenemyY, fenemyX);
        }
        if (MagicHandler.npcHP - hitDiff < 0 && !splash) {
            hitDiff = MagicHandler.npcHP;
        }
        if (MagicHandler.itHeals && !splash) {
            if (misc.random(2) == 1) {
                currentHealth += hitDiff / 4;
                if (currentHealth > playerLevel[playerHitpoints])
                    currentHealth = playerLevel[playerHitpoints];
                sendQuest("" + currentHealth + "", 4016);
                sM("You drain the enemies health.");
            }
        }
        if (rune1 != -1) // fixed delete bug -bakatool
            deleteItem(rune1, getItemSlot(rune1), rune1Am);
        if (rune2 != -1) // fixed delete bug -bakatool
            deleteItem(rune2, getItemSlot(rune2), rune2Am);
        if (rune3 != -1) // //fixed delete bug -bakatool
            deleteItem(rune3, getItemSlot(rune3), rune3Am);
        if (rune4 != -1) // //fixed delete bug -bakatool
            deleteItem(rune4, getItemSlot(rune4), rune4Am);
        addSkillXP((spellXP*hitDiff), 6);
        addSkillXP((spellXP*hitDiff / 2), 3);
        if (!splash) {
            server.npcHandler.npcs[index].StartKilling = playerId;
            server.npcHandler.npcs[index].RandomWalk = false;
            server.npcHandler.npcs[index].IsUnderAttack = true;
            server.npcHandler.npcs[index].hitDiff = hitDiff;
            server.npcHandler.npcs[index].Killing[playerId] += hitDiff;
            server.npcHandler.npcs[index].updateRequired = true;
            server.npcHandler.npcs[index].hitUpdateRequired = true;
            server.npcHandler.npcs[index].hit = true;
        }
    }

    /*
     *  - Handles most of casting on players. - lostmyphat
    */

    public void appendHitToPlayer(int index, int hitDiff, boolean stillSpell) {
        try {
            if (server.playerHandler.players[index] != null) {
                client mage = (client) server.playerHandler.players[index];
                boolean splash = false;
                if (!playerMage(index)) {
                    splash = true;
                }
                if (!splash) {
                    getEnd();
                }
                if (splash) {
                    stillgfx(85, fenemyY, fenemyX);
                }
                if (MagicHandler.playerHP - hitDiff < 0 && !splash) {
                    hitDiff = MagicHandler.playerHP;
                }
                if (MagicHandler.itHeals && !splash) {
                    if (hitDiff > 0) {
                        currentHealth += hitDiff / 4;
                        if (currentHealth > playerLevel[playerHitpoints])
                            currentHealth = playerLevel[playerHitpoints];
                        sendQuest("" + currentHealth + "", 4016);
                        sM("You drain the enemies health.");
                    }
                }
                if (MagicHandler.itTeleblocks && !splash) {
                    if(System.currentTimeMillis() - lastTeleblock >= 300000) {
                        mage.sM("You have been teleblocked!");
                        server.playerHandler.players[index].lastTeleblock = System.currentTimeMillis();
                    }
                }
                if (MagicHandler.itFreezes && !splash) {
                    if (server.playerHandler.players[index].EntangleDelay <= 0) {
                        server.playerHandler.players[index].lastEntangle = System.currentTimeMillis();
                        server.playerHandler.players[index].entangleDelay = getFreezeTimer(MagicHandler.spellID);
                        mage.sM("You have been frozen!");
                        mage.toX = mage.absX;
                        mage.toY = mage.absY;
                    }
                }
                client player = (client) server.playerHandler.players[playerId];
                if (mage.vengon && hitDiff != 0 && !splash) {
                    player.hitDiff = (int)(hitDiff / 1.2); // Simple math, 100 divided by 1.30, and you get 76.
                    player.currentHealth -= (int)(hitDiff / 1.2);
                    player.hitUpdateRequired = true; // So the hit will append to you.
                    player.updateRequired = true; // So the hit will append to you.
                    player.appearanceUpdateRequired = true; // So the hit will append to you.
                    mage.vengon = false;
                    mage.plrText = "Taste vengeance!"; // This says it in itself.
                    mage.plrTextUpdateRequired = true; // Make sure the txt4 will update.
                }
                if (rune1 != -1)
                    deleteItem(rune1, getItemSlot(rune1), rune1Am);
                if (rune2 != -1)
                    deleteItem(rune2, getItemSlot(rune2), rune2Am);
                if (rune3 != -1)
                    deleteItem(rune3, getItemSlot(rune3), rune3Am);
                if (rune4 != -1)
                    deleteItem(rune4, getItemSlot(rune4), rune4Am);
                addSkillXP((spellXP*hitDiff), 6);
                addSkillXP((spellXP*hitDiff / 2), 3);
                if (!MagicHandler.itTeleblocks && !splash) {
                    server.playerHandler.players[index].dealDamage(hitDiff);
                    server.playerHandler.players[index].hitDiff = hitDiff;
                    server.playerHandler.players[index].updateRequired = true;
                    server.playerHandler.players[index].hitUpdateRequired = true;
                    server.playerHandler.players[index].KilledBy[playerId] += hitDiff;
                    server.playerHandler.players[index].offTimer = System.currentTimeMillis();
                    server.playerHandler.players[index].hitID = playerId;
                    mage.KillerId = playerId;
                }
            }
        } catch (Exception e) {
        }
    }

    /*
     * Handles "tall" spells? - lostmyphat
    */

    public boolean TallSpell(int i) {
        if (i == 12963 || i == 13011 || i == 12919 || i == 12881 || i == 12975 || i == 13023 || i == 12929 || i == 12891) {
            return true;
        }
        return false;
    }

    /*
     * Moving on magic spells? - lostmyphat
    */

    public boolean StillSpell(int i) {
        return false;
    }

    /*
     *  Resetting emote for spells - lostmyphat
    */

    public void resetGFX(int id, int X, int Y) {
        GraphicsHandler.removeGFX(id, X, Y);
        firingspell = false;
        cast = false;
        fired = false;
    }

    /*
     * Handles fire spells - lostmyphat
    */

    public boolean firespell(int castID, int casterY, int casterX, int offsetY,
                             int offsetX, int angle, int speed, int movegfxID, int startHeight,
                             int endHeight, int MageAttackIndex, int finishID, int enemyY,
                             int enemyX) {
        fcastid = castID;
        fcasterY = casterY;
        fcasterX = casterX;
        foffsetY = offsetY;
        foffsetX = offsetX;
        fangle = angle;
        fspeed = speed;
        fmgfxid = movegfxID;
        fsh = startHeight;
        feh = endHeight;
        ffinishid = finishID;
        fenemyY = enemyY;
        fenemyX = enemyX;
        MageAttackIndex = MageAttackIndex;

        /*
         * Spell casting in hands - lostmyphat
        */

        if ((cast == false) && Projectile(MagicHandler.spellID) && casterY == absY && casterX == absX) {
            specGFX(castID);
            cast = true;
            firingspell = true;
        }
        if ((cast == false) && !Projectile(MagicHandler.spellID)) {
            cast = true;
            firingspell = true;
        }
        if ((cast == true) && (fired == false) && Projectile(MagicHandler.spellID)) {
            createProjectile(casterY, casterX, offsetY, offsetX, angle, speed,
                             movegfxID, startHeight, endHeight, MageAttackIndex);
            fired = true;
        }
        if ((cast == true) && (fired == false) && !Projectile(MagicHandler.spellID)) {
            fired = true;
        }
        if (fired == true) {
            resetGFX(castID, enemyX, enemyY);
            return false;
        }
        return true;

    }

    /*
     *  Some sort of checking for prayer level - lostmyphat
    */
    public int checkPrayStat() {
        int bonus = ((7 + playerBonus[11]/2) * 1000);
        return bonus;
    }

    /*
     * Values for prayer degrading - lostmyphat
    */

    public void prayerDrain() {
        if(ProtItem) {
            playerLevel[5] -= 1;
        }
        if(StrPrayer >= 1) {
            playerLevel[5] -= 1;
        }
        if(DefPray >= 1) {
            playerLevel[5] -= 1;
        }
        if(AtkPray >= 1) {
            playerLevel[5] -= 1;
        }
        if(RangePray >= 1) {
            playerLevel[5] -= 1;
        }
        if(MagePray >= 1) {
            playerLevel[5] -= 1;
        }
        if(ProtMage || ProtRange || ProtMelee || Retribution || Redemption || Smite) {
            playerLevel[5] -= 2;
        }
        if(Chivalry) {
            playerLevel[5] -= 1;
        }
        if(Piety) {
            playerLevel[5] -= 2;
        }
    }



    public void sendFrame254(int type, int id, int a, int b, int c) {
        outStream.createFrame(254);
        outStream.writeByte(type);
        if (type == 1) {
            outStream.writeWord(id);
        }
        else if (type >= 2 && type <= 6) {
            outStream.writeWord(a);
            outStream.writeWord(b);
            outStream.writeByte(c);
        }
        else if (type == 10) {
            outStream.writeWord(id);
        }
    }

    /*
     *  Creates arrow GFX for ranging - lostmyphat
    */

    public void createArrow(int type, int id) {
        outStream.createFrame(254); //The packet ID
        outStream.writeByte(type); //1=NPC, 10=Player
        outStream.writeWord(id); //NPC/Player ID
        outStream.write3Byte(0); //Junk
    }

    /*
     *  ^^ - lostmyphat
    */

    public void createArrow(int x, int y, int height, int pos) {
        outStream.createFrame(254); //The packet ID
        outStream.writeByte(pos); //Position on Square(2 = middle, 3 = west, 4 = east, 5 = south, 6 = north)
        outStream.writeWord(x); //X-Coord of Object
        outStream.writeWord(y); //Y-Coord of Object
        outStream.writeByte(height); //Height off Ground
    }

    /*
     * Picking items up; checks if item is there and adds it - lostmyphat
    */

    public void scanPickup() {
        if (absX == apickupx && absY == apickupy) {
            if (ItemHandler.itemExists(apickupid, absX, absY)) {
                int itemAmount = ItemHandler.itemAmount(apickupid, apickupx, apickupy);
                if (addItem(apickupid, itemAmount)) {

                    ItemHandler.removeItem(apickupid, apickupx, apickupy, itemAmount);
                }
            }
            else if (hasntLoggedin) {
            }
            resetPickup();
        }
    }

    /*
     * Resets pickup - lostmyphat
    */

    public void resetPickup() {
        apickupid = -1;
        apickupx = -1;
        apickupy = -1;
    }

    /*
     * Replacing item in bag - lostmyphat
    */

    public void replaceitem(int oldID, int newID) {

        for(int i2 = 0; i2 < playerItems.length; i2++) {
            if(playerItems[i2] == oldID+1) {
                int newamount = playerItemsN[i2];
                deleteItem(oldID, getItemSlot(oldID), playerItemsN[i2]);
                addItem(newID, newamount);
            }
        }
    }

    /*
     * Adding item on player position? - lostmyphat
    */

    public void replaceitem2(int oldID, int newID) {

        for(int i2 = 0; i2 < playerItems.length; i2++) {
            if(playerItems[i2] == oldID+1) {
                int newamount = playerItemsN[i2];
                deleteItem(oldID, getItemSlot(oldID), playerItemsN[i2]);
                ItemHandler.addItem(newID, absX, absY, newamount, playerId, false);
            }
        }
    }

    /*
     * Sends text in chat box - lostmyphat
    */

    public void sendInterface(String text) {
        sendFrame126(text, 357);
        sendFrame164(356);
    }

    /*
     * Used for player shouting? - lostmyphat
    */

    public void say(String what) {
        plrText = what;
        plrTextUpdateRequired = true;
    }

    /*
     * Opens deposit box - lostmyphat
    */

    public void openUpDepBox() {
        sendFrame248(4465, 197);
        resetItems(7423);
        IsBanking = true;
    }

    /*
     *  Player specing hit calculating - lostmyphat
    */

    public void getHit(int extraDamage) {
        client AttackingOn2 = (client) server.playerHandler.players[AttackingOn];
        int voidmelee = 0;
        if(FullVMelee()) {
            voidmelee += 10;
        }
        if(AttackingOn2.deathStage != 0 || AttackingOn2.currentHealth <= 0)
            return;
        int hit = misc.random(playerMaxHit) + misc.random(StrPrayer) + misc.random(extraDamage) + misc.random(voidmelee);
        int aBonus = 0;
        int rand_att = misc.random(playerLevel[0])*3 + misc.random(AtkPray * 8);
        int rand_def = (int) (0.65 * misc.random(AttackingOn2.playerLevel[1]) + AttackingOn2.DefPray * 8);
        if(AttackingOn2.ProtMelee) {
            rand_def += misc.random(100);
        }
        if (FightType == 1)
            aBonus += (int) (playerBonus[1] / 20);
        int random_u = misc.random(playerBonus[1] + aBonus) * 2;
        int dBonus = 0;
        if (AttackingOn2.FightType == 4)
            dBonus += (int) (AttackingOn2.playerBonus[6] / 20);
        int random_def = misc.random(AttackingOn2.playerBonus[6] + dBonus + AttackingOn2.AtkPray * 8);
        int noHit = misc.random(2);
        if (AttackingOn2.ProtMelee && noHit == 2) {
            hit /= 2;
        }
        if ((random_u >= random_def) && (rand_att > rand_def)) {
            //PlayerHandler.players[AttackingOn].dealDamage(hit);
            PlayerHandler.players[AttackingOn].hitDiff = hit;
            SpecDamg(hit);
        } else {
            PlayerHandler.players[AttackingOn].hitDiff = 0;
        }

        PlayerHandler.players[AttackingOn].updateRequired = true;
        PlayerHandler.players[AttackingOn].hitUpdateRequired = true;
    }

    /*
     * ^^ - lostmyphat
    */

    public void getHitDouble(int extraDamage) {
        client AttackingOn2 = (client) server.playerHandler.players[AttackingOn];
        int voidmelee = 0;
        if(FullVMelee()) {
            voidmelee += 10;
        }
        if(AttackingOn2.deathStage != 0 || AttackingOn2.currentHealth <= 0)
            return;
        int hit = misc.random(playerMaxHit) + misc.random(StrPrayer) + misc.random(extraDamage) + misc.random(voidmelee);
        int aBonus = 0;
        int rand_att = misc.random(playerLevel[0])*3 + misc.random(AtkPray * 8);
        int rand_def = (int) (0.65 * misc.random(AttackingOn2.playerLevel[1]) + AttackingOn2.DefPray * 8);
        if(AttackingOn2.ProtMelee) {
            rand_def += misc.random(100);
        }
        if (FightType == 1)
            aBonus += (int) (playerBonus[1] / 20);
        int random_u = misc.random(playerBonus[1] + aBonus) * 2;
        int dBonus = 0;
        if (AttackingOn2.FightType == 4)
            dBonus += (int) (AttackingOn2.playerBonus[6] / 20);
        int random_def = misc.random(AttackingOn2.playerBonus[6] + dBonus + AttackingOn2.AtkPray * 8);
        int noHit = misc.random(2);
        if (AttackingOn2.ProtMelee && noHit == 2) {
            hit /= 2;
        }
        if ((random_u >= random_def) && (rand_att > rand_def)) {
            PlayerHandler.players[AttackingOn].dealDamage(hit);
            PlayerHandler.players[AttackingOn].hitDiff = hit;
            SpecDamg(hit);
        } else {
            PlayerHandler.players[AttackingOn].hitDiff = 0;
        }
        PlayerHandler.players[AttackingOn].updateRequired = true;
        PlayerHandler.players[AttackingOn].hitUpdateRequired = true;
    }

    /*
     *  ^^ For npcs - lostmyphat
    */

    public void getHit2() {
        if(IsAttacking && AttackingOn > 0) {
            int hit = misc.random(maxRangeHit());
            PlayerHandler.players[AttackingOn].dealDamage(hit);
            PlayerHandler.players[AttackingOn].hitDiff = hit;
            PlayerHandler.players[AttackingOn].updateRequired = true;
            PlayerHandler.players[AttackingOn].hitUpdateRequired = true;
        }
        if(IsAttackingNPC && attacknpc > 0) {
            if(server.npcHandler.npcs[attacknpc] != null)
            {
                if (server.npcHandler.npcs[attacknpc].IsDead == false) {
                    server.npcHandler.npcs[attacknpc].hitDiff = misc.random(maxRangeHit2());
                    server.npcHandler.npcs[attacknpc].HP -= hitDiff;
                    server.npcHandler.npcs[attacknpc].updateRequired = true;
                    server.npcHandler.npcs[attacknpc].hitUpdateRequired = true;
                    server.npcHandler.npcs[attacknpc].hit = true;
                }
            }
        }
    }

    /*
     *  Something to do with moving - lostmyphat
    */

    public int getMove(int i, int j)
    {
        if(i - j == 0)
        {
            return 0;
        }
        if(i - j < 0)
        {
            return 1;
        }
        return i - j <= 0 ? 0 : -1;
    }

    /*
    *  Checks headicon and sends right one depending on prayer - lostmyphat
    */

    public void checkHead() {
        if(!isSkulled) {
            headIcon = 0;
        }
        if(isSkulled) {
            headIcon = 64;
        }
    }

    public void getHead() {
        if (ProtMage && !isSkulled)
            headIcon = 4;
        if (ProtRange && !isSkulled)
            headIcon = 2;
        if (ProtMelee && !isSkulled)
            headIcon = 1;
        if (Retribution && !isSkulled)
            headIcon = 8;
        if (Redemption && !isSkulled)
            headIcon = 32;
        if (Smite && !isSkulled)
            headIcon = 16;
        if (ProtMage && isSkulled)
            headIcon = 68;
        if (ProtRange && isSkulled)
            headIcon = 66;
        if (ProtMelee && isSkulled)
            headIcon = 65;
        if (Retribution && isSkulled)
            headIcon = 72;
        if (Redemption && isSkulled)
            headIcon = 96;
        if (Smite && isSkulled)
            headIcon = 80;
        else if (!ProtMage && !ProtRange && !ProtMelee && !Retribution && !Redemption && !Smite)
            headIcon = 64;
    }

    public void turnOffHead() {
        if(ProtMage)
            headIcon = 4;
        if(ProtRange)
            headIcon = 2;
        if(ProtMelee)
            headIcon = 1;
        if(Retribution)
            headIcon = 8;
        if(Redemption)
            headIcon = 32;
        if(Smite)
            headIcon = 16;
        else if(!isSkulled && !ProtMage && !ProtRange && !ProtMelee && !Retribution && !Redemption && !Smite)
            headIcon = 0;
    }

    /*
     *  Creates projectile of range - lostmyphat
    */

    public void rangeGFX(int speed, int arrow) {
        int EnemyX = 0;
        int EnemyY = 0;
        client AttackingOn2 = (client) server.playerHandler.players[AttackingOn];
        if(AttackingOn2 != null) {
            EnemyX = PlayerHandler.players[AttackingOn].absX;
            EnemyY = PlayerHandler.players[AttackingOn].absY;
        }
        int offsetX = (absY - EnemyY) * -1;
        int offsetY = (absX - EnemyX) * -1;
        CreateProjectile(absY, absX, offsetY, offsetX, 50, speed, arrow, 43, 31, -AttackingOn-1);
    }

    /*
     * Same thing as above, but for npcs  - lostmyphat
    */

    public void rangeGFXNPC(int speed, int arrow) {
        int EnemyX = server.npcHandler.npcs[attacknpc].absX;
        int EnemyY = server.npcHandler.npcs[attacknpc].absY;
        int offsetX = (absY - EnemyY) * -1;
        int offsetY = (absX - EnemyX) * -1;
        CreateProjectile(absY, absX, offsetY, offsetX, 50, speed, arrow, 43, 31, attacknpc + 1);
    }

    /*
     *  Adds bonus to mage items when casting? - lostmyphat
    */

    public boolean playerMage(int index) {
        int protmage = 0;
        int mystic = 0;
        if (server.playerHandler.players[index] == null) {
            return false;
        }
        if(MagePray == 5) {
            mystic = 15;
        }
        if(server.playerHandler.players[index].ProtMage) {
            protmage = 100;
        }
        int enemyDef = server.playerHandler.players[index].playerBonus[8] + protmage;
        int myBonus = playerBonus[3] + 30 + mystic;

        if (misc.random(myBonus) > misc.random(enemyDef)) {
            return true;
        }
        return false;
    }

    /*
     * ^^  - lostmyphat
    */

    public boolean playerMage2(int indexx) {
        int magicBonus = playerBonus[3]*5 + misc.random(100);
        if(FullVMage()) {
            magicBonus += misc.random(50);
        }
        int negative = CheckBestBonus2();
        int negativeBonus = playerBonus[negative];
        if (misc.random(magicBonus) > misc.random(negativeBonus)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     *  Something to do with player bonuses and returning values - lostmyphat
    */

    public int CheckBestBonus2() {
        if (playerBonus[6] > playerBonus[7] && playerBonus[6] > playerBonus[8]) {
            return 6;
        }
        if (playerBonus[7] > playerBonus[6] && playerBonus[7] > playerBonus[8]) {
            return 7;
        }
        if (playerBonus[8] > playerBonus[6] && playerBonus[8] > playerBonus[7]) {
            return 8;
        } else {
            return 0;
        }
    }

    /*
     * Resets following  - lostmyphat
    */

    public void resetfollowers()
    {
        PlayerHandler _tmp = server.playerHandler;
        Player aplayer[] = PlayerHandler.players;
        int j = aplayer.length;
        for(int k = 0; k < j; k++)
        {
            Player player = aplayer[k];
            if(player == null)
            {
                continue;
            }
            client client1 = (client)player;
            if(client1.followID == playerId)
            {
                client1.followID = 0;
            }
        }

    }

    /*
     * Sends frames to kill wildy sign  - lostmyphat
    */

    public void wildysigndisappear()
    {
        sendFrame126("", 13589);
        sendFrame126("", 13590);
        sendFrame126("", 13591);
        sendFrame126("", 13592);
        sendFrame126("", 13593);
        sendFrame126("", 13594);
        sendFrame126("", 13595);
        sendFrame126("", 13596);
        sendFrame126("", 13597);
        sendFrame126("", 13598);
        sendFrame126("", 13599);
        sendFrame126("", 13600);
        setInterfaceWalkable(13588);
    }

    /*
     *  Booleans for items for ranging, checks if bowid == crystal bow and if != return false - lostmyphat
    */

    public boolean teleblock = false;

    public boolean hasCrystalBow() {
        if(playerEquipment[playerWeapon] == 4214 || playerEquipment[playerWeapon] == 4215 || playerEquipment[playerWeapon] == 4216 || playerEquipment[playerWeapon] == 4217 || playerEquipment[playerWeapon] == 4218 || playerEquipment[playerWeapon] == 4219 || playerEquipment[playerWeapon] == 4220 || playerEquipment[playerWeapon] == 4221 || playerEquipment[playerWeapon] == 4222 ||
                playerEquipment[playerWeapon] == 4223) {
            return true;
        }
        return false;
    }

    public boolean hasCrystalShield() {
        if(playerEquipment[playerShield] == 4224 ||playerEquipment[playerShield] == 4225 || playerEquipment[playerShield] == 4226 || playerEquipment[playerShield] == 4227 || playerEquipment[playerShield] == 4228 || playerEquipment[playerShield] == 4229 || playerEquipment[playerShield] == 4230 || playerEquipment[playerShield] == 4231 || playerEquipment[playerShield] == 4232 || playerEquipment[playerShield] == 4234 ||
                playerEquipment[playerShield] == 4234) {
            return true;
        }
        return false;
    }

    public boolean checkPrayOn() {
        if(DefPray != 0 || AtkPray != 0 || StrPrayer != 0 || RangePray != 0 || MagePray != 0 || PrayHeal || ProtItem || ProtMage || ProtRange || ProtMelee || Redemption || Retribution || Smite || Chivalry || Piety) {
            return true;
        }
        return false;
    }

    /*
     *  Freezing with magic - lostmyphat
    */

    public void ifFreeze(int delay2) {
        if(EntangleDelay == 0) {
            EntangleDelay = delay2;
            sM("You have been frozen!");
            toX = absX;
            toY = absY;
            newWalkCmdSteps = 0;
            newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
            getNextPlayerMovement();
        }
    }

    /*
     *  Not important, prob. isn't even used - lostmyphat
    */


    public void giveItems() {
        client other = getClient(trade_reqId);
        if (validClient(trade_reqId)) {
            try {
                for (GameItem item: other.offeredItems) {
                    if (item.id > 0) {
                        addItem2(item.id, item.amount);
                        //println("TradeConfirmed, item="+item.id);

                    }
                }
                closeInterface();
                tradeResetNeeded = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * Resets all prayers when loses all prayer points  - lostmyphat
    */

    public void prayOff() {
        if(!isSkulled) {
            headIcon = 0;
        }
        if(isSkulled) {
            headIcon = 64;
        }
        DefPray = 0;
        AtkPray = 0;
        StrPrayer = 0;
        RangePray = 0;
        MagePray = 0;
        PrayHeal = false;
        ProtItem = false;
        ProtMage = false;
        ProtRange = false;
        ProtMelee = false;
        Redemption = false;
        Retribution = false;
        Smite = false;
        Chivalry = false;
        Piety = false;
        prayOn = false;
        sM("You have run out of prayer points, you must recharge at an altar.");
        turnpray();
        updateRequired = true;
        appearanceUpdateRequired = true;
    }

    /*
     *  ^^ - lostmyphat
    */

    public void prayOff2() {
        if(!isSkulled) {
            headIcon = 0;
        }
        if(isSkulled) {
            headIcon = 64;
        }
        DefPray = 0;
        AtkPray = 0;
        StrPrayer = 0;
        RangePray = 0;
        MagePray = 0;
        PrayHeal = false;
        ProtItem = false;
        ProtMage = false;
        ProtRange = false;
        ProtMelee = false;
        Redemption = false;
        Retribution = false;
        Smite = false;
        Chivalry = false;
        Piety = false;
        prayOn = false;
        turnpray();
        updateRequired = true;
        appearanceUpdateRequired = true;
    }


    /* MISC */
    public int i;

    private java.io.InputStream in; //private java.io.DataInputStream in;
    private java.io.OutputStream out; //private java.io.DataOutputStream out;

    public stream inStream = null, outStream = null;

    public Cryption inStreamDecryption = null, outStreamDecryption = null;

    private java.net.Socket mySock;

    /*
     *  Performing gfxs - lostmyphat
    */

    public void lowGFX(int id, int delay) {
        mask100var1 = id;
        mask100var2 = delay;
        mask100update = true;
        updateRequired = true;
    }

    /*
     *  ^^ - lostmyphat
    */

    public void specGFX(int gfx) {
        if(gfx == 343)
            return;
        mask100var1 = gfx;
        mask100var2 = 6553600;
        mask100update = true;
        updateRequired = true;
    }

    /*
     *  Gets value/time for weapon to hit - lostmyphat
    */

    public int getbattleTimer() {
        if (playerEquipment[playerWeapon]==35 || playerEquipment[playerWeapon]==667 || playerEquipment[playerWeapon]==2402 || playerEquipment[playerWeapon]==746 || playerEquipment[playerWeapon]==6528 || playerEquipment[playerWeapon]==4153 || playerEquipment[playerWeapon]==4718 ||playerEquipment[playerWeapon]==1377 || playerEquipment[playerWeapon]==3204 || playerEquipment[playerWeapon]==4827 || playerEquipment[playerWeapon]==7158 || playerEquipment[playerWeapon]==1319) {
            return 4500;
        } else {
            if (playerEquipment[playerWeapon]==837 || playerEquipment[playerWeapon]==1305) {
                return 3000;
            } else {
                if (playerEquipment[playerWeapon] == 839 || playerEquipment[playerWeapon] == 841 || playerEquipment[playerWeapon] == 843 ||  playerEquipment[playerWeapon] == 845 ||  playerEquipment[playerWeapon] == 847 ||  playerEquipment[playerWeapon] == 849 || playerEquipment[playerWeapon] == 851 ||  playerEquipment[playerWeapon] == 853 || playerEquipment[playerWeapon] == 855 ||  playerEquipment[playerWeapon] == 857 || playerEquipment[playerWeapon] == 861 || playerEquipment[playerWeapon] == 4734 || playerEquipment[playerWeapon] == 6522) {
                    return 1500;
                } else {
                    return 2500;
                }
            }
        }
    }

    /*
     *  Handles specials - lostmyphat
    */

    public void specAttack() {
        server.special.specialAttacks(playerId);
        server.special.specialAttacks2(playerId);
        server.special.specialAttacks3(playerId);
        server.special.specialAttacks4(playerId);
        server.special.specialAttacks5(playerId);
        server.special.specialAttacks6(playerId);
    }

    /*
     *  Walktimers - lostmyphat
    */


    public void WalkTimer(int i, int j) {
        if(EntangleDelay > 0)
            return;
        newWalkCmdSteps = 0;
        if(++newWalkCmdSteps > 50)
            newWalkCmdSteps = 0;
        int k = absX + i;
        k -= mapRegionX * 8;
        newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
        int l = absY + j;
        l -= mapRegionY * 8;
        newWalkCmdIsRunning = ((inStream.readSignedByteC() == 1) && playerEnergy > 0);
        for(this.i = 0; this.i < newWalkCmdSteps; this.i++)
        {
            newWalkCmdX[this.i] += k;
            newWalkCmdY[this.i] += l;
        }
        lastWalk = System.currentTimeMillis();
        walkDelay = 8000;
        poimiY = l;
        poimiX = k;
    }

    /*
     *  ^^ - lostmyphat
    */

    public void WalkTo2(int i, int j) {
        newWalkCmdSteps = 0;
        if(++newWalkCmdSteps > 50)
            newWalkCmdSteps = 0;
        int k = absX + i;
        k -= mapRegionX * 8;
        newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
        int l = absY + j;
        l -= mapRegionY * 8;
        isRunning2 = false;
        isRunning = false;
        for(this.i = 0; this.i < newWalkCmdSteps; this.i++) {
            newWalkCmdX[this.i] += k;
            newWalkCmdY[this.i] += l;
        }
        lastWalk = System.currentTimeMillis();
        walkDelay = 20000;
        poimiY = l;
        poimiX = k;
    }

    /*
     *  Walking to target after frozen - lostmyphat
    */

    public void walkTo(int i, int j)
    {
        if(EntangleDelay > 0)
            return;
        newWalkCmdSteps = 0;
        if(++newWalkCmdSteps > 50)
            newWalkCmdSteps = 0;
        int k = absX + i;
        k -= mapRegionX * 8;
        newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
        int l = absY + j;
        l -= mapRegionY * 8;
        newWalkCmdIsRunning = ((inStream.readSignedByteC() == 1) && playerEnergy > 0);
        for(this.i = 0; this.i < newWalkCmdSteps; this.i++) {
            newWalkCmdX[this.i] += k;
            newWalkCmdY[this.i] += l;
        }

        poimiY = l;
        poimiX = k;
    }

    /*
     *  Item name for switching attack options - lostmyphat
    */

    public String GetItemName(int ItemID) {
        for (int i = 0; i < server.itemHandler.MaxListedItems; i++) {
            if (server.itemHandler.ItemList[i] != null) {
                if (server.itemHandler.ItemList[i].itemId == ItemID) {
                    return server.itemHandler.ItemList[i].itemName;
                }
                if (ItemID == -1) {
                    return "Unarmed";
                }
            }
        }
        return "!! NOT EXISTING ITEM !!! - ID:" +ItemID;
    }

    /*
     *  Handles spec on players - lostmyphat
    */

    public void SpecDamg(int maxDamage) {
        for (Player p : server.playerHandler.players) {
            if(p != null) {
                if (PlayerHandler.players[AttackingOn].deathStage < 1) {
                    int damage = misc.random(maxDamage);
                    if (PlayerHandler.players[AttackingOn].playerLevel[3] - hitDiff < 0)
                        PlayerHandler.players[AttackingOn].hitDiff = damage;
                    PlayerHandler.players[AttackingOn].updateRequired = true;
                    PlayerHandler.players[AttackingOn].hitUpdateRequired = true;
                }
            }
        }
    }

    /*
     *  Handles spec damages on NPCS - lostmyphat
    */

    public void SpecDamgNPC(int maxDamage) {
        if(server.npcHandler.npcs[attacknpc] != null) {
            if (server.npcHandler.npcs[attacknpc].IsDead == false) {
                int voidmelee = 0;
                if(FullVMelee()) {
                    voidmelee += 10;
                }
                int damage = misc.random(maxDamage) + misc.random(voidmelee);
                if (NPChitting.npcHit()) {
                    damage = 0;
                }
                if (server.npcHandler.npcs[attacknpc].HP - hitDiff < 0)
                    damage = server.npcHandler.npcs[attacknpc].HP;
                server.npcHandler.npcs[attacknpc].StartKilling = playerId;
                server.npcHandler.npcs[attacknpc].RandomWalk = false;
                server.npcHandler.npcs[attacknpc].IsUnderAttack = true;
                server.npcHandler.npcs[attacknpc].hitDiff = damage;
                server.npcHandler.npcs[attacknpc].HP -= damage;
                server.npcHandler.npcs[attacknpc].updateRequired = true;
                server.npcHandler.npcs[attacknpc].hitUpdateRequired = true;
            }
        }
    }

    /*
     * Return true if boolean fullvmage == true - lostmyphat
    */

    public boolean FullVMage() {
        if(playerEquipment[playerHat] == 2518 && playerEquipment[playerChest] == 2520 && playerEquipment[playerLegs] == 2522) {
            return true;
        }
        return false;
    }
    public boolean FullVRange() {
        if(playerEquipment[playerHat] == 2524 && playerEquipment[playerChest] == 2520 && playerEquipment[playerLegs] == 2523) {
            return true;
        }
        return false;
    }
    public boolean FullVMelee() {
        if(playerEquipment[playerHat] == 2526 && playerEquipment[playerChest] == 2520 && playerEquipment[playerLegs] == 2522) {
            return true;
        }
        return false;
    }
    public boolean FullVeracEquipped() {
        if(playerEquipment[playerHat] == 4753 && playerEquipment[playerChest] == 4757 && playerEquipment[playerLegs] == 4759 && playerEquipment[playerWeapon] == 4755) {
            return true;
        }
        return false;
    }
    public boolean FullGuthanEquipped() {
        if(playerEquipment[playerHat] == 4724 && playerEquipment[playerChest] == 4728 && playerEquipment[playerLegs] == 4730 && playerEquipment[playerWeapon] == 4726) {
            return true;
        }
        return false;
    }
    public boolean FullDharokEquipped() {
        if(playerEquipment[playerHat] == 4716 && playerEquipment[playerChest] == 4720 && playerEquipment[playerLegs] == 4722 && playerEquipment[playerWeapon] == 4718) {
            return true;
        }
        return false;
    }

    /*
     * Switching magic books - lostmyphat
    */

    public void switchBooks() {
        interfaceEffect = 2;
        setAnimation(1652);
        clearQuestInterface();
        sendFrame126("Normal Magic", 2494);
        sendFrame126("", 2495);
        sendFrame126("", 2496);
        sendFrame126("", 2497);
        sendFrame126("Ancient Magic", 2498);
        sendQuestSomething(8143);
        sendFrame164(2492);
        flushOutStream();
    }

    /*
     * Sends some frame - lostmyphat
    */

    public void sendFrame106(int i1) {
        outStream.createFrame(106);
        outStream.writeByteC(i1);
    }

    public void sendQuest(String s, int id) {
        try {
            outStream.createFrameVarSizeWord(126);
            outStream.writeString(s);
            outStream.writeWordA(id);
            outStream.endFrameVarSizeWord();
        } catch (Exception e) {
            server.logError(e.getMessage());
        }
    }

    /*
     * Deleting object coords on login - lostmyphat
    */

    public void deletethatobject(int objectX, int objectY) {
        ReplaceObject2(objectX, objectY, 6951, -1, 10);
    }


    public void Deleteobjects() {

        //       deletethatobject(2898, 3428);

    }

    /*
     *  Makes objects - lostmyphat
    */

    public void makeGlobalObject(int x, int y, int typeID, int orientation, int tileObjectType) { //Makes Global objects
        for (Player p : server.playerHandler.players) {
            if(p != null) {
                client person = (client)p;
                if((person.playerName != null || person.playerName != "null")) {
                    if(person.distanceToPoint(x, y) <= 60) {
                        person.createNewTileObject(x, y, typeID, orientation, tileObjectType);
                    }
                }
            }
        }
    }

    /*
     * Makes objects on startup - lostmyphat
    */

    public void NewObjects() {
        // makeGlobalObject(3509, 9496, 3831, 0, 10);

    }

    public boolean HasItemAmount(int itemID, int itemAmount) {
        int playerItemAmountCount = 0;
        for (int i=0; i<playerItems.length; i++) {
            if (playerItems[i] == itemID+1) {
                playerItemAmountCount = playerItemsN[i];
            }
            if(playerItemAmountCount >= itemAmount) {
                return true;
            }
        }
        return false;
    }

    /*
     * Coordinates for multi combat - lostmyphat
    */

    public boolean multiCombat() {
        if((absX >= 3144 && absX <= 3184 && absY >= 3519 && absY <=3656) || (absX >= 3185 && absX <= 3350 && absY >= 3502 && absY <=3900) || (absX >= 2983 && absX <= 3007 && absY >= 3905 && absY <=3917) || (absX >= 3007 && absX <= 3075 && absY >= 3608 && absY <=3713) || (absX >= 2944 && absX <= 2963 && absY >= 3812 && absY <=3827) || (absX >= 3041 && absX <= 3057 && absY >= 3869 && absY <=3883) || (absX >= 3157 && absX <= 3181 && absY >= 3874 && absY <=3895) || (absX >= 2720 && absX <= 2760 && absY >= 5073 && absY <=5114) || (absX >= 2256 && absX <= 2287 && absY >= 4680 && absY <=4711) || (absX >= 2360 && absX <= 2445 && absY >= 5045 && absY <= 5125) || (absX >= 2760 && absX <= 2780 && absY >= 2790 && absY <=2810) || (absX >= 2624 && absX <= 2690 && absY >= 2550 && absY <=2619) || (absX >= 3460 && absX <= 3520 && absY >= 9470 && absY <=9530) || (absX >= 2371 && absX <= 2424 && absY >= 5125 && absY <=5167) || (absX >= 2627 && absX <= 2677 && absY >= 4550 && absY <=4602) || (absX >= 3249 && absX <= 3307 && absY >= 3904 && absY <=3952) || (absX >= 2420 && absX <= 2520 && absY >= 10100 && absY <=10200) || (absX >= 2992 && absX <= 3090 && absY >= 4804 && absY <=4872))
            return true;
        else
            return false;
    }

    /*
     * Void called on death - lostmyphat
    */

    public void youdied()
    {

        if (!isSkulled) {
            keepItemHandle();
        }
        if (ProtItem) {
            applyProtectItemProt();
        }
        for(int rr=0; rr<playerItems.length; rr++) {
            try {
                if(playerItems[rr] > 0 && playerItems[rr] < 11999) {		//createItem(currentX,currentY,playerItems[rr]-1);

                    //server.checkPlayerCapes.checkDrop(this);
                    ItemHandler.addItem(playerItems[rr]-1, absX, absY, playerItemsN[rr], KillerId, false);
                    //createGroundItem(playerItems[rr]-1, absX, absY, playerItemsN[i]);
                    deleteItem(playerItems[rr]-1, getItemSlot(playerItems[rr]-1), playerItemsN[rr]);

                }
            } catch(Exception e) {  }
        }
        for(int r=0; r<playerEquipment.length; r++) {
            try {
                int item = playerEquipment[r];
                if((item > 0) && (item < 11999)) {
                    remove(item, r);
                }
            } catch(Exception e) {
                sM("ERROR: Removing Equipment");
            }
        }


        for(int rr=0; rr<playerItems.length; rr++) {
            try {
                if(playerItems[rr] > 0 && playerItems[rr] < 11999) {
//createItem(currentX,currentY,playerItems[rr]-1);

                    //server.checkPlayerCapes.checkDrop(this);
                    ItemHandler.addItem(playerItems[rr]-1, absX, absY, playerItemsN[rr], KillerId, false);
                    //createGroundItem(playerItems[rr]-1, absX, absY, playerItemsN[i]);
                    deleteItem(playerItems[rr]-1, getItemSlot(playerItems[rr]-1), playerItemsN[rr]);
                }
            } catch(Exception e) {  }
        }
        try {

        } catch(Exception e) {}
        ItemHandler.addItem(526, absX, absY, 1, KillerId, false);
        try {
        } catch(Exception e) {}
        if (itemKept1 > 0)
            addItem(itemKept1, 1);
        if (itemKept2 > 0)
            addItem(itemKept2, 1);
        if (itemKept3 > 0)
            addItem(itemKept3, 1);
        if (itemKept4 > 0)
            addItem(itemKept4, 1);
        if (keep6570) {
            addItem(6570, 1);
            keep6570 = false;
        }

        resetKeepItem();
        hitDiff = 0;
        updateRequired = true;
        appearanceUpdateRequired = true;
    }



    public void resetKeepItem()
    {
        itemKept1 = itemKept2 = itemKept3 = itemKept4 = -1;
        itemKept1Slot = itemKept2Slot = itemKept3Slot = itemKept4Slot = -1;
    }
    public void keepItemHandle()
    {
        ItemKeeping.keepItem1();
        ItemKeeping.keepItem2();
        ItemKeeping.keepItem3();
        if (itemKept1 > 0)
        {
            if (itemSlot1)
                deleteItem(itemKept1, itemKept1Slot, 1);
            else if (!itemSlot1)
                deleteequiment(itemKept1, itemKept1Slot);
        }
        if (itemKept2 > 0)
        {
            if (itemSlot2)
                deleteItem(itemKept2, itemKept2Slot, 1);
            else if (!itemSlot2)
                deleteequiment(itemKept2, itemKept2Slot);
        }
        if (itemKept3 > 0)
        {
            if (itemSlot3)
                deleteItem(itemKept3, itemKept3Slot, 1);
            else if (!itemSlot3)
                deleteequiment(itemKept3, itemKept3Slot);
        }
    }

    public void applyProtectItemProt()
    {
        if(!isSkulled)
            ItemKeeping.keepItem4();
        if (itemKept4 > 0)
        {
            if (itemSlot4)
                deleteItem(itemKept4, itemKept4Slot, 1);
            else if (!itemSlot4)
                deleteequiment(itemKept4, itemKept4Slot);
        }
        if(isSkulled)
            ItemKeeping.keepItem1();
        if (itemKept1 > 0)
        {
            if (itemSlot1)
                deleteItem(itemKept1, itemKept1Slot, 1);
            else if (!itemSlot1)
                deleteequiment(itemKept1, itemKept1Slot);
        }
    }

    public void refreshSkills() {

        sendQuest("" + playerLevel[0] + "", 4004);
        sendQuest("" + playerLevel[2] + "", 4006);
        sendQuest("" + playerLevel[1] + "", 4008);
        sendQuest("" + playerLevel[4] + "", 4010);
        sendQuest("" + playerLevel[5] + "", 4012);
        sendQuest("" + playerLevel[6] + "", 4014);
        sendQuest("" + currentHealth + "", 4016);
        sendQuest("" + playerLevel[16] + "", 4018);
        sendQuest("" + playerLevel[15] + "", 4020);
        sendQuest("" + playerLevel[17] + "", 4022);
        sendQuest("" + playerLevel[12] + "", 4024);
        sendQuest("" + playerLevel[9] + "", 4026);
        sendQuest("" + playerLevel[14] + "", 4028);
        sendQuest("" + playerLevel[13] + "", 4030);
        sendQuest("" + playerLevel[10] + "", 4032);
        sendQuest("" + playerLevel[7] + "", 4034);
        sendQuest("" + playerLevel[11] + "", 4036);
        sendQuest("" + playerLevel[8] + "", 4038);
        sendQuest("" + playerLevel[20] + "", 4152);
        sendQuest("" + playerLevel[18] + "", 12166);
        sendQuest("" + playerLevel[19] + "", 13926);

        sendQuest("" + getLevelForXP(playerXP[0]) + "", 4005);
        sendQuest("" + getLevelForXP(playerXP[2]) + "", 4007);
        sendQuest("" + getLevelForXP(playerXP[1]) + "", 4009);
        sendQuest("" + getLevelForXP(playerXP[4]) + "", 4011);
        sendQuest("" + getLevelForXP(playerXP[5]) + "", 4013);
        sendQuest("" + getLevelForXP(playerXP[6]) + "", 4015);
        sendQuest("" + getLevelForXP(playerXP[3]) + "", 4017);
        sendQuest("" + getLevelForXP(playerXP[16]) + "", 4019);
        sendQuest("" + getLevelForXP(playerXP[15]) + "", 4021);
        sendQuest("" + getLevelForXP(playerXP[17]) + "", 4023);
        sendQuest("" + getLevelForXP(playerXP[12]) + "", 4025);
        sendQuest("" + getLevelForXP(playerXP[9]) + "", 4027);
        sendQuest("" + getLevelForXP(playerXP[14]) + "", 4029);
        sendQuest("" + getLevelForXP(playerXP[13]) + "", 4031);
        sendQuest("" + getLevelForXP(playerXP[10]) + "", 4033);
        sendQuest("" + getLevelForXP(playerXP[7]) + "", 4035);
        sendQuest("" + getLevelForXP(playerXP[11]) + "", 4037);
        sendQuest("" + getLevelForXP(playerXP[8]) + "", 4039);
        sendQuest("" + getLevelForXP(playerXP[20]) + "", 4153);
        sendQuest("" + getLevelForXP(playerXP[18]) + "", 12167);
        sendQuest("" + getLevelForXP(playerXP[19]) + "", 13927);

        sendQuest("" + playerXP[0] + "", 4044);
        sendQuest("" + playerXP[2] + "", 4050);
        sendQuest("" + playerXP[1] + "", 4056);
        sendQuest("" + playerXP[4] + "", 4062);
        sendQuest("" + playerXP[5] + "", 4068);
        sendQuest("" + playerXP[6] + "", 4074);
        sendQuest("" + playerXP[3] + "", 4080);
        sendQuest("" + playerXP[16] + "", 4086);
        sendQuest("" + playerXP[15] + "", 4092);
        sendQuest("" + playerXP[17] + "", 4098);
        sendQuest("" + playerXP[12] + "", 4104);
        sendQuest("" + playerXP[9] + "", 4110);
        sendQuest("" + playerXP[14] + "", 4116);
        sendQuest("" + playerXP[13] + "", 4122);
        sendQuest("" + playerXP[10] + "", 4128);
        sendQuest("" + playerXP[7] + "", 4134);
        sendQuest("" + playerXP[11] + "", 4140);
        sendQuest("" + playerXP[8] + "", 4146);
        sendQuest("" + playerXP[20] + "", 4157);
        sendQuest("" + playerXP[18] + "", 12171);
        sendQuest("" + playerXP[19] + "", 13921);

        sendQuest("" + getXPForLevel(playerLevel[0] + 1) + "", 4045);
        sendQuest("" + getXPForLevel(playerLevel[2] + 1) + "", 4051);
        sendQuest("" + getXPForLevel(playerLevel[1] + 1) + "", 4057);
        sendQuest("" + getXPForLevel(playerLevel[4] + 1) + "", 4063);
        sendQuest("" + getXPForLevel(playerLevel[5] + 1) + "", 4069);
        sendQuest("" + getXPForLevel(playerLevel[6] + 1) + "", 4075);
        sendQuest("" + getXPForLevel(playerLevel[3] + 1) + "", 4081);
        sendQuest("" + getXPForLevel(playerLevel[16] + 1) + "", 4087);
        sendQuest("" + getXPForLevel(playerLevel[15] + 1) + "", 4093);
        sendQuest("" + getXPForLevel(playerLevel[17] + 1) + "", 4099);
        sendQuest("" + getXPForLevel(playerLevel[12] + 1) + "", 4105);
        sendQuest("" + getXPForLevel(playerLevel[9] + 1) + "", 4111);
        sendQuest("" + getXPForLevel(playerLevel[14] + 1) + "", 4117);
        sendQuest("" + getXPForLevel(playerLevel[13] + 1) + "", 4123);
        sendQuest("" + getXPForLevel(playerLevel[10] + 1) + "", 4129);
        sendQuest("" + getXPForLevel(playerLevel[7] + 1) + "", 4135);
        sendQuest("" + getXPForLevel(playerLevel[11] + 1) + "", 4141);
        sendQuest("" + getXPForLevel(playerLevel[8] + 1) + "", 4147);
        sendQuest("" + getXPForLevel(playerLevel[20] + 1) + "", 4158);
        sendQuest("" + getXPForLevel(playerLevel[18] + 1) + "", 12172);
        sendQuest("" + getXPForLevel(playerLevel[19] + 1) + "", 13922);
        sendFrame126("Prayer: "+playerLevel[5]+"/"+getLevelForXP(playerXP[5])+"", 687);
    }


    public void turnpray() {
        server.setConfig.turnPrayOff(playerId);
    }


    public void createGroundItem(int itemID, int itemX, int itemY,
                                 int itemAmount) {
        // Phate: creates item at absolute X and Y
        outStream.createFrame(85); // Phate: Spawn ground item
        outStream.writeByteC((itemY - 8 * mapRegionY));
        outStream.writeByteC((itemX - 8 * mapRegionX));
        outStream.createFrame(44);
        outStream.writeWordBigEndianA(itemID);
        outStream.writeWord(itemAmount);
        outStream.writeByte(0); // x(4 MSB) y(LSB) coords
        // System.out.println("CreateGroundItem "+itemID+" "+(itemX - 8 *
        // mapRegionX)+","+(itemY - 8 * mapRegionY)+" "+itemAmount);
    }

    public static boolean AutoSave = false;
    public static final int bufferSize = 30000;
    public static final int packetSizes[] = {
        0, 0, 0, 1, -1, 0, 0, 0, 0, 0, //0
        0, 0, 0, 0, 8, 0, 6, 2, 2, 0,  //10
        0, 2, 0, 6, 0, 12, 0, 0, 0, 0, //20
        0, 0, 0, 0, 0, 8, 4, 0, 0, 2,  //30
        2, 6, 0, 6, 0, -1, 0, 0, 0, 0, //40
        0, 0, 0, 12, 0, 0, 0, 0, 8, 0, //50
        8, 8, 0, 0, 0, 0, 0, 0, 0, 0,  //60
        6, 0, 2, 2, 8, 6, 0, -1, 0, 6, //70
        0, 0, 0, 0, 0, 1, 4, 6, 0, 0,  //80
        0, 0, 0, 0, 0, 3, 0, 0, -1, 0, //90
        0, 13, 0, -1, 0, 0, 0, 0, 0, 0,//100
        0, 0, 0, 0, 0, 0, 0, 6, 0, 0,  //110
        1, 0, 6, 0, 0, 0, -1, 0, 2, 6, //120
        0, 4, 6, 8, 0, 6, 0, 0, 0, 2,  //130
        0, 0, 0, 0, 0, 6, 0, 0, 0, 0,  //140
        0, 0, 1, 2, 0, 2, 6, 0, 0, 0,  //150
        0, 0, 0, 0, -1, -1, 0, 0, 0, 0,//160
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  //170
        0, 8, 0, 3, 0, 2, 0, 0, 8, 1,  //180
        0, 0, 12, 0, 0, 0, 0, 0, 0, 0, //190
        2, 0, 0, 0, 0, 0, 0, 0, 4, 0,  //200
        4, 0, 0, 0, 7, 8, 0, 0, 10, 0, //210
        0, 0, 0, 0, 0, 0, -1, 0, 6, 0, //220
        1, 0, 0, 0, 6, 0, 6, 8, 1, 0,  //230
        0, 4, 0, 0, 0, 0, -1, 0, -1, 4,//240
        0, 0, 6, 6, 0, 0, 0         //250
    };
    public static final int validPackets[] = {
        1, 0, 0, 1, 1, 0, 0, 0, 0, 0, //0
        0, 0, 0, 0, 1, 0, 1, 1, 1, 0,  //10
        0, 1, 0, 0, 0, 1, 0, 0, 0, 0,   //20
        0, 0, 0, 0, 0, 1, 1, 0, 0, 1,  //30
        1, 1, 0, 1, 0, 1, 0, 0, 0, 0,  //40
        0, 0, 0, 1, 0, 0, 0, 1, 0, 0,  //50
        1, 0, 0, 0, 0, 0, 0, 0, 0, 0,  //60
        1, 0, 1, 1, 1, 1, 0, 1, 1, 1,   //70
        0, 0, 0, 0, 0, 1, 1, 1, 0, 0,  //80
        0, 0, 0, 0, 0, 1, 0, 0, 1, 0,  //90
        0, 1, 0, 1, 0, 0, 0, 0, 0, 0,  //100
        0, 0, 0, 0, 0, 0, 0, 1, 0, 0,  //110
        1, 1, 1, 0, 0, 0, 1, 0, 1, 1,   //120
        1, 1, 1, 1, 0, 1, 1, 0, 0, 1,   //130
        0, 0, 0, 0, 0, 1, 0, 0, 1, 0,   //140
        1, 0, 1, 1, 0, 1, 1, 0, 0, 0,  //150
        0, 0, 0, 0, 1, 1, 0, 0, 0, 0,  //160
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,   //170
        0, 1, 0, 1, 0, 1, 0, 0, 1, 1,  //180
        0, 0, 1, 0, 0, 0, 0, 0, 0, 0,  //190
        1, 0, 1, 0, 0, 0, 0, 0, 1, 0,  //200
        1, 0, 0, 0, 1, 1, 0, 0, 1, 0,   //210
        0, 0, 0, 0, 0, 0, 1, 0, 1, 0,   //220
        1, 0, 0, 0, 1, 0, 1, 1, 1, 0,   //230
        0, 1, 0, 0, 0, 0, 1, 0, 1, 1,  //240
        0, 0, 1, 1, 0, 0, 0            //250
    };
    public boolean destroyItem(int item) {
        for(int i = 0; i < noTrade.length; i++) {
            if(noTrade[i] == item)
                return true;
        }
        return false;
    }
    public String getMessageA(int itemID) {
        switch(itemID) {
        case 6570:
            return "You can get another from the Fight";
        case 4045:
            return "You can get another from the wizard at Home";
        case 4046:
            return "You can get another from the wizard at Home";
        }
        return "Are you sure you want to destroy this item!";
    }
    public String getMessageB(int itemID) {
        switch(itemID) {
        case 6570:
            return "Caves minigame.";
        }
        return "";
    }
    public int[] noTrade = {5509,5510,5512,5514,4565,4566,6570,1580,6729,4045,4046,714,771,772,1891,1892,983,1550,4031,4035,1613,1629,4277,739,1982,1796};
    public int NPCID; // GLOBALLY NOW last clicked npcID -bakatool

    public int NPCSlot; // GLOBALLY NOW last clicked npc slot -bakatool


    public CopyOnWriteArrayList<GameItem> offeredItems = new CopyOnWriteArrayList<GameItem>();

    public boolean officialClient = false;
    public int OriginalShield = -1;
    public int OriginalWeapon = -1;
    public CopyOnWriteArrayList<GameItem> otherOfferedItems = new CopyOnWriteArrayList<GameItem>();
    public int packetSize = 0, packetType = -1;

    public int pCArms;

    public int pCBeard;
    public int pCFeet;
    public int pCHands;
    public int pCHead;

    public int pCLegs;
    public int pColor;

    public int pCTorso;

    public int PickUpAmount = 0;

    public int PickUpDelete = 0;

    public int PickUpID = 0;

    public String properName = "";

    public int Publicchat = 0;
    public int[] QuestInterface = { 8145, 8147, 8148, 8149, 8150, 8151, 8152,
                                    8153, 8154, 8155, 8156, 8157, 8158, 8159, 8160, 8161, 8162, 8163,
                                    8164, 8165, 8166, 8167, 8168, 8169, 8170, 8171, 8172, 8173, 8174,
                                    8175, 8176, 8177, 8178, 8179, 8180, 8181, 8182, 8183, 8184, 8185,
                                    8186, 8187, 8188, 8189, 8190, 8191, 8192, 8193, 8194, 8195, 12174,
                                    12175, 12176, 12177, 12178, 12179, 12180, 12181, 12182, 12183,
                                    12184, 12185, 12186, 12187, 12188, 12189, 12190, 12191, 12192,
                                    12193, 12194, 12195, 12196, 12197, 12198, 12199, 12200, 12201,
                                    12202, 12203, 12204, 12205, 12206, 12207, 12208, 12209, 12210,
                                    12211, 12212, 12213, 12214, 12215, 12216, 12217, 12218, 12219,
                                    12220, 12221, 12222, 12223
                                  };
    public int random_skill = -1, npcId = -1;
    public int readPtr, writePtr;
    public int[] requiredLevel = { 1, 10, 25, 38, 50, 60, 62, 64, 66, 68, 70,
                                   72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96
                                 };

    public int restart = 0;


    public int returnCode = 2; // Tells the client if the login was successfull

    public int rune1, rune1Am, rune2, rune2Am, rune3, rune3Am, rune4, rune4Am,
           spellXP;

    public int sameclick = 0;

    public int savecounter = 0;

    public boolean saveNeeded = true;

    public boolean shafting = false;

    public int SkillID = 0;

    public int skillX = -1;

    public int skillY = -1;

    public int somejunk;
    // -bakatool
    public int spellHit; // also same added so it won't be static ROFL
    // -bakatool
    public int spellHitTimer;
    // npc. -bakatool
    public int spellNpcIndex = -1; // added so it won't be static ROFL..
    // -bakatool
    public int spellPlayerIndex = -1; // same added so it won't be static ROFL
    public boolean spellSet = false;
    public int stairDistance = 1;
    public int stairDistanceAdd = 0;
    public int stairs = 0;
    public int[] statId = { 10252, 11000, 10253, 11001, 10254, 11002, 10255,
                            11011, 11013, 11014, 11010, 11012, 11006, 11009, 11008, 11004,
                            11003, 11005, 47002, 54090, 11007
                          };
    public String statName[] = { "attack", "defence", "strength", "hitpoints",
                                 "range", "prayer", "magic", "cooking", "woodcutting", "fletching",
                                 "fishing", "firemaking", "crafting", "smithing", "mining",
                                 "herblore", "agility", "thieving", "slayer", "farming",
                                 "runecrafting"
                               };
    public int stealtimer;
    public int stillSpellGFX;
    public int timeOutCounter = 0; // to detect timeouts on the connection to
    // the client

    public int trade_reqId = 0, trade_other;

    public int Tradecompete = 0;
    public boolean tradeRequested = false, inTrade = false, canOffer = true,
                   tradeConfirmed = false, tradeConfirmed2 = false,
                   tradeResetNeeded = false;
    long tTime = 0;
    long tTime2 = 0;
    // Devolution: teleports
    int tX = 0, tY = 0, tH = 1;

    public boolean validClient = true, muted = false, attackedNpc = false;

    public boolean validLogin = false;
    // public int[] restrictedItem = { 4716, 4718, 4720, 4722, 4724, 4726, 4728,
    // 4730};
    public int WanneBank = 0;
    private int WanneShop = 0;

    public boolean wearing = false;

    public boolean WildernessWarning = false;

    public boolean WildernessWarning2 = false;

    private int woodcutting[] = { 0, 0, 0, 1, -1, 2 };

    public int XinterfaceID = 0;

    public int XremoveID = 0;

    public int XremoveSlot = 0;
    public int ItemKept1Slot;
    public int ItemKept2Slot;
    public int ItemKept3Slot;
    public int ItemKept4Slot;



    public client(java.net.Socket s, int _playerId) {
        super(_playerId);
        mySock = s;
        try {
            in = s.getInputStream();
            out = s.getOutputStream();
            //in = new java.io.DataInputStream(s.getInputStream());
            //out = new DataOutputStream(s.getOutputStream());
        } catch (java.io.IOException ioe) {
            misc.println("DeltaScape Server (1): Exception!");
            server.logError(ioe.getMessage());
        }

        outStream = new stream(new byte[bufferSize]);
        outStream.currentOffset = 0;
        inStream = new stream(new byte[bufferSize]);
        inStream.currentOffset = 0;

        readPtr = writePtr = 0;
        buffer = buffer = new byte[bufferSize];
    }

    public void actionReset() {
        actionName = "";
    }


    public boolean addItem2(int item, int amount) {
        try {
            if(item == -1)
                return false;
            if (!Item.itemStackable[item] || amount < 1) {
                amount = 1;
            }

            if ((freeSlots() >= amount && !Item.itemStackable[item]) || freeSlots() > 0) {
                for (int i = 0; i < playerItems.length; i++) {
                    if (playerItems[i] == (item+1) && Item.itemStackable[item] && playerItems[i] > 0) {
                        playerItems[i] = (item + 1);
                        if ((playerItemsN[i] + amount) < maxItemAmount && (playerItemsN[i] + amount) > -1) {
                            playerItemsN[i] += amount;
                        } else {
                            playerItemsN[i] = maxItemAmount;
                        }
                        outStream.createFrameVarSizeWord(34);
                        outStream.writeWord(3214);
                        outStream.writeByte(i);
                        outStream.writeWord(playerItems[i]);
                        if (playerItemsN[i] > 254) {
                            outStream.writeByte(255);
                            outStream.writeDWord(playerItemsN[i]);
                        } else {
                            outStream.writeByte(playerItemsN[i]); //amount
                        }
                        outStream.endFrameVarSizeWord();
                        i = 30;
                        return true;
                    }
                }
                for (int i = 0; i < playerItems.length; i++) {
                    if (playerItems[i] <= 0) {
                        playerItems[i] = item+1;
                        if (amount < maxItemAmount && amount > -1) {
                            playerItemsN[i] = amount;
                        } else {
                            playerItemsN[i] = maxItemAmount;
                        }
                        outStream.createFrameVarSizeWord(34);
                        outStream.writeWord(3214);
                        outStream.writeByte(i);
                        outStream.writeWord(playerItems[i]);
                        if (playerItemsN[i] > 254) {
                            outStream.writeByte(255);
                            outStream.writeDWord(playerItemsN[i]);
                        } else {
                            outStream.writeByte(playerItemsN[i]); //amount
                        }
                        outStream.endFrameVarSizeWord();
                        i = 30;
                        return true;
                    }
                }
                return false;
            } else {
                ItemHandler.addItem(item, absX, absY, amount, playerId, false);
                return false;
            }
        } catch (Exception E) {
            return false;
        }
    }

    public boolean addItem(int item, int amount) {
        try {
            if(item == -1)
                return false;
            if (!Item.itemStackable[item] || amount < 1) {
                amount = 1;
            }

            if ((freeSlots() >= amount && !Item.itemStackable[item]) || freeSlots() > 0) {
                for (int i = 0; i < playerItems.length; i++) {
                    if (playerItems[i] == (item+1) && Item.itemStackable[item] && playerItems[i] > 0) {
                        playerItems[i] = (item + 1);
                        if ((playerItemsN[i] + amount) < maxItemAmount && (playerItemsN[i] + amount) > -1) {
                            playerItemsN[i] += amount;
                        } else {
                            playerItemsN[i] = maxItemAmount;
                        }
                        outStream.createFrameVarSizeWord(34);
                        outStream.writeWord(3214);
                        outStream.writeByte(i);
                        outStream.writeWord(playerItems[i]);
                        if (playerItemsN[i] > 254) {
                            outStream.writeByte(255);
                            outStream.writeDWord(playerItemsN[i]);
                        } else {
                            outStream.writeByte(playerItemsN[i]); //amount
                        }
                        outStream.endFrameVarSizeWord();
                        i = 30;
                        return true;
                    }
                }
                for (int i = 0; i < playerItems.length; i++) {
                    if (playerItems[i] <= 0) {
                        playerItems[i] = item+1;
                        if (amount < maxItemAmount && amount > -1) {
                            playerItemsN[i] = amount;
                        } else {
                            playerItemsN[i] = maxItemAmount;
                        }
                        outStream.createFrameVarSizeWord(34);
                        outStream.writeWord(3214);
                        outStream.writeByte(i);
                        outStream.writeWord(playerItems[i]);
                        if (playerItemsN[i] > 254) {
                            outStream.writeByte(255);
                            outStream.writeDWord(playerItemsN[i]);
                        } else {
                            outStream.writeByte(playerItemsN[i]); //amount
                        }
                        outStream.endFrameVarSizeWord();
                        i = 30;
                        return true;
                    }
                }
                return false;
            } else {
                sM("Not enough space in your inventory.");
                return false;
            }
        } catch (Exception E) {
            return false;
        }
    }
    public void addObject(int objectX, int objectY, int NewObjectID, int Face) {
        outStream.createFrameVarSizeWord(60);
        outStream.writeByte(objectY - (mapRegionY * 8));
        outStream.writeByteC(objectX - (mapRegionX * 8));

        /* CREATE OBJECT */
        if (NewObjectID > -1) {
            outStream.writeByte(151);
            outStream.writeByteS(0);
            outStream.writeWordBigEndian(NewObjectID);
            outStream.writeByteA(Face); // 0= WEST | -1 = NORTH | -2 = EAST | -3
            // = SOUTH
        }
        outStream.endFrameVarSizeWord();
    }

    public boolean addShopItem(int itemID, int amount) {
        boolean Added = false;

        if (amount <= 0) {
            return false;
        }
        if (Item.itemIsNote[itemID] == true) {
            itemID = GetUnnotedItem(itemID);
        }
        for (int i = 0; i < server.shopHandler.ShopItems.length; i++) {
            if ((server.shopHandler.ShopItems[MyShopID][i] - 1) == itemID) {
                server.shopHandler.ShopItemsN[MyShopID][i] += amount;
                Added = true;
            }
        }
        if (Added == false) {
            for (int i = 0; i < server.shopHandler.ShopItems.length; i++) {
                if (server.shopHandler.ShopItems[MyShopID][i] == 0) {
                    server.shopHandler.ShopItems[MyShopID][i] = (itemID + 1);
                    server.shopHandler.ShopItemsN[MyShopID][i] = amount;
                    server.shopHandler.ShopItemsDelay[MyShopID][i] = 0;
                    break;
                }
            }
        }
        return true;
    }

    public boolean addSkillXP(int amount, int skill) {
        if (randomed) {
            sM("You must answer the genie before you can gain experience!");
            return false;
        }
        if ((amount + playerXP[skill]) < 0 || amount + playerXP[skill] > 200000000 || playerXP[skill] >= 200000000) {
            playerXP[skill] = 200000000;
            refreshSkills();
            return false;
        }
        int oldLevel = getLevelForXP(playerXP[skill]);
        // int[] statId = {4004, 4008, 4006, 4016, 4010, 4012, 4014, 4034, 4038,
        // 4026, 4032, 4036, 4024, 4030, 4028, 4020, 4018, 4022, 4152};
        playerXP[skill] += amount;
        if (oldLevel < getLevelForXP(playerXP[skill])) {
            // if(oldLevel >= 85)
            specGFX(199);
            //checkPlayerCapes.achievedMax(skill, this);

            playerLevel[skill] = getLevelForXP(playerXP[skill]);
            // stillgfx(623, absY, absX);
            // levelup(skill);
            updateRequired = true;
            appearanceUpdateRequired = true;
            sM("Congratulations, you just advanced a "
               + statName[skill] + " level.");

            if (playerLevel[skill] > 90)
                // sendFrame126(playerName + " (" + combatLevel + ")", 6572);
                setSkillLevel(skill, playerLevel[skill], playerXP[skill]);
        }
        refreshSkills();
        // setSkillLevel(skill, playerLevel[skill], playerXP[skill]);
        if (skill == 2) {
            CalculateMaxHit();
        }
        return true;

    }
    public int amountOfItem(int itemID) {
        int i1 = 0;

        for (int i = 0; i < 28; i++) {
            if (playerItems[i] == (itemID + 1)) {
                i1++;
            }
        }
        return i1;
    }
    public boolean antiHax() {
        if (System.currentTimeMillis() - lastMouse > 1000) {
            println("Suspicious activity!");
            disconnected = true;
            //sM("Client hack detected!");
            //sM("The only supported clients are the DeltaScape client and moparscape");
            return false;
        }
        return true;
    }
    public void appendToHiscores(String player) {

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(
                new FileWriter("config//hiscores.txt", true));
            bw.write(player);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                    sM("Error with hiscores!");
                }
            }
        }

    }

    public boolean AreXItemsInBag(int ItemID, int Amount) {
        int ItemCount = 0;

        for (int pItem : playerItems) {
            if ((pItem - 1) == ItemID) {
                ItemCount++;
            }
            if (ItemCount == Amount) {
                return true;
            }
        }
        return false;
    }
    public void drawback() {
        if (hasCrystalBow()) {
            specGFX(250);
        }
        if (playerEquipment[playerArrows] == 882 && !hasCrystalBow()) {
            specGFX(18);
        }
        else if (playerEquipment[playerArrows] == 884 && !hasCrystalBow()) {
            specGFX(19);
        }
        else if (playerEquipment[playerArrows] == 886 && !hasCrystalBow()) {
            specGFX(20);
        }
        else if (playerEquipment[playerArrows] == 888 && !hasCrystalBow()) {
            specGFX(21);
        }
        else if (playerEquipment[playerArrows] == 890 && !hasCrystalBow()) {
            specGFX(22);
        }
        else if (playerEquipment[playerArrows] == 892 && !hasCrystalBow()) {
            specGFX(24);

        }
    }
    public boolean hasKnife() {
        int a = playerEquipment[playerWeapon];
        if(a == 863 || a == 864 || a == 865 || a == 866 || a == 867 || a == 868 || a == 869) {
            return true;
        }
        return false;
    }
    // pk: 2726 9193
    private boolean Attack() {
        client AttackingOn2 = (client) server.playerHandler.players[AttackingOn];
        int EnemyX = PlayerHandler.players[AttackingOn].absX;
        int EnemyY = PlayerHandler.players[AttackingOn].absY;
        if(hasKnife()) {
            sM("Knives are disabled for now!");
            ResetAttack();
            return false;
        }
        if(hitID != AttackingOn2.playerId && hitID != 0 && !multiCombat()) {
            sM("I'm already under attack.");
            ResetAttack();
            faceNPC(32768 + AttackingOn);
            return false;
        }
        if (!(AttackingOn > 0)
                || !(AttackingOn < server.playerHandler.players.length)) {
            ResetAttack();
            return false;
        }
        if (playerId < 1) {
            sM("Error: Your player id is invalid. Please try again or logout and back in");
        }


        boolean UseBow = false;
        if (playerEquipment[playerWeapon] == 839 || playerEquipment[playerWeapon] == 841 || playerEquipment[playerWeapon] == 843 ||  playerEquipment[playerWeapon] == 845 ||  playerEquipment[playerWeapon] == 847 ||  playerEquipment[playerWeapon] == 849 || playerEquipment[playerWeapon] == 851 ||  playerEquipment[playerWeapon] == 853 || playerEquipment[playerWeapon] == 855 ||  playerEquipment[playerWeapon] == 857 ||  playerEquipment[playerWeapon] == 837 || playerEquipment[playerWeapon] == 861 || playerEquipment[playerWeapon] == 4734 || playerEquipment[playerWeapon] == 859 || playerEquipment[playerWeapon] == 4827 || hasCrystalBow()) {
            UseBow = true;
        }
        boolean UseCrossBow = false;
        if (playerEquipment[playerWeapon] == 837) {
            UseCrossBow = true;
        }
        boolean UseRing = false;
        if (playerEquipment[playerWeapon] == 6522) {
            UseRing = true;
        }
        if (UseBow) {
            HasArrows = false;
            CheckArrows();
            //CalculateRange();
            hitDiff = misc.random(maxRangeHit());
            //drawback();
        }
        if (UseCrossBow) {
            HasBolts = false;
            CheckBolts();
            //CalculateRange();
            hitDiff = misc.random(maxRangeHit());
        }
        if (UseRing) {
            HasRings = false;
            CheckRings();
            //CalculateRange();
            hitDiff = misc.random(maxRangeHit());
        }
        if(UseBow || UseCrossBow || UseRing) {
            if(GoodDistance(EnemyX, EnemyY, absX, absY, 8) == false) {
                sM("You are too far to range your enemy!");
                ResetAttack();
                return false;
            }
        }
        int EnemyHP = PlayerHandler.players[AttackingOn].currentHealth;
        int EnemyHPExp = PlayerHandler.players[AttackingOn].playerXP[playerHitpoints];
        int[] arrowIds = { 882, 884, 886, 888, 890, 892, 78 };
        int[] arrowGfx = { 10, 9, 11, 12, 13, 15, 16 };
        int[] staffs = {1381, 1383, 1385, 1387, 4675};
        faceNPC(32768 + AttackingOn);
        updateRequired = true;
        appearanceUpdateRequired = true;
        int arrowgfx = 10;
        for (int i1 = 0; i1 < arrowIds.length; i1++) {
            if (playerEquipment[playerArrows] == arrowIds[i1]) {
                arrowgfx = arrowGfx[i1];
            }
        }
        if(hasCrystalBow()) {
            arrowgfx = 249;
        }
        for (int element : staffs) {
            if ((playerEquipment[playerWeapon] == element)
                    && autocasting && autocastID > 0 && (isInPitGame() && !AttackingOn2.isInPitRoom() || isInWilderness(absX, absY, 1) == true && AttackingOn2.isInWilderness(AttackingOn2.absX, AttackingOn2.absY, 1) == true)) {
                int playerTargetX = server.playerHandler.players[AttackingOn].absX;
                int playerTargetY = server.playerHandler.players[AttackingOn].absY;
                int playerTargetCombat = server.playerHandler.players[AttackingOn].combat;
                int playerTargetHealth = server.playerHandler.players[AttackingOn].playerLevel[playerHitpoints];
                if (System.currentTimeMillis() - lastAttack < 4000) {
                    //sM("You must wait 4 seconds before casting this kind of spell again");
                    return false;
                }
                if (!playerMage(AttackingOn)) {
                    return false;
                }
                inCombat = true;
                lastCombat = System.currentTimeMillis();
                lastAttack = lastCombat;

                TurnPlayerTo(playerTargetX, playerTargetY);
                updateRequired = true;
                appearanceUpdateRequired = true;

                toX = absX;
                toY = absY;
                newWalkCmdSteps = 0;
                newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
                getNextPlayerMovement();
                MagicHandler.playerX = playerTargetX;
                MagicHandler.playerY = playerTargetY;
                MagicHandler.playerHP = playerTargetHealth;
                AttackingOn2.offTimer = System.currentTimeMillis();
                AttackingOn2.hitID = playerId;
                spellPlayerIndex = MagicHandler.magicSpellPlayer(autocastID,
                                   playerId, AttackingOn, playerLevel[6]);
                return true;
            }
        }
        int voidmelee = 0;
        int hitDiff = 0;
        int aBonus = 0;
        int rand_att = misc.random(playerLevel[0])*3 + misc.random(AtkPray * 8);
        int rand_def = (int) (0.65 * misc.random(AttackingOn2.playerLevel[1]) + AttackingOn2.DefPray * 8);
        if(AttackingOn2.ProtMelee) {
            rand_def += misc.random(100);
        }
        if(FullVMelee()) {
            voidmelee += 10;
        }
        if (FightType == 1)
            aBonus += (int) (playerBonus[1] / 20);
        int random_u = misc.random(playerBonus[1] + aBonus) * 2;
        int dBonus = 0;
        if (AttackingOn2.FightType == 4)
            dBonus += (int) (AttackingOn2.playerBonus[6] / 20);
        int random_def = misc.random(AttackingOn2.playerBonus[6] + dBonus + AttackingOn2.AtkPray * 8);
        if ((random_u >= random_def) && (rand_att > rand_def)) {
            hitDiff = misc.random(playerMaxHit) + misc.random(StrPrayer) + misc.random(voidmelee);
            if(AttackingOn2.ProtMelee)
                hitDiff /= 2;
        } else {
            hitDiff = 0;
        }
        long thisTime = System.currentTimeMillis();
        if (UseBow && playerEquipment[playerWeapon] == 4734) {
            //CalculateRange();
            hitDiff = misc.random(maxRangeHit());
            if (DeleteArrow() && playerEquipment[playerArrows] == 4740) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttack();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }
        if (UseBow && hasCrystalBow()) {
            //CalculateRange();
            drawback();
            hitDiff = misc.random(maxRangeHit());

            if (DeleteArrow()) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                arrowsLeft -= 1;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttack();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }
        if (UseBow && !UseCrossBow && playerEquipment[playerWeapon] != 4734 && playerEquipment[playerWeapon] != 4827 && !hasCrystalBow()) {
            //CalculateRange();
            drawback();
            hitDiff = misc.random(maxRangeHit());
            if (DeleteArrow() && HasArrows) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttack();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }
        if (UseBow && playerEquipment[playerWeapon] == 4827) {
            //CalculateRange();
            drawback();
            hitDiff = misc.random(maxRangeHit());
            if (DeleteArrow() && HasArrows) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttack();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }
        if (UseCrossBow) {
            //CalculateRange();
            hitDiff = misc.random(maxRangeHit());
            if (DeleteArrow() && HasBolts) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttack();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }
        if (UseRing) {
            //CalculateRange();
            hitDiff = misc.random(maxRangeHit());
            if (DeleteRing() && HasRings) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttack();
                return false;
            }
        }
        long thisAttack = System.currentTimeMillis();
        if(Smite == true && AttackingOn2.playerLevel[5] > 0 && GoodDistance(EnemyX, EnemyY, absX, absY, 1))
        {
            AttackingOn2.playerLevel[5] -= hitDiff/ 4;
            AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[5] + "", 4012);
            AttackingOn2.sendFrame126("Prayer: "+AttackingOn2.playerLevel[5]+"/"+AttackingOn2.getLevelForXP(playerXP[5])+"", 687);
        }
        if(playerEquipment[playerWeapon] == 6528 && playerEquipment[playerAmulet] == 6577 && misc.random(3)==1) {
            hitDiff = misc.random(8) + misc.random(playerMaxHit) + misc.random(StrPrayer);
        }
        if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 80 && currentHealth < 100) {
            hitDiff = misc.random(8) + misc.random(playerMaxHit) + misc.random(StrPrayer);

        }
        if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 60 && currentHealth < 79) {
            hitDiff = misc.random(18) + misc.random(playerMaxHit) + misc.random(StrPrayer);

        }
        if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 40 && currentHealth < 59) {
            hitDiff = misc.random(28) + misc.random(playerMaxHit) + misc.random(StrPrayer);

        }
        if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 20 && currentHealth < 39) {
            hitDiff = misc.random(38) + misc.random(playerMaxHit) + misc.random(StrPrayer);

        }
        if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 0 && currentHealth < 18) {
            hitDiff = misc.random(58) + misc.random(playerMaxHit) + misc.random(StrPrayer);

        }
        if(FullVeracEquipped()) {
            if(misc.random(2) == 1) {
                hitDiff = misc.random(playerMaxHit) + misc.random(StrPrayer);
            }
        }
        if(FullGuthanEquipped()) {
            if(misc.random(3) == 1) {
                if((currentHealth + hitDiff) <= getLevelForXP(playerXP[3])) {
                    currentHealth += hitDiff;
                }
                if((currentHealth + hitDiff) > getLevelForXP(playerXP[3])) {
                    currentHealth = getLevelForXP(playerXP[3]);
                }
                sendQuest("" + currentHealth + "", 4016);
                stillgfx(398, EnemyY, EnemyX);
            }
        }
        actionInterval = getbattleTimer();
        lastAction = System.currentTimeMillis();
        if(AttackingOn2.prayOn && AttackingOn2.Redemption && AttackingOn2.currentHealth < 10 && AttackingOn2.currentHealth > 0) {
            AttackingOn2.prayOff();
            AttackingOn2.currentHealth += 20;
            AttackingOn2.lowGFX(436,0);
            AttackingOn2.playerLevel[5] = 0;
        }
        if(AttackingOn2.skulledBy != playerName && !isInPitGame()) {
            lastSkull = System.currentTimeMillis();
            isSkulled = true;
            skulledBy = AttackingOn2.playerName;
            getHead();
        }
        if(playerEquipment[playerWeapon] == 4827 && !specOn) {
            DDS2Damg3 = true;
            ddsInterval = 2000;
            lastDds = System.currentTimeMillis();
            actionInterval = getbattleTimer();
            lastAction = System.currentTimeMillis();
        }
        if(playerEquipment[playerWeapon] == 4827 && specialAmount > 74 && specOn && AttackingOn2.currentHealth > 0) {
            specialAtk(true, 75, 250, 1074);
            hitDiff = misc.random(maxRangeHit()) + misc.random(23);
            rangeGFX(85, 643);
            rangeGFX(65, 643);
            actionInterval = getbattleTimer();
            lastAction = System.currentTimeMillis();
            specAttack();
            usingSpecial = true;
        }
        if(playerEquipment[playerWeapon] == 861 && specialAmount > 74 && specOn && AttackingOn2.currentHealth > 0) {
            specialAtk(true, 75, 256, 1074);
            hitDiff = misc.random(maxRangeHit()) + misc.random(3);
            rangeGFX(75, 249);
            rangeGFX(95, 249);
            specAttack();
            actionInterval = getbattleTimer();
            lastAction = System.currentTimeMillis();
            usingSpecial = true;
        }
        if(playerEquipment[playerWeapon] == 859 && specialAmount > 99 && specOn && AttackingOn2.currentHealth > 0) {
            specialAtk(false, 100, 250, 426);
            hitDiff = misc.random(maxRangeHit()) + misc.random(10);
            rangeGFX(75, 249);
            specAttack();
        }

        if(AttackingOn2.playerEquipment[AttackingOn2.playerRing] == 2570 && AttackingOn2.currentHealth > 0 && AttackingOn2.currentHealth < 6) {
            AttackingOn2.triggerTele(3689+misc.random(3), 3468+misc.random(3), 0);
            AttackingOn2.playerEquipment[AttackingOn2.playerRing] = -1;
            AttackingOn2.playerEquipmentN[AttackingOn2.playerRing] = 0;
            AttackingOn2.setEquipment(-1, 0,AttackingOn2.playerRing);
        }
        if (GoodDistance(EnemyX, EnemyY, absX, absY, 1) == true && !UseBow && !UseCrossBow && !UseRing) {
            inCombat = true;
            lastCombat = System.currentTimeMillis();
            if (isInPitGame() && !AttackingOn2.isInPitRoom() || isInWilderness(absX, absY, 1) == true && AttackingOn2.isInWilderness(AttackingOn2.absX, AttackingOn2.absY, 1) == true ||  matchId == handler.players[AttackingOn].matchId && matchId >= 0) {
                if (PlayerHandler.players[AttackingOn].deathStage > 0) {
                    ResetAttack();
                } else {
                    if (inRange(EnemyX, EnemyY)) {
                        if (thisAttack - lastAttack >= 4000)
                            ((client) PlayerHandler.players[AttackingOn])
                            .sM("You are under attack!");
                        PlayerHandler.players[AttackingOn]
                        .resetWalkingQueue();
                        PlayerHandler.players[AttackingOn].hits++;
                        PlayerHandler.players[AttackingOn].fighting = true;
                        PlayerHandler.players[AttackingOn].fightId = localId;
                        PlayerHandler.players[AttackingOn].IsAttacking = true;
                        ((client) PlayerHandler.players[AttackingOn])
                        .Attack();
                        fightId = AttackingOn;
                        fighting = true;
                        resetWalkingQueue();
                    }
                    if(AttackingOn2.hitID != playerId && AttackingOn2.hitID != 0 && !multiCombat()) {
                        sM("Someone else is already fighting your opponent.");
                        ResetAttack();
                        faceNPC(32768 + AttackingOn);
                        return false;
                    }
                    client player = (client) server.playerHandler.players[playerId];
                    if (AttackingOn2.vengon && hitDiff != 0) {
                        player.hitDiff = (int)(hitDiff / 1.2);
                        player.currentHealth -= (int)(hitDiff / 1.2);
                        player.hitUpdateRequired = true; // So the hit will append to you.
                        player.updateRequired = true; // So the hit will append to you.
                        player.appearanceUpdateRequired = true; // So the hit will append to you.
                        AttackingOn2.vengon = false;
                        AttackingOn2.plrText = "Taste vengeance!"; // This says it in itself.
                        AttackingOn2.plrTextUpdateRequired = true; // Make sure the txt4 will update.
                    }
                    double TotalExp = 0;
                    if (UseBow || UseCrossBow) {
                        TotalExp = (double)(120*hitDiff);
                        TotalExp = (double)(TotalExp*CombatExpRate);
                        addSkillXP((int)(TotalExp), 4);
                    } else if (FightType != 3) {
                        TotalExp = (double)(120*hitDiff);
                        TotalExp = (double)(TotalExp*CombatExpRate);
                        addSkillXP((int)(TotalExp), SkillID);
                    } else {
                        TotalExp = (double)(50*hitDiff);
                        TotalExp = (double)(TotalExp*CombatExpRate);
                        addSkillXP((int)(TotalExp), playerAttack);
                        addSkillXP((int)(TotalExp), playerDefence);
                        addSkillXP((int)(TotalExp), playerStrength);
                    }
                    TotalExp = (double)(50*hitDiff);
                    TotalExp = (double)(TotalExp*CombatExpRate);
                    addSkillXP((int)(TotalExp), playerHitpoints);
                    attackTimer = 7;
                    setAnimation(Equipemotes.GetWepAnim(playerEquipment[playerWeapon]));
                    AttackingOn2.KillerId = playerId;
                    actionInterval = getbattleTimer();
                    lastAction = System.currentTimeMillis();
                    AttackingOn2.setAnimation(Equipemotes.GetBlockAnim());
                    AttackingOn2.offTimer = System.currentTimeMillis();
                    AttackingOn2.hitID = playerId;
                    if(AttackingOn2.prayOn && AttackingOn2.Redemption && AttackingOn2.currentHealth < 10 && AttackingOn2.currentHealth > 0) {
                        AttackingOn2.prayOff();
                        AttackingOn2.currentHealth += 20;
                        AttackingOn2.lowGFX(436,0);
                        AttackingOn2.playerLevel[5] = 0;
                    }
                    if(specOn == true && AttackingOn2.currentHealth > 0 && GoodDistance(EnemyX, EnemyY, absX, absY, 1)) { //players
                        if(playerEquipment[playerWeapon] == 3204 && specialAmount > 74) {
                            specialAtk(true, 75, 282, 1203);
                            getHit(3);
                            usingSpecial = true;
                        }
                        if(playerEquipment[playerWeapon] == 5698 && specialAmount > 24) {
                            specialAtk(true, 25, 252, 0x426);
                            getHit(8);
                            usingSpecial = true;
                        }
                        if(playerEquipment[playerWeapon] == 1305 && specialAmount > 24) {
                            specialAtk(false, 25, 248, 1058);
                            getHit(10);
                        }
                        if(playerEquipment[playerWeapon] == 4587 && specialAmount > 74) {
                            specialAtk(false, 75, 347, 1872);
                            getHit(0);
                            AttackingOn2.setClientConfig(95, 0);
                            AttackingOn2.setClientConfig(96, 0);
                            AttackingOn2.setClientConfig(97, 0);
                            AttackingOn2.ProtMage = false;
                            AttackingOn2.ProtRange = false;
                            AttackingOn2.ProtMelee = false;
                            AttackingOn2.sM("You have been injured!");
                            AttackingOn2.checkHead();
                        }
                        if(playerEquipment[playerWeapon] == 4151 && specialAmount > 49) {
                            AttackingOn2.specGFX(341);
                            specialAmount -= 50;
                            hitDiff = misc.random(playerMaxHit) + misc.random(StrPrayer) + misc.random(voidmelee);
                            lastSpecial = System.currentTimeMillis();
                            setAnimation(1658);
                            actionInterval = getbattleTimer();
                            lastAction = System.currentTimeMillis();
                            specOn = false;
                        }
                        if(playerEquipment[playerWeapon] == 667 && specialAmount > 99) {
                            AttackingOn2.playerLevel[1] -= hitDiff;
                            AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[0] + "", 4004);
                            AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[1] + "", 4008);
                            AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[2] + "", 4006);
                            AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[4] + "", 4010);
                            AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[5] + "", 4012);
                            AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[6] + "", 4014);
                            setAnimation(2927);
                            specialAmount -= 100;
                            lastSpecial = System.currentTimeMillis();
                            specGFX(654);
                            getHit(10);
                            specOn = false;
                        }
                        if(playerEquipment[playerWeapon] == 35 && specialAmount > 49) {
                            setAnimation(3547);
                            specialAmount -= 50;
                            getHit(30);
                            specOn = false;
                            lastSpecial = System.currentTimeMillis();
                            specGFX(655);
                        }
                        if(playerEquipment[playerWeapon] == 2402 && specialAmount > 49) {
                            specialAtk(false, 50, 600, 2967);
                            specGFX(611);
                            getHit(0);
                            currentHealth += hitDiff;
                            playerLevel[5] += 5 + misc.random(15);
                            sendQuest("" + playerLevel[5] + "", 4012);
                            if (currentHealth > playerLevel[playerHitpoints])
                                currentHealth = playerLevel[playerHitpoints];
                            sendQuest("" + currentHealth + "", 4016);
                            if (playerLevel[5] > getLevelForXP(playerXP[5]))
                                playerLevel[5] = getLevelForXP(playerXP[5]);
                            sendQuest("" + playerLevel[5] + "", 4012);
                        }
                        if(playerEquipment[playerWeapon] == 746 && specialAmount > 74) {
                            stillgfx(369, EnemyY, EnemyX);
                            stillgfx(644, absY, absX);
                            specialAtk(false, 75, 600, 2927);
                            getHit(0);
                            AttackingOn2.EntangleDelay = 5;
                        }
                        if(playerEquipment[playerWeapon] == 8100 && specialAmount > 99) {
                            specialAtk(true, 100, 600, 811);
                            AttackingOn2.specGFX(656);
                            getHit(5);
                            usingSpecial = true;
                        }
                        specAttack();
                        actionInterval = getbattleTimer();
                        lastAction = System.currentTimeMillis();
                    }
                    if(playerEquipment[playerShield] == 2621 && misc.random(6)==1) {
                        specialAtk(true, 0, 600, 2836);
                        hitDiff = misc.random(25);
                        AttackingOn2.lowGFX(579,0);
                    }
                    if(AttackingOn2.autoRetaliate == 1 && AttackingOn2.AttackingOn == 0) {
                        AttackingOn2.AttackingOn = playerId;
                        AttackingOn2.IsAttacking = true;
                    }
                    if(hasCrystalShield()) {
                        shieldLeft -= 1;
                        ;
                    }
                    if(AttackingOn2.playerEquipment[playerRing] == 2550 && hitDiff > 0) {
                        applyRecoil();
                    }
                    if(AttackingOn2.playerEquipment[playerRing] == 2550 && misc.random(15)==1) {
                        AttackingOn2.sM("Your ring of recoil shatters.");
                        AttackingOn2.playerEquipment[AttackingOn2.playerRing] = -1;
                        AttackingOn2.playerEquipmentN[AttackingOn2.playerRing] = 0;
                        AttackingOn2.setEquipment(-1, 0, AttackingOn2.playerRing);
                    }
                    if(AttackingOn2.tStage == 0) {
                        PlayerHandler.players[AttackingOn].hitUpdateRequired = true;
                        PlayerHandler.players[AttackingOn].updateRequired = true;
                        PlayerHandler.players[AttackingOn].appearanceUpdateRequired = true;
                    }
                    if ((AttackingOn2.currentHealth - hitDiff) < 0) {
                        hitDiff = AttackingOn2.currentHealth;
                    }
                    if(AttackingOn2.tStage == 0) {
                        PlayerHandler.players[AttackingOn].dealDamage(hitDiff);
                        PlayerHandler.players[AttackingOn].hitDiff = hitDiff;
                        PlayerHandler.players[AttackingOn].killers[playerId] += hitDiff;
                        PlayerHandler.players[AttackingOn].KilledBy[playerId] += hitDiff;
                    }
                    attackTimer = 7;
                    lastAttack = System.currentTimeMillis();
                    // sM("You hit " + hitDiff + ", time=" +
                    // lastAttack);
                }
                return true;
            } else {
                sM("This player is not in the wilderness!");
                ResetAttack();
            }
        }

        if (isInPitGame() && !AttackingOn2.isInPitRoom() || isInWilderness(absX, absY, 1) == true && AttackingOn2.isInWilderness(AttackingOn2.absX, AttackingOn2.absY, 1) == true) {
            if (PlayerHandler.players[AttackingOn].deathStage > 0) {
                ResetAttack();

                if ((EnemyHP - hitDiff) <= 0) {
                    hitDiff = EnemyHP;
                    // animation(437, absY, absX);

                }
            } else if (UseBow || UseCrossBow || UseRing) {
                if(AttackingOn2.skulledBy != playerName && !isInPitGame()) {
                    lastSkull = System.currentTimeMillis();
                    isSkulled = true;
                    skulledBy = AttackingOn2.playerName;
                    getHead();
                }
                if(AttackingOn2.hitID != playerId && AttackingOn2.hitID != 0 && !multiCombat()) {
                    sM("Someone else is already fighting your opponent.");
                    ResetAttack();
                    faceNPC(32768 + AttackingOn);
                    return false;
                }
                if(AttackingOn2.autoRetaliate == 1 && AttackingOn2.AttackingOn == 0) {
                    AttackingOn2.AttackingOn = playerId;
                    AttackingOn2.IsAttacking = true;
                }
                if(hasCrystalShield()) {
                    shieldLeft -= 1;
                    ;
                }
                if(AttackingOn2.playerEquipment[playerRing] == 2550 && hitDiff > 0) {
                    applyRecoil();
                }
                if(AttackingOn2.playerEquipment[playerRing] == 2550 && misc.random(15)==1) {
                    AttackingOn2.sM("Your ring of recoil shatters.");
                    AttackingOn2.playerEquipment[AttackingOn2.playerRing] = -1;
                    AttackingOn2.playerEquipmentN[AttackingOn2.playerRing] = 0;
                    AttackingOn2.setEquipment(-1, 0, AttackingOn2.playerRing);
                }
                AttackingOn2.KillerId = playerId;
                setAnimation(Equipemotes.GetWepAnim(playerEquipment[playerWeapon]));
                lastArrow = System.currentTimeMillis();
                arrow = true;
                AttackingOn2.offTimer = System.currentTimeMillis();
                double TotalExp = 0;
                if (UseBow || UseCrossBow) {
                    TotalExp = (double)(120*hitDiff);
                    TotalExp = (double)(TotalExp*CombatExpRate);
                    addSkillXP((int)(TotalExp), 4);
                } else if (FightType != 3) {
                    TotalExp = (double)(120*hitDiff);
                    TotalExp = (double)(TotalExp*CombatExpRate);
                    addSkillXP((int)(TotalExp), SkillID);
                } else {
                    TotalExp = (double)(50*hitDiff);
                    TotalExp = (double)(TotalExp*CombatExpRate);
                    addSkillXP((int)(TotalExp), playerAttack);
                    addSkillXP((int)(TotalExp), playerDefence);
                    addSkillXP((int)(TotalExp), playerStrength);
                }
                TotalExp = (double)(50*hitDiff);
                TotalExp = (double)(TotalExp*CombatExpRate);
                addSkillXP((int)(TotalExp), playerHitpoints);
                attackTimer = 7;
                lastAttack = System.currentTimeMillis();
                client player = (client) server.playerHandler.players[playerId];
                if (AttackingOn2.vengon && hitDiff != 0 ) {
                    player.hitDiff = (int)(hitDiff / 1.2);
                    player.currentHealth -= (int)(hitDiff / 1.2);
                    player.hitUpdateRequired = true; // So the hit will append to you.
                    player.updateRequired = true; // So the hit will append to you.
                    player.appearanceUpdateRequired = true; // So the hit will append to you.
                    AttackingOn2.vengon = false;
                    AttackingOn2.plrText = "Taste vengeance!"; // This says it in itself.
                    AttackingOn2.plrTextUpdateRequired = true; // Make sure the txt4 will update.
                }
                if(Smite == true && AttackingOn2.playerLevel[5] > 0 && GoodDistance(EnemyX, EnemyY, absX, absY, 1))
                {
                    AttackingOn2.playerLevel[5] -= hitDiff/ 4;
                    AttackingOn2.sendQuest("" + AttackingOn2.playerLevel[5] + "", 4012);
                    AttackingOn2.sendFrame126("Prayer: "+AttackingOn2.playerLevel[5]+"/"+AttackingOn2.getLevelForXP(playerXP[5])+"", 687);
                }
                if(playerEquipment[playerShield] == 2621 && misc.random(6)==1) {
                    specialAtk(true, 0, 600, 2836);
                    getHitDouble(25);
                    AttackingOn2.lowGFX(579,0);
                }
            }
            return true;
        } else {
            sM("This player is not in the wilderness!");
            ResetAttack();
        }
        return false;
    }

    private boolean AttackNPC() {
        if(hasKnife()) {
            sM("Knives are disabled for now!");
            ResetAttackNPC();
            return false;
        }
        int EnemyX = server.npcHandler.npcs[attacknpc].absX;
        int EnemyY = server.npcHandler.npcs[attacknpc].absY;
        int EnemyHP = server.npcHandler.npcs[attacknpc].HP;
        int hitDiff = 0;
        if (EnemyHP < 1) {
            sM("You can't attack that monster!");
            return false;
        }
        int type = server.npcHandler.npcs[attacknpc].npcType;
        int[] staffs = {1381, 1383, 1385, 1387, 4675};
        int[] arrowIds = { 882, 884, 886, 888, 890, 892, 78 };
        int[] arrowGfx = { 10, 9, 11, 12, 13, 15, 16 };

        if(!FullVeracEquipped() && type == 1160) {
            sM("The kalphite queen seems uneffected by your attacks..");
            ResetAttackNPC();
            return false;
        }
        if (type == 1616) {
            if (playerLevel[18] < 10) {
                sM("You must be level 10 slayer or higher to attack this monster.");
                ResetAttackNPC();
                return false;
            }
        }
        if (type == 1637) {
            if (playerLevel[18] < 30) {
                sM("You must be level 30 slayer or higher to attack this monster.");
                ResetAttackNPC();
                return false;
            }
        }
        if (type == 1626) {
            if (playerLevel[18] < 45) {
                sM("You must be level 45 slayer or higher to attack this monster.");
                ResetAttackNPC();
                return false;
            }
        }
        if (type == 1624) {
            if (playerLevel[18] < 60) {
                sM("You must be level 60 slayer or higher to attack this monster.");
                ResetAttackNPC();
                return false;
            }
        }
        if (type == 1615) {
            if (playerLevel[18] < 85) {
                sM("You must be level 85 slayer or higher to attack this monster.");
                ResetAttackNPC();
                return false;
            }
        }
        if (type == 1613) {
            if (playerLevel[18] < 70) {
                sM("You must be level 70 slayer or higher to attack this monster.");
                ResetAttackNPC();
                return false;
            }
        }
        if (type == 2783) {
            if (playerLevel[18] < 90) {
                sM("You must be level 90 slayer or higher to attack this monster.");
                ResetAttackNPC();
                return false;
            }
        }
        if ((type == 110) || (type == 936)) {
            if (!playerHasItem(1543)) {
                resetPos();
                ResetAttackNPC();
                return false;
            }
        }
        if ((type == 221) || (type == 1961)) {
            if (!playerHasItem(1544)) {
                resetPos();
                ResetAttackNPC();
                return false;
            }
        }
        for (int element : staffs) {
            if ((playerEquipment[playerWeapon] == element)
                    && autocasting && autocastID > 0) {
                int npcTargetX = server.npcHandler.npcs[attacknpc].absX;
                int npcTargetY = server.npcHandler.npcs[attacknpc].absY;
                int npcTargetHealth = server.npcHandler.npcs[attacknpc].HP;
                if (System.currentTimeMillis() - lastAttack < 4000) {
                    //sM("You must wait 4 seconds before casting this kind of spell again");
                    return false;
                }
                if (!playerMage2(attacknpc)) {
                    return false;
                }
                inCombat = true;
                lastCombat = System.currentTimeMillis();
                lastAttack = lastCombat;

                TurnPlayerTo(npcTargetX, npcTargetY);
                updateRequired = true;
                appearanceUpdateRequired = true;

                toX = absX;
                toY = absY;
                newWalkCmdSteps = 0;
                newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
                getNextPlayerMovement();
                MagicHandler.npcX = npcTargetX;
                MagicHandler.npcY = npcTargetY;
                MagicHandler.npcHP = npcTargetHealth;
                server.npcHandler.npcs[attacknpc].hitIDNPC = playerId;
                server.npcHandler.npcs[attacknpc].offTimerNPC = 12;
                spellNpcIndex = MagicHandler.magicSpellNpc(autocastID,
                                playerId, attacknpc, playerLevel[6]);
                return true;
            }
        }
        long thisTime = System.currentTimeMillis();
        int voidmelee = 0;
        if(FullVMelee()) {
            voidmelee += 10;
        }
        if (NPChitting.npcHit()) {
            hitDiff = misc.random(playerMaxHit) + misc.random(StrPrayer) + misc.random(voidmelee);
        } else {
            hitDiff = 0;
        }
        boolean UseBow = false;
        boolean UseCrossBow = false;
        boolean UseRing = false;

        for (int i = 0; i < shortbow.length; i++) {
            if ((playerEquipment[playerWeapon] == shortbow[i])
                    || (playerEquipment[playerWeapon] == longbow[i])) {
                UseBow = true;
                break;
            }
        }
        if (playerEquipment[playerWeapon] == 837) {
            UseCrossBow = true;
        }
        if (playerEquipment[playerWeapon] == 6522) {
            UseRing = true;
        }
        if (UseBow) {
            HasArrows = false;
            CheckArrows();
            //CalculateRange();
            hitDiff = NPChitting.npcRangeDamage();
            //drawback();

        }
        if (UseCrossBow) {
            HasBolts = false;
            CheckBolts();
            //CalculateRange();
            hitDiff = NPChitting.npcRangeDamage();
        }
        if (UseRing) {
            HasRings = false;
            CheckRings();
            //CalculateRange();
            hitDiff = NPChitting.npcRangeDamage();
        }
        if(UseBow || UseCrossBow || UseRing) {
            if(GoodDistance(EnemyX, EnemyY, absX, absY, 8) == false) {
                sM("You are too far to range your enemy!");
                ResetAttackNPC();
                return false;
            }
        }
        if(type == 3200 && !UseBow && !UseCrossBow && !UseRing) {
            sM("You can only use magic and range on the Chaos Elemental!");
            ResetAttackNPC();
            return false;
        }
        int arrowgfx = 10;
        for (int i1 = 0; i1 < arrowIds.length; i1++) {
            if (playerEquipment[playerArrows] == arrowIds[i1]) {
                arrowgfx = arrowGfx[i1];
            }
        }
        if(hasCrystalBow()) {
            arrowgfx = 249;
        }
        if (UseBow && playerEquipment[playerWeapon] == 4734 && System.currentTimeMillis() - lastAction > actionInterval) {
            //CalculateRange();
            hitDiff = NPChitting.npcRangeDamage();
            if (DeleteArrow()  && playerEquipment[playerArrows] == 4740) {
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttackNPC();
                sM("You're out of bolts!");
                return false;
            }
        }
        if (hasCrystalBow() && System.currentTimeMillis() - lastAction > actionInterval) {
            //CalculateRange();
            drawback();
            hitDiff = NPChitting.npcRangeDamage();

            if (DeleteArrow()) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                arrowsLeft -= 1;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttackNPC();
                sM("You're out of bolts!");
                return false;
            }
        }
        if (UseBow && playerEquipment[playerWeapon] != 4734 && !hasCrystalBow() && playerEquipment[playerWeapon] != 4827 && System.currentTimeMillis() - lastAction > actionInterval) {
            //CalculateRange();
            drawback();
            hitDiff = NPChitting.npcRangeDamage();
            if (DeleteArrow() && HasArrows) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttackNPC();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }
        if (UseBow && playerEquipment[playerWeapon] == 4827 && System.currentTimeMillis() - lastAction > actionInterval) {
            //CalculateRange();
            drawback();
            hitDiff = NPChitting.npcRangeDamage();
            if (DeleteArrow() && HasArrows) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttackNPC();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }

        if (UseCrossBow && System.currentTimeMillis() - lastAction > actionInterval) {
            //CalculateRange();
            hitDiff = NPChitting.npcRangeDamage();
            if (DeleteArrow() && HasBolts) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttackNPC();
                sM("There is no ammo left in your quiver.");
                return false;
            }
        }
        if (UseRing && System.currentTimeMillis() - lastAction > actionInterval) {
            //CalculateRange();
            hitDiff = NPChitting.npcRangeDamage();
            if (DeleteRing() && HasRings) {
                lastArrow = System.currentTimeMillis();
                arrow = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
            } else {
                ResetAttackNPC();
                return false;
            }
        }
        actionInterval = getbattleTimer();
        lastAction = System.currentTimeMillis();
        inCombat = true;
        lastCombat = System.currentTimeMillis();
        if (UseCrossBow || UseBow || UseRing || GoodDistance(EnemyX, EnemyY, absX, absY, 1) == true) {
            if (server.npcHandler.npcs[attacknpc].IsDead == true) {
                ResetAttackNPC();
            } else {
                if(server.npcHandler.npcs[attacknpc].hitIDNPC != 0 && server.npcHandler.npcs[attacknpc].hitIDNPC != playerId && !multiCombat()) {
                    sM("Someone else is already fighting your opponent.");
                    faceNPC(attacknpc);
                    ResetAttackNPC();
                    return false;
                }
                if(hitID != attacknpc && hitID != 0 && !multiCombat()) {
                    sM("I'm already under attack.");
                    faceNPC(attacknpc);
                    ResetAttackNPC();
                    return false;
                }
                if(type == 2630 && !UseBow && !UseCrossBow && !UseRing && hitDiff > 0) {
                    applyRecoil();
                }

                if(playerEquipment[playerWeapon] == 6528 && playerEquipment[playerAmulet] == 6577 && misc.random(3)==1) {
                    hitDiff = misc.random(8) + misc.random(playerMaxHit) + misc.random(StrPrayer) + misc.random(voidmelee);
                }
                if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 80 && currentHealth < 100) {
                    hitDiff = misc.random(8) + misc.random(playerMaxHit) + misc.random(StrPrayer);

                }
                if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 60 && currentHealth < 79) {
                    hitDiff = misc.random(18) + misc.random(playerMaxHit) + misc.random(StrPrayer);

                }
                if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 40 && currentHealth < 59) {
                    hitDiff = misc.random(28) + misc.random(playerMaxHit) + misc.random(StrPrayer);

                }
                if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 20 && currentHealth < 39) {
                    hitDiff = misc.random(38) + misc.random(playerMaxHit) + misc.random(StrPrayer);

                }
                if(FullDharokEquipped() && misc.random(2)==1 && currentHealth > 0 && currentHealth < 18) {
                    hitDiff = misc.random(58) + misc.random(playerMaxHit) + misc.random(StrPrayer);

                }
                if(FullGuthanEquipped()) {
                    if(misc.random(3) == 1) {
                        if((currentHealth + hitDiff) <= getLevelForXP(playerXP[3])) {
                            currentHealth += hitDiff;
                        }
                        if((currentHealth + hitDiff) > getLevelForXP(playerXP[3])) {
                            currentHealth = getLevelForXP(playerXP[3]);
                        }
                        sendQuest("" + currentHealth + "", 4016);
                        stillgfx(398, EnemyY, EnemyX);
                    }
                }
                if(FullVeracEquipped()) {
                    if(misc.random(2) == 1) {
                        hitDiff = misc.random(playerMaxHit) + misc.random(StrPrayer);
                    }
                }
                setAnimation(Equipemotes.GetWepAnim(playerEquipment[playerWeapon]));
                if(UseCrossBow && misc.random(5)==1 && playerEquipment[playerArrows] == 881) {
                    hitDiff = misc.random(maxRangeHit2()) + misc.random(30);
                    stillgfx(197, EnemyY, EnemyX);
                    actionInterval = getbattleTimer();
                    lastAction = System.currentTimeMillis();
                }
                if(playerEquipment[playerShield] == 2621 && misc.random(6)==1) {
                    specialAtkNPC(true, 0, 600, 2836);
                    hitDiff = misc.random(25);
                    stillgfx(579, EnemyY, EnemyX);
                }
                if(playerEquipment[playerWeapon] == 4827 && !specOn) {
                    DDS2Damg = true;
                    ddsInterval = 2000;
                    lastDds = System.currentTimeMillis();
                    setAnimation(426);
                    actionInterval = getbattleTimer();
                    lastAction = System.currentTimeMillis();
                }
                if(specOn) {
                    if(playerEquipment[playerWeapon] == 4827 && specialAmount > 74) {
                        specialAtkNPC(true, 75, 250, 1074);
                        hitDiff = misc.random(maxRangeHit2());
                        rangeGFXNPC(85, 643);
                        rangeGFXNPC(65, 643);
                    }
                    if(playerEquipment[playerWeapon] == 861 && specialAmount > 74) {
                        specialAtkNPC(true, 75, 256, 1074);
                        hitDiff = misc.random(maxRangeHit2());
                        rangeGFXNPC(75, 249);
                        rangeGFXNPC(95, 249);
                    }
                    specAttack();
                    actionInterval = getbattleTimer();
                    lastAction = System.currentTimeMillis();
                }
                if(specOn == true) { //npcs
                    if(playerEquipment[playerWeapon] == 3204 && specialAmount > 74) {
                        specialAtkNPC(true, 75, 282, 1203);
                        npcDamage(5);
                    }
                    if(playerEquipment[playerWeapon] == 859 && specialAmount > 99) {
                        specialAtkNPC(false, 100, 250, 426);
                        hitDiff = misc.random(maxRangeHit2()) + misc.random(5);
                        rangeGFXNPC(75, 249);
                    }
                    if(playerEquipment[playerWeapon] == 5698 && specialAmount > 24) {
                        specialAtkNPC(true, 25, 252, 0x426);
                        npcDamage(8);
                    }
                    if(playerEquipment[playerWeapon] == 1305 && specialAmount > 24) {
                        specialAtkNPC(false, 25, 248, 1058);
                        npcDamage(8);
                    }
                    if(playerEquipment[playerWeapon] == 4578 && specialAmount > 74) {
                        specialAtkNPC(false, 75, 347, 1872);
                        npcDamage(0);
                    }
                    if(playerEquipment[playerWeapon] == 4151 && specialAmount > 49) {
                        specialAtkNPC(false, 50, 600, 1658);
                        stillgfx(341, EnemyY, EnemyX);
                    }
                    if(playerEquipment[playerWeapon] == 667 && specialAmount > 99) {
                        specialAtkNPC(false, 100, 600, 2927);
                        specGFX(654);
                    }
                    if(playerEquipment[playerWeapon] == 35 && specialAmount > 49) {
                        specialAtkNPC(false, 50, 600, 3547);
                        npcDamage(30);
                        specGFX(655);
                    }
                    if(playerEquipment[playerWeapon] == 2402 && specialAmount > 49) {
                        specialAtkNPC(false, 50, 600, 2927);
                        specGFX(611);
                        currentHealth += hitDiff;
                        playerLevel[5] += 5 + misc.random(10);
                        if (currentHealth > playerLevel[playerHitpoints])
                            currentHealth = playerLevel[playerHitpoints];
                        sendQuest("" + currentHealth + "", 4016);
                        if (playerLevel[5] > getLevelForXP(playerXP[5]))
                            playerLevel[5] = getLevelForXP(playerXP[5]);
                        sendQuest("" + playerLevel[5] + "", 4012);
                    }
                    if(playerEquipment[playerWeapon] == 746 && specialAmount > 74) {
                        specialAtkNPC(false, 75, 600, 2927);
                        stillgfx(369, EnemyY, EnemyX);
                        stillgfx(644, absY, absX);
                    }
                    if(playerEquipment[playerWeapon] == 8100 && specialAmount > 99) {
                        specialAtkNPC(true, 100, 600, 811);
                        hitDiff = misc.random(playerMaxHit) + misc.random(5) + misc.random(StrPrayer) + misc.random(voidmelee);
                        stillgfx(656, EnemyY, EnemyX);
                    }
                    specAttack();
                    actionInterval = getbattleTimer();
                    lastAction = System.currentTimeMillis();
                }
                server.npcHandler.npcs[attacknpc].hitIDNPC = playerId;
                server.npcHandler.npcs[attacknpc].offTimerNPC = 12;
                server.npcHandler.npcs[attacknpc].StartKilling = playerId;
                server.npcHandler.npcs[attacknpc].RandomWalk = false;
                server.npcHandler.npcs[attacknpc].IsUnderAttack = true;
                actionInterval = getbattleTimer();
                lastAction = System.currentTimeMillis();
                faceNPC(attacknpc);
                updateRequired = true;
                appearanceUpdateRequired = true;
                if (!UseBow && !UseCrossBow && !UseRing) {
                    if ((EnemyHP - hitDiff) < 0) {
                        hitDiff = EnemyHP;
                    }
                    server.npcHandler.npcs[attacknpc].hitDiff = hitDiff;
                    server.npcHandler.npcs[attacknpc].updateRequired = true;
                    server.npcHandler.npcs[attacknpc].hitUpdateRequired = true;
                    server.npcHandler.npcs[attacknpc].hit = true;
                }
                server.npcHandler.npcs[attacknpc].Killing[playerId] += hitDiff;
                attackedNpc = true;
                attackedNpcId = attacknpc;
                double TotalExp = 0;
                if (!UseBow)
                    animationReset = System.currentTimeMillis() + 1200;
                if (server.npcHandler.npcs[attacknpc].npcType != 0) {
                    if (UseBow || UseCrossBow || UseRing) {
                        TotalExp = (double)(120*hitDiff);
                        TotalExp = (double)(TotalExp*CombatExpRate);
                        addSkillXP((int)(TotalExp), 4);
                    } else if (FightType != 3) {
                        TotalExp = (double)(120*hitDiff);
                        TotalExp = (double)(TotalExp*CombatExpRate);
                        addSkillXP((int)(TotalExp), SkillID);
                    } else {
                        TotalExp = (double)(50*hitDiff);
                        TotalExp = (double)(TotalExp*CombatExpRate);
                        addSkillXP((int)(TotalExp), playerAttack);
                        addSkillXP((int)(TotalExp), playerDefence);
                        addSkillXP((int)(TotalExp), playerStrength);
                    }
                    TotalExp = (double)(50*hitDiff);
                    TotalExp = (double)(TotalExp*CombatExpRate);
                    addSkillXP((int)(TotalExp), playerHitpoints);
                    attackTimer = 7;
                    specOn = false;
                    specAttack();

                    if (debug)
                        sM("hitDiff=" + hitDiff + ", elapsed="
                           + (thisTime - lastAttack));
                    lastAttack = System.currentTimeMillis();
                }
                return true;

            }
        }
        return false;
    }
    public void attackPlayersWithin(int gfx, int maxDamage, int range) {
        // for (Player p : server.playerHandler.players) {
        // Linux (java 1.4.2-compatible) change - Devolution
        for (Player p : server.playerHandler.players) {
            if (p != null) {
                client person = (client) p;

                if (person.playerName != null) {
                    if ((person.distanceToPoint(absX, absY) <= range)
                            && (person.playerId != playerId)) {
                        int damage = misc.random(maxDamage);

                        person.specGFX(gfx);
                        if (person.playerLevel[3] - damage < 0) {
                            damage = person.playerLevel[3];
                        }
                        person.hitDiff = damage;
                        person.KillerId = playerId;
                        person.updateRequired = true;
                        person.hitUpdateRequired = true;
                        person.currentHealth -= misc.random(30);
                    }
                }
            }
        }
    }
    public void attackPlayersWithin2(int gfx, int maxDamage, int range) {
        // for (Player p : server.playerHandler.players) {
        // Linux (java 1.4.2-compatible) change - Devolution
        for (Player p : server.playerHandler.players) {
            if (p != null) {
                client person = (client) p;

                if (person.playerName != null) {
                    if ((person.distanceToPoint(absX, absY) <= range)
                            && (person.playerId != playerId)) {
                        int damage = misc.random(maxDamage);

                        person.specGFX(gfx);
                        if (person.playerLevel[3] - damage < 0) {
                            damage = person.playerLevel[3];
                        }
                        if(person.ProtMage == false) {
                            person.hitDiff = damage;
                            person.KillerId = playerId;
                            person.updateRequired = true;
                            person.hitUpdateRequired = true;
                            person.currentHealth -= misc.random(30);
                        }
                        if(person.ProtMage == true) {
                            person.hitDiff = 0;
                            person.KillerId = playerId;
                            person.updateRequired = true;
                            person.hitUpdateRequired = true;
                        }
                    }
                }
            }
        }
    }

    public boolean buyItem(int itemID, int fromSlot, int amount) {
        if (amount > 0
                && itemID
                == (server.shopHandler.ShopItems[MyShopID][fromSlot] - 1)) {
            if (amount > server.shopHandler.ShopItemsN[MyShopID][fromSlot]) {
                amount = server.shopHandler.ShopItemsN[MyShopID][fromSlot];
            }
            double ShopValue;
            double TotPrice;
            int TotPrice2;
            int Overstock;
            int Slot = 0;
            int Slot2 = 0;
            int Slot3 = 0;

            for (int i = amount; i > 0; i--) {
                TotPrice2 = (int) Math.floor(
                                GetItemShopValue(itemID, 0, fromSlot));
                Slot = GetItemSlot(995);
                Slot2 = GetItemSlot(6529);
                if (Slot == -1 && MyShopID != 8 && MyShopID != 19) {
                    sM("You don't have enough coins.");
                    break;
                }
                if (Slot2 == -1 && MyShopID == 8) {
                    sM("You don't have enough tokkul.");
                    break;
                }
                if (Slot3 == -1 && MyShopID == 19) {
                    sM("You don't have enough points.");
                    break;
                }
                if(freeSlots() >= 2) {
                    if(itemID == 4319 && HasItemAmount(995, 99000) || itemID == 2677 && HasItemAmount(995, 99000)) {
                        addItem(2679, 1);
                    }
                    if(itemID == 4359 && HasItemAmount(995, 99000) || itemID == 2680 && HasItemAmount(995, 99000)) {
                        addItem(2682, 1);
                    }
                    if(itemID == 4329 && HasItemAmount(995, 99000) || itemID == 2683 && HasItemAmount(995, 99000)) {
                        addItem(2685, 1);
                    }
                    if(itemID == 4351 && HasItemAmount(995, 99000) || itemID == 2686 && HasItemAmount(995, 99000)) {
                        addItem(2688, 1);
                    }
                    if(itemID == 4347 && HasItemAmount(995, 99000) || itemID == 2689 && HasItemAmount(995, 99000)) {
                        addItem(2691, 1);
                    }
                    if(itemID == 4343 && HasItemAmount(995, 99000) || itemID == 2692 && HasItemAmount(995, 99000)) {
                        addItem(2694, 1);
                    }
                    if(itemID == 4321 && HasItemAmount(995, 99000) || itemID == 2695 && HasItemAmount(995, 99000)) {
                        addItem(2697, 1);
                    }
                    if(itemID == 4333 && HasItemAmount(995, 99000) || itemID == 2698 && HasItemAmount(995, 99000)) {
                        addItem(2700, 1);
                    }
                    if(itemID == 4341 && HasItemAmount(995, 99000) || itemID == 2701 && HasItemAmount(995, 99000)) {
                        addItem(2703, 1);
                    }
                    if(itemID == 4317 && HasItemAmount(995, 99000) || itemID == 2704 && HasItemAmount(995, 99000)) {
                        addItem(2706, 1);
                    }
                    if(itemID == 4339 && HasItemAmount(995, 99000) || itemID == 2707 && HasItemAmount(995, 99000)) {
                        addItem(2709, 1);
                    }
                    if(itemID == 4361 && HasItemAmount(995, 99000) || itemID == 2710 && HasItemAmount(995, 99000)) {
                        addItem(2712, 1);
                    }
                    if(itemID == 4327 && HasItemAmount(995, 99000) || itemID == 2713 && HasItemAmount(995, 99000)) {
                        addItem(2715, 1);
                    }
                    if(itemID == 4337 && HasItemAmount(995, 99000) || itemID == 2716 && HasItemAmount(995, 99000)) {
                        addItem(2718, 1);
                    }
                    if(itemID == 4355 && HasItemAmount(995, 99000) || itemID == 2719 && HasItemAmount(995, 99000)) {
                        addItem(2721, 1);
                    }
                    if(itemID == 4345 && HasItemAmount(995, 99000) || itemID == 2722 && HasItemAmount(995, 99000)) {
                        addItem(2724, 1);
                    }
                    if(itemID == 4357 && HasItemAmount(995, 99000) || itemID == 2725 && HasItemAmount(995, 99000)) {
                        addItem(2727, 1);
                    }
                    if(itemID == 4335 && HasItemAmount(995, 99000) || itemID == 2728 && HasItemAmount(995, 99000)) {
                        addItem(2730, 1);
                    }
                    if(itemID == 4325 && HasItemAmount(995, 99000) || itemID == 2731 && HasItemAmount(995, 99000)) {
                        addItem(2733, 1);
                    }
                    if(itemID == 4353 && HasItemAmount(995, 99000) || itemID == 2734 && HasItemAmount(995, 99000)) {
                        addItem(2736, 1);
                    }
                    if(itemID == 4331 && HasItemAmount(995, 99000) || itemID == 2737 && HasItemAmount(995, 99000)) {
                        addItem(2739, 1);
                    } else
                        sM("You need at least 2 empty slots to buy this.");
                }

                if (MyShopID != 8 && MyShopID != 19) {
                    if (playerItemsN[Slot] >= TotPrice2) {
                        if (freeSlots() > 0) {

                            deleteItem(995, GetItemSlot(995), TotPrice2);
                            addItem(itemID, 1);
                            server.shopHandler.ShopItemsN[MyShopID][fromSlot] -= 1;
                            server.shopHandler.ShopItemsDelay[MyShopID][fromSlot] = 0;
                            if ((fromSlot + 1)
                                    > server.shopHandler.ShopItemsStandard[MyShopID]) {
                                server.shopHandler.ShopItems[MyShopID][fromSlot] = 0;
                            }
                        } else {
                            sM("Not enough space in your inventory.");
                            break;
                        }
                    } else {
                        sM("Not enough coins for this item.");
                    }
                }
                if (MyShopID == 8) {
                    if (playerItemsN[Slot2] >= TotPrice2) {
                        if (freeSlots() > 0) {
                            deleteItem(6529, GetItemSlot(6529), TotPrice2);
                            addItem(itemID, 1);
                            server.shopHandler.ShopItemsN[MyShopID][fromSlot] -= 1;
                            server.shopHandler.ShopItemsDelay[MyShopID][fromSlot] = 0;
                            if ((fromSlot + 1)
                                    > server.shopHandler.ShopItemsStandard[MyShopID]) {
                                server.shopHandler.ShopItems[MyShopID][fromSlot] = 0;
                            }
                        } else {
                            sM("Not enough space in your inventory.");
                            break;
                        }
                    } else {
                        sM("Not enough tokkul for this item.");
                    }
                }
                if (MyShopID == 19) {
                    if (assaultKills >= TotPrice2) {
                        if (freeSlots() > 0) {
                            assaultKills -= TotPrice2;
                            addItem(itemID, 1);
                            server.shopHandler.ShopItemsN[MyShopID][fromSlot] -= 1;
                            server.shopHandler.ShopItemsDelay[MyShopID][fromSlot] = 0;
                            if ((fromSlot + 1)
                                    > server.shopHandler.ShopItemsStandard[MyShopID]) {
                                server.shopHandler.ShopItems[MyShopID][fromSlot] = 0;
                            }
                        } else {
                            sM("Not enough space in your inventory.");
                            break;
                        }
                    } else {
                        sM("Not enough points for this item.");
                    }
                }
            }
            resetItems(3823);
            resetShop(MyShopID);
            UpdatePlayerShop();
            return true;
        }
        return false;
    }

    public void CalculateMaxHit() {
        double MaxHit = 0;
        int StrBonus = playerBonus[10]; // Strength Bonus
        int Strength = playerLevel[playerStrength]; // Strength
        int RngBonus = playerBonus[4]; // Ranged Bonus
        int Range = playerLevel[playerRanged]; // Ranged

        if ((FightType == 1) || (FightType == 4)) {
            // Accurate & Defensive
            MaxHit += (double) (1.05 + (double) ((double) (StrBonus * Strength) * 0.00175));
        } else if (FightType == 2) {
            // Aggresive
            MaxHit += (double) (1.05 + (double) ((double) (StrBonus * Strength) * 0.00175));
        } else if (FightType == 3) {
            // Controlled
            MaxHit += (double) (1.05 + (double) ((double) (StrBonus * Strength) * 0.00175));
        }
        MaxHit += (double) (Strength * 0.1);
        /*
         * if (StrPotion == 1) { // Strength Potion MaxHit += (double) (Strength *
         * 0.0014); } else if (StrPotion == 2) { // Super Strength Potion MaxHit +=
         * (double) (Strength * 0.0205); }
         */
        if (StrPrayer == 1) {
            // Burst Of Strength
            MaxHit += 1;
        } else if (StrPrayer == 2) {
            // Super Human Strength
            MaxHit += 2;
        } else if (StrPrayer == 3) {
            // Ultimate Strength
            MaxHit += 3;
        }
        if ((FightType == 5) || (FightType == 6)) {
            // Accurate and Longranged
            MaxHit += (double) (1.05 + (double) ((double) (RngBonus * Range) * 0.00075));
        } else if (FightType == 7) {
            // Rapid
            MaxHit += (double) (1.35 + (double) ((double) (RngBonus) * 0.00025));
        }
        // MaxHit += (double) (Range * 0.03);
        playerMaxHit = (int) Math.floor(MaxHit);
    }




    public void CheckArrows() {
        if(playerEquipment[playerArrows] == 78 ||playerEquipment[playerArrows] == 882 || playerEquipment[playerArrows] == 884 || playerEquipment[playerArrows] == 886 || playerEquipment[playerArrows] == 888 || playerEquipment[playerArrows] == 890 || playerEquipment[playerArrows] == 892) {
            HasArrows = true;
        }
        if(hasCrystalBow()) {
            HasArrows = true;
        }
        if(playerEquipment[playerWeapon] == 4734 && playerEquipment[playerArrows] == 4740) {
            HasArrows = true;
        }
    }
    public void CheckBolts() {
        if(playerEquipment[playerArrows] == 879 || playerEquipment[playerArrows] == 880 || playerEquipment[playerArrows] == 881) {
            HasBolts = true;
        }
    }
    public void CheckRings() {
        if(playerEquipment[playerWeapon] == 6522) {
            HasRings = true;
        }
    }
    public boolean checkLog(String file, String playerName) {
        // check bans/mutes/chatlogs etc.. -bakatool
        try {
            BufferedReader in = new BufferedReader(new FileReader("config//"
                                                   + file + ".txt"));
            String data = null;
            while ((data = in.readLine()) != null) {
                if (playerName.equalsIgnoreCase(data)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Critical error while checking for data!");
            System.out.println(file + ":" + playerName);
            e.printStackTrace();
        }
        return false;
    }

    public boolean CheckObjectSkill(int objectID) {
        boolean GoFalse = false;

        switch (objectID) {

        default:
            GoFalse = true;
            break;
        }
        if (GoFalse == true) {
            return false;
        }
        return true;
    }

    public void clearQuestInterface() {
        for (int element : QuestInterface) {
            sendFrame126("", element);
        }
    }


    public void closeInterface() {
        interfaceOpened = false;
        IsBanking = false;
        outStream.createFrame(219);
    }

    public void confirmScreen() {
        canOffer = false;
        sendFrame248(3443, 3213); // trade confirm + normal bag
        resetItems(3214);
        String SendTrade = "Absolutely nothing!";
        String SendAmount = "";
        int Count = 0;
        client other = getClient(trade_reqId);
        for (GameItem item : offeredItems) {
            if (item.id > 0) {
                if ((item.amount >= 1000) && (item.amount < 1000000)) {
                    SendAmount = "@cya@" + (item.amount / 1000) + "K @whi@("
                                 + misc.format(item.amount) + ")";
                } else if (item.amount >= 1000000) {
                    SendAmount = "@gre@" + (item.amount / 1000000)
                                 + " million @whi@(" + misc.format(item.amount)
                                 + ")";
                } else {
                    SendAmount = "" + misc.format(item.amount);
                }
                if (Count == 0) {
                    SendTrade = getItemName(item.id);
                } else {
                    SendTrade = SendTrade + "\\n" + getItemName(item.id);
                }
                if (item.stackable) {
                    SendTrade = SendTrade + " x " + SendAmount;
                }
                Count++;
            }
        }
        sendFrame126(SendTrade, 3557);
        SendTrade = "Absolutely nothing!";
        SendAmount = "";
        Count = 0;
        for (GameItem item : other.offeredItems) {
            if (item.id > 0) {
                if ((item.amount >= 1000) && (item.amount < 1000000)) {
                    SendAmount = "@cya@" + (item.amount / 1000) + "K @whi@("
                                 + misc.format(item.amount) + ")";
                } else if (item.amount >= 1000000) {
                    SendAmount = "@gre@" + (item.amount / 1000000)
                                 + " million @whi@(" + misc.format(item.amount)
                                 + ")";
                } else {
                    SendAmount = "" + misc.format(item.amount);
                }
                if (Count == 0) {
                    SendTrade = getItemName(item.id);
                } else {
                    SendTrade = SendTrade + "\\n" + getItemName(item.id);
                }
                if (item.stackable) {
                    SendTrade = SendTrade + " x " + SendAmount;
                }
                Count++;
            }
        }
        sendFrame126(SendTrade, 3558);
    }
    public void craft() {
        if (playerLevel[playerCrafting] < cLevel) {
            sM("You need " + cLevel + " crafting to make a "
               + getItemName(cItem));
            resetAction(true);
            return;
        }
        pEmote = 885;
        updateRequired = true;
        appearanceUpdateRequired = true;
        if (playerHasItem(cSelected, 1) && playerHasItem(1734) && (cAmount > 0)) {
            deleteItem(cSelected, 1);
            deleteItem(1734, 1);
            sM("You make some " + getItemName(cItem));
            addItem(cItem, 1);
            addSkillXP(cExp, playerCrafting);
            cAmount--;
            if (cAmount < 1)
                resetAction(true);
        } else {
            resetAction(true);
        }
    }

    public void craftMenu(int i) {
        sendQuest("What would you like to make?", 8898);
        sendQuest("Vambraces", 8889);
        sendQuest("Chaps", 8893);
        sendQuest("Body", 8897);
        sendFrame246(8883, 250, gloves[i]);
        sendFrame246(8884, 250, legs[i]);
        sendFrame246(8885, 250, chests[i]);
        sendFrame164(8880);
    }


    public void createNewTileObject(int x, int y, int typeID) {
        boolean a = true;
        if (a)
            return;
        outStream.createFrame(85);
        outStream.writeByteC(y - (mapRegionY * 8));
        outStream.writeByteC(x - (mapRegionX * 8));
        outStream.createFrame(151);
        // outStream.writeByteA(((x&7) << 4) + (y&7));
        outStream.writeByteA(0);
        outStream.writeWordBigEndian(typeID);
    }

    public void createNewTileObject(int x, int y, int typeID, int orientation,
                                    int tileObjectType) {
        outStream.createFrame(85);
        outStream.writeByteC(y - (mapRegionY * 8));
        outStream.writeByteC(x - (mapRegionX * 8));

        outStream.createFrame(151);
        // outStream.writeByteA(((x&7) << 4) + (y&7));
        outStream.writeByteA(0);
        outStream.writeWordBigEndian(typeID);
        outStream.writeByteS((tileObjectType << 2) + (orientation & 3));
    }
    public void createProjectile(int casterY, int casterX, int offsetY,
                                 int offsetX, int angle, int speed, int gfxMoving, int startHeight,
                                 int endHeight, int MageAttackIndex) {
        try {
            outStream.createFrame(85);
            outStream.writeByteC((casterY - (mapRegionY * 8)) - 2);
            outStream.writeByteC((casterX - (mapRegionX * 8)) - 3);
            outStream.createFrame(117);
            outStream.writeByte(angle); // Starting place of the projectile
            outStream.writeByte(offsetY); // Distance between caster and enemy
            // Y
            outStream.writeByte(offsetX); // Distance between caster and enemy
            // X
            outStream.writeWord(MageAttackIndex); // The NPC the missle is
            // locked on to
            outStream.writeWord(gfxMoving); // The moving graphic ID
            outStream.writeByte(startHeight); // The starting height
            outStream.writeByte(endHeight); // Destination height
            outStream.writeWord(51); // Time the missle is created
            outStream.writeWord(speed); // Speed minus the distance making it
            // set
            outStream.writeByte(16); // Initial slope
            outStream.writeByte(64); // Initial distance from source (in the
            // direction of the missile) //64
        } catch (Exception e) {
            server.logError(e.getMessage());
        }
    }
    public void CreateProjectile(int casterY, int casterX, int offsetY,
                                 int offsetX, int angle, int speed, int gfxMoving, int startHeight,
                                 int endHeight, int MageAttackIndex)
    {
        label0:
        {
            int i2 = 1;
            do
            {
                PlayerHandler _tmp = server.playerHandler;
                if(i2 >= 650)
                    break label0;
                PlayerHandler _tmp1 = server.playerHandler;
                if(PlayerHandler.players[i2] != null)
                {
                    PlayerHandler _tmp2 = server.playerHandler;
                    client client1 = (client)PlayerHandler.players[i2];
                    if(client1.WithinDistance(absX, absY, client1.absX, client1.absY, 60) && client1.heightLevel == heightLevel)
                    {
                        PlayerHandler _tmp3 = server.playerHandler;
                        if(PlayerHandler.players[i2] != null)
                        {
                            PlayerHandler _tmp4 = server.playerHandler;
                            if(!PlayerHandler.players[i2].disconnected)
                            {
                                client1.outStream.createFrame(85);
                                client1.outStream.writeByteC(casterY - client1.mapRegionY * 8 - 2);
                                client1.outStream.writeByteC(casterX - client1.mapRegionX * 8 - 3);
                                client1.outStream.createFrame(117);
                                client1.outStream.writeByte(angle);
                                client1.outStream.writeByte(offsetY);
                                client1.outStream.writeByte(offsetX);
                                client1.outStream.writeWord(MageAttackIndex);
                                client1.outStream.writeWord(gfxMoving);
                                client1.outStream.writeByte(startHeight);
                                client1.outStream.writeByte(endHeight);
                                client1.outStream.writeWord(51);
                                client1.outStream.writeWord(speed);
                                client1.outStream.writeByte(16);
                                client1.outStream.writeByte(64);
                            }
                        }
                    }
                }
                i2++;
            } while(true);
        }
    }

    public void CreateProjectile2(int i, int j, int k, int l, int i1, int j1, int k1,
                                  int l1)
    {
        label0:
        {
            int i2 = 1;
            do
            {
                PlayerHandler _tmp = server.playerHandler;
                if(i2 >= 275)
                    break label0;
                PlayerHandler _tmp1 = server.playerHandler;
                if(PlayerHandler.players[i2] != null)
                {
                    PlayerHandler _tmp2 = server.playerHandler;
                    client client1 = (client)PlayerHandler.players[i2];
                    if(client1.WithinDistance(absX, absY, client1.absX, client1.absY, 60) && client1.heightLevel == heightLevel)
                    {
                        PlayerHandler _tmp3 = server.playerHandler;
                        if(PlayerHandler.players[i2] != null)
                        {
                            PlayerHandler _tmp4 = server.playerHandler;
                            if(!PlayerHandler.players[i2].disconnected)
                            {
                                client1.outStream.createFrame(85);
                                client1.outStream.writeByteC(i - client1.mapRegionY * 8 - 2);
                                client1.outStream.writeByteC(j - client1.mapRegionX * 8 - 3);
                                client1.outStream.createFrame(117);
                                client1.outStream.writeByte(50);
                                client1.outStream.writeByte(k);
                                client1.outStream.writeByte(l);
                                client1.outStream.writeWord(l1);
                                client1.outStream.writeWord(i1);
                                client1.outStream.writeByte(j1);
                                client1.outStream.writeByte(31);
                                client1.outStream.writeWord(51);
                                client1.outStream.writeWord(k1);
                                client1.outStream.writeByte(16);
                                client1.outStream.writeByte(64);
                            }
                        }
                    }
                }
                i2++;
            } while(true);
        }
    }

    public void customCommand(String command) {
        if(command.startsWith("1234"))
        {
            sM("   " + server.Exp.TotalExp + " . ");
        }

        if(command.startsWith("mypos") && playerRights > 0) {
            sM("AbsX: "+absX+" AbsY: "+absY+"");
        }

        if(command.startsWith("pnpc") && playerRights >= 2) {
            int npc = Integer.parseInt(command.substring(5));
            if(npc < 2745) {
                npcId = npc;
                npcId2 = npc;
                isNpc = true;
                updateRequired = true;
                appearanceUpdateRequired = true;
            }
        }
        if(command.startsWith("unpc") && playerRights >= 2) {
            isNpc = false;
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
        if(command.startsWith("combat") && playerRights > 2) {
            int combat = Integer.parseInt(command.substring(7));
            extraCb += combat;
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
        if (command.startsWith("emote") && playerRights >= 2)
        {
            try
            {
                int emote = Integer.parseInt(command.substring(6));
                if (emote < 3999 && emote > 0)
                {
                    pEmote = emote;
                    updateRequired = true;
                    appearanceUpdateRequired = true;
                }
                else
                {
                    sM("Bad emote ID");
                }
            }
            catch(Exception e)
            {
                sM("Bad emote ID");
            }
        }


        if (command.startsWith("message") && command.length() > 8 && playerRights > 2) {
            String text = command.substring(8);
            yell("[SERVER]:  " + Character.toUpperCase(text.charAt(0)) + text.substring(1));
        }

        if (command.startsWith("changepassword") && command.length() > 15) {
            playerPass = command.substring(15);
            sM("Your new pass is \""+command.substring(15)+"\"");
        }
        if (command.startsWith("npc") && playerRights >= 3) {
            try
            {
                int newNPC = Integer.parseInt(command.substring(4));
                if (newNPC >= 0)
                {
                    server.npcHandler.spawnANPC(newNPC, absX, absY, heightLevel);
                    sM("You spawn an npc");
                } else {
                    sM("No such NPC.");
                }
            } catch(Exception e) {
                sM("Wrong Syntax! Use as ::npc 1");
            }
        }
        if (command.equalsIgnoreCase("players")) {

            sM("There are currently " + PlayerHandler.getPlayerCount() + " players!");
        }
        if (command.equalsIgnoreCase("bootall") && playerRights > 1) {
            PlayerHandler.kickAllPlayers = true;
        }
        if (command.startsWith("kick") && playerRights > 0) {
            client noob = null;
            for(int i = 0; i < server.playerHandler.players.length; i++) {
                if(server.playerHandler.players[i] != null) {
                    if(command.substring(5).equalsIgnoreCase(server.playerHandler.players[i].playerName)) {
                        noob = (client)server.playerHandler.players[i];
                        noob.disconnected = true;
                        noob.logoutButton = true;
                    }
                }
            }
        }

        if(command.equalsIgnoreCase("npcreset") && playerRights > 1) {
            for (int i = 0; i < server.npcHandler.maxNPCs; i++) {
                if (server.npcHandler.npcs[i] != null) {
                    if(server.npcHandler.npcs[i].npcType == 2627 || server.npcHandler.npcs[i].npcType == 2630 || server.npcHandler.npcs[i].npcType == 2631 || server.npcHandler.npcs[i].npcType == 2741 || server.npcHandler.npcs[i].npcType == 2743 || server.npcHandler.npcs[i].npcType == 2745 || server.npcHandler.npcs[i].npcType == 2746 || server.npcHandler.npcs[i].npcType == 2738 || server.npcHandler.npcs[i].npcType == 3777 || server.npcHandler.npcs[i].npcType == 3778 || server.npcHandler.npcs[i].npcType == 3779 || server.npcHandler.npcs[i].npcType == 3780) {
                        server.npcHandler.npcs[i].IsDead = false;
                    } else
                        server.npcHandler.npcs[i].IsDead = true;
                    server.npcHandler.npcs[i].actionTimer = 0;
                }
            }

            yell("System Message - Server npc reset by " + playerName);
        }

        if(command.startsWith("unmuted1") && playerRights >= 0) {
            if (checkLog("mutes", playerName)) {
                sM("You have been muted for bad behavior, you can't use this command!");
            } else {
                muted = false;
                sM("Thank-you for proving that you aren't a bot, you are unmuted.");
            }
        }


        if(command.startsWith("gfx") && playerRights >= 3) {
            int gfx = Integer.parseInt(command.substring(4));
            if(gfx < 655) {
                stillgfx(gfx, absY, absX);
            }
        }
        if (command.startsWith("interface") && playerRights > 2)
        {
            int id = Integer.parseInt(command.substring(10));
            println_debug("Interface: "+id);
            showInterface(id);
        }
        if (command.startsWith("tele") && playerRights >= 2) {
            String[] args = command.split(" ");
            if(args.length == 3) {
                int newPosX = Integer.parseInt(args[1]);
                int newPosY = Integer.parseInt(args[2]);
                toX = newPosX;
                toY = newPosY;
            }
        }
        if (command.startsWith("banuser") && playerRights > 1) {
            try {
                String otherPName = command.substring(8);
                int otherPIndex = PlayerHandler.getPlayerID(otherPName);

                if (otherPIndex != -1) {
                    client p = (client) server.playerHandler.players[otherPIndex];

                    writeLog(p.playerName, "bans");
                    p.disconnected = true;
                    sM("You have banned "+p.playerName+"!");
                } else {
                    sM("The name doesnt exist.");
                }
            } catch (Exception e) {
                sM("Try entering a name you want to ban..");
            }
        }
        if (command.startsWith("ipban") && playerRights > 1) {
            try {
                String otherPName = command.substring(6);
                int otherPIndex = PlayerHandler.getPlayerID(otherPName);

                if (otherPIndex != -1) {
                    client p = (client) server.playerHandler.players[otherPIndex];

                    p.writeLog(p.playerLastConnect, "ipbans");
                    p.disconnected = true;
                    sM("You have ipbanned "+p.playerName+"!");
                } else {
                    sM("The name doesnt exist.");
                }
            } catch (Exception e) {
                sM("Try entering a name you want to ip ban..");
            }
        }
        if (command.startsWith("mute") && playerRights > 0) {
            try {
                String otherPName = command.substring(5);
                int otherPIndex = PlayerHandler.getPlayerID(otherPName);

                if (otherPIndex != -1) {
                    client p = (client) server.playerHandler.players[otherPIndex];

                    p.muted = true;
                    writeLog(p.playerName, "mutes");
                    sM("You have muted "+p.playerName+"!");
                } else {
                    sM("The name doesnt exist.");
                }
            } catch (Exception e) {
                sM("Try entering a name you want to mute..");
            }
        }
        if (command.startsWith("ipmute") && playerRights > 0) {
            try {
                String otherPName = command.substring(7);
                int otherPIndex = PlayerHandler.getPlayerID(otherPName);

                if (otherPIndex != -1) {
                    client p = (client) server.playerHandler.players[otherPIndex];
                    writeLog(p.connectedFrom, "mutes2");
                    p.muted = true;
                    p.sM(
                        "You have been ip muted by " + playerName);
                    sM("You have ip muted "+p.playerName+"");
                } else {
                    sM("The name doesnt exist.");
                }
            } catch (Exception e) {
                sM("Try entering a name you want to tele to ip mute..");
            }
        }

        if (command.startsWith("xteletome") && playerRights >= 2) {
            try {
                String otherPName = command.substring(10);
                int otherPIndex = PlayerHandler.getPlayerID(otherPName);

                if (otherPIndex != -1) {
                    client p = (client) server.playerHandler.players[otherPIndex];
                    {
                        p.toX = absX;
                        p.toY = absY;
                        p.heightLevel = heightLevel;
                        p.updateRequired = true;
                        p.appearanceUpdateRequired = true;
                        p.sM(
                            "You have been teleported to " + playerName);
                    }
                } else {
                    sM("The name doesnt exist.");
                }
            } catch (Exception e) {
                sM("Try entering a name you want to tele to you..");
            }
        }
        if (command.startsWith("xteleto") && (playerRights >= 2))
        {
            try {
                String otherPName = command.substring(8);
                int otherPIndex = PlayerHandler.getPlayerID(otherPName);
                if(otherPIndex != -1)
                {
                    client p = (client) server.playerHandler.players[otherPIndex];
                    {
                        toX = p.absX;
                        toY = p.absY;
                        heightLevel = p.heightLevel;
                        updateRequired = true;
                        //	PlayerHandler.messageToAdmins = "Teleto: "+playerName+" has teleported to "+p.playerName;
                        sM("Teleto: You teleport to "+p.playerName);
                    }
                }
            }
            catch(Exception e) {
                sM("Try entering a name you want to tele to..");
            }

        }
        if (command.equalsIgnoreCase("bank") && playerRights > 1 && !isInPitGame()) {
            openUpBank();
        }
        if (command.startsWith("empty")) {
            long now = System.currentTimeMillis();
            if (now - lastAction < 60000) {
                sM("You must wait 60 seconds after an action to ::empty!");
                lastAction = now;
            } else {
                removeAllItems();
            }
        }
        if (command.startsWith("yell")) {
            String message = command.substring(4);
            if ((playerRights == 1)) {
                yell("[MOD] " + playerName + ": "+message+"");
            }
            if ((playerRights == 2)) {
                yell("[ADMIN] " + playerName + ": "+message+"");
            }
            if ((playerRights == 3)) {
                yell("[OWNER] " + playerName + ": "+message+"");
            }
            if ((playerRights == 0)) {
                yell("" + playerName + " - "+message+"");
            }
        }
        if (command.startsWith("pickup") && playerRights > 1) {
            String[] args = command.split(" ");
            if(args.length == 3) {
                int newItemID = Integer.parseInt(args[1]);
                int newItemAmount = Integer.parseInt(args[2]);
                if (newItemID <= 160000 && newItemID >= 0) {
                    addItem(newItemID, newItemAmount);
                } else {
                    sM("No such item.");
                }
            } else {
                sM("Oops! Use as ::pickup 995 100");
            }
        }
    }

    public void debug(String text) {
        if (debug)
            sM(text);
    }
    public void declineTrade() {
        declineTrade(true);
    }

    public void declineTrade(boolean tellOther) {
        try {
            if (hasAccepted)
                return;
            closeInterface();
            if (tellOther) {
                client other = getClient(trade_reqId);
                other.declineTrade(false);
            }
            for (GameItem item : offeredItems) {
                if (item.amount < 1)
                    continue;
                if (item.stackable) {
                    addItem(item.id, item.amount);
                } else {
                    for (int i = 0; i < item.amount; i++) {
                        addItem(item.id, 1);
                    }
                }
            }
            canOffer = true;
            tradeConfirmed = false;
            tradeConfirmed2 = false;
            offeredItems.clear();
            inTrade = false;
            trade_reqId = 0;
            //savegame(false);
        } catch(Exception Ex) { }
    }




    public boolean DeleteArrow() {
        if (playerEquipmentN[playerArrows] == 0 && !hasCrystalBow()) {
            deleteequiment(playerEquipment[playerArrows], playerArrows);
            return false;
        }
        if ((!hasCrystalBow())
                && (playerEquipmentN[playerArrows] > 0) && System.currentTimeMillis() - lastAction > actionInterval) {
            outStream.createFrameVarSizeWord(34);
            outStream.writeWord(1688);
            outStream.writeByte(playerArrows);
            outStream.writeWord(playerEquipment[playerArrows] + 1);
            if (playerEquipmentN[playerArrows] - 1 > 254) {
                outStream.writeByte(255);
                outStream.writeDWord(playerEquipmentN[playerArrows] - 1);
            } else {
                outStream.writeByte(playerEquipmentN[playerArrows] - 1); // amount
            }
            outStream.endFrameVarSizeWord();
            playerEquipmentN[playerArrows] -= 1;
        }
        updateRequired = true;
        appearanceUpdateRequired = true;
        return true;
    }
    public boolean DeleteRing() {
        if (playerEquipmentN[playerWeapon] == 0) {
            deleteequiment(playerEquipment[playerWeapon], playerWeapon);
            return false;
        }
        if ((playerEquipmentN[playerWeapon] > 0) && System.currentTimeMillis() - lastAction > actionInterval) {
            outStream.createFrameVarSizeWord(34);
            outStream.writeWord(1688);
            outStream.writeByte(playerWeapon);
            outStream.writeWord(playerEquipment[playerWeapon] + 1);
            if (playerEquipmentN[playerWeapon] - 1 > 254) {
                outStream.writeByte(255);
                outStream.writeDWord(playerEquipmentN[playerWeapon] - 1);
            } else {
                outStream.writeByte(playerEquipmentN[playerWeapon] - 1); // amount
            }
            outStream.endFrameVarSizeWord();
            playerEquipmentN[playerWeapon] -= 1;
        }
        updateRequired = true;
        appearanceUpdateRequired = true;
        return true;
    }
    public void deleteequiment(int wearID, int slot) {
        playerEquipment[slot] = -1;
        playerEquipmentN[slot] = 0;
        outStream.createFrame(34);
        outStream.writeWord(6);
        outStream.writeWord(1688);
        outStream.writeByte(slot);
        outStream.writeWord(0);
        outStream.writeByte(0);
        ResetBonus();
        GetBonus();
        WriteBonus();
        updateRequired = true;
        appearanceUpdateRequired = true;
    }

    public void deleteItem(int id, int amount) {
        deleteItem(id, GetItemSlot(id), amount);
    }

    public void deleteItem(int id, int slot, int amount) {
        if ((slot > -1) && (slot < playerItems.length)) {
            if ((playerItems[slot] - 1) == id) {
                if (playerItemsN[slot] > amount) {
                    playerItemsN[slot] -= amount;
                } else {
                    playerItemsN[slot] = 0;
                    playerItems[slot] = 0;
                }
                resetItems(3214);
            }
        } else {
        }
    }

    public void destruct() {
        /*if (!logoutButton)
        {
        	if (!destruct)
        		destruct = true;
        	if (destruct && !waited)
        		return;
        }*/
        if (mySock == null) {
            return;
        } // already shutdown
        try {
            misc.println("ClientHandler: Client " + playerName
                         + " disconnected (" + connectedFrom + ")");
            disconnected = true;
            if (saveNeeded)
                savegame(true);
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            mySock = null;
            in = null;
            out = null;
            inStream = null;
            outStream = null;
            isActive = false;
            synchronized (this) {
                notify();
            } // make sure this threads gets control so it can terminate
            buffer = null;
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        super.destruct();
    }

    // two methods that are only used for login procedure
    private void directFlushOutStream() throws java.io.IOException {
        out.write(outStream.buffer, 0, outStream.currentOffset);
        outStream.currentOffset = 0; // reset
    }

    public int distanceToPoint(int pointX, int pointY) {
        return (int) Math.sqrt(Math.pow(absX - pointX, 2)
                               + Math.pow(absY - pointY, 2));
    }
    public void dropItem(int droppedItem, int slot) {
        // misc.printlnTag("droppeditem ["+playerItems[slot]+"] which is
        // ["+(droppedItem+1)+"]");
        boolean a = true;





        if(playerName == null)
            return;
        if(droppedItem == 4708) {
            replaceitem2(4708, 4860);
        }
        if(droppedItem == 4710) {
            replaceitem2(4710, 4866);
        }
        if(droppedItem == 4712) {
            replaceitem2(4712, 4872);
        }
        if(droppedItem == 4714) {
            replaceitem2(4714, 4878);
        }
        if(droppedItem == 4716) {
            replaceitem2(4716, 4884);
        }
        if(droppedItem == 4718) {
            replaceitem2(4718, 4890);
        }
        if(droppedItem == 4720) {
            replaceitem2(4720, 4896);
        }
        if(droppedItem == 4722) {
            replaceitem2(4722, 4902);
        }
        if(droppedItem == 4724) {
            replaceitem2(4724, 4908);
        }
        if(droppedItem == 4726) {
            replaceitem2(4726, 4914);
        }
        if(droppedItem == 4728) {
            replaceitem2(4728, 4920);
        }
        if(droppedItem == 4730) {
            replaceitem2(4730, 4926);
        }
        if(droppedItem == 4732) {
            replaceitem2(4732, 4932);
        }
        if(droppedItem == 4734) {
            replaceitem2(4734, 4938);
        }
        if(droppedItem == 4736) {
            replaceitem2(4736, 4944);
        }
        if(droppedItem == 4738) {
            replaceitem2(4738, 4950);
        }
        if(droppedItem == 4745) {
            replaceitem2(4745, 4956);
        }
        if(droppedItem == 4747) {
            replaceitem2(4747, 4962);
        }
        if(droppedItem == 4749) {
            replaceitem2(4749, 4968);
        }
        if(droppedItem == 4751) {
            replaceitem2(4751, 4974);
        }
        if(droppedItem == 4753) {
            replaceitem2(4753, 4980);
        }
        if(droppedItem == 4755) {
            replaceitem2(4755, 4986);
        }
        if(droppedItem == 4757) {
            replaceitem2(4757, 4992);
        }
        if(droppedItem == 4759) {
            replaceitem2(4759, 4998);
        }
        if(droppedItem == 4045 && !isInJail()) {
            deleteItem(4045, 1);
            dealDamage(15);
            hitDiff = 15;
            plrText = "Ouch!";
            plrTextUpdateRequired = true;
            updateRequired = true;
            hitUpdateRequired = true;
            setAnimation(827);
            return;
        }
        if ((playerItemsN[slot] != 0) && (droppedItem != -1)
                && (playerItems[slot] == droppedItem + 1)) {
            for (int element : noTrade) {
            }
            if(destroyItem(droppedItem)) {
                outStream.createFrameVarSizeWord(34);
                outStream.writeWord(14171);
                outStream.writeByte( 0);
                outStream.writeWord(droppedItem + 1);
                outStream.writeByte(255);
                outStream.writeDWord(1);
                outStream.endFrameVarSizeWord();
                sendFrame126("Are you sure you want to destroy this object?", 14174);
                sendFrame126("Yes.", 14175);
                sendFrame126("No.", 141756);
                sendFrame126(""+GetItemName(droppedItem), 14184);
                sendFrame126(getMessageA(droppedItem),14182);
                sendFrame126(getMessageB(droppedItem),14183);
                sendFrame164(14170);
                publicDroppendItem = droppedItem;
                return;
            }
            ItemHandler.addItem(playerItems[slot] - 1, absX, absY,
                                playerItemsN[slot], playerId, false);
            // createGroundItem(droppedItem, absX, absY, c);
            deleteItem(droppedItem, slot, playerItemsN[slot]);
            updateRequired = true;
            savegame(false);
        }
    }

    // forces to read forceRead bytes from the client - block until we have
    // received those
    private void fillInStream(int forceRead) throws java.io.IOException {
        inStream.currentOffset = 0;
        in.read(inStream.buffer, 0, forceRead);
        //in.readFully(inStream.buffer, 0, forceRead);//in.read(inStream.buffer, 0, forceRead);
    }

    public int findItem(int id, int[] items, int[] amounts) {
        for (int i = 0; i < playerItems.length; i++) {
            if (((items[i] - 1) == id) && (amounts[i] > 0)) {
                return i;
            }
        }
        return -1;
    }


    // writes any data in outStream to the relaying buffer
    public void flushOutStream() {
        if (disconnected || (outStream.currentOffset == 0)) {
            return;
        }

        synchronized (this) {
            int maxWritePtr = (readPtr + bufferSize - 2) % bufferSize;

            for (int i = 0; i < outStream.currentOffset; i++) {
                buffer[writePtr] = outStream.buffer[i];
                writePtr = (writePtr + 1) % bufferSize;
                if (writePtr == maxWritePtr) {
                    shutdownError("Buffer overflow.");
                    // outStream.currentOffset = 0;
                    disconnected = true;
                    return;
                }
            }
            outStream.currentOffset = 0;

            notify();
        }
    }

    public void frame1() {
        // cancels all player and npc emotes within area!
        outStream.createFrame(1);
        updateRequired = true;
        appearanceUpdateRequired = true;
    }


    public int freeBankSlots() {
        int freeS = 0;

        for (int i = 0; i < playerBankSize; i++) {
            if (bankItems[i] <= 0) {
                freeS++;
            }
        }
        return freeS;
    }

    public int freeSlots() {
        int freeS = 0;

        for (int element : playerItems) {
            if (element <= 0) {
                freeS++;
            }
        }
        return freeS;
    }


    public void fromBank(int itemID, int fromSlot, int amount) {
        if (!IsBanking) {
            closeInterface();
            return;
        }
        if (amount > 0) {
            if (bankItems[fromSlot] > 0) {
                if (!takeAsNote) {
                    if (Item.itemStackable[bankItems[fromSlot] - 1]) {
                        if (bankItemsN[fromSlot] > amount) {
                            if (addItem((bankItems[fromSlot] - 1), amount)) {
                                bankItemsN[fromSlot] -= amount;
                                resetBank();
                                resetItems(5064);
                            }
                        } else {
                            if (addItem((bankItems[fromSlot] - 1),
                                        bankItemsN[fromSlot])) {
                                bankItems[fromSlot] = 0;
                                bankItemsN[fromSlot] = 0;
                                resetBank();
                                resetItems(5064);
                            }
                        }
                    } else {
                        while (amount > 0) {
                            if (bankItemsN[fromSlot] > 0) {
                                if (addItem((bankItems[fromSlot] - 1), 1)) {
                                    bankItemsN[fromSlot] += -1;
                                    amount--;
                                } else {
                                    amount = 0;
                                }
                            } else {
                                amount = 0;
                            }
                        }
                        resetBank();
                        resetItems(5064);
                    }
                } else if (takeAsNote && Item.itemIsNote[bankItems[fromSlot]]) {
                    // if (Item.itemStackable[bankItems[fromSlot]+1])
                    // {
                    if (bankItemsN[fromSlot] > amount) {
                        if (addItem(bankItems[fromSlot], amount)) {
                            bankItemsN[fromSlot] -= amount;
                            resetBank();
                            resetItems(5064);
                        }
                    } else {
                        if (addItem(bankItems[fromSlot], bankItemsN[fromSlot])) {
                            bankItems[fromSlot] = 0;
                            bankItemsN[fromSlot] = 0;
                            resetBank();
                            resetItems(5064);
                        }
                    }
                } else {
                    sM("Item can't be drawn as note.");
                    if (Item.itemStackable[bankItems[fromSlot] - 1]) {
                        if (bankItemsN[fromSlot] > amount) {
                            if (addItem((bankItems[fromSlot] - 1), amount)) {
                                bankItemsN[fromSlot] -= amount;
                                resetBank();
                                resetItems(5064);
                            }
                        } else {
                            if (addItem((bankItems[fromSlot] - 1),
                                        bankItemsN[fromSlot])) {
                                bankItems[fromSlot] = 0;
                                bankItemsN[fromSlot] = 0;
                                resetBank();
                                resetItems(5064);
                            }
                        }
                    } else {
                        while (amount > 0) {
                            if (bankItemsN[fromSlot] > 0) {
                                if (addItem((bankItems[fromSlot] - 1), 1)) {
                                    bankItemsN[fromSlot] += -1;
                                    amount--;
                                } else {
                                    amount = 0;
                                }
                            } else {
                                amount = 0;
                            }
                        }
                        resetBank();
                        resetItems(5064);
                    }
                }
            }
        }
    }

    public boolean fromTrade(int itemID, int fromSlot, int amount) {
        if (System.currentTimeMillis() - lastButton > 400) {
            lastButton = System.currentTimeMillis();
        } else {
            return false;
        }
        try {
            client other = getClient(trade_reqId);
            if (!inTrade || !validClient(trade_reqId) || !canOffer) {
                declineTrade();
                return false;
            }
            if (!Item.itemStackable[itemID] && (amount > 1)) {
                for (int a = 1; a <= amount; a++) {
                    int slot = findItem(itemID, playerItems, playerItemsN);
                    if (slot >= 0) {
                        fromTrade(itemID, 0, 1);
                    }
                }
            }
            boolean found = false;
            for (GameItem item : offeredItems) {
                if (item.id == itemID) {
                    if (!item.stackable) {
                        offeredItems.remove(item);
                        found = true;
                    } else {
                        if (item.amount > amount) {
                            item.amount -= amount;
                            found = true;
                        } else {
                            amount = item.amount;
                            found = true;
                            offeredItems.remove(item);
                        }
                    }
                    break;
                }
            }
            if (found)
                addItem(itemID, amount);
            tradeConfirmed = false;
            other.tradeConfirmed = false;
            resetItems(3322);
            resetTItems(3415);
            other.resetOTItems(3416);
            sendFrame126("", 3431);
            other.sendFrame126("", 3431);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public void reportAbuse(String abuser, int rule, int muted) {
        if (playerRights == 0) {
            writeLog("player: " + abuser + "| rule: " + rule + "| muted: "
                     + (muted > 0 ? "yes" : "no"), "reports");
            sM("Your Report Has been saved and will be looken over soon.");

        } else {
            boolean online = false;
            // int duration = misc.times[rule];
            for (int i = 0; i < handler.players.length; i++) {
                client other = getClient(i);
                if (!validClient(i))
                    continue;
                if (other.playerName.equalsIgnoreCase(abuser)) {
                    online = true;

                    writeLog(playerName, "mutes");
                    disconnected = true;
                    break;
                }
            }

            if (online) {
                sM("Player has been kicked.");
            } else {
                sM("Player was not online.");
            }

        }
    }
    public void fsBar(int id1, int id2, int id3) {
        outStream.createFrame(70);
        outStream.writeWord(id1);
        outStream.writeWordBigEndian(id2);
        outStream.writeWordBigEndian(id3);
    }

    public void GetBonus() {
        for (int i = 0; i < playerEquipment.length; i++) {
            if (playerEquipment[i] > -1) {
                for (int j = 0; j < 9999; j++) {
                    if (server.itemHandler.ItemList[j] != null) {
                        if (server.itemHandler.ItemList[j].itemId == playerEquipment[i]) {
                            for (int k = 0; k < playerBonus.length; k++) {
                                playerBonus[k] += server.itemHandler.ItemList[j].Bonuses[k];
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void WriteBonus() {
        int offset = 0;
        String send = "";
        for (int i = 0; i < playerBonus.length; i++) {
            if (playerBonus[i] >= 0) {
                send = BonusName[i]+": +"+playerBonus[i];
            } else {
                send = BonusName[i]+": -"+java.lang.Math.abs(playerBonus[i]);
            }

            if (i == 10) {
                offset = 1;
            }
            sendFrame126(send, (1675+i+offset));
        }
        CalculateMaxHit();
        /*for (int i = 4000; i <= 7000; i++) {
        	sendFrame126("T"+i, i);
        	println_debug("Sended: Test"+i);
        }*///USED FOR TESTING INTERFACE NUMBERS !
    }


    public client getClient(int index) {
        return ((client) handler.players[index]);
    }

    /* ITEMS */

    public String getItemName(int ItemID) {
        for (int i = 0; i < server.itemHandler.MaxListedItems; i++) {
            if (server.itemHandler.ItemList[i] != null) {
                if (server.itemHandler.ItemList[i].itemId == ItemID) {
                    return server.itemHandler.ItemList[i].itemName;
                }
            }
        }
        return "!! NOT EXISTING ITEM !!! - ID:" + ItemID;
    }

    public double GetItemShopValue(int ItemID, int Type, int fromSlot) {
        double ShopValue = 1;
        double Overstock = 0;
        double TotPrice = 0;

        for (int i = 0; i < server.itemHandler.MaxListedItems; i++) {
            if (server.itemHandler.ItemList[i] != null) {
                if (server.itemHandler.ItemList[i].itemId == ItemID) {
                    ShopValue = server.itemHandler.ItemList[i].ShopValue;
                }
            }
        }
        /*
         * Overstock = server.shopHandler.ShopItemsN[MyShopID][fromSlot] -
         * server.shopHandler.ShopItemsSN[MyShopID][fromSlot];
         */
        TotPrice = (ShopValue * 1); // Calculates price for 1 item, in
        // db is stored for 0 items (strange
        // but true)
        /*
         * if (Overstock > 0) { // more then default -> cheaper TotPrice -=
         * ((ShopValue / 100) * (1.26875 * Overstock)); } else if (Overstock <
         * 0) { // less then default -> exspensive TotPrice += ((ShopValue /
         * 100) * (1.26875 * Overstock)); }
         */
        if (server.shopHandler.ShopBModifier[MyShopID] == 1) {
            TotPrice *= 1; // 25% more expensive (general stores only)
            if (Type == 1) {
                TotPrice *= 0.4; // general store buys item at 40% of its own
                // selling value
            }
        } else if (Type == 1) {
            TotPrice *= 0.6; // other stores buy item at 60% of their own
            // selling value
        }
        return TotPrice;
    }
    public double GetItemValue(int ItemID) {
        double ShopValue = 1;
        double Overstock = 0;
        double TotPrice = 0;

        for (int i = 0; i < server.itemHandler.MaxListedItems; i++) {
            if (server.itemHandler.ItemList[i] != null) {
                if (server.itemHandler.ItemList[i].itemId == ItemID) {
                    ShopValue = server.itemHandler.ItemList[i].ShopValue;
                }
            }
        }
        TotPrice = (ShopValue * 1); // Calculates price for 1 item, in
        return TotPrice;
    }
    public int getItemSlot(int itemID) {
        for (int slot = 0; slot < playerItems.length; slot++) {
            if (playerItems[slot] == (itemID + 1)) {
                return slot;
            }
        }
        return -1;
    }

    public int GetItemSlot(int ItemID) {
        for (int i = 0; i < playerItems.length; i++) {
            if ((playerItems[i] - 1) == ItemID) {
                return i;
            }
        }
        return -1;
    }

    public int getLevelForXP(int exp) {
        int points = 0;
        int output = 0;
        if (exp > 13034430)
            return 99;
        for (int lvl = 1; lvl <= 99; lvl++) {
            points += Math.floor((double) lvl + 300.0
                                 * Math.pow(2.0, (double) lvl / 7.0));
            output = (int) Math.floor(points / 4);
            if (output >= exp) {
                return lvl;
            }
        }
        return 0;
    }

    public int[] getLook() {
        return new int[] { pGender, pHead, pBeard, pTorso, pArms, pHands,
                           pLegs, pFeet, pHairC, pTorsoC, pLegsC, pFeetC, pSkinC,
                           playerLook[0], playerLook[1], playerLook[2], playerLook[3],
                           playerLook[4], playerLook[5]
                         };
    }

    public int GetNPCID(int coordX, int coordY) {
        for (int i = 0; i < server.npcHandler.maxNPCSpawns; i++) {
            if (server.npcHandler.npcs[i] != null) {
                if ((server.npcHandler.npcs[i].absX == coordX)
                        && (server.npcHandler.npcs[i].absY == coordY)) {
                    return server.npcHandler.npcs[i].npcType;
                }
            }
        }
        return 1;
    }

    public String GetNpcName(int NpcID) {
        for (int i = 0; i < server.npcHandler.maxListedNPCs; i++) {
            if (server.npcHandler.NpcList[i] != null) {
                if (server.npcHandler.NpcList[i].npcId == NpcID) {
                    return server.npcHandler.NpcList[i].npcName;
                }
            }
        }
        return "!! NOT EXISTING NPC !!! - ID:" + NpcID;
    }

    /* OBJECTS */

    public int GetUnnotedItem(int ItemID) {
        int NewID = 0;
        String NotedName = "";

        for (int i = 0; i < server.itemHandler.MaxListedItems; i++) {
            if (server.itemHandler.ItemList[i] != null) {
                if (server.itemHandler.ItemList[i].itemId == ItemID) {
                    NotedName = server.itemHandler.ItemList[i].itemName;
                }
            }
        }
        for (int i = 0; i < server.itemHandler.MaxListedItems; i++) {
            if (server.itemHandler.ItemList[i] != null) {
                if (server.itemHandler.ItemList[i].itemName == NotedName) {
                    if (server.itemHandler.ItemList[i].itemDescription
                            .startsWith("Swap this note at any bank for a") == false) {
                        NewID = server.itemHandler.ItemList[i].itemId;
                        break;
                    }
                }
            }
        }
        return NewID;
    }

    public int GetWorld(int PlayerID) {
        String Server = PlayerHandler.players[PlayerID].playerServer;

        if (Server.equals("deltascape.no-ip.info") || Server.equals("localhost")) {
            return 1;
        } else if (Server.equals("deltascape.servequake.com")) {
            return 2;
        } else {
            println_debug("Invalid Server: " + Server);
            return 1; // 0; friendlist fix-bakatool
        }
    }

    public int GetXItemsInBag(int ItemID) {
        int ItemCount = 0;

        for (int element : playerItems) {
            if ((element - 1) == ItemID) {
                ItemCount++;
            }
        }
        return ItemCount;
    }

    public int getXPForLevel(int level) {
        int points = 0;
        int output = 0;

        for (int lvl = 1; lvl <= level; lvl++) {
            points += Math.floor((double) lvl + 300.0
                                 * Math.pow(2.0, (double) lvl / 7.0));
            if (lvl >= level) {
                return output;
            }
            output = (int) Math.floor(points / 4);
        }
        return 0;
    }

    public boolean GoodDistance(int objectX, int objectY, int playerX,
                                int playerY, int distance) {
        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j <= distance; j++) {
                if (((objectX + i) == playerX)
                        && (((objectY + j) == playerY)
                            || ((objectY - j) == playerY) || (objectY == playerY))) {
                    return true;
                } else if (((objectX - i) == playerX)
                           && (((objectY + j) == playerY)
                               || ((objectY - j) == playerY) || (objectY == playerY))) {
                    return true;
                } else if ((objectX == playerX)
                           && (((objectY + j) == playerY)
                               || ((objectY - j) == playerY) || (objectY == playerY))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean GoodDistance2(int objectX, int objectY, int playerX,
                                 int playerY, int distance) {
        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j <= distance; j++) {
                if ((objectX == playerX)
                        && (((objectY + j) == playerY)
                            || ((objectY - j) == playerY) || (objectY == playerY))) {
                    return true;
                } else if ((objectY == playerY)
                           && (((objectX + j) == playerX)
                               || ((objectX - j) == playerX) || (objectX == playerX))) {
                    return true;
                }
            }
        }
        return false;
    }

    // upon connection of a new client all the info has to be sent to client
    // prior to starting the regular communication
    public void initialize() {
        // first packet sent
        server.setConfig.initializeClientConfiguration(playerId);
        if(splitChat == 1) {
            setClientConfig(287, 1);
        }
        if(autoRetaliate == 0) {
            setClientConfig(172, 1);
        }
        setClientConfig(43, FightType-1);
        setClientConfig(166, brightness);
        outStream.createFrame(249);
        outStream.writeByteA(playerIsMember); // 1 for members, zero for free
        outStream.writeWordBigEndianA(playerId);
        // here is the place for seting up the UI, stats, etc...
        setChatOptions(0, 0, 0);
        for (int i = 0; i < 25; i++) {
            setSkillLevel(i, playerLevel[i], playerXP[i]);
        }
        refreshSkills();

        outStream.createFrame(107); // resets something in the client

        setSidebarInterface(0, 2423); // attack tab
        setSidebarInterface(1, 3917); // skills tab
        setSidebarInterface(2, 638); // quest tab
        setSidebarInterface(3, 3213); // backpack tab
        setSidebarInterface(4, 1644); // items wearing tab
        setSidebarInterface(5, 5608); // pray tab
        if (playerAncientMagics == 0) {
            setSidebarInterface(6, 1151);
            playerAncientMagics = 0;
        }
        if (playerAncientMagics == 1) {
            setSidebarInterface(6, 12855);
            playerAncientMagics = 1;
        }
        if (playerAncientMagics == 2) {
            setSidebarInterface(6, 18787);
            playerAncientMagics = 2;
        }
        setSidebarInterface(7, -1); // clan chat
        setSidebarInterface(8, 5065); // friend
        setSidebarInterface(9, 5715); // ignore
        setSidebarInterface(10, 2449); // logout tab
        setSidebarInterface(11, 4445); // wrench tab
        setSidebarInterface(12, 147); // run tab
        setSidebarInterface(13, -1); // harp tab
        // add player commands...
        outStream.createFrameVarSize(104);
        outStream.writeByteC(3);		// command slot (does it matter which one?)
        outStream.writeByteA(1);		// 0 or 1; 1 if command should be placed on top in context menu
        outStream.writeString("Attack");
        outStream.endFrameVarSize();

        outStream.createFrameVarSize(104);
        outStream.writeByteC(4); // command slot (does it matter which one?)
        outStream.writeByteA(0); // 0 or 1; 0 if command should be placed on top in context menu
        outStream.writeString("Follow");
        outStream.endFrameVarSize();

        outStream.createFrameVarSize(104);
        outStream.writeByteC(5); // command slot (does it matter which one?)
        outStream.writeByteA(0); // 0 or 1; 0 if command should be placed on top in context menu
        outStream.writeString("Trade with");
        outStream.endFrameVarSize();


        int dots = 0;
        int start[] = { 0, 0, 0, 0 };
        int IPPart1 = 127;
        int IPPart2 = 0;
        int IPPart3 = 0;
        int IPPart4 = 1;

        if (playerLastConnect.length() < 7) {
            playerLastConnect = connectedFrom;
        }
        if (playerLastConnect.length() <= 15) {
            for (int j = 0; j <= playerLastConnect.length(); j++) {
                if ((j + 1) <= playerLastConnect.length()) {
                    if (playerLastConnect.substring(j, (j + 1)).equals(".")) {
                        start[dots] = j;
                        dots++;
                    }
                    if (dots == 3) {
                        break;
                    }
                }
            }
            if (dots == 3) {
                IPPart1 = Integer.parseInt(playerLastConnect.substring(0,
                                           start[0]));
                IPPart2 = Integer.parseInt(playerLastConnect.substring(
                                               (start[0] + 1), start[1]));
                IPPart3 = Integer.parseInt(playerLastConnect.substring(
                                               (start[1] + 1), start[2]));
                IPPart4 = Integer.parseInt(playerLastConnect
                                           .substring((start[2] + 1)));
            }
        } else {
            for (int j = 0; j <= playerLastConnect.length(); j++) {
                if ((j + 1) <= playerLastConnect.length()) {
                    if (playerLastConnect.substring(j, (j + 1)).equals("-")) {
                        start[dots] = j;
                        dots++;
                    }
                    if (dots == 4) {
                        break;
                    }
                }
            }
            if (dots == 4) {
                try {
                    IPPart1 = Integer.parseInt(playerLastConnect.substring(0,
                                               start[0]));
                    IPPart2 = Integer.parseInt(playerLastConnect.substring(
                                                   (start[0] + 1), start[1]));
                    IPPart3 = Integer.parseInt(playerLastConnect.substring(
                                                   (start[1] + 1), start[2]));
                    IPPart4 = Integer.parseInt(playerLastConnect.substring(
                                                   (start[2] + 1), (start[3])));
                } catch (NumberFormatException e) {
                }
            }
        }
        if(playerEquipment[playerWeapon] == 5698 || playerEquipment[playerWeapon] == 1305) {
            playerEquipment[playerWeapon] = -1;
            playerEquipmentN[playerWeapon] = 0;
            setEquipment(-1, 0,playerWeapon);
        }
        if(playerEquipment[playerWeapon] == 4587) {
            playerEquipment[playerWeapon] = -1;
            playerEquipmentN[playerWeapon] = 0;
            setEquipment(-1, 0,playerWeapon);
        }
        if(playerEquipment[playerHat] == 3753) {
            playerEquipment[playerHat] = -1;
            playerEquipmentN[playerHat] = 0;
            setEquipment(-1, 0,playerHat);
        }

        specAttack();
        l33thax(12323);
        l33thax(7574);
        l33thax(7599);
        l33thax(7549);
        l33thax(8493);
        l33thax(7499);


        sM("Welcome to Project Rs.");
        checkDupe();
//Starter


        server.special.loginSpec(this, playerEquipment[playerWeapon]);
        if(absX >= 2997 && absX <= 2998 && absY >= 3917 && absY <= 3917) {
            toX = 2998;
            toY = 3931;
        }

        sendFrame126("Prayer: "+playerLevel[5]+"/"+getLevelForXP(playerXP[5])+"", 687);
        if (checkLog("mutes", playerName)) {

            muted = true;
            sM("You Have been muted by a moderator and will be unmuted in a while.");
        }
        if (checkLog("mutes2", connectedFrom)) {
            muted = true;
            sM("You are IP muted.");
        }

        for (int a = 0; a < lastMessage.length; a++) {
            lastMessage[a] = "";
        }
        if (playerMessages > 0)
            sM("You have "
               + playerMessages
               + " new messages.  Check your inbox at Devolution.com to view them.");
        // FACE: 0= WEST | -1 = NORTH | -2 = EAST | -3 = SOUTH
        if (lookNeeded) {
            showInterface(3559);
        } else
            sendFrame126("" + playerLevel[0] + "", 4004);
        sendFrame126("" + getLevelForXP(playerXP[0]) + "", 4005);
        sendFrame126("" + playerLevel[1] + "", 4008);
        sendFrame126("" + getLevelForXP(playerXP[1]) + "", 4009);
        sendFrame126("" + playerLevel[2] + "", 4006);
        sendFrame126("" + getLevelForXP(playerXP[2]) + "", 4007);
        sendFrame126("" + playerLevel[3] + "", 4016);
        sendFrame126("" + getLevelForXP(playerXP[3]) + "", 4017);
        sendFrame126("" + playerLevel[4] + "", 4010);
        sendFrame126("" + getLevelForXP(playerXP[4]) + "", 4011);
        sendFrame126("" + playerLevel[5] + "", 4012);
        sendFrame126("" + getLevelForXP(playerXP[5]) + "", 4013);
        sendFrame126("" + playerLevel[6] + "", 4014);
        sendFrame126("" + getLevelForXP(playerXP[6]) + "", 4015);
        sendFrame126("" + playerLevel[7] + "", 4034);
        sendFrame126("" + getLevelForXP(playerXP[7]) + "", 4035);
        sendFrame126("" + playerLevel[8] + "", 4038);
        sendFrame126("" + getLevelForXP(playerXP[8]) + "", 4039);
        sendFrame126("" + playerLevel[9] + "", 4026);
        sendFrame126("" + getLevelForXP(playerXP[9]) + "", 4027);
        sendFrame126("" + playerLevel[10] + "", 4032);
        sendFrame126("" + getLevelForXP(playerXP[10]) + "", 4033);
        sendFrame126("" + playerLevel[11] + "", 4036);
        sendFrame126("" + getLevelForXP(playerXP[11]) + "", 4037);
        sendFrame126("" + playerLevel[12] + "", 4024);
        sendFrame126("" + getLevelForXP(playerXP[12]) + "", 4025);
        sendFrame126("" + playerLevel[13] + "", 4030);
        sendFrame126("" + getLevelForXP(playerXP[13]) + "", 4031);
        sendFrame126("" + playerLevel[14] + "", 4028);
        sendFrame126("" + getLevelForXP(playerXP[14]) + "", 4029);
        sendFrame126("" + playerLevel[15] + "", 4020);
        sendFrame126("" + getLevelForXP(playerXP[15]) + "", 4021);
        sendFrame126("" + playerLevel[16], 4018);
        sendFrame126("" + getLevelForXP(playerXP[16]), 4019);
        sendFrame126("" + playerLevel[17], 4022);
        sendFrame126("" + getLevelForXP(playerXP[17]), 4023);
        sendFrame126("" + playerLevel[20], 4152);
        sendFrame126("" + getLevelForXP(playerXP[20]), 4153);
        if (playerPass.equals("")) {
            sM("No password set! Use ::pass PASSWORD to set ur password.");
        }

        sendFrame126("", 6067);
        sendFrame126("", 6071);
        SendWeapon(-1, "Unarmed");

        handler.updatePlayer(this, outStream);
        handler.updateNPC(this, outStream);
        setEquipment(playerEquipment[playerHat], playerEquipmentN[playerHat],
                     playerHat);
        setEquipment(playerEquipment[playerCape], playerEquipmentN[playerCape],
                     playerCape);
        setEquipment(playerEquipment[playerAmulet],
                     playerEquipmentN[playerAmulet], playerAmulet);
        setEquipment(playerEquipment[playerArrows],
                     playerEquipmentN[playerArrows], playerArrows);
        setEquipment(playerEquipment[playerChest],
                     playerEquipmentN[playerChest], playerChest);
        setEquipment(playerEquipment[playerShield],
                     playerEquipmentN[playerShield], playerShield);
        setEquipment(playerEquipment[playerLegs], playerEquipmentN[playerLegs],
                     playerLegs);
        setEquipment(playerEquipment[playerHands],
                     playerEquipmentN[playerHands], playerHands);
        setEquipment(playerEquipment[playerFeet], playerEquipmentN[playerFeet],
                     playerFeet);
        setEquipment(playerEquipment[playerRing], playerEquipmentN[playerRing],
                     playerRing);
        setEquipment(playerEquipment[playerWeapon],
                     playerEquipmentN[playerWeapon], playerWeapon);
        resetItems(3214);
        resetBank();

        ResetBonus();
        GetBonus();
        WriteBonus();
        //replaceDoors();

        pmstatus(2);
        boolean pmloaded = false;

        for (long element : friends) {
            if (element != 0) {
                for (int i2 = 1; i2 < handler.maxPlayers; i2++) {
                    if ((handler.players[i2] != null)
                            && handler.players[i2].isActive
                            && (misc
                                .playerNameToInt64(handler.players[i2].playerName) == element)) {
                        if ((playerRights >= 2)
                                || (handler.players[i2].Privatechat == 0)
                                || ((handler.players[i2].Privatechat == 1) && handler.players[i2]
                                    .isinpm(misc
                                            .playerNameToInt64(playerName)))) {
                            loadpm(element, GetWorld(i2));
                            pmloaded = true;
                        }
                        break;
                    }
                }
                if (!pmloaded) {
                    loadpm(element, 0);
                }
                pmloaded = false;
            }
        }
        for (int i1 = 1; i1 < handler.maxPlayers; i1++) {
            if ((handler.players[i1] != null)
                    && (handler.players[i1].isActive == true)) {
                handler.players[i1].pmupdate(playerId, GetWorld(playerId));
            }
        }
        server.textHandler.startText(playerId);
        // main
        setInterfaceWalkable(6673);
        playerLastConnect = connectedFrom;
        updateRequired = true;
        appearanceUpdateRequired = true;
    }

    public boolean inRange(int x, int y) {
        if (localId > 0)
            return false;
        if ((Math.abs(absX - x) < 4) && (Math.abs(absY - y) < 4)) {
            return true;
        }
        return false;
    }
    public boolean isinpm(long l) {
        for (long element : friends) {
            if (element != 0) {
                if (l == element) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInWilderness(int coordX, int coordY, int Type) {
        if (Type == 1) {
            if ((coordY >= 3523) && (coordY <= 3967) && (coordX <= 3392)
                    && (coordX >= 2942) || absX >= 3220 && absX <= 3299 && absY >= 3520 && absY <=3548 || absX >= 2250 && absX <= 2296 && absY >= 4676 && absY <=4715) {
                return true;
            }
        } else if (Type == 2) {
            if ((coordY >= 3512) && (coordY <= 3967) && (coordX <= 3392)
                    && (coordX >= 2942)) {
                return true;
            }
        }
        return false;
    }

    public boolean IsItemInBag(int ItemID) {
        for (int element : playerItems) {
            if ((element - 1) == ItemID) {
                return true;
            }
        }
        return false;
    }

    public int itemAmount(int itemID) {
        int tempAmount = 0;

        for (int i = 0; i < playerItems.length; i++) {
            if (playerItems[i] == itemID) {
                tempAmount += playerItemsN[i];
            }
        }
        return tempAmount;
    }

    public int itemType(int item) {
        for (int element : Item.capes) {
            if (item == element) {
                return playerCape;
            }
        }
        for (int element : Item.hats) {
            if (item == element) {
                return playerHat;
            }
        }
        for (int element : Item.boots) {
            if (item == element) {
                return playerFeet;
            }
        }
        for (int element : Item.gloves) {
            if (item == element) {
                return playerHands;
            }
        }
        for (int element : Item.shields) {
            if (item == element) {
                return playerShield;
            }
        }
        for (int element : Item.amulets) {
            if (item == element) {
                return playerAmulet;
            }
        }
        for (int element : Item.arrows) {
            if (item == element) {
                return playerArrows;
            }
        }
        for (int element : Item.rings) {
            if (item == element) {
                return playerRing;
            }
        }
        for (int element : Item.body) {
            if (item == element) {
                return playerChest;
            }
        }
        for (int element : Item.legs) {
            if (item == element) {
                return playerLegs;
            }
        }

        // Default
        return playerWeapon;
    }
    public void l33thax(int id) {
        outStream.createFrame(171);
        outStream.writeByte(0);
        outStream.writeWord(id);
        flushOutStream();
    }


    public int loadgame(String playerName, String playerPass) {
        for (Integer bUid : server.bannedUid) {
            if (uid == bUid.intValue()) {
                return 4;
            }
        }

        long start = System.currentTimeMillis();
        String line = "";
        String token = "";
        String token2 = "";
        String[] token3 = new String[3];
        boolean EndOfFile = false;
        int ReadMode = 0;
        BufferedReader characterfile = null;
        boolean charFileFound = false;
        int[] playerLooks = new int[19];

        try {
            characterfile = new BufferedReader(new FileReader("./CharData/"
                                               + playerName + ".txt"));
            charFileFound = true;
        } catch (FileNotFoundException fileex1) {
        }
        if (charFileFound == false) {
            misc.println(playerName + ": character file not found.");
            return 0;
        }

        try {
            line = characterfile.readLine();
        } catch (IOException ioexception) {
            misc.println(playerName + ": error loading file.");
            return 3;
        }
        while ((EndOfFile == false) && (line != null)) {
            line = line.trim();
            int spot = line.indexOf("=");
            if (spot > -1) {
                token = line.substring(0, spot);
                token = token.trim();
                token2 = line.substring(spot + 1);
                token2 = token2.trim();
                token3 = token2.split("\t");
                switch (ReadMode) {
                case 1:
                    if (token.equals("character-username")) {
                        if (playerName.equalsIgnoreCase(token2)) {
                        } else {
                            saveNeeded = false;
                            validClient = false;
                            return 3;
                        }
                    } else if (token.equals("character-password")) {
                        if (playerPass.equalsIgnoreCase(token2)) {
                        } else {
                            saveNeeded = false;
                            validClient = false;
                            return 3;
                        }
                    }
                    break;
                case 2:
                    if (token.equals("character-height")) {
                        heightLevel = Integer.parseInt(token2);
                    } else if (token.equals("character-posx")) {
                        toX = Integer.parseInt(token2) == -1 ? 2999
                              : Integer.parseInt(token2);
                    } else if (token.equals("character-posy")) {
                        toY = Integer.parseInt(token2) == -1 ? 3377
                              : Integer.parseInt(token2);
                    } else if (token.equals("character-rights")) {
                        playerRights = Integer.parseInt(token2);
                    } else if (token.equals("character-lastconnection")) {
                        playerLastConnect = token2;
                    } else if (token.equals("character-special")) {
                        specialAmount = Integer.parseInt(token2);
                    } else if (token.equals("character-tz")) {
                        TzWave = Integer.parseInt(token2);
                    } else if (token.equals("character-starter")) {
                        starter = Integer.parseInt(token2);
                    } else if (token.equals("character-pouch1")) {
                        smallPouch = Integer.parseInt(token2);
                    } else if (token.equals("character-pouch2")) {
                        mediumPouch = Integer.parseInt(token2);
                    } else if (token.equals("character-pouch3")) {
                        largePouch = Integer.parseInt(token2);
                    } else if (token.equals("character-pouch4")) {
                        giantPouch = Integer.parseInt(token2);
                    } else if (token.equals("character-energy")) {
                        playerEnergy = Integer.parseInt(token2);

                    } else if (token.equals("character-brightness")) {
                        brightness = Integer.parseInt(token2);
                    } else if (token.equals("character-fighttype")) {
                        FightType = Integer.parseInt(token2);
                    } else if (token.equals("character-skill")) {
                        SkillID = Integer.parseInt(token2);
                    } else if (token.equals("character-chat")) {
                        splitChat = Integer.parseInt(token2);
                    } else if (token.equals("character-ancients")) {
                        playerAncientMagics = Integer.parseInt(token2);
                    } else if (token.equals("character-pin")) {
                        bankPin = Integer.parseInt(token2);
                    } else if (token.equals("character-saradomin")) {
                        saraKills = Integer.parseInt(token2);
                    } else if (token.equals("character-retaliate")) {
                        autoRetaliate = Integer.parseInt(token2);
                    } else if (token.equals("character-action")) {
                        action = Integer.parseInt(token2);
                    } else if (token.equals("character-pcpoints")) {
                        pcPoints = Integer.parseInt(token2);
                    } else if (token.equals("character-assault")) {
                        assaultKills = Integer.parseInt(token2);
                    } else if (token.equals("character-donator")) {
                        donator = Integer.parseInt(token2);
                    } else if (token.equals("character-bow")) {
                        arrowsLeft = Integer.parseInt(token2);
                    } else if (token.equals("character-shield")) {
                        shieldLeft = Integer.parseInt(token2);
                    }
                    break;
                case 3:
                    if (token.equals("character-equip")) {
                        playerEquipment[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[1]);
                        playerEquipmentN[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[2]);
                    }
                    break;
                case 4:
                    if (token.equals("character-look")) {
                        playerLooks[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[1]);
                    }
                    break;
                case 5:
                    if (token.equals("character-skill")) {
                        playerLevel[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[1]);
                        playerXP[Integer.parseInt(token3[0])] = Integer
                                                                .parseInt(token3[2]);

                        int level = 0;
                        level = playerLevel[Integer.parseInt(token3[0])];
                        playerLevel[Integer.parseInt(token3[0])] = level;
                        setSkillLevel(Integer.parseInt(token3[0]), level,
                                      playerXP[Integer.parseInt(token3[0])]);
                        if (Integer.parseInt(token3[0]) == 3) {
                            currentHealth = level;
                            maxHealth = level;
                        }
                    }
                    break;



                case 6:
                    if (token.equals("character-item")) {
                        playerItems[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[1]);
                        playerItemsN[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[2]);
                    }
                    break;
                case 7:
                    if (token.equals("character-bank")) {
                        bankItems[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[1]);
                        bankItemsN[Integer.parseInt(token3[0])] = Integer
                                .parseInt(token3[2]);
                    }
                    break;
                case 8:
                    if (token.equals("character-friend")) {
                        friends[Integer.parseInt(token3[0])] = Long
                                                               .parseLong(token3[1]);
                    }
                    break;
                case 9:
                    if (token.equals("character-ignore")) {
                        ignores[Integer.parseInt(token3[0])] = Long
                                                               .parseLong(token3[1]);
                    }
                    break;
                }
            } else {
                if (line.equals("[ACCOUNT]"))
                    ReadMode = 1;
                else if (line.equals("[CHARACTER]"))
                    ReadMode = 2;
                else if (line.equals("[EQUIPMENT]"))
                    ReadMode = 3;
                else if (line.equals("[LOOK]"))
                    ReadMode = 4;
                else if (line.equals("[SKILLS]"))
                    ReadMode = 5;
                else if (line.equals("[ITEMS]"))
                    ReadMode = 6;
                else if (line.equals("[BANK]"))
                    ReadMode = 7;
                else if (line.equals("[FRIENDS]"))
                    ReadMode = 8;
                else if (line.equals("[IGNORES]"))
                    ReadMode = 9;
                else if (line.equals("[EOF]")) {
                    // end of file now do whatever you set.
                    try {
                        characterfile.close();
                    } catch (IOException ioexception) {
                    }
                    setLook(playerLooks);
                    updateRequired = true;
                    appearanceUpdateRequired = true;
                    long end = System.currentTimeMillis() - start;
                    println("Character Loaded Sucessfully  ["
                            + (playerRights > 0 ? "Has powers"
                               : "Regular player") + ", lag: " + end
                            + " ms]");
                    return 0;
                }
            }

            // Exception occured @ some line
            try {
                line = characterfile.readLine();
            } catch (IOException ioexception1) {
                EndOfFile = true;
            }
        }

        try {
            characterfile.close();
        } catch (IOException ioexception) {
        }
        println("Failed to load player: " + playerName);
        return 13;
    }

    public void loadpm(long name, int world) {
        if (world != 0) {
            world += 9;
        } else if (world == 0) {
            world += 1;
        }
        outStream.createFrame(50);
        outStream.writeQWord(name);
        outStream.writeByte(world);
    }


    public void logout() {

        savegame(true);
        outStream.createFrame(109);
        //logoutButton = true;
    }
    public int maxRangeHit()
    {
        double d = 0.0D;
        double d1 = playerLevel[playerRanged];
        d += 1.399D + d1 * 0.00125D;
        d += d1 * 0.11D;
        client AttackingOn2 = (client) server.playerHandler.players[AttackingOn];
        if (AttackingOn2 != null) {
            if(hasCrystalBow())
            {
                d *= 1.5D;
            } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 882 || playerEquipment[playerArrows] == 883))
            {
                d *= 1.042D;
            } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 884 || playerEquipment[playerArrows] == 885))
            {
                d *= 1.044D;
            } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 886 || playerEquipment[playerArrows] == 887))
            {
                d *= 1.1339999999999999D;
            } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 888 || playerEquipment[playerArrows] == 889))
            {
                d *= 1.2D;
            } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 890 || playerEquipment[playerArrows] == 891))
            {
                d *= 1.3500000000000001D;
            } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 892 || playerEquipment[playerArrows] == 893))
            {
                d *= 1.6000000000000001D;
            } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 4740))
            {
                d *= 1.95D;
            } else if(!hasCrystalBow() && (playerEquipment[playerWeapon] == 837))
            {
                d *= 1.55D;
            } else if(playerEquipment[playerWeapon] == 4827)
            {
                d *= 1.95D;
            } else if(playerEquipment[playerWeapon] == 6522)
            {
                d *= 1.55D;
            } else if(RangePray == 5)
            {
                d += d1 * 0.021999999999999999D;
            }
            if(specOn)
            {
                if(playerEquipment[playerWeapon] == 861)
                {
                    d *= 1.05D;
                } else if(playerEquipment[playerWeapon] == 859)
                {
                    d /= 0.94999999999999996D;
                } else if(playerEquipment[playerWeapon] == 4827)
                {
                    d *= 1.75D;
                }
            }
            if(FullVRange())
            {
                d += d * 0.20000000000000001D;
            }
            int hit = (int)Math.floor(d);
            int protrange = 0;
            int noHit = misc.random(2);
            if(AttackingOn2.ProtRange && noHit == 2) {
                hit /= 2;
            }
            if(AttackingOn2.ProtRange) {
                protrange = 100;
            }
            int aBonus = 0;
            int rand_att = misc.random(playerLevel[4]) + misc.random(playerBonus[4]);
            int rand_def = (int) (0.65 * misc.random(AttackingOn2.playerLevel[1])) + misc.random(protrange);
            int random_u = misc.random(playerBonus[4] + aBonus);
            int dBonus = 0;
            int random_def = misc.random(AttackingOn2.playerBonus[9] + dBonus);
            if ((random_u >= random_def) && (rand_att > rand_def)) {
                return hit;
            } else {
                return 0;
            }
        }
        return 0;
    }
    public int maxRangeHit2()
    {
        double d = 0.0D;
        double d1 = playerLevel[playerRanged];
        d += 1.399D + d1 * 0.00125D;
        d += d1 * 0.11D;
        if(hasCrystalBow())
        {
            d *= 1.5D;
        } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 882 || playerEquipment[playerArrows] == 883))
        {
            d *= 1.042D;
        } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 884 || playerEquipment[playerArrows] == 885))
        {
            d *= 1.044D;
        } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 886 || playerEquipment[playerArrows] == 887))
        {
            d *= 1.1339999999999999D;
        } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 888 || playerEquipment[playerArrows] == 889))
        {
            d *= 1.2D;
        } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 890 || playerEquipment[playerArrows] == 891))
        {
            d *= 1.3500000000000001D;
        } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 892 || playerEquipment[playerArrows] == 893))
        {
            d *= 1.6000000000000001D;
        } else if(!hasCrystalBow() && (playerEquipment[playerArrows] == 4740))
        {
            d *= 1.95D;
        } else if(!hasCrystalBow() && (playerEquipment[playerWeapon] == 837))
        {
            d *= 1.55D;
        } else if(playerEquipment[playerWeapon] == 4827)
        {
            d *= 1.95D;
        } else if(playerEquipment[playerWeapon] == 6522)
        {
            d *= 1.55D;
        } else if(RangePray == 5)
        {
            d += d1 * 0.021999999999999999D;
        }
        if(specOn)
        {
            if(playerEquipment[playerWeapon] == 861)
            {
                d *= 1.05D;
            } else if(playerEquipment[playerWeapon] == 859)
            {
                d /= 0.94999999999999996D;
            } else if(playerEquipment[playerWeapon] == 4827)
            {
                d *= 1.75D;
            }
        }
        if(FullVRange())
        {
            d += d * 0.20000000000000001D;
        }
        int hit = (int)Math.floor(d);
        return hit;
    }
    public int MICheckPickAxe() {
        int Hand;
        int Shield;
        int Bag;
        int PickAxe;

        Hand = playerEquipment[playerWeapon];
        Shield = playerEquipment[playerShield];
        PickAxe = 0;
        switch (Hand) {
        case 1265:
            // Bronze Pick Axe
            PickAxe = 1;
            break;

        case 1267:
            // Iron Pick Axe
            PickAxe = 2;
            break;

        case 1269:
            // Steel Pick Axe
            PickAxe = 3;
            break;

        case 1273:
            // Mithril Pick Axe
            PickAxe = 4;
            break;

        case 1271:
            // Adamant Pick Axe
            PickAxe = 5;
            break;

        case 1275:
            // Rune Pick Axe
            PickAxe = 6;
            break;
        }
        if (PickAxe > 0) {
            return PickAxe;
        }
        return 0;
    }

    /* MINING */
    public boolean mining() {
        int MIPickAxe = 0;
        int RndGems = 50;
        if (IsMining == true && false) {
            MIPickAxe = 1; // If Mining -> Go trough loop, passby
            // MICheckPickAxe to prevent originalweapon loss, 1
            // to tell you got pick axe, no function left for
            // MIPickAxe if mining, so 1 is enough.
        } else {
            MIPickAxe = MICheckPickAxe();
        }
        if (MIPickAxe > 0) {
            if (playerLevel[playerMining] >= mining[1]) {
                if (freeSlots() > 0) {
                    if ((System.currentTimeMillis() - lastAction >= 1000) && !IsMining) {
                        sM("You swing your pick axe at the rock.");
                        actionInterval = ((10 - MIPickAxe) * 1000);
                        lastAction = System.currentTimeMillis();
                        pEmote = 0x554;
                        IsMining = true;
                    }
                    if ((System.currentTimeMillis() - lastAction > actionInterval) && IsMining) {
                        if ((IsItemInBag(1706) == true)
                                || (IsItemInBag(1708) == true)
                                || (IsItemInBag(1710) == true)
                                || (IsItemInBag(1712) == true)) {
                            RndGems /= 2;
                        }
                        addSkillXP(mining[2], playerMining);
                        addItem(mining[4], 1);
                        sM("You manage to mine some ores.");
                        lastAction = System.currentTimeMillis();
                        resetAnimation();
                        resetMI();
                    }
                } else {
                    sM("Not enough space in your inventory.");
                    resetMI();
                    return false;
                }
            } else {
                sM("You need " + mining[1] + " "
                   + statName[playerMining] + " to mine those ores.");
                resetMI();
                return false;
            }
        } else {
            sM("You need a pick axe to mine ores.");
            resetMI();
            return false;
        }
        return true;
    }
    public void moveItems(int from, int to, int moveWindow) {
        if (moveWindow == 3724) {
            int tempI;
            int tempN;

            tempI = playerItems[from];
            tempN = playerItemsN[from];

            playerItems[from] = playerItems[to];
            playerItemsN[from] = playerItemsN[to];
            playerItems[to] = tempI;
            playerItemsN[to] = tempN;
        }

        if ((moveWindow == 34453) && (from >= 0) && (to >= 0)
                && (from < playerBankSize) && (to < playerBankSize)) {
            int tempI;
            int tempN;

            tempI = bankItems[from];
            tempN = bankItemsN[from];

            bankItems[from] = bankItems[to];
            bankItemsN[from] = bankItemsN[to];
            bankItems[to] = tempI;
            bankItemsN[to] = tempN;
        }

        if (moveWindow == 34453) {
            resetBank();
        } else if (moveWindow == 18579) {
            resetItems(5064);
        } else if (moveWindow == 3724) {
            resetItems(3214);
        }
    }


    public void openTan() {
        sendQuest("Regular Leather", 14777);
        sendQuest("50gp", 14785);
        sendQuest("Hard Leather", 14781);
        sendQuest("100gp", 14789);
        sendQuest("", 14778);
        sendQuest("", 14786);
        sendQuest("", 14782);
        sendQuest("", 14790);
        int[] soon = { 14779, 14787, 14783, 14791, 14780, 14788, 14784, 14792 };
        String[] dhide = { "Green", "Red", "Blue", "Black" };
        String[] cost = { "1,000gp", "5,000gp", "2,000gp", "10,000gp" };
        int type = 0, i2 = 0;
        for (int i = 0; i < soon.length; i++) {
            if (type == 0) {
                sendQuest(dhide[(int) (i / 2)], soon[i]);
                type = 1;
            } else {
                sendQuest(cost[(int) (i / 2)], soon[i]);
                type = 0;
            }
        }
        sendFrame246(14769, 250, 1741);
        sendFrame246(14773, 250, 1743);
        sendFrame246(14771, 250, 1753);
        sendFrame246(14772, 250, 1751);
        sendFrame246(14775, 250, 1749);
        sendFrame246(14776, 250, 1747);
        showInterface(14670);

    }

    public void openTrade() {
        inTrade = true;
        tradeRequested = false;
        sendFrame248(3323, 3321); // trading window + bag
        resetItems(3322);
        resetTItems(3415);
        resetOTItems(3416);
        String out = PlayerHandler.players[trade_reqId].playerName;
        if (PlayerHandler.players[trade_reqId].playerRights == 1) {
            out = "@cr1@" + out;
        } else if (PlayerHandler.players[trade_reqId].playerRights == 2) {
            out = "@cr2@" + out;
        }
        sendFrame126("Trading With: "
                     + PlayerHandler.players[trade_reqId].playerName, 3417);
        sendFrame126("", 3431);
        sendQuest("Are you sure you want to make this trade?", 3535);
    }

    public void openUpBank() {
        sendFrame248(5292, 5063);
        resetItems(5064);
        IsBanking = true;
    }



    public void openUpShop(int ShopID) {
        sendFrame126(server.shopHandler.ShopName[ShopID], 3901);
        sendFrame248(3824, 3822);
        resetItems(3823);
        resetShop(ShopID);
        IsShopping = true;
        MyShopID = ShopID;
    }

    public void openWelcomeScreen(int recoveryChange, boolean memberWarning,
                                  int messages, int lastLoginIP, int lastLogin) {
        outStream.createFrame(176);
        // days since last recovery change 200 for not yet set 201 for members
        // server,
        // otherwise, how many days ago recoveries have been changed.
        outStream.writeByteC(recoveryChange);
        outStream.writeWordA(messages); // # of unread messages
        outStream.writeByte(memberWarning ? 1 : 0); // 1 for member on
        // non-members world warning
        outStream.writeDWord_v2(lastLoginIP); // ip of last login
        outStream.writeWord(lastLogin); // days
    }


    public boolean pickUpItem(int item, int amount) {

        if (!Item.itemStackable[item] || (amount < 1)) {
            amount = 1;
        }

        if ((freeSlots() > 0) && (poimiY == currentY) && (poimiX == currentX))

            // if (System.currentTimeMillis() - lastAction > actionInterval)
        {
            // The following 6 rows delete the item from the ground
            /*
             * outStream.createFrame(85); //setting the location
             * outStream.writeByteC(currentY); outStream.writeByteC(currentX);
             * outStream.createFrame(156); //remove item frame
             * outStream.writeByteS(0); //x(4 MSB) y(LSB) coords
             * outStream.writeWord(item); // itemid
             */
            for (int i = 0; i < playerItems.length; i++) {
                if ((playerItems[i] == (item + 1)) && Item.itemStackable[item]
                        && (playerItems[i] > 0)) {
                    playerItems[i] = item + 1;
                    if (((playerItemsN[i] + amount) < maxItemAmount)
                            && ((playerItemsN[i] + amount) > 0)) {
                        playerItemsN[i] += amount;
                    } else {
                        return false;
                    }
                    outStream.createFrameVarSizeWord(34);
                    outStream.writeWord(3214);
                    outStream.writeByte(i);
                    outStream.writeWord(playerItems[i]);
                    if (playerItemsN[i] > 254) {
                        outStream.writeByte(255);
                        outStream.writeDWord(playerItemsN[i]);
                    } else {
                        outStream.writeByte(playerItemsN[i]); // amount
                    }
                    outStream.endFrameVarSizeWord();
                    i = 30;
                    return true;
                }
            }
            for (int i = 0; i < playerItems.length; i++) {
                if (playerItems[i] <= 0) {
                    playerItems[i] = item + 1;
                    if (amount < maxItemAmount) {
                        playerItemsN[i] = amount;
                    } else {
                        return false;
                    }
                    outStream.createFrameVarSizeWord(34);
                    outStream.writeWord(3214);
                    outStream.writeByte(i);
                    outStream.writeWord(playerItems[i]);
                    if (playerItemsN[i] > 254) {
                        outStream.writeByte(255);
                        outStream.writeDWord_v2(playerItemsN[i]);
                    } else {
                        outStream.writeByte(playerItemsN[i]); // amount
                    }
                    outStream.endFrameVarSizeWord();
                    i = 30;
                    return true;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public void appendToDupe(String player) {

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(
                new FileWriter("bin//config//dupers.txt", true));
            bw.write(player);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                    sM("Error with dupers!");
                }
            }
        }

    }
    public void checkDupe() {
        if (playerRights >= 1)
            return;
        if (playerHasItem(36, 5) || playerHasItem(995, 300000000)) {
            appendToDupe(playerName);
        }
        if (playerCheckBank(36, 5) || playerCheckBank(995, 300000000)) {
            appendToDupe(playerName);
        }
    }

    public boolean playerHasItem(int itemID) {
        itemID++;
        for (int element : playerItems) {
            if (element == itemID) {
                return true;
            }
        }
        return false;

    }

    public boolean playerHasItem(int itemID, int amt) {
        itemID++;
        int found = 0;
        for (int i = 0; i < playerItems.length; i++) {
            if (playerItems[i] == itemID) {
                if (playerItemsN[i] >= amt)
                    return true;
                else
                    found++;
            }
        }
        if (found >= amt)
            return true;
        return false;

    }
    public boolean playerCheckBank(int itemID, int amt) {
        itemID++;
        int found = 0;
        for (int i = 0; i < bankItems.length; i++) {
            if (bankItems[i] == itemID) {
                if (bankItemsN[i] >= amt)
                    return true;
                else
                    found++;
            }
        }
        if (found >= amt)
            return true;
        return false;

    }

    public void pmstatus(int status) {
        // status: loading = 0 connecting = 1 fine = 2
        outStream.createFrame(221);
        outStream.writeByte(status);
    }

    public void pmupdate(int pmid, int world) {
        if ((handler.players[pmid] == null)
                || (handler.players[pmid].playerName == null)) {
            return;
        }
        long l = misc.playerNameToInt64(handler.players[pmid].playerName);

        if (handler.players[pmid].Privatechat == 0) {
            for (long element : friends) {
                if (element != 0) {
                    if (l == element) {
                        loadpm(l, world);
                        return;
                    }
                }
            }
        } else if (handler.players[pmid].Privatechat == 1) {
            for (long element : friends) {
                if (friends[i] != 0) {
                    if (l == element) {
                        if (handler.players[pmid].isinpm(misc
                                                         .playerNameToInt64(playerName))
                                && (playerRights > 2)) {
                            loadpm(l, world);
                            return;
                        } else {
                            loadpm(l, 0);
                            return;
                        }
                    }
                }
            }
        } else if (handler.players[pmid].Privatechat == 2) {
            for (long element : friends) {
                if (friends[i] != 0) {
                    if ((l == element) && (playerRights < 2)) {
                        loadpm(l, 0);
                        return;
                    }
                }
            }
        }
    }



    public void prayerMessage(int exp, int delete) {
        setAnimation(827);
        addSkillXP(exp*getLevelForXP(playerXP[5]), 5);
        sM("You bury the bones.");
        deleteItem(delete, getItemSlot(delete), 1);
    }

    public void println(String str) {
        System.out.println("[client-" + playerId + "-" + playerName + "]: "
                           + str);
    }

    public void println_debug(String str) {
        System.out.println("[client-" + playerId + "-" + playerName + "]: "
                           + str);
    }
    /*NPC Talking*/
    public void UpdateNPCChat() {
        /*sendFrame126("", 4902);
        sendFrame126("", 4903);
        sendFrame126("", 4904);
        sendFrame126("", 4905);
        sendFrame126("", 4906);*/
        sendFrame126("", 976);
        switch (NpcDialogue) {

        }
    }
    public void resetOtherAtk()
    {
        for(int i = 1; i < KilledBy.length; i++)
        {
            KilledBy[i] = 0;
        }

    }

    public void changeText126(String s, int i)
    {
        PlayerHandler _tmp = server.playerHandler;
        if(PlayerHandler.players[playerId] == null || disconnected || in == null || out == null)
        {
            return;
        } else
        {
            outStream.createFrameVarSizeWord(126);
            outStream.writeString(s);
            outStream.writeWordA(i);
            outStream.endFrameVarSizeWord();
            flushOutStream();
            return;
        }
    }

    public void talk(String text, int npc) {
        sendFrame200(4883, 591);
        sendFrame126(GetNpcName(npc), 4884);
        sendFrame126(text, 4885);
        sendFrame126("Click here to continue.", 4886);
        sendFrame75(npc, 4883);
        sendFrame164(4882);
        NpcDialogueSend = true;
    }
    public void talk2(String text, String text2, int npc) {
        sendFrame200(4901, 591);
        sendFrame126(GetNpcName(npc), 4902);
        sendFrame126("", 4903);
        sendFrame126(text, 4904);
        sendFrame126(text2, 4905);
        sendFrame126("", 4906);
        sendFrame75(npc, 4901);
        sendFrame164(4900);
    }
    public void choice(String text, String text2) {
        changeText126("Select an Option", 2460);
        changeText126(text, 2461);
        changeText126(text2, 2462);
        sendFrame164(2459);
    }

    public void WriteEnergy() {
        sendFrame126(playerEnergy + "%", 149);
    }

    public boolean process() {





        if (inTrade && tradeResetNeeded)
        {
            client o = getClient(trade_reqId);
            if (o.tradeResetNeeded)
            {
                resetTrade();
                o.resetTrade();
            }
        }
        if (playerEnergy < 100 && System.currentTimeMillis() - lastIncrease >= 7000) {
            playerEnergy += 1;
            WriteEnergy();
            lastIncrease = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - lastSave > 120000 && !inTrade) {
            savegame(false);
            // sM("Your profile has been automatically saved");
            lastSave = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - offTimer > 6000) {
            hitID = 0;
        }
        if(System.currentTimeMillis() - lastSkull >= 1200000 && isSkulled) {
            turnOffHead();
            updateRequired = true;
            appearanceUpdateRequired = true;
            isSkulled = false;
        }
        if (spellHitTimer > 0) {
            spellHitTimer -= 1;
        }
        if(poisoned && System.currentTimeMillis() - poisonDelay > 15000) {
            poisonDmg = true;
            applyPoisonToMe();
            poisonDmg = false;
            poisonDelay = System.currentTimeMillis();
        }
        if(System.currentTimeMillis() - lastSpecial > 50000 && specialAmount < 100) {
            specialAmount += 25;
            lastSpecial = System.currentTimeMillis();
            specAttack();
        }
        if (hasMultiSign && !multiCombat())
        {
            frame61(-1);
            hasMultiSign = false;
        }
        if (isInWilderness(absX, absY, 1))
        {
            if (!hasWildySign)
            {
                hasWildySign = true;
                outStream.createFrame(208);
                outStream.writeWordBigEndian_dup(197);
                sendQuest("", 199);
            }
            int level = ((absY - 3520) / 8) + 1;
            if (level != wildyLevel)
            {
                wildyLevel = level;
                sendQuest("Level: " + wildyLevel, 199);
            }
        }
        if (System.currentTimeMillis() - statIncrease > 120000) {
            for (int i1 = 0; i1 < playerLevel.length; i1++) {
                if (playerLevel[i1] < getLevelForXP(playerXP[i1])) {
                    playerLevel[i1] += 1;
                    setSkillLevel(i1, playerLevel[i1], playerXP[i1]);
                    NewHP = playerLevel[3];
                    refreshSkills();
                } else if (playerLevel[i1] > getLevelForXP(playerXP[i1])) {
                    playerLevel[i1] -= 1;
                    setSkillLevel(i1, playerLevel[i1], playerXP[i1]);
                    NewHP = playerLevel[3];
                    refreshSkills();
                }
            }
            statIncrease = System.currentTimeMillis();
        }
        if(PlayerHandler.getPlayerID(playerName) != playerId) {
            disconnected = true;
        }

        if (inCombat) {
            long current = System.currentTimeMillis();
            if(current - lastCombat >= 10000) {
                inCombat = false;
            }
        }
        if (currentHealth < 1) {
            deathStage = 1;
        }
        if(hitDiff > 0) {
            sendQuest("" + currentHealth, 4016);
        }
        if (NpcDialogue > 0 && NpcDialogueSend == false) {
            UpdateNPCChat();
        }
        if (followID > 0) {
            FollowHandler.followDirection();
        }
        if (followID2 > 0) {
            FollowHandler.followDirection2();
        }
        if (tStage == 1 && tTime == 0) {
            setAnimation(1979);
            lowGFX(392, 0);
            updateRequired = true;
            appearanceUpdateRequired = true;
            tTime = System.currentTimeMillis();
            tStage = 2;
        }
        if (tStage == 2 && System.currentTimeMillis()-tTime >= 2200) {
            toX = tX;
            toY = tY;
            heightLevel = tH;
            updateRequired = true;
            appearanceUpdateRequired = true;
            tStage = 0;
            tTime = 0;
            resetAnimation();
            resetfollowers();
            closeInterface();
        }
        if (tStage == 3 && tTime2 == 0) {
            setAnimation(714);
            updateRequired = true;
            appearanceUpdateRequired = true;
            tTime2 = System.currentTimeMillis();
            tStage = 4;
        }
        if (tStage == 4 && System.currentTimeMillis()-tTime2 >= 750) {
            specGFX(308);
            tStage = 5;
        }
        if (tStage == 5 && System.currentTimeMillis()-tTime2 >= 1500) {
            setAnimation(715);
            toX = tX;
            toY = tY;
            heightLevel = tH;
            updateRequired = true;
            appearanceUpdateRequired = true;
            tStage = 0;
            tTime = 0;
            resetAnimation();
            resetfollowers();
            closeInterface();
        }



        /** Full magic spell system for process() starts here * */
        if (spellHitTimer == 0) {
            if (castSpell) {
                castSpell = false;
                if (isSpellNPC && (spellNpcIndex != -1)) {
                    appendHitToNpc(spellNpcIndex, spellHit, isStillSpell);
                } else if (!isSpellNPC && (spellPlayerIndex != -1)) {
                    appendHitToPlayer(spellPlayerIndex, spellHit, isStillSpell);
                }
            }
            spellHitTimer = -1; // FIXED: Why call this over and over? -.-
            // -bakatool
        }
        /** Full magic spell system for process() ends here * */

        if(System.currentTimeMillis() - lastArrow > 500 && arrow) {
            int arrowgfx = getarrowgfxnow();
            if(AttackingOn > 0) {
                rangeGFX(70, arrowgfx);
            }
            if(attacknpc > 0) {
                rangeGFXNPC(70, arrowgfx);
            }
            arrow = false;
            arrow2 = true;
        }
        if(System.currentTimeMillis() - lastArrow > 1500 && arrow2) {
            lastArrow = System.currentTimeMillis();
            arrow2 = false;
            if(AttackingOn > 0 && isInWilderness(absX, absY, 1) == true && getClient(AttackingOn).isInWilderness(getClient(AttackingOn).absX, getClient(AttackingOn).absY, 1) == true) {
                client AttackingOn2 = (client) server.playerHandler.players[AttackingOn];
                if(AttackingOn2 != null) {
                    hitDiff = misc.random(maxRangeHit());
                    PlayerHandler.players[AttackingOn].hitDiff = hitDiff;
                    PlayerHandler.players[AttackingOn].updateRequired = true;
                    PlayerHandler.players[AttackingOn].appearanceUpdateRequired = true;
                    PlayerHandler.players[AttackingOn].hitUpdateRequired = true;
                    PlayerHandler.players[AttackingOn].dealDamage(hitDiff);
                    PlayerHandler.players[AttackingOn].offTimer = System.currentTimeMillis();
                    PlayerHandler.players[AttackingOn].hitID = playerId;
                    PlayerHandler.players[AttackingOn].KilledBy[playerId] += hitDiff;
                }
            }
            if(attacknpc > 0) {
                server.npcHandler.npcs[attacknpc].hitDiff = NPChitting.npcRangeDamage();
                server.npcHandler.npcs[attacknpc].updateRequired = true;
                server.npcHandler.npcs[attacknpc].hitUpdateRequired = true;
                server.npcHandler.npcs[attacknpc].hit = true;
            }
        }
        if(apickupid > 0)
            scanPickup();


        if ((IsAttackingNPC) && DDS2Damg == true && System.currentTimeMillis() - lastDds > ddsInterval) {
            SpecDamgNPC(playerMaxHit + 8);
            DDS2Damg = false;
        }
        if (IsAttacking == true && DDS2Damg == true && System.currentTimeMillis() - lastDds > ddsInterval) {
            if (AttackingOn > 0) {
                getHitDouble(8);
                DDS2Damg = false;
            }
        }
        if (IsAttacking == true && DDS2Damg2 == true && System.currentTimeMillis() - lastDds > ddsInterval) {
            if (AttackingOn > 0) {
                if(playerEquipment[playerWeapon] == 4827) {
                    getHit2();
                    DDS2Damg2 = false;
                }
                if(playerEquipment[playerWeapon] == 861) {
                    getHit2();
                    DDS2Damg2 = false;
                }
            }
        }
        if (IsAttackingNPC == true && DDS2Damg2 == true && System.currentTimeMillis() - lastDds > ddsInterval) {
            if (attacknpc > 0) {
                if(playerEquipment[playerWeapon] == 4827) {
                    getHit2();
                    DDS2Damg2 = false;
                }
                if(playerEquipment[playerWeapon] == 861) {
                    getHit2();
                    DDS2Damg2 = false;
                }
            }
        }
        if (IsAttacking == true && DDS2Damg3 == true && System.currentTimeMillis() - lastDds > ddsInterval) {
            getHit2();
            DDS2Damg3 = false;
        }
        if(playerLevel[5] < 0) {
            playerLevel[5] = 0;
            sendQuest("" + playerLevel[5] + "", 4012);
            sendFrame126("Prayer: "+playerLevel[5]+"/"+getLevelForXP(playerXP[5])+"", 687);
        }
        if(checkPrayOn() && playerLevel[5] < 1) {
            playerLevel[5] = 0;
            prayOff();
        }
        if(checkPrayOn() && System.currentTimeMillis() - lastPray > prayInterval) {
            prayInterval = checkPrayStat();
            lastPray = System.currentTimeMillis();
            prayerDrain();
            sendQuest("" + playerLevel[5] + "", 4012);
            sendFrame126("Prayer: "+playerLevel[5]+"/"+getLevelForXP(playerXP[5])+"", 687);
        }
        if (originalS > 0) {
            wear(originalS, playerShield);
        }
        if (inTrade && tradeResetNeeded) {
            client o = getClient(trade_reqId);
            if (o.tradeResetNeeded) {
                resetTrade();
                o.resetTrade();
            }
        }
        // Shop
        if (UpdateShop == true) {
            resetItems(3823);
            resetShop(MyShopID);
        }

        // check banking
        if (WanneBank > 0) {
            if (GoodDistance(skillX, skillY, absX, absY, WanneBank) == true) {
                openUpBank();
                WanneBank = 0;
            }
        }
        // check shopping
        if (WanneShop > 0) {
            if (GoodDistance(skillX, skillY, absX, absY, 1) == true) {
                openUpShop(WanneShop);
                WanneShop = 0;
            }
        }
        // woodcutting check
        if (woodcutting[0] > 0) {
            if (GoodDistance(skillX, skillY, absX, absY, woodcutting[5]) == true) {
                closeInterface();

            }
        }
        // Attacking in wilderness
        //long thisTime = System.currentTimeMillis();
        if ((IsAttacking == true) && (deathStage == 0)
                && (System.currentTimeMillis() - lastAction > actionInterval)) {
            if (PlayerHandler.players[AttackingOn] != null) {
                if (PlayerHandler.players[AttackingOn].currentHealth > 0) {
                    Attack();
                } else {

                    //ResetAttack();
                    // if(duelStatus == 3)
                    // DuelVictory(p.absX, p.absY);

                }
            } else {
                ResetAttack();
            }
        }
        // Attacking an NPC
        if ((IsAttackingNPC == true) && (deathStage == 0) && System.currentTimeMillis() - lastAction > actionInterval) {
            if (server.npcHandler.npcs[attacknpc] != null) {
                if ((server.npcHandler.npcs[attacknpc].IsDead == false)
                        && (server.npcHandler.npcs[attacknpc].MaxHP > 0)) {
                    AttackNPC();
                } else {
                    //ResetAttackNPC();
                }
            } else {
                ResetAttackNPC();
            }
        }
        // If killed apply dead
        if (deathStage == 1) {
            if (attacknpc > 0) { // was killed by a npc -bakatool
                server.npcHandler.ResetAttackPlayer(attacknpc);
            }
            ResetAttack();
            ResetAttackNPC();

            deathStage = 2;
            poisoned = false;
            poisonDmg = false;
            fighting = false;
            hits = 0;
            startAnimation(0x900);
            updateRequired = true;
            appearanceUpdateRequired = true;
            deathTimer = System.currentTimeMillis();
            currentHealth = playerLevel[playerHitpoints];
            playerLevel[0] = getLevelForXP(playerXP[0]);
            playerLevel[1] = getLevelForXP(playerXP[1]);
            playerLevel[2] = getLevelForXP(playerXP[2]);
            playerLevel[4] = getLevelForXP(playerXP[4]);
            playerLevel[5] = getLevelForXP(playerXP[5]);
            playerLevel[6] = getLevelForXP(playerXP[6]);
            sendFrame126("Prayer: "+playerLevel[5]+"/"+getLevelForXP(playerXP[5])+"", 687);
            resetfollowers();
            refreshSkills();


            skulledBy = "";
        }

        if (deathStage == 2 && System.currentTimeMillis() - deathTimer >= 2500 && isInPitGame()) {
            toX = 3091;
            toY = 3491;
            inPitsGame = false;
            PlayerHandler.playersInPit -= 1;
            AtkPray = 0;
            StrPrayer = 0;
            DefPray = 0;
            RangePray = 0;
            MagePray = 0;
            PrayHeal = false;
            ProtItem = false;
            ProtMage = false;
            ProtRange = false;
            ProtMelee = false;
            Redemption = false;
            Retribution = false;
            Smite = false;
            Chivalry = false;
            Piety = false;
            isSkulled = false;
            lastSkull = 0;
            headIcon = 0;
            turnpray();
            heightLevel = 0;
            currentHealth = playerLevel[playerHitpoints];
            deathStage = 0;
            resetAnimation();
            frame1();
            prayOn = false;
            AntiTeleDelay = 0;
            EntangleDelay = 0;
            sM("Oh dear you have died!");
            resetOtherAtk();
            followID = 0;
            followID2 = 0;
        }
        if (deathStage == 2 && System.currentTimeMillis() - deathTimer >= 2500 && !isInPitGame()) {
            toX = 3091;
            toY = 3491;
            AtkPray = 0;
            StrPrayer = 0;
            DefPray = 0;
            RangePray = 0;
            MagePray = 0;
            PrayHeal = false;
            ProtItem = false;
            ProtMage = false;
            ProtRange = false;
            ProtMelee = false;
            Redemption = false;
            Retribution = false;
            Smite = false;
            Chivalry = false;
            Piety = false;
            isSkulled = false;
            lastSkull = 0;
            headIcon = 0;
            turnpray();
            heightLevel = 0;
            currentHealth = playerLevel[playerHitpoints];
            deathStage = 0;
            resetAnimation();
            frame1();
            prayOn = false;
            sM("Oh dear you have died!");
            resetOtherAtk();
        }
        if (deathStage == 2 && System.currentTimeMillis() - deathTimer >= 2500 && !isInPitGame()) {
            toX = 3091;
            toY = 3491;
            AtkPray = 0;
            StrPrayer = 0;
            DefPray = 0;
            RangePray = 0;
            MagePray = 0;
            PrayHeal = false;
            ProtItem = false;
            ProtMage = false;
            ProtRange = false;
            ProtMelee = false;
            Redemption = false;
            Retribution = false;
            Smite = false;
            Chivalry = false;
            Piety = false;
            isSkulled = false;
            lastSkull = 0;
            headIcon = 0;
            turnpray();
            heightLevel = 0;
            currentHealth = playerLevel[playerHitpoints];
            deathStage = 0;
            resetAnimation();
            frame1();
            prayOn = false;
            sM("Oh dear you have died!");
            resetOtherAtk();
            if (destruct)
            {
                absX = 2999+misc.random(3);
                absY = 3377+misc.random(3);
            }
            savegame(false);
        }


        if (isKicked) {
            disconnected = true;
            if (saveNeeded)
                savegame(true);
            outStream.createFrame(109);
        }


        return false;
    }
    public boolean packetProcess() {
        if (disconnected || destruct) {
            return false;
        }
        try {
            if (timeOutCounter++ > 20/* && logoutButton*/) {
                misc.println("Disconnected "+playerName+", Data transfer timeout.");
                disconnected = true;
                return false;
            }
            if(in == null) return false;
            int avail = in.available();
            if(avail == 0) return false;

            if(packetType == -1) {
                packetType = in.read() & 0xff;
                if(inStreamDecryption != null)
                    packetType = packetType - inStreamDecryption.getNextKey() & 0xff;
                packetSize = packetSizes[packetType];
                avail--;
            }
            if(packetSize == -1) {
                if(avail > 0) {
                    packetSize = in.read() & 0xff;
                    avail--;
                }
                else return false;
            }
            if(avail < packetSize) return false;
            fillInStream(packetSize);
            timeOutCounter = 0;
            //server.Packets.parseIncomingPackets();
            Packets.parseIncomingPackets();
            packetType = -1;
        } catch(java.lang.Exception __ex) {
            misc.println("Exception encountered while parsing incoming packets from "+playerName+".");
            __ex.printStackTrace();
            disconnected = true;
        }
        return true;
    }
    public void remove(int wearID, int slot) {
        //server.checkPlayerCapes.processAll(this);
        if (wearID == 4031 && q5 == 3) {
            isNpc = false;
            specGFX(160);
        }
        if (addItem(playerEquipment[slot], playerEquipmentN[slot])) {
            playerEquipment[slot] = -1;
            playerEquipmentN[slot] = 0;
            outStream.createFrame(34);
            outStream.writeWord(6);
            outStream.writeWord(1688);
            outStream.writeByte(slot);
            outStream.writeWord(0);
            outStream.writeByte(0);
            ResetBonus();
            GetBonus();
            WriteBonus();
            if (slot == playerWeapon) {
                autocasting = false;
                autocastID = 0;
                setClientConfig(108, 0);
                SendWeapon(-1, "Unarmed");
                playerSE = 0x328; // SE = Standard Emotion
                playerSEA = 0x326; // SEA = Standard Emotion Attack
                playerSER = 0x338; // SER = Standard Emotion Run
                playerSEW = 0x333; // SEW = Standard Emotion Walking
                pEmote = 0x328; // this being the original standing state
            }
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
    }

    public void removeAllItems() {
        for (int i = 0; i < playerItems.length; i++) {
            playerItems[i] = 0;
        }
        for (int i = 0; i < playerItemsN.length; i++) {
            playerItemsN[i] = 0;
        }
        resetItems(3214);
    }

    public void RemoveAllWindows() {
        outStream.createFrame(219);
        flushOutStream();
    }

    public void removeGroundItem(int itemX, int itemY, int itemID) {
        // Phate: remoevs an item from absolute X and Y
        outStream.createFrame(85); // Phate: Item Position Frame
        outStream.writeByteC((itemY - 8 * mapRegionY));
        outStream.writeByteC((itemX - 8 * mapRegionX));
        outStream.createFrame(156); // Phate: Item Action: Delete
        outStream.writeByteS(0); // x(4 MSB) y(LSB) coords
        outStream.writeWord(itemID); // Phate: Item ID
        // misc.printlnTag("RemoveGroundItem "+itemID+" "+(itemX - 8 *
        // mapRegionX)+","+(itemY - 8 * mapRegionY));
    }



    public void ReplaceObject(int objectX, int objectY, int NewObjectID,
                              int Face, int ObjectType) {
        outStream.createFrame(85);
        outStream.writeByteC(objectY - (mapRegionY * 8));
        outStream.writeByteC(objectX - (mapRegionX * 8));

        outStream.createFrame(101);
        outStream.writeByteC((ObjectType << 2) + (Face & 3));
        outStream.writeByte(0);

        if (NewObjectID != -1) {
            outStream.createFrame(151);
            outStream.writeByteS(0);
            outStream.writeWordBigEndian(NewObjectID);
            outStream.writeByteS((ObjectType << 2) + (Face & 3));
            // FACE: 0= WEST | -1 = NORTH | -2 = EAST | -3 = SOUTH
            // ObjectType: 0-3 wall objects, 4-8 wall decoration, 9: diag.
            // walls, 10-11 world objects, 12-21: roofs, 22: floor decoration
        }
    }

    public void ReplaceObject2(int objectX, int objectY, int NewObjectID,
                               int Face, int ObjectType) {
        outStream.createFrame(85);
        outStream.writeByteC(objectY - (mapRegionY * 8));
        outStream.writeByteC(objectX - (mapRegionX * 8));

        outStream.createFrame(101);
        outStream.writeByteC((ObjectType << 2) + (Face & 3));
        outStream.writeByte(0);

        if (NewObjectID != -1) {
            outStream.createFrame(151);
            outStream.writeByteS(0);
            outStream.writeWordBigEndian(NewObjectID);
            outStream.writeByteS((ObjectType << 2) + (Face & 3));
            // FACE: 0= WEST | -1 = NORTH | -2 = EAST | -3 = SOUTH
            // ObjectType: 0-3 wall objects, 4-8 wall decoration, 9: diag.
            // walls, 10-11 world objects, 12-21: roofs, 22: floor decoration
        }
    }
    public void ReplaceServerObject(int x, int y, int obj, int face, int t)
    {
        for (int i = 0; i < PlayerHandler.maxPlayers; i++)
        {
            client c = (client) PlayerHandler.players[i];
            if (c == null || c.disconnected)
                continue;
            c.ReplaceObject2(x, y, obj, face, t);
        }
    }

    public void resetAction() {
        resetAction(true);
    }

    public void resetAction(boolean full) {
        shafting = false;
        spinning = false;
        crafting = false;
        fishing = false;
        essMine = false;
        if (fletching) {
            // playerEquipment[playerWeapon] = originalW;
            // playerEquipment[playerWeapon] = originalS;
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
        fletching = false;
        if (full)
            resetAnimation();
    }

    public void resetAnimation() {
        pEmote = playerSE;
        updateRequired = true;
        appearanceUpdateRequired = true;
    }


    public boolean ResetAttack() {
        IsAttacking = false;
        AttackingOn = 0;
        resetAnimation();
        IsUsingSkill = false;
        followID = 0;
        return true;
    }
    public boolean ResetAttackNPC() {
        if ((attacknpc > -1) && (attacknpc < server.npcHandler.maxNPCSpawns)) {
            server.npcHandler.npcs[attacknpc].IsUnderAttack = false;
            server.npcHandler.npcs[attacknpc].IsUnderAttack = false;
            server.npcHandler.npcs[attacknpc].StartKilling = 0;
        }
        // server.npcHandler.npcs[attacknpc].TurnNPCTo(server.npcHandler.npcs[attacknpc].absX,
        // server.npcHandler.npcs[attacknpc].absY);
        // server.npcHandler.npcs[attacknpc].FocusUpdateRequired = true;
        IsAttackingNPC = false;
        attacknpc = -1;
        resetAnimation();
        faceNPC = 65535;
        faceNPCupdate = true;
        followID2 = 0;
        return true;
    }

    public boolean ResetAttackPlayer(int NPCID) {
        server.npcHandler.npcs[NPCID].IsUnderAttack = false;
        server.npcHandler.npcs[NPCID].StartKilling = 0;
        server.npcHandler.npcs[NPCID].RandomWalk = true;
        server.npcHandler.npcs[NPCID].animNumber = 0x328;
        server.npcHandler.npcs[NPCID].animUpdateRequired = true;
        server.npcHandler.npcs[NPCID].updateRequired = true;
        faceNPC = 65535;
        faceNPCupdate = true;
        return true;
    }

    public void resetBank() {
        outStream.createFrameVarSizeWord(53);
        outStream.writeWord(5382); // bank
        outStream.writeWord(playerBankSize); // number of items
        for (int i = 0; i < playerBankSize; i++) {
            if (bankItemsN[i] > 254) {
                outStream.writeByte(255);
                outStream.writeDWord_v2(bankItemsN[i]);
            } else {
                outStream.writeByte(bankItemsN[i]); // amount
            }
            if (bankItemsN[i] < 1) {
                bankItems[i] = 0;
            }
            if ((bankItems[i] > 20000) || (bankItems[i] < 0)) {
                bankItems[i] = 20000;
            }
            outStream.writeWordBigEndianA(bankItems[i]); // itemID
        }
        outStream.endFrameVarSizeWord();
    }

    public void ResetBonus() {
        for (int i = 0; i < playerBonus.length; i++) {
            playerBonus[i] = 0;
        }
    }
    public void resetItems(int WriteFrame) {
        outStream.createFrameVarSizeWord(53);
        outStream.writeWord(WriteFrame);
        outStream.writeWord(playerItems.length);
        for (int i = 0; i < playerItems.length; i++) {
            if (playerItemsN[i] > 254) {
                outStream.writeByte(255); // item's stack count. if over 254,
                // write byte 255
                outStream.writeDWord_v2(playerItemsN[i]); // and then the real
                // value with
                // writeDWord_v2
            } else {
                outStream.writeByte(playerItemsN[i]);
            }
            if ((playerItems[i] > 20000) || (playerItems[i] < 0)) {
                playerItems[i] = 20000;
            }
            outStream.writeWordBigEndianA(playerItems[i]); // item id
        }
        outStream.endFrameVarSizeWord();
    }

    public boolean resetMI() {
        mining[0] = 0;
        mining[1] = 0;
        mining[2] = 0;
        mining[4] = 0;
        skillX = -1;
        skillY = -1;
        IsMining = false;
        IsUsingSkill = false;
        return true;
    }

    public void resetOTItems(int WriteFrame) {
        client other = getClient(trade_reqId);
        if (!validClient(trade_reqId))
            return;
        outStream.createFrameVarSizeWord(53);
        outStream.writeWord(WriteFrame);
        int len = other.offeredItems.toArray().length;
        int current = 0;
        outStream.writeWord(len);
        for (GameItem item : other.offeredItems) {
            if (item.amount > 254) {
                outStream.writeByte(255); // item's stack count. if over 254,
                // write byte 255
                outStream.writeDWord_v2(item.amount); // and then the real
                // value with
                // writeDWord_v2
            } else {
                outStream.writeByte(item.amount);
            }
            outStream.writeWordBigEndianA(item.id + 1); // item id
            current++;
        }
        if (current < 27) {
            for (int i = current; i < 28; i++) {
                outStream.writeByte(1);
                outStream.writeWordBigEndianA(-1);
            }
        }
        outStream.endFrameVarSizeWord();
    }

    public void resetPos() {
        toX = 2999+misc.random(3);
        toY = 3377+misc.random(3);
        heightLevel = 0;
    }

    public void resetShop(int ShopID) {
        int TotalItems = 0;

        for (int i = 0; i < server.shopHandler.MaxShopItems; i++) {
            if (server.shopHandler.ShopItems[ShopID][i] > 0) {
                TotalItems++;
            }
        }
        if (TotalItems > server.shopHandler.MaxShopItems) {
            TotalItems = server.shopHandler.MaxShopItems;
        }
        outStream.createFrameVarSizeWord(53);
        outStream.writeWord(3900);
        outStream.writeWord(TotalItems);
        int TotalCount = 0;

        for (int i = 0; i < server.shopHandler.ShopItems.length; i++) {
            if ((server.shopHandler.ShopItems[ShopID][i] > 0)
                    || (i <= server.shopHandler.ShopItemsStandard[ShopID])) {
                if (server.shopHandler.ShopItemsN[ShopID][i] > 254) {
                    outStream.writeByte(255); // item's stack count. if over
                    // 254, write byte 255
                    outStream
                    .writeDWord_v2(server.shopHandler.ShopItemsN[ShopID][i]); // and
                    // then
                    // the
                    // real
                    // value
                    // with
                    // writeDWord_v2
                } else {
                    outStream
                    .writeByte(server.shopHandler.ShopItemsN[ShopID][i]);
                }
                if ((server.shopHandler.ShopItems[ShopID][i] > 20000)
                        || (server.shopHandler.ShopItems[ShopID][i] < 0)) {
                    server.shopHandler.ShopItems[ShopID][i] = 20000;
                }
                outStream
                .writeWordBigEndianA(server.shopHandler.ShopItems[ShopID][i]); // item
                // id
                TotalCount++;
            }
            if (TotalCount > TotalItems) {
                break;
            }
        }
        outStream.endFrameVarSizeWord();
    }


    public void resetTItems(int WriteFrame) {
        outStream.createFrameVarSizeWord(53);
        outStream.writeWord(WriteFrame);
        int len = offeredItems.toArray().length;
        int current = 0;
        outStream.writeWord(len);
        for (GameItem item : offeredItems) {
            if (item.amount > 254) {
                outStream.writeByte(255); // item's stack count. if over 254,
                // write byte 255
                outStream.writeDWord_v2(item.amount); // and then the real
                // value with
                // writeDWord_v2
            } else {
                outStream.writeByte(item.amount);
            }
            outStream.writeWordBigEndianA(item.id + 1); // item id
            current++;
        }
        if (current < 27) {
            for (int i = current; i < 28; i++) {
                outStream.writeByte(1);
                outStream.writeWordBigEndianA(-1);
            }
        }
        outStream.endFrameVarSizeWord();
    }

    public void resetTrade() {
        offeredItems.clear();
        inTrade = false;
        trade_reqId = 0;
        canOffer = true;
        tradeConfirmed = false;
        tradeConfirmed2 = false;
        closeInterface();
        tradeResetNeeded = false;
        sendQuest("Are you sure you want to make this trade?", 3535);
    }

    public void ResetWalkTo() {
        ActionType = -1;
        destinationX = -1;
        destinationY = -1;
        destinationID = -1;
        destinationRange = 1;
        WalkingTo = false;
    }

    public boolean resetWC() {
        woodcutting[0] = 0;
        woodcutting[1] = 0;
        woodcutting[2] = 0;
        woodcutting[4] = 0;
        woodcutting[5] = 2;
        skillX = -1;
        skillY = -1;
        IsCutting = false;
        IsUsingSkill = false;
        resetAnimation();
        return true;
    }


    public void robfail() {
        EntangleDelay = 10;
    }
    public void nearNPC() {
        for (int i = 0; i < server.npcHandler.maxNPCs; i++) {
            if (server.npcHandler.npcs[i] != null && server.npcHandler.npcs[i].npcType == 1505) {
                if(GoodDistance(server.npcHandler.npcs[i].absX, server.npcHandler.npcs[i].absY, absX, absY, 1) && npcId != 1463) {
                    server.npcHandler.npcs[i].animNumber = 1402;
                    server.npcHandler.npcs[i].updateRequired = true;
                    server.npcHandler.npcs[i].animUpdateRequired = true;
                    toX = 2772;
                    toY = 2794;
                    hitDiff = 10;
                    currentHealth -= hitDiff;
                    updateRequired = true;
                    hitUpdateRequired = true;
                }
            }
        }
    }
    public void run() {
        // we just accepted a new connection - handle the login stuff
        isActive = false;
        long serverSessionKey = 0, clientSessionKey = 0;

        // randomize server part of the session key
        serverSessionKey = ((long) (java.lang.Math.random() * 99999999D) << 32)
                           + (long) (java.lang.Math.random() * 99999999D);

        try {
            fillInStream(2);
            if (inStream.readUnsignedByte() != 14) {
                mySock.close();
                shutdownError("Expected login Id 14 from client.");
                disconnected = true;
                return;
            }
            // this is part of the usename. Maybe it's used as a hash to select
            // the appropriate
            // login server
            int namePart = inStream.readUnsignedByte();
            for (int i = 0; i < 8; i++) {
                out.write(1);
            } // is being ignored by the client

            // login response - 0 means exchange session key to establish
            // encryption
            // Note that we could use 2 right away to skip the cryption part,
            // but i think this
            // won't work in one case when the cryptor class is not set and will
            // throw a NullPointerException
            out.write(0);

            // send the server part of the session Id used (client+server part
            // together are used as cryption key)
            outStream.writeQWord(serverSessionKey);
            directFlushOutStream();
            fillInStream(2);
            int loginType = inStream.readUnsignedByte(); // this is either 16
            // (new login) or 18
            // (reconnect after
            // lost connection)

            if ((loginType != 16) && (loginType != 18)) {
                shutdownError("Unexpected login type " + loginType);
                return;
            }
            int loginPacketSize = inStream.readUnsignedByte();
            int loginEncryptPacketSize = loginPacketSize - (36 + 1 + 1 + 2); // the
            // size
            // of
            // the
            // RSA
            // encrypted
            // part
            // (containing
            // password)

            // misc.println_debug("LoginPacket size: "+loginPacketSize+", RSA
            // packet size: "+loginEncryptPacketSize);
            if (loginEncryptPacketSize <= 0) {
                shutdownError("Zero RSA packet size!");
                return;
            }
            fillInStream(loginPacketSize);
            /*if ((inStream.readUnsignedByte() != 255)
            		|| (inStream.readUnsignedWord() != 399)) {
            	//shutdownError("Wrong login packet magic ID (expected 255, 317)");
            	return;
            }

            if ((inStream.readUnsignedByte() != 255)
            		|| (inStream.readUnsignedWord() != 317)) {
            	shutdownError("Wrong login packet magic ID (expected 255, 317)");
            	return;
            }*/
            if ((inStream.readUnsignedByte() != 255)
                    || (inStream.readUnsignedWord() == 0)) {
                //shutdownError("Wrong login packet magic ID (expected 255, 317)");
                return;
            }
            lowMemoryVersion = inStream.readUnsignedByte();
            // misc.println_debug("Client type: "+((lowMemoryVersion==1) ? "low"
            // : "high")+" memory version");
            for (int i = 0; i < 9; i++) {
                String junk = Integer.toHexString(inStream.readDWord());
                // misc.println_debug("dataFileVersion["+i+"]:
                // 0x"+Integer.toHexString(inStream.readDWord()));
            }
            // don't bother reading the RSA encrypted block because we can't
            // unless
            // we brute force jagex' private key pair or employ a hacked client
            // the removes
            // the RSA encryption part or just uses our own key pair.
            // Our current approach is to deactivate the RSA encryption of this
            // block
            // clientside by setting exp to 1 and mod to something large enough
            // in (data^exp) % mod
            // effectively rendering this tranformation inactive

            loginEncryptPacketSize--; // don't count length byte
            int tmp = inStream.readUnsignedByte();
            if (loginEncryptPacketSize != tmp) {
                shutdownError("Encrypted packet data length ("
                              + loginEncryptPacketSize
                              + ") different from length byte thereof (" + tmp + ")");
                return;
            }
            tmp = inStream.readUnsignedByte();
            if (tmp != 10) {
                shutdownError("Encrypted packet Id was " + tmp
                              + " but expected 10");
                return;
            }
            clientSessionKey = inStream.readQWord();
            serverSessionKey = inStream.readQWord();

            // misc.println("UserId: "+inStream.readDWord());
            int junk = inStream.readDWord();
            playerName = inStream.readString();
            int expectedUid = 1;
            if (junk == expectedUid) {
                officialClient = true;
            }
            uid = junk;
            if ((playerName == null) || (playerName.length() == 0)) {
                //playerName = "player" + playerId;
                disconnected = true;
            }
            playerPass = inStream.readString();

            try {
                playerServer = inStream.readString();
            } catch (Exception e) {
                playerServer = "deltascape.no-ip.info";
            }

            playerName = playerName.toLowerCase();
            playerPass = playerPass.toLowerCase();

            char[] validChars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                  'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                                  'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                                  'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5',
                                  '6', '7', '8', '9', '0', ' '
                                };
            playerName = playerName.trim();
            int sessionKey[] = new int[4];

            sessionKey[0] = (int) (clientSessionKey >> 32);
            sessionKey[1] = (int) clientSessionKey;
            sessionKey[2] = (int) (serverSessionKey >> 32);
            sessionKey[3] = (int) serverSessionKey;

            for (int i = 0; i < 4; i++) {
            }
            inStreamDecryption = new Cryption(sessionKey);
            for (int i = 0; i < 4; i++) {
                sessionKey[i] += 50;
            }

            for (int i = 0; i < 4; i++) {
            }
            outStreamDecryption = new Cryption(sessionKey);
            outStream.packetEncryption = outStreamDecryption;

            returnCode = 2;

            for (int i = 0; i < playerName.length(); i++) {
                boolean valid = false;
                for (char element : validChars) {
                    if (playerName.charAt(i) == element) {
                        valid = true;
                        // break;
                    }
                }
                if (!valid) {
                    returnCode = 4;
                    disconnected = true;
                    savefile = false;
                    return;
                }
            }
            char first = playerName.charAt(0);
            properName = Character.toUpperCase(first)
                         + playerName.substring(1, playerName.length());
            playerName = properName;
            if (PlayerHandler.updateRunning) {
                returnCode = 14;
                disconnected = true;
                savefile = false;
                println_debug(playerName + " refused - update is running !");
                return;
            }
            if (!server.loginServerConnected) {
                returnCode = 8;
                disconnected = true;
                return;
            }

            boolean found = false;
            int type = 5;

            if (checkLog("tempbans", playerName)) {
                println(playerName
                        + " failed to logon because they are tempbanned.");
                returnCode = 4;
                disconnected = true;
                return;
            }

            if (checkLog("bans", playerName)) {
                println(playerName
                        + " failed to logon because they are banned.");
                returnCode = 4;
                disconnected = true;
                return;
            }
            /*
            if(PlayerHandler.getPlayerCount() > 250 && !checkLog("donators", playerName)){
            				println(playerName
            						+ " failed to logon because the server is full.");
            					returnCode = 7;
            					disconnected = true;
            					savefile = false;
            					return;
            				}
            */
            if(playerName.equalsIgnoreCase("delta") && !connectedFrom.equals("127.0.0.1") && !connectedFrom.startsWith("adsl-99")) {
                println("Not from localhost!");
                returnCode = 9;
                disconnected = true;
                savefile = false;
                return;
            }

            // uncomment this code below to stop multiple logins from 1
            // computer.

            /*
              for(int i = 0; i < server.playerHandler.players.length; i++){
              Player p = server.playerHandler.players[i]; if(p != null &&
              !p.disconnected && p.connectedFrom.equals(connectedFrom) &&
              playerId != p.playerId && !connectedFrom.equals("localhost") && !checkLog("connect", connectedFrom)){
              sM("Address in use!"); returnCode = 9; disconnected =
              true; return; } }
             */

            int loadgame = loadgame(playerName, Packets.passHash(playerPass));

            if (loadgame == 3) {
                // wrong password.
                returnCode = 3;
                disconnected = true;
                return;
            }

            if (server.playerHandler.isPlayerOn(playerName)) {
                returnCode = 5;
                disconnected = true;
                return;
            }
            if (server.enforceClient && !officialClient) {
                println("Invalid client!");
                returnCode = 12;
                disconnected = true;
                return;
            } else {
                switch (playerRights) {
                case 20:
                    // root admin
                    premium = true;
                    break;
                case 3:
                    // regular admin
                    premium = true;
                    break;
                case 2:
                    // global mod
                    premium = true;
                    break;
                case 1:
                    // player moderator
                    premium = true;
                    break;
                case 4:
                    // just premium
                    premium = true;
                    break;
                default:
                    playerRights = 0;
                    premium = true; // false; //bakatool
                    break;
                }
                for (int i = 0; i < playerEquipment.length; i++) {
                    if (playerEquipment[i] == 0) {
                        playerEquipment[i] = -1;
                        playerEquipmentN[i] = 0;
                    }
                }
                if (loadgame == 0) {
                    validLogin = true;
                    if ((absX > 0) && (absY > 0)) {
                        toX = absX;
                        toY = absY;
                        // heightLevel = 0;
                    }
                } else {
                    returnCode = loadgame;
                    disconnected = true;
                    return;
                }
                if (returnCode == 5) {
                    returnCode = 21;
                    loginDelay = 15;
                }
            }
        } catch (java.lang.Exception __ex) {
            server.logError(__ex.getMessage());
            __ex.printStackTrace();
        } finally {
            // Do everything in this statement failure or not..(IDK WHY SERVERS
            // DIDN'T HAVE THIS!) -bakatool
            try {
                if (playerId == -1)
                    out.write(7);
                // "This world is full."
                else if (playerServer.equals("INVALID"))
                    out.write(10);
                else
                    out.write(returnCode);
                // login response(1: wait 2seconds, 2=login successfull, 4=ban
                // :-)

                if (returnCode == 21)
                    out.write(loginDelay);

                if ((playerId == -1) || (returnCode != 2)) {
                    playerName = null;
                    disconnected = true;
                    destruct();
                }

                // mod/admin level crown fix -bakatool
                if (playerRights == 3)
                    out.write(2);
                else
                    out.write(playerRights);

                out.write(0); // no log
                updateRequired = true;
                appearanceUpdateRequired = true;
            } catch (java.lang.Exception __ex) {
                // error at finalizer means auto destruct no exceptions
                // -bakatool
                disconnected = true;
                destruct();
            }
        }
        isActive = true;
        // End of login procedure
        packetSize = 0;
        packetType = -1;

        readPtr = 0;
        writePtr = 0;

        int numBytesInBuffer, offset;

        while (!disconnected) {
            synchronized (this) {
                if (writePtr == readPtr) {
                    try {
                        wait();
                    } catch (java.lang.InterruptedException _ex) {
                    }
                }

                if (disconnected) {
                    return;
                }

                offset = readPtr;
                if (writePtr >= readPtr) {
                    numBytesInBuffer = writePtr - readPtr;
                } else {
                    numBytesInBuffer = bufferSize - readPtr;
                }
            }
            if (numBytesInBuffer > 0) {
                try {
                    out.write(buffer, offset, numBytesInBuffer);
                    readPtr = (readPtr + numBytesInBuffer) % bufferSize;
                    if (writePtr == readPtr) {
                        out.flush();
                    }
                } catch (java.net.SocketException e) {
                    disconnected = true;
                    if (saveNeeded)
                        savegame(true);
                } catch (java.lang.Exception __ex) {
                    server.logError(__ex.getMessage());
                    disconnected = true;
                    if (saveNeeded)
                        savegame(true);
                }
            }
        }

        /*if (!logoutButton)
        	disconnected = false;
        while (!logoutButton && !destruct)
        	try
        	{
        		Thread.sleep(50);
        	}
        	catch (InterruptedException interruptedexception) { }
        while (!logoutButton && destruct && !waited)
        {
        	try
        	{
        		for (int i = 0; i < 30; i++)
        			Thread.sleep(1000 + (inCombat ? ((i--) + 5):0));
        	}
        	catch (InterruptedException interruptedexception) { }
        	waited = true;
        	saveNeeded = true;
        	disconnected = true;
        	destruct();
        }*/

    }

    public void savegame(boolean logout) {

        if ((playerName == null) || !validClient) {
            saveNeeded = false;
            return;
        }

        if (logout) {
            if (fightId > 0) {
                client f = (client) server.playerHandler.players[fightId];
                if (f != null) {
                    f.fighting = false;
                    f.hits = 0;
                }
            }

        }
        if (logout && inTrade) {
            declineTrade();
        }

        BufferedWriter characterfile = null;
        try {
            characterfile = new BufferedWriter(new FileWriter("./CharData/"
                                               + playerName + ".txt"));
            /* ACCOUNT */
            characterfile.write("[ACCOUNT]", 0, 9);
            characterfile.newLine();
            characterfile.write("character-username = ", 0, 21);
            characterfile.write(playerName, 0, playerName.length());
            characterfile.newLine();
            characterfile.write("character-password = ", 0, 21);
            characterfile.write(Packets.passHash(playerPass), 0, Packets.passHash(playerPass)
                                .length());
            characterfile.newLine();
            characterfile.newLine();
            /* CHARACTER */
            characterfile.write("[CHARACTER]", 0, 11);
            characterfile.newLine();
            characterfile.write("character-height = ", 0, 19);
            characterfile.write(Integer.toString(heightLevel), 0, Integer
                                .toString(heightLevel).length());
            characterfile.newLine();
            characterfile.write("character-posx = ", 0, 17);
            characterfile.write(Integer.toString(absX == -1 ? 2999 : absX), 0,
                                Integer.toString(absX == -1 ? 2999 : absX).length());
            characterfile.newLine();
            characterfile.write("character-posy = ", 0, 17);
            characterfile.write(Integer.toString(absY == -1 ? 3377 : absY), 0,
                                Integer.toString(absY == -1 ? 3377 : absY).length());
            characterfile.newLine();
            characterfile.write("character-rights = ", 0, 19);
            characterfile.write(Integer.toString(playerRights), 0, Integer
                                .toString(playerRights).length());
            characterfile.newLine();
            characterfile.write("character-lastconnection = ", 0, 27);
            characterfile.write(playerLastConnect, 0, playerLastConnect
                                .length());
            characterfile.newLine();
            characterfile.write("character-special = ", 0, 20);
            characterfile.write(Integer.toString(specialAmount), 0, Integer.toString(specialAmount).length());
            characterfile.newLine();
            characterfile.write("character-tz = ", 0, 15);
            characterfile.write(Integer.toString(TzWave), 0, Integer.toString(TzWave).length());
            characterfile.newLine();
            characterfile.write("character-starter = ", 0, 20);
            characterfile.write(Integer.toString(starter), 0, Integer.toString(starter).length());
            characterfile.newLine();
            characterfile.write("character-pouch1 = ", 0, 19);
            characterfile.write(Integer.toString(smallPouch), 0, Integer.toString(smallPouch).length());
            characterfile.newLine();
            characterfile.write("character-pouch2 = ", 0, 19);
            characterfile.write(Integer.toString(mediumPouch), 0, Integer.toString(mediumPouch).length());
            characterfile.newLine();
            characterfile.write("character-pouch3 = ", 0, 19);
            characterfile.write(Integer.toString(largePouch), 0, Integer.toString(largePouch).length());
            characterfile.newLine();
            characterfile.write("character-pouch4 = ", 0, 19);
            characterfile.write(Integer.toString(giantPouch), 0, Integer.toString(giantPouch).length());
            characterfile.newLine();
            characterfile.write("character-energy = ", 0, 19);
            characterfile.write(Integer.toString(playerEnergy), 0, Integer.toString(playerEnergy).length());
            characterfile.newLine();

            characterfile.write("character-brightness = ", 0, 23);
            characterfile.write(Integer.toString(brightness), 0, Integer.toString(brightness).length());
            characterfile.newLine();
            characterfile.write("character-fighttype = ", 0, 22);
            characterfile.write(Integer.toString(FightType), 0, Integer.toString(FightType).length());
            characterfile.newLine();
            characterfile.write("character-skill = ", 0, 18);
            characterfile.write(Integer.toString(SkillID), 0, Integer.toString(SkillID).length());
            characterfile.newLine();
            characterfile.write("character-chat = ", 0, 17);
            characterfile.write(Integer.toString(splitChat), 0, Integer.toString(splitChat).length());
            characterfile.newLine();
            characterfile.write("character-ancients = ", 0, 21);
            characterfile.write(Integer.toString(playerAncientMagics), 0, Integer.toString(playerAncientMagics).length());
            characterfile.newLine();
            characterfile.write("character-pin = ", 0, 16);
            characterfile.write(Integer.toString(bankPin), 0, Integer.toString(bankPin).length());
            characterfile.newLine();
            characterfile.write("character-saradomin = ", 0, 22);
            characterfile.write(Integer.toString(saraKills), 0, Integer.toString(saraKills).length());
            characterfile.newLine();
            characterfile.write("character-retaliate = ", 0, 22);
            characterfile.write(Integer.toString(autoRetaliate), 0, Integer.toString(autoRetaliate).length());
            characterfile.newLine();
            characterfile.write("character-action = ", 0, 19);
            characterfile.write(Integer.toString(action), 0, Integer.toString(action).length());
            characterfile.newLine();
            characterfile.write("character-pcpoints = ", 0, 21);
            characterfile.write(Integer.toString(pcPoints), 0, Integer.toString(pcPoints).length());
            characterfile.newLine();
            characterfile.write("character-assault = ", 0, 20);
            characterfile.write(Integer.toString(assaultKills), 0, Integer.toString(assaultKills).length());
            characterfile.newLine();
            characterfile.write("character-donator = ", 0, 20);
            characterfile.write(Integer.toString(donator), 0, Integer.toString(donator).length());
            characterfile.newLine();
            characterfile.write("character-bow = ", 0, 16);
            characterfile.write(Integer.toString(arrowsLeft), 0, Integer.toString(arrowsLeft).length());
            characterfile.newLine();
            characterfile.write("character-shield = ", 0, 19);
            characterfile.write(Integer.toString(shieldLeft), 0, Integer.toString(shieldLeft).length());
            characterfile.newLine();
            characterfile.newLine();
            /* EQUIPMENT */
            characterfile.write("[EQUIPMENT]", 0, 11);
            characterfile.newLine();
            for (int i = 0; i < playerEquipment.length; i++) {
                characterfile.write("character-equip = ", 0, 18);
                characterfile.write(Integer.toString(i), 0, Integer.toString(i)
                                    .length());
                characterfile.write("	", 0, 1);
                characterfile.write(Integer.toString(playerEquipment[i]), 0,
                                    Integer.toString(playerEquipment[i]).length());
                characterfile.write("	", 0, 1);
                characterfile.write(Integer.toString(playerEquipmentN[i]), 0,
                                    Integer.toString(playerEquipmentN[i]).length());
                characterfile.write("	", 0, 1);
                characterfile.newLine();
            }
            characterfile.newLine();
            /* LOOK */
            characterfile.write("[LOOK]", 0, 6);
            characterfile.newLine();
            int[] Looks = getLook();
            for (int i = 0; i < Looks.length; i++) {
                characterfile.write("character-look = ", 0, 17);
                characterfile.write(Integer.toString(i), 0, Integer.toString(i)
                                    .length());
                characterfile.write("	", 0, 1);
                characterfile.write(Integer.toString(Looks[i]), 0, Integer
                                    .toString(Looks[i]).length());
                characterfile.newLine();
            }
            characterfile.newLine();
            /* SKILLS */
            characterfile.write("[SKILLS]", 0, 8);
            characterfile.newLine();
            for (int i = 0; i < playerLevel.length; i++) {
                characterfile.write("character-skill = ", 0, 18);
                characterfile.write(Integer.toString(i), 0, Integer.toString(i)
                                    .length());
                characterfile.write("	", 0, 1);
                characterfile.write(Integer.toString(playerLevel[i]), 0,
                                    Integer.toString(playerLevel[i]).length());
                characterfile.write("	", 0, 1);
                characterfile.write(Integer.toString(playerXP[i]), 0, Integer
                                    .toString(playerXP[i]).length());
                characterfile.newLine();
            }
            characterfile.newLine();
            /* ITEMS */
            characterfile.write("[ITEMS]", 0, 7);
            characterfile.newLine();
            for (int i = 0; i < playerItems.length; i++) {
                if (playerItems[i] > 0) {
                    characterfile.write("character-item = ", 0, 17);
                    characterfile.write(Integer.toString(i), 0, Integer
                                        .toString(i).length());
                    characterfile.write("	", 0, 1);
                    characterfile.write(Integer.toString(playerItems[i]), 0,
                                        Integer.toString(playerItems[i]).length());
                    characterfile.write("	", 0, 1);
                    characterfile.write(Integer.toString(playerItemsN[i]), 0,
                                        Integer.toString(playerItemsN[i]).length());
                    characterfile.newLine();
                }
            }
            characterfile.newLine();
            /* BANK */
            characterfile.write("[BANK]", 0, 6);
            characterfile.newLine();
            for (int i = 0; i < bankItems.length; i++) {
                if (bankItems[i] > 0) {
                    characterfile.write("character-bank = ", 0, 17);
                    characterfile.write(Integer.toString(i), 0, Integer
                                        .toString(i).length());
                    characterfile.write("	", 0, 1);
                    characterfile.write(Integer.toString(bankItems[i]), 0,
                                        Integer.toString(bankItems[i]).length());
                    characterfile.write("	", 0, 1);
                    characterfile.write(Integer.toString(bankItemsN[i]), 0,
                                        Integer.toString(bankItemsN[i]).length());
                    characterfile.newLine();
                }
            }
            characterfile.newLine();
            /* FRIENDS */
            characterfile.write("[FRIENDS]", 0, 9);
            characterfile.newLine();
            for (int i = 0; i < friends.length; i++) {
                if (friends[i] > 0) {
                    characterfile.write("character-friend = ", 0, 19);
                    characterfile.write(Integer.toString(i), 0, Integer
                                        .toString(i).length());
                    characterfile.write("	", 0, 1);
                    characterfile.write(Long.toString(friends[i]), 0, Long
                                        .toString(friends[i]).length());
                    characterfile.newLine();
                }
            }
            characterfile.newLine();
            /* IGNORES */
            characterfile.write("[IGNORES]", 0, 9);
            characterfile.newLine();
            for (int i = 0; i < ignores.length; i++) {
                if (ignores[i] > 0) {
                    characterfile.write("character-ignore = ", 0, 19);
                    characterfile.write(Integer.toString(i), 0, Integer
                                        .toString(i).length());
                    characterfile.write("	", 0, 1);
                    characterfile.write(Long.toString(ignores[i]), 0, Long
                                        .toString(ignores[i]).length());
                    characterfile.newLine();
                }
            }
            characterfile.newLine();
            /* EOF */
            characterfile.write("[EOF]", 0, 5);
            characterfile.newLine();
            characterfile.newLine();
            characterfile.close();
        } catch (IOException ioexception) {
            misc.println(playerName + ": error writing file.");
        }
        saveNeeded = false;
    }


    /* Shops */
    public boolean sellItem(int itemID, int fromSlot, int amount) {
        if ((amount > 0) && playerRights != 2 && (itemID == (playerItems[fromSlot] - 1))) {
            if (server.shopHandler.ShopSModifier[MyShopID] > 1) {
                boolean IsIn = false;

                for (int i = 0; i <= server.shopHandler.ShopItemsStandard[MyShopID]; i++) {
                    if (itemID == (server.shopHandler.ShopItems[MyShopID][i] - 1)) {
                        IsIn = true;
                        break;
                    }
                }
                if (IsIn == false) {
                    sM("You cannot sell " + getItemName(itemID)
                       + " in this store.");
                    return false;
                }
            }
            if (Item.itemSellable[(playerItems[fromSlot] - 1)] == false) {
                sM("I cannot sell " + getItemName(itemID) + ".");
                return false;
            }
            if ((amount > playerItemsN[fromSlot])
                    && ((Item.itemIsNote[(playerItems[fromSlot] - 1)] == true) || (Item.itemStackable[(playerItems[fromSlot] - 1)] == true))) {
                amount = playerItemsN[fromSlot];
            } else if ((amount > GetXItemsInBag(itemID))
                       && (Item.itemIsNote[(playerItems[fromSlot] - 1)] == false)
                       && (Item.itemStackable[(playerItems[fromSlot] - 1)] == false)) {
                amount = GetXItemsInBag(itemID);
            }
            double ShopValue;
            double TotPrice;
            int TotPrice2;
            int Overstock;

            for (int i = amount; i > 0; i--) {
                TotPrice2 = (int) Math.floor(GetItemShopValue(itemID, 1,
                                             fromSlot));
                if (freeSlots() > 0) {
                    if (Item.itemIsNote[itemID] == false) {
                        deleteItem(itemID, GetItemSlot(itemID), 1);
                    } else {
                        deleteItem(itemID, fromSlot, 1);
                    }
                    addItem(995, TotPrice2);
                    addShopItem(itemID, 1);
                } else {
                    sM("Not enough space in your inventory.");
                    break;
                }
            }
            resetItems(3823);
            resetShop(MyShopID);
            UpdatePlayerShop();
            return true;
        }
        return true;
    }

    public void sendFrame126(String s, int id) {
        outStream.createFrameVarSizeWord(126);
        outStream.writeString(s);
        outStream.writeWordA(id);
        outStream.endFrameVarSizeWord();
        flushOutStream();
    }

    public void sendFrame164(int Frame) {
        outStream.createFrame(164);
        outStream.writeWordBigEndian_dup(Frame);
        flushOutStream();
    }

    public void sendFrame171(int MainFrame, int SubFrame) {
        outStream.createFrame(171);
        outStream.writeByte(MainFrame);
        outStream.writeWord(SubFrame);
        flushOutStream();
    }

    public void sendFrame185(int Frame) {
        outStream.createFrame(185);
        outStream.writeWordBigEndianA(Frame);
        flushOutStream();
    }

    public void sendFrame200(int MainFrame, int SubFrame) {
        outStream.createFrame(200);
        outStream.writeWord(MainFrame);
        outStream.writeWord(SubFrame);
        flushOutStream();
    }

    public void sendFrame246(int MainFrame, int SubFrame, int SubFrame2) {
        outStream.createFrame(246);
        outStream.writeWordBigEndian(MainFrame);
        outStream.writeWord(SubFrame);
        outStream.writeWord(SubFrame2);
        flushOutStream();
    }

    public void sendFrame248(int MainFrame, int SubFrame) {
        interfaceOpened = true;
        outStream.createFrame(248);
        outStream.writeWordA(MainFrame);
        outStream.writeWord(SubFrame);
        flushOutStream();
    }

    public void sendFrame75(int MainFrame, int SubFrame) {
        outStream.createFrame(75);
        outStream.writeWordBigEndianA(MainFrame);
        outStream.writeWordBigEndianA(SubFrame);
        flushOutStream();
    }

    // sends a game message of trade/duelrequests: "PlayerName:tradereq:" or
    // "PlayerName:duelreq:"
    public void sM(String s) {
        outStream.createFrameVarSize(253);
        outStream.writeString(s);
        outStream.endFrameVarSize();
    }

    public void sendpm(long name, int rights, byte[] chatmessage,
                       int messagesize) {
        outStream.createFrameVarSize(196);
        outStream.writeQWord(name);
        outStream.writeDWord(handler.lastchatid++); // must be different for
        // each message
        outStream.writeByte(rights);
        outStream.writeBytes(chatmessage, messagesize, 0);
        outStream.endFrameVarSize();
    }


    public void sendQuestSomething(int id) {
        outStream.createFrame(79);
        outStream.writeWordBigEndian(id);
        outStream.writeWordA(0);
        flushOutStream();
    }

    public void SendWeapon(int Weapon, String WeaponName) {
        String WeaponName2 = WeaponName.replaceAll("Bronze", "");

        WeaponName2 = WeaponName2.replaceAll("Iron", "");
        WeaponName2 = WeaponName2.replaceAll("Steel", "");
        WeaponName2 = WeaponName2.replaceAll("Scythe", "");
        WeaponName2 = WeaponName2.replaceAll("Black", "");
        WeaponName2 = WeaponName2.replaceAll("Mithril", "");
        WeaponName2 = WeaponName2.replaceAll("Adamant", "");
        WeaponName2 = WeaponName2.replaceAll("Rune", "");
        WeaponName2 = WeaponName2.replaceAll("Granite", "");
        WeaponName2 = WeaponName2.replaceAll("Dragon", "");
        WeaponName2 = WeaponName2.replaceAll("Crystal", "");
        WeaponName2 = WeaponName2.trim();
        if (WeaponName.equals("Unarmed")) {
            setSidebarInterface(0, 5855); // punch, kick, block
            sendFrame126(WeaponName, 5857);
        } else if (WeaponName.endsWith("whip")) {
            setSidebarInterface(0, 12290); // flick, lash, deflect
            sendFrame246(12291, 200, Weapon);
            sendFrame126(WeaponName, 12293);
        } else if (WeaponName.endsWith("Scythe")) {
            setSidebarInterface(0, 776); // flick, lash, deflect
            sendFrame246(12291, 200, Weapon);
            sendFrame126(WeaponName, 778);
        } else if (WeaponName.endsWith("bow") || WeaponName.startsWith("Crystal bow") || WeaponName.startsWith("Toktz-xil-ul")) {
            setSidebarInterface(0, 1764); // accurate, rapid, longrange
            sendFrame246(1765, 200, Weapon);
            sendFrame126(WeaponName, 1767);
        } else if (WeaponName.startsWith("Staff")
                   || WeaponName.endsWith("staff")) {
            setSidebarInterface(0, 328); // spike, impale, smash, block
            sendFrame246(329, 200, Weapon);
            sendFrame126(WeaponName, 331);

        } else if (WeaponName2.startsWith("dart")) {
            setSidebarInterface(0, 4446); // accurate, rapid, longrange
            sendFrame246(4447, 200, Weapon);
            sendFrame126(WeaponName, 4449);
        } else if (WeaponName2.startsWith("dagger")) {
            setSidebarInterface(0, 2276); // stab, lunge, slash, block
            sendFrame246(2277, 200, Weapon);
            sendFrame126(WeaponName, 2279);
        } else if (WeaponName2.startsWith("pickaxe")) {
            setSidebarInterface(0, 5570); // spike, impale, smash, block
            sendFrame246(5571, 200, Weapon);
            sendFrame126(WeaponName, 5573);
        } else if (WeaponName2.startsWith("axe")
                   || WeaponName2.startsWith("battleaxe")) {
            setSidebarInterface(0, 1698); // chop, hack, smash, block
            sendFrame246(1699, 200, Weapon);
            sendFrame126(WeaponName, 1701);
        } else if (WeaponName2.startsWith("Axe")
                   || WeaponName2.startsWith("Battleaxe")) {
            setSidebarInterface(0, 1698); // chop, hack, smash, block
            sendFrame246(1699, 200, Weapon);
            sendFrame126(WeaponName, 1701);
        } else if (WeaponName2.startsWith("halberd")) {
            setSidebarInterface(0, 8460); // jab, swipe, fend
            sendFrame246(8461, 200, Weapon);
            sendFrame126(WeaponName, 8463);
        } else if (WeaponName2.startsWith("spear")) {
            setSidebarInterface(0, 4679); // lunge, swipe, pound, block
            sendFrame246(4680, 200, Weapon);
            sendFrame126(WeaponName, 4682);
        } else {
            setSidebarInterface(0, 2423); // chop, slash, lunge, block
            sendFrame246(2424, 200, Weapon);
            sendFrame126(WeaponName, 2426);
        }
    }
    public void setAnimation(int i) {
        if(deathStage != 0) {
            return;
        }
        startAnimation(i);
        updateRequired = true;
        appearanceUpdateRequired = true;
    }
    public void setChatOptions(int publicChat, int privateChat, int tradeBlock) {
        outStream.createFrame(206);
        outStream.writeByte(publicChat); // On = 0, Friends = 1, Off = 2,
        // Hide = 3
        outStream.writeByte(privateChat); // On = 0, Friends = 1, Off = 2
        outStream.writeByte(tradeBlock); // On = 0, Friends = 1, Off = 2
    }

    public void setClientConfig(int id, int state) {
        outStream.createFrame(36);
        outStream.writeWordBigEndian(id);
        outStream.writeByte(state);
    }

    public void setEquipment(int wearID, int amount, int targetSlot) {
        int Stat = playerDefence;

        if (targetSlot == playerWeapon) {
            Stat = playerAttack;
        }
        outStream.createFrameVarSizeWord(34);
        outStream.writeWord(1688);
        outStream.writeByte(targetSlot);
        outStream.writeWord((wearID + 1));
        if (amount > 254) {
            outStream.writeByte(255);
            outStream.writeDWord(amount);
        } else {
            outStream.writeByte(amount); // amount
        }
        outStream.endFrameVarSizeWord();

        if ((targetSlot == playerWeapon) && (wearID >= 0)) {
            SendWeapon(wearID, getItemName(wearID));
            playerSE = Equipemotes.GetStandAnim(wearID);
            playerSEW = Equipemotes.GetWalkAnim(wearID);
            playerSER = Equipemotes.GetRunAnim(wearID);
            playerSEA = 0x326;
        }
        pEmote = playerSE;
        updateRequired = true;
        appearanceUpdateRequired = true;
    }

    public void setInterfaceWalkable(int ID) {
        outStream.createFrame(208);
        outStream.writeWordBigEndian_dup(ID);
        flushOutStream();
    }

    public void setLook(int[] parts) {
        if (parts.length != 19) {
            println("setLook:  Invalid array length!");
            return;
        }
        pGender = parts[0];
        pHead = parts[1];
        pBeard = parts[2];
        pTorso = parts[3];
        pArms = parts[4];
        pHands = parts[5];
        pLegs = parts[6];
        pFeet = parts[7];
        pHairC = parts[8];
        pTorsoC = parts[9];
        pLegsC = parts[10];
        pFeetC = parts[11];
        pSkinC = parts[12];
        playerLook[0] = parts[13];
        playerLook[1] = parts[14];
        playerLook[2] = parts[15];
        playerLook[3] = parts[16];
        playerLook[4] = parts[17];
        playerLook[5] = parts[18];
        apset = true;
        appearanceUpdateRequired = true;
        lookUpdate = true;
        updateRequired = true;
    }

    public void setSidebarInterface(int menuId, int form) {
        outStream.createFrame(71);
        outStream.writeWord(form);
        outStream.writeByteA(menuId);
    }

    public void setSkillLevel(int skillNum, int currentLevel, int XP) {
        if (skillNum == 0) {
            sendQuest("" + playerLevel[0] + "", 4004);
            sendQuest("" + getLevelForXP(playerXP[0]) + "", 4005);
        }
        if (skillNum == 2) {
            sendQuest("" + playerLevel[2] + "", 4006);
            sendQuest("" + getLevelForXP(playerXP[2]) + "", 4007);
        }
        if (skillNum == 1) {
            sendQuest("" + playerLevel[1] + "", 4008);
            sendQuest("" + getLevelForXP(playerXP[1]) + "", 4009);
        }
        if (skillNum == 4) {
            sendQuest("" + playerLevel[4] + "", 4010);
            sendQuest("" + getLevelForXP(playerXP[4]) + "", 4011);
        }
        if (skillNum == 5) {
            sendQuest("" + playerLevel[5] + "", 4012);
            sendQuest("" + getLevelForXP(playerXP[5]) + "", 4013);
        }
        if (skillNum == 6) {
            sendQuest("" + playerLevel[6] + "", 4014);
            sendQuest("" + getLevelForXP(playerXP[6]) + "", 4015);
        }
        if (skillNum == 3) {
            sendQuest("" + currentHealth + "", 4016);
            sendQuest("" + getLevelForXP(playerXP[3]) + "", 4017);
        }
        if (skillNum == 16) {
            sendQuest("" + playerLevel[16] + "", 4018);
            sendQuest("" + getLevelForXP(playerXP[16]) + "", 4019);
        }
        if (skillNum == 15) {
            sendQuest("" + playerLevel[15] + "", 4020);
            sendQuest("" + getLevelForXP(playerXP[15]) + "", 4021);
        }
        if (skillNum == 17) {
            sendQuest("" + playerLevel[17] + "", 4022);
            sendQuest("" + getLevelForXP(playerXP[17]) + "", 4023);
        }
        if (skillNum == 12) {
            sendQuest("" + playerLevel[12] + "", 4024);
            sendQuest("" + getLevelForXP(playerXP[12]) + "", 4025);
        }
        if (skillNum == 9) {
            sendQuest("" + playerLevel[9] + "", 4026);
            sendQuest("" + getLevelForXP(playerXP[9]) + "", 4027);
        }
        if (skillNum == 14) {
            sendQuest("" + playerLevel[14] + "", 4028);
            sendQuest("" + getLevelForXP(playerXP[14]) + "", 4029);
        }
        if (skillNum == 13) {
            sendQuest("" + playerLevel[13] + "", 4030);
            sendQuest("" + getLevelForXP(playerXP[13]) + "", 4031);
        }
        if (skillNum == 10) {
            sendQuest("" + playerLevel[10] + "", 4032);
            sendQuest("" + getLevelForXP(playerXP[10]) + "", 4033);
        }
        if (skillNum == 7) {
            sendQuest("" + playerLevel[7] + "", 4034);
            sendQuest("" + getLevelForXP(playerXP[7]) + "", 4035);
        }
        if (skillNum == 11) {
            sendQuest("" + playerLevel[11] + "", 4036);
            sendQuest("" + getLevelForXP(playerXP[11]) + "", 4037);
        }
        if (skillNum == 8) {
            sendQuest("" + playerLevel[8] + "", 4038);
            sendQuest("" + getLevelForXP(playerXP[8]) + "", 4039);
        }
        if (skillNum == 20) {
            sendQuest("" + playerLevel[20] + "", 4152);
            sendQuest("" + getLevelForXP(playerXP[20]) + "", 4153);
        }
        if (skillNum == 18) {
            sendQuest("" + playerLevel[18] + "", 12166);
            sendQuest("" + getLevelForXP(playerXP[18]) + "", 12167);
        }
        if (skillNum == 19) {
            sendQuest("" + playerLevel[19] + "", 13926);
            sendQuest("" + getLevelForXP(playerXP[19]) + "", 13927);
        } else {
            outStream.createFrame(134);
            outStream.writeByte(skillNum);
            outStream.writeDWord_v1(XP);
            outStream.writeByte(currentLevel);
        }
    }

    public void shaft() {
        closeInterface();
        if (playerHasItem(1511)) {
            if (playerHasItem(-1)) {
                deleteItem(1511, 1);
                addItem(52, 15);
                addSkillXP(150, playerFletching);
            } else {
                sM("Not enough space in your inventory.");
                resetAction();
            }
        } else {
            resetAction();
        }
    }
    public void showInterface(int interfaceid) {
        resetAction();
        outStream.createFrame(97);
        outStream.writeWord(interfaceid);
        flushOutStream();
        interfaceOpened = true;
    }
    public void shutdownError(String errorMessage) {
        // misc.println(": " + errorMessage);
        destruct();
    }


    /*
     * [0] Varrock [1] Wizard Tower [2] Ardougne [3] Magic Guild
     */
    public void startCraft(int actionbutton) {
        closeInterface();
        int[] buttons = { 33187, 33186, 33185, 33190, 33189, 33188, 33193,
                          33192, 33191, 33196, 33195, 33194, 33199, 33198, 33197, 33202,
                          33201, 33200, 33205, 33204, 33203
                        };
        int[] amounts = { 1, 5, 10, 1, 5, 10, 1, 5, 10, 1, 5, 10, 1, 5, 10, 1,
                          5, 10, 1, 5, 10
                        };
        int[] ids = { 1129, 1129, 1129, 1059, 1059, 1059, 1061, 1061, 1061,
                      1063, 1063, 1063, 1095, 1095, 1095, 1169, 1169, 1169, 1167,
                      1167, 1167
                    };
        int[] levels = { 14, 1, 7, 11, 18, 38, 9 };
        int[] exp = { 27, 14, 16, 22, 27, 37, 19 };
        int amount = 0, id = -1;
        int index = 0;
        for (int i = 0; i < buttons.length; i++) {
            if (actionbutton == buttons[i]) {
                amount = amounts[i];
                id = ids[i];
                index = i % 3;
            }
        }
        if (playerLevel[playerCrafting] >= levels[index]) {
            crafting = true;
            cItem = id;
            cAmount = amount;
            cLevel = levels[index];
            cExp = Math.round(exp[index] * 9);
            cSelected = 1741;
        } else {
            sM("Requires level " + levels[index]);
        }
    }



    public void stillgfx(int id, int y, int x) {
        stillgfx(id, y, x, 0, 0);
    }

    public void stillgfx(int id, int Y, int X, int height, int time) {
        // for (Player p : server.playerHandler.players) {
        for (Player p : server.playerHandler.players) {
            if (p != null) {
                client person = (client) p;

                if (person.playerName != null) {
                    if (person.distanceToPoint(X, Y) <= 60 && person.heightLevel == heightLevel) {
                        person.stillgfx2(id, Y, X, height, time);
                    }
                }
            }
        }
    }

    public void stillgfx2(int id, int Y, int X, int height, int time) {
        outStream.createFrame(85);
        outStream.writeByteC(Y - (mapRegionY * 8));
        outStream.writeByteC(X - (mapRegionX * 8));
        outStream.createFrame(4);
        outStream.writeByte(0); // Tiles away (X >> 4 + Y & 7)
        outStream.writeWord(id); // Graphic id
        outStream.writeByte(height); // height of the spell above it's basic
        // place, i think it's written in pixels
        // 100 pixels higher
        outStream.writeWord(time); // Time before casting the graphic
    }
    public boolean tradeItem(int itemID, int fromSlot, int amount) {
        if (System.currentTimeMillis() - lastButton > 400) {
            lastButton = System.currentTimeMillis();
        } else {
            return false;
        }
        if (!Item.itemStackable[itemID] && (amount > 1)) {
            for (int a = 1; a <= amount; a++) {
                int slot = findItem(itemID, playerItems, playerItemsN);
                if (slot >= 0) {
                    tradeItem(itemID, slot, 1);
                }
            }
        }
        for (int element : noTrade) {
            if ((itemID == element) || (itemID == element + 1)) {
                sM("You can't trade that item");
                return false;
            }
        }
        client other = getClient(trade_reqId);
        if (!inTrade || !validClient(trade_reqId) || !canOffer) {
            declineTrade();
            return false;
        }
        if (!playerHasItem(itemID, amount)) {
            return false;
        }
        if (itemID != playerItems[fromSlot] - 1) {
            return false;
        }
        if (Item.itemStackable[itemID] || Item.itemIsNote[itemID]) {
            boolean inTrade = false;
            for (GameItem item : offeredItems) {
                if (item.id == itemID) {
                    inTrade = true;
                    item.amount += amount;
                    break;
                }
            }
            if (!inTrade) {
                offeredItems.add(new GameItem(itemID, amount));
            }
        } else {
            offeredItems.add(new GameItem(itemID, 1));
        }
        deleteItem(itemID, fromSlot, amount);
        resetItems(3322);
        resetTItems(3415);
        other.resetOTItems(3416);
        sendFrame126("", 3431);
        other.sendFrame126("", 3431);
        return true;
    }


    public void tradeReq(int id) {
        if (!server.trading) {
            sM("Trading has been temporarily disabled");
            return;
        }
        client other = (client) handler.players[id];
        if (validClient(trade_reqId)) {
            if (other.inTrade) {
                sM("Other player is busy at the moment.");
                trade_reqId = 0;
                return;
            }
        }
        if(other.interfaceOpened) {
            int EnemyX = PlayerHandler.players[trade_reqId].absX;
            int EnemyY = PlayerHandler.players[trade_reqId].absY;
            TurnPlayerTo(EnemyX, EnemyY);
            sM("Other player is busy at the moment.");
            return;
        }
        if(action == 1) {
            return;
        }
        if(other.playerName.equalsIgnoreCase(playerName)) {
            sM("Other player is busy at the moment.");
            return;
        }
        if(other.action == 1) {
            return;
        }


        if (validClient(trade_reqId) && !inTrade && other.tradeRequested
                && (other.trade_reqId == playerId)) {
            openTrade();
            other.openTrade();
            int EnemyX = PlayerHandler.players[trade_reqId].absX;
            int EnemyY = PlayerHandler.players[trade_reqId].absY;
            TurnPlayerTo(EnemyX, EnemyY);
        } else if (validClient(trade_reqId) && !inTrade
                   && (System.currentTimeMillis() - lastButton > 1000)) {
            lastButton = System.currentTimeMillis();
            tradeRequested = true;
            trade_reqId = id;
            int EnemyX = PlayerHandler.players[trade_reqId].absX;
            int EnemyY = PlayerHandler.players[trade_reqId].absY;
            TurnPlayerTo(EnemyX, EnemyY);
            sM("Sending trade request...");
            other.sM(playerName + ":tradereq:");
        }
    }

    public void specialAtk(boolean hitTwice, int specDrain, int projectileHit, int emoteSet) {
        client AttackingOn2 = (client) server.playerHandler.players[AttackingOn];
        int EnemyX = PlayerHandler.players[AttackingOn].absX;
        int EnemyY = PlayerHandler.players[AttackingOn].absY;
        if(isInWilderness(EnemyX, EnemyY, 1) == false && !AttackingOn2.isInPitGame()) {
            return;
        }
        if(isInWilderness(absX, absY, 1) == false && !isInPitGame()) {
            return;
        }
        if(hitTwice && playerEquipment[playerWeapon] != 4153 && playerEquipment[playerWeapon] != 4827 && playerEquipment[playerWeapon] != 861) {
            DDS2Damg = true;
            ddsInterval = 1000;
            lastDds = System.currentTimeMillis();
        }
        if(hitTwice && playerEquipment[playerWeapon] == 4153) {
            DDS2Damg = true;
            ddsInterval = 0;
            lastDds = System.currentTimeMillis();
        }
        if(hitTwice && playerEquipment[playerWeapon] == 4827) {
            DDS2Damg2 = true;
            ddsInterval = 1000;
            lastDds = System.currentTimeMillis();
        }
        if(hitTwice && playerEquipment[playerWeapon] == 861) {
            DDS2Damg2 = true;
            ddsInterval = 1000;
            lastDds = System.currentTimeMillis();
        }
        if(!hitTwice) {
            DDS2Damg = false;
            DDS2Damg2 = false;
        }
        if(playerEquipment[playerWeapon] == 5698 && misc.random(5)==1 && AttackingOn2.poisoned == false && AttackingOn2.deathStage == 0) {
            AttackingOn2.sM("You have been poisoned!");
            AttackingOn2.poisoned = true;
        }
        lastSpecial = System.currentTimeMillis();
        setAnimation(emoteSet);
        specOn = false;
        specialAmount -= specDrain;
        specGFX(projectileHit);
        actionInterval = getbattleTimer();
        lastAction = System.currentTimeMillis();
    }
    public void specialAtkNPC(boolean hitTwice, int specDrain, int projectileHit, int emoteSet) {
        if(hitTwice && playerEquipment[playerWeapon] != 4153 && playerEquipment[playerWeapon] != 4827 && playerEquipment[playerWeapon] != 861) {
            DDS2Damg = true;
            ddsInterval = 1000;
            lastDds = System.currentTimeMillis();
        }
        if(hitTwice && playerEquipment[playerWeapon] == 4153) {
            DDS2Damg = true;
            ddsInterval = 0;
            lastDds = System.currentTimeMillis();
        }
        if(hitTwice && playerEquipment[playerWeapon] == 4827) {
            DDS2Damg2 = true;
            ddsInterval = 1000;
            lastDds = System.currentTimeMillis();
        }
        if(hitTwice && playerEquipment[playerWeapon] == 861) {
            DDS2Damg2 = true;
            ddsInterval = 1000;
            lastDds = System.currentTimeMillis();
        }
        if(!hitTwice) {
            DDS2Damg = false;
        }
        lastSpecial = System.currentTimeMillis();
        specOn = false;
        specialAmount -= specDrain;
        specGFX(projectileHit);
        actionInterval = getbattleTimer();
        lastAction = System.currentTimeMillis();
        setAnimation(emoteSet);
    }
    public void triggerRandom() {
        if (!randomed) {
            random_skill = misc.random(statName.length) - 1;
            if (random_skill < 0)
                random_skill = 0;
            sendQuest("Click the @or1@" + statName[random_skill]
                      + " @yel@button", 2810);
            sendQuest("", 2811);
            sendQuest("", 2831);
            randomed = true;
            showInterface(2808);
        }
    }

    public void triggerTele(int x, int y, int height) {


        if (System.currentTimeMillis() - lastAction > 5000) {
            lastAction = System.currentTimeMillis();
            resetWalkingQueue();
            if(wildyLevel > 20 && isInWilderness(absX, absY, 1)) {
                sM("You cannot teleport above level 20 wilderness!");
                return;
            }



            if(System.currentTimeMillis() - lastTeleblock < 300000) {
                sM("You are teleblocked!");
                return;
            }
            tX = x;
            tY = y;
            tH = height;
            if(playerAncientMagics == 2) {
                tStage = 3;
                tTime2 = 0;
                setSidebarInterface(6, 18787);
            }
            if(playerAncientMagics == 1) {
                tStage = 1;
                tTime = 0;
                setSidebarInterface(6, 12855);
            }
            if(playerAncientMagics == 0) {
                tStage = 3;
                tTime2 = 0;
                setSidebarInterface(6, 1151);
            }
            followID = 0;
            followID2 = 0;
            ResetAttack();
            ResetAttackNPC();
        }
    }
    public void triggerTele2(int x, int y, int height) {
        if (System.currentTimeMillis() - lastAction > 5000) {
            lastAction = System.currentTimeMillis();
            resetWalkingQueue();


            if(System.currentTimeMillis() - lastTeleblock < 300000) {
                sM("You are teleblocked!");
                return;
            }
            tX = x;
            tY = y;
            tH = height;
            if(action == 1) {
                return;
            }

            if(playerAncientMagics == 2) {
                tStage = 3;
                tTime2 = 0;
                setSidebarInterface(6, 18787);
            }
            if(playerAncientMagics == 1) {
                tStage = 1;
                tTime = 0;
                setSidebarInterface(6, 12855);
            }
            if(playerAncientMagics == 0) {
                tStage = 3;
                tTime2 = 0;
                setSidebarInterface(6, 1151);
            }
            followID = 0;
            followID2 = 0;
            ResetAttack();
            ResetAttackNPC();

        }
    }


    public void update() {
        handler.updatePlayer(this, outStream);
        handler.updateNPC(this, outStream);
        flushOutStream();
    }

    public void updateCharAppearance(int[] styles, int[] colors) {
        for (int j = 0; j < 7; j++) {
            if (styles[j] > 0) {
                styles[j] += 0x100;
                pCHead = styles[0];
                pCBeard = styles[1];
                pCTorso = styles[2];
                pCArms = styles[3];
                pCHands = styles[4];
                pCLegs = styles[5];
                pCFeet = styles[6];
            }
        }
        for (int i = 0; i < 5; i++) {
            pColor = colors[i];
        }
    }

    public void UpdatePlayerShop() {
        for (int i = 1; i < PlayerHandler.maxPlayers; i++) {
            if (PlayerHandler.players[i] != null) {
                if ((PlayerHandler.players[i].IsShopping == true)
                        && (PlayerHandler.players[i].MyShopID == MyShopID)
                        && (i != playerId)) {
                    PlayerHandler.players[i].UpdateShop = true;
                }
            }
        }
    }

    public boolean validClient(int index) {
        client p = (client) handler.players[index];
        if ((p != null) && !p.disconnected) {
            return true;
        }
        return false;
    }

    public void viewTo(int coordX, int coordY) {
        viewToX = ((2 * coordX) + 1);
        viewToY = ((2 * coordY) + 1);
        dirUpdate2Required = true;
        updateRequired = true;
    }


    public int WCCheckAxe() {
        int Hand;
        int Shield;
        int Bag;
        int Axe;

        Hand = playerEquipment[playerWeapon];
        Shield = playerEquipment[playerShield];
        Axe = 0;
        switch (Hand) {
        case 1351:
            // Bronze Axe
            Axe = 1;
            break;

        case 1349:
            // Iron Axe
            Axe = 2;
            break;

        case 1353:
            // Steel Axe
            Axe = 3;
            break;

        case 1361:
            // Black Axe
            Axe = 4;
            break;

        case 1355:
            // Mithril Axe
            Axe = 5;
            break;

        case 1357:
            // Adamant Axe
            Axe = 6;
            break;


        case 1359:
            // Rune Axe
            Axe = 7;
            break;

        case 6739:
            // dragon Axe
            Axe = 8;
            break;

            /*
             * case X: //Dragon Axe Axe = 8; break;
             */
        }
        /*
         * if (Axe > 0) { OriginalWeapon = Hand; OriginalShield = Shield;
         * playerEquipment[playerShield] = -1; return Axe; }
         */
        if (Axe > 0) {
            // OriginalWeapon = Hand;
            // OriginalShield = Shield;
            // playerEquipment[playerShield] = -1;
            // playerEquipment[playerWeapon] = Bag;
        }
        return Axe;
    }

    public void fillSmallPouch()
    {
        int essence = amountOfItem(1436);
        if (!playerHasItem(1436))
        {
            sM("You do not have any rune essence to fill.");
            return;
        }
        if (essence < 3)
        {
            sM("You do not have 3 rune essence to put in this pouch.");
            return;
        }
        if (essence >= 3 && (smallPouch == 0))
        {
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            smallPouch += 3;
        }
        if (smallPouch == 3)
        {
            sM("Your pouch is full.");
            return;
        }
    }

    public void fillMediumPouch()
    {
        int essence = amountOfItem(1436);
        if (!playerHasItem(1436))
        {
            sM("You do not have any rune essence to fill.");
            return;
        }
        if (essence < 6)
        {
            sM("You do not have 6 rune essence to put in this pouch.");
            return;
        }
        if (essence >= 6 && (mediumPouch == 0))
        {
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            mediumPouch += 6;
            return;
        }
        if (mediumPouch == 6)
        {
            sM("Your pouch is full.");
            return;
        }
    }

    public void fillLargePouch()
    {
        int essence = amountOfItem(1436);
        if (!playerHasItem(1436))
        {
            sM("You do not have any rune essence to fill.");
            return;
        }
        if (essence < 9)
        {
            sM("You do not have 9 rune essence to put in this pouch.");
            return;
        }
        if (essence >= 9 && (largePouch == 0))
        {
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            largePouch += 9;
            return;
        }
        if (largePouch == 9)
        {
            sM("Your pouch is full.");
            return;
        }
    }

    public void fillGiantPouch()
    {
        int essence = amountOfItem(1436);
        if (!playerHasItem(1436))
        {
            sM("You do not have any rune essence to fill.");
            return;
        }
        if (essence < 12)
        {
            sM("You do not have 12 rune essence to put in this pouch.");
            return;
        }
        if (essence >= 12 && (giantPouch == 0))
        {
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            deleteItem(1436, 1);
            giantPouch += 12;
            return;
        }
        if (giantPouch == 12)
        {
            sM("Your pouch is full.");
            return;
        }
    }

    public void emptySmallPouch()
    {
        if (smallPouch < 3)
        {
            sM("You do not have 3 rune essence.");
            return;
        }
        if (freeSlots() < 3)
        {
            sM("You need at least 3 free slots before emptying your pouch.");
            return;
        }
        if (smallPouch == 3 && freeSlots() >= 3)
        {
            smallPouch -= 3;
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
        }
    }

    public void emptyMediumPouch()
    {
        if (mediumPouch < 6)
        {
            sM("You do not have 6 rune essence.");
            return;
        }
        if (freeSlots() < 6)
        {
            sM("You need at least 6 free slots before emptying your pouch.");
            return;
        }
        if (mediumPouch == 6 && freeSlots() >= 6)
        {
            mediumPouch -= 6;
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
        }
    }

    public void emptyLargePouch()
    {
        if (largePouch < 9)
        {
            sM("You do not have 9 rune essence.");
            return;
        }
        if (freeSlots() < 9)
        {
            sM("You need at least 9 free slots before emptying your pouch.");
            return;
        }
        if (largePouch == 9 && freeSlots() >= 9)
        {
            largePouch -= 9;
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
        }
    }

    public void emptyGiantPouch()
    {
        if (giantPouch < 12)
        {
            sM("You do not have 12 rune essence.");
            return;
        }
        if (freeSlots() < 12)
        {
            sM("You need at least 12 free slots before emptying your pouch.");
            return;
        }
        if (giantPouch == 12 && freeSlots() >= 12)
        {
            giantPouch -= 12;
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
            addItem(1436, 1);
        }
    }

    public boolean wear(int wearID, int slot) {
        if(wearID == 5509) {
            emptySmallPouch();
            return false;
        }
        if(wearID == 5510) {
            emptyMediumPouch();
            return false;
        }
        if(wearID == 5512) {
            emptyLargePouch();
            return false;
        }
        if(wearID == 5514) {
            emptyGiantPouch();
            return false;
        }
        if(wearID == 6570 && killedJad == 0) {
            sM("You must have defeated TzTok-Jad to wear this cape.");
            return false;
        }
        if(wearID == 4084 && playerRights != 3)
            return false;
        if(wearID == 1052 && q7 != 15) {
            sM("You must complete Legends Quest to equip this.");
            return false;
        }
        if(wearID == 4035 && q5 == 3) {
            triggerTele(2650, 4565, 1);
        }
        if(wearID == 4031 && q5 == 3) {
            npcId = 1463;
            npcId2 = npcId;
            isNpc = true;
            specGFX(160);
        }
        if(wearID == 3753 && q8 != 15) {
            sM("You must complete Lunar Diplomacy to equip this.");
            return false;
        }
        if(wearID == 4587 && q5 != 15) {
            sM("You must complete Monkey Madness to equip this.");
            return false;
        }
        if(wearID == 1305 && q1 != 15 || wearID == 5698 && q1 != 15) {
            sM("You must complete Lost City to equip this.");
            return false;
        }
        if(isInCity()==true && wearID != 1351) {
            sM("You can't equip anything but a bronze axe down here!");
            return false;
        }
        if(wearID == 714) {
            return false;
        }
        if(wearID == 4151 && FightType == 2) {
            FightType = 3;
            SkillID = 3;
        }

        int targetSlot = 0;
        targetSlot = itemType(wearID);
        int[] two_hand = {841, 6609, 1319, 4718, 4726, 1409, 4710, 7158, 8100, 3204, 4755, 4153, 4827,667,35,2402,746, 6528,843,845,849,847,853,851,859,861, 4734,4214,4215,4216,4217,4218,4219,4220,4221,4222,4223, 4747 };
        for (int element : two_hand) {
            if ((wearID == element) && (playerEquipment[playerShield] > 0)) {
                if (playerHasItem(-1)) {
                    addItem(playerEquipment[playerShield], 1);
                    playerEquipment[playerShield] = -1;
                    playerEquipmentN[playerShield] = 0;
                    setEquipment(-1, 0, playerShield);
                } else {
                    sM("Not enough space in your inventory.");
                    return false;
                }
            }
            if ((itemType(wearID) == playerShield)
                    && (playerEquipment[playerWeapon] == element)) {
                if (playerHasItem(-1)) {
                    addItem(playerEquipment[playerWeapon], 1);
                    playerEquipment[playerWeapon] = -1;
                    playerEquipmentN[playerWeapon] = 0;
                    setEquipment(-1, 0, playerWeapon);
                } else {
                    sM("Not enough space in your inventory.");
                    return false;
                }
            }
        }
        //server.checkPlayerCapes.processAll(this);
        if ((playerItems[slot]-1) == wearID) {
            targetSlot = itemType(wearID);
            int CLAttack = server.Wearing.GetCLAttack(wearID);
            int CLDefence = server.Wearing.GetCLDefence(wearID);
            int CLStrength = server.Wearing.GetCLStrength(wearID);
            int CLMagic = server.Wearing.GetCLMagic(wearID);
            int CLRanged = server.Wearing.GetCLRanged(wearID);
            int CLCrafting = server.Wearing.GetCLCrafting(wearID);
            int CLHitpoints = server.Wearing.GetCLHitpoints(wearID);
            int CLAgility = server.Wearing.GetCLAgility(wearID);
            int CLPrayer = server.Wearing.GetCLPrayer(wearID);
            int CLSlayer = server.Wearing.GetCLSlayer(wearID);
            int CLMining = server.Wearing.GetCLMining(wearID);
            int CLFishing = server.Wearing.GetCLFishing(wearID);
            int CLCooking = server.Wearing.GetCLCooking(wearID);
            int CLFarming = server.Wearing.GetCLFarming(wearID);
            int CLFletching = server.Wearing.GetCLFletching(wearID);
            int CLFiremaking = server.Wearing.GetCLFiremaking(wearID);
            int CLSmithing = server.Wearing.GetCLSmithing(wearID);
            int CLHerblore = server.Wearing.GetCLHerblore(wearID);
            int CLWoodcutting = server.Wearing.GetCLWoodcutting(wearID);
            int CLThieving = server.Wearing.GetCLThieving(wearID);
            int CLRunecrafting = server.Wearing.GetCLRunecrafting(wearID);
            boolean GoFalse = false;
            if (targetSlot == playerWeapon) {
                if (playerEquipment[playerWeapon] == 4031 && q5 == 3) {
                    isNpc = false;
                    specGFX(160);
                }
            }
            if(wearID == 4363) {
                GoFalse = true;
            }
            if (CLAttack > getLevelForXP(playerXP[0])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have an "+statName[playerAttack]+" level of "+CLAttack+".");
                GoFalse = true;
            }
            if (CLHitpoints > getLevelForXP(playerXP[3])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerHitpoints]+" level of "+CLHitpoints+".");
                GoFalse = true;
            }
            if (CLDefence > getLevelForXP(playerXP[1])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerDefence]+" level of "+CLDefence+".");
                GoFalse = true;
            }
            if (CLStrength > getLevelForXP(playerXP[2])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerStrength]+" level of "+CLStrength+".");
                GoFalse = true;
            }
            if (CLMagic > getLevelForXP(playerXP[6])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerMagic]+" level of "+CLMagic+".");
                GoFalse = true;
            }
            if (CLRanged > getLevelForXP(playerXP[4])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerRanged]+" level of "+CLRanged+".");
                GoFalse = true;
            }
            if (CLHerblore > getLevelForXP(playerXP[15])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerHerblore]+" level of "+CLHerblore+".");
                GoFalse = true;
            }
            if (CLThieving > getLevelForXP(playerXP[17])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerThieving]+" level of "+CLThieving+".");
                GoFalse = true;
            }
            if (CLSmithing > getLevelForXP(playerXP[13])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerSmithing]+" level of "+CLSmithing+".");
                GoFalse = true;
            }
            if (CLFarming > getLevelForXP(playerXP[19])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerFarming]+" level of "+CLFarming+".");
                GoFalse = true;
            }
            if (CLFletching > getLevelForXP(playerXP[9])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have an "+statName[playerFletching]+" level of "+CLFletching+".");
                GoFalse = true;
            }
            if (CLFiremaking > getLevelForXP(playerXP[11])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerFiremaking]+" level of "+CLFiremaking+".");
                GoFalse = true;
            }
            if (CLCooking > getLevelForXP(playerXP[7])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerCooking]+" level of "+CLCooking+".");
                GoFalse = true;
            }
            if (CLFishing > getLevelForXP(playerXP[10])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerFishing]+" level of "+CLFishing+".");
                GoFalse = true;
            }
            if (CLRunecrafting > getLevelForXP(playerXP[20])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerRunecrafting]+" level of "+CLRunecrafting+".");
                GoFalse = true;
            }
            if (CLWoodcutting > getLevelForXP(playerXP[8])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerWoodcutting]+" level of "+CLWoodcutting+".");
                GoFalse = true;
            }
            if (CLMining > getLevelForXP(playerXP[14])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerMining]+" level of "+CLMining+".");
                GoFalse = true;
            }
            if (CLSlayer > getLevelForXP(playerXP[18])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerSlayer]+" level of "+CLSlayer+".");
                GoFalse = true;
            }
            if (CLPrayer > getLevelForXP(playerXP[5])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerPrayer]+" level of "+CLPrayer+".");
                GoFalse = true;
            }
            if (CLAgility > getLevelForXP(playerXP[16])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have an "+statName[playerAgility]+" level of "+CLAgility+".");
                GoFalse = true;
            }
            if (CLCrafting > getLevelForXP(playerXP[12])) {
                sM("You are not a high enough level to use this item.");
                sM("You need to have a "+statName[playerCrafting]+" level of "+CLCrafting+".");
                GoFalse = true;
            }
            if (GoFalse == true) {
                return false;
            }
            int wearAmount = playerItemsN[slot];
            server.special.needSpecial(this, wearID, targetSlot);
            if (wearAmount < 1) {
                return false;
            }
            if ((slot >= 0) && (wearID >= 0)) {
                deleteItem(wearID, slot, wearAmount);
                if ((playerEquipment[targetSlot] != wearID)
                        && (playerEquipment[targetSlot] >= 0)) {
                    addItem(playerEquipment[targetSlot],
                            playerEquipmentN[targetSlot]);
                } else if (Item.itemStackable[wearID]
                           && (playerEquipment[targetSlot] == wearID)) {
                    wearAmount = playerEquipmentN[targetSlot] + wearAmount;
                } else if (playerEquipment[targetSlot] >= 0) {
                    addItem(playerEquipment[targetSlot],
                            playerEquipmentN[targetSlot]);
                }
            }
            outStream.createFrameVarSizeWord(34);
            outStream.writeWord(1688);
            outStream.writeByte(targetSlot);
            outStream.writeWord(wearID + 1);
            if (wearAmount > 254) {
                outStream.writeByte(255);
                outStream.writeDWord(wearAmount);
            } else {
                outStream.writeByte(wearAmount); // amount
            }
            outStream.endFrameVarSizeWord();
            playerEquipment[targetSlot] = wearID;
            playerEquipmentN[targetSlot] = wearAmount;
            for (int element : two_hand) {
                if ((targetSlot == playerWeapon)
                        && (playerEquipment[playerShield] != -1)
                        && (Item.itemTwoHanded[wearID] == true) && wearID == element) {
                    remove(playerEquipment[playerShield], playerShield);
                }
            }
            if (targetSlot == playerWeapon) {
                autocasting = false;
                autocastID = 0;
                setClientConfig(108, 0);
                SendWeapon(wearID, getItemName(wearID));
                playerSE = Equipemotes.GetStandAnim(wearID);
                playerSEW = Equipemotes.GetWalkAnim(wearID);
                playerSER = Equipemotes.GetRunAnim(wearID);
                playerSEA = 0x326;
                pEmote = playerSE;
                specOn = false;
                specAttack();
            }
            ResetBonus();
            GetBonus();
            wearing = false;
            WriteBonus();
            updateRequired = true;
            appearanceUpdateRequired = true;
            return true;
        }
        return false;
    }

    /* WOODCUTTING */

    public void WriteLog2(String data, String file) {
        // used for bans/mutes/chatlogs etc. -bakatool
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("hiscores/" + file + ".txt",
                                                   true));
            bw.write(data);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException ioe2) {
                    System.out.println("Error writing system log.");
                    ioe2.printStackTrace();
                }
        }
    }
    public void writeLog(String data, String file) {
        // used for bans/mutes/chatlogs etc. -bakatool
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("config//" + file + ".txt",
                                                   true));
            bw.write(data);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException ioe2) {
                    System.out.println("Error writing system log.");
                    ioe2.printStackTrace();
                }
        }
    }
    public void yell(String message) {
        for (Player p : handler.players) {
            if ((message.indexOf("tradereq") > 0)
                    || (message.indexOf("duelreq") > 0))
                return;
            if ((p == null) || !p.isActive)
                continue;
            client temp = (client) p;
            if ((temp.absX > 0) && (temp.absY > 0))
                if ((temp != null) && !temp.disconnected && p.isActive)
                    temp.sM(message);
        }
    }

}