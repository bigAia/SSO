package cn.biga.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 */
public class MyClientDetails implements ClientDetails {
    private static final long serialVersionUID = 39L;
    private String clientId;
    private Set<String> resourceId;
    private boolean secretRequired;
    private String clientSecret;
    private boolean scoped;
    private Set<String> scope;
    private Set<String> authorizedGrantTypes;
    private Set<String> registeredRedirectUri;
    private boolean autoApprove;
    private Integer refreshTokenValiditySeconds;
    private Integer accessTokenValiditySeconds;
    private List authorities;
    private Map<String, Object> additionalInformation;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Set<String> getResourceId() {
        return resourceId;
    }

    public void setResourceId(Set<String> resourceId) {
        this.resourceId = resourceId;
    }

    public void setSecretRequired(boolean secretRequired) {
        this.secretRequired = secretRequired;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScoped(boolean scoped) {
        this.scoped = scoped;
    }

    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    public boolean isAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(boolean autoApprove) {
        this.autoApprove = autoApprove;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public void setAuthorities(List authorities) {
        this.authorities = authorities;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return this.resourceId;
    }

    @Override
    public boolean isSecretRequired() {
        return this.secretRequired;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return this.scoped;
    }

    @Override
    public Set<String> getScope() {
        return this.scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.registeredRedirectUri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return this.autoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return this.additionalInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((accessTokenValiditySeconds == null) ? 0
                : accessTokenValiditySeconds);
        result = prime
                * result
                + ((refreshTokenValiditySeconds == null) ? 0
                : refreshTokenValiditySeconds);
        result = prime * result
                + ((authorities == null) ? 0 : authorities.hashCode());
        result = prime
                * result
                + ((authorizedGrantTypes == null) ? 0 : authorizedGrantTypes
                .hashCode());
        result = prime * result
                + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result
                + ((clientSecret == null) ? 0 : clientSecret.hashCode());
        result = prime
                * result
                + ((registeredRedirectUri == null) ? 0
                : registeredRedirectUri.hashCode());
        result = prime * result
                + ((resourceId == null) ? 0 : resourceId.hashCode());
        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
        result = prime * result + ((additionalInformation == null) ? 0 : additionalInformation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyClientDetails other = (MyClientDetails) obj;
        if (accessTokenValiditySeconds == null) {
            if (other.accessTokenValiditySeconds != null)
                return false;
        } else if (!accessTokenValiditySeconds.equals(other.accessTokenValiditySeconds))
            return false;
        if (refreshTokenValiditySeconds == null) {
            if (other.refreshTokenValiditySeconds != null)
                return false;
        } else if (!refreshTokenValiditySeconds.equals(other.refreshTokenValiditySeconds))
            return false;
        if (authorities == null) {
            if (other.authorities != null)
                return false;
        } else if (!authorities.equals(other.authorities))
            return false;
        if (authorizedGrantTypes == null) {
            if (other.authorizedGrantTypes != null)
                return false;
        } else if (!authorizedGrantTypes.equals(other.authorizedGrantTypes))
            return false;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        } else if (!clientId.equals(other.clientId))
            return false;
        if (clientSecret == null) {
            if (other.clientSecret != null)
                return false;
        } else if (!clientSecret.equals(other.clientSecret))
            return false;
        if (registeredRedirectUri == null) {
            if (other.registeredRedirectUri != null)
                return false;
        } else if (!registeredRedirectUri.equals(other.registeredRedirectUri))
            return false;
        if (resourceId == null) {
            if (other.resourceId != null)
                return false;
        } else if (!resourceId.equals(other.resourceId))
            return false;
        if (scope == null) {
            if (other.scope != null)
                return false;
        } else if (!scope.equals(other.scope))
            return false;
        if (additionalInformation == null) {
            if (other.additionalInformation != null)
                return false;
        } else if (!additionalInformation.equals(other.additionalInformation))
            return false;
        return true;
    }

}
