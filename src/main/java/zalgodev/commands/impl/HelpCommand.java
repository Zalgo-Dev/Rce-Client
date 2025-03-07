package zalgodev.commands.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import zalgodev.commands.Command;
import zalgodev.commands.CommandManager;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "Affiche la liste des commandes disponibles.", CommandManager.getPrefix() + "help");
    }

    @Override
    public void execute(MinecraftClient client, String[] args) {
        if (client.player == null) return;

        client.player.sendMessage(Text.of("§6--- Liste des commandes ---"), false);
        for (Command command : CommandManager.getCommands()) {
            client.player.sendMessage(Text.of("§a" + CommandManager.getPrefix() + command.getName() + " §7- " + command.getDescription()), false);
        }
    }
}
