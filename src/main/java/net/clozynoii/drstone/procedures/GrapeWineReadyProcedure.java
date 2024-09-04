package net.clozynoii.drstone.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.drstone.init.DrstoneModParticleTypes;

public class GrapeWineReadyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StirTimer") <= 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DrstoneModParticleTypes.GRAPE_BUBBLES.get()), (x + 0.5), (y + 1), (z + 0.5), 1, 0.25, 0.25, 0.25, 0);
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WineProgress") == 4) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.5), (z + 0.5), 1, 0.5, 0.5, 0.5, 0);
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StirTimer") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("StirTimer", ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "StirTimer")) - 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
