package com.tts.lcy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tts.lcy.mapper.UserMapper;
import com.tts.lcy.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisMpApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		List<User> users = userMapper.selectList(null);
		for (User user: users) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsert(){
		User user = new User();
//		user.setId("10");
		user.setUserName("tobyli");
		user.setPassword("123456");
		user.setName("toby");
		user.setEmail("toby@email.com");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}

	@Test
	public void testUpdateById(){
		User user = new User();
		user.setId("10");
		user.setAge("29");
		int update = userMapper.updateById(user);
		System.out.println(update);
		contextLoads();
	}

	@Test
	public void testUpdateByKey(){
		User user = new User();
		user.setAge("30");
		//更新的条件
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id", "11");

		int update = userMapper.update(user, queryWrapper);
		System.out.println(update);
		contextLoads();
	}

	@Test
	public void testDeleteById(){
		int delete = userMapper.deleteById(10);
		System.out.println(delete);
		contextLoads();
	}

	@Test
	public void testDeleteMap(){
		Map<String, Object> map = new HashMap();
		map.put("age", "30");
		map.put("name", "toby");
		int delete = userMapper.deleteByMap(map);
		System.out.println(delete);
		contextLoads();
	}

	@Test
	public void testARSelectById(){
		User user = new User();
		user.setId("5");
		User user2 = user.selectById();
		System.out.println(user2);
	}

}
