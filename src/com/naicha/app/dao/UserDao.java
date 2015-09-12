package com.naicha.app.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.naicha.app.mode.User;

public interface UserDao extends Repository<User, Integer> {

	/**
	 * 保存
	 * @return
	 */
	public User save(User user);

	/**
	 * 通过手机号码查找用户
	 * @author yangxujia
	 * @date 2015年9月9日上午9:55:02
	 */
	@Query(nativeQuery=true,value="SELECT headPicture, name,age,profession,address,phone,userType,regitsterTime,naichaNo,perSignature,password FROM user where phone=?1 limit 1")
	public Object[] findByPhone(String phone);

	/**
	 * 通过奶茶号查找用户
	 * @author yangxujia
	 * @date 2015年9月9日上午9:55:02
	 */
	@Query(nativeQuery=true,value="SELECT headPicture, name,age,profession,address,phone,userType,regitsterTime,naichaNo,perSignature,password FROM user where naichaNo=?1 limit 1")
	public Object[] findByNaichaNo(String naicha);
	
	/**
	 * 更新名称
	 * @author yangxujia
	 * @date 2015年9月11日下午4:19:34
	 */
	@Modifying
	@Query(nativeQuery=true,value="update user set name=?1 where phone=?2")
	public Integer updateName(String name, String phone);
	
	/**
	 * 根据phone更改头像
	 * @author yangxujia
	 * @date 2015年9月11日下午4:55:24
	 */
	@Modifying
	@Query(nativeQuery=true,value="update user set headPicture=?1 where phone=?2")
	public Integer updateHeadPicture(String headPicture, String phone);

	/**
	 * 更新奶茶号
	 * @author yangxujia
	 * @date 2015年9月11日下午4:55:24
	 */
	@Modifying
	@Query(nativeQuery=true,value="update user set naichaNo=?1 where phone=?2")
	public Integer updateNaichaNo(String naichaNo, String phone);
	
	/**
	 * 更改性别
	 * @author yangxujia
	 * @date 2015年9月11日下午4:58:21
	 */
	@Modifying
	@Query(nativeQuery=true,value="update user set sex=?1 where phone=?2")
	public Integer updateSex(Integer sex, String phone);

	@Modifying
	@Query(nativeQuery=true,value="update user set hometown=?1 where id=?2")
	public Integer updateHometown(String hometown, int id);

	@Modifying
	@Query(nativeQuery=true,value="update user set hobby=?1 where id=?2")
	public Integer updateHobby(String hobby, int id);
	
	@Modifying
	@Query(nativeQuery=true,value="update user set sid=?1 where id=?2")
	public Integer updateSid(String sid, int id);
	
	@Modifying
	@Query(nativeQuery=true,value="update user set age=?1 where id=?2")
	public Integer updateAge(String age, int id);
	
	@Modifying
	@Query(nativeQuery=true,value="update user set personalNote=?1 where id=?2")
	public Integer updatePersonalNote(String personalNote, int id);
	
	@Modifying
	@Query(nativeQuery=true,value="update user set password=?2 where phone=?1")
	public Integer updatePassword(String phone,String password);

	@Modifying
	@Query(nativeQuery=true,value="update user set birthday=?1 where phone=?2")
	public Integer updateBirthday(Date birthday, String phone);

	@Modifying
	@Query(nativeQuery=true,value="update user set profession=?2 where phone=?1")
	public Integer updateProfession(String phone, String profession);
	
	@Modifying
	@Query(nativeQuery=true,value="update user set address=?2 where phone=?1")
	public Integer updateAddress(String phone, String address);
	
	@Modifying
	@Query(nativeQuery=true,value="update user set perSignature=?2 where phone=?1")
	public Integer updatePerSignature(String phone, String perSignature);
	
	@Modifying
	@Query(nativeQuery=true,value="update user set weixinNo=?2 where phone=?1")
	public Integer updateWeixinNo(String phone, String weixinNo);
}
