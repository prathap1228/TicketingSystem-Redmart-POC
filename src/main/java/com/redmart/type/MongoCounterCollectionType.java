package com.redmart.type;

public enum MongoCounterCollectionType {
	TICKETS((short) 0, "tickets"), USERS((short) 1, "users"), AGENTS((short) 3, "agents");

	private final short id;
	private final String name;

	private MongoCounterCollectionType(short id, String name){
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
