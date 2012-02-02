package server.PlayerActions;

import server.client;

public class MusicSystem {






public MusicSystem() {

}

public void check(client c) {
if(c.absX == 2964 && c.absY == 3394){
c.sM("Falador music playing.");
//c.outStream.createFrame(74);
//c.outStream.writeWordBigEndian(106);

} else
if (c.absX >= 3205 && c.absX <= 3216 && c.absY >= 3209 && c.absY <= 3229) {
c.outStream.createFrame(74);//lumby castle
            c.outStream.writeWordBigEndian(76);
} else
if(c.absX >= 3265 && c.absX <= 3351 && c.absY >= 3143 && c.absY <= 3324) {
c.sM("Alkharid music playing! - test2");
c.outStream.createFrame(74);
            c.outStream.writeWordBigEndian(123);
} else
if(c.absX >= 2935 && c.absX <= 3065 && c.absY >= 3311 && c.absY <= 3389) {
c.sM("Falador music playing! - test2");
c.outStream.createFrame(74);
            c.outStream.writeWordBigEndian(72);
} else
if(c.absX >= 3192 && c.absX <= 3265 && c.absY >= 3146 && c.absY <= 3254) {
c.sM("Lumbridge music playing!");
c.outStream.createFrame(74);
            c.outStream.writeWordBigEndian(76);
} else
if(c.absX >= 3150 && c.absX <= 3311 && c.absY >= 3354 && c.absY <= 3487) {
c.sM("Varrock music playing!");
c.outStream.createFrame(74);
            c.outStream.writeWordBigEndian(106);

} else {
c.outStream.createFrame(74);
            c.outStream.writeWordBigEndian(99);
c.sM("Else");


}
}
}



