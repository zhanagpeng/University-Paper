package com.zp.basic.notice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2022/1/23 10:11

 * @desc    上传成功返回文件列表

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {
    private String name;
    private String url;
}
