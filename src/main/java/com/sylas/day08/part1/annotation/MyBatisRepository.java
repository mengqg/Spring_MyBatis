package com.sylas.day08.part1.annotation;

import org.springframework.stereotype.Repository;

@Repository
public @interface MyBatisRepository {
	String value() default "";
}
