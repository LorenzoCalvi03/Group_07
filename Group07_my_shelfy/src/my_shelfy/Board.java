package my_shelfy;
import java.util.*;

public class Board
{
	private
		Tile[][] play_ground = new Tile[Game_Master.g.cols][Game_Master.g.rows];
	
	public
		// Board constructor, initializing private members
		Board()
		{
			for (int i = 0; i < Game_Master.g.cols; ++i)
				for (int j = 0; j < Game_Master.g.rows; ++j)
					play_ground[i][j] = new Tile();
		}
		
		// reused to refill when empty
		void fill()
		{
			Random random = new Random();
			for (int i = 0; i < Game_Master.g.cols; ++i)
				for (int j = 0; j < Game_Master.g.rows; ++j)
				{
					if (Game_Master.g.is_tile_accessible(i, j))
						play_ground[i][j].get_object().set_type(Object.types[random.nextInt(Object.types.length)]);
					else
						play_ground[i][j].get_object().set_type("null");
				}
		}
		
		Tile get_tile(int _x, int _y)
		{
			return play_ground[_x][_y];
		}
}

