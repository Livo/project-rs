package server;

public class setConfig {

    public void initializeClientConfiguration(int ID) {
        client c = (client) PlayerHandler.players[ID];
        // TODO: this is sniffed from a session (?), yet have to figure out what
        // each of these does.
        c.setClientConfig(18, 1);
        c.setClientConfig(19, 0);
        c.setClientConfig(25, 0);
        c.setClientConfig(43, 0);
        c.setClientConfig(44, 0);
        c.setClientConfig(75, 0);
        c.setClientConfig(83, 0);
        c.setClientConfig(84, 0);
        c.setClientConfig(85, 0);
        c.setClientConfig(86, 0);
        c.setClientConfig(87, 0);
        c.setClientConfig(88, 0);
        c.setClientConfig(89, 0);
        c.setClientConfig(90, 0);
        c.setClientConfig(91, 0);
        c.setClientConfig(92, 0);
        c.setClientConfig(93, 0);
        c.setClientConfig(94, 0);
        c.setClientConfig(95, 0);
        c.setClientConfig(96, 0);
        c.setClientConfig(97, 0);
        c.setClientConfig(98, 0);
        c.setClientConfig(99, 0);
        c.setClientConfig(100, 0);
        c.setClientConfig(101, 0);
        c.setClientConfig(102, 0);
        c.setClientConfig(104, 0);
        c.setClientConfig(106, 0);
        c.setClientConfig(108, 0);
        c.setClientConfig(115, 0);
        c.setClientConfig(143, 0);
        c.setClientConfig(153, 0);
        c.setClientConfig(156, 0);
        c.setClientConfig(157, 0);
        c.setClientConfig(158, 0);
        c.setClientConfig(166, 0);
        c.setClientConfig(167, 0);
        c.setClientConfig(168, 0);
        c.setClientConfig(169, 0);
        c.setClientConfig(170, 0);
        c.setClientConfig(171, 0);
        c.setClientConfig(172, 0);
        c.setClientConfig(173, 0);
        c.setClientConfig(174, 0);
        c.setClientConfig(203, 0);
        c.setClientConfig(210, 0);
        c.setClientConfig(211, 0);
        c.setClientConfig(261, 0);
        c.setClientConfig(262, 0);
        c.setClientConfig(263, 0);
        c.setClientConfig(264, 0);
        c.setClientConfig(265, 0);
        c.setClientConfig(266, 0);
        c.setClientConfig(268, 0);
        c.setClientConfig(269, 0);
        c.setClientConfig(270, 0);
        c.setClientConfig(271, 0);
        c.setClientConfig(280, 0);
        c.setClientConfig(286, 0);
        c.setClientConfig(287, 0);
        c.setClientConfig(297, 0);
        c.setClientConfig(298, 0);
        c.setClientConfig(301, 0);
        c.setClientConfig(304, 01);
        c.setClientConfig(309, 01);
        c.setClientConfig(311, 01);
        c.setClientConfig(312, 01);
        c.setClientConfig(313, 01);
        c.setClientConfig(330, 01);
        c.setClientConfig(331, 01);
        c.setClientConfig(342, 01);
        c.setClientConfig(343, 01);
        c.setClientConfig(344, 01);
        c.setClientConfig(345, 01);
        c.setClientConfig(346, 01);
        c.setClientConfig(353, 01);
        c.setClientConfig(354, 01);
        c.setClientConfig(355, 01);
        c.setClientConfig(356, 01);
        c.setClientConfig(361, 01);
        c.setClientConfig(362, 01);
        c.setClientConfig(363, 01);
        c.setClientConfig(377, 01);
        c.setClientConfig(378, 01);
        c.setClientConfig(379, 01);
        c.setClientConfig(380, 01);
        c.setClientConfig(383, 01);
        c.setClientConfig(388, 01);
        c.setClientConfig(391, 01);
        c.setClientConfig(393, 01);
        c.setClientConfig(399, 01);
        c.setClientConfig(400, 01);
        c.setClientConfig(406, 01);
        c.setClientConfig(408, 01);
        c.setClientConfig(414, 01);
        c.setClientConfig(417, 01);
        c.setClientConfig(423, 01);
        c.setClientConfig(425, 01);
        c.setClientConfig(427, 01);
        c.setClientConfig(433, 01);
        c.setClientConfig(435, 01);
        c.setClientConfig(436, 01);
        c.setClientConfig(437, 01);
        c.setClientConfig(439, 01);
        c.setClientConfig(440, 01);
        c.setClientConfig(441, 01);
        c.setClientConfig(442, 01);
        c.setClientConfig(443, 01);
        c.setClientConfig(445, 01);
        c.setClientConfig(446, 01);
        c.setClientConfig(449, 01);
        c.setClientConfig(452, 01);
        c.setClientConfig(453, 01);
        c.setClientConfig(455, 01);
        c.setClientConfig(464, 01);
        c.setClientConfig(465, 01);
        c.setClientConfig(470, 01);
        c.setClientConfig(482, 01);
        c.setClientConfig(486, 01);
        c.setClientConfig(491, 01);
        c.setClientConfig(492, 01);
        c.setClientConfig(493, 01);
        c.setClientConfig(496, 01);
        c.setClientConfig(497, 01);
        c.setClientConfig(498, 01);
        c.setClientConfig(499, 01);
        c.setClientConfig(502, 01);
        c.setClientConfig(503, 01);
        c.setClientConfig(504, 01);
        c.setClientConfig(505, 01);
        c.setClientConfig(506, 01);
        c.setClientConfig(507, 01);
        c.setClientConfig(508, 01);
        c.setClientConfig(509, 01);
        c.setClientConfig(510, 01);
        c.setClientConfig(511, 01);
        c.setClientConfig(512, 01);
        c.setClientConfig(515, 01);
        c.setClientConfig(518, 01);
        c.setClientConfig(520, 01);
        c.setClientConfig(521, 01);
        c.setClientConfig(524, 01);
        c.setClientConfig(525, 01);
        c.setClientConfig(531, 01);
    }
    public void turnPrayOff(int ID) {
        client c = (client) PlayerHandler.players[ID];
        c.setClientConfig(83, 0);
        c.setClientConfig(84, 0);
        c.setClientConfig(85, 0);
        c.setClientConfig(86, 0);
        c.setClientConfig(87, 0);
        c.setClientConfig(88, 0);
        c.setClientConfig(89, 0);
        c.setClientConfig(90, 0);
        c.setClientConfig(91, 0);
        c.setClientConfig(92, 0);
        c.setClientConfig(93, 0);
        c.setClientConfig(94, 0);
        c.setClientConfig(95, 0);
        c.setClientConfig(96, 0);
        c.setClientConfig(97, 0);
        c.setClientConfig(98, 0);
        c.setClientConfig(99, 0);
        c.setClientConfig(100, 0);
        c.setClientConfig(101, 0);
        c.setClientConfig(102, 0);
    }
} //ends setConfig handler