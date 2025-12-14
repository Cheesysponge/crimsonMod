//
//
//
//
//
// WAS USED FOR SCRAPPED 1.21.2 update
//
//
//
//
//
//
//
//
//
//
//
// package name.crimson.item;
//
//import net.minecraft.item.equipment.EquipmentModel;
//import net.minecraft.util.DyeColor;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.Util;
//
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.BiConsumer;
//
//public interface ModEquipmentModels {
//
//    Identifier RUBY = Identifier.ofVanilla("ruby");
//    Identifier SAPPHIRE = Identifier.ofVanilla("sapphire");
//
//
//    static void accept(BiConsumer<Identifier, EquipmentModel> equipmentModelBiConsumer) {
//        equipmentModelBiConsumer.accept(RUBY, buildHumanoid("ruby"));
//        equipmentModelBiConsumer.accept(SAPPHIRE, buildHumanoid("sapphire"));
//
//
//    }
//
//    private static EquipmentModel buildHumanoid(String path) {
//        return EquipmentModel.builder().addHumanoidLayers(Identifier.ofVanilla(path)).build();
//    }
//}
