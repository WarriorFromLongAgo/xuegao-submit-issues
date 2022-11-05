package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.mapper.mpservice.UserInfoTestMpService;
import com.example.demo.model.UserInfoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserInfoTestMpService userInfoTestMpService;

    /**
     * 请先初始化数据
     */
    @Test
    public void init() {
        List<UserInfoTest> userInfoTestList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            UserInfoTest userInfoTest = new UserInfoTest();
            userInfoTest.setUsername("username" + i);
            userInfoTest.setUpdateBy("updateBy" + i);
            userInfoTest.setPassword("password" + i);
            userInfoTest.setId(i);
            userInfoTestList.add(userInfoTest);
        }
        userInfoTestMpService.saveBatch(userInfoTestList);
    }

    @Test
    void testUpdateWrapper() {
        // // 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
        // boolean update(Wrapper<T> updateWrapper);
        // // 根据 whereWrapper 条件，更新记录
        // boolean update(T updateEntity, Wrapper<T> whereWrapper);

        // ==>  Preparing: UPDATE user_info_test SET create_by=? WHERE username=? AND del_flag=? AND (password = ? AND id = ?)
        // ==> Parameters: create_by1111111111(String), username1111111111(String), 1(Integer), password1111111111(String), 1(Integer)
        // <==    Updates: 0

        // 得到的结果是，UpdateWrapper 在更新时，会将对象的字段

        UserInfoTest userInfoTest = new UserInfoTest();
        userInfoTest.setUsername("username1111111111");
        UpdateWrapper<UserInfoTest> updateWrapper = Wrappers.update(userInfoTest)
                .set("create_by", "create_by1111111111")
                .eq("password", "password1111111111")
                .eq("id", 1);
        userInfoTestMpService.update(updateWrapper);
    }

    @Test
    void testUpdateWrapperV2() {
        // // 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
        // boolean update(Wrapper<T> updateWrapper);
        // // 根据 whereWrapper 条件，更新记录
        // boolean update(T updateEntity, Wrapper<T> whereWrapper);

// ==>  Preparing: UPDATE user_info_test SET username=?, del_flag=?, update_by=?, update_time=?, trace_id=?, create_by=? WHERE del_flag=? AND (password = ? AND id = ?)
// ==> Parameters: username1111111111(String), 1(Integer), null, null, null, create_by1111111111(String), 1(Integer), password1111111111(String), 1(Integer)
// <==    Updates: 0

        UserInfoTest userInfoTest = new UserInfoTest();
        userInfoTest.setUsername("username1111111111");
        UpdateWrapper<UserInfoTest> updateWrapper = Wrappers.update(new UserInfoTest())
                .set("create_by", "create_by1111111111")
                .eq("password", "password1111111111")
                .eq("id", 1);
        userInfoTestMpService.update(userInfoTest, updateWrapper);
    }

    @Test
    void testLambdaUpdateWrapper() {
        // ==>  Preparing: UPDATE user_info_test SET create_by=? WHERE username=? AND del_flag=? AND (password = ? AND id = ?)
        // ==> Parameters: create_by222222222(String), username222222222(String), 1(Integer), password222222222(String), 1(Integer)
        // <==    Updates: 0

        UserInfoTest userInfoTest = new UserInfoTest();
        userInfoTest.setUsername("username222222222");
        LambdaUpdateWrapper<UserInfoTest> updateWrapper = Wrappers.lambdaUpdate(userInfoTest)
                .set(UserInfoTest::getCreateBy, "create_by222222222")
                .eq(UserInfoTest::getPassword, "password222222222")
                .eq(UserInfoTest::getId, 2);
        userInfoTestMpService.update(updateWrapper);
    }
}
