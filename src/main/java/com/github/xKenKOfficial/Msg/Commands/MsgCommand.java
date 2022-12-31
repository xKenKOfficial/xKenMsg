package com.github.xKenKOfficial.Msg.Commands;

import com.github.xKenKOfficial.Msg.Apis.API;
import com.github.xKenKOfficial.Msg.Basic.Main;
import com.github.xKenKOfficial.Msg.Utils.ChatUtil;
import com.github.xKenKOfficial.Msg.Utils.StringUtil;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor
{
    private static final String NO_PERMISSION = Main.getPlugin().getConfig().getString("no_permission");
    private static final String OFFLINE_PLAYER = Main.getPlugin().getConfig().getString("offline_player");
    private static final String WRONG_ARGS = Main.getPlugin().getConfig().getString("wrong_args");

    private static final String COMMAND_USAGE = Main.getPlugin().getConfig().getString("msg_command_usage");
    private static final String SENDER_MESSAGE = Main.getPlugin().getConfig().getString("msg_sender_message");
    private static final String RECIPIENT_MESSAGE = Main.getPlugin().getConfig().getString("msg_recipient_message");

    @Override
    public boolean onCommand(final CommandSender Sender, final Command c, final String l, final String[] args) {
        if(!Sender.hasPermission("xkenmsg.player.msg")) {
            Sender.sendMessage(ChatUtil.fixColor(NO_PERMISSION));
            return false;
        }
        if(args.length >= 2) {
            final Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                Sender.sendMessage(ChatUtil.fixColor(OFFLINE_PLAYER));
                return false;
            }
            final String message = StringUtil.stringBuilder(args, 1);
            target.sendMessage(ChatUtil.fixColor(RECIPIENT_MESSAGE.replace("{GRACZ}", Sender.getName()).replace("{WIADOMOSC}", message)));
            Sender.sendMessage(ChatUtil.fixColor(SENDER_MESSAGE.replace("{GRACZ}", target.getName()).replace("{WIADOMOSC}", message)));
            API.getAPI().sendAdminMessage(Sender.getName(), target.getName(), message);
            return false;
        } else {
            Sender.sendMessage(ChatUtil.fixColor(COMMAND_USAGE));
        }
        return false;
    }
}
