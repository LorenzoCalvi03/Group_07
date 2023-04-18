package my_shelfy;

public class Object 
{
	public static String[] types = new String[]{"Cat", "Game", "Frame", "Book", "Trophie", "Plant"};
	private
		String m_type;
	public 
		// Constructor of object "Object" with String as args
		Object(String _type) 
		{
			m_type = _type;
		}
	
		String get_type()
		{
			return m_type;
		}
		
		void set_type(String _type)
		{
			m_type = _type;
		}
}
