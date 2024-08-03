package com.yunshare.core.validator.group;

import javax.validation.groups.Default;

/**
 * <p>分组较验</p>
 *
 * @author lzx@yunshare.com
 * @since 2021/9/9 上午11:21
 */
public interface ValidGroup extends Default {
    interface Crud extends ValidGroup {

        interface Create extends Crud{

        }

        interface Update extends Crud{

        }

        interface Query extends Crud{

        }

        interface Delete extends Crud{

        }
    }
}
