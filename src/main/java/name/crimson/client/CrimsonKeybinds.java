package name.crimson.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class CrimsonKeybinds {

    public static KeyBinding BOOST;

    public static void register() {
        BOOST = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.crimson.boost",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_R, // change if you want
                        "category.crimson"
                )
        );
    }
}
