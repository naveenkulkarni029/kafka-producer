package org.nbk.demo.kafka.producer.model;

public class InternalUser {

    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
	return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
	this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("InternalUser [username=");
	builder.append(username);
	builder.append(", password=");
	builder.append(password);
	builder.append("]");
	return builder.toString();
    }

}
