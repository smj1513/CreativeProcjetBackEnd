package _2024.creativeproject.config;

import _2024.creativeproject.config.annotation.QueryStringArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
	private final QueryStringArgumentResolver argResolver;

	@Override
	public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers){
		argumentResolvers.add(argResolver);
	}
}
