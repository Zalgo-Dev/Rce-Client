package zalgodev.commands;

import net.minecraft.client.MinecraftClient;

public abstract class Command {
    private final String name;
    private final String description;
    private final String usage;

    public Command(String name, String description, String usage) {
        this.name = name;
        this.description = description;
        this.usage = usage;
    }

    public abstract void execute(MinecraftClient client, String[] args);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
