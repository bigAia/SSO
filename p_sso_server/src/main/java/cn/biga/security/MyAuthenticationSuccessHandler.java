package cn.biga.security;

import cn.biga.model.CommonResultModel;
import cn.biga.util.HttpUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 * 登录成功处理器
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
    private String redirectUrl = "/";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        CommonResultModel resultModel = null;
        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest,httpServletResponse);

        if(null != savedRequest){
            redirectUrl = savedRequest.getRedirectUrl();
        }

        resultModel =  CommonResultModel.newSuccessInstance("登录成功",redirectUrl);
        System.out.println("登陆成功");

        HttpUtil.writeResponse(httpServletResponse,resultModel);
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
