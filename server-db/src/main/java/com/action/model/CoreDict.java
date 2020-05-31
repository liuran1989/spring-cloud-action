package com.action.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class CoreDict implements Serializable {
    /**
     * 
     * core_dict.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 
     * core_dict.VALUE
     *
     * @mbggenerated
     */
    private String value;

    /**
     * 名称
     * core_dict.NAME
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 字典编码
     * core_dict.TYPE
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 类型描述
     * core_dict.TYPE_NAME
     *
     * @mbggenerated
     */
    private String typeName;

    /**
     * 排序
     * core_dict.SORT
     *
     * @mbggenerated
     */
    @JsonIgnore
    private Integer sort;

    /**
     * 父id
     * core_dict.PARENT
     *
     * @mbggenerated
     */
    @JsonIgnore
    private Integer parent;

    /**
     * 删除标记
     * core_dict.DEL_FLAG
     *
     * @mbggenerated
     */
    @JsonIgnore
    private Integer delFlag;

    /**
     * 备注
     * core_dict.REMARK
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 创建时间
     * core_dict.CREATE_TIME
     *
     * @mbggenerated
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}