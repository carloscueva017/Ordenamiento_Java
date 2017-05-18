package sorter;

public enum SortingMethod {	
	BUBBLE_SORT("Bubble sort"),
	MERGE_SORT("Merge sort");
	
	private String description;
	
	private SortingMethod(String description){
		this.description= description;
	}
	
	protected String getDescription(){
		return this.description;
	}
}
