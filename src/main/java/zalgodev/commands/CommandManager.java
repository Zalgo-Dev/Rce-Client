package zalgodev.commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import zalgodev.commands.impl.HelpCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private static final List<Command> commands = new ArrayList<>();
    private static final String prefix = "?";

    public static void init() {
        register(new HelpCommand());
    }

    public static void register(Command command) {
        commands.add(command);
    }

    public static void executeCommand(MinecraftClient client, String input) {
        if (!input.startsWith(prefix)) return;

        String[] parts = input.substring(prefix.length()).split(" ");
        if (parts.length == 0) return;

        String commandName = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);

        for (Command command : commands) {
            if (command.getName().equalsIgnoreCase(commandName)) {
                command.execute(client, args);
                return;
            }
        }

        assert client.player != null;
        client.player.sendMessage(Text.of("§cCommande inconnue : " + prefix + commandName), false);
    }

    public static List<Command> getCommands() {
        return commands;
    }

    public static String getPrefix() {
        return prefix;
    }
}
