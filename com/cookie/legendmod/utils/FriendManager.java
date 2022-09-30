//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import java.util.*;

public class FriendManager
{
    public static ArrayList<String> friendsList;
    
    public static void addFriend(final String friendname) {
        if (!FriendManager.friendsList.contains(friendname)) {
            FriendManager.friendsList.add(friendname);
        }
    }
    
    public static void removeFriend(final String friendname) {
        if (FriendManager.friendsList.contains(friendname)) {
            FriendManager.friendsList.remove(friendname);
        }
    }
    
    public static void clear() {
        if (!FriendManager.friendsList.isEmpty()) {
            FriendManager.friendsList.clear();
        }
    }
    
    static {
        FriendManager.friendsList = new ArrayList<String>();
    }
}
