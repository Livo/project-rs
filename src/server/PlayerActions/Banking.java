package server.PlayerActions;

import server.client;
import server.Item;

public class Banking {

    client c;






    public Banking(client client) {
        this.c = client;
        // TODO Auto-generated constructor stub
    }






    public boolean bankItem(int itemID, int fromSlot, int amount) {
        if (!c.IsBanking)
            return false;
        if (c.playerItemsN[fromSlot] <= 0) {
            return false;
        }
        if (!Item.itemIsNote[c.playerItems[fromSlot] - 1]) {
            if (c.playerItems[fromSlot] <= 0) {
                return false;
            }
            if (Item.itemStackable[c.playerItems[fromSlot] - 1]
                    || (c.playerItemsN[fromSlot] > 1)) {
                int toBankSlot = 0;
                boolean alreadyInBank = false;

                for (int i = 0; i < c.playerBankSize; i++) {
                    if (c.bankItems[i] == c.playerItems[fromSlot]) {
                        if (c.playerItemsN[fromSlot] < amount) {
                            amount = c.playerItemsN[fromSlot];
                        }
                        alreadyInBank = true;
                        toBankSlot = i;
                        i = c.playerBankSize + 1;
                    }
                }

                if (!alreadyInBank && (c.freeBankSlots() > 0)) {
                    for (int i = 0; i < c.playerBankSize; i++) {
                        if (c.bankItems[i] <= 0) {
                            toBankSlot = i;
                            i = c.playerBankSize + 1;
                        }
                    }
                    c.bankItems[toBankSlot] = c.playerItems[fromSlot];
                    if (c.playerItemsN[fromSlot] < amount) {
                        amount = c.playerItemsN[fromSlot];
                    }
                    if (((c.bankItemsN[toBankSlot] + amount) <= c.maxItemAmount)
                            && ((c.bankItemsN[toBankSlot] + amount) > -1)) {
                        c.bankItemsN[toBankSlot] += amount;
                    } else {
                        c.sM("Bank full!");
                        return false;
                    }
                    c.deleteItem((c.playerItems[fromSlot] - 1), fromSlot, amount);
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else if (alreadyInBank) {
                    if (((c.bankItemsN[toBankSlot] + amount) <= c.maxItemAmount)
                            && ((c.bankItemsN[toBankSlot] + amount) > -1)) {
                        c.bankItemsN[toBankSlot] += amount;
                    } else {
                        c.sM("Bank full!");
                        return false;
                    }
                    c.deleteItem((c.playerItems[fromSlot] - 1), fromSlot, amount);
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else {
                    c.sM("Bank full!");
                    return false;
                }
            } else {
                itemID = c.playerItems[fromSlot];
                int toBankSlot = 0;
                boolean alreadyInBank = false;

                for (int i = 0; i < c.playerBankSize; i++) {
                    if (c.bankItems[i] == c.playerItems[fromSlot]) {
                        alreadyInBank = true;
                        toBankSlot = i;
                        i = c.playerBankSize + 1;
                    }
                }
                if (!alreadyInBank && (c.freeBankSlots() > 0)) {
                    for (int i = 0; i < c.playerBankSize; i++) {
                        if (c.bankItems[i] <= 0) {
                            toBankSlot = i;
                            i = c.playerBankSize + 1;
                        }
                    }
                    int firstPossibleSlot = 0;
                    boolean itemExists = false;

                    while (amount > 0) {
                        itemExists = false;
                        for (int i = firstPossibleSlot; i < c.playerItems.length; i++) {
                            if ((c.playerItems[i]) == itemID) {
                                firstPossibleSlot = i;
                                itemExists = true;
                                i = 30;
                            }
                        }
                        if (itemExists) {
                            c.bankItems[toBankSlot] = c.playerItems[firstPossibleSlot];
                            c.bankItemsN[toBankSlot] += 1;
                            c.deleteItem((c.playerItems[firstPossibleSlot] - 1),
                                         firstPossibleSlot, 1);
                            amount--;
                        } else {
                            amount = 0;
                        }
                    }
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else if (alreadyInBank) {
                    int firstPossibleSlot = 0;
                    boolean itemExists = false;

                    while (amount > 0) {
                        itemExists = false;
                        for (int i = firstPossibleSlot; i < c.playerItems.length; i++) {
                            if ((c.playerItems[i]) == itemID) {
                                firstPossibleSlot = i;
                                itemExists = true;
                                i = 30;
                            }
                        }
                        if (itemExists) {
                            c.bankItemsN[toBankSlot] += 1;
                            c.deleteItem((c.playerItems[firstPossibleSlot] - 1),
                                         firstPossibleSlot, 1);
                            amount--;
                        } else {
                            amount = 0;
                        }
                    }
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else {
                    c.sM("Bank full!");
                    return false;
                }
            }
        } else if (Item.itemIsNote[c.playerItems[fromSlot] - 1]
                   && !Item.itemIsNote[c.playerItems[fromSlot] - 2]) {
            if (c.playerItems[fromSlot] <= 0) {
                return false;
            }
            if (Item.itemStackable[c.playerItems[fromSlot] - 1]
                    || (c.playerItemsN[fromSlot] > 1)) {
                int toBankSlot = 0;
                boolean alreadyInBank = false;

                for (int i = 0; i < c.playerBankSize; i++) {
                    if (c.bankItems[i] == (c.playerItems[fromSlot] - 1)) {
                        if (c.playerItemsN[fromSlot] < amount) {
                            amount = c.playerItemsN[fromSlot];
                        }
                        alreadyInBank = true;
                        toBankSlot = i;
                        i = c.playerBankSize + 1;
                    }
                }

                if (!alreadyInBank && (c.freeBankSlots() > 0)) {
                    for (int i = 0; i < c.playerBankSize; i++) {
                        if (c.bankItems[i] <= 0) {
                            toBankSlot = i;
                            i = c.playerBankSize + 1;
                        }
                    }
                    c.bankItems[toBankSlot] = (c.playerItems[fromSlot] - 1);
                    if (c.playerItemsN[fromSlot] < amount) {
                        amount = c.playerItemsN[fromSlot];
                    }
                    if (((c.bankItemsN[toBankSlot] + amount) <= c.maxItemAmount)
                            && ((c.bankItemsN[toBankSlot] + amount) > -1)) {
                        c.bankItemsN[toBankSlot] += amount;
                    } else {
                        return false;
                    }
                    c.deleteItem((c.playerItems[fromSlot] - 1), fromSlot, amount);
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else if (alreadyInBank) {
                    if (((c.bankItemsN[toBankSlot] + amount) <= c.maxItemAmount)
                            && ((c.bankItemsN[toBankSlot] + amount) > -1)) {
                        c.bankItemsN[toBankSlot] += amount;
                    } else {
                        return false;
                    }
                    c.deleteItem((c.playerItems[fromSlot] - 1), fromSlot, amount);
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else {
                    c.sM("Bank full!");
                    return false;
                }
            } else {
                itemID = c.playerItems[fromSlot];
                int toBankSlot = 0;
                boolean alreadyInBank = false;

                for (int i = 0; i < c.playerBankSize; i++) {
                    if (c.bankItems[i] == (c.playerItems[fromSlot] - 1)) {
                        alreadyInBank = true;
                        toBankSlot = i;
                        i = c.playerBankSize + 1;
                    }
                }
                if (!alreadyInBank && (c.freeBankSlots() > 0)) {
                    for (int i = 0; i < c.playerBankSize; i++) {
                        if (c.bankItems[i] <= 0) {
                            toBankSlot = i;
                            i = c.playerBankSize + 1;
                        }
                    }
                    int firstPossibleSlot = 0;
                    boolean itemExists = false;

                    while (amount > 0) {
                        itemExists = false;
                        for (int i = firstPossibleSlot; i < c.playerItems.length; i++) {
                            if ((c.playerItems[i]) == itemID) {
                                firstPossibleSlot = i;
                                itemExists = true;
                                i = 30;
                            }
                        }
                        if (itemExists) {
                            c.bankItems[toBankSlot] = (c.playerItems[firstPossibleSlot] - 1);
                            c.bankItemsN[toBankSlot] += 1;
                            c.deleteItem((c.playerItems[firstPossibleSlot] - 1),
                                         firstPossibleSlot, 1);
                            amount--;
                        } else {
                            amount = 0;
                        }
                    }
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else if (alreadyInBank) {
                    int firstPossibleSlot = 0;
                    boolean itemExists = false;

                    while (amount > 0) {
                        itemExists = false;
                        for (int i = firstPossibleSlot; i < c.playerItems.length; i++) {
                            if ((c.playerItems[i]) == itemID) {
                                firstPossibleSlot = i;
                                itemExists = true;
                                i = 30;
                            }
                        }
                        if (itemExists) {
                            c.bankItemsN[toBankSlot] += 1;
                            c.deleteItem((c.playerItems[firstPossibleSlot] - 1),
                                         firstPossibleSlot, 1);
                            amount--;
                        } else {
                            amount = 0;
                        }
                    }
                    c.resetItems(5064);
                    c.resetBank();
                    return true;
                } else {
                    c.sM("Bank full!");
                    return false;
                }
            }
        } else {
            c.sM("Item not supported " + (c.playerItems[fromSlot] - 1));
            return false;
        }
    }
}