package app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
public class AppGlobalRequestInterceptor extends HandlerInterceptorAdapter {

    private final AppProperty appProperty = AppBeanContextService.getBeanFromContext(AppProperty.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // LOGGER.info("PreHandle SessionId: {}, RequestContextPath: {}, RequestURI: {}", request.getSession().getId(), request.getContextPath(), request.getRequestURI());

        HttpSession session = request.getSession();
        if (RequestURL.getStatelessURL_List().contains(request.getRequestURI()) ||
                request.getRequestURI().startsWith("/webjars") ||
                request.getRequestURI().startsWith("/js/") || request.getRequestURI().startsWith("/css/")) {

            return super.preHandle(request, response, handler);

        } else {
            return super.preHandle(request, response, handler);
        }
        // return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.debug("PostHandle SessionId: {}", request.getSession().getId());

        if (null != modelAndView) {
            Map<String, Object> x = modelAndView.getModel();
            x.put("appProperty", appProperty);
        }
        super.postHandle(request, response, handler, modelAndView);
    }

}
