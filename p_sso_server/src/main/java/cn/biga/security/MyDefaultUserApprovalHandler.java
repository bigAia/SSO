package cn.biga.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.DefaultUserApprovalHandler;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 * 是否需要用户确定是否授权  设置为true为默认确定授权
 */
public class MyDefaultUserApprovalHandler extends DefaultUserApprovalHandler {
    private boolean isApproved = false;

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        return isApproved;
    }
}
