package com.climber.auth.service.imp;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.climber.auth.bean.UserInfo;
import com.climber.auth.bean.UserInfoDetails;
import com.climber.auth.service.UserService;
import com.climber.auth.utils.MD5Utils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails rtn = null;
		// 通过用户名查询密码,将返回的密文带入UserInfo的第三个参数
		// 选择加密方式为bcrypt
		// UserInfo user = new UserInfo(1, "user1", "{bcrypt}"+new BCryptPasswordEncoder().encode("123456789"));
		// 可选择加密方式为MD5
		UserInfo user = new UserInfo(1, "user1", "{MD5}" + MD5Utils.encode("123456789"));
		if (user.getUserName().equals(username)) {
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
