package cn.biga.security;

import cn.biga.model.CommonResultModel;
import cn.biga.util.HttpUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 * 登录失败处理器
 */
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private String badCredentialsException = "org.springframework.security.authentication.BadCredentialsException";
    private String lockedException = "org.springframework.security.authentication.LockedException";
    private String disabledException = "org.springframework.security.authentication.DisabledException";
    private String accountExpiredException = "org.springframework.security.authentication.AccountExpiredException";
    private String validateFailException = "cn.biga.security.ValidateFailException";

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (HttpUtil.isAjax(httpServletRequest)) {
            String clazzName = e.getClass().getName();
            String msg = "";
            if (badCredentialsException.equals(clazzName)) {
                msg = "用户名或密码错误！";
            } else if (lockedException.equals(clazzName)) {
                msg = "账号被锁定，请联系管理员！";
            } else if (disabledException.equals(clazzName)) {
                msg = "账号被禁用，请联系管理员！";
            } else if (accountExpiredException.equals(clazzName)) {
                msg = "账号被过期了，请联系管理员！";
            } else if (validateFailException.equals(clazzName)) {
                msg = e.getMessage();
            }

            CommonResultModel result = CommonResultModel.newFailedInstance(msg);
            HttpUtil.writeResponse(httpServletResponse, result);

        } else {
            super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
        }

        System.out.println(e.getMessage() + ":登录失败");
    }
}
