package com.belonk.jfinal.controller;

import com.belonk.jfinal.interceptor.TxInterceptor;
import com.belonk.jfinal.model.Hello;
import com.belonk.jfinal.service.HelloService;
import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;

/**
 * Created by sun on 2018/1/24.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class HelloController extends Controller {
    //~ Static fields/initializers =====================================================================================


    //~ Instance fields ================================================================================================


    //~ Constructors ===================================================================================================


    //~ Methods ========================================================================================================

    public void hello() {
        render("hello");
    }

    public void save() {
        HelloService helloService = Enhancer.enhance(HelloService.class, TxInterceptor.class);
        helloService.save(getModel(Hello.class));
    }
}
