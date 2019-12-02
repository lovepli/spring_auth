package com.climber.auth.bean;
import java.util.Collections;

import org.springframework.security.core.userdetails.User;

public class UserInfoDetails extends User {

	private static final long serialVersionUID = 1L;
	
	private UserInfo userInfo;

    public UserInfoDetails(UserInfo userInfo) {
        super(userInfo.getUserName(), userInfo.getPassword(), true, true, true, true, Collections.emptySet());
        this.userInfo = userInfo;
    }

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
    
    
}
