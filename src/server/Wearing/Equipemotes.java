package server.Wearing;

import server.client;



public class Equipemotes {

    client c;



    public Equipemotes(client client) {
        this.c = client;
    }

    public Equipemotes() {
        // TODO Auto-generated constructor stub
    }

    public int GetWepAnim(int id)//cleaned, everyone of them to f2p.
    {
        if (id == -1) // unarmed
        {
            return 422;
        }
        if ((id == 1351)) // scimitars ftype doesn't = 3

        {
            ////c.frame174(400, 000, 040);
            return 451;
        }
        if ((id == 1381 || id == 1383 || id == 1385 || id == 1387 || id == 1379) && c.FightType != 3)  // staffs
        {
            ////c.frame174(395, 000, 040);
            return 451;
        }
        if ((id == 1265 || id == 1267 || id == 1259 || id == 1271 || id == 1273))  // pick axes
        {
            //c.frame174(398, 000, 040);
            return 451;
        }
        if ((id == 1291 || id == 1321 || id == 1323 || id == 1325 || id == 1327 || id == 1329 || id == 1327 || id == 1321 || id == 1333) && c.FightType != 3) // scimitars ftype doesn't = 3
        {
            if(c.playerRights > 1) {
                c.sM("test for slash");
            }
            //c.frame174(396, 000, 040);
            return 451;
        }
        if ((id == 1291 || id == 1321 || id == 1323 || id == 1325 || id == 1327 || id == 1329 || id == 1327 || id == 1321 || id == 1333) && c.FightType == 3) // scimitars for fightype ==3
        {
            //c.frame174(398, 000, 040);
            if(c.playerRights > 1) {
                c.sM("test for stab");
            }
            return 412;
        }
        if (id == 841 || id == 843 || id == 845 || id == 849 || id == 847 || id == 853 || id == 851) // f2p bows
        {
            //c.frame174(370, 000, 040);
            return 426;
        }
        if (id == 1307 || id == 1309 || id == 1311 || id == 1313 || id == 1315 || id == 1317 || id == 1319) //bronze - rune 2hs.
            // 2 handers
        {
            return 407;
        } else {
            return 451;
        }
    }


    public int GetRunAnim(int id) {
        if (id == 1307 || id == 1309 || id == 1311 || id == 1313 || id == 1315 || id == 1317 || id == 1319) //bronze - rune 2hs.
        {
            return 2563;
        } else//k
        {
            return 0x338;
        }
    }

    public int GetWalkAnim(int id) {
        if (id == 1307 || id == 1309 || id == 1311 || id == 1313 || id == 1315 || id == 1317 || id == 1319) //bronze - rune 2hs.
        {
            return 2562;
        }
        if (id == 1379 || id == 1381 || id == 1383 || id == 1385) // air staff etc
        {
            return 1146;
        } else {
            return 0x333;
        }
    }

    public int GetStandAnim(int id) {
        if (id == 1307 || id == 1309 || id == 1311 || id == 1313 || id == 1315 || id == 1317 || id == 1319) //bronze - rune 2hs.
        {
            return 2561;
        } else {
            return 0x328;
        }
    }

    public int GetBlockAnim()//havent finished
    {
        if (c.playerEquipment[c.playerShield] == 1201 || c.playerEquipment[c.playerShield] == 1540 || c.playerEquipment[c.playerShield] == 1171)//shields
        {
            // return 0x484;
        }
        if (c.playerEquipment[c.playerWeapon] == 1171 || c.playerEquipment[c.playerWeapon] == 1329 || c.playerEquipment[c.playerWeapon] == 1327 || c.playerEquipment[c.playerWeapon] == 1291 || c.playerEquipment[c.playerWeapon] == 1321 || c.playerEquipment[c.playerWeapon] == 1325 || c.playerEquipment[c.playerWeapon] == 1291)//scims
        {
            return 404;//kk
        }
        if (c.playerEquipment[c.playerWeapon] == 839 || c.playerEquipment[c.playerWeapon] == 841 || c.playerEquipment[c.playerWeapon] == 843 || c.playerEquipment[c.playerWeapon] == 845 || c.playerEquipment[c.playerWeapon] == 847 || c.playerEquipment[c.playerWeapon] == 849 || c.playerEquipment[c.playerWeapon] == 851 || c.playerEquipment[c.playerWeapon] == 853 || c.playerEquipment[c.playerWeapon] == 855 || c.playerEquipment[c.playerWeapon] == 857 || c.playerEquipment[c.playerWeapon] == 837 || c.playerEquipment[c.playerWeapon] == 861 || c.playerEquipment[c.playerWeapon] == 4734 || c.playerEquipment[c.playerWeapon] == 859 || c.playerEquipment[c.playerWeapon] == 4827) {
            return 424;
        }
        if (c.playerEquipment[c.playerWeapon] == 4718) {
            return 424;
        }
        if (c.playerEquipment[c.playerWeapon] == 4153) // maul
        {
            return 1666;
        } else {
            return 424;
        }
    }
}
