package com.demo.user;

import com.demo.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * UserValidator.
 */
public class UserValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("user.user_id", "uesr_idMsg", "请输入Userid!");
		validateRequiredString("user.user_name", "user_nameMsg", "请输入User用户名!");
		validateRequiredString("user.user_pwd", "user_pwdMsg", "请输入User密码!");
		validateRequiredString("user.email", "emailMsg", "请输入User邮箱!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(User.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/user/save"))
			controller.render("add.html");
		else if (actionKey.equals("/user/update"))
			controller.render("edit.html");
	}
}
