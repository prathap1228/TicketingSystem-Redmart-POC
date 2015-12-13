package com.redmart.type;

/**
 * 
 * @author prathap
 *
 */
public enum ApiResultType {
	
	BAD_REQUEST(400), OK(200), NOT_AVAILABLE(404),INTERNAL_SERVER_ERROR(500), NOT_AUTHORISED(401);
	
	private final Integer id;

	private ApiResultType(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
}
