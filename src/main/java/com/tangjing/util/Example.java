package com.tangjing.util;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/14
 * Time:下午3:20
 */

public class Example {

    /**
     * redirect后传递参数
     * forward跳转后地址栏URL不会改变 而redirect会改变
     * 为了防止用户刷新重复提交，save操作之后一般会redirect到另一个页面，同时带点操作成功的提示信息。因为是Redirect，
     * Request里的attribute不会传递过去，如果放在session中，则需要在显示后及时清理，不然下面每一页都带着这个信息也不对。
     * Spring在3.1才提供了这个能力，原理是放到session中，session在跳到页面后马上移除对象。所以你刷新一下后这个值就会丢掉。
     */

    @RequestMapping("flash")
    public String flash(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("username", "Biao");
        return "redirect:flash2";
    }

    @RequestMapping("flash2")
    @ResponseBody
    public String flash2(@ModelAttribute("username") String username) {
        return "username: " + username;
    }

}
