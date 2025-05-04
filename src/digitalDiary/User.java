package digitalDiary;

public class User {
	public String username;
	private String password;
	private String entry;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEntry() {
		return entry;
	}
	
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	public String displayUsername() {
		String user;
		user = "- " + username;
		return user;
	}
}
