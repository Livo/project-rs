package server;

// a collection of item methods
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Item {

	public static int amulets[] = {4035,6577, 10519, 10413, 11204, 11205, 1120611146,
			11147, 11148, 11149, 11150, 11151, 11152, 11141, 6857, 6859, 6861,
			6863, 1724, 1718, 6585, 86, 774, 87, 295, 421, 552, 589, 1478,
			1692, 1694, 1696, 1698, 1700, 1702, 1704, 1706, 1708, 1710, 1712,
			1725, 1727, 1729, 1731, 4021, 4081, 4250, 4677, 6040, 6041, 6208,
			11274, 11275, 11276, 11273, 11941 };
	public static int arrows[] = { 11774, 11775, 11776, 11777, 11778, 11779,
			78, 598, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887,
			888, 889, 890, 891, 892, 893, 942, 2532, 2533, 2534, 2535, 2536,
			2537, 2538, 2539, 2540, 2541, 2866, 4160, 4172, 4173, 4174, 4175,
			4740, 5616, 5617, 5618, 5619, 5620, 5621, 5622, 5623, 5624, 5625,
			5626, 5627, 6061, 6062 };
	public static int body[] = {577,2896,2906,2916,2926,2936,2520, 638 , 640,642, 430, 10300, 11154, 11471, 10625, 10628, 10930,
			10933, 10935, 10937, 10939, 10941, 10927, 11998, 11997, 11281,
			10222, 11268, 10408, 11977, 11975, 11198, 11199, 11200, 11173,
			11175, 11177, 11179, 11181, 11183, 11185, 11187, 11171, 11169,
			11162, 11158, 11143, 11138, 11134, 5032, 5028, 6065, 1844, 5034,
			6788, 7134, 7128, 7110, 7122, 6750, 6615, 6617, 5575, 7592, 6129,
			6322, 6139, 6133, 129, 6916, 6654, 7390, 7392, 7362, 7364, 7399,
			7374, 7376, 7372, 7370, 1035, 540, 5553, 4757, 1833, 6388, 6384,
			2501, 2499, 4111, 4101, 4091, 6186, 6184, 6180, 3058, 4509, 4504,
			4069, 4728, 4736, 4712, 6107, 2661, 3140, 1101, 1103, 1105, 1107,
			1109, 1111, 1113, 1115, 1117, 1119, 1121, 1123, 1125, 1127, 1129,
			1131, 1133, 1135, 2499, 2503, 2583, 2591, 2599, 2607, 2615, 2623,
			2653, 2669, 3481, 4712, 4720, 4728, 4749, 4892, 4893, 4894, 4895,
			4916, 4917, 4918, 4919, 4964, 4965, 4966, 4967, 6107, 6133, 6322,
			426, 7633, 7642, 7661, 7660, 7667, 7669, 7684, 7689, 7698, 3387,
			7695, 544, 546, 75 };
	public static int boots[] = {3393, 10627, 10630, 11269, 10411, 11981, 11979,
			7159, 7114, 6619, 6666, 7596, 6920, 6061, 6106, 88, 89, 626, 628,
			630, 632, 634, 1061, 1837, 1846, 2577, 2579, 2894, 2904, 2914,
			2924, 2934, 3061, 3105, 3107, 3791, 4097, 4107, 4117, 4119, 4121,
			4123, 4125, 4127, 4129, 4131, 4310, 5064, 5345, 5557, 6069, 6106,
			6143, 6145, 6147, 6328, 7664, 7666, 7700 };
	// Few item types for equipping
	public static int capes[] = { 2677,2680,2683,2686,2689,2692,2695,2698,2701,2704,2710,2713,2716,2719,2722,2725,2728,2731,2734,2737,10943, 10944, 10945, 10946, 10865, 10866,
			11371, 11372, 10412, 10704, 10705, 10707, 10708, 10710, 10711,
			10713, 10714, 10716, 10717, 10719, 10720, 10722, 10723, 10725,
			10726, 10728, 10729, 10731, 10732, 10734, 10735, 10737, 10738,
			10740, 10741, 10743, 10744, 10746, 10747, 10749, 10750, 10752,
			10753, 10755, 10756, 10758, 10759, 10761, 10762, 10764, 10765,
			10767, 10768, 10770, 11192, 11193, 11194, 7535, 6111, 6570, 6568,
			1007, 1019, 1021, 1023, 1027, 1029, 1031, 1052, 2412, 2413, 2414,
			4304, 4315, 4317, 4319, 4321, 4323, 4325, 4327, 4329, 4331, 4333,
			4335, 4337, 4339, 4341, 4343, 4345, 4347, 4349, 4351, 4353, 4355,
			4357, 4359, 4361, 4363, 4365, 4367, 4369, 4371, 4373, 4375, 4377,
			4379, 4381, 4383, 4385, 4387, 4389, 4391, 4393, 4395, 4397, 4399,
			4401, 4403, 4405, 4407, 4409, 4411, 4413, 4514, 4516, 6070, 6568,
			6570, 3777, 3790, 3783, 2413, 3789, 3781, 3763, 3765, 3787, 3785,
			4304, 3779, 3759,3761, 762, 7623, 7626, 7630, 7632, 7634, 7636, 7638,
			7640, 7648, 7628, 750, 7653, 7655, 7650, 7657, 7672, 7674, 7676,
			7678, 7680, 7682, 7685 };
	public static int crackers[] = { 1038, 1040, 1042, 1044, 1046, 1048 };
	/* Catherby, relekka and fishing guild - ID 5 */
	public static int fishing_big_net[] = { 353, 407, 405, 401, 341, 363 };
	public static int fishing_big_net_lvl[] = { 16, 16, 16, 16, 23, 46 };
	public static int fishing_big_net_xp[] = { 20, 10, 10, 1, 45, 100 };
	/* Any River - ID 4 */
	public static int fishing_fly[] = { 335, 349, 331 };
	public static int fishing_fly_lvl[] = { 20, 25, 30 };
	public static int fishing_fly_xp[] = { 50, 60, 70 };
	/* karamja, fishing guild, caatherby and rellekka - ID 6 */
	public static int fishing_harpoon[] = { 359, 371 };

	public static int fishing_harpoon_lvl[] = { 35, 50 };
	public static int fishing_harpoon_xp[] = { 80, 100 };
	/* Any Sea - ID 1 */
	public static int fishing_net[] = { 317, 321 };

	public static int fishing_net_lvl[] = { 1, 15 };
	public static int fishing_net_xp[] = { 10, 40 };
	/* Any Sea - ID 2 */
	public static int fishing_rod1[] = { 327, 345 };
	public static int fishing_rod1_lvl[] = { 5, 10 };
	public static int fishing_rod1_xp[] = { 10, 30 };
	/* Lumby Swamp - ID 3 */
	public static int fishing_rod2[] = { 3379, 5001 };
	public static int fishing_rod2_lvl[] = { 28, 36 };
	public static int fishing_rod2_xp[] = { 65, 80 };
	public static int Helm[] = {2679,2682,2685,2688,2691,2694,2697,2700,2703,2706,2709,2712,2715,2718,2721,2724,2727,2730,2733,2736,2739,7611,5574,1169, 3753, 4513, 4515,
			3748, 7112, 7124, 7130, 7136, 7539, 6109, 6621, 6623, 7594, 6131,
			6137, 6128, 4732, 1149, 4753, 6188, 4511, 4056, 4071, 4724, 6109,
			2587, 2595, 2605, 1153, 1155, 1157, 1159, 1161, 1163, 1165, 2657, 2673, 2665,
			2613, 2619, 2627, 3486, 6402, 6394, 3751, 7594, 4708,
			4716, 4745, 4732, 5554, 4753, 7624, 7631, 2518, 2524, 2526};
	public static int fullHelm[] = {2679,2682,2685,2688,2691,2694,2697,2700,2703,2706,2709,2712,2715,2718,2721,2724,2727,2730,2733,2736,2739,7611,5574,1169, 3753, 4513, 4515,
			3748, 7112, 7124, 7130, 7136, 7539, 6621, 6623, 7594, 6131,
			6137, 6128, 4732, 1149, 4753, 6188, 4511, 4056, 4071, 4724,
			2587, 2595, 2605,
			2613, 2619, 2627, 3486, 6402, 6394, 7594,
			 4745, 4732, 5554, 4753, 7624, 7631, 2518, 2524, 2526};
	public static int fullMask[] = {4513, 4515, 11298, 11144, 7539, 6621, 6623, 7594, 6326, 6131, 6137, 6128, 9128, 4732, 5554, 4753, 4611, 6188,
			3507, 4511, 4056, 4071, 4724, 2665, 1053, 1055, 1057,
			7594, 4745, 4732, 5554, 4753, 7652, 7647, 7627, 7649,
			7629, 7633, 7635, 7641, 7651, 7637, 7639, 7654, 7656, 7657, 7663,
			7658, 7673, 7675, 7677, 7679, 7681, 7683, 7686, 2518, 2524, 2526};  
	// All other IDs are weapons (I hope)
	public static int gloves[] = {3391, 11271, 10947, 10948, 10949, 10950, 10951,
			10952, 10225, 10410, 11710, 11161, 11157, 11153, 11137, 6629, 6720,
			7595, 6330, 6922, 2491, 1065, 2487, 2489, 3060, 1495, 775, 777,
			778, 6708, 1059, 1063, 1065, 1580, 2487, 2489, 2491, 2902, 2912,
			2922, 2932, 2942, 3060, 3799, 4095, 4105, 4115, 4308, 5556, 6068,
			6110, 6149, 6151, 6153, 7454, 7455, 7456, 7457, 7458, 7459, 7460,
			7461, 7462, 1050, 3057, 7671, 7688 };
	public static int hats[] = {7611,2679,2682,2685,2688,2691,2694,2697,2700,2703,2706,2709,2712,2715,2718,2721,2724,2727,2730,2733,2736,2739,1169,1025,7112,7124,7130,7136,7534,658,660,662, 10307, 11264, 11265, 11266, 11446, 8454, 8453,
			10931, 10934, 10928, 11195, 11196, 11197, 11812, 11813, 11809,
			11810, 11951, 11950, 11949, 10867, 11298, 11490, 10407, 10706,
			10709, 10712, 10715, 10718, 10721, 10724, 10727, 10730, 10733,
			10736, 10739, 10742, 10745, 10748, 10751, 10754, 10757, 10760,
			10763, 10766, 10769, 10771, 11824, 11974, 11938, 11939, 11940,
			11168, 11165, 11164, 11160, 11156, 11144, 11140, 11136, 7663, 7652,
			7646, 7645, 7649, 7627, 7641, 7639, 7637, 7635, 7633, 7629, 7631,
			7621, 7624, 6621, 4745, 6623, 6858, 6860, 6862, 6856, 6918, 6656,
			7400, 7321, 7323, 7219, 7325, 7327, 7396, 7394, 4732, 4753, 4611,
			6188, 6182, 4511, 4056, 4071, 4724, 2639, 2641, 2643, 2665, 6109,
			5525, 5527, 5529, 5531, 5533, 5535, 5537, 5539, 5541, 5543, 5545,
			5547, 5549, 5551, 74, 579, 656, 658, 660, 662, 664, 740, 1017,
			1037, 1038, 1040, 1042, 1044, 1046, 1048, 1050, 1053, 1055, 1057,
			1137, 1139, 1141, 1143, 1145, 1147, 1149, 1151, 1153, 1155, 1157,
			1159, 1161, 1163, 1165, 1506, 1949, 2422, 2581, 2587, 2595, 2605,
			2613, 2619, 2627, 2631, 2633, 2635, 2637, 2651, 2657, 2673, 2900,
			2910, 2920, 2930, 2940, 2978, 2979, 2980, 2981, 2982, 2983, 2984,
			2985, 2986, 2987, 2988, 2989, 2990, 2991, 2992, 2993, 2994, 2995,
			3057, 3385, 3486, 3748, 3749, 3751, 3753, 3755, 3797, 4041, 4042,
			4071, 4089, 4099, 4109, 4164, 4302, 4506, 4511, 4513, 4515, 4551,
			4567, 4708, 4716, 4724, 4753, 4856, 4857, 4858, 4859, 4880, 4881,
			4882, 4883, 4904, 4905, 4906, 4907, 4952, 4953, 4954, 4955, 4976,
			4977, 4978, 4979, 5013, 5014, 5554, 5574, 6109, 6128, 6131, 6137,
			6182, 6188, 6335, 6337, 6339, 6345, 6355, 6365, 6375, 6382, 6392,
			6400, 2518, 2524, 2526};
	public static boolean[] itemIsNote = new boolean[19999];
	public static boolean[] itemSellable = new boolean[19999];
	public static boolean[] itemStackable = new boolean[19999];
	public static boolean[] itemTradeable = new boolean[19999];
	public static boolean[] itemTwoHanded = new boolean[19999];
	public static int legs[] = {2898,2908,2918,2928,2938,2522,648, 650, 652, 10331, 11155, 10626, 10629, 11272, 11447,
			10929, 10932, 10936, 10938, 10940, 10942, 10926, 11139, 8649,
			10223, 10409, 11978, 11976, 11201, 11202, 11203, 11174, 11176,
			11178, 11180, 11182, 11184, 11186, 11188, 11172, 11170, 11166,
			11167, 11163, 11159, 11142, 11135, 1845, 6789, 7116, 7126, 7132,
			7138, 7128, 7134, 7138, 6752, 6627, 7593, 6324, 6135, 6130, 6141,
			6108, 6625, 6809, 6924, 6655, 7386, 7388, 7366, 7368, 7398, 7382,
			7384, 7380, 7378, 1835, 538, 1033, 5555, 4759, 6386, 6390, 2497,
			2495, 2493, 1099, 4113, 4103, 4093, 6185, 6181, 3059, 4510, 4505,
			4070, 538, 542, 548, 1011, 1013, 1015, 1067, 1069, 1071, 1073,
			1075, 1077, 1079, 1081, 1083, 1085, 1087, 1089, 1091, 1093, 2585,
			2593, 2601, 2609, 2617, 2625, 2655, 2663, 2671, 3059, 3389, 3472,
			3473, 3474, 3475, 3476, 3477, 3478, 3479, 3480, 3483, 3485, 3795,
			4087, 4585, 4712, 4714, 4722, 4730, 4738, 4751, 4759, 4874, 4875,
			4876, 4877, 4898, 4899, 4900, 4901, 4922, 4923, 4924, 4925, 4946,
			4947, 4948, 4949, 4970, 4971, 4972, 4973, 4994, 4995, 4996, 4997,
			5048, 5050, 5052, 5576, 6107, 6130, 6187, 6390, 6386, 6390, 6396,
			6404, 428, 7659, 7662, 7668, 7670, 7690, 7696, 7699 };

	public static int normal_gems[] = { 1623, 1621, 1619, 1617 };
	public static int platebody[] = {577,2896,2906,2916,2926,2936,6654,2520,1107,638 , 640 , 642, 430, 10300, 11154, 11471, 10625, 10628, 10930,
			10933, 10935, 10937, 10939, 10941, 10927, 11998, 11997, 11281,
			10222, 11268, 10408, 11977, 11975, 11198, 11199, 11200, 11173,
			11175, 11177, 11179, 11181, 11183, 11185, 11187, 11171, 11169,
			11162, 11158, 11143, 11138, 11134, 5032, 5028, 6065, 1844, 5034,
			6750, 6617, 5575, 7399, 6322, 6139, 6133, 6129, 7390, 7392, 6916,
			1035, 540, 5553, 4757, 1833, 1835, 6388, 6384, 1355, 4111, 4101,
			4091, 6186, 6184, 6180, 3058, 4509, 4504, 4069, 4728, 4736, 4712,
			6107, 2661, 3140, 1115, 1117, 1119, 1121, 1123, 1125, 1127, 2583,
			2591, 2599, 2607, 2615, 2623, 2653, 2669, 3481, 4720, 4728, 4749,
			2661, 426, 3387, 7695, 544, 7689, 7660, 7670, 7661, 7669, 7698,
			7642, 546, 75 };

	public static int rings[] = { 6583, 6575, 6731, 6733, 6735, 6737, 773,
			1635, 1637, 1639, 1641, 1643, 1645, 2550, 2552, 2554, 2556, 2558,
			2560, 2562, 2564, 2566, 2568, 2570, 2572, 4202, 4657, 6465 };
	public static int shields[] = {1191,3095,3096,3097,3098,3099,3100,3101, 10226, 10227, 10228, 10229, 10230, 10231,
			10232, 10234, 11814, 11815, 11145, 6631, 6633, 6889, 6591, 7332,
			7338, 7344, 7350, 7356, 7334, 1171, 1173, 1175, 1177, 1179, 1181, 1183,
			1185, 1187, 1189, 1191, 1193, 1195, 1197, 1199, 1201, 1540, 2589, 2597,
			2603, 2611, 2621, 2629, 2659, 2667, 2675, 2890, 3122, 3488, 3758,
			3839, 3840, 3841, 3842, 3843, 3844, 4072, 4156, 4224, 4225, 4226,
			4227, 4228, 4229, 4230, 4231, 4232, 4233, 4234, 4302, 4507, 4512,
			6215, 6217, 6219, 6221, 6223, 6225, 6227, 6229, 6231, 6233, 6235,
			6237, 6239, 6241, 6243, 6245, 6247, 6249, 6251, 6253, 6255, 6257,
			6259, 6261, 6263, 6265, 6267, 6269, 6271, 6273, 6275, 6277, 6279,
			6524, 7334, 7340, 7346, 7352, 7358, 7336, 7342, 7348, 7354, 7360,
			1203, 1205, 1207, 1209, 1211, 1213, 1215, 1217, 7625, 7632, 7643,
			7692, 7229, 7228, 7227, 7226, 7225, 11538 };
    public static int Barrows[] = {4734,4710,4724,4726,4728,4730,4718,4718,4732,4736,4738,4716,4720,4722,4753,4747,4755,4757,4759,4708,4712,4714,4745,4749,4751,7462,7462,7462,7462,7462,7462,7462,7462,7462,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592,592};

        public static int randomBarrows()
        {
            return Barrows[(int)(Math.random()*Barrows.length)];
        }
    public static int Clue[] = {3841,3843,3486,3488,3841,3843,3486,3488,3841,3843,3486,3488,2856,2857,2858,2856,2857,2858,2856,2857,2858,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2856,2857,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,2653,2655,2657,2659,2661,2663,2665,2667,2669,2671,2673,2675,638,640,642,648,650,652,658,660,662,2589};

        public static int randomClue()
        {
            return Clue[(int)(Math.random()*Clue.length)];
        }
	public static int shilo_gems[] = { 1623, 1621, 1619, 1617, 1625, 1627, 1629 };
	public static int smithing_frame[][][] = {
			{ { 1205, 1, 1, 1, 1125, 1094 }, { 1351, 1, 1, 1, 1126, 1091 },
					{ 1422, 1, 2, 1, 1129, 1093 },
					{ 1139, 1, 3, 1, 1127, 1102 },
					{ 1277, 1, 3, 1, 1128, 1085 },
					{ 819, 10, 4, 1, 1124, 1107 },
					{ 4819, 15, 4, 1, 13357, 13358 },
					{ 39, 15, 5, 1, 1130, 1108 },
					{ 1321, 1, 5, 2, 1116, 1087 },
					{ 1291, 1, 6, 2, 1089, 1086 },
					{ 1155, 1, 7, 2, 1113, 1103 },
					{ 864, 5, 7, 1, 1131, 1106 },
					{ 1173, 1, 8, 2, 1114, 1104 },
					{ 1337, 1, 9, 3, 1118, 1083 },
					{ 1375, 1, 10, 3, 1095, 1092 },
					{ 1103, 1, 11, 3, 1109, 1098 },
					{ 1189, 1, 12, 3, 1115, 1105 },
					{ 3095, 1, 13, 2, 8428, 8429 },
					{ 1307, 1, 14, 3, 1090, 1088 },
					{ 1087, 1, 16, 3, 1111, 1100 },
					{ 1075, 1, 16, 3, 1110, 1099 },
					{ 1117, 1, 18, 5, 1112, 1101 },/* Specials */
					{ 1794, 1, 4, 1, 1132, 1096 } },
			{ { 1203, 1, 15, 1, 1125, 1094 }, { 1349, 1, 16, 1, 1126, 1091 },
					{ 1420, 1, 17, 1, 1129, 1093 },
					{ 1137, 1, 18, 1, 1127, 1102 },
					{ 1279, 1, 19, 1, 1128, 1085 },
					{ 820, 10, 19, 1, 1124, 1107 },
					{ 4820, 15, 19, 1, 13357, 13358 },
					{ 40, 15, 20, 1, 1130, 1108 },
					{ 1323, 1, 20, 2, 1116, 1087 },
					{ 1293, 1, 21, 2, 1089, 1086 },
					{ 1153, 1, 22, 2, 1113, 1103 },
					{ 863, 5, 22, 1, 1131, 1106 },
					{ 1175, 1, 23, 2, 1114, 1104 },
					{ 1335, 1, 24, 3, 1118, 1083 },
					{ 1363, 1, 25, 3, 1095, 1092 },
					{ 1101, 1, 26, 3, 1109, 1098 },
					{ 1191, 1, 27, 3, 1115, 1105 },
					{ 3096, 1, 28, 2, 8428, 8429 },
					{ 1309, 1, 29, 3, 1090, 1088 },
					{ 1081, 1, 31, 3, 1111, 1100 },
					{ 1067, 1, 31, 3, 1110, 1099 },
					{ 1115, 1, 33, 5, 1112, 1101 },/* Specials */
					{ 4540, 1, 26, 1, 11459, 11461 } },
			{ { 1207, 1, 30, 1, 1125, 1094 }, { 1353, 1, 31, 1, 1126, 1091 },
					{ 1424, 1, 32, 1, 1129, 1093 },
					{ 1141, 1, 33, 1, 1127, 1102 },
					{ 1281, 1, 34, 1, 1128, 1085 },
					{ 821, 10, 34, 1, 1124, 1107 },
					{ 1539, 15, 34, 1, 13357, 13358 },
					{ 41, 15, 35, 1, 1130, 1108 },
					{ 1325, 1, 35, 2, 1116, 1087 },
					{ 1295, 1, 36, 2, 1089, 1086 },
					{ 1157, 1, 37, 2, 1113, 1103 },
					{ 865, 5, 37, 1, 1131, 1106 },
					{ 1177, 1, 38, 2, 1114, 1104 },
					{ 1339, 1, 39, 3, 1118, 1083 },
					{ 1365, 1, 40, 3, 1095, 1092 },
					{ 1105, 1, 41, 3, 1109, 1098 },
					{ 1193, 1, 42, 3, 1115, 1105 },
					{ 3097, 1, 43, 2, 8428, 8429 },
					{ 1311, 1, 44, 3, 1090, 1088 },
					{ 1083, 1, 46, 3, 1111, 1100 },
					{ 1069, 1, 46, 3, 1110, 1099 },
					{ 1119, 1, 48, 5, 1112, 1101 },/* Specials */
					{ 4544, 1, 49, 1, 11459, 11461 },
					{ 2370, 1, 36, 1, 1135, 1134 } },
			{ { 1209, 1, 50, 1, 1125, 1094 }, { 1355, 1, 51, 1, 1126, 1091 },
					{ 1428, 1, 52, 1, 1129, 1093 },
					{ 1143, 1, 53, 1, 1127, 1102 },
					{ 1285, 1, 53, 1, 1128, 1085 },
					{ 822, 10, 54, 1, 1124, 1107 },
					{ 4822, 15, 54, 1, 13357, 13358 },
					{ 42, 15, 55, 1, 1130, 1108 },
					{ 1329, 1, 55, 2, 1116, 1087 },
					{ 1299, 1, 56, 2, 1089, 1086 },
					{ 1159, 1, 57, 2, 1113, 1103 },
					{ 866, 5, 57, 1, 1131, 1106 },
					{ 1181, 1, 58, 2, 1114, 1104 },
					{ 1343, 1, 59, 3, 1118, 1083 },
					{ 1369, 1, 60, 3, 1095, 1092 },
					{ 1109, 1, 61, 3, 1109, 1098 },
					{ 1197, 1, 62, 3, 1115, 1105 },
					{ 3099, 1, 63, 2, 8428, 8429 },
					{ 1315, 1, 64, 3, 1090, 1088 },
					{ 1085, 1, 66, 3, 1111, 1100 },
					{ 1071, 1, 66, 3, 1110, 1099 },
					{ 1121, 1, 68, 5, 1112, 1101 } },
			{ { 1211, 1, 70, 1, 1125, 1094 }, { 1357, 1, 71, 1, 1126, 1091 },
					{ 1430, 1, 72, 1, 1129, 1093 },
					{ 1145, 1, 73, 1, 1127, 1102 },
					{ 1287, 1, 74, 1, 1128, 1085 },
					{ 823, 10, 74, 1, 1124, 1107 },
					{ 4823, 15, 74, 1, 13357, 13358 },
					{ 43, 15, 75, 1, 1130, 1108 },
					{ 1331, 1, 75, 2, 1116, 1087 },
					{ 1301, 1, 76, 2, 1089, 1086 },
					{ 1161, 1, 77, 2, 1113, 1103 },
					{ 867, 5, 77, 1, 1131, 1106 },
					{ 1183, 1, 78, 2, 1114, 1104 },
					{ 1345, 1, 79, 3, 1118, 1083 },
					{ 1371, 1, 80, 3, 1095, 1092 },
					{ 1111, 1, 81, 3, 1109, 1098 },
					{ 1199, 1, 82, 3, 1115, 1105 },
					{ 3100, 1, 83, 2, 8428, 8429 },
					{ 1317, 1, 84, 3, 1090, 1088 },
					{ 1091, 1, 86, 3, 1111, 1100 },
					{ 1073, 1, 86, 3, 1110, 1099 },
					{ 1123, 1, 88, 5, 1112, 1101 } },
			{ { 1213, 1, 85, 1, 1125, 1094 }, { 1359, 1, 86, 1, 1126, 1091 },
					{ 1432, 1, 87, 1, 1129, 1093 },
					{ 1147, 1, 88, 1, 1127, 1102 },
					{ 1289, 1, 89, 1, 1128, 1085 },
					{ 824, 10, 89, 1, 1124, 1107 },
					{ 4824, 15, 89, 1, 13357, 13358 },
					{ 44, 15, 90, 1, 1130, 1108 },
					{ 1333, 1, 90, 2, 1116, 1087 },
					{ 1303, 1, 91, 2, 1089, 1086 },
					{ 1163, 1, 92, 2, 1113, 1103 },
					{ 868, 5, 92, 1, 1131, 1106 },
					{ 1185, 1, 93, 2, 1114, 1104 },
					{ 1347, 1, 94, 3, 1118, 1083 },
					{ 1373, 1, 95, 3, 1095, 1092 },
					{ 1113, 1, 96, 3, 1109, 1098 },
					{ 1201, 1, 97, 3, 1115, 1105 },
					{ 3101, 1, 98, 2, 8428, 8429 },
					{ 1319, 1, 99, 3, 1090, 1088 },
					{ 1093, 1, 99, 3, 1111, 1100 },
					{ 1079, 1, 99, 3, 1110, 1099 },
					{ 1127, 1, 99, 5, 1112, 1101 } }
	// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
	// dagger axe mace medium sword dart tips nails arrow heads scimitar long sword
	// full helmet knives square warhammer battle axe chain kite claws 2-handed
	// skirt legs body lantern/wire studs
	};
	public static int SmithingItems[][] = new int[5][5];
	static {
		int counter = 0;
		int c;
		try {
			FileInputStream dataIn = new FileInputStream(new File(
					"data/stackable.dat"));
			while ((c = dataIn.read()) != -1) {
				if (c == 0)
					itemStackable[counter] = false;
				else
					itemStackable[counter] = true;
				counter++;
			}
			dataIn.close();
			itemStackable[6685] = false;
			itemStackable[6687] = false;
			itemStackable[6689] = false;
			itemStackable[6691] = false;
			itemStackable[6570] = false;
			itemStackable[6737] = false;
			int[] runeId = {553, 3706, 6430, 6432, 565, 6428, 6422, 566, 6434, 6424 };
			for (int i = 0; i < runeId.length; i++) {
				itemStackable[runeId[i]] = true;
			}
		} catch (IOException e) {
			System.out
					.println("Critical error while loading stackabledata! Trace:");
			e.printStackTrace();
		}

		counter = 0;
		try {
			FileInputStream dataIn = new FileInputStream(new File(
					"data/notes.dat"));
			while ((c = dataIn.read()) != -1) {
				if (c == 0)
					itemIsNote[counter] = true;
				else
					itemIsNote[counter] = false;
				counter++;
			}
			dataIn.close();
		} catch (IOException e) {
			System.out.println("Critical error while loading notedata! Trace:");
			e.printStackTrace();
		}

		counter = 0;
		try {
			FileInputStream dataIn = new FileInputStream(new File(
					"data/twohanded.dat"));
			while ((c = dataIn.read()) != -1) {
				if (c == 0)
					itemTwoHanded[counter] = false;
				else
					itemTwoHanded[counter] = true;
				counter++;
			}
			dataIn.close();
		} catch (IOException e) {
			System.out
					.println("Critical error while loading twohanded! Trace:");
			e.printStackTrace();
		}

		counter = 0;
		try {
			FileInputStream dataIn = new FileInputStream(new File(
					"data/tradeable.dat"));
			while ((c = dataIn.read()) != -1) {
				if (c == 0)
					itemTradeable[counter] = false;
				else
					itemTradeable[counter] = true;
				counter++;
			}
			dataIn.close();
		} catch (IOException e) {
			System.out
					.println("Critical error while loading tradeable! Trace:");
			e.printStackTrace();
		}

		counter = 0;
		try {
			FileInputStream dataIn = new FileInputStream(new File(
					"data/sellable.dat"));
			while ((c = dataIn.read()) != -1) {
				if (c == 0)
					itemSellable[counter] = true;
				else
					itemSellable[counter] = false;
				counter++;
			}
			dataIn.close();
			itemSellable[6570] = false;
			itemSellable[3101] = false;
			itemSellable[1949] = false;
			itemSellable[430] = false;
			itemSellable[1053] = false;
			itemSellable[1054] = false;		
			itemSellable[1055] = false;
			itemSellable[1056] = false;
			itemSellable[1057] = false;
			itemSellable[1058] = false;
			itemSellable[771] = false;
			itemSellable[772] = false;
			itemSellable[1891] = false;
			itemSellable[1892] = false;
			itemSellable[983] = false;
			itemSellable[1550] = false;
			itemSellable[4031] = false;
			itemSellable[4035] = false;
			itemSellable[1613] = false;
			itemSellable[1629] = false;
		} catch (IOException e) {
			System.out.println("Critical error while loading sellable! Trace:");
			e.printStackTrace();
		}
	}

   public static boolean isHelm(int itemID) {
      for (int element : Helm)
         if (element == itemID)
            return true;
      return false;
   }

	public static boolean isFullHelm(int itemID) {
		for (int element : fullHelm)
			if (element == itemID)
				return true;
		return false;
	}

	public static boolean isFullMask(int itemID) {
		for (int element : fullMask)
			if (element == itemID)
				return true;
		return false;
	}

	public static boolean isPlate(int itemID) {
		for (int element : platebody)
			if (element == itemID)
				return true;
		return false;
	}

	public static int randomAmulet() {
		return amulets[(int) (Math.random() * amulets.length)];
	}

	public static int randomArrows() {
		return arrows[(int) (Math.random() * arrows.length)];
	}

	public static int randomBody() {
		return body[(int) (Math.random() * body.length)];
	}

	public static int randomBoots() {
		return boots[(int) (Math.random() * boots.length)];
	}

	public static int randomCape() {
		return capes[(int) (Math.random() * capes.length)];
	}

	public static int randomGloves() {
		return gloves[(int) (Math.random() * gloves.length)];
	}

	public static int randomHat() {
		return hats[(int) (Math.random() * hats.length)];
	}

	public static int randomLegs() {
		return legs[(int) (Math.random() * legs.length)];
	}

	public static int randomNGems() {
		return normal_gems[(int) (Math.random() * normal_gems.length)];
	}

	public static int randomPHat() {
		return crackers[(int) (Math.random() * crackers.length)];
	}

	public static int randomRing() {
		return rings[(int) (Math.random() * rings.length)];
	}

	public static int randomSGems() {
		return shilo_gems[(int) (Math.random() * shilo_gems.length)];
	}

	public static int randomShield() {
		return shields[(int) (Math.random() * shields.length)];
	}
}