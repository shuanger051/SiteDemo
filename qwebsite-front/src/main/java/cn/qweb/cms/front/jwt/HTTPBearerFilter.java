package cn.qweb.cms.front.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xuebj on 2017/2/8.
 */
public class HTTPBearerFilter extends OncePerRequestFilter {

    private Audience audience;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(audience.getEnable()) {
            String auth = request.getHeader("Authorization");
            if ((auth != null) && (auth.length() > 7)) {
                String HeadStr = auth.substring(0, 6).toLowerCase();
                if (HeadStr.compareTo("bearer") == 0) {
                    auth = auth.substring(7, auth.length());
                    Claims claims = JwtHelper.parseJWT(auth, audience.getMd5String());
                    if (claims != null) {
                        filterChain.doFilter(request, response);
                        return;
                    }
                }
            }
            AJAXUtils.print(response, 403, "凭证错误");
            return;
        }else{
            filterChain.doFilter(request,response);
        }
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }
}
