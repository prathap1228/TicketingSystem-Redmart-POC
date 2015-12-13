package com.redmart.type;

/**
 * 
 * @author prathap
 *
 */
public enum TicketStatusType {
	
	OPEN((short) 0, "Open"), PENDING((short) 1, "Pending"), CLOSED((short) 3, "Closed");
	
	private final short id;
	private final String name;
    
	public static TicketStatusType getById(short id) {
	    for(TicketStatusType e : values()) {
	        if(e.id == id)
	        	return e;
	    }
	    return null;
	 }
	
	private TicketStatusType(short id, String name){
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
