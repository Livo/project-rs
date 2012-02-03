package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import server.Wearing.Equipemotes;

import server.Wearing.Wearing;

import server.Buttons.ActionButtons;
import server.Skills.Fletching;
import server.Skills.Exp;
import server.Skills.Herblore;
import server.Skills.Menu;
//import server.Other.MusicSystem;
//import server.Other.NPChitting;
import server.PlayerActions.FollowHandler;

import server.PlayerActions.ItemKeeping;
//import server.PacketHandler.Cases;






public class server implements Runnable {

    /**
     * The task scheduler.
     */
    private static final TaskScheduler scheduler = new TaskScheduler();

    /**
     * Gets the task scheduler.
     * @return The task scheduler.
     */
    public static TaskScheduler getTaskScheduler() {
        return scheduler;
    }

    public static boolean pickup = true;
    public static boolean fightcaves = true;
    public static ArrayList<String> banned = new ArrayList<String>();
    public static ArrayList<Integer> bannedUid = new ArrayList<Integer>();
    public static server clientHandler = null; // handles all the clients
    public static java.net.ServerSocket clientListener = null;
    public static int MaxConnections = 100000;
    public static int[] ConnectionCount = new int[MaxConnections];
    public static ArrayList<String> connections = new ArrayList<String>();
    public static String[] Connections = new String[MaxConnections];
    //public static final int cycleTime = 500;
    public static int delay = 50;
    public static long delayUpdate = 0, lastRunite = 0;

    public static int EnergyRegian = 60;

    public static boolean enforceClient = false;
    public static WorldMap WorldMap = null;
    public static GraphicsHandler GraphicsHandler = null;
    public static ItemHandler itemHandler = null;
    //public static checkPlayerCapes checkPlayerCapes = null;
    /*handlers made by Delta*/
    public static Wearing Wearing = null;
    public static special special = null;
    public static GlobalItems GlobalItems = null;
    public static setConfig setConfig = null;
    public static textHandler textHandler = null;
    public static ItemFunctions ItemFunctions = null;
    public static ActionButtons ActionButtons = null;
    public static Fletching Fletching = null;
    public static Exp Exp = null;
    public static Herblore Herblore = null;
    public static Menu Menu = null;
    /*end of handlers made by Delta*/
    public static boolean loginServerConnected = true;
    public static NPCHandler npcHandler = null;
    public static ArrayList<Object> objects = new ArrayList<Object>();
    public static PlayerHandler playerHandler = null;

    public static int[][] runesRequired = new int[24][9];
    public static int serverlistenerPort = 43594; // 43594=default
    public static ShopHandler shopHandler = null;
    //public static Equipemotes Equipemotes = null;
    //public static NPChitting NPChitting = null;
    //public static FollowHandler FollowHandler = null;
    //public static ItemKeeping ItemKeeping = null;
    //public static Banking Banking = null;
    //public static Cases Cases = null;
    //public static Packets Packets = null;



    //public static MusicSystem MusicSystem = null;


    public static boolean ShutDown = false;
    public static boolean shutdownClientHandler; // signals ClientHandler to shut
    // down
    public static int ShutDownCounter = 0;
    public static boolean shutdownServer = false; // set this to true in order to
    // shut down and kill the server
    public static long startTime;
    // TODO: yet to figure out proper value for timing, but 500 seems good
    public static boolean trading = true, dueling = true, pking = true;
    public static int updateSeconds = 1800; // 180 because it doesnt make the
    // time jump at the start :P

    public static boolean updateServer = false;

    public static int world = 1;

    /*
    public static void calcTime() {
    	long curTime = System.currentTimeMillis();
    	updateSeconds = 180 - ((int) (curTime - startTime) / 1000);
    	if (updateSeconds == 0) {
    		shutdownServer = true;
    	}
    }
    */
    public static void calcTime() {
        long curTime = System.currentTimeMillis();
        updateSeconds = 1800 - ((int) (curTime - startTime) / 1800);
        if (updateSeconds == 0) {
            shutdownServer = true;
        }
    }

    public static void logError(String message) {
        misc.println(message);
    }

