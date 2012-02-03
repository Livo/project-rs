package server.PlayerActions;

import server.client;
import server.NPCHandler;
import server.misc;
import server.server;

public class NPChitting {

    client c;



    public NPChitting(client client) {
        this.c = client;
    }

    public NPChitting() {
        // TODO Auto-generated constructor stub
    }

    public boolean npcHit() {
        int rand_att = misc.random(c.playerLevel[0]) + misc.random(c.playerBonus[1]) + misc.random(c.AtkPray * 8);
        int rand_npc = 0;
        if (server.npcHandler.npcs[c.attacknpc].npcType == 117 || server.npcHandler.npcs[c.attacknpc].npcType == 112) { // giant
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1338) { // dagg
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1610) { // gargoyle
            rand_npc = misc.random(170);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1616) { // basilisk
            rand_npc = misc.random(60);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1637) { // jelly
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1624) { // dust devil
            rand_npc = misc.random(80);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1615) { // abyssal demon
            rand_npc = misc.random(180);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2783) { // dark beast
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 941) { // green dragons
            rand_npc = misc.random(90);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1625) { // turoth
            rand_npc = misc.random(70);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1613) { // nechryael
            rand_npc = misc.random(120);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1264) { // saradomin wizard
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1459) { // gorilla guard
            rand_npc = misc.random(150);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1030) { // wolfman
            rand_npc = misc.random(60);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2631) { // tok-xil
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2741) { // yt-mejkot
            rand_npc = misc.random(100);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2743) { // ket-zek
            rand_npc = misc.random(300);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2745) { // tz-tok-jad
            rand_npc = misc.random(500);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 50) { // king black dragon
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1160) { // kalphite queen
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 3200) { // chaos elemental
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2881 || server.npcHandler.npcs[c.attacknpc].npcType == 2882 || server.npcHandler.npcs[c.attacknpc].npcType == 2883) { // daggonaths
            rand_npc = misc.random(300);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 258) { // general khazard
            rand_npc = misc.random(120);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2025 || server.npcHandler.npcs[c.attacknpc].npcType == 2026 || server.npcHandler.npcs[c.attacknpc].npcType == 2027 || server.npcHandler.npcs[c.attacknpc].npcType == 2028 || server.npcHandler.npcs[c.attacknpc].npcType == 2029 || server.npcHandler.npcs[c.attacknpc].npcType == 2030) { // barrows
            rand_npc = misc.random(150);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1183) { // elf warrior
            rand_npc = misc.random(150);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 3777 || server.npcHandler.npcs[c.attacknpc].npcType == 3778 || server.npcHandler.npcs[c.attacknpc].npcType == 3779 || server.npcHandler.npcs[c.attacknpc].npcType == 3780) { // pest control
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1472) { // jungle demon
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 988 || server.npcHandler.npcs[c.attacknpc].npcType == 989 || server.npcHandler.npcs[c.attacknpc].npcType == 990) { // knights legend
            rand_npc = misc.random(250);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1115) { // general graardor
            rand_npc = misc.random(300);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 655) { // tree spirit
            rand_npc = misc.random(100);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 72) { // mithril dragon
            rand_npc = misc.random(170);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2591 || server.npcHandler.npcs[c.attacknpc].npcType == 2604 || server.npcHandler.npcs[c.attacknpc].npcType == 2610) { // tzhaar
            rand_npc = misc.random(70);
        }
        if (rand_att >= rand_npc) {
            return true;
        }
        return false;
    }
    public int npcRangeDamage() {
        if(npcRangeHit()) {
            return misc.random(c.maxRangeHit2());
        } else {
            return 0;
        }
    }
    public boolean npcRangeHit() {
        int rand_att = misc.random(c.playerLevel[4]) + misc.random(c.playerBonus[4]) + misc.random(c.RangePray * 8);
        int rand_npc = 0;
        if (server.npcHandler.npcs[c.attacknpc].npcType == 117 || server.npcHandler.npcs[c.attacknpc].npcType == 112) { // giant
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1338) { // dagg
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1610) { // gargoyle
            rand_npc = misc.random(170);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1616) { // basilisk
            rand_npc = misc.random(60);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1637) { // jelly
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1624) { // dust devil
            rand_npc = misc.random(80);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1615) { // abyssal demon
            rand_npc = misc.random(180);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2783) { // dark beast
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 941) { // green dragons
            rand_npc = misc.random(90);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1625) { // turoth
            rand_npc = misc.random(70);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1613) { // nechryael
            rand_npc = misc.random(120);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1264) { // saradomin wizard
            rand_npc = misc.random(50);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1459) { // gorilla guard
            rand_npc = misc.random(150);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1030) { // wolfman
            rand_npc = misc.random(60);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2631) { // tok-xil
            rand_npc = misc.random(20);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2741) { // yt-mejkot
            rand_npc = misc.random(30);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2743) { // ket-zek
            rand_npc = misc.random(150);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2745) { // tz-tok-jad
            rand_npc = misc.random(300);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 50) { // king black dragon
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1160) { // kalphite queen
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 3200) { // chaos elemental
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2881 || server.npcHandler.npcs[c.attacknpc].npcType == 2882 || server.npcHandler.npcs[c.attacknpc].npcType == 2883) { // daggonaths
            rand_npc = misc.random(300);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 258) { // general khazard
            rand_npc = misc.random(120);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2025 || server.npcHandler.npcs[c.attacknpc].npcType == 2026 || server.npcHandler.npcs[c.attacknpc].npcType == 2027 || server.npcHandler.npcs[c.attacknpc].npcType == 2028 || server.npcHandler.npcs[c.attacknpc].npcType == 2029 || server.npcHandler.npcs[c.attacknpc].npcType == 2030) { // barrows
            rand_npc = misc.random(150);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1183) { // elf warrior
            rand_npc = misc.random(150);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 3777 || server.npcHandler.npcs[c.attacknpc].npcType == 3778 || server.npcHandler.npcs[c.attacknpc].npcType == 3779 || server.npcHandler.npcs[c.attacknpc].npcType == 3780) { // pest control
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1472) { // jungle demon
            rand_npc = misc.random(200);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 988 || server.npcHandler.npcs[c.attacknpc].npcType == 989 || server.npcHandler.npcs[c.attacknpc].npcType == 990) { // knights legend
            rand_npc = misc.random(250);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 1115) { // general graardor
            rand_npc = misc.random(300);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 655) { // tree spirit
            rand_npc = misc.random(100);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 72) { // mithril dragon
            rand_npc = misc.random(170);
        }
        if (server.npcHandler.npcs[c.attacknpc].npcType == 2591 || server.npcHandler.npcs[c.attacknpc].npcType == 2604 || server.npcHandler.npcs[c.attacknpc].npcType == 2610) { // tzhaar
            rand_npc = misc.random(70);
        }
        if (rand_att >= rand_npc) {
            return true;
        }
        return false;
    }
}
