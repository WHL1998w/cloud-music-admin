package com.soft1851.music.admin.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * @ClassName LoginDto
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/4/21
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @Size(max = 15,message = "用户民不能大于15")
    @NotNull(message = "姓名不能为空")
    private String name;

    @Size(min = 6,max = 16,message = "密码不能小于6位大于16位")
    @NotNull(message = "密码不能为空")
    private String password;

    @Size(min = 4,max = 6,message = "验证码输入有误")
    @NotNull(message = "验证码不能为空")
    private String verifyCode;
}
