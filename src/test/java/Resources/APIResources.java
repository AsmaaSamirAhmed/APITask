package Resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	AddUserAPI("api/v1/users"),
	getUserAPI("api/v1/users");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
