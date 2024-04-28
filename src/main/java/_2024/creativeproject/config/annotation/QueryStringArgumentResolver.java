package _2024.creativeproject.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class QueryStringArgumentResolver implements HandlerMethodArgumentResolver {

	private final ObjectMapper om;

	@Override
	public boolean supportsParameter(final MethodParameter parameter) {
		return parameter.getParameterAnnotation(QueryStringArgResolver.class) != null;
	}

	@Override
	public Object resolveArgument(final MethodParameter parameter,
	                              final ModelAndViewContainer mavContainer,
	                              final NativeWebRequest webRequest,
	                              final WebDataBinderFactory binderFactory) throws Exception {
		final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		final String json = queryStringToJson(request.getQueryString());
		return om.readValue(json, parameter.getParameterType());
	}

	private String queryStringToJson(String queryString) {
		queryString = URLDecoder.decode(queryString, StandardCharsets.UTF_8); //한글이 들어올 경우 encoding된 채로 들어오기때문에 디코딩
		StringBuilder res = new StringBuilder();
		res.append("{\"");
		for (char token : queryString.toCharArray()) {
			if (token == '=') {
				res.append('"').append(':').append('"');

			} else if (token == '&') {
				res.append('"').append(',').append('"');
			} else {
				res.append(token);
			}
		}
		res.append("\"}");
		return res.toString();
	}
}
