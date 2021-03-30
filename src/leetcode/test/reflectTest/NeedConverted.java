package leetcode.test.reflectTest;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE})
public @interface NeedConverted {
    public String[] strField();
    public String[] listField();
}
