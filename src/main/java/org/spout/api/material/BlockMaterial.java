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
package org.spout.api.material;

import org.spout.api.Source;
import org.spout.api.collision.CollisionVolume;
import org.spout.api.geo.World;
import org.spout.api.material.block.BlockFace;

public interface BlockMaterial extends ItemMaterial {

	public float getFriction();

	public BlockMaterial setFriction(float slip);

	public float getHardness();

	public BlockMaterial setHardness(float hardness);

	public byte getLightLevel();

	public BlockMaterial setLightLevel(byte level);

	/**
	 * True if no light can pass through this block
	 * 
	 * @return opacity
	 */
	public boolean isOpaque();
	
	/**
	 * Gets the amount of light blocked by this block.
	 * 
	 * 0xF (15) represents a fully opaque block.
	 * @return opacity
	 */
	public byte getOpacity();

	/**
	 * Sets the amount of light blocked  by this block.
	 * 
	 * 0xF (15) represents a fully opaque block.
	 * @param level of opacity
	 * @return this material
	 */
	public BlockMaterial setOpacity(byte level);

	/**
	 * Gets the bounding box area of this material
	 *
	 * @return area
	 */
	public CollisionVolume getBoundingArea();

	/**
	 * True if this block requires physic updates when a neighbor block changes,
	 * false if not.
	 *
	 * @return if this block requires physics updates
	 */
	public boolean hasPhysics();

	/**
	 * Called when a block adjacent to this material is changed.
	 *
	 * @param world that the material is in
	 * @param x coordinate for this material
	 * @param y coordinate for this material
	 * @param z coordinate for this material
	 */
	public void onUpdate(World world, int x, int y, int z);

	/**
	 * Called when this block has been destroyed.
	 *
	 * @param world that the material is in
	 * @param x coordinate for this material
	 * @param y coordinate for this material
	 * @param z coordinate for this material
	 */
	public void onDestroy(World world, int x, int y, int z);
	
	/**
	 * Called when this block is placed.
	 *
	 * @param world that the material is in
	 * @param x coordinate for this material
	 * @param y coordinate for this material
	 * @param z coordinate for this material
	 * @param data block data to use during placement
	 * @param against face against the block is placed
	 * @param source source of this placement
	 * @return true if placement is handled
	 */
	public boolean onPlacement(World world, int x, int y, int z, short data, BlockFace against, Source source);
	
}
