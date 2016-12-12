package com.demo.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.demo.common.model.User;
import com.demo.method.CheckEmailValidityUtil;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;



/**
 * UserController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(UserInterceptor.class)
public class UserController extends Controller {
	public void index() {
		setAttr("userPage", User.dao.paginate(getParaToInt(0, 1), 10));
		render("user.html");
	}
	
	public void add() {
	}
	
	@Before(UserValidator.class)
	public void save() {
		getModel(User.class).save();
		redirect("/user");
	}
	
	public void edit() {
		setAttr("user", User.dao.findById(getParaToInt()));
	}
	
	@Before(UserValidator.class)
	public void update() {
		getModel(User.class).update();
		redirect("/user");
	}
	
	public void delete() {
		User.dao.deleteById(getParaToInt());
		redirect("/user");
	}
	//登录接口
	public void login()  {
		try{
			BufferedReader reader = this.getRequest().getReader();
			String[] result = new String[2];
			String line = null;
			int i = 0;
			while((line = reader.readLine()) != null){
				result[i] = line;
				i++;
			}
			reader.close();
			List<User> users = User.dao.getlistuser();
			int j = 0;
			String user_name = "";
			String user_pwd = "";
			String user_id = "";
			while(j < users.size()){
				User user = users.get(j);
				user_name = user.getUserName();
				user_pwd = user.getUserPwd();
				if(result[0].equals(user_name)&&result[1].equals(user_pwd)){
					user_id = user.getUserId();
					break;
				}
				j++;
			}
			if(user_id != ""){
				renderText(user_id);
			}else{
				renderText("用户名或密码不正确");
			}
		}catch(Exception ex){
			
		}
		
	}
	//注册接口
	public void regist(){
		BufferedReader reader;
		try {
			reader = this.getRequest().getReader();
			String[] result = new String[3];
			result[0] = "";
			result[1] = "";
			result[2] = "";
			String line = null;
			int i = 0;
			while((line = reader.readLine()) != null){
				result[i] = line;
				i++;
			}
			reader.close();
			List<User> users = User.dao.getlistuser();
			if(result[1].equals(result[2])){
				CheckEmailValidityUtil c = new CheckEmailValidityUtil();
				if(c.isEmailValid(result[0]) == true){
					int j = 0;
					String user_name = "";
					int f = 0;
					while(j < users.size()){
						User user = users.get(j);
						user_name = user.getUserName();
						if(user_name.equals(result[0])){
							render("该邮箱已注册");
							f = 1;
							break;
						}
						j++;
					}
					if(f == 1){
						User.dao.adduser(result[0], result[1]);
						renderText("注册成功");
					}
				}else{
					renderText("输入邮箱不合法");
				}
			}else{
				renderText("密码输入不一致");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


