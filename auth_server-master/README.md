## postman获取Token ##

1. 打开postman

2. 在Authorization选择Basic Auth，在UserName和Password输入client的用户名和密码

3. 切换到Body，选择form-data，输入key-value分别如下

	    grant_type 	password
	    username 	user1
	    password 	123456789
	    
4. 权限验证调用，输入：`localhost:8080/user` 选择`Bearer Token`，输入获取的token值进行调用

5. 刷新token http://localhost:8080/oauth/token?client_id=client_1&client_secret=123456&grant_type=refresh_token&refresh_token=655e8c5d-d351-40e7-bd15-d413af6142e6 