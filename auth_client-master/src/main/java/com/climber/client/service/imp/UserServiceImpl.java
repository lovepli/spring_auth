package com.climber.client.service.imp;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.climber.client.bean.UserInfo;
import com.climber.client.bean.UserInfoDetails;
import com.climber.client.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails rtn = null;
		
		UserInfo user = new UserInfo(1, "user1", "{bcrypt}"+new BCryptPasswordEncoder().encode("123456789"));
//		UserInfo user = new UserInfo(1, "user1", "{MD5}"+MD5Utils.encode("123456789"));
		if(user.getUserName().equals(username)){
			rtn = UserDetailConverter.convert(user);
		}
		return rtn;
	}
	
	
	private static class UserDetailConverter {
        static UserDetails convert(UserInfo user) {
            return new UserInfoDetails(user);
        }
    }

}
