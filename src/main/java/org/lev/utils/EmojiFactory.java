package org.lev.utils;

import com.vdurmont.emoji.EmojiParser;

public final class EmojiFactory {

    public static String getBlueDiamond(){
        return EmojiParser.parseToUnicode(":small_blue_diamond:");
    }

    public static String getStar(){
        return EmojiParser.parseToUnicode(":star:");
    }

    public static String getRingedPlanet(){
        return EmojiParser.parseToUnicode(":ringed_planet:");
    }

    public static String getFire(){
        return EmojiParser.parseToUnicode(":fire:");
    }

    public static String getWarning(){
        return EmojiParser.parseToUnicode(":warning:");
    }

    public static String getExclamation(){
        return EmojiParser.parseToUnicode(":exclamation:");
    }
    public static String getClock4(){
        return EmojiParser.parseToUnicode(":clock4:");
    }
    public static String getEnvelopeWithArrow(){
        return EmojiParser.parseToUnicode(":envelope_with_arrow:");
    }

}
