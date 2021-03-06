package com.sirding.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 应用于Object属性注解之上，以解决Object与.conf或是.ini文件中属性之间对应的逻辑关系
 * 
 * @author zc.ding
 * @date 20160-06-17
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Option {

	/**
	 * 属性是不是section节点</br>
	 * true 是节点</br>
	 * false 不是节点</br>
	 * @default false
	 * @return
	 */
	boolean isSection() default false;
	
	/**
	 * key值
	 * @default ""
	 * @return
	 */
	String key() default "";
	
	/**
	 * 解析属性时先执行指定的方法
	 * @default ""
	 * @return
	 */
	String beforeMethod() default "";
	
	/**
	 * 属性的注释信息
	 * @default ""
	 * @return
	 */
	String comment() default "";
	
	/**
	 * 是否添加空白行
	 * @default false
	 * @return
	 */
	boolean blankLine() default false;
	
	/**
	 * 屬性值保存标识符 默认值</br>
	 * 1：保存</br>
	 * 2：null empty不保存</br>
	 * 3：不保存</br>
	 * @default 1
	 * @return
	 */
	int saveFlag() default 1;
	
	/**
	 * 不确定是否保存的元素</br>
	 * false : 在要保存的集合中，可以通过asserKeys注解的配置进行过滤</br>
	 * true ： 不再保存的集合中，通过asserKeys注解配置动态添加保存属性的集合中</br>
	 * @default false
	 * @return
	 */
	boolean notSure() default false;
	
	/**
	 * 断言指定的成员变量的值是否在期望的值相等，相等时通过flag、priority判断是否保留params中相对应的属性</br>
	 * eg</br>
	 * @Option
	 * @Option(assertKeys = {
	 *		@AssertKey(ev = "a", priority = 1, params = {"aa"}),
	 *		@AssertKey(ev = "b", flag = false, params = {"bb"})
			})</br>
	 * private String key;
	 * 如果key=a那么保存成员变量aa的值到文件中，如果key=b那么将不保存bb属性值到配置文件中</br>
	 * 如果注解中不包含assertKey那么直接将key值写入到文件中</br>
	 * @default {}
	 * @return
	 */
	AssertKey[] assertKeys() default {};
	
}
