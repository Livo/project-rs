package server.PlayerActions;

import server.client;
import server.Player;
import server.PlayerHandler;
import server.server;

public class FollowHandler {

    client c;

    public FollowHandler(client client) {
        this.c = client;
    }

    public FollowHandler() {
        // TODO Auto-generated constructor stub
    }

    public void followDirection() {
        c.faceNPC(32768 + c.followID);
        int i = PlayerHandler.players[c.followID].absX;
        int k = PlayerHandler.players[c.followID].absY;
        boolean flag1 = c.WithinDistance(i, k, c.absX, c.absY, 1);
        boolean flag3 = c.WithinDistance(i, k, c.absX, c.absY, 2);
        boolean UseBow = false;
        if (c.playerEquipment[c.playerWeapon] == 839 || c.playerEquipment[c.playerWeapon] == 841 || c.playerEquipment[c.playerWeapon] == 843 ||  c.playerEquipment[c.playerWeapon] == 845 ||  c.playerEquipment[c.playerWeapon] == 847 ||  c.playerEquipment[c.playerWeapon] == 849 || c.playerEquipment[c.playerWeapon] == 851 ||  c.playerEquipment[c.playerWeapon] == 853 || c.playerEquipment[c.playerWeapon] == 855 ||  c.playerEquipment[c.playerWeapon] == 857 ||  c.playerEquipment[c.playerWeapon] == 837 || c.playerEquipment[c.playerWeapon] == 861 || c.playerEquipment[c.playerWeapon] == 4734 || c.playerEquipment[c.playerWeapon] == 859 || c.playerEquipment[c.playerWeapon] == 4827 || c.hasCrystalBow()) {
            UseBow = true;
        }
        boolean UseCrossBow = false;
        if (c.playerEquipment[c.playerWeapon] == 837) {
            UseCrossBow = true;
        }
        boolean UseRing = false;
        if (c.playerEquipment[c.playerWeapon] == 6522) {
            UseRing = true;
        }
        if (c.isInArena() || c.isInGraardor() || c.isInApe() || c.isInJail() || c.isInRock()) {
            return;
        }
        if (c.isInPitRoom()) {
            c.sM("You can't follow in the waiting room!");
            return;
        }
        if (c.isInAssault()) {
            c.sM("You can't follow in assault!");
            return;
        }
        if (k == c.absY && i == c.absX)
            c.walkTo(0, c.getMove(c.absY, k - 1));
        if(!UseBow && !UseCrossBow && !UseRing && !flag1 || !c.inCombat && !flag1)
        {
            if(flag3 && PlayerHandler.players[c.followID] != null)
            {
                if(k > c.absY && i == c.absX)
                    c.walkTo(0, c.getMove(c.absY, k - 1));
                else if(k < c.absY && i == c.absX)
                    c.walkTo(0, c.getMove(c.absY, k + 1));
                else if(i > c.absX && k == c.absY)
                    c.walkTo(c.getMove(c.absX, i - 1), 0);
                else if(i < c.absX && k == c.absY)
                    c.walkTo(c.getMove(c.absX, i + 1), 0);
                else if(i < c.absX && k < c.absY)
                    c.walkTo(c.getMove(c.absX, i + 1), c.getMove(c.absY, k + 1));
                else if(i > c.absX && k > c.absY)
                    c.walkTo(c.getMove(c.absX, i - 1), c.getMove(c.absY, k - 1));
                else if(i < c.absX && k > c.absY)
                    c.walkTo(c.getMove(c.absX, i + 1), c.getMove(c.absY, k - 1));
                else if(i > c.absX && k < c.absY)
                {
                    c.walkTo(c.getMove(c.absX, i - 1), c.getMove(c.absY, k + 1));
                } else
                {
                    c.sM("Undocumented movement.");
                    c.sM((new StringBuilder()).append("followX - c.absX = ").append(i - c.absX).toString());
                    c.sM((new StringBuilder()).append("followY - c.absY = ").append(k - c.absY).toString());
                }
            } else if(!flag3 && PlayerHandler.players[c.followID] != null)
            {
                if(k > c.absY && i == c.absX)
                    c.walkTo(0, c.getMove(c.absY, k - 1) + c.getMove(c.absY, k - 1));
                else if(k < c.absY && i == c.absX)
                    c.walkTo(0, c.getMove(c.absY, k + 1) + c.getMove(c.absY, k + 1));
                else if(i > c.absX && k == c.absY)
                    c.walkTo(c.getMove(c.absX, i - 1) + c.getMove(c.absX, i - 1), 0);
                else if(i < c.absX && k == c.absY)
                    c.walkTo(c.getMove(c.absX, i + 1) + c.getMove(c.absX, i + 1), 0);
                else if(i < c.absX && k < c.absY)
                    c.walkTo(c.getMove(c.absX, i + 1) + c.getMove(c.absX, i + 1), c.getMove(c.absY, k + 1) + c.getMove(c.absY, k + 1));
                else if(i > c.absX && k > c.absY)
                    c.walkTo(c.getMove(c.absX, i - 1) + c.getMove(c.absX, i - 1), c.getMove(c.absY, k - 1) + c.getMove(c.absY, k - 1));
                else if(i < c.absX && k > c.absY)
                    c.walkTo(c.getMove(c.absX, i + 1) + c.getMove(c.absX, i + 1), c.getMove(c.absY, k - 1) + c.getMove(c.absY, k - 1));
                else if(i > c.absX && k < c.absY)
                {
                    c.walkTo(c.getMove(c.absX, i + 1) + c.getMove(c.absX, i + 1), c.getMove(c.absY, k - 1) + c.getMove(c.absY, k - 1));
                } else
                {
                    c.sM("Undocumented movement.");
                    c.sM((new StringBuilder()).append("followX - c.absX = ").append(i - c.absX).toString());
                    c.sM((new StringBuilder()).append("followY - c.absY = ").append(k - c.absY).toString());
                }
            }
        }
    }

