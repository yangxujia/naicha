package com.naicha.web;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naicha.app.mode.Contacts;
import com.naicha.app.service.ContactsService;
import com.naicha.app.utils.Codes;
import com.naicha.app.utils.MemCached;
import com.naicha.app.utils.StringTool;


@Controller
@RequestMapping("/contacts")
public class ContactsController {
	@Autowired
	private ContactsService  contactsService;

	/**
	 * 添加好友
	 * @author yangxujia
	 * @date 2015年9月26日下午5:39:17
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public Map<String, Object> save(String friendId,String userIdStr, String token,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringTool.isEmpty(token)||StringTool.isEmpty(friendId)	||StringTool.isEmpty(userIdStr)) {
			map.put("codes", Codes.PARAMETER_IS_EMPTY);
			return map;
		}
		Integer userAId = Integer.parseInt(userIdStr);
		Integer userBId = Integer.parseInt(friendId);
		//校验token
		MemCached cached =  MemCached.getInstance();
		String tokenOld = (String)cached.get(userIdStr);
		if(!token.equals(tokenOld)){
			map.put("codes", Codes.TOKEN_IS_OVER_DUE);
			return map;
		}
		//查看是否已经存在
		BigInteger isExistBigInteger = contactsService.isExist(userAId, userBId);
		if (isExistBigInteger.intValue()==1) {
			//delete;
		}
		Contacts contacts = new Contacts();
		contacts.setUserAId(userAId);
		contacts.setUserBId(userBId);
		contacts.setIsFriend(Codes.FRIEND_YES);
		contacts.setTime(new Date());
		contactsService.save(contacts);
		map.put("codes", Codes.SUCCESS);
		return map;
	}
	
	/**
	 * 加入黑名单
	 * @author yangxujia
	 * @date 2015年9月26日下午5:39:46
	 */
	@RequestMapping("/addToBlockedList.do")
	@ResponseBody
	public Map<String, Object> addToBlockedList(String friendId,String userIdStr, String token,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringTool.isEmpty(token)||StringTool.isEmpty(friendId)	||StringTool.isEmpty(userIdStr)) {
			map.put("codes", Codes.PARAMETER_IS_EMPTY);
			return map;
		}
		Integer userAId = Integer.parseInt(userIdStr);
		Integer userBId = Integer.parseInt(friendId);
		//校验token
		MemCached cached =  MemCached.getInstance();
		String tokenOld = (String)cached.get(userIdStr);
		if(!token.equals(tokenOld)){
			map.put("codes", Codes.TOKEN_IS_OVER_DUE);
			return map;
		}
		//查看是否已经存在
		BigInteger isExistBigInteger = contactsService.isExist(userAId, userBId);
		if(isExistBigInteger.intValue()>0){//如果存在，更新
			contactsService.updateIsFriend(userAId,userBId);
		}else {//如果不存在插入
			Contacts contacts = new Contacts();
			contacts.setUserAId(userAId);
			contacts.setUserBId(userBId);
			contacts.setIsFriend(Codes.FRIEND_B_IS_A_BLOCKED);
			contacts.setTime(new Date());
			contactsService.save(contacts);
		}
		map.put("codes", Codes.SUCCESS);
		return map;
	}
	
}