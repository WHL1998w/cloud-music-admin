package com.soft1851.music.admin.service;

import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.domain.entity.SysAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SysAdminServiceTest {
    @Resource
    private SysAdminService sysAdminService;

    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder().name("whl").password("123456").build();
        System.out.println(sysAdminService.login(loginDto));
    }

    @Test
    void selectByName() {
        System.out.println(sysAdminService.getAdminAndRolesByName("whl"));
    }

    @Test
    void updateSysAdmin() {
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setId("DE35D7CC05AF96A21D7ADFC8651E6614");
        sysAdmin.setName("whl1");
        sysAdmin.setPassword("654321");
        sysAdmin.setAvatar("测试头像");
        sysAdminService.updateSysAdmin(sysAdmin);
    }
}