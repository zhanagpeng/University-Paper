package com.zp.basic.email.vo;

import com.zp.basic.notice.vo.FileVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**

 * @author  zp

 * @create  2022/1/23 18:59

 * @desc    查看信件VO

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckEmailVo {
    /**
     * 信件主题
     */
    private String emailTopic;
    /**
     * 信件内容
     */
    private String emailContent;
    /**
     * 附件
     */
    private List<FileVo> fileVos;
}
