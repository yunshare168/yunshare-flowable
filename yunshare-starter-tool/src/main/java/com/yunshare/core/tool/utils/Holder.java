

package com.yunshare.core.tool.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 一些常用的单利对象
 * @author : lzx@yuyuda.com
 * @since : 2022/3/30 14:28
 */
public class Holder {

    /**
     * RANDOM
     */
    public static final  Random RANDOM = new Random();

    /**
     * SECURE_RANDOM
     */
    public static final  SecureRandom SECURE_RANDOM = new SecureRandom();
}
