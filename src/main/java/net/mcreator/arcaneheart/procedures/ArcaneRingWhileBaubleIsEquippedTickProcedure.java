package net.mcreator.arcaneheart.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.arcaneheart.init.ArcaneHeartModItems;

public class ArcaneRingWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("counter1", (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "counter1") + 1));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "counter1")) % 10 == 0) {
			if (Math.random() < 0.3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcaneHeartModItems.EARTH_MANA_DROP.get()));
					entityToSpawn.setPickUpDelay(Mth.nextInt(RandomSource.create(), 1, 10));
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcaneHeartModItems.FIRE_MANA_DROP.get()));
					entityToSpawn.setPickUpDelay(Mth.nextInt(RandomSource.create(), 1, 10));
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcaneHeartModItems.AIR_MANA_DROP.get()));
					entityToSpawn.setPickUpDelay(Mth.nextInt(RandomSource.create(), 1, 10));
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcaneHeartModItems.WATER_MANA_DROP.get()));
					entityToSpawn.setPickUpDelay(Mth.nextInt(RandomSource.create(), 1, 10));
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcaneHeartModItems.ARCANE_MANA_DROP.get()));
					entityToSpawn.setPickUpDelay(Mth.nextInt(RandomSource.create(), 1, 10));
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
