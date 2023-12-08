package games.twinhead.flowers.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class SeedlingBlock extends PlantBlock {
    public static final MapCodec<SeedlingBlock> CODEC = createCodec(SeedlingBlock::new);
    public static final IntProperty AGE;

    public SeedlingBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(this.getAgeProperty(), 0));
    }

    @Override
    public MapCodec<SeedlingBlock> getCodec() {return CODEC;}

    public IntProperty getAgeProperty() {
        return AGE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    static {
        AGE = Properties.AGE_4;
    }
}
