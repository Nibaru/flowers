package games.twinhead.flowers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class DandelionSeedlingBlock extends PlantBlock {
    public static final int MAX_AGE = 4;
    public static final IntProperty AGE;

    public DandelionSeedlingBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(this.getAgeProperty(), 0));
    }

    public IntProperty getAgeProperty() {
        return AGE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    protected int getAge(BlockState state) {
        return (Integer)state.get(this.getAgeProperty());
    }

    static {
        AGE = Properties.AGE_4;
    }
}
