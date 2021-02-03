package com.projet.DeuxMainsPourToi.Exception;

public class InputNotUniqueException extends Exception{

    private Object object;
    private Class<?> clazz;

    public InputNotUniqueException(Object object, Class<?> clazz) {
        super("Input already exist in DB" +
                "\n\t- class : " + clazz.getSimpleName() +
                "\n\t- input : " + object);
        this.object = object;
        this.clazz = clazz;
    }
}