    public void followDirection2() {
        if(c.followID2 > 0 && server.npcHandler.npcs[c.followID2] != null)
        {
            if(server.npcHandler.npcs[c.followID2].IsDead || server.npcHandler.npcs[c.followID2].HP <= 0)
            {
                c.followID2 = 0;
                return;
            }
            int j = server.npcHandler.npcs[c.followID2].absX;
            int l = server.npcHandler.npcs[c.followID2].absY;
            boolean flag2 = c.WithinDistance(j, l, c.absX, c.absY, 1);
            boolean flag4 = c.WithinDistance(j, l, c.absX, c.absY, 2);
            boolean UseBow = false;
            if (c.playerEquipment[c.playerWeapon] == 839 || c.playerEquipment[c.playerWeapon] == 841 || c.playerEquipment[c.playerWeapon] == 843 ||  c.playerEquipment[c.playerWeapon] == 845 ||  c.playerEquipment[c.playerWeapon] == 847 ||  c.playerEquipment[c.playerWeapon] == 849 || c.playerEquipment[c.playerWeapon] == 851 ||  c.playerEquipment[c.playerWeapon] == 853 || c.playerEquipment[c.playerWeapon] == 855 ||  c.playerEquipment[c.playerWeapon] == 857 ||  c.playerEquipment[c.playerWeapon] == 837 || c.playerEquipment[c.playerWeapon] == 861 || c.playerEquipment[c.playerWeapon] == 4734 || c.playerEquipment[c.playerWeapon] == 859 || c.playerEquipment[c.playerWeapon] == 4827 || c.hasCrystalBow()) {
                UseBow = true;
            }
            boolean UseCrossBow = false;
            if (c.playerEquipment[c.playerWeapon] == 837) {
                UseCrossBow = true;
            }
            boolean UseRing = false;
            if (c.playerEquipment[c.playerWeapon] == 6522) {
                UseRing = true;
            }
            if(l == c.absY && j == c.absX)
                c.walkTo(0, c.getMove(c.absY, l - 1));
            if(!UseBow && !UseCrossBow && !UseRing && !flag2)
                if(flag4)
                {
                    if(l > c.absY && j == c.absX)
                        c.walkTo(0, c.getMove(c.absY, l - 1));
                    else if(l < c.absY && j == c.absX)
                        c.walkTo(0, c.getMove(c.absY, l + 1));
                    else if(j > c.absX && l == c.absY)
                        c.walkTo(c.getMove(c.absX, j - 1), 0);
                    else if(j < c.absX && l == c.absY)
                        c.walkTo(c.getMove(c.absX, j + 1), 0);
                    else if(j < c.absX && l < c.absY)
                        c.walkTo(c.getMove(c.absX, j + 1), c.getMove(c.absY, l + 1));
                    else if(j > c.absX && l > c.absY)
                        c.walkTo(c.getMove(c.absX, j - 1), c.getMove(c.absY, l - 1));
                    else if(j < c.absX && l > c.absY)
                        c.walkTo(c.getMove(c.absX, j + 1), c.getMove(c.absY, l - 1));
                    else if(j > c.absX && l < c.absY)
                    {
                        c.walkTo(c.getMove(c.absX, j - 1), c.getMove(c.absY, l + 1));
                    } else
                    {
                        c.sM("Undocumented movement.");
                        c.sM((new StringBuilder()).append("followX - c.absX = ").append(j - c.absX).toString());
                        c.sM((new StringBuilder()).append("followY - c.absY = ").append(l - c.absY).toString());
                    }
                } else if(!flag4)
                    if(l > c.absY && j == c.absX)
                        c.walkTo(0, c.getMove(c.absY, l - 1) + c.getMove(c.absY, l - 1));
                    else if(l < c.absY && j == c.absX)
                        c.walkTo(0, c.getMove(c.absY, l + 1) + c.getMove(c.absY, l + 1));
                    else if(j > c.absX && l == c.absY)
                        c.walkTo(c.getMove(c.absX, j - 1) + c.getMove(c.absX, j - 1), 0);
                    else if(j < c.absX && l == c.absY)
                        c.walkTo(c.getMove(c.absX, j + 1) + c.getMove(c.absX, j + 1), 0);
                    else if(j < c.absX && l < c.absY)
                        c.walkTo(c.getMove(c.absX, j + 1) + c.getMove(c.absX, j + 1), c.getMove(c.absY, l + 1) + c.getMove(c.absY, l + 1));
                    else if(j > c.absX && l > c.absY)
                        c.walkTo(c.getMove(c.absX, j - 1) + c.getMove(c.absX, j - 1), c.getMove(c.absY, l - 1) + c.getMove(c.absY, l - 1));
                    else if(j < c.absX && l > c.absY)
                        c.walkTo(c.getMove(c.absX, j + 1) + c.getMove(c.absX, j + 1), c.getMove(c.absY, l - 1) + c.getMove(c.absY, l - 1));
                    else if(j > c.absX && l < c.absY)
                    {
                        c.walkTo(c.getMove(c.absX, j + 1) + c.getMove(c.absX, j + 1), c.getMove(c.absY, l - 1) + c.getMove(c.absY, l - 1));
                    } else
                    {
                        c.sM("Undocumented movement.");
                        c.sM((new StringBuilder()).append("followX - c.absX = ").append(j - c.absX).toString());
                        c.sM((new StringBuilder()).append("followY - c.absY = ").append(l - c.absY).toString());
                    }
        }
    }
}