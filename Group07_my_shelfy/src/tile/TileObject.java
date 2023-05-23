package tile;

public class TileObject {
	
private static String[][] matrix = new String[6][5];
	
	public TileObject(int n){
		switch(n) {
		case 1 :
			matrix=Personal1;
			break;
		case 2 :
			matrix=Personal2;
			break;
		case 3 :
			matrix=Personal3;
			break;	
		case 4 :
			matrix=Personal4;
			break;	
		case 5 :
			matrix=Personal5;
			break;
		case 6 :
			matrix=Personal6;
			break;	
		case 7 :
			matrix=Personal7;
			break;
		case 8 :
			matrix=Personal8;
			break;
		case 9 :
			matrix=Personal9;
			break;
		case 10 :
			matrix=Personal10;
			break;
		case 11 :
			matrix=Personal11;
			break;
		case 12 :
			matrix=Personal12;
			break;
		}
	
	}
	
    private String[][] Personal1 = {{" pink, - , blue , - , - "}, 
								 {" - , - , - , - , green "},  
								{" - , - , - , white , - "}, 
								{" - , orange , - , - , - "}, 
								{" - , - , - , - , - "}, 
								{" - , - , azure , - , - "}};
    private String[][] Personal2 = {{" - , - , - , - , - "}, 
			                        {" - , pink , - , - , - "},  
			                        {" green , - , orange , - , - "}, 
			                        {" - , - , - , - , white "}, 
			                        {" - , - , - , azure , - "},
		                          	{" - , - , - , - , blue "}};
    private String[][] Personal3 = {{" - , - , - , - , - "}, 
			{" blue , - , - , orange , - "},  
			{" - , - , pink , - , - "}, 
			{" - , green , - , - , blue "}, 
			{" - , - , - , - , - "}, 
			{" white , - , - , - , - "}};
    private String[][] Personal4 = {{"-, - , - , - , orange "}, 
			{" - , - , - , - , - "},  
			{" azure , - , blue , - , - "}, 
			{" - , - , - , pink , - "}, 
			{" - , white , green , - , - "}, 
			{" - , - , - , - , - "}};
    private String[][] Personal5 = {{" - , - , - , - , - "}, 
			{" - , azure , - , - , - "},  
			{" - , - , - , - , - "}, 
			{" - , blue , white , - , - "}, 
			{" - , - , - , - , pink "}, 
			{" orange , - , - , green , - "}};
    private String[][] Personal6 = {{" - , - , azure , - , green "}, 
			{" - , - , - , - , - "},  
			{" - , - , - , white , - "}, 
			{" - , - , - , - , - "}, 
			{" - , orange , - , blue , - "}, 
			{" pink , - , - , - , - "}};
    

    private String[][] Personal7 = 	{{"green","-" ,"-","-" , "-"}, 
									{"-","-" ,"-","blue" , "-"},  
									{"-","pink" ,"-","-" , "-"}, 
									{"azure","-" ,"-","-" , "-"}, 
									{"-","-" ,"-","-" , "orange"}, 
									{"-","-" ,"white","-" , "-"}};
    
    
    private String[][] Personal8 = 	{{"-","-" ,"-","-" , "blue"}, 
									{"-","green" ,"-","-" , "-"},  
									{"-","-" ,"azure","-" , "-"}, 
									{"pink","-" ,"-","-" , "-"}, 
									{"-","-" ,"-","white" , "-"}, 
									{"-","-" ,"-","orange" , "-"}};
    
    private String[][] Personal9 = 	{{"-","-" ,"-","-" , "orange"}, 
									{"-","-" ,"-","-" , "-"},  
									{"-","-" ,"-","green" , "-"}, 
									{"-","-" ,"-","-" , "white"}, 
									{"-","azure" ,"-","-" , "pink"}, 
									{"blue","-" ,"-","-" , "-"}};
   
    private String[][] Personal10 = {{"-","-" ,"-","-" , "azure"}, 
									{"-","orange" ,"-","-" , "-"},  
									{"white","-" ,"-","-" , "-"}, 
									{"-","-" ,"-","green" , "-"}, 
									{"-","blue" ,"-","-" , "-"}, 
									{"-","-" ,"-","pink" , "-"}};
    
    
    private String[][] Personal11 = {{"-","-" ,"pink","-" , "-"}, 
									{"-","white" ,"-","-" , "-"},  
									{"orange","-" ,"-","-" , "-"}, 
									{"-","-" ,"blue","-" , "-"}, 
									{"-","-" ,"-","-" , "green"}, 
									{"-","-" ,"-","azure" , "-"}};
    
    private String[][] Personal12 = {{"-","-" ,"white","-" , "-"}, 
									{"-","pink" ,"-","-" , "-"},  
									{"-","-" ,"blue","-" , "-"}, 
									{"-","-" ,"-","azure" , "-"}, 
									{"-","-" ,"-","-" , "orange"}, 
									{"green","-" ,"-","-" , "-"}};
    
 
}
