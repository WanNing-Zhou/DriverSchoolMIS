package com.example.ssm.interceptor;


import com.example.ssm.util.Permission;
import com.example.ssm.util.ResponseDataCode;
import com.example.ssm.util.ServiceResult;
import com.example.ssm.util.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

//@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        // 判断请求是否为登录请求 或者是静态资源
        if (requestURI.endsWith("/login") || requestURI.contains("/pages")||requestURI.contains("/static")) {
            return true;
        }

        // 校验权限
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 判断方法上是否有 Permission 注解
            if (method.isAnnotationPresent(Permission.class)) {
                Permission annotation = method.getAnnotation(Permission.class);
                String[] permissionCodes = annotation.value();

                // 获取请求头中的 token 值
                String token = request.getHeader("Authorization");
                if (token == null || token.isEmpty()) {
                    // 如果没有 token 则直接返回未授权错误
                    ServiceResult result = new ServiceResult(ResponseDataCode.UNAUTHORIZED, "未授权，请登录后再试");
                    response.getWriter().write(new ObjectMapper().writeValueAsString(result));
                    return false;
                }

                // 校验 token 是否合法
                String username = tokenUtils.getUsernameFromToken(token);
                if (username == null) {
                    // 如果 token 不合法则也返回未授权错误
                    ServiceResult result = new ServiceResult(ResponseDataCode.UNAUTHORIZED, "非法的登录凭证，请重新登录");
                    response.getWriter().write(new ObjectMapper().writeValueAsString(result));
                    return false;
                }

                // TODO：根据用户权限验证是否有访问所需权限

                // 检查每个要求的权限是否都被允许
                boolean isPermitted = true;
                for (String permissionCode : permissionCodes) {
                    if (!checkPermission(username, permissionCode)) {
                        isPermitted = false;
                        break;
                    }
                }

                if (!isPermitted) {
                    //如果没有权限则返回错误信息
                    ServiceResult result = new ServiceResult(ResponseDataCode.FORBIDDEN, "权限不足，无法访问");
                    response.getWriter().write(new ObjectMapper().writeValueAsString(result));
                    return false;
                }

                // 权限验证成功，放行请求
                return true;
            }
        }

        // 没有 Permission 注解，则直接通过拦截器
        return true;
    }


    public Boolean checkPermission(String  username, String permissionCode){
        return  false;
    }
}