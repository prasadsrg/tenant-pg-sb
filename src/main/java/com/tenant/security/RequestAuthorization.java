package com.tenant.security;

import java.lang.annotation.*;

/**
 * @author Md. Amran Hossain
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequestAuthorization {
}
