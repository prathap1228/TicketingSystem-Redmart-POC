package com.redmart.type;

public enum TicketCategoryType {
	
	DELIVERY((short) 0, "Delivery"), PAYMENT((short) 1, "Payment"), PRODUCT((short) 2, "Product");
	
	private final short id;
	private final String name;
    
	public static TicketCategoryType getById(short id) {
	    for(TicketCategoryType e : values()) {
	        if(e.id == id)
	        	return e;
	    }
	    return null;
	 }
	
	private TicketCategoryType(short id, String name){
        this.id = id;
        this.name = name;
    }

    public short getId() {
        return id;
    }
    
    public String getName() {
    	return name;
    }

}
