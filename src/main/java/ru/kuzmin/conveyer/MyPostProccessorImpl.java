package ru.kuzmin.conveyer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Calendar;

@Component
public class MyPostProccessorImpl implements BeanPostProcessor {
    @Override
    //это происходит до инит-метода бина
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        return bean;
    }

    @Override
    //это происходит после инит-метода бина
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //если нет аннотации Loggable
        if (!bean.getClass().isAnnotationPresent(Loggable.class)) return bean;
        //если есть аннотация Loggable
        //создаем экземпляр "улучшателя" - построителя новых классов(!)
        Enhancer enhancer = new Enhancer();
        //говорим, что порождаемые классы будут потомками класса нашего текущего бина
        enhancer.setSuperclass(bean.getClass());
        //добавляем обработчик, который будет перехватывать вызовы методов
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            //собственно, логика перехвата вызова метода
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("interceptor!!!!");
                System.out.printf("\nLog: bean: %s, method: %s datetime: %s", beanName, method.getName(), Calendar.getInstance().getTime());
                return method.invoke(bean, args);
            }
        });
        //возвращаем экземпляр "улучшенного" бина, но он не знает, что передавать в конструктор
        //берм первый попавшийся конструктор
        Constructor cons= bean.getClass().getConstructors()[0];
        //новый массив формальных элементов  по количеству аргументов конструктора
        Object [] arr=new Object[cons.getParameterCount()];
        //возвращаем экземпляр "улучшенного" бина
        //так себе реализация
        return enhancer.create(cons.getParameterTypes(),arr);
    }
}
