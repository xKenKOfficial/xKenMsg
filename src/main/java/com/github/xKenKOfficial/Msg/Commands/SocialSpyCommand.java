package com.github.xKenKOfficial.Msg.Commands;

import com.github.xKenKOfficial.Msg.Apis.API;
import com.github.xKenKOfficial.Msg.Basic.Main;
import com.github.xKenKOfficial.Msg.Utils.ChatUtil;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SocialSpyCommand implements CommandExecutor
{
    private static final String NO_PERMISSION = Main.getPlugin().getConfig().getString("no_permission");
    private static final String WRONG_ARGS = Main.getPlugin().getConfig().getString("wrong_args");

    @Override
    public boolean onCommand(final CommandSender Sender, final Command c, final String l, final String[] args) {
        if(!Sender.hasPermission("xkenmsg.admin.socialspy")) {
            Sender.sendMessage(ChatUtil.fixColor(NO_PERMISSION));
            return false;
        }
        if(Sender instanceof Player) {
            if(args.length < 1) {
                API.getAPI().setSocialSpy((Player)Sender);
                return false;
            } else {
                Sender.sendMessage(ChatUtil.fixColor(WRONG_ARGS));
            }
        } else {
            Sender.sendMessage(ChatColor.DARK_RED + "Tej komendy nie mozna uzywac w konsoli!");
        }
        return false;
    }
}
