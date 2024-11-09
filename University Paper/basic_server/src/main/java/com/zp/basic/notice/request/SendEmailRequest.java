package com.zp.basic.notice.request;

import com.zp.basic.notice.vo.FileVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author zp
 * @create 2022/1/22 2:56
 * @desc 发送信件请求类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailRequest {
    //发件人
    private String userId;
    //收件人
    @NotBlank(message = "receiveMan不能为空")
    private String receiveMan;
    //信件标题
    @NotBlank(message = "emailTopic不能为空")
    private String emailTopic;
    //信件正文
    private String emailContent;
    //信件附件
    private List<FileVo> fileVoList;
}
