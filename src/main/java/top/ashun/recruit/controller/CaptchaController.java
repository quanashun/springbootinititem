package top.ashun.recruit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ashun.recruit.pojo.vo.R;
import top.ashun.recruit.util.captcha.ImageCaptchaUtil;

/**
 * @author 18483
 */
@RestController
@RequestMapping("/captcha")
@Api(tags = "验证码")
public class CaptchaController {
    @Autowired
    private ImageCaptchaUtil imageCaptchaUtil;

    @GetMapping("/getImageCaptcha")
    @ApiOperation("获取图像验证码")
    public R getImageCaptcha() {
        return imageCaptchaUtil.getCaptcha();
    }

    @GetMapping("/verifyImageCaptcha")
    @ApiOperation("验证图像验证码")
    public R verifyImageCaptcha(String captchaId,String captcha) {
        return R.success(imageCaptchaUtil.verifyCaptcha(captchaId,captcha));
    }
}
