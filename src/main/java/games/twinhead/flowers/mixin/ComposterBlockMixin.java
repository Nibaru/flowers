package games.twinhead.flowers.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.InventoryProvider;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ComposterBlock.class)
public class ComposterBlockMixin extends Block implements InventoryProvider {


    public ComposterBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return null;
    }

    @Inject(method = "registerDefaultCompostableItems", at = @At("TAIL"), cancellable = true)
    private static void injected(CallbackInfo ci) {

    }
}
