package edu.handong.csee.java.hw3;

public class Parser {
	private StringBuilder find_add = new StringBuilder();
	private String[] find_data_arr;
	private String find_getString;
	private String find_result;
	private StringBuilder detail_add = new StringBuilder();
	private String[] detail_data_arr;
	private String detail_getString;
	private String detail_result;
	private int i=0, j=0, cnt=0;
	
	public String find(String data, String prop) {

		find_add = Util.reset(find_add);
		find_data_arr = Util.getSplit(data, ",\n");
    	
    	for(int i=0;i<find_data_arr.length;i++) {
    		
    		if(find_data_arr[i].contains(prop) || cnt!=0) {
    			find_getString = new String(detail(find_data_arr[i], prop));
    			
    			find_add.insert(find_add.length(), find_getString);
    			find_add.insert(find_add.length(), "\n");
    		}
    	}
    	
    	find_result = Util.SBToString(find_add);
    	
    	return find_result;
	}
	
	public String detail(String data, String prop) {
		
		detail_add = Util.reset(detail_add);
		detail_data_arr = Util.getSplit(data, " : ");
		
		for(i=0;i<detail_data_arr.length;i++) {
			if(cnt!=0) {
				if(detail_data_arr[i+1].contains("}")) cnt=0;
				
				detail_add.insert(detail_add.length(), data);
				break;
			}
			else if(detail_data_arr[i].contains(prop)) {
				if(i==detail_data_arr.length-1)
					continue;
					//detail_getString = new String(detail_data_arr[i]);
				else detail_getString = new String(detail_data_arr[i+1]);
				
				if(detail_getString.contains("{")) {
					cnt++;
					
					for(j=i+1;j<detail_data_arr.length;j++) {
						detail_add.insert(detail_add.length(), detail_data_arr[j]);
					}
					
					break;
				}
				else detail_add.insert(detail_add.length(), detail_getString);
			}
		}
		
		detail_result = Util.SBToString(detail_add);
		
		return detail_result;
	}
}