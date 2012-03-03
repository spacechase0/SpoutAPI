/*
 * This file is part of SpoutAPI (http://www.spout.org/).
 *
 * SpoutAPI is licensed under the SpoutDev License Version 1.
 *
 * SpoutAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * SpoutAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.api.geo.cuboid;

import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.BlockMaterial;
import org.spout.api.util.thread.DelayedWrite;
import org.spout.api.util.thread.LiveRead;
import org.spout.api.util.thread.SnapshotRead;

/**
 * Represents a cube with an edge length of 1.
 */
public abstract class Block extends Cube {
	private final static float EDGE = 1.0f;

	public Block(World world, float x, float y, float z) {
		super(new Point(world, x, y, z), EDGE);
	}

	/**
	 * Sets the block to the given material type and returns the snapshot value
	 *
	 * @param x the x coordinate
	 * @param y the x coordinate
	 * @param z the x coordinate
	 * @param material
	 * @return the block's material from the snapshot
	 */
	@SnapshotRead
	@DelayedWrite
	public abstract BlockMaterial setBlockMaterial(BlockMaterial material);

	/**
	 * Sets the id for the block to the given id and returns the snapshot value
	 *
	 * For ids greater than 255, the id must represent a value custom id
	 *
	 * @param x the x coordinate
	 * @param y the x coordinate
	 * @param z the x coordinate
	 * @param material
	 * @return the block's material from the snapshot
	 */
	@SnapshotRead
	@DelayedWrite
	public abstract short setBlockId(short id);

	/**
	 * Sets the block light for the block to the given value and returns the snapshot value
	 *
	 * @param value
	 * @return the block's block light from the snapshot
	 */
	@SnapshotRead
	@DelayedWrite
	public abstract int setBlockLight(int value);

	/**
	 * Sets the sky light for the block to the given value and returns the snapshot value
	 *
	 * @param value
	 * @return the block's sky light from the snapshot
	 */
	@SnapshotRead
	@DelayedWrite
	public abstract int setSkyLight(int value);

	/**
	 * Gets the snapshot material for the block
	 *
	 * @param x the x coordinate
	 * @param y the x coordinate
	 * @param z the x coordinate
	 * @param material
	 * @return the block's material from the snapshot
	 */
	@SnapshotRead
	public abstract BlockMaterial getBlockMaterial();

	/**
	 * Gets the snapshot id for the block
	 *
	 * @param x the x coordinate
	 * @param y the x coordinate
	 * @param z the x coordinate
	 * @param material
	 * @return the block's material id from the snapshot
	 */
	@SnapshotRead
	public abstract short getBlockId();

	/**
	 * Gets the snapshot block light for the block
	 *
	 * @return the block's block light from the snapshot
	 */
	@SnapshotRead
	public abstract int getBlockLight();

	/**
	 * Gets the snapshot sky light for the block
	 *
	 * @return the block's sky light from the snapshot
	 */
	@SnapshotRead
	public abstract int getSkyLight();

	/**
	 * Gets the live material for the block
	 *
	 * Note: this may have a negative performance impact, relative to reading
	 * the snapshot value
	 *
	 * @param x the x coordinate
	 * @param y the x coordinate
	 * @param z the x coordinate
	 * @param material
	 * @return the block's material from the snapshot
	 */
	@LiveRead
	public abstract BlockMaterial getLiveBlockMaterial();

	/**
	 * Gets the live id for the block
	 *
	 * Note: this may have a negative performance impact, relative to reading
	 * the snapshot value
	 *
	 * @param x the x coordinate
	 * @param y the x coordinate
	 * @param z the x coordinate
	 * @param material
	 * @return the block's material id from the snapshot
	 */
	@LiveRead
	public abstract short getLiveBlockId();

	/**
	 * Gets the live block light for the block
	 *
	 * Note: this may have a negative performance impact, relative to reading
	 * the snapshot value
	 * 
	 * @return the block's block light
	 */
	@LiveRead
	public abstract int getLiveBlockLight();

	/**
	 * Gets the live sky light for the block
	 *
	 * Note: this may have a negative performance impact, relative to reading
	 * the snapshot value
	 * 
	 * @return the block's sky light
	 */
	@LiveRead
	public abstract int getLiveSkyLight();
}
