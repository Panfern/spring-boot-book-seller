package com.sha.springbootbookseller.Security;

import com.sha.springbootbookseller.util.SecurityUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InternalApiAuthenticationFilter extends OncePerRequestFilter
{

    private final String accessKey;

    public InternalApiAuthenticationFilter(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().startsWith("/api/internal");
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try
        {
            String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);
//            System.out.println(accessKey);
//            System.out.println(requestKey);
            if (requestKey == null || !requestKey.equals(accessKey)) {
                logger.warn("internal key given was "+ requestKey);
                logger.warn("real key is "+ accessKey);
                logger.warn("internal key endpoint requested without/wrong key uri: {" + request.getRequestURI() + "}");
                throw new RuntimeException("UNAUTHORIZED");
            }

            UserPrincipal superUser = UserPrincipal.createSuperUser();
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(superUser, null, superUser.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch(Exception ex)
        {
            logger.error("Could not set user application in security context", ex);
        }

        filterChain.doFilter(request, response);

    }
}
