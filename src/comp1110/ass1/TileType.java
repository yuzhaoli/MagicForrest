package comp1110.ass1;

/**
 * This enum represents the three kinds of tiles (curves, bridges and intersections),
 * and implements some of their behavior.
 */
public enum TileType {
  CURVE,
  BRIDGE,
  INTERSECTION;

  /**
   * Determine the set of next positions upon reaching a given tile.
   * <p>
   * Curve tiles will return a set of size one, containing the neighbour
   * that is connected to the neighbour last visited.   This will
   * depend on the orientation of the curve tile.   For example, if a
   * curve tile was at position 18 in the upright (NORTH) orientation
   * and was visited from position 13, then the array { 19 } should be
   * returned since the destination would be 19.   On the other hand,
   * if the tile were rotated 90 degrees, in the EAST orientation, then
   * the array { 17 } would be returned, since the destination would be
   * 17.
   * <p>
   * Bridge tiles will return a set of size one, containing the
   * neighbour that is connected to the neighbour last visited. This
   * does not depend on the orientation of the bridge tile.   For
   * example, if a bridge tile was at position 11, and was visited from
   * position 16, then the array { 6 } would be returned, since the
   * desitnation would be 6.   On the other hand, if it were visited
   * from 10, then the array { 12 } would be returned.
   * <p>
   * Intersection tiles will return a set of size three containing
   * all of their neighbours excluding the tile that this visit came
   * from.   For example, if an intersection tile was at position 6,
   * and was visited from position 11, then this function would return
   * the array { 1, 5, 7} since they are the three direct neighbours
   * of 6 excluding 11.
   *
   * @param position
   * @param from
   * @param orientation
   * @return
   */
  int[] nextPositions(int position, int from, Direction orientation) {
    return null; // TODO Task 11
  }

  /**
   * Given a tile ID, return the correct TileType
   *
   * @param id The tile ID, a number from 0 ... 8.
   * @return The TileType corresponding to the id.
   */
  static TileType fromTileID(int id) {
    if (id >= 0 && id <= 3)
      return TileType.CURVE;
    else if (id >= 4 && id <= 5)
      return TileType.BRIDGE;
    else if (id >= 6 && id <= 8)
      return TileType.INTERSECTION;
    else
      assert false;
    return null;
  }
}
