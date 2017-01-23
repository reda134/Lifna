package blog.controllers;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import blog.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnRegistrationCompleteEvent extends ApplicationEvent
{
    private final String appUrl;
    private final Locale locale;
    private final User user;

    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl)
    {
	super(user);

	this.user = user;
	this.locale = locale;
	this.appUrl = appUrl;
    }

}