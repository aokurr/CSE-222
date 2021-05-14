public class branch{
	public String employee_names[];
	public int chairs[][];
	public int desks[][];
	public int meeting_tables[][];
	public int bookcases[];
	public int  office_cabinets[];
	public String employee[];
	public branch(){
		int i,j;
		chairs=new int[7][5];
		for( i=0;i<7;i++)
			for(j=0;j<5;j++)
				chairs[i][j]=2;
		
		
		desks=new int[5][4];
		for(i=0;i<5;i++)
			for(j=0;j<4;j++)
				desks[i][j]=2;
		
		meeting_tables=new int[10][4];
		for(i=0;i<10;i++)
			for(j=0;j<4;j++)
				meeting_tables[i][j]=2;
		
		bookcases=new int[12];
		for(i=0;i<12;i++)
			bookcases[i]=2;

		office_cabinets=new int[12];
		for(i=0;i<12;i++)
			office_cabinets[i]=2;

		employee=new String[1];
		employee[0]=new String("ahmet");

	}


}