    public static void main(java.lang.String args[])
    throws NullPointerException {
        try {
            File f = new File("server.ini");
            if (!f.exists()) {
                misc.println("server.ini doesn't exist!");
            }
            Properties p = new Properties();
            p.load(new FileInputStream("./server.ini"));
            int client = Integer.parseInt(p.getProperty("ClientRequired")
                                          .trim());
            world = Integer.parseInt(p.getProperty("WorldId"));
            serverlistenerPort = Integer.parseInt(p.getProperty("ServerPort")
                                                  .trim());
            if (client > 0) {
                misc.println("Enforcing Devolution client requirement");
                enforceClient = true;
            }
        } catch (Exception e) {
            misc.println("Error loading settings");
            e.printStackTrace();
        }
        WorldMap = new WorldMap();
        WorldMap.loadWorldMap();
        clientHandler = new server();
        (new Thread(clientHandler)).start(); // launch server listener
        playerHandler = new PlayerHandler();
        npcHandler = new NPCHandler();
        itemHandler = new ItemHandler();
        GlobalItems = new GlobalItems();

        GraphicsHandler = new GraphicsHandler();
        //checkPlayerCapes = new checkPlayerCapes();
        /*handlers made by Delta*/
        Wearing = new Wearing();
        special = new special();
        setConfig = new setConfig();
        textHandler = new textHandler();
        ItemFunctions = new ItemFunctions();
        ActionButtons = new ActionButtons();
        Fletching = new Fletching();
        Exp = new Exp();
        Herblore = new Herblore();
        Menu = new Menu();
        GlobalItems.process();
        //misc.println(".::Delta cleaned 1.5::.");
        /*end of handlers made by Delta*/
        if (itemHandler == null) {
            misc.println("ERROR NULL");
        }
        shopHandler = new ShopHandler();
        //ItemKeeping = new ItemKeeping();
        //Equipemotes = new Equipemotes();
        //NPChitting = new NPChitting();
        //FollowHandler = new FollowHandler();
        //Banking = new Banking();
        //Cases = new Cases();
        GraphicsHandler = new GraphicsHandler();
        //Packets = new Packets();

        //MusicSystem = new MusicSystem();
        process proc = new process();
        new Thread(proc).start();
        scheduler.schedule(new Task() {
            @Override
            protected void execute() {
            }

        });
    }
    public int[] ips = new int[1000];

    public long[] lastConnect = new long[1000];

    public server() {
        // the current way of controlling the server at runtime and a great
        // debugging/testing tool
        // jserv js = new jserv(this);
        // js.start();

    }

    public void banHost(String host, int num) {
        if (false) {
            banned.add(host);
        } else {
            try {
                misc.println("BANNING HOST " + host + " (flooding)");
                banned.add(host);
                delay = 2000;
                delayUpdate = System.currentTimeMillis() + 60000;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public boolean checkHost(String host) {
        for (String h : banned) {
            if (h.equals(host))
                return false;
        }
        int num = 0;
        for (String h : connections) {
            if (host.equals(h)) {
                num++;
            }
        }
        if (num > 5) {
            banHost(host, num);
            return false;
        }

        if (checkLog("ipbans", host)) {
            System.out.println("They are in ip ban list!");
            return false; // ip ban added by bakatool
        }
        return true;
    }

    public boolean checkLog(String file, String playerName) {
        // check ipbans -bakatool
        try {
            BufferedReader in = new BufferedReader(new FileReader("config\\"
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

    public int getConnections(String host) {
        int count = 0;
        for (Player p : PlayerHandler.players) {
            if ((p != null) && !p.disconnected
                    && p.connectedFrom.equalsIgnoreCase(host)) {
                count++;
            }
        }
        return count;
    }

    public void killServer() {
        try {
            shutdownClientHandler = true;
            if (clientListener != null)
                clientListener.close();
            clientListener = null;
        } catch (java.lang.Exception __ex) {
            __ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        // setup the listener
        try {
            shutdownClientHandler = false;
            clientListener = new java.net.ServerSocket(serverlistenerPort, 1,
                    null);
            misc.println("Loading actionbuttons...");
            misc.println("loading client...");
            misc.println("Loading shops...");
            misc.println("Loading items...");
            misc.println("Loading npcs...");

            misc.println("Loading complete, Runescape 2007 online!");
            while (true) {
                try {
                    java.net.Socket s = clientListener.accept();
                    s.setTcpNoDelay(true);
                    String connectingHost = s.getInetAddress().getHostName();
                    if ( /*
					 * connectingHost.startsWith("localhost") ||
					 * connectingHost.equals("127.0.0.1")
					 */true) {
                        if (connectingHost.contains("74-129-182-147.dhcp.insightbb.com")) {
                            misc.println("Checking Server Status...");
                            s.close();
                        } else {
                            connections.add(connectingHost);
                            if (checkHost(connectingHost)) {
                                misc.println("Connection from ip - "
                                             + connectingHost + ":" + s.getPort());
                                playerHandler.newPlayerClient(s, connectingHost);
                            } else {
                                misc.println("Rejected Connection "
                                             + connectingHost + ":" + s.getPort());
                                s.close();
                            }
                        }
                    } else {
                        misc.println("ClientHandler: Rejected "
                                     + connectingHost + ":" + s.getPort());
                        s.close();
                    }
                    if ((delayUpdate > 0)
                            && (System.currentTimeMillis() > delayUpdate)) {
                        delay = 50;
                        delayUpdate = 0;
                    }
                    Thread.sleep(100);
                } catch (Exception e) {
                    logError(e.getMessage());
                }
            }
        } catch (java.io.IOException ioe) {
            if (!shutdownClientHandler) {
                misc.println("Server is already in use.");
            } else {
                misc.println("ClientHandler was shut down.");
            }
        }
    }
}
