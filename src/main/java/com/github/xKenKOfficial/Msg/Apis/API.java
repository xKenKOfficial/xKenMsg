package com.github.xKenKOfficial.Msg.Apis;

import com.github.xKenKOfficial.Msg.Basic.Main;
import com.github.xKenKOfficial.Msg.Utils.ChatUtil;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class API
{
    private static API api = new API();

    private static List<Player> socialSpy = new ArrayList<Player>();

    private static final String ENABLED = Main.getPlugin().getConfig().getString("admin_socialspy_enable");
    private static final String DISABLED = Main.getPlugin().getConfig().getString("admin_socialspy_disable");
    private static final String ADMIN_MESSAGE = Main.getPlugin().getConfig().getString("socialspy_admin_message");

    public void setSocialSpy(Player admin) {
        if(!socialSpy.contains(admin)) {
            socialSpy.add(admin);
            admin.sendMessage(ChatUtil.fixColor(ENABLED));
        } else if(socialSpy.contains(admin)) {
            socialSpy.remove(admin);
            admin.sendMessage(ChatUtil.fixColor(DISABLED));
        }
    }

    public void sendAdminMessage(String nickname1, String nickname2, String message) {
        for(final Player admins : Bukkit.getOnlinePlayers()) {
            if(socialSpy.contains(admins)) {
                admins.sendMessage(ChatUtil.fixColor(ADMIN_MESSAGE.replace("{GRACZ1}", nickname1).replace("{GRACZ2}", nickname2).replace("{WIADOMOSC}", message)));
            }
        }
    }

    public static List<Player> getSocialSpy()
    {
        return socialSpy;
    }

    public static API getAPI()
    {
        return api;
    }
}
