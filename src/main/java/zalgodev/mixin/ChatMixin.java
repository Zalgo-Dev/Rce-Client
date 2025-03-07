package zalgodev.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import zalgodev.commands.CommandManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatScreen.class)
public class ChatMixin {
    @Inject(method = "sendMessage", at = @At("HEAD"), cancellable = true)
    private void onChatMessage(String message, boolean addToHistory, CallbackInfo ci) {
        if (message.startsWith(CommandManager.getPrefix())) { // Utilise le préfixe configuré
            CommandManager.executeCommand(net.minecraft.client.MinecraftClient.getInstance(), message);
            ci.cancel(); // Empêche l’envoi du message au serveur
        }
    }
}
